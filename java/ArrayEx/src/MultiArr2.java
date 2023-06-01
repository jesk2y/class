import java.util.Arrays;
import java.util.Scanner;

public class MultiArr2 {
	public static void main(String[] args) {
		int[][] arr = new int[123][];

		int value = 1;
		for (int i = 0; i < arr.length; i++) {
			int[] temp = new int[i + 1];

			for (int j = 0; j < temp.length; j++) {
				temp[j] = value++;
			}
			arr[i] = temp;
		}

		for (int[] tempArr : arr) {
			System.out.println(Arrays.toString(tempArr));
		}

//		System.out.println("알고싶은 층을 입력해주세요.");
//		Scanner scanner = new Scanner(System.in);
//		int user = Integer.parseInt(scanner.nextLine());
//
//		for(int i=0; i<arr.length; i++) {
//			int[] temp = new int[i+1];
//			for(int j=0;j<temp.length;j++) {
//				if(arr[i][j] == user) {
//					System.out.println((arr.length-i) + "층 " + (j+1) + "호");
//				}
//			}
//			arr[i] = temp;
//		}

		System.out.println("알고싶은 층을 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		int user = Integer.parseInt(scanner.nextLine());

		int[] temp = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			temp[i] = arr[i][0];
		}

		for (int i = 1; i < arr.length; i++) {
			if (user < temp[i]) {
				System.out.println((arr.length - (i - 1)) + "층 " + (user - temp[i - 1] + 1) + "호");
				break;
			}else {
				System.out.println("1층 " + (user - temp[arr.length-1]+1) + "호");
				break;
			}
		}

	}
}
