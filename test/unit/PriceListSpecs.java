package unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import implementations.PriceList;

import java.util.AbstractMap;

import org.junit.Test;

import contracts.IAmADistinctItem;
import contracts.IAmCurrency;
import contracts.IAmInfoForADistinctItem;
import contracts.IHoldPrices;



public class PriceListSpecs
{
	private IHoldPrices sut;
	
	@Test
	public void whenAskedForThePriceOfAnItem_andThatItemIsPresent_shouldReturnTheCorrectPrice()
	{
		AbstractMap mockMap = mock(AbstractMap.class);
		IAmInfoForADistinctItem mockItemInfo = mock(IAmInfoForADistinctItem.class);
		IAmADistinctItem mockDistinctItem = mock(IAmADistinctItem.class);
		IAmCurrency expectedResult = mock(IAmCurrency.class);
		stub(mockDistinctItem.getQuantity()).toReturn(5);
		stub(mockMap.get(mockDistinctItem)).toReturn(mockItemInfo);
		stub(mockItemInfo.getPriceFor(5)).toReturn(expectedResult);
		sut = new PriceList(mockMap);
		
		IAmCurrency result = sut.getPriceFor(mockDistinctItem);
		
		assertEquals(expectedResult, result);
	}
	
	@Test(expected=NullPointerException.class)
	public void whenAskedForThePriceOfAnItem_andThatItemIsNotPresent_shouldThrowAnException()
	{
		AbstractMap mockMap = mock(AbstractMap.class);
		IAmInfoForADistinctItem mockItemInfo = null;
		IAmADistinctItem mockDistinctItem = mock(IAmADistinctItem.class);
		IAmCurrency expectedResult = mock(IAmCurrency.class);
		stub(mockDistinctItem.getQuantity()).toReturn(5);
		stub(mockMap.get(mockDistinctItem)).toReturn(mockItemInfo);
		stub(mockItemInfo.getPriceFor(5)).toReturn(expectedResult);
		sut = new PriceList(mockMap);
		
		IAmCurrency result = sut.getPriceFor(mockDistinctItem);
	}
}
