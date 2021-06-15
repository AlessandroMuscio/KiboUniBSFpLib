package it.unibs.fp.mylib.graphs.shortestpath;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.unibs.fp.mylib.graphs.*;

/**
 * La classe <strong>Dijkstra</strong> permette di eseguire l'algoritmo di
 * Dijkstra su di un grafo in modo da trovare il percorso più breve da un nodo
 * ad un altro
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class Dijkstra {
  /**
   * Il grafo di cui dobbiamo trovare il percorso minimo
   */
  private Graph<DefaultNode, ?> grafo_completo;
  /**
   * Una tabella che tiene traccia delle distanze dall'origine di ogni nodo
   */
  private Map<DefaultNode, FromDist> distanze_origine = new HashMap<>();
  /**
   * L'id del nodo di arrivo
   */
  private long id_arrival_node;

  /**
   * Crea un oggetto della classe <strong>Dijkstra</strong> specificandone il
   * grafo, l'id del nodo di partenza e l'id del nodo di arrivo
   * 
   * @param graph            Il <strong>grafo</strong> su cui trovare il percorso
   *                         minimo
   * @param id_starting_node L'id del <strong>nodo di partenza</strong>
   * @param id_arrival_node  L'id del <strong>nodo di arrivo</strong>
   */
  public Dijkstra(Graph<DefaultNode, ?> graph, int id_starting_node, int id_arrival_node) {
    grafo_completo = graph.copyGraph();
    this.id_arrival_node = id_arrival_node;

    FromDist from_dist;
    for (DefaultNode node : grafo_completo.getAllNodes()) {
      if (node.getId() != id_starting_node)
        from_dist = new FromDist();
      else
        from_dist = new FromDist(id_starting_node, 0);

      distanze_origine.put(node, from_dist);
    }
  }

  /**
   * Crea un oggetto della classe <strong>Dijkstra</strong> specificandone il
   * grafo. Se <strong>starting_node</strong> è <code>true</code>
   * <strong>node_id</strong> viene interpretato come l'id del nodo di partenza e
   * come nodo di arrivo viene preso quello con l'id più grande tra tutti. Se
   * <strong>starting_node</strong> è <code>false</code> <strong>node_id</strong>
   * viene interpretato come l'id del nodo di arrivo e come nodo di partenza viene
   * preso quello con l'id più piccolo tra tutti
   * 
   * @param graph         Il <strong>grafo</strong> su cui trovare il percorso
   *                      minimo
   * @param node_id       L'id di un nodo che può essere quello di partenza o
   *                      quello di arrivo
   * @param starting_node Indica se <code>node_id</code> è il nodo di partenza o
   *                      quello di arrivo
   */
  public Dijkstra(Graph<DefaultNode, ?> graph, int node_id, boolean starting_node) {
    grafo_completo = graph.copyGraph();

    FromDist from_dist;
    if (starting_node) {
      id_arrival_node = getHighestId();

      for (DefaultNode node : grafo_completo.getAllNodes()) {
        if (node.getId() != node_id)
          from_dist = new FromDist();
        else
          from_dist = new FromDist(node_id, 0);

        distanze_origine.put(node, from_dist);
      }
    } else {
      id_arrival_node = node_id;
      long id_starting_node = getLowestId();

      for (DefaultNode node : grafo_completo.getAllNodes()) {
        if (node.getId() != id_starting_node)
          from_dist = new FromDist();
        else
          from_dist = new FromDist(id_starting_node, 0);

        distanze_origine.put(node, from_dist);
      }
    }
  }

  /**
   * Crea un oggetto della classe <strong>Dijkstra</strong> specificandone il
   * grafo. Come nodo di partenza verrà preso quello con l'id più piccolo mentre
   * come nodo di arrivo quello con l'id più grande
   * 
   * @param graph Il <strong>grafo</strong> su cui trovare il percorso minimo
   */
  public Dijkstra(Graph<DefaultNode, ?> graph) {
    grafo_completo = graph.copyGraph();
    id_arrival_node = getHighestId();

    long id_starting_node = getLowestId();
    FromDist from_dist;
    for (DefaultNode node : grafo_completo.getAllNodes()) {
      if (node.getId() != id_starting_node)
        from_dist = new FromDist();
      else
        from_dist = new FromDist(id_starting_node, 0);

      distanze_origine.put(node, from_dist);
    }
  }

  /**
   * Restituisce il più grande <strong>id</strong> tra tutti quelli dei nodi di
   * <code>grafo_completo</code>
   * 
   * @return Un <code>int</code> rappresentante l'id
   */
  private long getHighestId() {
    long max = -1;

    for (DefaultNode node : grafo_completo.getAllNodes()) {
      if (node.getId() > max)
        max = node.getId();
    }

    return max;
  }

  /**
   * Restituisce il più piccolo <strong>id</strong> tra tutti quelli dei nodi di
   * <code>grafo_completo</code>
   * 
   * @return Un <code>int</code> rappresentante l'id
   */
  private long getLowestId() {
    long min = Integer.MAX_VALUE;

    for (DefaultNode node : grafo_completo.getAllNodes()) {
      if (node.getId() < min)
        min = node.getId();
    }

    return min;
  }

  public void setShortestPath() {
    Set<DefaultNode> Q = grafo_completo.getAllNodes();
    Set<DefaultNode> neighbours;
    DefaultNode T;

    while (!Q.isEmpty()) {
      T = getNodeClosestToOrigin(Q);

      neighbours = getNeighbours(T);
    }
  }

  private DefaultNode getNodeClosestToOrigin(Set<DefaultNode> Q) {
    boolean first_time = true;
    DefaultNode closest_one = null;

    for (DefaultNode node : Q) {
      if (!first_time) {
        if (distanze_origine.get(node).getDist() < distanze_origine.get(closest_one).getDist())
          closest_one = node;
      } else {
        closest_one = node;
        first_time = false;
      }
    }

    return closest_one;
  }

  private Set<DefaultNode> getNeighbours(DefaultNode T) {
    if (grafo_completo instanceof UndirectedGraph) {

    }
  }
}
