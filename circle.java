class Point{
  // requires public property to be inherited by circle sub-class
  public double x;
  public double y;
 
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

  public Point setX(double x){
    this.x=x;
    return this;
  }

  public Point setY(double y){
    this.y=y;
    return this;
  }
  
  public double getDistance(Point p){
    double dist;
    double xdist;
    double ydist;

    xdist=p.getX()-this.x;
    ydist=p.getY()-this.y;
    dist=Math.sqrt(Math.pow(xdist,2)+Math.pow(ydist,2));

    return dist;
  }
  
  public void display(){
    // Plots out the point on a 2D plane
 
    int length=20; 
    int midpt=(int)Math.floor(length/2);

    for (int i =0;i<length;i++){
      if (i==midpt){
        for(int j=0;j<length;j++){
          if(j==midpt){
            System.out.print("-|");  
          }else{
            System.out.print("--");
          }
        }
      }else{
         for(int j=0;j<length;j++){
          if(j==midpt){
            System.out.print("*|");  
          }else{
            System.out.print("**");
          }
        }
      }
      System.out.print("\n");
    }
 }

  //////////////////////////////////////
}

class Circle extends Point{
  // private double x = 0;
  // private double y = 0;
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
    this.x = i.getX();
    this.y = i.getY();
    this.id = last_id;
    last_id ++;
  }
  //////////////////////////////////////

  // Methods
  public double getArea(){
    return r*r*PI;
  }
}
  //public double getX(){
  //  return this.x;
  //}
  //public double getY(){
  //  return this.y;
  //}
  //////////////////////////////////////


