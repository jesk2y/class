
public class AutoEx {
	public static void main(String[] args) {
		int a = 10;
		int b = a++;
		
		int sum = a++ + ++b + ++a;
		
		System.out.println(sum);
		
	}
}
