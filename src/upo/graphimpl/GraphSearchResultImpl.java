package upo.graphimpl;

import java.util.Iterator;

import upo.graph.GraphSearchResult;
import upo.graph.SearchType;
import upo.graph.Vertex;

public class GraphSearchResultImpl implements GraphSearchResult
{

	@Override
	public Iterator<Vertex> iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchType getType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex getSource()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDistance(Vertex v) throws UnsupportedOperationException, IllegalArgumentException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vertex getParentOf(Vertex v) throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStartTime(Vertex v) throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEndTime(Vertex v) throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getEdgeWeight(Vertex v1, Vertex v2) throws IllegalArgumentException
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
