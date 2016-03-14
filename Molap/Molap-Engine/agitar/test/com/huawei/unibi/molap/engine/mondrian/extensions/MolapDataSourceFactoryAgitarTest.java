/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on 29 Jul, 2013 5:02:11 PM
 * Time to generate: 00:16.335 seconds
 *
 */

package com.huawei.unibi.molap.engine.mondrian.extensions;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.huawei.unibi.molap.engine.datasource.MolapDataSourceImpl;
import javax.sql.DataSource;
import mondrian.olap.Util;
import mondrian.rolap.RolapConnectionProperties;

public class MolapDataSourceFactoryAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MolapDataSourceFactory.class;
    }
    
    public void testConstructor() throws Throwable {
        new MolapDataSourceFactory();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testGetMolapDataSource() throws Throwable {
        DataSource result = MolapDataSourceFactory.getMolapDataSource(Util.parseConnectString("testMolapDataSourceFactorys"));
        assertNull("result", result);
    }
    
    public void testGetMolapDataSource1() throws Throwable {
        storeStaticField(RolapConnectionProperties.class, "JdbcDrivers");
        Util.PropertyList propertyList = (Util.PropertyList) Mockingbird.getProxyObject(Util.PropertyList.class);
        setPrivateField(RolapConnectionProperties.class, "JdbcDrivers", Mockingbird.getProxyObject(RolapConnectionProperties.class));
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "com.huawei.unibi.molap.engine.datasource.MolapDataSourceImpl", 1);
        Mockingbird.replaceObjectForRecording(MolapDataSourceImpl.class, "<init>(mondrian.olap.Util$PropertyList)", Mockingbird.getProxyObject(MolapDataSourceImpl.class));
        Mockingbird.enterTestMode(MolapDataSourceFactory.class);
        DataSource result = MolapDataSourceFactory.getMolapDataSource(propertyList);
        assertNotNull("result", result);
        assertNotNull("MolapDataSourceFactory.LOGGER", getPrivateField(MolapDataSourceFactory.class, "LOGGER"));
    }
    
    public void testGetMolapDataSourceThrowsNullPointerException() throws Throwable {
        try {
            MolapDataSourceFactory.getMolapDataSource(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MolapDataSourceFactory.class, ex);
            assertNotNull("MolapDataSourceFactory.LOGGER", getPrivateField(MolapDataSourceFactory.class, "LOGGER"));
        }
    }
}

