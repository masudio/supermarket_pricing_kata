

public class Register implements IGetReceipt
{
	private IConvertDistinctItemListToReceipt receiptFormatter;
	private IConvertBasketToItemList itemTally;

	public Register(IConvertBasketToItemList itemTally,
            IConvertDistinctItemListToReceipt receiptFormatter)
    {
		this.itemTally = itemTally;
		this.receiptFormatter = receiptFormatter;
    }

	@Override
	public IAmAReceipt getReceipt(IHoldItems basket)
	{
		return receiptFormatter.convertToReceipt(itemTally.convertToDistinctItemList(basket));
	}
}
