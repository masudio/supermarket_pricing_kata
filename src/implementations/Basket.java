package implementations;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import contracts.IHoldItems;
import contracts.Item;



public class Basket implements IHoldItems
{
	private Collection items;
	private Iterator iterator;
	
	private Basket(Item[] items)
	{
		this.items = new LinkedList();
		
		for(int i = 0; i < items.length; i++)
        {
	        this.items.add(AnItem.create(items[i]));
        }
		
		this.iterator = this.items.iterator();
	}
	
	@Override
	public boolean hasNext()
	{
		return this.iterator.hasNext();
	}

	@Override
	public Object next()
	{
		return this.iterator.next();
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}

	public static IHoldItems create(Item[] items)
    {
		return new Basket(items);
    }

}
