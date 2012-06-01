package implementations;
import java.util.AbstractMap;
import java.util.HashMap;

import contracts.IAmAnItem;
import contracts.IConvertBasketToMap;
import contracts.IHoldItems;


public class BasketToMap implements IConvertBasketToMap
{

	@Override
	public AbstractMap convert(IHoldItems mockBasket)
	{
		AbstractMap<IAmAnItem,Integer> map = new HashMap();
		IAmAnItem item;
		while(mockBasket.hasNext())
		{
			item = (IAmAnItem) mockBasket.next();
			if(null == map.get(item)) map.put(item, 1);
			else map.put(item, map.get(item) + 1);
		}
		
		return map;
	}

}