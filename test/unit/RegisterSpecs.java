package unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import implementations.Register;

import org.junit.Test;

import contracts.IAmAReceipt;
import contracts.IConvertBasketToItemList;
import contracts.IConvertDistinctItemListToReceipt;
import contracts.IGetReceipt;
import contracts.IHoldDistinctItems;
import contracts.IHoldItems;


public class RegisterSpecs
{
	private IGetReceipt sut;
	
	@Test
	public void whenAskedForReceipt_shouldReturnReceipt()
	{
		IConvertBasketToItemList mockItemTally = mock(IConvertBasketToItemList.class);
		IConvertDistinctItemListToReceipt mockReceiptFormatter = mock(IConvertDistinctItemListToReceipt.class);
		IHoldItems mockBasket = mock(IHoldItems.class);
		IAmAReceipt expectedResult = mock(IAmAReceipt.class);
		IHoldDistinctItems itemList = mock(IHoldDistinctItems.class);
		stub(mockItemTally.convertToDistinctItemList(mockBasket)).toReturn(itemList);
		stub(mockReceiptFormatter.convertToReceipt(itemList)).toReturn(expectedResult);
		sut = new Register(mockItemTally, mockReceiptFormatter);
		
		IAmAReceipt result = sut.getReceipt(mockBasket);
		
		assertEquals(expectedResult, result);
	}
}
