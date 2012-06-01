package unit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import implementations.DistinctItemListToReceipt;

import org.junit.Test;

import contracts.IAmAReceipt;
import contracts.IConvertDistinctItemListToReceipt;
import contracts.IHoldDistinctItems;
import contracts.IPriceItemLists;


public class DistinctItemListToReceiptSpecs
{
	private IConvertDistinctItemListToReceipt sut;
	
	@Test
	public void whenConvertToReceiptIsCalled_shouldReturnAReceipt()
	{
		IHoldDistinctItems mockDistinctItemList = mock(IHoldDistinctItems.class);
		IPriceItemLists priceChecker = mock(IPriceItemLists.class);
		sut = new DistinctItemListToReceipt(priceChecker);
		
		IAmAReceipt result = sut.convertToReceipt(mockDistinctItemList);
		
		assertNotNull(result);
	}
}
