class ServiceEndEvent extends Event { 
 
  /**
  * This class implements a service end event of the shop.
  *
  * @author Alex Teo (Lab16A)
  * @version CS2030S AY20/21 Semester 2
  */ 

  // ----- Data ---------------------------
  private Counter ctr;
  private Customer c;


  // ----- Constructors ---------------------
  public ServiceEndEvent(Customer c) { 
    super(c.getTime());
    this.c = c;
  }

  // ----- Methods ------------------------
  public Event[] simulate() { 
    // release counter
    return new Event[] { new DepartureEvent(c)};
  }
  
  @Override
  public String toString() { 
    return String.format("%f : %s service done (by %s)", 
        super.getTime(), c, c.getCounter()); 
    // create getcounter method in customer class to retreive currrent counter - done
  }
}
