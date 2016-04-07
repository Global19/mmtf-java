package org.rcsb.mmtf.dataholders;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Group (residue) level data store.
 * @author Anthony Bradley
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PDBGroup implements Serializable {

  /** Serial id for this version of the format. */
  private static final long serialVersionUID = 2880633780569899800L;

  /** The group name. (e.g. HIS) */
  private String groupName;

  /** The atom names. A list of strings indicating
   * the atom names (e.g. CA for C-alpha). */
  private String[] atomNameList;

  /** The element names. A list of strings indicating
   * the element names (e.g. Ca for Calcium). */
  private String[] elementList;
  
  /** The bond orders. A list of integers indicating the bond orders*/
  private int[] bondOrderList;

  /** The bond indices (in pairs).
   * (e.g. 0,1 means there is bond between atom 0 and 1).*/
  private int[] bondAtomList;

  /** The atom charges. */
  private int[] atomChargeList;

  /** The single letter code. */
  private char singleLetterCode;

  /** A string (taken from the chemical component dictionary) indicating 
   * the type of the group. Corresponds to -> http://mmcif.wwpdb.org/dictionaries/mmcif_pdbx.dic/Items/_chem_comp.type.html
   */
  private String chemCompType;
  
  
  /**
   * Gets the atom info.
   *
   * @return the atom info
   */
  // Generic getter and setter functions
  public String[] getAtomNameList() {
    return atomNameList;
  }

  /**
   * Sets the atom info.
   *
   * @param inputAtomInfo the new atom info
   */
  public void setAtomNameList(String[] inputAtomInfo) {
    this.atomNameList = inputAtomInfo;
  }

  /**
   * Gets the bond orders.
   *
   * @return the bond orders
   */
  public int[] getBondOrderList() {
    return bondOrderList;
  }

  /**
   * Sets the bond orders.
   *
   * @param inputBondOrders the new bond orders
   */
  public void setBondOrderList(int[] inputBondOrders) {
    this.bondOrderList = inputBondOrders;
  }

  /**
   * Gets the bond indices.
   *
   * @return the bond indices
   */
  public int[] getBondAtomList() {
    return bondAtomList;
  }

  /**
   * Sets the bond indices.
   *
   * @param inputBondIndices the new bond indices
   */
  public void setBondAtomList(int[] inputBondIndices) {
    this.bondAtomList = inputBondIndices;
  }

  /**
   * Gets the group name.
   *
   * @return the group name
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * Sets the group name.
   *
   * @param resName the new group name
   */
  public void setGroupName(String resName) {
    this.groupName = resName;
  }

  /**
   * Gets the atom charges.
   *
   * @return the atom charges
   */
  public int[] getAtomChargeList() {
    return atomChargeList;
  }

  /**
   * Sets the atom charges.
   *
   * @param inputAtomCharges the new atom charges
   */
  public void setAtomChargeList(int[] inputAtomCharges) {
    this.atomChargeList = inputAtomCharges;
  }

  /**
   * Gets the single letter code.
   *
   * @return the single letter code
   */
  public char getSingleLetterCode() {
    return singleLetterCode;
  }

  /**
   * Sets the single letter code.
   *
   * @param inputSingleLetterCode the new single letter code
   */
  public void setSingleLetterCode(char inputSingleLetterCode) {
    this.singleLetterCode = inputSingleLetterCode;
  }

  /**
   * @return the groupType - corresponds to _chem_comp.type
   */
  public String getChemCompType() {
    return chemCompType;
  }

  /**
   * @param groupType the groupType (corresponds to _chem_comp.type) to set
   */
  public void setChemCompType(String groupType) {
    this.chemCompType = groupType;
  }

/**
 * @return the elementList
 */
public String[] getElementList() {
	return elementList;
}

/**
 * @param elementList the elementList to set
 */
public void setElementList(String[] elementList) {
	this.elementList = elementList;
}
}
