package contracts;




public interface IAmAnItem
{
	boolean equals(IAmAnItem other);
	Item getItem();
	int hashCode();
}
