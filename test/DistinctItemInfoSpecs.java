import static org.junit.Assert.*;

import org.junit.Test;

import contracts.IAmCurrency;
import contracts.IAmInfoForADistinctItem;
import contracts.Item;


public class DistinctItemInfoSpecs
{
	private IAmInfoForADistinctItem sut;

	@Test
	public void whenAskedForThePrice_andQuantityIsLessThanRequiredForTheDeal_shouldReturnRegularPriceTimesQuantity()
	{
		IAmCurrency expectedResult = Money.create(2, 0);
		sut = new DistinctItemInfo(Item.TOMATO, Money.create(0, 50), 5,
		        Money.create(2, 25));

		IAmCurrency result = sut.getPriceFor(4);

		assertEquals(expectedResult, result);
	}

	@Test
	public void whenAskedForThePrice_andQuantityIsEqualToTheQuantityRequiredForTheDeal_shouldReturnTheDealPrice()
	{
		IAmCurrency expectedResult = Money.create(2, 25);
		sut = new DistinctItemInfo(Item.TOMATO, Money.create(0, 50), 5,
		        Money.create(2, 25));

		IAmCurrency result = sut.getPriceFor(5);
		
		assertEquals(expectedResult,result);
	}
	
	@Test
	public void whenAskedForThePrice_andQuantityIsMoreThanRequiredForTheDeal_shouldReturnCorrectCalculationForPrice()
	{
		IAmCurrency expectedResult = Money.create(5, 0);
		sut = new DistinctItemInfo(Item.TOMATO, Money.create(0, 50), 5,
		        Money.create(2, 25));

		IAmCurrency result = sut.getPriceFor(11);
		
		assertEquals(expectedResult,result);
	}
}
