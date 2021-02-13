class ServiceEndEvent extends Event { 

  /**
   * This class implements a service end event of the shop.
   *
   * @author Alex Teo (Lab16A)
   * @version CS2030S AY20/21 Semester 2
   */ 

  // ----- Data ---------------------------
  /** Customer who just ended service. */
  private Customer c;

  /** Shop at which service end event is happening. */
  private Counter ctr;

  // ----- Constructors ---------------------
  /**
   * Constructor for Service End Event.
   *
   * @param c Customer that just ended service.
   * @param shop Shop that Service End event is happening.
   */
  public ServiceEndEvent(Customer c, Counter ctr) { 
    super(c.getTime());
    this.c = c;
    this.ctr = ctr;
  }

  // ----- Methods ------------------------
  public Event[] simulate() { 
    c.getCounter().releaseCounter();
    return new Event[] { new DepartureEvent(this.c, this.ctr.getShop())};
  }

  @Override
  public String toString() { 
    return String.format("%s: %s service done (by %s)", 
        super.toString(), c, this.ctr); 
  }
}
