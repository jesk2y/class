import java.util.Arrays;

public class SwapEx {
	public static void sortAll(int[] arr) {
		
		for(int j=0; j<arr.length-1; j++){
			if(arr[j] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
			System.out.println(Arrays.toString(arr));
		}
		
		
	}
	public static void main(String[] args) {
		int[] arr = {9,8,7,6,5,4,3,2,1};
		
		for(int i=0, len=arr.length-1; i<len; i++) { 
			sortAll(arr);
		}
		
	}
}
