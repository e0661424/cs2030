//import java.util.Arrays;
class Counter{
  private boolean available=true;
  private static int lastCounterID=0;
  private int counterID=0;
  public Customer currentCustomer;

  public Counter(){
    //set counter id
    counterID=lastCounterID;
    lastCounterID++;
  }

  public int getCounterID(){
    return this.counterID;
  }

  public boolean available(){
    return this.available;
  }

  public void occupyCounter(Customer c){
    this.available=false;
    this.currentCustomer = c;
  }

  public void releaseCounter(){
    this.available=true;
    this.currentCustomer=null;
  }

  public String toString(Customer c){
    if (available) { return ("Currently serving:" + c.getCustomerID()); }
    else {return ("Currently empty");}
  }
}
