package implementations;
import java.util.AbstractMap;

import contracts.IAmADistinctItem;
import contracts.IAmCurrency;
import contracts.IAmInfoForADistinctItem;
import contracts.IHoldPrices;



public class PriceList implements IHoldPrices
{

	private AbstractMap map;

	public PriceList(AbstractMap map)// should be a map of <IAmADistinctItem,IAmInfoForADistinctItem
    {
		this.map = map;
    }

	@Override
	public IAmCurrency getPriceFor(IAmADistinctItem distinctItem)
	{
		IAmInfoForADistinctItem info = (IAmInfoForADistinctItem)map.get(distinctItem);
		return info.getPriceFor(distinctItem.getQuantity());
//		return (IAmCurrency)((IAmInfoForADistinctItem)map.get(distinctItem)).getPriceFor(distinctItem.getQuantity());
	}

}
