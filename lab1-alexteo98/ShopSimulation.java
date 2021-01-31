import java.util.Scanner;

/**
 * This class implements a shop simulation.
 *
 * @author Alex Teo (Lab16A)
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
  public Event[] initEvents;
  /**
   * Retrieve an array of events to populate the 
   * simulator with.
   *
   * @return An array of events for the simulator.
   */
  @Override
  public Event[] getInitialEvents() {
    return initEvents;
  }

  // ----- Data ----------------------------------

  private int noOfCustomers=0;
  private int noOfCounters=0;
  private double[][] timings;
  private Customer[] customers;
  private Counter[] counters;

  // ----- Constructors -------------------------
  public ShopSimulation(Scanner sc){
    
    this.noOfCustomers=sc.nextInt();
    this.noOfCounters=sc.nextInt();
    
    initialiseValues(sc);
    startSimulation();
  }

  // ----- Methods ----------------------------
  private void initialiseValues(Scanner sc){
   
    initEvents=new Event[noOfCustomers];
    this.counters =  createCounters(noOfCounters);
    this.customers = createCustomers(noOfCustomers);
    timings = createTimings(noOfCustomers,sc);
   }

  public void startSimulation(){
   
    for (int i=0;i<noOfCustomers;i++){
     double arrivalTime = timings[i][0];
     double serviceTime = timings[i][1];
     Customer c = customers[i];
     initEvents[i] = new ArrivalEvent(c,counters,timings[i][0],timings[i][1]);
    }
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

  private double[][] createTimings(int noOfCustomers,Scanner sc){
    
    double[][] timings = new double [noOfCustomers] [2];
    for (int i=0;i<noOfCustomers;i++){
      timings[i][0] = sc.nextDouble();
      timings[i][1] = sc.nextDouble();
    }
    return timings;
  }
}
