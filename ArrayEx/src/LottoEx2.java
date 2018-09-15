import java.util.Arrays;

public class LottoEx2 {
	public static void main(String[] args) {
		
		int[] arr = new int[45];
		
		for(int i=0;i<45;i++) {
			arr[i] = i+1;
		}

		for(int i=0;i<6;i++){
			int random = (int)(Math.random()*(45-i));
			int temp = arr[i + random];
			arr[i + random] = arr[i];
			arr[i] = temp;
			System.out.println(arr[i]);
		}
	}
}
