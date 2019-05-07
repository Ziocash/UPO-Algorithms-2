package upo.graphimpl;

import java.util.Set;

import upo.graph.Edge;
import upo.graph.Graph;
import upo.graph.Vertex;

public class EdgeImpl implements Edge
{
	private Set<Vertex> vertices;
	private final Vertex source;
	private final Vertex destination;
	private double weight = 0;
	
	public EdgeImpl(Vertex src, Vertex dest, double weight)
	{
		vertices.add(src);
		source = src;
		vertices.add(dest);
		destination = dest;
		if(weight > 1)
			this.weight = weight; 
		else
			this.weight = Graph.DEFAULT_EDGE_WEIGHT;
	}
	
	public synchronized Vertex getSource()
	{
		return source;
	}

	public synchronized Vertex getDestination()
	{
		return destination;
	}
	
	@Override
	public double getEdgeWeight()
	{
		return weight;
	}

	@Override
	public Set<Vertex> getVertices()
	{
		if(!vertices.isEmpty())
			return vertices;
		return null;
	}

	@Override
	public Graph getGraph()
	{
		return null;
	}
	
}
