/*--------------------------------------------------------------------------------------------------------------------------*/
/*!!Warning: This is a key information asset of Huawei Tech Co.,Ltd                                                         */
/*CODEMARK:kOyQZYzjDpyGdBAEC2GaWmnksNUG9RKxzMKuuAYTdbJ5ajFrCnCGALet/FDi0nQqbEkSZoTs
2wdXgejaKCr1dP3uE3wfvLHF9gW8+IdXbwddts1/q4bCGDA4M3dH8C2PEEMnfDqqdF4ZhcSc
1BeEnK94LYjSl6N3wzZT2K37pV9fDYep0/L42rWpn6h1yLz4EK1qbxvIzVaU8vYg41gk9F7v
hvxUyKN0Emod3zPwt0/X9GW5fLv6JhXNMJu5/Fmqnvc9uNdjprLrHXc9Gd8piA==*/
/*--------------------------------------------------------------------------------------------------------------------------*/
/**
 *
 * Copyright Notice
 * =====================================
 * This file contains proprietary information of
 * Huawei Technologies Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2011
 * =====================================
 *
 */
package com.huawei.unibi.molap.groupby.step;

import java.util.List;
import java.util.Map;

import org.pentaho.di.core.CheckResult;
import org.pentaho.di.core.CheckResultInterface;
import org.pentaho.di.core.Counter;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.core.row.RowMetaInterface;
import org.pentaho.di.core.xml.XMLHandler;
import org.pentaho.di.i18n.BaseMessages;
import org.pentaho.di.repository.ObjectId;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.BaseStepMeta;
import org.pentaho.di.trans.step.StepDataInterface;
import org.pentaho.di.trans.step.StepInterface;
import org.pentaho.di.trans.step.StepMeta;
import org.pentaho.di.trans.step.StepMetaInterface;
import org.w3c.dom.Node;

/**
 * Project Name NSE V3R7C00 
 * Module Name : MOLAP
 * Author :C00900810
 * Created Date :24-Jun-2013
 * FileName : MolapSliceMergerStepMeta.java
 * Class Description : This class is the entry point for MolapDataWriterStepMeta plug-in
 * Version 1.0
 */
public class MolapGroupByStepMeta extends BaseStepMeta implements
        StepMetaInterface, Cloneable
{

    /**
     * for i18n purposes
     */
    private static final Class<?> PKG = MolapGroupByStepMeta.class;
    
    private String aggTypeString;
    
    private String actualColumnName;
    
    private String columnName;
    
    private String outputRowSize;
    
    /**
     * 
     * MolapDataWriterStepMeta constructor to initialize this class
     * 
     */
    public MolapGroupByStepMeta()
    {
        super();
    }

    /**
     * set the default value for all the properties
     * 
     */
    @Override
    public void setDefault()
    {
        aggTypeString="";
        actualColumnName= "";
        columnName= "";
        outputRowSize="";
    }

    /**
     * Get the XML that represents the values in this step
     * 
     * @return the XML that represents the metadata in this step
     * @throws KettleException
     *             in case there is a conversion or XML encoding error
     */
    public String getXML()
    {
        StringBuffer retval = new StringBuffer(150);
        retval.append("    ").append(
                XMLHandler.addTagValue("aggTypeString", aggTypeString));
        retval.append("    ").append(
                XMLHandler.addTagValue("actualColumnName", actualColumnName));
        retval.append("    ").append(
                XMLHandler.addTagValue("columnName", columnName));
        retval.append("    ").append(
                XMLHandler.addTagValue("outputRowSize", outputRowSize));
        
        return retval.toString();
    }
    
    //TODO SIMIAN
    /**
     * Make an exact copy of this step, make sure to explicitly copy Collections
     * etc.
     * 
     * @return an exact copy of this step
     */
    public Object clone()
    {
        Object retval = super.clone();
        return retval;
    }
    
    /**
     * Load the values for this step from an XML Node
     * 
     * @param stepnode
     *            the Node to get the info from
     * @param databases
     *            The available list of databases to reference to
     * @param counters
     *            Counters to reference.
     * @throws KettleXMLException
     *             When an unexpected XML error occurred. (malformed etc.)
     */
    @Override
    public void loadXML(Node stepnode, List<DatabaseMeta> databases,
            Map<String, Counter> counters) throws KettleXMLException
    {
        try
        {
            aggTypeString = XMLHandler.getTagValue(stepnode, "aggTypeString");
            
            actualColumnName = XMLHandler.getTagValue(stepnode, "actualColumnName");
            
            columnName = XMLHandler.getTagValue(stepnode, "columnName");
            
            outputRowSize = XMLHandler.getTagValue(stepnode, "outputRowSize");
        }
        catch(Exception e)
        {
            // TODO Auto-generated catch block
            throw new KettleXMLException(
                    "Unable to read step info from XML node", e);
        }
    }


    /**
     * Save the steps data into a Kettle repository
     * 
     * @param rep
     *            The Kettle repository to save to
     * @param idTransformation
     *            The transformation ID
     * @param idStep
     *            The step ID
     * @throws KettleException
     *             When an unexpected error occurred (database, network, etc)
     */
    @Override
    public void saveRep(Repository rep, ObjectId idTransformation,
            ObjectId idStep) throws KettleException
    {
        try
        { 
            rep.saveStepAttribute(idTransformation, idStep,
                    "aggTypeString", aggTypeString); //$NON-NLS-1$
            
            rep.saveStepAttribute(idTransformation, idStep,
                    "actualColumnName", actualColumnName); //$NON-NLS-1$
            
            rep.saveStepAttribute(idTransformation, idStep,
                    "columnName", columnName); //$NON-NLS-1$
            
            rep.saveStepAttribute(idTransformation, idStep,
                    "outputRowSize", outputRowSize); //$NON-NLS-1$
            
        }
        catch(Exception e)
        {
            throw new KettleException(BaseMessages.getString(PKG,
                    "TemplateStep.Exception.UnableToSaveStepInfoToRepository")
                    + idStep, e);
        }
    }

    /**
     * Read the steps information from a Kettle repository
     * 
     * @param rep
     *            The repository to read from
     * @param idStep
     *            The step ID
     * @param databases
     *            The databases to reference
     * @param counters
     *            The counters to reference
     * @throws KettleException
     *             When an unexpected error occurred (database, network, etc)
     */
    @Override
    public void readRep(Repository rep, ObjectId idStep,
            List<DatabaseMeta> databases, Map<String, Counter> counters)
            throws KettleException 
    {
        // TODO Auto-generated method stub
        try
        {
            aggTypeString = rep.getStepAttributeString(idStep, "aggTypeString");
            columnName = rep.getStepAttributeString(idStep, "columnName");
            actualColumnName = rep.getStepAttributeString(idStep, "actualColumnName");
            outputRowSize = rep.getStepAttributeString(idStep, "outputRowSize");
            
        }
        catch(Exception ex)
        {
            // TODO Auto-generated catch block
            throw new KettleException(
                    BaseMessages
                            .getString(PKG,
                                    "MolapDataWriterStepMeta.Exception.UnexpectedErrorInReadingStepInfo"),
                    ex);
        }

    }

    /**
     * Checks the settings of this step and puts the findings in a remarks List.
     * 
     * @param remarks
     *            The list to put the remarks in @see
     *            org.pentaho.di.core.CheckResult
     * @param stepMeta
     *            The stepMeta to help checking
     * @param prev
     *            The fields coming from the previous step
     * @param input
     *            The input step names
     * @param output
     *            The output step names
     * @param info
     *            The fields that are used as information by the step
     */
    @Override
    public void check(List<CheckResultInterface> remarks, TransMeta transMeta,
            StepMeta stepMeta, RowMetaInterface prev, String[] input,
            String[] output, RowMetaInterface info)
    {
        // TODO Auto-generated method stub 

        CheckResult checkResultInfo; 

        // See if we have input streams leading to this step!
        if(input.length > 0)
        {
            checkResultInfo = new CheckResult(CheckResult.TYPE_RESULT_OK,
                    "Step is receiving info from other steps.", stepMeta);
            remarks.add(checkResultInfo);
        }
        else
        {
            checkResultInfo = new CheckResult(CheckResult.TYPE_RESULT_ERROR,
                    "No input received from other steps!", stepMeta);
            remarks.add(checkResultInfo);
        }

    }

    /**
     * Get the executing step, needed by Trans to launch a step.
     * 
     * @param stepMeta
     *            The step info
     * @param stepDataInterface
     *            the step data interface linked to this step. Here the step can
     *            store temporary data, database connections, etc.
     * @param copyNr
     *            The copy nr to get
     * @param transMeta
     *            The transformation info
     * @param trans
     *            The launching transformation
     */
    @Override
    public StepInterface getStep(StepMeta stepMeta,
            StepDataInterface stepDataInterface, int copyNr,
            TransMeta transMeta, Trans trans)
    {
        // TODO Auto-generated method stub
        return new MolapGroupByStep(stepMeta, stepDataInterface, copyNr,
                transMeta, trans);
    }

    /**
     * Get a new instance of the appropriate data class. This data class
     * implements the StepDataInterface. It basically contains the persisting
     * data that needs to live on, even if a worker thread is terminated.
     * 
     * @return The appropriate StepDataInterface class.
     */
    @Override
    public StepDataInterface getStepData()
    {
        // TODO Auto-generated method stub
        return new MolapGroupByStepData();
    }

    /**
     * Method will return agg type string 
     * 
     * @return aggTypeString
     *
     */
    public String getAggTypeString()
    {
        return aggTypeString;
    }

    /**
     * This method will be used to set the agg type string 
     * 
     * @param aggTypeString
     *
     */
    public void setAggTypeString(String aggTypeString)
    {
        this.aggTypeString = aggTypeString;
    }

    public String getActualColumnName()
    {
        return actualColumnName;
    }

    public void setActualColumnName(String actualColumnName)
    {
        this.actualColumnName = actualColumnName;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public String getOutputRowSize()
    {
        return outputRowSize;
    }

    public void setOutputRowSize(String outputRowSize)
    {
        this.outputRowSize = outputRowSize;
    }
}
