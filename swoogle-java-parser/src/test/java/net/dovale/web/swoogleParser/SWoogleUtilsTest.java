package net.dovale.web.swoogleParser;

import net.dovale.web.swoogleParser.model.KeyValuePair;

import org.junit.Test;

public class SWoogleUtilsTest
{

	@Test
	public void testRunQuery()
	{
		SWoogleUtils instance = SWoogleUtils.getInstance();
		KeyValuePair keyValue = new KeyValuePair();
		keyValue.setKey( "searchString" );
		keyValue.setValue( "http://xmlns.com/foaf/0.1/Person" );

		String result = instance.runQuery( "digest_swt", keyValue );
		System.out.println( result );
	}

}
