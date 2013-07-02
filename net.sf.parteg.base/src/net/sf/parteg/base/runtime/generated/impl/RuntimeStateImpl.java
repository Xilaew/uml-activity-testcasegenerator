/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.runtime.generated.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import net.sf.parteg.base.runtime.generated.GeneratedPackage;
import net.sf.parteg.base.runtime.generated.RuntimeState;
import net.sf.parteg.base.testcasegraph.generated.TCGNode;
import net.sf.parteg.base.testcasegraph.generated.TestCaseRegion;
import net.sf.parteg.base.testcasegraph.helperclasses.TCGNodeHelperClass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runtime State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RuntimeStateImpl extends EObjectImpl implements RuntimeState {

	/**
	 * @generated NOT
	 */
	private HashMap<TestCaseRegion, TCGNode> m_colRegionsToNodes; 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected RuntimeStateImpl() {
		super();
		m_colRegionsToNodes = new HashMap<TestCaseRegion, TCGNode>();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratedPackage.Literals.RUNTIME_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TCGNode getActiveNode(TestCaseRegion region) {
		return m_colRegionsToNodes.get(region);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setActiveNode(TCGNode node) {
		m_colRegionsToNodes.put(TCGNodeHelperClass.getContainingRegion(node), node);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void removeNodeFromState(TCGNode node) {
		for(Entry<TestCaseRegion, TCGNode> entry : m_colRegionsToNodes.entrySet())
		{
			if(entry.getValue().equals(node))
			{
				m_colRegionsToNodes.remove(entry.getKey());
				return;
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Set<TestCaseRegion> getAllRegions() {
		return m_colRegionsToNodes.keySet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Collection<TCGNode> getAllActiveNodes() {
		return m_colRegionsToNodes.values();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isInitialState() {
		for(TCGNode oNode : m_colRegionsToNodes.values())
		{
			// not is initial state
			if(!TCGNodeHelperClass.isTopmostInitialNode(oNode))
				return false;
		}
		return true;
	}

} //RuntimeStateImpl
