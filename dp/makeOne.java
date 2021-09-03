package BackJun.DP;
import java.util.Scanner;

public class makeOne {

	static int d[];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		d = new int[num+1];
		d[1] = 0;
		
		for(int i=2; i<=num; ++i) {
			d[i] = d[i-1] + 1;
			
			if(i%3 == 0)
				d[i] = Math.min(d[i], d[i/3]+1);
			if(i%2 == 0)
				d[i] = Math.min(d[i], d[i/2]+1);
		}
		System.out.println(d[num]);
		scan.close();
	}
	
	static int cal(int num) {
		if (num <= 1)
			return 0;
		if(d[num] > 0)
			return d[num];
		
		d[num] = cal(num-1) + 1;
		
		if(num%3 == 0) {
			int temp = cal(num/3)+1;
			if(d[num] > temp) 
				d[num] = temp;
		}
		else if(num%2 == 0) {
			int temp = cal(num/2)+1;
			if(d[num] > temp) 
				d[num] = temp;
		}
		
		return d[num];
	}

}
