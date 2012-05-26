
public class Register implements IGetReceipt
{
	private IConvertItemListToReceipt receiptFormatter;
	private IConvertBasketToItemList itemTally;

	public Register(IConvertBasketToItemList itemTally,
            IConvertItemListToReceipt receiptFormatter)
    {
		this.itemTally = itemTally;
		this.receiptFormatter = receiptFormatter;
    }

	@Override
	public IAmAReceipt getReceipt(IHoldItems basket)
	{
		return receiptFormatter.convertToReceipt(itemTally.convertToItemList(basket));
	}
}
