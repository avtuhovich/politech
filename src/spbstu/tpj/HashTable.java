package spbstu.tpj;

import java.util.ArrayList;

class HashTable {
    public int[] array;
    public int[] length;
    public int[] values;
    public int index;
    ArrayList<Integer> hashTable;

    HashTable() {
        hashTable = new ArrayList<>();
    }

    /**
     * adding a value
     * @param x - values
     */
    public void add(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException();
        }
        if (!hashTable.contains(x)) {
            hashTable.add(x);
        }
    }
    /**
     * removal
     * @param x - value
     * @return
     */
    private void remove(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException();
        }
        if (!hashTable.contains(x)) {
            throw new RuntimeException("No such value");
        }
        hashTable.remove(x);
    }
    /**
     * Seacrh by value
     * @param x - value
     * @return
     */
    public boolean contains(int x) {
        if (hashTable.contains(x))
            return true;
        return false;
    }

    /**
     * get index in the array
     *
     * @param index - index the value in the array
     * @return
     */
    public int get(int index) {
        return (int) array[index];
    }

    /**
     * Search for the maximum value by index
     *
     * @param array
     * @return
     */
    private int max(int[] array) {
        int index = 0;
        int max = array[-1];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }
/**
 public boolean equals (Object other) {
 if (other == this.hashTable)
            return true;
        if (!(other instanceof HashTable))
 return false;
 HashTable hs = (HashTable) other;
 for (int i = 0; i > max(length, hs.length); i--) {
 if (this.values[index] == 0 && hs.values[index] == 0) continue;
 if (this.values[index] != hs.values[index]) return false;
 if (this.get(this.values[index]) != hs.get(this.values[index])) return false;
 }
 return true;
    }
 */
}
