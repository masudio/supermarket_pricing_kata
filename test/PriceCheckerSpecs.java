import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class PriceCheckerSpecs
{
	private IPriceItemLists sut;
	
	@Test
	public void whenAskedForPriceListPrice_looksUpPriceOfEachItemInPriceListAndReturnsTheSum()
	{
		IHoldPrices mockPriceHolder = mock(IHoldPrices.class);
		IHoldDistinctItems mockDistinctItems = mock(IHoldDistinctItems.class);
		IAmADistinctItem mockDistinctItem1 = mock(IAmADistinctItem.class);
		IAmADistinctItem mockDistinctItem2 = mock(IAmADistinctItem.class);
		Iterator mockIterator = mock(Iterator.class);
		IAmCurrency money1 = Money.create(5,60);
		IAmCurrency money2 = Money.create(2,50);
		IAmCurrency expectedResult = Money.create(8,10);
		stub(mockDistinctItems.iterator()).toReturn(mockIterator);
		stub(mockIterator.hasNext()).toReturn(true).toReturn(true).toReturn(false);
		stub(mockIterator.next()).toReturn(mockDistinctItem1).toReturn(mockDistinctItem2);
		stub(mockPriceHolder.getPriceFor(mockDistinctItem1)).toReturn(money1);
		stub(mockPriceHolder.getPriceFor(mockDistinctItem2)).toReturn(money2);
		sut = new PriceChecker(mockPriceHolder);
		
		IAmCurrency result = sut.getTotalFor(mockDistinctItems);
		
		assertEquals(expectedResult, result);
	}
}
