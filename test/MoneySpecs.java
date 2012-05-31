import static org.junit.Assert.*;

import org.junit.Test;

import contracts.IAmCurrency;

import static org.mockito.Mockito.*;

public class MoneySpecs
{
	private IAmCurrency sut;
	
	@Test
	public void whenOneMoneyIsAddedToAnother_shouldReturnTheValueOfTheSum()
	{
		IAmCurrency otherMoney = Money.create(5, 60);
		IAmCurrency expectedResult = Money.create(8,10);
		sut = Money.create(2,50);
		
		IAmCurrency result = sut.add(otherMoney);
		
		assertEquals(expectedResult,result);
	}
}
