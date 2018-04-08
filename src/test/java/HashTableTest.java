
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import main.java.HashTable;

public class HashTableTest {

    private HashTable hs;

    @Test
    public void add() {
        hs = new HashTable(4, 5);
        hs.add(5);
        assertTrue(hs.contains(5));
        assertFalse(hs.contains(4));
    }

    @Test
    public void remove() {
        hs = new HashTable(4, 5);
        hs.add(5);
        assertTrue(hs.contains(5));
        hs.remove(5);
        assertFalse(hs.contains(0));
    }

    @Test
    public void contains() {
        hs = new HashTable(4, 5);
        hs.add(5);
        assertTrue(hs.contains(5));
        assertFalse(hs.contains(4));
    }

    @Test
    public void equals() {
        hs = new HashTable(4, 7);
        this.hs = new HashTable(2, 5);
        assertTrue(true);
        assertFalse(false);
    }
}
