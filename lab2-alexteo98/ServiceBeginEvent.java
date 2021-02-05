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
  private Shop shop;

  // ----- Construcctors -------------------
  public ServiceBeginEvent(Customer c, Shop shop) { 
    super(c.getTime());
    this.c = c;
    this.time = c.getTime();
    this.shop = shop;
  }

  // ----- Methods ------------------------
  public Event[] simulate() { 
    c.getCounter().occupyCounter(c);
    c = c.setTime(c.getTime() + c.getServiceTime());
    return new Event[] {new ServiceEndEvent(this.c, this.shop)};
  }
  
  @Override
  public String toString() { 
    return String.format("%s: %s service begin (by %s)", super.toString(), c, c.getCounter());
  }
}
