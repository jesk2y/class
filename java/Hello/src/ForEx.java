
public class ForEx {
	public static void main(String[] args) {
		int i = 0;
		
		int j = 0;
		loop1: while (i < 10) {
			System.out.println(i);
			loop2: while (j < 10) {
				
				if (i == 5 && j == 5) {
					System.out.print(i + "x" + j + "=" + i * j + "\t");
					break loop1;
				}
				j++;
			}
			i++;
		}

	}
}
