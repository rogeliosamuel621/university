package hashtable;

import java.util.Hashtable;

public class CustomHashTable {
    private Hashtable<Integer, String> hashTable;

    public CustomHashTable() {
        this.hashTable = new Hashtable<Integer, String>();
    }

    public boolean isEmpty() {
        return  this.hashTable.isEmpty();
    }

    public int size() {
        return this.hashTable.size();
    }

    public Hashtable add(int key, String value) {
        this.hashTable.put(key, value);

        return this.hashTable;
    }

    public String getByKey(int key) {
        return this.hashTable.get(key);
    }
}
