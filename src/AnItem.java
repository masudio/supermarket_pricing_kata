
public class AnItem implements IAmAnItem
{
	private Item item;

	private AnItem(Item item)
	{
		this.item = item;
		
	}
	
	@Override
	public boolean equals(IAmAnItem other)
	{
		return item.equals(other.getItem());
	}

	public static IAmAnItem create(Item item)
    {
		return new AnItem(item);
    }

	@Override
    public Item getItem()
    {
		return item;
    }

	@Override
	public int hashCode()
	{
		return item.hashCode();
	}
}
