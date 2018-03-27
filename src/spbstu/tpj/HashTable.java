package spbstu.tpj;

import java.util.Arrays;

class HashTable {
    public int length;
    private int mask;
    private int[] head;
    private int[] next;
    private Integer[] values;
    private int cnt = 1;

    /**
     * creature a HashTable
     *
     * @param degree  - degree
     * @param maxSize - mix size table
     */
    public HashTable(int degree, int maxSize) {
        int headNum = 1 << degree;
        mask = headNum - 1;
        head = new int[headNum];
        next = new int[maxSize + 1];
        values = new Integer[maxSize + 1];
        length = maxSize;
    }

    /**
     * adding a value
     *
     * @param x - value
     */
    public void add(Integer x) {
        if (x == null) {
            throw new IllegalArgumentException();
        }
        if (contains(x)) {
            return;
        }
        int h = index(x);
        next[cnt] = head[h];
        values[cnt] = x;
        head[h] = cnt++;
    }

    /**
     * Se
     *
     * @return
     */
    public int get(int x) {
        int h = index(x);
        for (int i = head[h]; i != 0; i = next[i]) {
            if (values[i] == x)
                return values[i];
        }
        throw new RuntimeException("No such value");
    }

    /**
     * removal value
     *
     * @param x - value
     * @return
     */
    public boolean remove(Integer x) {
        int h = index(x);
        if (x == null) {
            throw new IllegalArgumentException();
        }
        for (int i = head[h]; i != 0; i = next[i]) {
            if (values[i] == x) {
                values[i] = null;
                next[cnt] = 0;
                head[h] = cnt--;
                return true;
            }
        }
        return false;
    }

    private int index(int x) {
        return Math.abs((x >> 15) ^ x) & mask;
    }

    /**
     * Contains value in HashTable
     *
     * @param x - value
     * @return
     */
    public boolean contains(int x) {
        for (int i = 1; i != 0; i = next[i])
            if (values[i] != null && values[i] == x)
                return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTable hashTable = (HashTable) o;

        if (length != hashTable.length) return false;
        if (mask != hashTable.mask) return false;
        if (cnt != hashTable.cnt) return false;
        if (!Arrays.equals(head, hashTable.head)) return false;
        if (!Arrays.equals(next, hashTable.next)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(values, hashTable.values);
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + mask;
        result = 31 * result + Arrays.hashCode(head);
        result = 31 * result + Arrays.hashCode(next);
        result = 31 * result + Arrays.hashCode(values);
        result = 31 * result + cnt;
        return result;
    }
}