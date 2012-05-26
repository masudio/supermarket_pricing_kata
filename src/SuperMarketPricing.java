
public class SuperMarketPricing {

	private IGetReceipt register;
	private IHoldItems basket;
	private ICalculateTotal calculator;

	public SuperMarketPricing(IGetReceipt register,ICalculateTotal calculator, IHoldItems basket)
    {
		this.register = register;
		this.calculator = calculator;
		this.basket = basket;
    }

	public IAmAReceipt getReceipt()
    {
		return register.getReceipt(basket);
    }

	public IAmCurrency getTotal()
    {
		return calculator.getTotal(basket);
    }
}
