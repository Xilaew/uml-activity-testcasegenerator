package basics;

import java.util.LinkedHashSet;
import java.util.Set;

public class CustomTests {

	public static void main(String[] args)
	{
		Set<Integer> colNumbers = new LinkedHashSet<Integer>();
		colNumbers.add(1);
		colNumbers.add(11);
		for(Integer oNum : colNumbers)
		{
			if(oNum < 10)
				colNumbers.add(oNum + 1);
		}
		int x = 42;
		++x;
	}
}
