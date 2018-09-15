import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] arr = {3,2,214,32,4,43}; //인트의 배열의 리모콘이 담김
		int[] arr2 = arr; //리모콘이 복제됨 -> 레퍼런싱 카운트가 2개가 됨
		//레퍼런싱 카운팅이 0인걸 삭제하는게 가비지 콜력터
		System.out.println(arr);
		System.out.println(arr2);
		System.out.println(arr==arr2);  // "arr상자의 내용물과 arr2상자에 있는 내용물"이 같다(값비교 x)
		arr[0] = 100;
		System.out.println(arr2[0]);

		
		System.out.println(arr.length);
		
		System.out.println(Arrays.toString(arr));
	
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		for(int i = 0, len = arr.length; i < len; i++) {
			System.out.println(arr[i]);
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
		Arrays.stream(arr).forEach(x->System.out.println(x));
	}
}
