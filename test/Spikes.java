import static org.junit.Assert.assertEquals;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

public class Spikes
{

	@Test
	public void test()
	{
		AbstractMap sut = new HashMap();
		Object key1 = new Object();
		Object key2 = new Object();
		sut.put(key1, 1);
		sut.put(key2, 1);

		Set result = sut.keySet();
		Collection valueResult = sut.values();
		for(Object object : result)
		{
			sut.get(object);
		}
		assertEquals(2, result.size());
		assertEquals(2, valueResult.size());
	}

}
