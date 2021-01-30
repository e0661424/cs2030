class DepartureEvent extends Event{
  private Customer c;
  // private Counter ctr;

  public DepartureEvent(Customer c,double time){
    super(time);
    this.c=c;
  }

  @Override
  public String toString(){
    return String.format(": Customer %d departed",c.getCustomerID());
  }

  
  public Event[] simulate(){
     return new Event[] {};
    
  }
}
