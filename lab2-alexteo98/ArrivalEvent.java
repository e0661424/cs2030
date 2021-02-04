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
  private Queue q;
  private Counter ctr;
  private Counter[] ctrs;
  private double time;
  private double serviceTime;

  // ----- Constructors --------------------------
  public ArrivalEvent(Customer c, Shop shop, Queue q) { 
    super(c.getTime());
    this.c = c;
    this.shop = shop;
    this.q = q;
  }

  // ----- Methods ------------------------------
  @Override
  public String toString() { 
    return super.toString() + String.format(": %s arrives", c);
  }

  public Event[] simulate() { 
    // ----- check counter availability
    // ----- if no Counters, call depart() 
    // ----- else call serve()
   
    // TODO
    // shop.get available counters
    // if counter.avail -> serve(cust)
    // else { 
    //  if (queue.full) { 
    //    depart();
    //  }else { 
    //    queue();
    //  }
    // }
  }

  public Event[] serve() { 
    return new Event[] {new ServiceBeginEvent(this.c, this.ctr, this.time, this.serviceTime)};
  }

  public Event[] depart() { 
    return new Event[] {new DepartureEvent(this.c, this.time)};
  }
}
