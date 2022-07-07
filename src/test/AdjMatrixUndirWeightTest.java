package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import upo.graph20025432.AdjMatrixUndirWeight;

public class AdjMatrixUndirWeightTest {

    AdjMatrixUndirWeight matrixUndirWeight = new AdjMatrixUndirWeight();

    private void populateGraph(int num) {
        for (char a = 'A'; a < 'A' + num; a++)
            matrixUndirWeight.addVertex(new String(new char[] { a }));
    }

    private void addEdgesForDijkstra() {
        matrixUndirWeight.addEdge("A", "B");
        matrixUndirWeight.setEdgeWeight("A", "B", 15.0);
        matrixUndirWeight.addEdge("A", "C");
        matrixUndirWeight.setEdgeWeight("A", "C", 12.0);
        matrixUndirWeight.addEdge("B", "C");
        matrixUndirWeight.setEdgeWeight("B", "C", 2.0);
        matrixUndirWeight.addEdge("C", "D");
        matrixUndirWeight.setEdgeWeight("C", "D", 1.0);
        matrixUndirWeight.addEdge("B", "D");
        matrixUndirWeight.setEdgeWeight("B", "D", 100.0);
    }

    @Test
    public void testDijkstra() {
        populateGraph(4);
        addEdgesForDijkstra();
        var result = matrixUndirWeight.getDijkstraShortestPaths("A");
        assertEquals(12, result.getEdgeWeight("A", "C"));
        assertEquals(2, result.getEdgeWeight("C", "B"));
        assertEquals(1, result.getEdgeWeight("C", "D"));
        assertTrue(result.containsEdge("A", "C"));
        assertTrue(result.containsEdge("C", "B"));
        assertTrue(result.containsEdge("C", "D"));
        assertFalse(result.containsEdge("A", "B"));
        assertFalse(result.containsEdge("B", "D"));
    }
}
