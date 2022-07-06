package test;

import org.junit.Test;

import upo.graph20025432.AdjMatrixUndir;
import upo.graph20025432.AdjMatrixUndirWeight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdjMatrixUndirTest {
    AdjMatrixUndir matrixUndir = new AdjMatrixUndir();

    @Test
    public void testAddVertex() {
        assertEquals(0, matrixUndir.addVertex("A"));
        assertEquals(1, matrixUndir.addVertex("B"));
        assertEquals(2, matrixUndir.addVertex("C"));
    }

    @Test
    public void testContainsVertex() {
        assertEquals(0, matrixUndir.addVertex("A"));
        assertEquals(1, matrixUndir.addVertex("B"));
        assertEquals(2, matrixUndir.addVertex("C"));
        assertTrue(matrixUndir.containsVertex("A"));
        assertTrue(matrixUndir.containsVertex("B"));
        assertTrue(matrixUndir.containsVertex("C"));
        assertEquals(3, matrixUndir.size());
    }

    @Test
    public void testEdgeMethods() {
        assertEquals(0, matrixUndir.addVertex("A"));
        assertEquals(1, matrixUndir.addVertex("B"));
        assertEquals(2, matrixUndir.addVertex("C"));
        assertTrue(matrixUndir.containsVertex("A"));
        assertTrue(matrixUndir.containsVertex("B"));
        assertTrue(matrixUndir.containsVertex("C"));
        assertEquals(3, matrixUndir.size());

        matrixUndir.addEdge("A", "B");
        assertTrue(matrixUndir.containsEdge("A", "B"));
        assertTrue(matrixUndir.containsEdge("B", "A"));
        assertThrows(IllegalArgumentException.class, () -> matrixUndir.containsEdge("C", "D"));
    }

    @Test
    public void testTrueEquals() {
        AdjMatrixUndir tempEqualsMatrix = new AdjMatrixUndir();
        assertEquals(0, matrixUndir.addVertex("A"));
        assertEquals(0, tempEqualsMatrix.addVertex("A"));
        assertEquals(1, matrixUndir.addVertex("B"));
        assertEquals(1, tempEqualsMatrix.addVertex("B"));
        assertEquals(2, matrixUndir.addVertex("C"));
        assertEquals(2, tempEqualsMatrix.addVertex("C"));
        assertEquals(3, matrixUndir.addVertex("D"));
        assertEquals(3, tempEqualsMatrix.addVertex("D"));

        matrixUndir.addEdge("A", "B");
        tempEqualsMatrix.addEdge("A", "B");
        matrixUndir.addEdge("C", "D");
        tempEqualsMatrix.addEdge("C", "D");

        assertTrue(matrixUndir.equals(tempEqualsMatrix));

    }

    @Test
    public void testFalseEquals() {
        AdjMatrixUndir tempEqualsMatrix = new AdjMatrixUndir();
        assertEquals(0, matrixUndir.addVertex("A"));
        assertEquals(0, tempEqualsMatrix.addVertex("A"));
        assertEquals(1, matrixUndir.addVertex("B"));
        assertEquals(1, tempEqualsMatrix.addVertex("B"));
        assertEquals(2, matrixUndir.addVertex("C"));
        assertEquals(2, tempEqualsMatrix.addVertex("C"));
        assertEquals(3, matrixUndir.addVertex("D"));

        matrixUndir.addEdge("A", "B");
        tempEqualsMatrix.addEdge("A", "B");
        matrixUndir.addEdge("A", "D");
        tempEqualsMatrix.addEdge("C", "B");

        assertFalse(matrixUndir.equals(tempEqualsMatrix));

    }

    @Test
    public void testFalseEqualsDifferentClass() {
        AdjMatrixUndirWeight anotherMatrix = new AdjMatrixUndirWeight();
        assertFalse(matrixUndir.equals(anotherMatrix));
        // Different classes lead to false result
    }

    @Test
    public void testExceptionCallingEdgeWeight() {
        assertThrows(UnsupportedOperationException.class, () -> matrixUndir.setEdgeWeight("A", "B", 1.0));
        assertDoesNotThrow(() -> matrixUndir.getEdgeWeight("A", "B"));
    }

    @Test
    public void testDFSTree() {
        int num = 6;
        for (char a = 'A'; a < 'A' + num; a++)
            matrixUndir.addVertex(new String(new char[] { a }));
        matrixUndir.addEdge("A", "B");
        matrixUndir.addEdge("A", "C");
        matrixUndir.addEdge("D", "B");
        matrixUndir.addEdge("E", "A");
        matrixUndir.addEdge("E", "F");
        matrixUndir.getDFSTOTForest("A");
    }

    @Test
    public void testBFSTree() {
        int num = 6;
        for (char a = 'A'; a < 'A' + num; a++)
            matrixUndir.addVertex(new String(new char[] { a }));
        matrixUndir.addEdge("A", "B");
        matrixUndir.addEdge("A", "C");
        matrixUndir.addEdge("D", "B");
        matrixUndir.addEdge("E", "A");
        matrixUndir.addEdge("E", "F");
        var visit = matrixUndir.getBFSTree("A");
        String[] vertices = new String[matrixUndir.size()];
        for (int i = matrixUndir.getVertexIndex("A") + 1; i < matrixUndir.size(); i++) {
            char a = (char) ('A' + i);
            vertices[i] = visit.getPartent(new String(new char[] { a }));
        }
        var arrayResult = new String[] { null, "A", "A", "B", "A", "E" };
        assertArrayEquals(arrayResult, vertices);
    }
}