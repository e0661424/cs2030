class Customer { 

  /**
   * This class implements a customer.
   *
   * @author Alex Teo (Lab16A)
   * @version CS2030S AY20/21 Semester 2
   */

  // ----- Data ---------------------------
  private int customerID = 0;
  private static int lastCustomerID = 0;
  private Counter currentCounter;
  private double time;
  private double serviceTime;

  // ----- Constructors ------------------
  public Customer() {
    this.customerID = lastCustomerID;
    lastCustomerID++;
    this.time = 0;
    this.serviceTime = 0;
  }
  public Customer(double time, double serviceTime) { 
    this();
    this.time=time;
    this.serviceTime=serviceTime;
   // System.out.println(String.format("ID:%d, time:%f, serviceTime:%f",this.customerID, this.time, this.serviceTime));
  }

  // ----- Getter and Setters ------------
  public int getCustomerID() { 
    return this.customerID;
  }
  public void setCounter(Counter c) { 
    currentCounter = c;
  }
  public Counter getCounter() { 
      return this.currentCounter;
  }
  public double getTime() { 
      return this.time;
  }
  public Customer setTime(double updatedTime) { 
      this.time=updatedTime;
      return this;
  }
  public double getServiceTime() { 
      return this.serviceTime;
  }

  @Override
  public String toString() { 
    return String.format("C%d",this.customerID);
  }
}
