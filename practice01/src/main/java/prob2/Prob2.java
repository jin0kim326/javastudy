package prob2;

public class Prob2 {
	public static void main(String[] args) {
		int count = 1;
		
		while(count<=10) {
			int count2 = count;
			int max = count+10;
			while(count2< max) {
				System.out.print(count2 + " ");
				count2++;
			}
			System.out.println("");
			count++;
		}
	}
}
