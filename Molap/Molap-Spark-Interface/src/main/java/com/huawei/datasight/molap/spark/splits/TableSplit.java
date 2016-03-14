/**
 * 
 */
package com.huawei.datasight.molap.spark.splits;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.Writable;

import com.huawei.datasight.molap.partition.api.Partition;
import com.huawei.iweb.platform.logging.LogService;
import com.huawei.iweb.platform.logging.LogServiceFactory;
import com.huawei.unibi.molap.constants.MolapCommonConstants;
import com.huawei.unibi.molap.engine.util.MolapEngineLogEvent;

/**
 * It represents one region server as one split.
 * @author R00900208
 *
 */
public class TableSplit implements Serializable,Writable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8058151330863145575L;

	private static final LogService LOGGER = LogServiceFactory.getLogService(TableSplit.class.getName());	
	private List<String> locations = new ArrayList<String>(MolapCommonConstants.CONSTANT_SIZE_TEN);
	
	private Partition partition;


	/**
	 * @return the locations
	 */
	public List<String> getLocations() 
	{
		return locations;
	}

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(List<String> locations) 
	{
		this.locations = locations;
	}

	/**
     * 
     * @return Returns the partitions.
     * 
     */
    public Partition getPartition()
    {
        return partition;
    }

    /**
     * 
     * @param partitions The partitions to set.
     * 
     */
    public void setPartition(Partition partition)
    {
        this.partition = partition;
    }

    @Override
	public void readFields(DataInput in) throws IOException 
	{

		
		int sizeLoc = in.readInt();
		for (int i = 0; i < sizeLoc; i++) 
		{
			byte[] b = new byte[in.readInt()];
			in.readFully(b);
			locations.add(new String(b,Charset.defaultCharset()));
		}
		
		byte[] buf = new byte[in.readInt()];
		in.readFully(buf);
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		ObjectInputStream ois = new ObjectInputStream(bis);
		try
        {
            partition = (Partition)ois.readObject();
        }
        catch(ClassNotFoundException e)
        {
//            e.printStackTrace();
        	 LOGGER.error(MolapEngineLogEvent.UNIBI_MOLAPENGINE_MSG, e, e.getMessage());
        }
		ois.close();
	}

	@Override
	public void write(DataOutput out) throws IOException 
	{
		
		int sizeLoc = locations.size();
		out.writeInt(sizeLoc);
		for (int i = 0; i < sizeLoc; i++) 
		{
			byte[] bytes = locations.get(i).getBytes(Charset.defaultCharset());
			out.writeInt(bytes.length);
			out.write(bytes);
		}
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		ObjectOutputStream obs = new ObjectOutputStream(bos);
		obs.writeObject(partition);
		obs.close();
		byte[] byteArray = bos.toByteArray();
        out.writeInt(byteArray.length);
		out.write(byteArray);
	}

	public String toString()
	{
	    return partition.getUniqueID() + ' ' + locations;
	}
}
