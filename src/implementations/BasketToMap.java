package implementations;

import java.util.AbstractMap;
import java.util.HashMap;

import contracts.IAmAnItem;
import contracts.IConvertBasketToMap;
import contracts.IHoldItems;

public class BasketToMap implements IConvertBasketToMap
{
	@Override
	public AbstractMap convert(IHoldItems basket)
	{
		AbstractMap<IAmAnItem,Integer> map = new HashMap();
		IAmAnItem item;
		for(Object element : basket)
		{
			item = (IAmAnItem) element;
			if(null == map.get(item)) map.put(item, 1);
			else map.put(item, map.get(item) + 1);
		}

		return map;
	}
}
