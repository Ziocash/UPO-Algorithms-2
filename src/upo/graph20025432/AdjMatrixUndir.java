package upo.graph20025432;

public class AdjMatrixUndir extends AdjMatrixUndirWeight {

    public AdjMatrixUndir() {
        super();
    }

    @Override
    public void setEdgeWeight(String vertex1, String vertex2, double weight) {
        throw new UnsupportedOperationException("Working on an unweighted graph.");
    }
}