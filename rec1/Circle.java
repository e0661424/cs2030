class Circle {

  private Point centre;
  private double radius;
  
  Circle(Point centre) {
    this.centre = centre;
    this.radius = 1.0;
  }

  Circle(Point centre, double radius) {
    this.centre = centre;
    this.radius = radius;
  }

  boolean contains(Point point) {
    return centre.distance(point) <= radius;
  }

  @Override
  public String toString() {
    return "Circle centred at " + this.centre +
      " with radius " + this.radius;
  }

  public int findCoverage(Point[] p){
    int count=0;
    for (int i=0;i<p.length;i++){
      if(contains(p[i])){
        //add one to counter
        count++;
      }
    }
    return count;
  }
}
