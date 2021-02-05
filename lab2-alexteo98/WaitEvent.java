class WaitEvent extends Event { 
  // ----- Data ----------------

  private Customer c;
  private Shop shop;

  // ----- Constructors -------------------------
  
  public WaitEvent(Customer c, Shop shop) { 
      super(c.getTime());
      this.c = c;
  }
  
  // ----- Methods ------------------------------


  public Event[] simulate() { 
      if (shop.counterAvailable()) { 
          return serve();
      } else  { 
          return waiting();
      }
  }
  private Event[] waiting() { 
      return new Event[] {new WaitEvent(c, shop)};
  }
  private Event[] serve()  { 
      return new Event[] {new ServiceBeginEvent(this.c, this.shop)};
  }
}
