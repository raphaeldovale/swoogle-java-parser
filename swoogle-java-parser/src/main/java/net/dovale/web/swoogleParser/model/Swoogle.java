package net.dovale.web.swoogleParser.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root( name = "rdf:RDF", strict = false )
public class Swoogle
{
	@Element( name = "QueryResponse" )
	private SwoogleQueryResponse queryResponse;

	/**
	 * @return the queryResponse
	 */
	public SwoogleQueryResponse getQueryResponse()
	{
		return queryResponse;
	}

	/**
	 * @param queryResponse
	 *            the queryResponse to set
	 */
	public void setQueryResponse( SwoogleQueryResponse queryResponse )
	{
		this.queryResponse = queryResponse;
	}
}
