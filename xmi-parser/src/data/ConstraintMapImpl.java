package data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;

public class ConstraintMapImpl implements ConstraintMap {

	private Map<Element, EList<Constraint>> map = new HashMap<Element, EList<Constraint>>();

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public Set<java.util.Map.Entry<Element, EList<Constraint>>> entrySet() {
		return map.entrySet();
	}

	public Set<Element> keySet() {
		return map.keySet();
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public boolean equals(Object o) {
		return map.equals(o);
	}

	public EList<Constraint> get(Object key) {
		return map.get(key);
	}

	public int hashCode() {
		return map.hashCode();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public EList<Constraint> put(ActivityNode key, EList<Constraint> value) {
		return map.put(key, value);
	}

	public EList<Constraint> remove(Object key) {
		return map.remove(key);
	}

	public int size() {
		return map.size();
	}

	public Collection<EList<Constraint>> values() {
		return map.values();
	}

	public EList<Constraint> put(Element key, EList<Constraint> value) {
		return map.put(key, value);
	}

	public void putAll(Map<? extends Element, ? extends EList<Constraint>> m) {
		map.putAll(m);
	}

	@Override
	public void put(Element node, Constraint constraint) {
		if(map.containsKey(node)){
			map.get(node).add(constraint);
		}else{
			@SuppressWarnings({ "serial" })
			EList<Constraint> l = new BasicEList<Constraint>(){
				protected boolean isUnique(){
					return true;
				}
			};
			map.put(node, l);
		}
		
	}

	

}
