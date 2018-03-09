package spbstu.tpj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private HashTable hs;

    @Test
    public void put() {
    }

    @Test
    public void get() {
    }

    @Test
    public void containsKey() {
    }

    @Test
    public void equals() {
        hs = new HashTable(10, 10);
        HashTable h = new HashTable(10, 10);
        assertTrue(h.equals(hs));
        hs.put(1, 1);
        assertFalse(h.equals(hs));
    }
}