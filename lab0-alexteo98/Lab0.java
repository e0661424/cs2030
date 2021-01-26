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

  public double  estimatePi(long numOfPoints, int seed) {
  
  int pointsInside=0;

  RandomPoint.setSeed(seed);

  return pointsInside/numOfPoints;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfPoints = sc.nextInt();
    int seed = sc.nextInt();

    // double pi = estimatePi(numOfPoints, seed);

    // System.out.println(pi);
    sc.close();
  }
}
