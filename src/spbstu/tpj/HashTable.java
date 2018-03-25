package spbstu.tpj;

import java.util.ArrayList;
import java.util.Arrays;

class HashTable {
    public int[] array;
    public int[] values;
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
     * @param index - index the value in the array
     * @return
     */
    public int get(int index) {
        return (int) array[index];
    }
    /**
     * The size of hashTable
     * @return
     */
    public int size() {
        return hashTable.size();
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + Arrays.hashCode(values);
        result = 31 * result + (hashTable != null ? hashTable.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this.size() == hashTable.size()) {
            return true;
        }
        for (int i = 0; i < hashTable.size(); i++) {
            if (this.get(i) != hashTable.get(i)) {
                return false;
            }
        }
        return true;
    }
}
