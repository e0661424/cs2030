import java.util.Scanner;

/**
 * CS2030S Lab 0: Estimating Pi with Monte Carlo
 * Semester 2, 2020/21
 *
 * This program takes in two command line arguments: the 
 * number of points and a random seed.  It runs the
 * Monte Carlo simulation with the given argument and print
 * out the estimated pi value.
 *
 * @author Alex Teo (Lab B16A) 
 */

class Lab0 {

  static double estimatePi(long numOfPoints, int seed) {
  
    long pointsInside=0;

    // setting seed
    RandomPoint.setSeed(seed);
  
    Point p1 = new Point (0.5,0.5);
    Circle c = new Circle(p1,0.5);

    for (int i=0;i<numOfPoints;i++){
      Point p = new RandomPoint(0,1,0,1);

      if(c.contains(p)){
        pointsInside++;
      }
    }
    double pi=(double)pointsInside/numOfPoints*4;
    return pi;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfPoints = sc.nextInt();
    int seed = sc.nextInt();

    double pi = estimatePi(numOfPoints, seed);

    System.out.println(pi);
    sc.close();
  }
}
