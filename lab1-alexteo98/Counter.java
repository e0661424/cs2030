class Counter { 

  /**
  * This class implements a Counter.
  *
  * @author Alex Teo (Lab16A)
  * @version CS2030S AY20/21 Semester 2
  */

  // ----- Data -------------------------------------
  private boolean available = true;
  private static int lastCounterID = 0;
  private int counterID = 0;
  private Customer currentCustomer;


  // ----- Constructors -----------------------------
  public Counter() { 
    //set counter id
    counterID = lastCounterID;
    lastCounterID++;
  }

  // ----- Getters and Setters ----------------------

  public int getCounterID() { 
    return this.counterID;
  }

  public boolean available() { 
    return this.available;
  }

  public Customer getCustomer() { 
    return this.currentCustomer;
  }

  // ----- Methods -----------------------------------

  public void occupyCounter(Customer c) { 
    this.available = false;
    this.currentCustomer = c;
  }

  public void releaseCounter() { 
    this.available = true;
    this.currentCustomer = null;
  }

  /*
  public String toString(Customer c) { 
    if (available) { 
      return ("Currently serving:" + c.getCustomerID());
    } else { 
      return ("Currently empty");
    }
  }
  */

  @Override
  public String toString() { 
      return String.format("S%d",this.counterID);
  }
}
