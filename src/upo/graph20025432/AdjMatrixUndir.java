package upo.graph20025432;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

import upo.graph.base.Graph;
import upo.graph.base.VisitForest;
import upo.graph.base.VisitForest.Color;
import upo.graph.base.VisitForest.VisitType;

public class AdjMatrixUndir implements Graph {

    private static final String GRAPH_NOT_CONTAINING = "Graph does not contains \'";

    int[][] matrix;
    List<String> vertices = new ArrayList<String>();
    int time = 0;
    int t;

    public AdjMatrixUndir() {
        matrix = new int[size()][size()];
        Arrays.fill(matrix, 0);
    }

    @Override
    public int addVertex(String vertex) {
        vertices.add(vertex);
        var backupMatrix = new int[size()][size()];
        int index = size() - 1;
        matrix = new int[size()][size()];
        System.arraycopy(matrix, 0, backupMatrix, 0, size());
        return index;
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
    public void addEdge(String vertex1, String vertex2) throws IllegalArgumentException {
        if (!containsVertex(vertex1))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");
        if (!containsVertex(vertex2))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");

        if (!containsEdge(vertex1, vertex2))
            matrix[getVertexIndex(vertex1)][getVertexIndex(
                    vertex2)] = matrix[getVertexIndex(vertex2)][getVertexIndex(vertex1)] = 1;

    }

    @Override
    public Set<Set<String>> connectedComponents() throws UnsupportedOperationException {
        var componentsList = new TreeSet<Set<String>>();
        VisitForest visit = new VisitForest(this, VisitType.DFS);
        for (var elem : vertices) {
            if (visit.getColor(elem) == Color.WHITE) {
                var components = getDFSTree(elem);
            }
        }
        return componentsList;
    }

    @Override
    public boolean containsEdge(String vertex1, String vertex2) throws IllegalArgumentException {
        if (!containsVertex(vertex1))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");
        if (!containsVertex(vertex2))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex1 + "\'.");

        return matrix[getVertexIndex(vertex1)][getVertexIndex(vertex2)] == 1
                && matrix[getVertexIndex(vertex2)][getVertexIndex(vertex1)] == 1;
    }

    @Override
    public Set<String> getAdjacent(String vertex) throws NoSuchElementException {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex + "\'.");
        Set<String> internalSet = new TreeSet<String>();
        for (String element : vertices)
            if (matrix[getVertexIndex(vertex)][getVertexIndex(element)] == 1
                    || matrix[getVertexIndex(element)][getVertexIndex(vertex)] == 1)
                internalSet.add((element));
        return internalSet;
    }

    @Override
    public VisitForest getBFSTree(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VisitForest getDFSTOTForest(String vertex) throws UnsupportedOperationException, IllegalArgumentException {
        if (!containsVertex(vertex))
            throw new IllegalArgumentException(GRAPH_NOT_CONTAINING + vertex + "\'.");

        VisitForest visit = new VisitForest(this, VisitType.DFS_TOT);
        recursiveDFS(visit, vertex);
        return visit;
    }

    private void recursiveDFS(VisitForest forest, String vertex) {
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

    @Override
    public VisitForest getDFSTOTForest(String[] arg0) throws UnsupportedOperationException, IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VisitForest getDFSTree(String arg0) throws UnsupportedOperationException, IllegalArgumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getVertexIndex(String vertex) {
        int index = 0;
        for (String s : vertices) {
            if (s.equals(vertex))
                return index;
            index++;
        }
        return -1;
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
        // TODO Auto-generated method stub
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
    public void removeEdge(String arg0, String arg1) throws IllegalArgumentException, NoSuchElementException {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeVertex(String vertex) throws NoSuchElementException {
        int index = getVertexIndex(vertex);
        if (index > 0) {
            vertices.remove(vertex);
            matrix = escapeColumn(index, vertices.size());
        } else
            throw new NoSuchElementException("Cannot remove an unexisting vertex.");
    }

    private int[][] escapeColumn(int indexToEscape, int newIndex) {
        int[][] reducedMatrix = new int[matrix.length - 1][matrix.length - 1];
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
    public boolean equals(Object graph) {
        Graph comparedTo = (AdjMatrixUndir) graph;

        for (int i = 0; i < vertices.size(); i++)
            for (int j = 0; j < vertices.size(); j++)
                if (comparedTo.containsEdge(comparedTo.getVertexLabel(i),
                        comparedTo.getVertexLabel(j)) != containsEdge(vertices.get(i), vertices.get(j)))
                    return false;
        for (int i = 0; i < vertices.size(); i++)
            if (comparedTo.getVertexLabel(i) != vertices.get(i))
                return false;

        return true;
    }
}