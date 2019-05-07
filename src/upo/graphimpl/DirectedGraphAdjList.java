/**
 * 
 */
package upo.graphimpl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

import upo.graph.Edge;
import upo.graph.Graph;
import upo.graph.GraphSearchResult;
import upo.graph.SearchType;
import upo.graph.Vertex;

/**
 * @author Luca Piovesan
 *
 */
public class DirectedGraphAdjList implements Graph 
{
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Vertex> iterator() 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#addVertex(upo.graph.Vertex)
	 */
	@Override
	public boolean addVertex(Vertex v) 
	{
		
		return false;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#containsVertex(upo.graph.Vertex)
	 */
	@Override
	public boolean containsVertex(Vertex v) 
	{
		
		return false;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#removeVertex(upo.graph.Vertex)
	 */
	@Override
	public boolean removeVertex(Vertex v) 
	{
		
		return false;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#vertexSet()
	 */
	@Override
	public Set<Vertex> vertexSet() 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#addEdge(upo.graph.Vertex, upo.graph.Vertex)
	 */
	@Override
	public Edge addEdge(Vertex sourceVertex, Vertex targetVertex) 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#containsEdge(upo.graph.Vertex, upo.graph.Vertex)
	 */
	@Override
	public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex) 
	{
		
		return false;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#edgeSet()
	 */
	@Override
	public Set<Edge> edgeSet() 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#degreeOf(upo.graph.Vertex)
	 */
	@Override
	public int degreeOf(Vertex vertex) 
	{
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#inDegreeOf(upo.graph.Vertex)
	 */
	@Override
	public int inDegreeOf(Vertex vertex) 
	{

		return 0;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#outDegreeOf(upo.graph.Vertex)
	 */
	@Override
	public int outDegreeOf(Vertex vertex) 
	{
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#isDirected()
	 */
	@Override
	public boolean isDirected() 
	{
		
		return false;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#removeEdge(upo.graph.Vertex, upo.graph.Vertex)
	 */
	@Override
	public Edge removeEdge(Vertex sourceVertex, Vertex targetVertex) 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#getEdgeWeight(upo.graph.Vertex, upo.graph.Vertex)
	 */
	@Override
	public double getEdgeWeight(Vertex sourceVertex, Vertex targetVertex) 
	{
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#setEdgeWeight(upo.graph.Vertex, upo.graph.Vertex, double)
	 */
	@Override
	public void setEdgeWeight(Vertex sourceVertex, Vertex targetVertex, double weight) 
	{

	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#visit(upo.graph.SearchType)
	 */
	@Override
	public GraphSearchResult visit(SearchType type) throws UnsupportedOperationException 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#isCyclic()
	 */
	@Override
	public boolean isCyclic() 
	{
		
		return false;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#isDAG()
	 */
	@Override
	public boolean isDAG() 
	{
		
		return false;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#topologicalSort()
	 */
	@Override
	public Vertex[] topologicalSort() 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#stronglyConnectedComponents()
	 */
	@Override
	public Collection<Collection<Vertex>> stronglyConnectedComponents() 
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see upo.graph.Graph#toStringSCC()
	 */
	@Override
	public String toStringSCC() 
	{
		
		return null;
	}

}
