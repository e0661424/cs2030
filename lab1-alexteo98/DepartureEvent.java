class DepartureEvent extends Event{
  private Customer c;
  private Counter ctr;

  public DepartureEvent(Customer C,Counter Ctr,double time){
    super(time);
    this.c=C;
    this.ctr=Ctr;
  }

  @Override
  public String toString(){
    return String.format(": Customer %d departed",c.getCustomerID());
  }

}
