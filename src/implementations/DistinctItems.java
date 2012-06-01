package implementations;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import contracts.IAmADistinctItem;
import contracts.IHoldDistinctItems;



public class DistinctItems implements IHoldDistinctItems
{
	private Set<IAmADistinctItem> allItems;
	
	private DistinctItems()
	{
		this.allItems = new HashSet<IAmADistinctItem>();
	}
	
	@Override
    public int numberOfDistinctItems()
    {
	    return allItems.size();
    }

	public static IHoldDistinctItems create()
    {
		return new DistinctItems();
    }

	@Override
    public void add(Object item,Object quantity)
    {
		IAmADistinctItem newItem = DistinctItem.create(item, quantity);
		for(IAmADistinctItem distinctItem : allItems)
        {
	        if(distinctItem.equals(newItem))
	        {
	        	distinctItem.add((Integer)quantity);
	        	return;
	        }
        }
		
		allItems.add(newItem);
    }

	@Override
    public Iterator iterator()
    {
		return allItems.iterator();
    }

}
