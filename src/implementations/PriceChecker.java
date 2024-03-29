package implementations;

import contracts.IAmADistinctItem;
import contracts.IAmCurrency;
import contracts.IHoldDistinctItems;
import contracts.IHoldPrices;
import contracts.IPriceItemLists;

public class PriceChecker implements IPriceItemLists
{
	private IHoldPrices priceHolder;

	public PriceChecker(IHoldPrices priceHolder)
	{
		this.priceHolder = priceHolder;
	}

	@Override
	public IAmCurrency getTotalFor(IHoldDistinctItems items)
	{
		IAmCurrency result = Money.create(0, 0);

		for(Object item : items)
		{
			result = result.add(priceHolder
			        .getPriceFor((IAmADistinctItem) item));
		}

		return result;
	}
}
