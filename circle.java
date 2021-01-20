public class Circle{
  private double x = 0;
  private double y = 0;
  private double r = 0;
  public int id = 0;
  private final double PI=3.14159265358979;
  
  static int last_id=0;

  // ---------------Constructors--------
  public Circle(){
    this.r = 0;
    this.x = 0;
    this.y = 0;
    this.id = last_id;
    last_id ++;
  }
  public Circle(double x,double y,double r){
    this.r = r;
    this.x = x;
    this.y = y;
    this.id = last_id;
    last_id ++;
  }
  public Circle(Point i,double r){
    this.r = r;
    this.x = i.getx();
    this.y = i.gety();
    this.id = last_id;
    last_id ++;
  }
  //////////////////////////////////////


  // Methods
  public double getArea(){
    return r*r*PI;
  } 
  public double getX(){
    return this.x;
  }
  public double getY(){
    return this.y;
  }
  //////////////////////////////////////

}

public class Point{
  private double x;
  private double y;
 
  // ----------Constructors-----------
  public Point(){
  // null point
  }

  public Point(double x,double y){
    this.x=x;
    this.y=y;
  }
  ////////////////////////////////////


  // ------------Methods--------------
  public double getX(){
    return this.x;
  }

  public double getY(){
    return this.y;
  }

  public Point setx(double x){
      this.x=x;
      return this;
  }

  public Point sety(double y){
      this.y=y;
      return this;
  }

  //////////////////////////////////////
}
