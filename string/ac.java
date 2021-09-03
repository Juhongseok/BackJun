/*시간초과 */

package BackJun.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ac {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int arrCount;
		String[] arr = null;
		String arr_ = "";
		int count=0;
		for(int i=0; i<T; ++i) {
			
			String[] func = scan.next().split(""); 
			arrCount = scan.nextInt();
			arr = new String[arrCount];
			arr_ = scan.next();
			arr_ = arr_.replace("[", "").replace("]", "");
			
			arr = arr_.split(",");
			while(count<func.length) {
				if(func[count].equals("R"))
					arr = R(arr);
				else
					arr = D(arr);
				
				count++;
			}
			count = 0;
			if(arr.length == 0)
				System.out.println("error");
			else
			{
				System.out.print("[");
				for(int j=0; j<arr.length; ++j) {
					if(j != arr.length-1)
						System.out.print(arr[j] + ",");
					else
						System.out.print(arr[j]);
				}
				System.out.print("]\n");
			}
			
		}
		scan.close();
		
	}
	static String[] R(String[] s) {
		List<String> list = Arrays.asList(s);
		Collections.reverse(list);
		s = list.toArray(new String[0]);
		return s;
	}
	static String[] D(String[] s) {
		List<String> list = new ArrayList<String>();
		
		if(s.length != 0) {
			for(String temp : s)
				list.add(temp);
			list.remove(0);
		}
		s = list.toArray(new String[0]);
		return s;
	}

}
