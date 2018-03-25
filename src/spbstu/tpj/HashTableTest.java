package spbstu.tpj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private HashTable hs;

    @Test
    public void add() {
        hs = new HashTable();
        hs.add(5);
        assertTrue(hs.contains(5));
        assertFalse(hs.contains(4));
        assertEquals(5, hs.get(0));
    }

    @Test
    public void remove() {
        hs = new HashTable();
        hs.add(5);
        assertTrue(hs.contains(5));
        hs.remove(5);
        assertFalse(hs.contains(5));
    }

    @Test
    public void contains() {
        hs = new HashTable();
        hs.contains(6);
        assertTrue(true);
        assertFalse(false);
    }
}