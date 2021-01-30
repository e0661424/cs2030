class ServiceBeginEvent extends Event{

  private Customer c;
  private Counter ctr;
  private double time;
  private double serviceTime;

  public ServiceBeginEvent(Customer c, Counter ctr, double time,double serviceTime){
    super(time);
    this.serviceTime=serviceTime;
    this.c=c;
    this.ctr=ctr;
    this.time=time;
    ctr.occupyCounter(c);

  }

  public Event[] simulate(){
    double endTime = this.time + this.serviceTime;
    return new Event[] {new ServiceEndEvent(c,ctr,endTime)};
  }
  
  @Override
  public String toString(){
    return String.format(": Customer %d service begin (by Counter %d)", c.getCustomerID(), ctr.getCounterID());
  }
}
