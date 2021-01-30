import java.util.Scanner;

/**
 * This class implements a shop simulation.
 *
 * @author Wei Tsang
 * @version CS2030S AY20/21 Semester 2
 */ 
class ShopSimulation extends Simulation {
  /** 
   * The availability of counters in the shop. 
   */

  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  
  /** 
   * Constructor for a shop simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */

  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    // return initEvents
    return new Event[] {};
  }

  //--------------------------------------------------------
  //

  private int noOfCustomers=0;
  private int noOfCounters=0;
  private double[][] timings;

  public ShopSimulation(Scanner sc){
    initialiseValues(sc);
  }

  private void initialiseValues(Scanner sc){
    noOfCustomers=(int) sc.nextDouble();
    noOfCounters=(int) sc.nextDouble();
    timings= new double [noOfCustomers] [2];  
  }

  private Counter[] createCounters(int noOfCounters){
    Counter[] counters = new Counter[noOfCounters];
    for (int i=0;i<noOfCounters;i++){
      counters[i] = new Counter();
    }
    return counters;
  }

  private Customer[] createCustomers(int noOfCustomers){
    Customer[] customers = new Customer[noOfCustomers];
    for(int i=0;i<noOfCustomers;i++){
      customers[i]=new Customer();
    }
    return customers;
  }
}
