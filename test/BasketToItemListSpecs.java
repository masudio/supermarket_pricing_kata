import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.AbstractMap;

import org.junit.Test;

import contracts.IConvertBasketToItemList;
import contracts.IConvertBasketToMap;
import contracts.IConvertMapToItemList;
import contracts.IHoldDistinctItems;
import contracts.IHoldItems;


public class BasketToItemListSpecs
{
	private IConvertBasketToItemList sut;

	@Test
	public void whenPassedABasketObject_shouldConvertItToAnItemList()
	{
		IConvertBasketToMap basketToMap = mock(IConvertBasketToMap.class);
		IConvertMapToItemList mapToItemList = mock(IConvertMapToItemList.class);
		IHoldItems mockBasket = mock(IHoldItems.class);
		AbstractMap mockMap = mock(AbstractMap.class);
		IHoldDistinctItems expectedResult = mock(IHoldDistinctItems.class);
		stub(basketToMap.convert(mockBasket)).toReturn(mockMap);
		stub(mapToItemList.convert(mockMap)).toReturn(expectedResult);
		sut = new BasketToItemList(basketToMap, mapToItemList);

		IHoldDistinctItems result = sut.convertToDistinctItemList(mockBasket);

		assertEquals(expectedResult, result);
	}
}
