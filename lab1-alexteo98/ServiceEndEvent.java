class ServiceEndEvent extends Event{
  
  private Counter ctr;
  private Customer c;


  public ServiceEndEvent(Customer c,Counter ctr,double time){
    super(time);
    this.c=c;
    this.ctr=ctr;
    
  }
  
  @Override
  public String toString(){
    return ("Service Ended for Customer: " + c.getCustomerID() + " at Counter: " + ctr.getCounterID()) ;
  }
}
