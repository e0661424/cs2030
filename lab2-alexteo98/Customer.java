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
  private int currentCounter = 0;
  private double time;
  private double serviceTime;

  // ----- Constructors ------------------
  public Customer() {
    this.customerID = lastCustomerID;
    lastCustomerID++;
  }
  public Customer(double time, double serviceTime) { 
      this.time=time;
      this.serviceTime=serviceTime;
  }

  // ----- Getter and Setters ------------
  public int getCustomerID() { 
    return this.customerID;
  }

  public void setCounter(int n) { 
    currentCounter = n;
  }

  @Override
  public String toString() { 
      return String.format("C%d",this.customerID);
  }
}
