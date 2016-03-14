/*--------------------------------------------------------------------------------------------------------------------------*/
/*!!Warning: This is a key information asset of Huawei Tech Co.,Ltd                                                         */
/*CODEMARK:kOyQZYzjDpyGdBAEC2GaWmnksNUG9RKxzMKuuAYTdbJ5ajFrCnCGALet/FDi0nQqbEkSZoTs
2wdXgejaKCr1dP3uE3wfvLHF9gW8+IdXbwcz8AOhvEHjQfa55oxvUSJWRQCwLl+VwWEHaV7n
0eFj3WiDYFEuRQtMFyO1lZ3oiwy1edymAnQ9CrH8fx2W+ZRwYSCh9sE6t9Y6PSkTAqgpUM6v
LBlG8i+olKtjc1UiampTNoXpXwTuxUSJgPj3c8zNDheZ3lv8tFQDsjo5knG/2Q==*/
/*--------------------------------------------------------------------------------------------------------------------------*/
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
package com.huawei.unibi.molap.engine.mondrian.extensions.rolap.concurrent;

import java.util.concurrent.Callable;

/**
 * Project Name NSE V3R7C00 
 * Module Name : MOLAP
 * Author :C00900810
 * Created Date :29-Jul-2013
 * FileName : CubeLoader.java
 * Class Description : 
 * Version 1.0
 */
public class CubeLoader implements Callable<CubeLoader>
{

    @Override
    public CubeLoader call() throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
//    /**
//     * 
//     */
//    private mondrian.olap.MondrianDef.Schema xmlSchema;
//    /**
//     * 
//     */
//    private mondrian.olap.MondrianDef.Cube xmlCube; 
//    /**
//     * 
//     */
//    private boolean load;
//    /**
//     * 
//     */
//    private RolapSchema rolapSchema;
//    /**
//     * 
//     */
//    private VirtualCube xmlVirtualCube;
//    /**
//     * 
//     */
//    private boolean isCompleted;
//    
//    /**
//     * 
//     */
//    private static final LogService LOGGER = LogServiceFactory
//            .getLogService(CubeLoader.class.getName());
//    
//    public CubeLoader(RolapSchema rolapSchema, mondrian.olap.MondrianDef.Schema xmlSchema,
//            mondrian.olap.MondrianDef.Cube xmlCube, boolean load)
//    {
//        this.rolapSchema = rolapSchema;
//        this.xmlSchema = xmlSchema;
//        this.xmlCube = xmlCube;
//        this.xmlVirtualCube =null;
//        this.load = load;
//    }
//
//    public CubeLoader(RolapSchema rolapSchema,
//            mondrian.olap.MondrianDef.Schema xmlSchema,
//            VirtualCube xmlVirtualCube, boolean load)
//    {
//        this.rolapSchema = rolapSchema;
//        this.xmlSchema = xmlSchema;
//        this.xmlCube = null;
//        this.xmlVirtualCube = xmlVirtualCube;
//        this.load = load;
//    }
//
//    @Override
//    public CubeLoader call() throws Exception
//    {        
//        this.isCompleted =false;
//        load();
//        this.isCompleted =true;
//        return this;
//    }
//    /**
//     * Which tells the task is completed or not
//     * @return
//     */
//    public boolean isCompleted()
//    {
//        return isCompleted;
//    }
//
//    public void load() throws Exception
//    {
//        try
//        {
//            if( null != this.xmlCube)
//            {
//                //System.out.println("Loading normal cube : "+xmlCube.name);
//                RolapCube cube = new RolapCube(rolapSchema,this.xmlSchema,this.xmlCube,this.load);
//                Util.discard(cube);
//                setCalculatedMeasures(cube);
//            }
//            else if( null != xmlVirtualCube)
//            {
//                //System.out.println("Loading Virtual cube : "+xmlVirtualCube.name);
//                RolapCube cube = new RolapCube(rolapSchema,this.xmlSchema,this.xmlVirtualCube,this.load);
//                Util.discard(cube);
//                setCalculatedMeasures(cube);
//            }
//        }catch(Throwable e)
//        {
//            LOGGER.error(MolapEngineLogEvent.UNIBI_MOLAPENGINE_MSG,"Error in load method "+ e.getMessage());
//            throw new Exception(e);
//        }
//    }
//    
//    private void setCalculatedMeasures(RolapCube cube)
//    {
//    	Cube molapCube = MolapMetadata.getInstance().getCube(cube.getSchema().getName()+'_'+cube.getName());
//    	List<RolapMember> measuresMembers = cube.getMeasuresMembers();
//    	for(RolapMember rolapMember : measuresMembers)
//    	{
//    		if(rolapMember instanceof RolapCalculatedMeasure)
//    		{
//    			RolapCalculatedMeasure calculatedMeasure = (RolapCalculatedMeasure)rolapMember;
//    			
//    			CalculatedMeasure measure = new CalculatedMeasure(calculatedMeasure.getExpression(), calculatedMeasure.getName());
//    			molapCube.getMeasures(molapCube.getFactTableName()).add(measure);
//    		}
//    	}
//    }
//    
//    @Override
//    public String toString()
//    {
//        if( null != xmlCube && null !=xmlSchema)
//        {
//            return xmlSchema.name+':'+xmlCube.name;
//        }else if( null != xmlVirtualCube && null != xmlSchema)
//        {
//            return xmlSchema.name+':'+xmlVirtualCube.name;
//        }else
//        {
//            return "Not defined";
//        }
//            
//    }
}
