package it.unibs.fp.mylib.graphs;

/**
 * La classe <strong>GraphsException</strong> permette di creare eccezioni per
 * tutto quello che riguarda i grafi
 * 
 * @author Alessandro Muscio
 * @version 1.0
 */
public class GraphsException extends Exception {
  /**
   * Il messaggio d'errore dell'eccezione
   */
  String message;

  /**
   * Crea un oggetto della classe <strong>GraphsException</strong> specificandone
   * il messaggio d'errore
   * 
   * @param message Indica il messaggio di <em>GraphsException</em>
   */
  public GraphsException(String message) {
    this.message = message;
  }

  /**
   * Stampa a video il messaggio d'errore e lo stack trace dell'eccezione
   */
  public void printMessage() {
    System.out.println(message);
    this.printStackTrace();
  }
}
