package implementations;

import contracts.IAmAReceipt;
import contracts.IConvertDistinctItemListToReceipt;
import contracts.IHoldDistinctItems;
import contracts.IPriceItemLists;

public class DistinctItemListToReceipt implements
        IConvertDistinctItemListToReceipt
{
	private IPriceItemLists priceChecker;

	public DistinctItemListToReceipt(IPriceItemLists priceChecker)
	{
		this.priceChecker = priceChecker;
	}

	@Override
	public IAmAReceipt convertToReceipt(IHoldDistinctItems distinctItemList)
	{
		return Receipt.createFrom(distinctItemList, this.priceChecker);
	}
}
