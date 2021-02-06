class Customer { 

  /**
   * This class implements a customer.
   *
   * @author Alex Teo (Lab16A)
   * @version CS2030S AY20/21 Semester 2
   */

  // ----- Data ---------------------------

  /** ID Value of Customer Object. */
  private int customerID = 0;

  /** Static value for incrementing ID of many Customer objects. */
  private static int lastCustomerID = 0;

  /** Counter object - only present is there is a counter currently serving customer. */
  private Counter currentCounter;

  /** Time of event start. */
  private double time;

  /** Time needed for serving particular Customer. */
  private double serviceTime;

  // ----- Constructors ------------------
  /** 
   * Constructor for Customer object.
   *
   * Default construtor of Customer object.
   * Sets customer ID to 1 above previous Customer object's value.
   * Sets time and serviceTime to 0 if not provided.
   * */
  public Customer() {
    this.customerID = lastCustomerID;
    lastCustomerID++;
    this.time = 0;
    this.serviceTime = 0;
  }

  /** Constructor for Customer object.
   *
   *  Overloaded constrctor to include time and serviceTime parameters.
   *  Calls default constructor of Customer.
   *  Sets time and serviceTime to values provided.
   *
   *  @param time Time of event.
   *  @param serviceTime Time needed for counter to serve this customer.
   */
  public Customer(double time, double serviceTime) { 
    this();
    this.time = time;
    this.serviceTime = serviceTime;
  }

  // ----- Getter and Setters ------------
  /**
   * Gets the ID of current Customer object.
   *
   * @return ID of current Customer object.
   */
  public int getCustomerID() { 
    return this.customerID;
  }

  /**
   * Sets a counter that is currently serving this Customer.
   *
   * @param c Counter that is currently serving this customer.
   */
  public void setCounter(Counter c) { 
    currentCounter = c;
  }

  /** 
   * Gets the current counter serving this customer.
   *
   * @return The counter serving this customer.
   * */
  public Counter getCounter() { 
    return this.currentCounter;
  }

  /**
   * Gets the time of the event that this customer is involved in.
   *
   * @return The time of event start.
   */
  public double getTime() { 
    return this.time;
  }

  /**
   * Sets the time of the event that this customer is involved in.
   *
   * @param updatedTime The updated time of event the customer is involved in.
   *
   * @return This customer object.
   */
  public Customer setTime(double updatedTime) { 
    this.time = updatedTime;
    return this;
  }

  /**
   * Gets the time required to serve this customer.
   *
   * @return serviceTime required to serve this customer.
   */
  public double getServiceTime() { 
    return this.serviceTime;
  }

  @Override
  public String toString() { 
    return String.format("C%d", this.customerID);
  }
}
