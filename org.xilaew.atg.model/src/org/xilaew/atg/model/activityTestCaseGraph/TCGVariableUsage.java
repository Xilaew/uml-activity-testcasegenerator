/**
 */
package org.xilaew.atg.model.activityTestCaseGraph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>TCG Variable Usage</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.xilaew.atg.model.activityTestCaseGraph.ActivityTestCaseGraphPackage#getTCGVariableUsage()
 * @model
 * @generated
 */
public enum TCGVariableUsage implements Enumerator {
	/**
	 * The '<em><b>In Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	IN_PARAMETER(0, "inParameter", "inParameter"),

	/**
	 * The '<em><b>Out Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUT_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	OUT_PARAMETER(1, "outParameter", "outParameter"),

	/**
	 * The '<em><b>Inout Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INOUT_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	INOUT_PARAMETER(2, "inoutParameter", "inoutParameter"),

	/**
	 * The '<em><b>Return Parameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_PARAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN_PARAMETER(3, "returnParameter", "returnParameter"),

	/**
	 * The '<em><b>Field</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	FIELD(5, "field", "field"), /**
	 * The '<em><b>Local Variable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOCAL_VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	LOCAL_VARIABLE(4, "localVariable", "localVariable");

	/**
	 * The '<em><b>In Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>In Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IN_PARAMETER
	 * @model name="inParameter"
	 * @generated
	 * @ordered
	 */
	public static final int IN_PARAMETER_VALUE = 0;

	/**
	 * The '<em><b>Out Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Out Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OUT_PARAMETER
	 * @model name="outParameter"
	 * @generated
	 * @ordered
	 */
	public static final int OUT_PARAMETER_VALUE = 1;

	/**
	 * The '<em><b>Inout Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inout Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INOUT_PARAMETER
	 * @model name="inoutParameter"
	 * @generated
	 * @ordered
	 */
	public static final int INOUT_PARAMETER_VALUE = 2;

	/**
	 * The '<em><b>Return Parameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Return Parameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RETURN_PARAMETER
	 * @model name="returnParameter"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_PARAMETER_VALUE = 3;

	/**
	 * The '<em><b>Field</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Field</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIELD
	 * @model name="field"
	 * @generated
	 * @ordered
	 */
	public static final int FIELD_VALUE = 5;

	/**
	 * The '<em><b>Local Variable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Local Variable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOCAL_VARIABLE
	 * @model name="localVariable"
	 * @generated
	 * @ordered
	 */
	public static final int LOCAL_VARIABLE_VALUE = 4;

	/**
	 * An array of all the '<em><b>TCG Variable Usage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TCGVariableUsage[] VALUES_ARRAY =
		new TCGVariableUsage[] {
			IN_PARAMETER,
			OUT_PARAMETER,
			INOUT_PARAMETER,
			RETURN_PARAMETER,
			FIELD,
			LOCAL_VARIABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>TCG Variable Usage</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TCGVariableUsage> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>TCG Variable Usage</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TCGVariableUsage get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TCGVariableUsage result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TCG Variable Usage</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TCGVariableUsage getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TCGVariableUsage result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>TCG Variable Usage</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TCGVariableUsage get(int value) {
		switch (value) {
			case IN_PARAMETER_VALUE: return IN_PARAMETER;
			case OUT_PARAMETER_VALUE: return OUT_PARAMETER;
			case INOUT_PARAMETER_VALUE: return INOUT_PARAMETER;
			case RETURN_PARAMETER_VALUE: return RETURN_PARAMETER;
			case FIELD_VALUE: return FIELD;
			case LOCAL_VARIABLE_VALUE: return LOCAL_VARIABLE;
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
	private TCGVariableUsage(int value, String name, String literal) {
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
	
} //TCGVariableUsage
