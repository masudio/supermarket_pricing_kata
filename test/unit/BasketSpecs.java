package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import implementations.Basket;

import java.util.Iterator;

import org.junit.Test;

import contracts.IHoldItems;
import contracts.Item;

public class BasketSpecs
{
	private IHoldItems sut;

	@Test
	public void whenAskedForIterator_shouldReturnAnIterator()
	{
		sut = Basket.create(new Item[] {});

		Iterator result = sut.iterator();

		assertNotNull(result);
	}

	@Test
	public void whenGivenAnArrayWithACertainNumberOfElements_shouldGetAnIteratorWithThatManyElementsToo()
	{
		sut = Basket.create(new Item[] { Item.TOMATO, Item.TOMATO, Item.TOMATO,
		        Item.CRACKERS });
		int result = 0;

		for(Object element : sut)
		{
			result++;
		}

		assertEquals(4, result);
	}
}
