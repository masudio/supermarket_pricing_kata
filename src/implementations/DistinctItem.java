package implementations;
import contracts.IAmADistinctItem;
import contracts.IAmAnItem;


public class DistinctItem implements IAmADistinctItem
{
	private int quantity;
	private IAmAnItem item;

	private DistinctItem(IAmAnItem item,int quantity)
	{
		this.quantity = quantity;
		this.item = item;
	}

	public static IAmADistinctItem create(Object item,Object quantity)
	{
		return new DistinctItem((IAmAnItem) item, (Integer) quantity);
	}

	@Override
	public boolean equals(IAmADistinctItem other)
	{
		return this.item.equals(other.getItem());
	}

	@Override
	public IAmAnItem getItem()
	{
		return item;
	}

	@Override
	public int hashCode()
	{
		return item.hashCode();
	}

	@Override
    public int getQuantity()
    {
		return quantity;
    }

	@Override
    public void add(int quantity)
    {
		this.quantity += quantity;
    }
}
