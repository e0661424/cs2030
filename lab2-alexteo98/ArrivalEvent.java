class ArrivalEvent extends Event { 

  /**
   * This class implements a arrival event of the shop.
   *
   * @author Alex Teo (Lab16A)
   * @version CS2030S AY20/21 Semester 2
   */

  // ------ Data ---------------------------------
  private Shop shop;
  private Customer c; 
  private double time;

  // ----- Constructors --------------------------
  public ArrivalEvent(Customer c, Shop shop) { 
    super(c.getTime());
    this.time = c.getTime();
    this.c = c;
    this.shop = shop;
  }

  // ----- Methods ------------------------------
  @Override
  public String toString() { 
    return String.format("%s: %s arrived %s", super.toString(), c, shop.getQueue());
  }

  public Event[] simulate() { 
    if (shop.counterAvailable()) { 
      return serve();
    } else {
      if (shop.getQueue().isFull()) { 
          return depart();
      } else  { 
          System.out.println(String.format("%s: %s joined queue %s",super.toString(), this.c, this.shop.getQueue()));
          shop.getQueue().enq(this.c);
          return new Event[] {};
      }
    }
  }

  private Event[] joinQ() { 
    return new Event[]{new WaitEvent(this.c, this.shop)};
  }
  public Event[] serve() { 
    c.setCounter(shop.getAvailableCounter());
    return new Event[] {new ServiceBeginEvent(this.c, this.shop)};
  }

  public Event[] depart() { 
    return new Event[] {new DepartureEvent(this.c, this.shop)};
  }
}
