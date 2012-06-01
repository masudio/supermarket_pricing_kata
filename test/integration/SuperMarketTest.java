package integration;

import implementations.Basket;
import implementations.BasketToItemList;
import implementations.BasketToMap;
import implementations.DistinctItemInfo;
import implementations.DistinctItemListToReceipt;
import implementations.DistinctItemToDistinctItemInfoMap;
import implementations.MapToItemList;
import implementations.Money;
import implementations.PriceChecker;
import implementations.PriceList;
import implementations.Register;
import implementations.SuperMarketPricing;

import java.util.AbstractMap;
import java.util.HashMap;

import contracts.IAmADistinctItem;
import contracts.IAmInfoForADistinctItem;
import contracts.Item;

public class SuperMarketTest
{
	public static void main(String[] args)
	{
		AbstractMap<Item,IAmInfoForADistinctItem> wrappedMap = new HashMap<Item,IAmInfoForADistinctItem>();
		wrappedMap.put(
		        Item.TOMATO,
		        new DistinctItemInfo(Item.TOMATO, Money.create(0, 50), 3, Money
		                .create(1, 25)));
		wrappedMap.put(Item.CRACKERS,
		        new DistinctItemInfo(Item.CRACKERS, Money.create(3, 99), 3,
		                Money.create(8, 99)));
		AbstractMap<IAmADistinctItem,IAmInfoForADistinctItem> itemPriceMap = new DistinctItemToDistinctItemInfoMap(
		        wrappedMap);

		SuperMarketPricing sut = new SuperMarketPricing(new Register(
		        new BasketToItemList(new BasketToMap(), new MapToItemList()),
		        new DistinctItemListToReceipt(new PriceChecker(new PriceList(itemPriceMap)))), Basket.create(new Item[] {
		        Item.TOMATO, Item.TOMATO, Item.CRACKERS, Item.CRACKERS,
		        Item.TOMATO, Item.CRACKERS }));

		System.out.println("Total: " + sut.getTotal());
		System.out.println("\nYour receipt: " + sut.getReceipt());
	}
}
