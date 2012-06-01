package unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import implementations.MapToItemList;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import contracts.IAmAnItem;
import contracts.IConvertMapToItemList;
import contracts.IHoldDistinctItems;


public class MapToItemListSpecs
{
	private IConvertMapToItemList sut;
	
	@Test
	public void whenPassedAMap_shouldConvertItToAnItemList()
	{
		AbstractMap mockMap = mock(AbstractMap.class);
		Set mockSet = mock(Set.class);
		Iterator mockIterator = mock(Iterator.class);
		Iterator mockValueIterator = mock(Iterator.class);
		IAmAnItem mockItem1 = mock(IAmAnItem.class);
		IAmAnItem mockItem2 = mock(IAmAnItem.class);
		Collection mockCollection = mock(Collection.class);
		stub(mockSet.iterator()).toReturn(mockIterator);
		stub(mockIterator.hasNext()).toReturn(true).toReturn(true).toReturn(false);
		stub(mockIterator.next()).toReturn(mockItem1).toReturn(mockItem2);
		stub(mockMap.keySet()).toReturn(mockSet);
		stub(mockMap.get(mockItem1)).toReturn(1);
		stub(mockMap.get(mockItem2)).toReturn(1);
		
		sut = new MapToItemList();
		
		IHoldDistinctItems result = sut.convert(mockMap);
		
		assertEquals(2, result.numberOfDistinctItems());
	}

}
