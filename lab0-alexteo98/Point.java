/**
 * CS2030S Lab 0: Point.java
 * Semester 2, 2020/21
 *
 * The Point class encapsulates a point on a 2D plane.
 *
 * @author Alex Teo
 */
class Point {
  
  private double x = 0;
  private double y = 0;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double getX(){
    return this.x;
  }

  public double getY(){
    return this.y;
  }
  
  public Point setX(double x){
    this.x = x;
    return this;
  }

  public Point setY(double y){
    this.y = y;
    return this;
  }
  
  public double getDistance(Point p){
    return Math.sqrt(Math.pow(p.getX()-this.x,2)+Math.pow(p.getY()-this.y,2));
  }
}
