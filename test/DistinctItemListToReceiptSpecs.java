import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.Iterator;

import org.junit.Test;


public class DistinctItemListToReceiptSpecs
{
	private IConvertDistinctItemListToReceipt sut;
	
	@Test
	public void whenConvertToReceiptIsCalled_shouldReturnAReceipt()
	{
		IHoldDistinctItems mockDistinctItemList = mock(IHoldDistinctItems.class);
		sut = new DistinctItemListToReceipt();
		
		IAmAReceipt result = sut.convertToReceipt(mockDistinctItemList);
		
		assertNotNull(result);
	}
}
