import java.util.HashSet;
import java.util.Set;


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
	    allItems.add(DistinctItem.create(item, quantity));
    }

}
