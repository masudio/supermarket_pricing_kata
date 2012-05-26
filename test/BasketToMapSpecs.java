import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.AbstractMap;

import org.junit.Test;


public class BasketToMapSpecs
{
	private IConvertBasketToMap sut;
	
	@Test
	public void whenPassedABasket_shouldConvertItToAMap()
	{
		IHoldItems mockBasket = mock(IHoldItems.class);
		IAmAnItem mockItem1 = mock(IAmAnItem.class);
		IAmAnItem mockItem2 = mock(IAmAnItem.class);
		stub(mockBasket.hasNext()).toReturn(true).toReturn(true).toReturn(false);
		stub(mockBasket.next()).toReturn(mockItem1).toReturn(mockItem2);
		sut = new BasketToMap();
		
		AbstractMap result = sut.convert(mockBasket);
		
		assertEquals(2, result.size());
	}

}
