package net.dovale.web.swoogleParser.model;

/**
 * 
 * @author Raphael
 * 
 */
public class KeyValuePair
{
	/**
	 * @return the key
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey( String key )
	{
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue( String value )
	{
		this.value = value;
	}

	String key;
	String value;

}
