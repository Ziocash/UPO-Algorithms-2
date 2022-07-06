package upo.graph20025432;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import upo.graph.base.Graph;
import upo.graph.base.VisitForest;
import upo.graph.base.WeightedGraph;
import upo.graph.base.VisitForest.Color;
import upo.graph.base.VisitForest.VisitType;

public class AdjMatrixUndirWeight implements WeightedGraph {

    private static final String GRAPH_NOT_CONTAINING = "Graph does not contains \'";
    private static final String NOT_IMPLEMENTED = "Not implemented.";
    protected double[][] matrix;
    protected List<String> vertices = new ArrayList<>();
    protected int time = 0;
    protected int t;

    public AdjMatrixUndirWeight() {
        matrix = new double[size()][size()];
        Arrays.fill(matrix, 0);
    }

    @Override
    public void addEdge(String vertex1, String vertex2) throws IllegalArgumentException {
        if (!containsVertex(vertex1))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");
        if (!containsVertex(vertex2))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");

        if (!containsEdge(vertex1, vertex2))
            matrix[getVertexIndex(vertex1)][getVertexIndex(
                    vertex2)] = matrix[getVertexIndex(vertex2)][getVertexIndex(vertex1)] = defaultEdgeWeight;
    }

    @Override
    public int addVertex(String vertex) {
        vertices.add(vertex);
        var backupMatrix = new double[size()][size()];
        int index = size() - 1;
        matrix = new double[size()][size()];
        System.arraycopy(matrix, 0, backupMatrix, 0, size());
        return index;
    }

    @Override
    public Set<Set<String>> connectedComponents() throws UnsupportedOperationException {
        Set<Set<String>> componentsList = new HashSet<>();
        VisitForest visit = new VisitForest(this, VisitType.DFS);
        for (var element : vertices)
            if (visit.getColor(element) == Color.WHITE)
                componentsList.add(getDFSTree(visit, element));
        return componentsList;
    }

    protected Set<String> getDFSTree(VisitForest visit, String vertex) {
        Set<String> setAux = new HashSet<>();
        recursiveDFS(visit, vertex, setAux);
        return setAux;
    }

    protected void recursiveDFS(VisitForest forest, String vertex, Set<String> set) {
        forest.setColor(vertex, Color.GRAY);
        forest.setStartTime(vertex, time);
        time++;
        set.add(vertex);
        for (var element : getAdjacent(vertex)) {
            if (forest.getColor(element) == Color.WHITE) {
                forest.setParent(element, vertex);
                recursiveDFS(forest, element, set);
            }
        }
        forest.setColor(vertex, Color.BLACK);
        forest.setEndTime(vertex, time);
        time++;
    }

    @Override
    public boolean containsEdge(String vertex1, String vertex2) throws IllegalArgumentException {
        if (!containsVertex(vertex1))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");
        if (!containsVertex(vertex2))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");

        return matrix[getVertexIndex(vertex1)][getVertexIndex(vertex2)] > 0
                && matrix[getVertexIndex(vertex2)][getVertexIndex(vertex1)] > 0;
    }

    @Override
    public boolean containsVertex(String vertex) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                if (i == getVertexIndex(vertex) && j == getVertexIndex(vertex))
                    return true;
        return false;
    }

    @Override
    public Set<String> getAdjacent(String vertex) throws NoSuchElementException {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex + "\'.");
        Set<String> internalSet = new TreeSet<>();
        for (String element : vertices)
            if (matrix[getVertexIndex(vertex)][getVertexIndex(element)] > 0
                    || matrix[getVertexIndex(element)][getVertexIndex(vertex)] > 0) 
                internalSet.add((element));
        return internalSet;
    }

    @Override
    public VisitForest getBFSTree(String vertex) throws UnsupportedOperationException, IllegalArgumentException {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex + "\'.");
        VisitForest forest = new VisitForest(this, VisitType.BFS);
        Queue<String> verticesQueue = new LinkedList<>();
        forest.setColor(vertex, Color.WHITE);
        forest.setDistance(vertex, 0);
        verticesQueue.add(vertex);
        while (!verticesQueue.isEmpty()) {
            for (var adj : getAdjacent(verticesQueue.peek())) {
                if (forest.getColor(adj) == Color.WHITE) {
                    forest.setColor(adj, Color.GRAY);
                    forest.setParent(adj, verticesQueue.peek());
                    forest.setDistance(adj, forest.getDistance(verticesQueue.peek()) + 1);
                    verticesQueue.add(adj);
                }
            }
            forest.setColor(verticesQueue.peek(), Color.BLACK);
            verticesQueue.remove(verticesQueue.peek());
        }
        return forest;
    }

    @Override
    public VisitForest getDFSTOTForest(String vertex) throws UnsupportedOperationException, IllegalArgumentException {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex + "\'.");
        time = 1;
        VisitForest forest = new VisitForest(this, VisitType.DFS_TOT);
        for (var element : vertices) {
            if (forest.getColor(element) == Color.WHITE)
                recursiveDFS(forest, element);
        }
        return forest;
    }

    // Visit
    protected void recursiveDFS(VisitForest forest, String vertex) {
        forest.setColor(vertex, Color.GRAY);
        forest.setStartTime(vertex, time);
        time++;
        for (var element : getAdjacent(vertex)) {
            if (forest.getColor(element) == Color.WHITE) {
                forest.setParent(element, vertex);
                recursiveDFS(forest, element);
            }
        }
        forest.setColor(vertex, Color.BLACK);
        forest.setEndTime(vertex, time);
        time++;
    }
    //

    @Override
    public VisitForest getDFSTOTForest(String[] vertices)
            throws UnsupportedOperationException, IllegalArgumentException {
        if (vertices.length != this.vertices.size())
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertices + "\'.");
        VisitForest forest = new VisitForest(this, VisitType.DFS_TOT);
        for (var element : vertices) {
            if (forest.getColor(element) == Color.WHITE)
                recursiveDFS(forest, element);
        }
        return forest;
    }

    @Override
    public VisitForest getDFSTree(String vertex) throws UnsupportedOperationException, IllegalArgumentException {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex + "\'.");
        time = 1;
        VisitForest visit = new VisitForest(this, VisitType.DFS);
        recursiveDFS(visit, vertex);
        return visit;
    }

    @Override
    public int getVertexIndex(String vertex) {
        return vertices.indexOf(vertex);
    }

    @Override
    public String getVertexLabel(Integer index) {
        return vertices.get(index);
    }

    @Override
    public boolean isAdjacent(String vertex1, String vertex2) throws IllegalArgumentException {
        return containsEdge(vertex1, vertex2);
    }

    @Override
    public boolean isCyclic() {
        VisitForest forest = new VisitForest(this, null);
        for (var element : vertices) {
            if ((forest.getColor(element) == Color.WHITE) && visitRicCycle(forest, element))
                return true;
        }
        return false;
    }

    private boolean visitRicCycle(VisitForest forest, String element) {
        forest.setColor(element, Color.GRAY);
        for (var adj : getAdjacent(element)) {
            if (forest.getColor(adj) == Color.WHITE) {
                forest.setParent(adj, element);
                if (visitRicCycle(forest, adj))
                    return true;
            } else if (adj.equals(forest.getPartent(element)))
                return true;
        }
        forest.setColor(element, Color.BLACK);
        return false;
    }

    @Override
    public boolean isDAG() {
        return false;
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public void removeEdge(String vertex1, String vertex2) throws IllegalArgumentException, NoSuchElementException {
        if (!containsVertex(vertex1))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");
        if (!containsVertex(vertex2))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");

        if (!containsEdge(vertex1, vertex2))
            throw new NoSuchElementException("Cannot retrieve an unexisting weight.");

        setEdgeWeight(vertex1, vertex2, 0);
    }

    @Override
    public void removeVertex(String vertex) throws NoSuchElementException {
        int index = getVertexIndex(vertex);
        if (index > -1) {
            vertices.remove(vertex);
            matrix = escapeColumn(index);
        } else
            throw new NoSuchElementException("Cannot remove an unexisting vertex.");
    }

    private double[][] escapeColumn(int indexToEscape) {
        double[][] reducedMatrix = new double[matrix.length - 1][matrix.length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if (i != indexToEscape && j != indexToEscape) {

                    if ((i > indexToEscape) && (j > indexToEscape)) {
                        reducedMatrix[i - 1][j - 1] = matrix[i][j];
                    } else if (i > indexToEscape) {
                        reducedMatrix[i - 1][j] = matrix[i][j];
                    } else if (j > indexToEscape) {
                        reducedMatrix[i][j - 1] = matrix[i][j];
                    } else
                        reducedMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return reducedMatrix;
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public Set<Set<String>> stronglyConnectedComponents() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Working on an undirected graph.");
    }

    @Override
    public String[] topologicalSort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Working on an undirected graph.");
    }

    @Override
    public WeightedGraph getBellmanFordShortestPaths(String arg0)
            throws UnsupportedOperationException, IllegalArgumentException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    @Override
    public WeightedGraph getDijkstraShortestPaths(String arg0)
            throws UnsupportedOperationException, IllegalArgumentException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    @Override
    public double getEdgeWeight(String vertex1, String vertex2)
            throws IllegalArgumentException, NoSuchElementException {
        if (!containsVertex(vertex1))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");
        if (!containsVertex(vertex2))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");
        
        return matrix[getVertexIndex(vertex1)][getVertexIndex(vertex2)];
    }

    @Override
    public WeightedGraph getFloydWarshallShortestPaths() throws UnsupportedOperationException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    @Override
    public WeightedGraph getKruskalMST() throws UnsupportedOperationException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    @Override
    public WeightedGraph getPrimMST(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
        throw new UnsupportedOperationException(NOT_IMPLEMENTED);
    }

    @Override
    public void setEdgeWeight(String vertex1, String vertex2, double weight) {
        if (containsEdge(vertex1, vertex2))
            matrix[getVertexIndex(vertex1)][getVertexIndex(
                    vertex2)] = matrix[getVertexIndex(vertex2)][getVertexIndex(vertex1)] = weight;
    }

    @Override
    public boolean equals(Object graph) {
        if (graph == null)
            return false;
        if (graph.getClass() != getClass())
            return false;
        Graph comparedTo = (AdjMatrixUndirWeight) graph;

        if (comparedTo.size() != size())
            return false;

        for (int i = 0; i < size(); i++)
            if (comparedTo.getVertexLabel(i) != vertices.get(i))
                return false;
        for (int i = 0; i < size(); i++)
            for (int j = 0; j < size(); j++) {
                if (comparedTo.containsEdge(comparedTo.getVertexLabel(i),
                        comparedTo.getVertexLabel(j)) != containsEdge(vertices.get(i), vertices.get(j)))
                    return false;
                if (getEdgeWeight(comparedTo.getVertexLabel(i),
                        comparedTo.getVertexLabel(j)) != getEdgeWeight(vertices.get(i), vertices.get(j)))
                    return false;
            }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + vertices.size() + Arrays.hashCode(matrix);
    }

}
