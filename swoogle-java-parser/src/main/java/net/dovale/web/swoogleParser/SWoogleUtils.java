package net.dovale.web.swoogleParser;

import java.io.InputStream;

import net.dovale.web.swoogleParser.model.KeyValuePair;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * 
 * @author Raphael
 * 
 */
public class SWoogleUtils
{
	private static String DEFAULT_ENCODE = "UTF-8";

	private static String SWOOGLE_API_URL = "http://sparql.cs.umbc.edu:80/swoogle31/q";

	private static String SWOOGLE_API_QUERY_TYPE_PARAM = "queryType";

	private static String SWOOGLE_API_KEY_PARAM = "key";

	private static String SWOOGLE_API_KEY_VALUE = "demo";

	public String runQuery( String queryType, KeyValuePair... values )
	{
		try
		{
			HttpClient httpClient = new DefaultHttpClient();

			URIBuilder uriBulder = new URIBuilder( SWOOGLE_API_URL );
			uriBulder.setParameter( SWOOGLE_API_QUERY_TYPE_PARAM, queryType );
			uriBulder.setParameter( SWOOGLE_API_KEY_PARAM,
					SWOOGLE_API_KEY_VALUE );
			for ( KeyValuePair keyValuePair : values )
			{
				uriBulder.setParameter( keyValuePair.getKey(),
						keyValuePair.getValue() );

			}
			HttpGet get = new HttpGet( uriBulder.build() );
			HttpResponse response = httpClient.execute( get );
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			String responseData = IOUtils.toString( content );
			return responseData;
		}
		catch ( Throwable t )
		{
			String message = String
					.format( "Error while trying to process a query." );
			throw new RuntimeException( message, t );
		}

	}

	private SWoogleUtils()
	{
		// Singleton constructor, nothing at the moment
	}

	private static SWoogleUtils instance = new SWoogleUtils();

	/**
	 * 
	 * @return
	 */
	public static SWoogleUtils getInstance()
	{
		return instance;
	}
}
