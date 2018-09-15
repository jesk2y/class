import java.util.Arrays;

public class new2 {
public static void main(String[] args) {
		
		int[] balls = new int[45];
		
		for (int i = 0; i < balls.length; i++) {
			balls[i] = i+1;
		}
		System.out.println(Arrays.toString(balls));
		
		
		for(int i = 0; i < 6; i++) {
			
			int idx = (int)(Math.random() * (balls.length -i));
			
			//System.out.println("idx: " + idx);
			//1
			int value = balls[idx];
			//System.out.println("value: " + value);
			
			int end = balls[ balls.length -i - 1];
			System.out.println("end: " + end);
			
			balls[idx] = end;
			balls[ balls.length -i - 1] = value;
			
			System.out.println(Arrays.toString(balls));
		}
}
}
