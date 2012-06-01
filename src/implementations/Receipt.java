package implementations;

import contracts.IAmADistinctItem;
import contracts.IAmAReceipt;
import contracts.IAmCurrency;
import contracts.IHoldDistinctItems;
import contracts.IPriceItemLists;

public class Receipt implements IAmAReceipt
{
	private IHoldDistinctItems distinctItemList;
	private IPriceItemLists priceChecker;

	private Receipt(IHoldDistinctItems distinctItemList,
	        IPriceItemLists priceChecker)
	{
		this.distinctItemList = distinctItemList;
		this.priceChecker = priceChecker;
	}

	@Override
	public IAmCurrency getTotal()
	{
		return priceChecker.getTotalFor(distinctItemList);
	}

	public static IAmAReceipt createFrom(IHoldDistinctItems distinctItemList,
	        IPriceItemLists priceChecker)
	{
		return new Receipt(distinctItemList, priceChecker);
	}

	@Override
	public String toString()
	{
		String result = "";

		for(Object element : this.distinctItemList)
		{
			IAmADistinctItem distinctItem = (IAmADistinctItem) element;
			result += distinctItem.getQuantity() + " "
			        + distinctItem.getItem().getItem().toString() + "\n";
		}

		return result;
	}
}
