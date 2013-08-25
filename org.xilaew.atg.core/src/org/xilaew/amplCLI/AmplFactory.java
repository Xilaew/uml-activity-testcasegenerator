/**
 * 
 */
package org.xilaew.amplCLI;

import java.io.IOException;

/**
 * @author TH51E0
 *
 */
public class AmplFactory {
	
	public static CLI createCLI(){
		CLI result;
		try {
			result = new CLI();
		} catch (IOException e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static CLI createCLI(String runfile){
		CLI result;
		try {
			result = new CLI(runfile);
		} catch (IOException e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}
	
	public static JAMPL createJAMPL(){
		CLI cli = createCLI();
		JAMPL result = null;
		if (cli != null){
			result = new JAMPL();
			result.cli=cli;
		}
		return result;
	}
}
