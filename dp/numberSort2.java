package BackJun.DP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class numberSort2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = scan.nextInt();
		List<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<N; ++i)
			arr.add(scan.nextInt());
		
		Collections.sort(arr);
		for(int i : arr)
			sb.append(i + "\n");
		System.out.println(sb);
		scan.close();
	}

}