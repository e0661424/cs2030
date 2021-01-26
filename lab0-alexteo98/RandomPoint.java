import java.util.Random;

class RandomPoint extends Point{

  // static double seed = 0;
  public static Random rng = new Random(1);

  public RandomPoint(double minX,double maxX,double minY,double maxY){
   
    super();

    double randomX = rng.nextDouble();
    double  x = (((maxX-minX)*randomX)+minX);
    
    double randomY = rng.nextDouble();
    double y = (((maxY-minY)*randomY)+minY);
  
    this.setX(x);
    this.setY(y);
  }

  public static void setSeed(long seed){
    rng.setSeed(seed);
  }


}
