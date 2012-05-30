import java.util.AbstractMap;
import java.util.HashMap;

public class BasketToItemList implements IConvertBasketToItemList
{
	private IConvertMapToItemList mapToItemList;
	private IConvertBasketToMap basketToMap;

	public BasketToItemList(IConvertBasketToMap basketToMap,
            IConvertMapToItemList mapToItemList)
    {
		this.basketToMap = basketToMap;
		this.mapToItemList = mapToItemList;
    }

	@Override
	public IHoldDistinctItems convertToDistinctItemList(IHoldItems basket)
	{
		return mapToItemList.convert(basketToMap.convert(basket));
	}
}