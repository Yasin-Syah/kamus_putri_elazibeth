public class MyHashMap<K, V> {

    private class masuk<K, V> {
      private K key;
      private V value;
      private masuk<K, V> next;
  
      public masuk(K key, V value) {
        this.key = key;
        this.value = value;
      }
  
      public K getKey() {
        return this.key;
      }
  
      public V getValue() {
        return this.value;
      }
  
      public void setValue(V value) {
        this.value = value;
      }
  
      @Override
      public String toString() {
        masuk<K, V> temp = this;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
          sb.append(temp.key + " -> " + temp.value + ",");
          temp = temp.next;
        }
        return sb.toString();
      }
  
    }
     private final int SIZE = 5000;

  private masuk<K, V> table[];

  public MyHashMap() {
    table = new masuk[SIZE];
  }

  public void put(K key, V value) {
    int hash = key.hashCode() % SIZE;
    masuk<K, V> e = table[hash];

    if (e == null) {
      table[hash] = new masuk<K, V>(key, value);
    } else {
      while (e.next != null) {
        if (e.getKey() == key) {
          e.setValue(value);
          return;
        }
        e = e.next;
      }

      if (e.getKey() == key) {
        e.setValue(value);
        return;
      }

      e.next = new masuk<K, V>(key, value);
    }
  }
