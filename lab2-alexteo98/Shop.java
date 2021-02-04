class Shop { 
  // ----- Data --------------------------  
  private int noOfCustomers;
  private int noOfCounters;
  private allCounters[];
  private allCustomers[];

  // ----- Constructor --------------------
  public Shop(int noOfCustomers, int noOfCounters, double[][] timings) { 
    // initialise Customer and counter arrays
    this.allCounters = createCounters(noOfCounters);
    this.allCustomres = createCustomers(noOfCustomers, timings);
    this.noOfCustomers = noOfCustomers;
    this.noOfCounters = noOfCounters;
  }

  // ----- Methods -----------------------
  public Counter getAvailableCounter() { 
    // returns an available counter, if none available, return null value 
    for (int i = 0; i < noOfCounters; i++) { 
      if (allCounters[i].available) { 
          return allCounter[i];
      } else {  }
    }
    return null;
  }

  private Counter[] createCounters(int noOfCounters) { 
    Counter[] allCounters = new Counter[noOfCounters];
    for (int i = 0; i < noOfCounters; i++) { 
      allCounters[i] = new Counter();
    }
    return allCounters;
  }

  private Customers[] createCustomers(int noOfCustomers, double[][] timings) { 
    Customer[] allCustomers = new Customers[noOfCustomers];
    for (int i = 0; i < noOfCustomers; i++) { 
      allCustomers[i] = new Customers(timings[i][0], timings[i][1]);
    }
    return allCustomers;
  }
}
