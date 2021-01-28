class ServiceEndEvent extends Event{
  
  private Counter ctr;
  private Customer c;


  public ServiceEndEvent(Customer c,Counter ctr,double time){
    super(time);
    this.c=c;
    this.ctr=ctr;
    
  }
  
    
}
