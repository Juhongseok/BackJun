package BackJun.DP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class selfNumber {

	public static void main(String[] args) {
		int number = 1;
		int count = 0;
		List<Integer> listForDelete = new ArrayList<Integer>();

		while (number <= 10000) {
			count = 0;
			int tNumber = number++;
			int temp = tNumber;
			while (true) {
				try {
					int plus = Character.getNumericValue(String.valueOf(temp).charAt(count++));
					tNumber += plus;
				} catch (Exception e) {
					break;
				}
			}
			if (!listForDelete.contains(tNumber))
				listForDelete.add(tNumber);
		}

		Collections.sort(listForDelete);

		int i = 1;
		for(;i<10000; ++i) {
			if(listForDelete.contains(i))
				continue;
			else
				System.out.println(i);
		}
	}

}
