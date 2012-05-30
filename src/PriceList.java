import java.util.AbstractMap;


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
		return (IAmCurrency)((IAmInfoForADistinctItem)map.get(distinctItem)).getPriceFor(distinctItem);
	}

}
