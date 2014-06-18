package aop.hello;

public class StoreImpl implements Store {

	@Override
	public double purchaseItem(String item) {
		int length = item.length();
		double price = length * Math.random() * 5;
		System.out.println(item + " costs " + price);
		return price;
		
		
	}
}
