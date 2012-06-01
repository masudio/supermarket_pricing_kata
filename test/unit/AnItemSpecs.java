package unit;

import static org.junit.Assert.*;
import implementations.AnItem;

import org.junit.Test;

import contracts.IAmAnItem;
import contracts.Item;



public class AnItemSpecs
{
	private IAmAnItem sut;
	
	@Test
	public void whenEqualityCheckedAgainstAnItemWithTheSameEnumeratedTypeConstant_shouldReturnTrue()
	{
		sut = AnItem.create(Item.TOMATO);
		IAmAnItem other = AnItem.create(Item.TOMATO);
		
		boolean result = sut.equals(other);
		
		assertTrue(result);
	}

	@Test
	public void whenEqualityCheckedAgainstAnItemWithADifferentEnumeratedTypeConstant_shouldReturnFalse()
	{
		sut = AnItem.create(Item.TOMATO);
		IAmAnItem other = AnItem.create(Item.CRACKERS);
		
		boolean result = sut.equals(other);
		
		assertFalse(result);
	}
}
