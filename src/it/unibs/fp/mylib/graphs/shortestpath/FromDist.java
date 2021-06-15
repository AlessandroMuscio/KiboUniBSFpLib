package it.unibs.fp.mylib.graphs.shortestpath;

public class FromDist {
  private long from;
  private double dist;

  public FromDist(long from, double dist) {
    this.from = from;
    this.dist = dist;
  }

  public FromDist() {
    from = -1;
    dist = Double.POSITIVE_INFINITY;
  }

  public long getFrom() {
    return from;
  }

  public double getDist() {
    return dist;
  }

  public void setFrom(long from) {
    this.from = from;
  }

  public void setDist(double dist) {
    this.dist = dist;
  }
}
