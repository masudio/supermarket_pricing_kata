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
		sut = new SuperMarketPricing(mockRegister, null, mockBasket);

		IAmAReceipt result = sut.getReceipt();

		assertEquals(expectedResult, result);
	}
	
	@Test
	public void whenAskedForBillTotal_ShouldCallGetTotalOnCalculator()
	{
		ICalculateTotal mockCalculator = mock(ICalculateTotal.class);
		IHoldItems mockBasket = mock(IHoldItems.class);
		IAmCurrency expectedResult = mock(IAmCurrency.class);
		stub(mockCalculator.getTotal(mockBasket)).toReturn(expectedResult);
		sut = new SuperMarketPricing(null, mockCalculator, mockBasket);

		IAmCurrency result = sut.getTotal();

		assertEquals(expectedResult, result);
	}
}
