class ArrivalEvent extends Event{

  private Customer c; 
  private Counter ctr;
  private double time;

  public ArrivalEvent(Customer c,double time){
    //constructor
    super(time);
    this.time=time;
    this.c=c;
  }

  @Override
  public String toString(){
    return String.format(": Customer %d arrives", c.getCustomerID());
  }

  public Event[] simulate(){
    //check counter availability
    //if counter >0 , call begin
    //else call depart
    boolean available=true;
    if (available){
      return serve();
    }
    else{
      return depart();
    }
  }

  public Event[] serve(){
    // instantiate service.begi
    double serviceTime=0;
    // TODO
    return new Event[] {new ServiceBeginEvent(this.c,this.ctr,this.time,serviceTime)};
  }

  public Event[] depart(){
    // instantiate departure
    return new Event[] {new DepartureEvent(this.c,this.time)};
  }
}
