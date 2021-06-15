package it.unibs.fp.mylib.graphs;

/**
 * La classe <strong>DefaultNode</strong> permette di creare un nodo generico da
 * inserire in un grafo
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class DefaultNode {
  /**
   * Tiene traccia del massimo id utilizzato fino ad ora
   */
  private static long id_counter = -1;
  /**
   * Rappresenta l'<strong>id</strong> del nodo
   */
  private long id;

  /**
   * Crea un oggetto della classe <strong>DefaultNode</strong> specificandone l'id
   * 
   * @param id Indica l'id del <em>DefaultNode</em>
   * @throws GraphsException Quando l'id è minore di 0
   */
  public DefaultNode(long id) throws GraphsException {
    if (id < 0)
      throw new GraphsException("L'id del nodo deve essere maggiore uguale di 0");

    id_counter = id;
    this.id = id;
  }

  /**
   * Crea un oggetto della classe <strong>DefaultNode</strong> assegnando
   * automaticamente l'id in maniera dinamica
   */
  public DefaultNode() {
    id_counter++;
    id = id_counter;
  }

  /**
   * Restituisce l'<strong>id</strong> di questo <em>DefaultNode</em>
   * 
   * @return Un <code>long</code> rappresentante l'<strong>id</strong>
   */
  public long getId() {
    return id;
  }

  /**
   * Imposta l'<strong>id</strong> di questo <em>DefaultNode</em>
   * 
   * @param id Valore da assegnare all'<strong>id</strong>
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Verifica se <strong>questo DefaultNode</strong> e <strong>obj</strong> sono
   * uguali
   * 
   * @param obj Indica l'oggetto da confrontare con <strong>questo
   *            DefaultNode</strong>
   * @return Un <code>boolean</code> che rappresenta se i due oggetti sono uguali
   *         o no
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DefaultNode) {
      DefaultNode node_obj = (DefaultNode) obj;

      if (id == node_obj.id)
        return true;
    }

    return false;
  }

  /**
   * Restituisce una rappresentazione in forma leggibile di un oggetto
   * <strong>DefaultNode</strong>
   * 
   * @return Una <code>String</code> che rappresenta un
   *         <strong>DefaultNode</strong>
   */
  @Override
  public String toString() {
    return String.format("Node: {Id: %d}", id);
  }
}
