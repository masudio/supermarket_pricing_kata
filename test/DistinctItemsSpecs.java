import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.Iterator;

import org.junit.Test;

public class DistinctItemsSpecs
{
	private IHoldDistinctItems sut;

	@Test
	public void whenANewItemIsAdded_shouldIncrementListSize()
	{
		IAmAnItem mockItem = mock(IAmAnItem.class);
		IAmAnItem mockItem2 = mock(IAmAnItem.class);
		IAmADistinctItem mockDistinctItem = DistinctItem.create(mockItem, 3);
		IAmADistinctItem mockDistinctItem2 = DistinctItem.create(mockItem2, 1);
		sut = DistinctItems.create();

		sut.add(mockItem, 3);
		int result = sut.numberOfDistinctItems();

		assertEquals(1, result);

		sut.add(mockItem2, 1);
		result = sut.numberOfDistinctItems();

		assertEquals(2, result);
	}

	@Test
	public void whenAskedForIterator_shouldReturnNotNull()
	{
		sut = DistinctItems.create();
		
		Iterator result = sut.iterator();
		
		assertNotNull(result);
	}
}
