package upo.graphimpl;

import java.util.Iterator;

import upo.graph.GraphSearchResult;
import upo.graph.SearchType;
import upo.graph.Vertex;

public class GraphSearchResultImpl implements GraphSearchResult
{

	private SearchType type;
	private Vertex source;
	
	@Override
	public Iterator<Vertex> iterator()
	{
		
		return null;
	}

	@Override
	public SearchType getType()
	{
		
		return null;
	}

	@Override
	public Vertex getSource()
	{
		
		return null;
	}

	@Override
	public double getDistance(Vertex v) throws UnsupportedOperationException, IllegalArgumentException
	{
		
		return 0;
	}

	@Override
	public Vertex getParentOf(Vertex v) throws IllegalArgumentException
	{
		
		return null;
	}

	@Override
	public int getStartTime(Vertex v) throws IllegalArgumentException
	{
		
		return 0;
	}

	@Override
	public int getEndTime(Vertex v) throws IllegalArgumentException
	{
		
		return 0;
	}

	@Override
	public double getEdgeWeight(Vertex v1, Vertex v2) throws IllegalArgumentException
	{
		
		return 0;
	}

}
