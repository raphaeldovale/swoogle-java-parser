package net.dovale.web.swoogleParser;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.dovale.web.swoogleParser.model.KeyValuePair;
import net.dovale.web.swoogleParser.model.Swoogle;
import net.dovale.web.swoogleParser.model.SwoogleQueryResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

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

	private String runQuery( String queryType, KeyValuePair... values )
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

	public Map< String, SwoogleQueryResponse > diggestTerm(
			List< String > termList )
	{
		Map< String, SwoogleQueryResponse > resultMap = new TreeMap< String, SwoogleQueryResponse >();
		for ( String term : termList )
		{
			SwoogleQueryResponse diggestTerm = diggestTerm( term );
			resultMap.put( term, diggestTerm );
		}

		return resultMap;
	}

	public SwoogleQueryResponse diggestTerm( String term )
	{
		KeyValuePair keyValuePair = new KeyValuePair();
		keyValuePair.setKey( "searchString" );
		keyValuePair.setValue( term );
		String result = runQuery( "digest_swd", keyValuePair );

		try
		{
			Serializer serializer = new Persister();
			Swoogle swoogle = serializer.read( Swoogle.class, result );
			return swoogle.getQueryResponse();
		}
		catch ( Exception e )
		{
			System.out.println( e );
			e.printStackTrace();
		}
		return null;
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
