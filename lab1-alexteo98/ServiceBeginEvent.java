class ServiceBeginEvent extends Event { 

  /**
  * This class implements a service begin event of the shop.
  *
  * @author Alex Teo (Lab16A)
  * @version CS2030S AY20/21 Semester 2
  */

  // ----- Data --------------------------
  private Customer c;
  private Counter ctr;
  private double time;
  private double serviceTime;

  // ----- Construcctors -------------------
  public ServiceBeginEvent(Customer c, Counter ctr, double time, double serviceTime) { 
    super(time);
    this.serviceTime = serviceTime;
    this.c = c;
    this.ctr = ctr;
    this.time = time;
  }

  // ----- Methods ------------------------
  public Event[] simulate() { 
    ctr.occupyCounter(c);
    double endTime = this.time + this.serviceTime;
    return new Event[] {new ServiceEndEvent(c, ctr, endTime)};
  }
  
  @Override
  public String toString() { 
    return super.toString() + String.format(": Customer %d service begin (by Counter %d)", 
        c.getCustomerID(), ctr.getCounterID());
  }
}
