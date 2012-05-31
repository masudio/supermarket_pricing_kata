

public class Money implements IAmCurrency
{
	private int dollars;
	private int cents;
	
	private Money(int dollars,int cents)
	{
		this.dollars = dollars;
		this.cents = cents;
	}
	
	@Override
	public IAmCurrency add(IAmCurrency addend)
	{
		int dollars = this.dollars + addend.getDollars();
		dollars += (this.cents + addend.getCents()) / 100;
		int cents = (this.cents + addend.getCents()) % 100;
		
		return Money.create(dollars,cents);
	}

	public static IAmCurrency create(int dollars,int cents)
    {
		return new Money(dollars,cents);
    }

	@Override
    public int getDollars()
    {
		return this.dollars;
    }

	@Override
    public int getCents()
    {
		return this.cents;
    }

	@Override
	public boolean equals(IAmCurrency otherMoney)
	{
		return this.dollars == otherMoney.getDollars() && this.cents == otherMoney.getCents();
	}
	
	@Override
	public boolean equals(Object otherMoney)
	{
		return this.equals((IAmCurrency)otherMoney);
	}
}
