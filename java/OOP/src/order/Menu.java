package order;

public class Menu {

	String name;
	String size;
	Double price;
	int qty;

	public Menu(String name, String size, Double price) {
		super();
		this.name = name;
		this.size = size;
		this.price = price; // 인스턴스 변수, 멤버변수, 누적-상태유지
	}
	public double getTotal() {
		return this.price * this.qty;
	}

	@Override
	public String toString() {
		return this.name + this.size + this.price;
	}
}