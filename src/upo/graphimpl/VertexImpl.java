package upo.graphimpl;

import java.util.Iterator;

import upo.graph.Graph;
import upo.graph.Vertex;

public class VertexImpl extends Vertex
{

	public VertexImpl(String label)
	{
		super(label);
	}

	@Override
	public Iterator<Vertex> iterator()
	{
		return null;
	}

	@Override
	public Graph getGraph()
	{
		return null;
	}

}
