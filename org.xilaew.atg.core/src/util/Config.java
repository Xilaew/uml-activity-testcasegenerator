/**
 * 
 */
package util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author TH51E0
 * 
 */
public class Config {
	private static Properties defaultProps = new Properties();
	
	static {
		try {
			FileInputStream in = new FileInputStream("custom.properties");
			defaultProps.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return defaultProps.getProperty(key);
	}

}
