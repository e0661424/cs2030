import java.util.Scanner;

/**
 * This class implements a shop simulation.
 *
 * @author Alex Teo (Lab16A)
 * @version CS2030S AY20/21 Semester 2
 */ 
class ShopSimulation extends Simulation {
    
  // ----- Data ----------------------------------
  
  /** 
   * The list of customer arrival events to populate
   * the simulation with.
   */
  public Event[] initEvents;
 
  private Shop shop;
  private Queue q;
  private int queueLen;
  private int noOfCustomers = 0;
  private int noOfCounters = 0;
  private double[][] timings;

  // ----- Constructors -------------------------
  /** 
   * Constructor for a shop simulation. 
   *
   * @param sc A scanner to read the parameters from.  The first
   *           integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a 
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
    
  public ShopSimulation(Scanner sc) { 
    
    this.noOfCustomers = sc.nextInt();
    this.noOfCounters = sc.nextInt();
    this.queueLen=sc.nextInt();

    initEvents = new Event[noOfCustomers];
    
    createTimings(sc);
    q = new Queue(queueLen);
    shop = new Shop(noOfCustomers, noOfCounters, timings);
  }

  // ----- Methods ----------------------------
  
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

  public double[][] createTimings(Scanner sc) { 
      timings[][] = new double[noOfCustomers][2];
      for (int i = 0; i < noOfCustomers; i++) { 
          timings[i][0] = sc.nextDouble();
          timings[i][1] = sc.nextDouble();
      }
  }
    
  public void startSimulation() {  
      initEvents[i] = new ArrivalEvent(c, shop, q);
    }
  }
}
