package upo.graph20025432;

import upo.graph.base.WeightedGraph;

public class AdjMatrixUndir extends AdjMatrixUndirWeight {

    public AdjMatrixUndir() {
        super();
    }

    @Override
    public void setEdgeWeight(String vertex1, String vertex2, double weight) {
        throw new UnsupportedOperationException("Working on an unweighted graph.");
    }

    @Override
    public WeightedGraph getDijkstraShortestPaths(String vertex)
            throws UnsupportedOperationException, IllegalArgumentException {
        throw new UnsupportedOperationException("Cannot run Dijkstra algorithm on an unweighted graph.");
    }
}