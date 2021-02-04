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
  public ServiceBeginEvent(Customer c) { 
    super(c.getTime());
    this.c = c;
  }

  // ----- Methods ------------------------
  public Event[] simulate() { 
    // occupy counter
    c = c.setTime(c.getTime() + c.getServiceTime());
    return new Event[] {new ServiceEndEvent(c)};
  }
  
  @Override
  public String toString() { 
    return super.toString() + String.format(": %s service begin (by %s)", 
        c, ctr);
  }
}
