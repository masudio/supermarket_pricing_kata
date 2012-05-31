import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;


public class SuperMarketPricingSpecs
{
	private SuperMarketPricing sut;

	@Test
	public void whenAskedForBillReceipt_ShouldCallGetReceiptOnRegister()
	{
		IGetReceipt mockRegister = mock(IGetReceipt.class);
		IHoldItems mockBasket = mock(IHoldItems.class);
		IAmAReceipt expectedResult = mock(IAmAReceipt.class);
		stub(mockRegister.getReceipt(mockBasket)).toReturn(expectedResult);
		sut = new SuperMarketPricing(mockRegister, mockBasket);

		IAmAReceipt result = sut.getReceipt();

		assertEquals(expectedResult, result);
	}
	
	@Test
	public void whenAskedForBillTotal_ShouldCallGetTotalOnRegister()
	{
		IGetReceipt mockRegister = mock(IGetReceipt.class);
		IHoldItems mockBasket = mock(IHoldItems.class);
		IAmAReceipt mockReceipt = mock(IAmAReceipt.class);
		IAmCurrency expectedResult = mock(IAmCurrency.class);
		stub(mockRegister.getReceipt(mockBasket)).toReturn(mockReceipt);
		stub(mockReceipt.getTotal()).toReturn(expectedResult);
		sut = new SuperMarketPricing(mockRegister, mockBasket);

		IAmCurrency result = sut.getTotal();

		assertEquals(expectedResult, result);
	}
}
