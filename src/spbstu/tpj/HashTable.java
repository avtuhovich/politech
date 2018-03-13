package spbstu.tpj;

class HashTable {
    public int[] keys;
    public int length;
    private int mask;
    private int[] head;
    private int[] next;
    private int[] values;
    private int cnt = 1;

    /**
     * @param degree  - степень числа
     * @param maxSize - максимальный размер
     */
    public HashTable(int degree, int maxSize) {
        int headNum = 1 << degree;
        mask = headNum - 1;
        head = new int[headNum];
        next = new int[maxSize + 1];
        keys = new int[maxSize + 1];
        values = new int[maxSize + 1];
        length = maxSize;
    }

    /**
     * @param x - ключ
     * @param y - значение
     */
    public void put(int x, int y) {
        if (containsKey(x)) return;
        int h = index(x);
        for (int i = head[h]; i != 0; i = next[i])
            if (keys[i] == x) {
                values[i] = y;
                return;
            }
        next[cnt] = head[h];
        keys[cnt] = x;
        values[cnt] = y;
        head[h] = cnt++;
    }

    /**
     * @param x - ключ
     * @return
     */
    public int get(int x) {
        int h = index(x);
        for (int i = head[h]; i != 0; i = next[i])
            if (keys[i] == x)
                return values[i];
        throw new RuntimeException("No such key!");
    }

    /**
     * @param x - ключ
     * @return
     */
    public boolean containsKey(int x) {
        int h = index(x);
        for (int i = head[h]; i != 0; i = next[i])
            if (keys[i] == x)
                return true;
        return false;
    }

    private int index(int x) {
        return Math.abs((x >> 15) ^ x) & mask;
    }

    private int min(int x, int y) {
        if (x > y)
            return y;
        else
            return x;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (!(other instanceof HashTable))
            return false;
        HashTable hs = (HashTable) other;
        for (int i = 0; i < min(length, hs.length); i++) {
            if (this.keys[i] == 0 && hs.keys[i] == 0) continue;
            if (this.keys[i] != hs.keys[i]) return false;
            if (this.get(this.keys[i]) != hs.get(this.keys[i])) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int i = 0;
        for (int k : keys) {
            if (k == 0) continue;
            str.append("[").append(i).append("] ").append(k).append(" —> ")
                    .append(get(k)).append("\n");
            i++;
        }
        return str.toString().trim();
    }
}