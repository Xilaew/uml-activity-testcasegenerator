/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.sf.parteg.base.testcasetree.generated;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variable Classification</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.sf.parteg.base.testcasetree.generated.GeneratedPackage#getVariableClassification()
 * @model
 * @generated
 */
public enum VariableClassification implements Enumerator {
	/**
	 * The '<em><b>Active Dependent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_DEPENDENT_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE_DEPENDENT(0, "activeDependent", "activeDependent"),

	/**
	 * The '<em><b>Independent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDEPENDENT_VALUE
	 * @generated
	 * @ordered
	 */
	INDEPENDENT(1, "independent", "independent"),

	/**
	 * The '<em><b>Input Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPUT_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	INPUT_PARAMETER(2, "inputParameter", "inputParameter"),

	/**
	 * The '<em><b>Passive Dependent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASSIVE_DEPENDENT_VALUE
	 * @generated
	 * @ordered
	 */
	PASSIVE_DEPENDENT(3, "passiveDependent", "passiveDependent"),

	/**
	 * The '<em><b>Unknown</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(4, "unknown", "unknown");

	/**
	 * The '<em><b>Active Dependent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active Dependent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_DEPENDENT
	 * @model name="activeDependent"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_DEPENDENT_VALUE = 0;

	/**
	 * The '<em><b>Independent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Independent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDEPENDENT
	 * @model name="independent"
	 * @generated
	 * @ordered
	 */
	public static final int INDEPENDENT_VALUE = 1;

	/**
	 * The '<em><b>Input Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Input Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPUT_PARAMETER
	 * @model name="inputParameter"
	 * @generated
	 * @ordered
	 */
	public static final int INPUT_PARAMETER_VALUE = 2;

	/**
	 * The '<em><b>Passive Dependent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Passive Dependent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PASSIVE_DEPENDENT
	 * @model name="passiveDependent"
	 * @generated
	 * @ordered
	 */
	public static final int PASSIVE_DEPENDENT_VALUE = 3;

	/**
	 * The '<em><b>Unknown</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unknown</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model name="unknown"
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN_VALUE = 4;

	/**
	 * An array of all the '<em><b>Variable Classification</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VariableClassification[] VALUES_ARRAY =
		new VariableClassification[] {
			ACTIVE_DEPENDENT,
			INDEPENDENT,
			INPUT_PARAMETER,
			PASSIVE_DEPENDENT,
			UNKNOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>Variable Classification</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<VariableClassification> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variable Classification</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableClassification get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableClassification result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Classification</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableClassification getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableClassification result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Classification</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableClassification get(int value) {
		switch (value) {
			case ACTIVE_DEPENDENT_VALUE: return ACTIVE_DEPENDENT;
			case INDEPENDENT_VALUE: return INDEPENDENT;
			case INPUT_PARAMETER_VALUE: return INPUT_PARAMETER;
			case PASSIVE_DEPENDENT_VALUE: return PASSIVE_DEPENDENT;
			case UNKNOWN_VALUE: return UNKNOWN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VariableClassification(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //VariableClassification
