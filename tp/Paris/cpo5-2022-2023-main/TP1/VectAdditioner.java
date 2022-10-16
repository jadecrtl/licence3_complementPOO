package TP1;

public class VectAdditioner {
  private Point sum = new Point();

  public void add(Point p) {
    this.sum.x += p.x; this.sum.y += p.y;
  }

  public Point getSum() {
    //return this.sum; Au lieu de retourner le Point qui appartient à la classe, faire une copie.
    return new Point(this.sum.x, this.sum.y);
  }

  public class Point {
    public int x;
    public int y;

    public Point() {}
    public Point(int x, int y) {
      this.x = x; this.y = y;
    }
  }

  @Override
  public String toString() {
    return "Point x:"+this.sum.x+" y:"+this.sum.y;
  } 
}
