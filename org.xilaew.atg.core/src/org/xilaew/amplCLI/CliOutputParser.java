/**
 * 
 */
package org.xilaew.amplCLI;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author th51e0
 * 
 */
public class CliOutputParser {
	
	
	protected CliOutputParser(CLI cli) {
		super();
		this.cli = cli;
	}

	CLI cli;

	void readParameter(Map<String,Integer> param) {
		final String parameter = "^(\\w+)\\s=\\s(-?\\d+)$";
		Pattern p = Pattern.compile(parameter);
		Matcher matcher = p.matcher(cli.readLine());
		param.put(matcher.group(1), Integer.parseInt(matcher.group(2)));
	}
}
