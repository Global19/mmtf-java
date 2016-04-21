package org.rcsb.mmtf.encoder;

import java.util.ArrayList;
import java.util.List;

import org.rcsb.mmtf.api.StructureDataInterface;
import org.rcsb.mmtf.dataholders.BioAssemblyData;
import org.rcsb.mmtf.dataholders.BioAssemblyTransformation;
import org.rcsb.mmtf.dataholders.Entity;
import org.rcsb.mmtf.dataholders.Group;
import org.rcsb.mmtf.utils.CodecUtils;

/**
 * A class of static utility functions to add encoding of data.
 * @author Anthony Bradley
 *
 */
public class EncoderUtils {

	/**
	 * Regenerate a group map from the decoded data interface.
	 * @param mmtfDecodedDataInterface the input interface
	 * @return a list of all the groups in the molecule
	 */
	public static Group[] generateGroupMap(StructureDataInterface mmtfDecodedDataInterface) {
		int[] groupTypeIndices = mmtfDecodedDataInterface.getGroupTypeIndices();
		int maxIndex = CodecUtils.findMaxInIntArray(groupTypeIndices);
		Group[] outGroupList = new Group[maxIndex+1];
		for (int i=0; i<maxIndex+1; i++) {
			// Generate this PDBGroup
			Group pdbGroup = new Group();
			pdbGroup.setAtomChargeList(mmtfDecodedDataInterface.getGroupAtomCharges(i));
			pdbGroup.setAtomNameList(mmtfDecodedDataInterface.getGroupAtomNames(i));
			pdbGroup.setBondAtomList(mmtfDecodedDataInterface.getGroupBondIndices(i));
			pdbGroup.setBondOrderList(mmtfDecodedDataInterface.getGroupBondOrders(i));
			pdbGroup.setChemCompType(mmtfDecodedDataInterface.getGroupChemCompType(i));
			pdbGroup.setElementList(mmtfDecodedDataInterface.getGroupElementNames(i));
			pdbGroup.setGroupName(mmtfDecodedDataInterface.getGroupName(i));
			pdbGroup.setSingleLetterCode(mmtfDecodedDataInterface.getGroupSingleLetterCode(i));
			outGroupList[i] = pdbGroup;
		}
		return outGroupList;
	}

	/**
	 * Find the bioassembly information as a list from the decodeddatainterface.
	 * @param mmtfDecodedDataInterface the interface from where to find the data
	 * @return a list of bioassembly information
	 */
	public static List<BioAssemblyData> generateBioassemblies(StructureDataInterface mmtfDecodedDataInterface) {
		int numBioassemblies = mmtfDecodedDataInterface.getNumBioassemblies();
		List<BioAssemblyData> outList = new ArrayList<>();
		for (int i=0; i<numBioassemblies; i++) {
			BioAssemblyData bioAssemblyData = new BioAssemblyData();
			outList.add(bioAssemblyData);
			List<BioAssemblyTransformation> transformList = new ArrayList<>();
			bioAssemblyData.setTransformList(transformList);
			int numTrans = mmtfDecodedDataInterface.getNumTransInBioassembly(i);
			for (int j=0; j<numTrans; j++) {
				BioAssemblyTransformation bioAssemblyTrans = new BioAssemblyTransformation();
				transformList.add(bioAssemblyTrans);
				bioAssemblyTrans.setChainIndexList(
						mmtfDecodedDataInterface.getChainIndexListForTransform(i, j));
				bioAssemblyTrans.setMatrix(
						mmtfDecodedDataInterface.getMatrixForTransform(i,j));
			}
		}
		return outList;
	}

	/**
	 * Generate the entity level information from the DecodedDataInterface.
	 * @param mmtfDecodedDataInterface the input interface
	 * @return the list of entities
	 */
	public static Entity[] generateEntityList(StructureDataInterface mmtfDecodedDataInterface) {
		int numEntities =  mmtfDecodedDataInterface.getNumEntities();
		Entity[] outList = new Entity[numEntities];
		for (int i=0; i<numEntities;i++) {
			Entity entity = new Entity();
			entity.setChainIndexList(mmtfDecodedDataInterface.getEntityChainIndexList(i));
			entity.setDescription(mmtfDecodedDataInterface.getEntityDescription(i));
			entity.setSequence(mmtfDecodedDataInterface.getEntitySequence(i));
			entity.setType(mmtfDecodedDataInterface.getEntityType(i));
			outList[i] = entity;
		}
		return outList;
	}

}