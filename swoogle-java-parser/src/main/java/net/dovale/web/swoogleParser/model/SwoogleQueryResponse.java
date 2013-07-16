package net.dovale.web.swoogleParser.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root( name = "QueryResponse", strict = false )
public class SwoogleQueryResponse
{
	@Element( name = "hasSearchString", required = false )
	private String searchString;
	@Element( name = "comment", required = false )
	private String comment;
	@Path( "hasResult" )
	@Element( name = "SemanticWebDocument", required = false )
	private SwoogleQueryDocument document;
	@Element( name = "hasErrorMessage", required = false )
	private String errorMessage;

	/**
	 * @return the document
	 */
	public SwoogleQueryDocument getDocument()
	{
		return document;
	}

	/**
	 * @param document
	 *            the document to set
	 */
	public void setDocument( SwoogleQueryDocument document )
	{
		this.document = document;
	}

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

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage( String errorMessage )
	{
		this.errorMessage = errorMessage;
	}

}
