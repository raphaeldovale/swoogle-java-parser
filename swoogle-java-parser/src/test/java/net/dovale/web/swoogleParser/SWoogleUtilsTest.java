package net.dovale.web.swoogleParser;

import org.junit.Test;

public class SWoogleUtilsTest
{

	@Test
	public void testDiggestTerm()
	{
		SWoogleUtils instance = SWoogleUtils.getInstance();

		instance.diggestTerm( "http://xmlns.com/foaf/0.1/Person" );

	}

}
