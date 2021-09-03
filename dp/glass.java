package BackJun.DP;
import java.util.Scanner;

public class glass {
	public static void main(String[] args) {
		int answer;
		int[] number = new int[2];
		init(number);
		answer = number[0];
		while(true) {
			if(getCount(answer) <= number[1])
				break;
			else
				answer++;
		}
		System.out.println(answer-number[0]);
	}
	
	static void init(int[] number) {
		Scanner scan = new Scanner(System.in);
		
		String[] number_ = scan.nextLine().split(" ");
		scan.close();
		number[0] = Integer.parseInt(number_[0]);
		number[1] = Integer.parseInt(number_[1]);
	}
	
	static int getCount(int n) {
		int count = 0;
		while(n > 0) {
			if(n % 2 == 1) 
				count++;
			n /= 2;
		}
		return count;
	}
}
