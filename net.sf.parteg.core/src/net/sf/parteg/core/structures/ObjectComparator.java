package net.sf.parteg.core.structures;

import java.util.Collection;


public class ObjectComparator {
	
	public static boolean equals(Object in_oObject1, Object in_oObject2) {
		// shortcut for equal objects
		if(in_oObject1 == in_oObject2)
			return true;

		if(in_oObject1 != null) {
			return in_oObject1.equals(in_oObject2); 
		} else {
			return (in_oObject2 == null);
		}
	}
	
	public static boolean contains(Collection<? extends Object> in_colObjects,
			Object in_oObject) {
		// shortcut for equal objects
		if(in_colObjects.contains(in_oObject))
			return true;

		for(Object oObject : in_colObjects) {
			if(oObject.equals(in_oObject))
				return true;
		}
		return false;
	}
	
	public static Object getEqualObject(Collection<? extends Object> in_colObjects,
			Object in_oObject) {
		for(Object oObject : in_colObjects) {
			if(oObject.equals(in_oObject))
				return oObject;
		}
		return null;		
	}
	

}
