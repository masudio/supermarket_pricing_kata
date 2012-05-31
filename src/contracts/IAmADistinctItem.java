package contracts;


public interface IAmADistinctItem
{
	IAmAnItem getItem();
	boolean equals(IAmADistinctItem other);
	int hashCode();
	int getQuantity();
}
