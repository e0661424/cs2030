class Array<T extends Comparable<T>>{ 

  private T[] array;

  Array(int size) { 
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Comparable[size];
    this.array=temp;
  }

  public void set (int index, T item) { 
    this.array[index] = item;
  }

  public T get(int index) { 
    return this.array[index];
  }

  public T[] getArray() { 
    return this.array;
  }

  public T min() { 
    T temp = array[0];

    for (int i = 1; i < array.length;  i++) { 
      if (temp.compareTo(array[i]) == -1) { 
        // not needed
      } else  { 
        temp = array[i];
      }
    }

    return temp;
  }

}
