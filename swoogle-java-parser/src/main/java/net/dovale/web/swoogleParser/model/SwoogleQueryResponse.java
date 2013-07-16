package net.dovale.web.swoogleParser.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root( name = "QueryResponse", strict = false )
public class SwoogleQueryResponse
{
	@Element( name = "hasSearchString" )
	private String searchString;
	@Element( name = "comment" )
	private String comment;
	@Path( "hasResult" )
	@Element( name = "SemanticWebDocument" )
	private SwoogleQueryDocument document;

	/**
	 * @return the searchString
	 */
	public String getSearchString()
	{
		return searchString;
	}

	/**
	 * @param searchString
	 *            the searchString to set
	 */
	public void setSearchString( String searchString )
	{
		this.searchString = searchString;
	}

	/**
	 * @return the comment
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment( String comment )
	{
		this.comment = comment;
	}

}
