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

  /** Empty Event to return. */
  private Event[] emptyEvent = new Event[] {};

  // ----- Constructors --------------------

  /**
   * Constructor for a Shop.
   *
   * Initialises the array of Customers and Counters by calling their relevent methods.
   *
   * @param noOfCustomers Number of Customers in the shop.
   * @param noOfCounters Number of Counters in the shop.
   * @param timings Array used to store arrival and service time of customers.
   */

  public Shop(int noOfCustomers, int noOfCounters, double[][] timings) { 
    this.allCounters = createCounters(noOfCounters);
    this.allCustomers = createCustomers(noOfCustomers, timings);
    this.noOfCustomers = noOfCustomers;
    this.noOfCounters = noOfCounters;
  }

  // ----- Getter and Setters ---------------------

  /**
   * Gets the queue object of the shop.
   *
   * @return The queue object of the shop.
   */
  public Queue getQueue() { 
    return this.q;
  }

  /**
   * Sets the queue object of the shop
   *
   * @param q Queue object to link to the shop.
   */
  public void setQueue(Queue q) { 
    this.q = q;
  }

  /**
   * Gets the array of Customers in the shop.
   *
   * @return The array containing all customer objects in the shop.
   */
  public Customer[] getCustomers() { 
    return this.allCustomers;
  }

  // ----- Methods -----------------------
  /**
   * Gets a counter object that is available
   *
   * @return A counter object belonging to this shop that is available,  null if none available.
   */
  public Counter getAvailableCounter() { 
    for (int i = 0; i < noOfCounters; i++) { 
      if (allCounters[i].available()) { 
        return allCounters[i];
      } else { /*not needed*/ }
    }
    return null;
  }

  public boolean isShopFull() { 
    if (this.q.isFull()) { 
      return false;
    } else { 
      return true;
    }
  }

  public Event[] customerLeft(Customer c, Counter ctr) { 
      
    Customer nextCustomer = (Customer) this.q.deq();
    Event[] nextEvent = ctr.nextCustomer();
    return new Event[] {nextEvent[0], new JoinQueueEvent(nextCustomer, ctr.getQueue())};
  }

  public Event[] addCustomer(Customer c) { 

    for (int i= 0;i<allCounters.length;i++) { 
      if (allCounters[i].available()) { 
        return new Event[] {new ServiceBeginEvent(c, allCounters[i])};
      } else { /** not needed. */ }
    }
    return new Event[] {new JoinQueueEvent(c, findQueueToQueue())};
    /**
      Counter c = findCounter();
      if (c.available()) { 
      return new Event[] {new ServiceBeginEvent(this.c, c)};
      } else { 
      c.getQueue().enq(this.c);
      return emptyEvent;
      }*/
  }

  private Queue findQueueToQueue() { 
    // all counters busy 
    Counter c = allCounters[0];
    for (int i=0;i<allCounters.length;i++) { 
        if (c.compareTo(allCounters[i]) == 1) { 
            c = allCounters[i];
        } else {}
    }

    if (c.isCounterFull()){
      return this.q;
    } else { 
        return c.getQueue();
    }
  }

/**
 * Checks if there are any available counters in the shop.
 *
 * @return True if there is an available counter for use, false otherwise.
 */
public boolean counterAvailable() { 
  Counter ctr = getAvailableCounter();
  if (ctr == null) { 
    return false;
  } else  { 
    return true;
  }
}

/**
 * Initialise an array of counters.
 *
 * @param noOfCounters Number of Counter objects to create.
 *
 * @return An array of counters belonging to the shop.
 */
private Counter[] createCounters(int noOfCounters) {
  Counter[] allCounters = new Counter[noOfCounters];
  for (int i = 0; i < noOfCounters; i++) { 
    allCounters[i] = new Counter(this);
  }
  return allCounters;
}

/**
 * Initialise an array of customers.
 *
 * @param noOfCustomers Number of Customer objects to create.
 * @param timings An containing the arrival and service time of each customer.
 *
 * @return An array of customers belonging to the shop.
 */
private Customer[] createCustomers(int noOfCustomers, double[][] timings) { 
  Customer[] allCustomers = new Customer[noOfCustomers];
  for (int i = 0; i < noOfCustomers; i++) { 
    allCustomers[i] = new Customer(timings[i][0], timings[i][1]);
  }
  return allCustomers;
}

/**
 * Dequeues and gets the next customer in queue.
 *
 * @return The next customer in line.
 */
public Customer nextCustomer() { 
  return (Customer) q.deq();
}

public Event[] customerDeparted(Counter ctr) { 
  if (ctr.getQueue().isEmpty()) { 
      return emptyEvent;
  } else {
    Event[] nextEvent = ctr.nextCustomer();
  Customer nextInCounter = (Customer) ctr.getQueue().deq();
  Customer nextInShop = (Customer) this.q.deq();
  ctr.getQueue().enq(nextInShop);
  return nextEvent;
  }
}
}
