package contracts;


public interface IConvertBasketToItemList
{
	IHoldDistinctItems convertToDistinctItemList(IHoldItems mockBasket);
}
