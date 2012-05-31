import contracts.IAmAReceipt;
import contracts.IConvertDistinctItemListToReceipt;
import contracts.IHoldDistinctItems;



public class DistinctItemListToReceipt implements IConvertDistinctItemListToReceipt
{

	@Override
	public IAmAReceipt convertToReceipt(IHoldDistinctItems distinctItemList)
	{
		return Receipt.createFrom(distinctItemList);
	}

}
