/**
 *
 * Copyright Notice
 * =====================================
 * This file contains proprietary information of
 * Huawei Technologies India Pvt Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013
 * =====================================
 *
 */
package com.huawei.unibi.molap.datastorage.store.compression.type;

import com.huawei.iweb.platform.logging.LogService;
import com.huawei.iweb.platform.logging.LogServiceFactory;
import com.huawei.unibi.molap.datastorage.store.compression.Compressor;
import com.huawei.unibi.molap.datastorage.store.compression.SnappyCompression;
import com.huawei.unibi.molap.datastorage.store.compression.ValueCompressonHolder;
import com.huawei.unibi.molap.datastorage.store.compression.ValueCompressonHolder.UnCompressValue;
import com.huawei.unibi.molap.datastorage.store.dataholder.MolapReadDataHolder;
import com.huawei.unibi.molap.util.MolapCoreLogEvent;
import com.huawei.unibi.molap.util.ValueCompressionUtil;
import com.huawei.unibi.molap.util.ValueCompressionUtil.DataType;

/**
 * @author S71955
 */
public class UnCompressNoneByte implements UnCompressValue<byte[]>
{
    /**
     * Attribute for Molap LOGGER
     */
    private static final LogService LOGGER = LogServiceFactory.getLogService(UnCompressNoneByte.class.getName());

    /**
     * byteCompressor.
     */
    private static Compressor<byte[]> byteCompressor = SnappyCompression.SnappyByteCompression.INSTANCE;

    /**
     * value.
     */
    private byte[] value;

//    @Override
//    public double getValue(int index, int decimal, double maxValue)
//    {
//        return value[index];
//    }

    //TODO SIMIAN
    @Override
    public UnCompressValue getNew()
    {
        try
        {
            return (UnCompressValue)clone();
        }
        catch(CloneNotSupportedException e)
        {
            LOGGER.error(MolapCoreLogEvent.UNIBI_MOLAPCORE_MSG, e, e.getMessage());
        }
        return null;
    }
    
    @Override
    public void setValue(byte[] value)
    {
        this.value = value;
    }

    @Override
    public UnCompressValue uncompress(DataType dataType)
    {
        UnCompressValue byte1 = ValueCompressionUtil.unCompressNone(dataType, dataType);
        ValueCompressonHolder.unCompress(dataType, byte1, value);
        return byte1;
    }

    @Override
    public UnCompressValue compress()
    {
        UnCompressNoneByte byte1 = new UnCompressNoneByte();
        byte1.setValue(byteCompressor.compress(value));
        return byte1;
    }

   

    @Override
    public byte[] getBackArrayData()
    {
        return value;
    }

    @Override
    public void setValueInBytes(byte[] value)
    {
        this.value = value;
    }

    /**
     * 
     * @see com.huawei.unibi.molap.datastorage.store.compression.ValueCompressonHolder.UnCompressValue#getCompressorObject()
     * 
     */
    @Override
    public UnCompressValue getCompressorObject()
    {
        // TODO Auto-generated method stub
        return new UnCompressNoneByte();
    }
    
    //TODO SIMIAN
    @Override
    public MolapReadDataHolder getValues(int decimal, double maxValue)
    {
        MolapReadDataHolder dataHldr = new MolapReadDataHolder();   
        double[] vals = new double[value.length];
        for(int i = 0;i < vals.length;i++)
        {
            vals[i] = value[i];
        }
        dataHldr.setReadableDoubleValues(vals);
        return dataHldr;
    }

}
