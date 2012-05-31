import contracts.IAmAReceipt;
import contracts.IAmCurrency;
import contracts.IGetReceipt;
import contracts.IHoldItems;



public class SuperMarketPricing {

	private IGetReceipt register;
	private IHoldItems basket;

	public SuperMarketPricing(IGetReceipt register,IHoldItems basket)
    {
		this.register = register;
		this.basket = basket;
    }

	public IAmAReceipt getReceipt()
    {
		return register.getReceipt(basket);
    }

	public IAmCurrency getTotal()
    {
		IAmAReceipt receipt = register.getReceipt(basket);
		return receipt.getTotal();
    }
}
