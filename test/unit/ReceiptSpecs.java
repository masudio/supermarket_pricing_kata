package unit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import implementations.Receipt;

import org.junit.Test;

import contracts.IAmAReceipt;
import contracts.IAmCurrency;
import contracts.IHoldDistinctItems;
import contracts.IPriceItemLists;


public class ReceiptSpecs
{
	private IAmAReceipt sut;

	@Test
	public void whenAskedForTotal_shouldAskPriceCheckerForPrice()
	{
		IPriceItemLists mockPriceChecker = mock(IPriceItemLists.class);
		IAmCurrency expectedResult = mock(IAmCurrency.class);
		IHoldDistinctItems mockItems = mock(IHoldDistinctItems.class);
		stub(mockPriceChecker.getTotalFor(mockItems)).toReturn(expectedResult);
		sut = Receipt.createFrom(mockItems,mockPriceChecker);
		
		IAmCurrency result = sut.getTotal();
		
		assertEquals(expectedResult, result);
	}
}
