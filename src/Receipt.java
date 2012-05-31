import contracts.IAmAReceipt;
import contracts.IAmCurrency;
import contracts.IHoldDistinctItems;
import contracts.IPriceItemLists;



public class Receipt implements IAmAReceipt
{
	private IHoldDistinctItems distinctItemList;
	private IPriceItemLists priceChecker;
	
	private Receipt(IHoldDistinctItems distinctItemList, IPriceItemLists priceChecker)
	{
		this.distinctItemList = distinctItemList;
		this.priceChecker = priceChecker;
	}
	
	@Override
	public IAmCurrency getTotal()
	{
		return priceChecker.getTotalFor(distinctItemList);
	}
	
	public static IAmAReceipt createFrom(IHoldDistinctItems distinctItemList, IPriceItemLists priceChecker)
	{
		return new Receipt(distinctItemList,priceChecker);
	}
	
	public static IAmAReceipt createFrom(IHoldDistinctItems distinctItemList)
	{
		return createFrom(distinctItemList, new PriceChecker(null)/* might wanna find a better way than instantiating here */);
	}
}
