/**
 * CS2030S Lab 0: Circle.java
 * Semester 2, 2020/21
 *
 * The Circle class represents a circle with a center 
 * and a radius.
 *
 * @author Alex Teo 
 */
class Circle {
  /** The center of the circle. */
  private Point c;

  /** The radius of the circle (assume positive). */
  private double r;

  /**
   * Constructor for a circle.  Takes in a center c and a 
   * radius r (assume to be positive). 
   *
   * @param c The center of the new circle.
   * @param r The radius of the new circle.
   */
  public Circle(Point c, double r) {
    this.c = c;
    this.r = r;
  }

  /**
   * Checks if a given point p is contained within the circle.
   *
   * @param p The point to test.
   * @return true if p is within this circle; false otherwise.
   */
  public boolean contains(Point p) {
    boolean result = false;
    
    // result = (Math.pow(r,2) == Math.pow((c.getX()-p.getX()),2) + Math.pow((c.getY()-p.getY()),2));

    return (Math.pow(r,2) >= Math.pow((c.getX()-p.getX()),2) + Math.pow((c.getY()-p.getY()),2));
  }

  /**
   * Return the string representation of this circle.
   *
   * @return The string representing of this circle.
   */
  public String toString() {
    return "{ center: " + this.c + ", radius: " + this.r + " }";
  }
}
