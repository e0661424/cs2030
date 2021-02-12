class JoinQueueEvent extends Event { 
    
  private Queue q;
  private Customer c;
  private Event[] emptyEvent = new Event[] {};

  public JoinQueueEvent(Customer c, Queue q) { 
    super(c.getTime());
    this.c = c;
    this.q = q;
  }

  public Event[] simulate() { 
      this.q.enq(this.c);
      return this.emptyEvent;
  }

  private Event[] joinQ() { 
    System.out.println(String.format("%s: %s joined queue %s", 
          super.toString(), this.c, this.q));
    this.q.enq(this.c);
    return emptyEvent;
  }

  @Override
  public String toString() { 
      return String.format("%s: %s joined queue %s", 
            super.toString(), this.c, this.q);
  }

}
