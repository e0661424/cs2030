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
  private double time;
  private Shop shop;


  // ----- Constructors ---------------------
  public ServiceEndEvent(Customer c, Shop shop) { 
    super(c.getTime());
    this.c = c;
    this.time = c.getTime();
    this.shop = shop;
  }

  // ----- Methods ------------------------
  public Event[] simulate() { 
    c.getCounter().releaseCounter();
    return new Event[] { new DepartureEvent(this.c, this.shop)};
  }

  @Override
  public String toString() { 
    return String.format("%s: %s service done (by %s)", 
        super.toString(), c, c.getCounter()); 
  }
}
