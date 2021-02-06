class Shop { 
  // ----- Data --------------------------  
  
  /** number of customers in shop */
  private int noOfCustomers;

  /** number of counters in shop */
  private int noOfCounters;

  /** an array to store all counter objects */
  private Counter[] allCounters;

  /** an array to store all customer objects */
  private Customer[] allCustomers;

  /** Queue object belonging to specific shop */
  private Queue q;

  // ----- Constructors --------------------
  public Shop(int noOfCustomers, int noOfCounters, double[][] timings) { 
    // initialise Customer and counter arrays
    this.allCounters = createCounters(noOfCounters);
    this.allCustomers = createCustomers(noOfCustomers, timings);
    this.noOfCustomers = noOfCustomers;
    this.noOfCounters = noOfCounters;
  }

  // ----- Getter and Setters ---------------------
  
  public Queue getQueue() { 
      return this.q;
  }
  public void setQueue(Queue q) { 
      this.q = q;
  }
  public Customer[] getCustomers() { 
      return this.allCustomers;
  }

  // ----- Methods -----------------------
  public Counter getAvailableCounter() { 
    // returns an available counter, if none available, return null value 
    for (int i = 0; i < noOfCounters; i++) { 
      if (allCounters[i].available()) { 
          return allCounters[i];
      } else {/*not needed*/}
    }
    return null;
  }

  public boolean counterAvailable() { 
      Counter ctr = getAvailableCounter();
      if (ctr == null) { 
          return false;
      } else  { 
          return true;
      }
  }

  private Counter[] createCounters(int noOfCounters) {
    //  creates and returns an array of counters
    //  @param noOfCounters =  number of counter objects to return in counter array
    Counter[] allCounters = new Counter[noOfCounters];
    for (int i = 0; i < noOfCounters; i++) { 
      allCounters[i] = new Counter();
    }
    return allCounters;
  }

  private Customer[] createCustomers(int noOfCustomers, double[][] timings) { 
    // Creates and returns an array of customers
    // @param noOfCustomers = number of customer objects to return in customer array
    Customer[] allCustomers = new Customer[noOfCustomers];
    for (int i = 0; i < noOfCustomers; i++) { 
      allCustomers[i] = new Customer(timings[i][0], timings[i][1]);
    }
    return allCustomers;
  }
}
