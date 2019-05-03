package upo.graphimpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import upo.graph.Edge;
import upo.graph.Graph;
import upo.graph.GraphSearchResult;
import upo.graph.SearchType;
import upo.graph.Vertex;

public class GraphImpl implements Graph
{

	@Override
	public Iterator<Vertex> iterator()
	{
		
		return null;
	}

	@Override
	public boolean addVertex(Vertex v)
	{
		
		return false;
	}

	@Override
	public boolean containsVertex(Vertex v)
	{
		
		return false;
	}

	@Override
	public boolean removeVertex(Vertex v)
	{
		
		return false;
	}

	@Override
	public Set<Vertex> vertexSet()
	{
		
		return null;
	}

	@Override
	public Edge addEdge(Vertex sourceVertex, Vertex targetVertex)
	{

		return null;
	}

	@Override
	public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex)
	{

		return false;
	}

	@Override
	public Set<Edge> edgeSet()
	{
		
		return null;
	}

	@Override
	public int degreeOf(Vertex vertex)
	{

		return 0;
	}

	@Override
	public int inDegreeOf(Vertex vertex)
	{

		return 0;
	}

	@Override
	public int outDegreeOf(Vertex vertex)
	{

		return 0;
	}

	@Override
	public boolean isDirected()
	{

		return false;
	}

	@Override
	public Edge removeEdge(Vertex sourceVertex, Vertex targetVertex)
	{

		return null;
	}

	@Override
	public double getEdgeWeight(Vertex sourceVertex, Vertex targetVertex)
	{

		return 0;
	}

	@Override
	public void setEdgeWeight(Vertex sourceVertex, Vertex targetVertex, double weight)
	{
		
	}

	@Override
	public GraphSearchResult visit(SearchType type) throws UnsupportedOperationException
	{
		
		return null;
	}

	@Override
	public boolean isCyclic()
	{
		
		return false;
	}

	@Override
	public boolean isDAG()
	{
		
		return false;
	}

	@Override
	public Vertex[] topologicalSort()
	{

		return null;
	}

	@Override
	public Collection<Collection<Vertex>> stronglyConnectedComponents()
	{

		return null;
	}

	@Override
	public String toStringSCC()
	{

		return null;
	}

}
