//import java.util.Arrays;
class Counter{
  private boolean[] counterID;
  private int numberOfCounters=0;

  public Counter(int n){
    counterID = new boolean[n];
    
    // set numberOfCounters
    setNumberOfCounters(n);

    // set all to available
    for (int i=0;i<numberOfCounters;i++){
      counterID[i]=true;
    }
    
  }

  public boolean available(){
    for(int i=0;i<counterID.length;i++){
      if (counterID[i]==true){
        return true;
      }
    }
    return false;
  }

  public void setNumberOfCounters(int n){
    this.numberOfCounters=n;
  }
}
