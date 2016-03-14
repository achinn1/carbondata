/**
 * 
 */
package com.huawei.unibi.molap.util;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.huawei.unibi.molap.constants.IgnoreDictionary;
import com.huawei.unibi.molap.constants.MolapCommonConstants;

/**
 * This is the utility class for No Dictionary changes.
 * 
 * @author R00903928
 * 
 */
public class RemoveDictionaryUtil
{
    /**
     * Here we are dividing one single object [] into 3 arrays. one for
     * dimensions , one for high card, one for measures.
     * 
     * @param out
     * @param dimArray
     * @param byteBufferArr
     * @param measureArray
     */
    public static void prepareOut(Object[] newOutArr,
            ByteBuffer[] byteBufferArr, Object[] out, int dimCount)
    {

        byte[] nonDictionaryCols = RemoveDictionaryUtil
                .packByteBufferIntoSingleByteArray(byteBufferArr);
        Integer[] dimArray = new Integer[dimCount];
        for(int i = 0;i < dimCount;i++)
        {
            dimArray[i] = (Integer)out[i];
        }

        Double[] measureArray = new Double[out.length - dimCount];
        int index = 0;
        for(int j = dimCount;j < out.length;j++)
        {
            measureArray[index++] = (Double)out[j];
        }

        newOutArr[IgnoreDictionary.DIMENSION_INDEX_IN_ROW.getIndex()] = dimArray;
        newOutArr[IgnoreDictionary.BYTE_ARRAY_INDEX_IN_ROW.getIndex()] = nonDictionaryCols;
        newOutArr[IgnoreDictionary.MEASURES_INDEX_IN_ROW.getIndex()] = measureArray;

    }

    /**
     * This method will form one single byte [] for all the high card dims.
     * 
     * @param byteBufferArr
     * @return
     */
    public static byte[] packByteBufferIntoSingleByteArray(
            ByteBuffer[] byteBufferArr)
    {
        // for empty array means there is no data to remove dictionary.
        if(null == byteBufferArr || byteBufferArr.length == 0)
        {
            return null;
        }
        int noOfCol = byteBufferArr.length;
        short toDetermineLengthOfByteArr = 2;
        short offsetLen = (short)(noOfCol * 2 + toDetermineLengthOfByteArr);
        int totalBytes = calculateTotalBytes(byteBufferArr) + offsetLen;

        ByteBuffer buffer = ByteBuffer.allocate(totalBytes);

        // write the length of the byte [] as first short
        buffer.putShort((short)(totalBytes - toDetermineLengthOfByteArr));
        // writing the offset of the first element.
        buffer.putShort(offsetLen);

        // prepare index for byte []
        for(int index = 0;index < byteBufferArr.length - 1;index++)
        {
            ByteBuffer individualCol = byteBufferArr[index];
            // short lengthOfbytes = individualCol.getShort();
            int noOfBytes = individualCol.capacity();

            buffer.putShort((short)(offsetLen + noOfBytes));
            offsetLen += noOfBytes;
            individualCol.rewind();
        }

        // put actual data.
        for(int index = 0;index < byteBufferArr.length;index++)
        {
            ByteBuffer individualCol = byteBufferArr[index];
            buffer.put(individualCol.array());
        }

        buffer.rewind();
        return buffer.array();

    }

    /**
     * To calculate the total bytes in byte Buffer[].
     * 
     * @param byteBufferArr
     * @return
     */
    private static int calculateTotalBytes(ByteBuffer[] byteBufferArr)
    {
        int total = 0;
        for(int index = 0;index < byteBufferArr.length;index++)
        {
            total += byteBufferArr[index].capacity();
        }
        return total;
    }

    /**
     * Method to check whether entire row is empty or not.
     * 
     * @param row
     * @return
     */
    public static boolean checkAllValuesForNull(Object[] row)
    {
        if(checkNullForDims(row[0]) && checkNullForDouble(row[2])
                && null == row[1])
        {
            return true;
        }
        return false;
    }

    /**
     * To check whether the measures are empty/null
     * 
     * @param object
     * @return
     */
    private static boolean checkNullForDouble(Object object)
    {
        Double[] measures = (Double[])object;
        for(Double measure : measures)
        {
            if(null != measure)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * To check whether the dimensions are empty/null
     * 
     * @param object
     * @return
     */
    private static boolean checkNullForDims(Object object)
    {
        Integer[] dimensions = (Integer[])object;
        for(Integer dimension : dimensions)
        {
            if(null != dimension)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Method to get the required Dimension from obj []
     * 
     * @param index
     * @param row
     * @return
     */
    public static Integer getDimension(int index, Object[] row)
    {

        Integer[] dimensions = (Integer[])row[IgnoreDictionary.DIMENSION_INDEX_IN_ROW.getIndex()];

        return dimensions[index];

    }

    /**
     * Method to get the required measure from obj []
     * 
     * @param index
     * @param row
     * @return
     */
    public static Double getMeasure(int index, Object[] row)
    {
        Double[] measures = (Double[])row[IgnoreDictionary.MEASURES_INDEX_IN_ROW.getIndex()];
        return measures[index];
    }

    /**
     * 
     * @param row
     * @return
     */
    public static byte[] getByteArrayForNoDictionaryCols(Object[] row)
    {

        return (byte[])row[IgnoreDictionary.BYTE_ARRAY_INDEX_IN_ROW.getIndex()];
    }

    /**
     * 
     * @param out
     * @param dimArray
     * @param byteBufferArr
     * @param measureArray
     */
    public static void prepareOutObj(Object[] out, Integer[] dimArray,
            byte[] byteBufferArr, Double[] measureArray)
    {

        out[IgnoreDictionary.DIMENSION_INDEX_IN_ROW.getIndex()] = dimArray;
        out[IgnoreDictionary.BYTE_ARRAY_INDEX_IN_ROW.getIndex()] = byteBufferArr;
        out[IgnoreDictionary.MEASURES_INDEX_IN_ROW.getIndex()] = measureArray;

    }

    /**
     * 
     * @param row
     * @return
     */
    public static Integer[] getCompleteDimensions(Object[] row)
    {

        return (Integer[])row[0];
    }

    /**
     * This will extract the high cardinality count from the string.
     * 
     * @param highCardinalityDims2
     */
    public static int extractHighCardCount(String highCardinalityDim)
    {
        
        if(null == highCardinalityDim)
        {
            return 0;
        }
        
        String[] highCard = highCardinalityDim
                .split(MolapCommonConstants.COMA_SPC_CHARACTER);
        int[] highCardDimsLocal = new int[highCard.length];
        List<String> list1 = new ArrayList<String>(
                MolapCommonConstants.CONSTANT_SIZE_TEN);
        // int[] lenshighCard = new int[highCard.length];

        for(int i = 0;i < highCardDimsLocal.length;i++)
        {
            String[] dim = highCard[i]
                    .split(MolapCommonConstants.COLON_SPC_CHARACTER);
            list1.add(dim[0]);
            highCardDimsLocal[i] = Integer.parseInt(dim[1]);
            Integer.parseInt(dim[2]);

        }

        return list1.toArray(new String[list1.size()]).length;
    }

    /**
     * This method will split one single byte array of high card dims into array
     * of byte arrays.
     * 
     * @param highCardArr
     * @param highCardCount
     * @return
     */
    public static byte[][] splitHighCardKey(byte[] highCardArr,
            int highCardCount)
    {
        byte[][] split = new byte[highCardCount][];

        ByteBuffer buff = ByteBuffer.wrap(highCardArr, 2, highCardCount * 2);

        int remainingCol = highCardCount;
        short secIndex = 0;
        short firstIndex = 0;
        for(int i = 0;i < highCardCount;i++)
        {
            
            if(remainingCol == 1)
            {
                firstIndex = buff.getShort();
                int length = highCardArr.length - firstIndex;

                // add 2 bytes (short) as length required to determine size of
                // each column value.

                split[i] = new byte[length + 2];
                ByteBuffer splittedCol = ByteBuffer.wrap(split[i]);
                splittedCol.putShort((short)length);

                System.arraycopy(highCardArr, firstIndex, split[i], 2, length);

            }
            else
            {

                firstIndex = buff.getShort();
                secIndex = buff.getShort();
                int length = secIndex - firstIndex;

                // add 2 bytes (short) as length required to determine size of
                // each column value.

                split[i] = new byte[length + 2];
                ByteBuffer splittedCol = ByteBuffer.wrap(split[i]);
                splittedCol.putShort((short)length);

                System.arraycopy(highCardArr, firstIndex, split[i], 2, length);
                buff.position(buff.position() - 2);

            }
            remainingCol--;
        }

        return split;
    }

    /**
     * 
     * @param index
     * @param val
     */
    public static void setDimension(int index, int val, Object[] objArr)
    {
        Integer[] dimensions = (Integer[])objArr[IgnoreDictionary.DIMENSION_INDEX_IN_ROW.getIndex()];

        dimensions[index] = val;

    }
    
    /**
     * This will extract the high cardinality count from the string.
     * 
     * @param highCardinalityDims2
     */
    public static String[] extractHighCardDimsArr(String highCardinalityDim)
    {
        
        if(null == highCardinalityDim || highCardinalityDim.isEmpty())
        {
            return new String[0];
        }
        
        String[] highCard = highCardinalityDim
                .split(MolapCommonConstants.COMA_SPC_CHARACTER);
        int[] highCardDimsLocal = new int[highCard.length];
        List<String> list1 = new ArrayList<String>(
                MolapCommonConstants.CONSTANT_SIZE_TEN);
        // int[] lenshighCard = new int[highCard.length];

        for(int i = 0;i < highCardDimsLocal.length;i++)
        {
            String[] dim = highCard[i]
                    .split(MolapCommonConstants.COLON_SPC_CHARACTER);
            list1.add(dim[0]);
            highCardDimsLocal[i] = Integer.parseInt(dim[1]);
            Integer.parseInt(dim[2]);

        }

        return list1.toArray(new String[list1.size()]);
    }
    /**
     * 
     * @param directSurrogateKeyList
     * @return
     */
    public static byte[] convertListByteArrToSingleArr(
            List<byte[]> directSurrogateKeyList)
    {
        ByteBuffer[] buffArr = new ByteBuffer[directSurrogateKeyList.size()];
        int index = 0;
        for(byte[] singleColVal : directSurrogateKeyList)
        {
            buffArr[index] = ByteBuffer.allocate(singleColVal.length);
           buffArr[index].put(singleColVal);
           buffArr[index++].rewind();
        }
        
       return RemoveDictionaryUtil.packByteBufferIntoSingleByteArray(buffArr);
        
    }
}
