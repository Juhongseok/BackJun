package BackJun.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class godOfNumber {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int max;
	static String[] numlist;
	static String answer = "";

	public static void main(String[] args) throws IOException {
		setData();

		for (String s : numlist)
			System.out.println(s);
		getMaxValue();
		System.out.println(answer);
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		numlist = new String[K];
		for (int i = 0; i < K; i++) {
			String sv = br.readLine();
			int value = Integer.parseInt(sv);

			if (max < value)
				max = value;
			numlist[i] = sv;
		}

		Arrays.sort(numlist, (o1, o2)-> 
				 (o2 + o1).compareTo(o1 + o2));

	}

	private static void getMaxValue() {
		boolean flag = false;
		for (int i = 0; i < K; i++) {
			answer += numlist[i];
			if (max == Integer.parseInt(numlist[i]) && flag == false) {
				flag = true;
				for (int j = 0; j < (N - K); j++) {
					answer += numlist[i];
				}
			}
		}
	}
}
