package test;

import org.junit.Test;

import upo.graph20025432.AdjMatrixUndir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdjMatrixUndirTest
{
    AdjMatrixUndir matrixUndir = new AdjMatrixUndir();

    @Test
    public void testAddVertex()
    {
        assertEquals(0,matrixUndir.addVertex("A"));
        assertEquals(1,matrixUndir.addVertex("B"));
        assertEquals(2,matrixUndir.addVertex("C"));
    }

    
    @Test
    public void testContainsVertex()
    {
        assertEquals(0,matrixUndir.addVertex("A"));
        assertEquals(1,matrixUndir.addVertex("B"));
        assertEquals(2,matrixUndir.addVertex("C"));
        assertTrue(matrixUndir.containsVertex("A"));
        assertTrue(matrixUndir.containsVertex("B"));
        assertTrue(matrixUndir.containsVertex("C"));
        assertEquals(3, matrixUndir.size());
    }

    @Test
    public void testEdgeMethods()
    {
        assertEquals(0,matrixUndir.addVertex("A"));
        assertEquals(1,matrixUndir.addVertex("B"));
        assertEquals(2,matrixUndir.addVertex("C"));
        assertTrue(matrixUndir.containsVertex("A"));
        assertTrue(matrixUndir.containsVertex("B"));
        assertTrue(matrixUndir.containsVertex("C"));
        assertEquals(3, matrixUndir.size());

        matrixUndir.addEdge("A", "B");
        assertTrue(matrixUndir.containsEdge("A", "B"));
        assertTrue(matrixUndir.containsEdge("B", "A"));
        assertThrows(IllegalArgumentException.class, () -> { matrixUndir.containsEdge("C", "D");});
    }
}