class Counter { 

  /**
  * This class implements a Counter.
  *
  * @author Alex Teo (Lab16A)
  * @version CS2030S AY20/21 Semester 2
  */

  // ----- Data -------------------------------------
  /** Availability of counter. */
  private boolean available = true;

  /** Next ID for next instance of Counter object, can be used to get total number of counters. */
  private static int lastCounterID = 0;

  /** Counter ID for this instance of Counter object. */
  private int counterID = 0;

  /** Customer object for current Customer served by this counter, null is not occupied. */
  private Customer currentCustomer;


  // ----- Constructors -----------------------------
  /**
   * Constructor for Counter.
   * 
   * initialise counter ID for current Counter object.
   * Sets up counter ID for next instantiation of Counter object.
   */
  public Counter() { 
    counterID = lastCounterID;
    lastCounterID++;
  }

  // ----- Getters and Setters ----------------------

  /**
   *  Gets the specific counter ID of counter object.
   *
   *  @return the counter ID of counter object.
   */
  public int getCounterID() { 
    return this.counterID;
  }

  /**
   * Checks if counter ia available for use.
   *
   * @return True if counter is not occupied, false otherwise.
   */
  public boolean available() { 
    return this.available;
  }

  /**
   * Gets the Customer object currently using the counter.
   *
   * @return Customer object currently using the counter, null if counter is not occupied.
   */
  public Customer getCustomer() { 
    return this.currentCustomer;
  }

  // ----- Methods -----------------------------------

  /**
   * Sets counter to occupied.
   * Links a counter to a customer.
   *
   * @param c The customer that will be occupying the counter.
   */
  public void occupyCounter(Customer c) { 
    this.available = false;
    this.currentCustomer = c;
  }

  /**
   * Sets counter to available after customer's service ends.
   * Removes the counter - customer link.
   *
   */
  public void releaseCounter() { 
    this.available = true;
    this.currentCustomer = null;
  }

  @Override
  public String toString() { 
      return String.format("S%d",this.counterID);
  }
}
