public class MyHashMap<K, V> {

  private class masuk<K, V> {
    private V value;
    private K key;
    private masuk<K, V> next;

    public K getKey() {
      return this.key;
    }

    public masuk(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public V getValue() {
      return this.value;
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

  public V get(K key) {
    int hash = key.hashCode() % SIZE;
    masuk<K, V> e = table[hash];

    if (e == null) {
      return null;
    }

    while (e != null) {
      if (e.getKey() == key) {
        return e.getValue();
      }
      e = e.next;
    }

    return null;
  }

  public masuk<K, V> remove(K key) {
    int hash = key.hashCode() % SIZE;
    masuk<K, V> e = table[hash];

    if (e == null) {
      return null;
    }

    if (e.getKey() == key) {
      table[hash] = e.next;
      e.next = null;
      return e;
    }

    masuk<K, V> prev = e;
    e = e.next;

    while (e != null) {
      if (e.getKey() == key) {
        prev.next = e.next;
        e.next = null;
        return e;
      }
      prev = e;
      e = e.next;
    }

    return null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < SIZE; i++) {
      if (table[i] != null) {
        sb.append(i + " " + table[i] + "\n");
      } else {
        sb.append(i + " " + "null" + "\n");
      }
    }

    return sb.toString();
  }
}
