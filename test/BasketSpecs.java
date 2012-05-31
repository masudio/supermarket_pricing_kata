import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import contracts.IHoldItems;
import contracts.Item;


public class BasketSpecs
{
	private IHoldItems sut;

	@Test
	public void whenAskedIfHasNext_andItDoes_shouldReturnTrue()
	{
		Item[] items = { Item.TOMATO, Item.CRACKERS, Item.TOMATO,
		        Item.CRACKERS, Item.TOMATO };
		sut = Basket.create(items);
		
		boolean result = sut.hasNext();
		
		assertTrue(result);
	}

	@Test
	public void whenAskedIfHasNext_andItDoesNot_shouldReturnFalse()
	{
		Item[] items = {};
		sut = Basket.create(items);
		
		boolean result = sut.hasNext();
		
		assertFalse(result);
	}
	
	@Test
	public void whenAskedForNext_andItHasNext_shouldReturnSomething()
	{
		Item[] items = { Item.TOMATO, Item.CRACKERS, Item.TOMATO,
		        Item.CRACKERS, Item.TOMATO };
		sut = Basket.create(items);
		
		Object result = sut.next();
		
		assertNotNull(result);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void whenAskedToRemove_shouldThrowException()
	{
		Item[] items = {};
		sut = Basket.create(items);
		
		sut.remove();
	}
}
