import java.util.Arrays;

public class BubbleSorter {
	
	public static void sortAll(int[] arr) {
		
		for(int i = 0; i < arr.length -1; i++) {
		
			sortOnce(arr, i + 1);
		}
	}

	public static void sortOnce(int[] arr, int count) {
		
		int temp = arr[0];
		
		for(int i = 0, len = arr.length - count; i < len; i++ ) {
			
			System.out.println("temp: " + temp  + " vs "  + arr[i+1]);
			
			if(temp > arr[i + 1]) {
				System.out.println("need swap");
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				temp = arr[i +1]; 
			}else {
				temp = arr[i + 1];
			}

			System.out.println(Arrays.toString(arr));
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] testArr =  {1,3,7,34,32,200,46,4,22,5,32,56,6,74,100};
		
		sortAll(testArr);
		
		System.out.println("=================================");
		System.out.println(Arrays.toString(testArr));
		
	}
}