package implementations;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import contracts.IHoldItems;
import contracts.Item;

public class Basket implements IHoldItems
{
	private Collection items;

	private Basket(Item[] items)
	{
		this.items = new LinkedList();

		for(int i = 0; i < items.length; i++)
		{
			this.items.add(AnItem.create(items[i]));
		}
	}

	public static IHoldItems create(Item[] items)
	{
		return new Basket(items);
	}

	@Override
	public Iterator iterator()
	{
		return items.iterator();
	}
}
