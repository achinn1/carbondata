package com.huawei.unibi.molap.engine.expression;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huawei.unibi.molap.constants.MolapCommonConstants;
import com.huawei.unibi.molap.engine.expression.exception.FilterUnsupportedException;
import com.huawei.unibi.molap.util.MolapProperties;

public class ExpressionResult
{

    private static final long serialVersionUID = 1L;
    protected DataType dataType;

    protected Object value;

    private List<ExpressionResult> expressionResults;

    public ExpressionResult(DataType dataType, Object value)
    {
        this.dataType = dataType;
        this.value = value;
    }

    public ExpressionResult(List<ExpressionResult> expressionResults)
    {
        this.expressionResults = expressionResults;
    }

    public void set(DataType dataType, Object value)
    {
        this.dataType = dataType;
        this.value = value;
        this.expressionResults = null;
    }

    public DataType getDataType()
    {
        return dataType;
    }

    //CHECKSTYLE:OFF Approval No:Approval-V1R2C10_009
    public Integer getInt() throws FilterUnsupportedException
    {
        if(value == null) 
        {
            return null;
        }
        try
        {
            switch(this.getDataType())
            {
            case StringType:
                try
                {
                    return Integer.parseInt(value.toString());
                }
                catch(NumberFormatException e)
                {
                    throw new FilterUnsupportedException(e);
                }

            case IntegerType:
            case DoubleType:
            
                if(value instanceof Double)
                {
                    return ((Double)value).intValue();
                }
                return (Integer)value;
            
            case TimestampType:
            
                if(value instanceof Timestamp)
                {
                    return (int)(((Timestamp)value).getTime() % 1000);
                }
                else{
                    return (Integer)value;
                }
            
            default:
                throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                        + " to integer type value");
            }

        }
        catch(ClassCastException e)
        {
            throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                    + " to Integer type value");
        }
    }

    public String getString()
    {
        if(value == null) 
        {
            return null;
        }       
        switch(this.getDataType())
        {
            case TimestampType:
                SimpleDateFormat parser = new SimpleDateFormat(MolapProperties.getInstance().
                        getProperty(MolapCommonConstants.MOLAP_TIMESTAMP_FORMAT,
                                MolapCommonConstants.MOLAP_TIMESTAMP_DEFAULT_FORMAT));
                if(value instanceof Timestamp){
                    return parser.format((Timestamp)value);    
                } else {
                    return parser.format(new Timestamp((long)value));
                }
                
            default:
                return value.toString();
        }
    }

    public Double getDouble() throws FilterUnsupportedException
    {
        if(value == null) 
        {
            return null;
        }
        try
        {
            switch(this.getDataType())
            {
            case StringType:
                try
                {
                    return Double.parseDouble(value.toString());
                }
                catch(NumberFormatException e)
                {
                    throw new FilterUnsupportedException(e);
                }

            case IntegerType:
                return ((Integer)value).doubleValue();
            case LongType:
                return ((Long)value).doubleValue();
            case DoubleType:
                return (Double)value;
            case TimestampType:
                if(value instanceof Timestamp)
                {
                    return (double)((Timestamp)value).getTime()*1000;
                }
                else
                {
                    return (Double)(value);
                }
            default:
                throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                        + " to double type value");
            }
        }
        catch(ClassCastException e)
        {
            throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                    + " to Double type value");
        }
    }
    //CHECKSTYLE:ON
    
    public Long getLong() throws FilterUnsupportedException
    {
        if(value == null) 
        {
            return null;
        }
        try
        {
            switch(this.getDataType())
            {
            case StringType:
                try
                {
                    return Long.parseLong(value.toString());
                }
                catch(NumberFormatException e)
                {
                    throw new FilterUnsupportedException(e);
                }

            case IntegerType:
                return (Long)value;
            case DoubleType:
                return (Long)value;
            case TimestampType:
                if(value instanceof Timestamp)
                {
                    return 1000*((Timestamp)value).getTime();
                }
                else
                {
                    return (Long)value;
                }
            default:
                throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                        + " to Long type value");
            }
        }
        catch(ClassCastException e)
        {
            throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                    + " to Long type value");
        }
    
    }

    public Long getTime() throws FilterUnsupportedException
    {
        if(value == null) 
        {
            return null;
        }
        try
        {
            switch(this.getDataType())
            {
            case StringType:
                SimpleDateFormat parser = new SimpleDateFormat(MolapProperties.getInstance().getProperty(
                        MolapCommonConstants.MOLAP_TIMESTAMP_FORMAT,
                        MolapCommonConstants.MOLAP_TIMESTAMP_DEFAULT_FORMAT));
                Date dateToStr;
                try
                {
                    dateToStr = parser.parse(value.toString());
                    return dateToStr.getTime()*1000;
                }
                catch(ParseException e)
                {
                    throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                            + " to Time/Long type value");
                }

            case IntegerType:
                // Handler: Need to check timestamp is in seconds or millisecs.
                // This cast makes sense if its in seconds
            case LongType:
                return (Long)value;
            case DoubleType:
                return (Long)value;
            case TimestampType:
                if(value instanceof Timestamp)
                {
                  return ((Timestamp)value).getTime()*1000;
                }
                else
                {
                  return (Long)value; 
                }
            default:
                throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                        + " to Time/Long type value");
            }
        }
        catch(ClassCastException e)
        {
            throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                    + " to Time/Long type value");
        }

    }
    public Boolean getBoolean() throws FilterUnsupportedException
    {
        if(value == null) 
        {
            return null;
        }
        try
        {
            switch(this.getDataType())
            {
            case StringType:
                try
                {
                    return Boolean.parseBoolean(value.toString());
                }
                catch(NumberFormatException e)
                {
                    throw new FilterUnsupportedException(e);
                }

            case BooleanType:
                return Boolean.parseBoolean(value.toString());

            default:
                throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                        + " to boolean type value");
            }
        }
        catch(ClassCastException e)
        {
            throw new FilterUnsupportedException("Cannot convert" + this.getDataType().name()
                    + " to Boolean type value");
        }
    }

    public List<ExpressionResult> getList()
    {
        if(null == expressionResults)
        {
            List<ExpressionResult> a = new ArrayList<ExpressionResult>(20);
            a.add(new ExpressionResult(dataType, value));
            return a;
        }
        else
        {
            return expressionResults;
        }
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        if(null != expressionResults)
        {
            result = prime * result + expressionResults.hashCode();
        }
        else if(null != value)
        {
            result = prime * result + value.hashCode();
        }
        else
        {
            result = prime * result + "".hashCode();
        }

        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override        //CHECKSTYLE:OFF    Approval No:Approval-V1R2C10_012
    public boolean equals(Object obj)
    {
        if(null == obj)
        {
            return false;
        }
        
        if(!(obj instanceof ExpressionResult))
        {
            return false;
        }
     // CHECKSTYLE:ON
        if(this == obj)
        {
            return true;
        }
        
            
        if(getClass() != obj.getClass())
        {
            return false;
        }
        
        ExpressionResult objToCompare = (ExpressionResult)obj;
        boolean result = false;
        if(this.value == objToCompare.value)
        {
            return true;
        }
        try
        {
            switch(this.getDataType())
            {
            case StringType:
                result = this.getString().equals(objToCompare.getString());
                break;
            case IntegerType:
                result = this.getInt().equals(objToCompare.getInt());
                break;

            case DoubleType:
                result = this.getDouble().equals(objToCompare.getDouble());
                break;
            case TimestampType:
                result = this.getLong().equals(objToCompare.getLong());
                break;
            default:
                break;
            }
        }
        catch(FilterUnsupportedException ex)
        {
            return false;
        }

        return result;
    }
    
    public boolean isNull(){
        return value == null;
    }

}
