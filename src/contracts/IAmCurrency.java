package contracts;


public interface IAmCurrency
{
	IAmCurrency add(IAmCurrency addend);
	int getDollars();
	int getCents();
	boolean equals(IAmCurrency otherMoney);
}
