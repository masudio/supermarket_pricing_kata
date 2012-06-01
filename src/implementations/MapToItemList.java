package implementations;
import java.util.AbstractMap;
import java.util.Set;

import contracts.IConvertMapToItemList;
import contracts.IHoldDistinctItems;



public class MapToItemList implements IConvertMapToItemList
{

	@Override
	public IHoldDistinctItems convert(AbstractMap map)
	{
		Set keySet = map.keySet();
		IHoldDistinctItems itemList = DistinctItems.create();
		
		for(Object item : keySet)
        {
	        itemList.add(item, map.get(item));
        }
		
		return itemList;
	}

}
