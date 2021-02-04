class ArrivalEvent extends Event { 

  /**
  * This class implements a arrival event of the shop.
  *
  * @author Alex Teo (Lab16A)
  * @version CS2030S AY20/21 Semester 2
  */

  // ------ Data ---------------------------------
  private Customer c; 
  private Counter ctr;
  private Counter[] ctrs;
  private double time;
  private double serviceTime;

  // ----- Constructors --------------------------
  public ArrivalEvent(Customer c, Counter[] ctrs, double time, double serviceTime) { 
    //constructor
    super(time);
    this.time = time;
    this.c = c;
    this.serviceTime = serviceTime;
    this.ctrs = ctrs;
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
    int counterNo = availableCounters(ctrs);
    if (counterNo == -1) { 
      return depart();
    } else { 
      return serve();
    }
  }

  public Event[] serve() { 
    return new Event[] {new ServiceBeginEvent(this.c, this.ctr, this.time, this.serviceTime)};
  }

  public Event[] depart() { 
    return new Event[] {new DepartureEvent(this.c, this.time)};
  }

  private int availableCounters(Counter[] ctrs) { 
    // ----- default value of -1 -> no counters available
    int counterNo = -1;
    for (int i = 0; i < ctrs.length; i++) { // ----- Loop through to find available counter;
      if (ctrs[i].available()) {       // ----- Breaks if found available counter
        counterNo = i;
        this.ctr = ctrs[i];
        break;
      } else { /* not needed */ }
    }
    return counterNo;
  }
}
