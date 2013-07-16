package net.dovale.web.swoogleParser.model;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root( name = "SemanticWebDocument", strict = false )
public class SwoogleQueryDocument
{

	/**
	 * @return the datePing
	 */
	public Date getDatePing()
	{
		return datePing;
	}

	/**
	 * @param datePing
	 *            the datePing to set
	 */
	public void setDatePing( Date datePing )
	{
		this.datePing = datePing;
	}

	/**
	 * @return the lastDateModified
	 */
	public Date getLastDateModified()
	{
		return lastDateModified;
	}

	/**
	 * @param lastDateModified
	 *            the lastDateModified to set
	 */
	public void setLastDateModified( Date lastDateModified )
	{
		this.lastDateModified = lastDateModified;
	}

	/**
	 * @return the dateDicovered
	 */
	public Date getDateDicovered()
	{
		return dateDicovered;
	}

	/**
	 * @param dateDicovered
	 *            the dateDicovered to set
	 */
	public void setDateDicovered( Date dateDicovered )
	{
		this.dateDicovered = dateDicovered;
	}

	/**
	 * @return the ontoRank
	 */
	public double getOntoRank()
	{
		return ontoRank;
	}

	/**
	 * @param ontoRank
	 *            the ontoRank to set
	 */
	public void setOntoRank( double ontoRank )
	{
		this.ontoRank = ontoRank;
	}

	@Element( name = "hasDatePing" )
	private Date datePing;
	@Element( name = "hasDateLastmodified" )
	private Date lastDateModified;
	@Element( name = "hasDateDiscovered" )
	private Date dateDicovered;
	@Element( name = "hasOntoRank" )
	private double ontoRank;
	@Attribute( name = "about" )
	private String term;
}
