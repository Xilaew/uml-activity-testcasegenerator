package experimental;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexpTest {

	public static void main(String[] argv) throws Exception {

		CharSequence inputStr = "jacop 3.2: exit code 1";
		String patternStr = "\\s+exit\\s+code\\s+(\\-?\\d+)";
//		String patternStr = "\\s*(\\d+)\\s+((-?\\d+\\.?\\d*)|NaN)";

		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(inputStr);
		//boolean matchFound = matcher.matches();

		while (matcher.find()) {
			// Get all groups for this match
			for (int i = 0; i <= matcher.groupCount(); i++) {
				// Get the group's captured text
				String groupStr = matcher.group(i);
				if (groupStr!= null && groupStr.equals("NaN")){
					
				}else{
				}
				System.out.println(i +":="+groupStr);
			}
		}
	}
}
