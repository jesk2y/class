import java.util.Arrays;

public class LottoEx1 {
	public static boolean checkArray(int[] arr, int target) {
		boolean result = false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == target) {
				result = true;
				break;
			}
		}
		return result;

	}
	public static void main(String[] args) {
		int[] result = new int[6];

		for(int i = 0, len = result.length; i < len; i++) {

			int value = (int)(Math.random()*45) + 1;
			// 바깥에 써도 되지만 안전용으로 안쪽에 씀

			System.out.println(value);

			//중복 체크 필요
			boolean duplicated = checkArray(result,value);

			if(duplicated) {//안의 식이 뭐든간에 true일때만 작동함
				i--;
				continue;
			}

			result[i]  = value;

		}
		System.out.println(Arrays.toString(result));
	}
}
