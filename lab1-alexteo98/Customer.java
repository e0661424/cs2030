class Customer{
  
  private int customerID=0;
  private static int lastCustomerID=0;
  private int currentCounter=0;
  private double serviceTime = 0;

  public Customer(){
    this.customerID=lastCustomerID;
    lastCustomerID++;
  }

  public int getCustomerID(){
    return this.customerID;
  }

  public void setCounter(int n){
    currentCounter=n;
  }
  public void setTime(double Time){
    this.serviceTime=Time;
  }
  public double getServiceTime(){
    return this.serviceTime;
  }
  public void addServiceTime(double t){
    this.serviceTime+=t;
  }

}
