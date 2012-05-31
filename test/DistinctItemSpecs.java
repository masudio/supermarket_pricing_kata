import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import org.junit.Test;


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
}
