package main.java;

import java.util.Arrays;

public class HashTable {
    private int[] head;
    private int[] next;
    private int[] values;
    private int cnt = 1;
    private int headCount;

    /**
     * Create HashTable
     *
     * @param headCount - Count array pointer to int values corresponding to the same hash-value
     * @param maxSize   - maxSize of table
     */
    public HashTable(int headCount, int maxSize) {
        this.headCount = headCount;
        head = new int[headCount];
        next = new int[maxSize + 1];
        values = new int[maxSize + 1];
    }

    /**
     * adding a value
     *
     * @param x - value
     */
    public void add(int x) {
        if (this.contains(x)) {
            return;
        }
        int h = index(hash(x));
        next[cnt] = head[h];
        values[cnt] = x;
        head[h] = cnt++;
    }

    /**
     * removal value
     *
     * @param x - value
     * @return
     */
    public boolean remove(int x) {
        int h = index(hash(x));
        for (int i = head[h]; i != 0; i = next[i]) {
            if (values[i] == x) {
                next[cnt] = 0;
                head[h] = cnt--;
                return true;
            }
        }
        return false;
    }

    /**
     * Contains value in HashTable
     *
     * @param x - value
     * @return
     */
    public boolean contains(int x) {
        int h = index(hash(x));
        for (int i = 1; i != 0; i = next[i])
            if (values[i] == x)
                return true;
        return false;
    }

    private int hash(int x) {
        return Math.abs((x >> 15) ^ x);
    }

    private int index(int hash) {
        return Math.abs(hash) % headCount;
    }

    private int[] getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTable hashTable = (HashTable) o;

        if (headCount != hashTable.headCount) return false;
        if (!values.equals(hashTable.getValues())) return false;
        return true;
    }
}