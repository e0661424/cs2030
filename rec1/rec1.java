class rec1{
  
  public static void main(String[] args) {
    
    Point[] points = new Point[]{new Point(0,0), new Point(0,-1), new Point(1,0), new Point(0,1), new Point(-1,0)};
    findCoverage(points);
    System.out.println("end");
  }

  public static int findCoverage(Point[] p){
    int count=0;
    for (int i=0;i<p.length;i++){
      Circle c=new Circle (p[i],1.0);
      for (int j=0;j<p.length;j++){
        if(c.contains(p[j])){
          count++;
        }
      }
      System.out.println(count + "Points inside the circle");
      count=0;
    }
    return count;
  }

}
