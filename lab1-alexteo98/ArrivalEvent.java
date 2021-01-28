class ArrivalEvent extends Event{

  public ArrivalEvent{
    //constructor
  }

  @Override
  public String toString(){
    return String.format(": Customer %d arrives", this.customerId);
  }

  public void checkCounter(){
    //check counter number
    //if counter >0 , call begin
    //else call depart
  }

  public void serve(){
    // instantiate service.begin
  }

  public void depart(){
    // instantiate departure
  }

}
