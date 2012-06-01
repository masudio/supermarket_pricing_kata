package implementations;
import contracts.IAmCurrency;
import contracts.IAmInfoForADistinctItem;
import contracts.Item;


public class DistinctItemInfo implements IAmInfoForADistinctItem
{
	private Item item;
	private IAmCurrency regularPrice;
	private int requiredDealQuantity;
	private IAmCurrency dealPrice;

	public DistinctItemInfo(Item item,IAmCurrency regularPrice,
	        int requiredDealQuantity,IAmCurrency dealPrice)
	{
		this.item = item;
		this.regularPrice = regularPrice;
		this.requiredDealQuantity = requiredDealQuantity;
		this.dealPrice = dealPrice;
	}

	@Override
    public IAmCurrency getPriceFor(int quantity)
    {
		IAmCurrency result = Money.create(0,0);
		while(quantity > 0)
		{
			if(quantity >= requiredDealQuantity)
			{
				result = result.add(dealPrice);
				quantity -= requiredDealQuantity;
			}
			else
			{
				result = result.add(regularPrice);
				quantity--;
			}
		}
		
		return result;
    }
}
