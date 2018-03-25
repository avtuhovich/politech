package spbstu.tpj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

class HashTable {
    private ArrayList<Integer> hashTable;

    HashTable() {
        hashTable = new ArrayList<>();
    }

    /**
     * adding a value
     *
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
     *
     * @param x - value
     * @return
     */
    public void remove(Integer x) {
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
     *
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
        return hashTable.get(index);
    }

    /**
     * The size of hashTable
     *
     * @return
     */
    public int size() {
        return hashTable.size();
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashTable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTable ht = (HashTable) o;
        if (this.size() == hashTable.size()) return true;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != ht.get(i)) return false;
        }

        return true;
    }
}
