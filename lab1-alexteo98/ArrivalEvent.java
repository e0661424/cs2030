class ArrivalEvent extends Event{

  private Customer c; 
  private Counter ctr;
  private Counter[] ctrs;
  private double time;
  private double serviceTime;

  public ArrivalEvent(Customer c,Counter[] ctrs,double time,double serviceTime){
    //constructor
    super(time);
    this.time=time;
    this.c=c;
    this.serviceTime=serviceTime;
    this.ctrs=ctrs;
  }

  @Override
  public String toString(){
    return String.format(": Customer %d arrives", c.getCustomerID());
  }

  public Event[] simulate(){
    //check counter availability
    //if counter >0 , call begin
    //else call depart
    int counterNo = availableCounters(ctrs);
    if (counterNo == -1 ){
      return depart();
    }
    else{
      return serve();
    }
  }

  public Event[] serve(){
    // instantiate service.begin
    // TODO
    return new Event[] {new ServiceBeginEvent(this.c,this.ctr,this.time,this.serviceTime)};
  }

  public Event[] depart(){
    // instantiate departure
    return new Event[] {new DepartureEvent(this.c,this.time)};
  }

  private int availableCounters(Counter[] ctrs){
    // default value of -1 - no counters available
    int counterNo=-1;
    for (int i=0;i<ctrs.length;i++){
     // System.out.println("Counter " + i + " - Available: " + ctrs[i].available());
      if (ctrs[i].available()){
        counterNo=i;
        this.ctr=ctrs[i];
      } else{/* not needed */}
    }
    return counterNo;
  }
}
