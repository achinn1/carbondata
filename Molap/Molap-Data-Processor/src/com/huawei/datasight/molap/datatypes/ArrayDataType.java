package com.huawei.datasight.molap.datatypes;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.pentaho.di.core.exception.KettleException;

import com.huawei.unibi.molap.keygenerator.KeyGenException;
import com.huawei.unibi.molap.keygenerator.KeyGenerator;
import com.huawei.unibi.molap.surrogatekeysgenerator.csvbased.MolapCSVBasedDimSurrogateKeyGen;

public class ArrayDataType implements GenericDataType {
	
	private GenericDataType children;
	
	private String name;
	
	private String parentname;
	
	private int outputArrayIndex;
	
	private int dataCounter;
	
	@Override
	public void addChildren(GenericDataType children) {
		if(this.getName().equals(children.getParentname()))
		{
			this.children = children;
		}
		else
		{
			this.children.addChildren(children);
		}
	}
	public ArrayDataType(String name, String parentname)
	{
		this.name = name;
		this.parentname = parentname;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setParentname(String parentname) {
		this.parentname = parentname;
		
	}

	@Override
	public String getParentname() {
		return parentname;
	}
	
	@Override
	public void getAllPrimitiveChildren(List<GenericDataType> primitiveChild) {
		if (children instanceof PrimitiveDataType) 
		{
			primitiveChild.add(children);
		}
		else
		{
			children.getAllPrimitiveChildren(primitiveChild);
		}
	}
	
	
	@Override
	public int getSurrogateIndex() {
		return 0;
	}

	@Override
	public void setSurrogateIndex(int surrIndex) {
		
	}
	@Override
	public void parseStringAndWriteByteArray(String tableName, String inputString,
			String[] delimiter, int delimiterIndex,
			DataOutputStream dataOutputStream,
			MolapCSVBasedDimSurrogateKeyGen surrogateKeyGen)
			throws KettleException, IOException {
		
		if(inputString == null || inputString.equals("null"))
		{
			//Indicates null array
			dataOutputStream.writeInt(0);
		}
		else
		{
			String[] splitInput = inputString.split(delimiter[delimiterIndex]);
			dataOutputStream.writeInt(splitInput.length);
			delimiterIndex = (delimiter.length - 1) == delimiterIndex ? delimiterIndex : delimiterIndex + 1;
			for(String eachInput: splitInput)
			{
				children.parseStringAndWriteByteArray(tableName, eachInput, delimiter, delimiterIndex, dataOutputStream, surrogateKeyGen);
			}
		}
	}
	
	@Override
	public void parseAndBitPack(ByteBuffer byteArrayInput, DataOutputStream dataOutputStream, KeyGenerator[] generator) throws IOException, KeyGenException
	{
		int dataLength = byteArrayInput.getInt();
		
		dataOutputStream.writeInt(dataLength);
		if(children instanceof PrimitiveDataType)
		{
			dataOutputStream.writeInt(generator[children.getSurrogateIndex()].getKeySizeInBytes());
		}
		for(int i=0;i<dataLength;i++)
		{
			children.parseAndBitPack(byteArrayInput, dataOutputStream, generator);
		}
		
	}
	@Override
	public int getColsCount() {
		return children.getColsCount() + 1;
	}
	
	@Override
	public void setOutputArrayIndex(int outputArrayIndex) {
		this.outputArrayIndex = outputArrayIndex;
		children.setOutputArrayIndex(outputArrayIndex + 1);
	}
	
	@Override
	public int getMaxOutputArrayIndex()
	{
		int currentMax = outputArrayIndex;
		int childMax = children.getMaxOutputArrayIndex();
		if(childMax > currentMax)
		{
			currentMax = childMax;
		}
		return currentMax;
	}
	
	@Override
	public void getColumnarDataForComplexType(
			List<ArrayList<byte[]>> columnsArray, ByteBuffer inputArray) {
		ByteBuffer b = ByteBuffer.allocate(8);
		int dataLength = inputArray.getInt();
		b.putInt(dataLength);
		if(dataLength == 0)
		{
			b.putInt(0);
		}
		else
		{
			b.putInt(children.getDataCounter());
		}
		columnsArray.get(this.outputArrayIndex).add(b.array());

		if(children instanceof PrimitiveDataType)
		{
			((PrimitiveDataType) children).setKeySize(inputArray.getInt());
		}
		for(int i=0;i<dataLength;i++)
		{
			children.getColumnarDataForComplexType(columnsArray, inputArray);
		}
		this.dataCounter++;
	}
	
	@Override
	public int getDataCounter()
	{
		return this.dataCounter;
	}
	
	@Override
	public void fillAggKeyBlock(List<Boolean> aggKeyBlockWithComplex, boolean[] aggKeyBlock)
	{
		aggKeyBlockWithComplex.add(false);
		children.fillAggKeyBlock(aggKeyBlockWithComplex,aggKeyBlock);
	}
	
	@Override
	public void fillBlockKeySize(List<Integer> blockKeySizeWithComplex, int[] primitiveBlockKeySize)
	{
		blockKeySizeWithComplex.add(8);
		children.fillBlockKeySize(blockKeySizeWithComplex, primitiveBlockKeySize);
	}
	
	@Override
	public void fillCardinalityAfterDataLoad(List<Integer> dimCardWithComplex, int[] maxSurrogateKeyArray)
	{
		dimCardWithComplex.add(0);
		children.fillCardinalityAfterDataLoad(dimCardWithComplex, maxSurrogateKeyArray);
	}
	
}
