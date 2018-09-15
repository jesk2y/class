public class Income {
	public static void main(String[] args) {
		float ticket = 5;
		int people = 120;
		float max = 0;
		float best_ticket = 0;
		
		for(int i=0;i<50;i++) {
			
			float income = people * ticket;
			float outcome = (float) (180 + (people * 0.04));
			float total_income = income - outcome;
			
			if (total_income > max){
				max = total_income;
				best_ticket = ticket;
			}
			
			System.out.println(ticket + " " + total_income);
			ticket -= 0.1;
			people += 15;
			
			
		}
		System.out.println(best_ticket + " " + max);
	}
	
}
