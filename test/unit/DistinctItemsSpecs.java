package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import implementations.AnItem;
import implementations.DistinctItems;

import java.util.Iterator;

import org.junit.Test;

import contracts.IAmADistinctItem;
import contracts.IAmAnItem;
import contracts.IHoldDistinctItems;
import contracts.Item;


public class DistinctItemsSpecs
{
	private IHoldDistinctItems sut;

	@Test
	public void whenANewItemIsAdded_shouldIncrementListSize()
	{
		IAmAnItem item = AnItem.create(Item.TOMATO);
		IAmAnItem item2 = AnItem.create(Item.CRACKERS);
		sut = DistinctItems.create();

		sut.add(item, 3);
		int result = sut.numberOfDistinctItems();

		assertEquals(1, result);

		sut.add(item2, 1);
		result = sut.numberOfDistinctItems();

		assertEquals(2, result);
		
		sut.add(item2, 3);
		result = sut.numberOfDistinctItems();
		
		assertEquals(2, result);
	}
	
	@Test
	public void whenANewItemIsAdded_andItIsAlreadyThere_shouldAddTheQuantityOfTheAddedItemToTheCorrectEntry()
	{
		IAmAnItem item = AnItem.create(Item.TOMATO);
		IAmAnItem item2 = AnItem.create(Item.CRACKERS);
		sut = DistinctItems.create();

		sut.add(item, 3);
		int result = sut.numberOfDistinctItems();

		assertEquals(1, result);

		sut.add(item2, 1);
		result = sut.numberOfDistinctItems();

		assertEquals(2, result);
		
		sut.add(item2, 3);
		
		for(Object element : sut)
        {
	        IAmADistinctItem distinctItem = (IAmADistinctItem)element;
	        if(distinctItem.getItem().equals(item2))
	        {
	        	result = distinctItem.getQuantity();
	        	assertEquals(4,result);
	        }
        }
	}

	@Test
	public void whenAskedForIterator_shouldReturnNotNull()
	{
		sut = DistinctItems.create();
		
		Iterator result = sut.iterator();
		
		assertNotNull(result);
	}
}
