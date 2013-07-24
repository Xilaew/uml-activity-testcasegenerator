package util;

import java.util.HashSet;

public class Output {
	
	public static boolean ERROR = true;
	public static boolean WARN = true;
	public static boolean DEBUG = true;
	public static boolean MESSAGE = true;
	public static HashSet<Class<?>> debugClasses= new HashSet<Class<?>>();
	

	public static void message(String messageCode){
		if(MESSAGE){
			System.out.println(Messages.getString("Message."+messageCode));
		}
	}
	
	public static void error(String messageCode){
		if(ERROR){
			System.err.println(Messages.getString("Error."+messageCode));
		}
	}
	
	public static void warn(String messageCode){
		if(WARN){
			System.out.println(Messages.getString("Warn."+messageCode));
		}
	}
	
	public static void debug(String message, Object sender){
		if(DEBUG){
			System.out.println(sender.getClass().getName()+": "+message);
		}
	}

}
