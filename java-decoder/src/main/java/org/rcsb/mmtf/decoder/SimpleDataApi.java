package org.rcsb.mmtf.decoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.rcsb.mmtf.api.DataApiInterface;
import org.rcsb.mmtf.dataholders.BioAssemblyInfoNew;
import org.rcsb.mmtf.dataholders.Entity;
import org.rcsb.mmtf.dataholders.PDBGroup;

public class SimpleDataApi implements DataApiInterface {

	/** The cartn x. */
	private int[] cartnX;

	/** The cartn y. */
	private int[] cartnY;

	/** The cartn z. */
	private int[] cartnZ;

	/** The b factor. */
	private int[] bFactor;

	/** The occupancy arr. */
	private int[] occupancyArr;

	/** The atom id. */
	private int[] atomId;

	/** The alt id. */
	private char[] altId;

	/** The ins code. */
	private char[] insCode;

	/** The group num. */
	private int[] groupNum;

	/** The group map. */
	private Map<Integer, PDBGroup> groupMap;

	/** The group list. */
	private int[] groupList;

	/** The last count. */
	private int lastAtomCount;

	/** The sequence ids of the groups */
	private int[] seqResGroupList;

	/** The internal chain ids*/
	private String[] internalChainIds;

	/** The public facing chain ids*/
	private String[] publicChainIds;

	/** The number of chains per model*/
	private int[] chainsPerModel;

	/** The number of groups per (internal) chain*/
	private int[] groupsPerChain;

	/** The space group of the structure*/
	private String spaceGroup;

	/** The unit cell of the structure*/
	private List<Float> unitCell;

	/** The bioassembly information for the structure*/
	private Map<Integer, BioAssemblyInfoNew> bioAssembly;

	/** The bond indices for bonds between groups*/
	private int[] interGroupBondIndices;

	/** The bond orders for bonds between groups*/
	private int[] interGroupBondOrders;

	/** The chosen list of chain ids */
	private String[] chainList;

	/** The counter for the models */
	private int modelCounter;

	/** The counter for the groups (residues) */
	private int groupCounter;

	/** The counter for the chains */
	private int chainCounter;

	/** The counter for atoms in a group */
	private int atomCounter;

	/** A unique set of lists for each model */
	private Set<String> chainIdSet;

	/** The sequence information. An entry for each chain. In a list.  */
	private List<String> sequenceInfo;

	/** The mmtf version */
	private String mmtfVersion;

	/** The mmtf prodcuer */
	private String mmtfProducer;

	/** A list containing pdb group names for nucleic acids */
	List<String> nucAcidList = new ArrayList<>();

	/** The pdbx_description of a given chain (entity) */
	private String[] chainDescription;

	/** The type of a given chain (entity) */
	private String[] chainType;

  /** The list of entities in this structure. */
  private Entity[] entityList;
	
	/** The PDB id	 */
	private String pdbId;

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getCartnX()
	 */
	@Override
	public int[] getCartnX() {
		return cartnX;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setCartnX(int[])
	 */
	@Override
	public void setCartnX(int[] cartnX) {
		this.cartnX = cartnX;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getCartnY()
	 */
	@Override
	public int[] getCartnY() {
		return cartnY;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setCartnY(int[])
	 */
	@Override
	public void setCartnY(int[] cartnY) {
		this.cartnY = cartnY;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getCartnZ()
	 */
	@Override
	public int[] getCartnZ() {
		return cartnZ;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setCartnZ(int[])
	 */
	@Override
	public void setCartnZ(int[] cartnZ) {
		this.cartnZ = cartnZ;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getbFactor()
	 */
	@Override
	public int[] getbFactor() {
		return bFactor;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setbFactor(int[])
	 */
	@Override
	public void setbFactor(int[] bFactor) {
		this.bFactor = bFactor;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getOccupancyArr()
	 */
	@Override
	public int[] getOccupancyArr() {
		return occupancyArr;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setOccupancyArr(int[])
	 */
	@Override
	public void setOccupancyArr(int[] occupancyArr) {
		this.occupancyArr = occupancyArr;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getAtomId()
	 */
	@Override
	public int[] getAtomId() {
		return atomId;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setAtomId(int[])
	 */
	@Override
	public void setAtomId(int[] atomId) {
		this.atomId = atomId;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getAltId()
	 */
	@Override
	public char[] getAltId() {
		return altId;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setAltId(char[])
	 */
	@Override
	public void setAltId(char[] altId) {
		this.altId = altId;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getInsCode()
	 */
	@Override
	public char[] getInsCode() {
		return insCode;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setInsCode(char[])
	 */
	@Override
	public void setInsCode(char[] insCode) {
		this.insCode = insCode;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getGroupNum()
	 */
	@Override
	public int[] getGroupNum() {
		return groupNum;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setGroupNum(int[])
	 */
	@Override
	public void setGroupNum(int[] groupNum) {
		this.groupNum = groupNum;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getGroupMap()
	 */
	@Override
	public Map<Integer, PDBGroup> getGroupMap() {
		return groupMap;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setGroupMap(java.util.Map)
	 */
	@Override
	public void setGroupMap(Map<Integer, PDBGroup> groupMap) {
		this.groupMap = groupMap;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getGroupList()
	 */
	@Override
	public int[] getGroupList() {
		return groupList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setGroupList(int[])
	 */
	@Override
	public void setGroupList(int[] groupList) {
		this.groupList = groupList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getLastAtomCount()
	 */
	@Override
	public int getLastAtomCount() {
		return lastAtomCount;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setLastAtomCount(int)
	 */
	@Override
	public void setLastAtomCount(int lastAtomCount) {
		this.lastAtomCount = lastAtomCount;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getSeqResGroupList()
	 */
	@Override
	public int[] getSeqResGroupList() {
		return seqResGroupList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setSeqResGroupList(int[])
	 */
	@Override
	public void setSeqResGroupList(int[] seqResGroupList) {
		this.seqResGroupList = seqResGroupList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getInternalChainIds()
	 */
	@Override
	public String[] getInternalChainIds() {
		return internalChainIds;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setInternalChainIds(java.lang.String[])
	 */
	@Override
	public void setInternalChainIds(String[] internalChainIds) {
		this.internalChainIds = internalChainIds;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getPublicChainIds()
	 */
	@Override
	public String[] getPublicChainIds() {
		return publicChainIds;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setPublicChainIds(java.lang.String[])
	 */
	@Override
	public void setPublicChainIds(String[] publicChainIds) {
		this.publicChainIds = publicChainIds;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getChainsPerModel()
	 */
	@Override
	public int[] getChainsPerModel() {
		return chainsPerModel;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setChainsPerModel(int[])
	 */
	@Override
	public void setChainsPerModel(int[] chainsPerModel) {
		this.chainsPerModel = chainsPerModel;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getGroupsPerChain()
	 */
	@Override
	public int[] getGroupsPerChain() {
		return groupsPerChain;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setGroupsPerChain(int[])
	 */
	@Override
	public void setGroupsPerChain(int[] groupsPerChain) {
		this.groupsPerChain = groupsPerChain;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getSpaceGroup()
	 */
	@Override
	public String getSpaceGroup() {
		return spaceGroup;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setSpaceGroup(java.lang.String)
	 */
	@Override
	public void setSpaceGroup(String spaceGroup) {
		this.spaceGroup = spaceGroup;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getUnitCell()
	 */
	@Override
	public List<Float> getUnitCell() {
		return unitCell;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setUnitCell(java.util.List)
	 */
	@Override
	public void setUnitCell(List<Float> unitCell) {
		this.unitCell = unitCell;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getBioAssembly()
	 */
	@Override
	public Map<Integer, BioAssemblyInfoNew> getBioAssembly() {
		return bioAssembly;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setBioAssembly(java.util.Map)
	 */
	@Override
	public void setBioAssembly(Map<Integer, BioAssemblyInfoNew> bioAssembly) {
		this.bioAssembly = bioAssembly;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getInterGroupBondIndices()
	 */
	@Override
	public int[] getInterGroupBondIndices() {
		return interGroupBondIndices;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setInterGroupBondIndices(int[])
	 */
	@Override
	public void setInterGroupBondIndices(int[] interGroupBondIndices) {
		this.interGroupBondIndices = interGroupBondIndices;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getInterGroupBondOrders()
	 */
	@Override
	public int[] getInterGroupBondOrders() {
		return interGroupBondOrders;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setInterGroupBondOrders(int[])
	 */
	@Override
	public void setInterGroupBondOrders(int[] interGroupBondOrders) {
		this.interGroupBondOrders = interGroupBondOrders;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getChainList()
	 */
	@Override
	public String[] getChainList() {
		return chainList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setChainList(java.lang.String[])
	 */
	@Override
	public void setChainList(String[] chainList) {
		this.chainList = chainList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getModelCounter()
	 */
	@Override
	public int getModelCounter() {
		return modelCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setModelCounter(int)
	 */
	@Override
	public void setModelCounter(int modelCounter) {
		this.modelCounter = modelCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getGroupCounter()
	 */
	@Override
	public int getGroupCounter() {
		return groupCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setGroupCounter(int)
	 */
	@Override
	public void setGroupCounter(int groupCounter) {
		this.groupCounter = groupCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getChainCounter()
	 */
	@Override
	public int getChainCounter() {
		return chainCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setChainCounter(int)
	 */
	@Override
	public void setChainCounter(int chainCounter) {
		this.chainCounter = chainCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getAtomCounter()
	 */
	@Override
	public int getAtomCounter() {
		return atomCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setAtomCounter(int)
	 */
	@Override
	public void setAtomCounter(int atomCounter) {
		this.atomCounter = atomCounter;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getChainIdSet()
	 */
	@Override
	public Set<String> getChainIdSet() {
		return chainIdSet;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setChainIdSet(java.util.Set)
	 */
	@Override
	public void setChainIdSet(Set<String> chainIdSet) {
		this.chainIdSet = chainIdSet;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getSequenceInfo()
	 */
	@Override
	public List<String> getSequenceInfo() {
		return sequenceInfo;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setSequenceInfo(java.util.List)
	 */
	@Override
	public void setSequenceInfo(List<String> sequenceInfo) {
		this.sequenceInfo = sequenceInfo;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getMmtfVersion()
	 */
	@Override
	public String getMmtfVersion() {
		return mmtfVersion;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setMmtfVersion(java.lang.String)
	 */
	@Override
	public void setMmtfVersion(String mmtfVersion) {
		this.mmtfVersion = mmtfVersion;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getMmtfProducer()
	 */
	@Override
	public String getMmtfProducer() {
		return mmtfProducer;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setMmtfProducer(java.lang.String)
	 */
	@Override
	public void setMmtfProducer(String mmtfProducer) {
		this.mmtfProducer = mmtfProducer;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getNucAcidList()
	 */
	@Override
	public List<String> getNucAcidList() {
		return nucAcidList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setNucAcidList(java.util.List)
	 */
	@Override
	public void setNucAcidList(List<String> nucAcidList) {
		this.nucAcidList = nucAcidList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getChainDescription()
	 */
	@Override
	public String[] getChainDescription() {
		return chainDescription;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setChainDescription(java.lang.String[])
	 */
	@Override
	public void setChainDescription(String[] chainDescription) {
		this.chainDescription = chainDescription;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getChainType()
	 */
	@Override
	public String[] getChainType() {
		return chainType;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setChainType(java.lang.String[])
	 */
	@Override
	public void setChainType(String[] chainType) {
		this.chainType = chainType;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getEntityList()
	 */
	@Override
	public Entity[] getEntityList() {
		return entityList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setEntityList(org.rcsb.mmtf.dataholders.Entity[])
	 */
	@Override
	public void setEntityList(Entity[] entityList) {
		this.entityList = entityList;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#getPdbId()
	 */
	@Override
	public String getPdbId() {
		return pdbId;
	}

	/* (non-Javadoc)
	 * @see org.rcsb.mmtf.decoder.DataApiInterface#setPdbId(java.lang.String)
	 */
	@Override
	public void setPdbId(String pdbId) {
		this.pdbId = pdbId;
	}

}