package implementations;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import contracts.IAmADistinctItem;
import contracts.IAmInfoForADistinctItem;
import contracts.Item;

public class DistinctItemToDistinctItemInfoMap extends
        AbstractMap<IAmADistinctItem,IAmInfoForADistinctItem>
{
	private Map<Item,IAmInfoForADistinctItem> map;

	public DistinctItemToDistinctItemInfoMap(
	        Map<Item,IAmInfoForADistinctItem> map)
	{
		this.map = map;
	}

	@Override
	public void clear()
	{
		map.clear();
	}

	@Override
	public boolean containsKey(Object arg0)
	{
		return map.containsKey(arg0);
	}

	@Override
	public boolean containsValue(Object arg0)
	{
		return map.containsValue(arg0);
	}

	@Override
	public Set<java.util.Map.Entry<IAmADistinctItem,IAmInfoForADistinctItem>> entrySet()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public IAmInfoForADistinctItem get(Object arg0)
	{
		return map.get(((IAmADistinctItem) arg0).getItem().getItem());
	}

	@Override
	public boolean isEmpty()
	{
		return map.isEmpty();
	}

	@Override
	public Set<IAmADistinctItem> keySet()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public IAmInfoForADistinctItem put(IAmADistinctItem distinctItem,
	        IAmInfoForADistinctItem distinctItemInfo)
	{
		return map.put(distinctItem.getItem().getItem(), distinctItemInfo);
	}

	@Override
	public void putAll(
	        Map<? extends IAmADistinctItem,? extends IAmInfoForADistinctItem> arg0)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public IAmInfoForADistinctItem remove(Object arg0)
	{
		return map.remove(((IAmADistinctItem) arg0).getItem().getItem());
	}

	@Override
	public int size()
	{
		return map.size();
	}

	@Override
	public Collection<IAmInfoForADistinctItem> values()
	{
		return map.values();
	}

}
