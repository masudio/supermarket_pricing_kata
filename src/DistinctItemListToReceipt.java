
public class DistinctItemListToReceipt implements IConvertDistinctItemListToReceipt
{

	@Override
	public IAmAReceipt convertToReceipt(IHoldDistinctItems distinctItemList)
	{
		return Receipt.createFrom(distinctItemList);
	}

}
