class ArrivalEvent extends Event{

  private Customer c; 
  public ArrivalEvent(Customer c,double time){
    //constructor
    super(time);
    this.c=c;
  }

  @Override
  public String toString(){
    return String.format(": Customer %d arrives", c.getCustomerID());
  }

  public void checkCounter(){
    //check counter availability
    //if counter >0 , call begin
    //else call depart
  }

  public void serve(){
    // instantiate service.begin
  }

  public void depart(){
    // instantiate departure
  }

  @Override
  public Event[] simulate(){
    // override abstract method
    return new Event[333];
  }
}
