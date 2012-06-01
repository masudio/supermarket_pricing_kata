package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import implementations.DistinctItem;

import org.junit.Test;

import contracts.IAmADistinctItem;
import contracts.IAmAnItem;

public class DistinctItemSpecs
{
	private IAmADistinctItem sut;

	@Test
	public void whenEqualityComparedToAnotherItemOfSameType_shouldReturnTrue()
	{
		IAmAnItem mockItem1 = mock(IAmAnItem.class);
		IAmAnItem mockItem2 = mock(IAmAnItem.class);
		IAmADistinctItem mockDistinctOther = DistinctItem.create(mockItem2, 1);
		stub(mockItem1.equals(mockItem2)).toReturn(true);
		sut = DistinctItem.create(mockItem1, 1);

		boolean result = sut.equals(mockDistinctOther);

		assertTrue(result);
	}

	@Test
	public void whenEqualityComparedToAnotherItemOfDifferentType_shouldReturnFalse()
	{
		IAmAnItem mockItem1 = mock(IAmAnItem.class);
		IAmAnItem mockItem2 = mock(IAmAnItem.class);
		IAmADistinctItem mockDistinctOther = DistinctItem.create(mockItem2, 1);
		stub(mockItem1.equals(mockItem2)).toReturn(false);
		sut = DistinctItem.create(mockItem1, 1);

		boolean result = sut.equals(mockDistinctOther);

		assertFalse(result);
	}

	@Test
	public void whenQuantityAdded_shouldAddGivenQuantity()
	{
		IAmAnItem mockItem1 = mock(IAmAnItem.class);
		IAmAnItem mockItem2 = mock(IAmAnItem.class);
		sut = DistinctItem.create(mockItem1, 1);

		sut.add(5);
		int result = sut.getQuantity();

		assertEquals(6, result);
	}
}
