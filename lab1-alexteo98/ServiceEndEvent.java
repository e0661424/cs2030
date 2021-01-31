class ServiceEndEvent extends Event{
 
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
  public ServiceEndEvent(Customer c,Counter ctr,double time){
    super(time);
    this.c=c;
    this.ctr=ctr;
  }

  // ----- Methods ------------------------
  public Event[] simulate(){
    ctr.releaseCounter();
    double time=super.getTime();
    return new Event[] {new DepartureEvent(c,time)};

  }
  
  @Override
  public String toString(){
    return super.toString() + String.format(": Customer %d service done (by Counter %d)", c.getCustomerID(), ctr.getCounterID());
  }
}
