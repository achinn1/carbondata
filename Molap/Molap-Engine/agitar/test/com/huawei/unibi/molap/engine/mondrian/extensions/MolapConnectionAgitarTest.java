/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on 29 Jul, 2013 5:03:16 PM
 * Time to generate: 01:40.622 seconds
 *
 */

package com.huawei.unibi.molap.engine.mondrian.extensions;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import javax.sql.DataSource;
import mondrian.olap.Cube;
import mondrian.olap.MondrianException;
import mondrian.olap.MondrianServer;
import mondrian.olap.Query;
import mondrian.olap.Result;
import mondrian.olap.Schema;
import mondrian.olap.Util;
import mondrian.resource.MondrianResource;
import mondrian.rolap.RolapConnection;
import mondrian.rolap.RolapConnectionProperties;
import mondrian.rolap.RolapResultShepherd;
import mondrian.rolap.RolapSchema;
import mondrian.server.Execution;
import mondrian.server.StatementImpl;
import mondrian.server.StringRepositoryContentFinder;
import mondrian.server.UrlRepositoryContentFinder;
import mondrian.spi.Dialect;
import mondrian.spi.DialectManager;
import mondrian.spi.impl.CatalogLocatorImpl;

public class MolapConnectionAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MolapConnection.class;
    }
    
    public void testConstructor() throws Throwable {
        Mockingbird.ignoreConstructorExceptions(RolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(null, null, null);
        assertNull("molapConnection.getCatalogName()", molapConnection.getCatalogName());
        assertNull("molapConnection.getSchema()", molapConnection.getSchema());
        assertNull("molapConnection.getSchemaReader()", molapConnection.getSchemaReader());
        assertNotNull("molapConnectionRolapConnection.LOGGER", getPrivateField(RolapConnection.class, "LOGGER"));
        assertNull("molapConnection.getDataSource()", molapConnection.getDataSource());
        assertNull("molapConnection.role", getPrivateField(molapConnection, "role"));
        assertNull("molapConnection.getConnectInfo()", molapConnection.getConnectInfo());
        assertNull("molapConnection.getServer()", molapConnection.getServer());
        assertEquals("molapConnection.getLocale().getDisplayName()", "English (India)", molapConnection.getLocale().getDisplayName());
    }
    
    public void testConstructor1() throws Throwable {
        Mockingbird.ignoreConstructorExceptions(RolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(null, null, null, null);
        assertNull("molapConnection.getCatalogName()", molapConnection.getCatalogName());
        assertNull("molapConnection.getSchema()", molapConnection.getSchema());
        assertNull("molapConnection.getSchemaReader()", molapConnection.getSchemaReader());
        assertNull("molapConnection.getDataSource()", molapConnection.getDataSource());
        assertNotNull("molapConnectionRolapConnection.LOGGER", getPrivateField(RolapConnection.class, "LOGGER"));
        assertNull("molapConnection.role", getPrivateField(molapConnection, "role"));
        assertNull("molapConnection.getConnectInfo()", molapConnection.getConnectInfo());
        assertEquals("molapConnection.getLocale().getDisplayName()", "English (India)", molapConnection.getLocale().getDisplayName());
        assertNull("molapConnection.getServer()", molapConnection.getServer());
    }
    
    public void testCreateDataSourceWithAggressiveMocks() throws Throwable {
        storeStaticField(RolapConnectionProperties.class, "JdbcPassword");
        storeStaticField(RolapConnectionProperties.class, "Jdbc");
        storeStaticField(RolapConnectionProperties.class, "JdbcUser");
        storeStaticField(RolapConnectionProperties.class, "JdbcDrivers");
        MolapConnection molapConnection = (MolapConnection) Mockingbird.getProxyObject(MolapConnection.class, true);
        Util.PropertyList propertyList = (Util.PropertyList) Mockingbird.getProxyObject(Util.PropertyList.class);
        StringBuilder stringBuilder = new StringBuilder();
        RolapConnectionProperties rolapConnectionProperties = (RolapConnectionProperties) Mockingbird.getProxyObject(RolapConnectionProperties.class);
        setPrivateField(RolapConnectionProperties.class, "Jdbc", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcUser", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcPassword", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcDrivers", rolapConnectionProperties);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", null, 1);
        Mockingbird.enterTestMode(MolapConnection.class);
        DataSource result = molapConnection.createDataSource(null, propertyList, stringBuilder);
        assertNull("result", result);
    }
    
    public void testCreateDataSourceWithAggressiveMocks1() throws Throwable {
        storeStaticField(RolapConnectionProperties.class, "JdbcPassword");
        storeStaticField(RolapConnectionProperties.class, "Jdbc");
        storeStaticField(RolapConnectionProperties.class, "JdbcUser");
        MolapConnection molapConnection = (MolapConnection) Mockingbird.getProxyObject(MolapConnection.class, true);
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Util.PropertyList propertyList = (Util.PropertyList) Mockingbird.getProxyObject(Util.PropertyList.class);
        StringBuilder stringBuilder = new StringBuilder();
        RolapConnectionProperties rolapConnectionProperties = (RolapConnectionProperties) Mockingbird.getProxyObject(RolapConnectionProperties.class);
        setPrivateField(RolapConnectionProperties.class, "Jdbc", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcUser", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcPassword", rolapConnectionProperties);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        callPrivateMethod("mondrian.rolap.RolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {stringBuilder, "Anonymous data source", dataSource});
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.enterTestMode(MolapConnection.class);
        DataSource result = molapConnection.createDataSource(dataSource, propertyList, stringBuilder);
        assertNotNull("result", result);
    }
    
    public void testCreateDataSourceWithAggressiveMocks2() throws Throwable {
        storeStaticField(RolapConnectionProperties.class, "JdbcPassword");
        storeStaticField(RolapConnectionProperties.class, "Jdbc");
        storeStaticField(RolapConnectionProperties.class, "JdbcUser");
        storeStaticField(RolapConnectionProperties.class, "JdbcDrivers");
        MolapConnection molapConnection = (MolapConnection) Mockingbird.getProxyObject(MolapConnection.class, true);
        Util.PropertyList propertyList = (Util.PropertyList) Mockingbird.getProxyObject(Util.PropertyList.class);
        StringBuilder stringBuilder = new StringBuilder();
        RolapConnectionProperties rolapConnectionProperties = (RolapConnectionProperties) Mockingbird.getProxyObject(RolapConnectionProperties.class);
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        setPrivateField(RolapConnectionProperties.class, "Jdbc", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcUser", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcPassword", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcDrivers", rolapConnectionProperties);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(molapConnection.createMolapDatasource(propertyList), dataSource);
        Mockingbird.enterTestMode(MolapConnection.class);
        DataSource result = molapConnection.createDataSource(null, propertyList, stringBuilder);
        assertNotNull("result", result);
    }
    
    public void testCreateMolapDatasource() throws Throwable {
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        DataSource dataSource2 = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(dataSource2.getConnection(), null);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource2, null), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource2, "testMolapConnectionMd5Bytes"});
        MondrianServer server = MondrianServer.forId(null);
        Util.PropertyList connectInfo = new Util.PropertyList();
        Mockingbird.enterRecordingMode();
        callPrivateMethod("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {null, "testMolapConnectionParam2", dataSource});
        Mockingbird.setNormalReturnForVoid(true);
        Mockingbird.enterTestMode(MolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(server, connectInfo, schema, dataSource);
        DataSource result = molapConnection.createMolapDatasource(new Util.PropertyList());
        assertNull("result", result);
    }
    
    public void testExecuteWithAggressiveMocks() throws Throwable {
        storeStaticField(RolapConnection.class, "THREAD_LOCAL");
        storeStaticField(MolapConnection.class, "THREAD_LOCAL");
        MolapConnection molapConnection = (MolapConnection) Mockingbird.getProxyObject(MolapConnection.class, true);
        Execution execution = (Execution) Mockingbird.getProxyObject(Execution.class);
        StatementImpl statementImpl = (StatementImpl) Mockingbird.getProxyObject(StatementImpl.class);
        Query query = (Query) Mockingbird.getProxyObject(Query.class);
        Cube cube = (Cube) Mockingbird.getProxyObject(Cube.class);
        Schema schema = (Schema) Mockingbird.getProxyObject(Schema.class);
        ThreadLocal threadLocal = (ThreadLocal) Mockingbird.getProxyObject(ThreadLocal.class);
        HashMap hashMap = (HashMap) Mockingbird.getProxyObject(HashMap.class);
        ThreadLocal threadLocal2 = (ThreadLocal) Mockingbird.getProxyObject(ThreadLocal.class);
        HashMap hashMap2 = (HashMap) Mockingbird.getProxyObject(HashMap.class);
        HashMap hashMap3 = (HashMap) Mockingbird.getProxyObject(HashMap.class);
        HashMap hashMap4 = (HashMap) Mockingbird.getProxyObject(HashMap.class);
        HashMap hashMap5 = (HashMap) Mockingbird.getProxyObject(HashMap.class);
        setPrivateField(execution, "statement", statementImpl);
        statementImpl.setQuery(query);
        setPrivateField(query, "id", new Long(0L));
        setPrivateField(query, "cube", cube);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(cube.getName(), "");
        setPrivateField(MolapConnection.class, "THREAD_LOCAL", threadLocal);
        setPrivateField(RolapConnection.class, "THREAD_LOCAL", threadLocal2);
        Mockingbird.setReturnValue(false, cube, "getSchema", "()mondrian.olap.Schema", schema, 1);
        Mockingbird.setReturnValue(schema.getName(), "");
        Mockingbird.setReturnValue(false, threadLocal, "get", "()java.lang.Object", new Object[] {}, hashMap, 1);
        Mockingbird.setReturnValue(true, System.class, "currentTimeMillis", "()long", new Object[] {}, new Long(0L), 1);
        Mockingbird.setReturnValue(false, hashMap, "put", "(java.lang.Object,java.lang.Object)java.lang.Object", null, 1);
        Mockingbird.setReturnValue(false, threadLocal2, "get", "()java.lang.Object", new Object[] {}, hashMap2, 1);
        Mockingbird.setReturnValue(false, hashMap2, "put", "(java.lang.Object,java.lang.Object)java.lang.Object", null, 1);
        Mockingbird.setReturnValue(false, threadLocal2, "get", "()java.lang.Object", new Object[] {}, hashMap3, 1);
        Mockingbird.setReturnValue(false, hashMap3, "put", "(java.lang.Object,java.lang.Object)java.lang.Object", null, 1);
        Callable callable = (Callable) Mockingbird.getProxyObject(Class.forName("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection$2"));
        Mockingbird.replaceObjectForRecording(Class.forName("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection$2"), "<init>(com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection,mondrian.server.Execution)", callable);
        Mockingbird.setReturnValue(RolapResultShepherd.shepherdExecution(execution, callable), null);
        Mockingbird.setReturnValue(false, threadLocal2, "get", "()java.lang.Object", new Object[] {}, hashMap4, 1);
        Mockingbird.setReturnValue(false, hashMap4, "remove", "(java.lang.Object)java.lang.Object", new Object[] {"SCHEMA_NAME"}, null, 1);
        Mockingbird.setReturnValue(false, threadLocal2, "get", "()java.lang.Object", new Object[] {}, hashMap5, 1);
        Mockingbird.setReturnValue(false, hashMap5, "remove", "(java.lang.Object)java.lang.Object", new Object[] {"CUBENAME"}, null, 1);
        Mockingbird.enterTestMode(MolapConnection.class);
        Result result = molapConnection.execute(execution);
        assertNull("result", result);
    }
    
    public void testGetcallableExecution() throws Throwable {
        Execution execution = Execution.NONE;
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        DataSource dataSource2 = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(dataSource2.getConnection(), null);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource2, null), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource2, "testMolapConnectionMd5Bytes"});
        MondrianServer server = MondrianServer.forId(null);
        Util.PropertyList connectInfo = new Util.PropertyList();
        Mockingbird.enterRecordingMode();
        callPrivateMethod("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {null, "testMolapConnectionParam2", dataSource});
        Mockingbird.setNormalReturnForVoid(true);
        Mockingbird.enterTestMode(MolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(server, connectInfo, schema, dataSource);
        Callable result = molapConnection.getcallableExecution(execution, "testMolapConnectionSchemaName", "testMolapConnectionCubeName", 100L);
        assertNotNull("result", result);
    }
    
    public void testQueryEnd() throws Throwable {
        MondrianServer server = MondrianServer.forId(null);
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Connection connection = (Connection) Mockingbird.getProxyObject(Connection.class);
        Mockingbird.setReturnValue(dataSource.getConnection(), connection);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource, connection), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        connection.close();
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource, "testMolapConnectionMd5Bytes"});
        Util.PropertyList connectInfo = new Util.PropertyList();
        DataSource dataSource2 = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        callPrivateMethod("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {null, "testMolapConnectionParam2", dataSource2});
        Mockingbird.setNormalReturnForVoid(true);
        Mockingbird.enterTestMode(MolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(server, connectInfo, schema, dataSource2);
        molapConnection.queryEnd("testMolapConnectionSchema", "testMolapConnectionCubeName", 100L);
        assertNotNull("molapConnectionRolapConnection.THREAD_LOCAL.get()", RolapConnection.THREAD_LOCAL.get());
    }
    
    public void testQueryStart() throws Throwable {
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Connection connection = (Connection) Mockingbird.getProxyObject(Connection.class);
        Mockingbird.setReturnValue(dataSource.getConnection(), connection);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource, connection), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        connection.close();
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource, "testMolapConnectionMd5Bytes"});
        DataSource dataSource2 = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        MondrianServer server = MondrianServer.forId(null);
        Util.PropertyList connectInfo = new Util.PropertyList();
        Mockingbird.enterRecordingMode();
        callPrivateMethod("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {null, "testMolapConnectionParam2", dataSource2});
        Mockingbird.setNormalReturnForVoid(true);
        Mockingbird.enterTestMode(MolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(server, connectInfo, schema, dataSource2);
        molapConnection.queryStart("testMolapConnectionSchema", "testMolapConnectionCubeName", 100L);
        assertNotNull("molapConnectionMolapConnection.THREAD_LOCAL.get()", MolapConnection.THREAD_LOCAL.get());
    }
    
    public void testValidateRolapCredentials() throws Throwable {
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Util.PropertyList connectInfo = new Util.PropertyList();
        DataSource dataSource2 = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Util.PropertyList propertyList = (Util.PropertyList) callPrivateMethod("mondrian.olap.Util$PropertyList", "<init>", new Class[] {List.class}, null, new Object[] {new ArrayList(100)});
        Mockingbird.enterRecordingMode();
        callPrivateMethod("mondrian.rolap.RolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {null, "testMolapConnectionParam2", dataSource2});
        Mockingbird.setNormalReturnForVoid(true);
        Connection connection = (Connection) Mockingbird.getProxyObject(Connection.class);
        Mockingbird.setReturnValue(dataSource2.getConnection(), connection);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource2, connection), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        connection.close();
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource2, "testMolapConnectionMd5Bytes"});
        StringBuilder buf = new StringBuilder();
        MondrianServer server = MondrianServer.createWithRepository(new StringRepositoryContentFinder("testMolapConnectionContent"), null);
        Mockingbird.enterRecordingMode();
        callPrivateMethod("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {null, "testMolapConnectionParam2", dataSource});
        Mockingbird.setNormalReturnForVoid(true);
        Mockingbird.enterTestMode(MolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(server, connectInfo, schema, dataSource);
        molapConnection.validateRolapCredentials(buf);
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testConstructorThrowsAssertionError() throws Throwable {
        Util.PropertyList connectInfo = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterTestMode(MolapConnection.class);
        try {
            new MolapConnection(null, connectInfo, dataSource);
            fail("Expected AssertionError to be thrown");
        } catch (AssertionError ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(RolapConnection.class, ex);
            assertNotNull("RolapConnection.LOGGER", getPrivateField(RolapConnection.class, "LOGGER"));
        }
    }
    
    public void testConstructorThrowsAssertionError1() throws Throwable {
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Util.PropertyList connectInfo = new Util.PropertyList();
        Mockingbird.enterTestMode(MolapConnection.class);
        try {
            new MolapConnection(null, connectInfo, null, dataSource);
            fail("Expected AssertionError to be thrown");
        } catch (AssertionError ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(RolapConnection.class, ex);
            assertNotNull("RolapConnection.LOGGER", getPrivateField(RolapConnection.class, "LOGGER"));
        }
    }
    
    public void testConstructorThrowsNullPointerException() throws Throwable {
        Util.PropertyList connectInfo = new Util.PropertyList();
        MondrianServer server = MondrianServer.createWithRepository(new UrlRepositoryContentFinder("testMolapConnectionUrl"), new CatalogLocatorImpl());
        connectInfo.put(null, "testMolapConnectionValue");
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterTestMode(MolapConnection.class);
        try {
            new MolapConnection(server, connectInfo, dataSource);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Util.PropertyList.class, ex);
            assertNotNull("RolapConnection.LOGGER", getPrivateField(RolapConnection.class, "LOGGER"));
        }
    }
    
    public void testCreateDataSourceThrowsAssertionError() throws Throwable {
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(dataSource.getConnection(), null);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource, null), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource, "testMolapConnectionMd5Bytes"});
        MolapConnection inMemoryOlapConnection = new InMemoryOlapConnection(MondrianServer.forId(null), Util.parseConnectString("testMolapConnections"), schema, (DataSource) Mockingbird.getProxyObject(DataSource.class));
        try {
            inMemoryOlapConnection.createDataSource(null, null, null);
            fail("Expected AssertionError to be thrown");
        } catch (AssertionError ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MolapConnection.class, ex);
        }
    }
    
    public void testCreateDataSourceThrowsMondrianException() throws Throwable {
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(dataSource.getConnection(), null);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource, null), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource, "testMolapConnectionMd5Bytes"});
        MolapConnection inMemoryOlapConnection = new InMemoryOlapConnection(MondrianServer.forId(null), Util.parseConnectString("testMolapConnections"), schema, (DataSource) Mockingbird.getProxyObject(DataSource.class));
        Util.PropertyList connectInfo = new Util.PropertyList();
        try {
            inMemoryOlapConnection.createDataSource(null, connectInfo, new StringBuilder());
            fail("Expected MondrianException to be thrown");
        } catch (MondrianException ex) {
            assertEquals("ex.getMessage()", "Mondrian Error:Internal error: Connect string '' must contain either InMemory or Hbase Driver'", ex.getMessage());
            assertThrownBy(MondrianResource._Def0.class, ex);
        }
    }
    
    public void testCreateDataSourceThrowsNullPointerException() throws Throwable {
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        DataSource dataSource2 = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(dataSource2.getConnection(), null);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource2, null), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource2, "testMolapConnectionMd5Bytes"});
        MondrianServer server = MondrianServer.forId(null);
        Util.PropertyList connectInfo = new Util.PropertyList();
        Mockingbird.enterRecordingMode();
        callPrivateMethod("com.huawei.unibi.molap.engine.mondrian.extensions.MolapConnection", "appendKeyValue", new Class[] {StringBuilder.class, String.class, Object.class}, null, new Object[] {null, "testMolapConnectionParam2", dataSource});
        Mockingbird.setNormalReturnForVoid(true);
        Mockingbird.enterTestMode(MolapConnection.class);
        MolapConnection molapConnection = new MolapConnection(server, connectInfo, schema, dataSource);
        Util.PropertyList connectInfo2 = new Util.PropertyList();
        connectInfo2.put(null, "testMolapConnectionValue");
        StringBuilder buf = new StringBuilder("testMolapConnectionParam1");
        buf.insert(0, 100.0);
        try {
            molapConnection.createDataSource(null, connectInfo2, buf);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Util.PropertyList.class, ex);
        }
    }
    
    public void testCreateDataSourceThrowsRuntimeExceptionWithAggressiveMocks() throws Throwable {
        storeStaticField(RolapConnectionProperties.class, "JdbcPassword");
        storeStaticField(RolapConnectionProperties.class, "Jdbc");
        storeStaticField(RolapConnectionProperties.class, "JdbcUser");
        storeStaticField(RolapConnectionProperties.class, "JdbcDrivers");
        MolapConnection molapConnection = (MolapConnection) Mockingbird.getProxyObject(MolapConnection.class, true);
        Util.PropertyList propertyList = (Util.PropertyList) Mockingbird.getProxyObject(Util.PropertyList.class);
        StringBuilder stringBuilder = new StringBuilder();
        RolapConnectionProperties rolapConnectionProperties = (RolapConnectionProperties) Mockingbird.getProxyObject(RolapConnectionProperties.class);
        RuntimeException runtimeException = (RuntimeException) Mockingbird.getProxyObject(RuntimeException.class);
        setPrivateField(RolapConnectionProperties.class, "Jdbc", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcUser", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcPassword", rolapConnectionProperties);
        setPrivateField(RolapConnectionProperties.class, "JdbcDrivers", rolapConnectionProperties);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(true, RolapConnection.class, "appendKeyValue", "(java.lang.StringBuilder,java.lang.String,java.lang.Object)void", null, 1);
        Mockingbird.setReturnValue(false, propertyList, "get", "(java.lang.String)java.lang.String", "", 1);
        Mockingbird.setReturnValue(propertyList.toString(), "");
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(StringBuilder.class), "toString", "()java.lang.String", "", 1);
        Mockingbird.setReturnValue(true, Util.class, "newInternal", "(java.lang.String)java.lang.RuntimeException", runtimeException, 1);
        Mockingbird.enterTestMode(MolapConnection.class);
        try {
            molapConnection.createDataSource(null, propertyList, stringBuilder);
            fail("Expected RuntimeException to be thrown");
        } catch (RuntimeException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
    
    public void testExecuteThrowsNullPointerException() throws Throwable {
        Execution execution = Execution.NONE;
        Util.PropertyList propertyList = new Util.PropertyList();
        DataSource dataSource = (DataSource) Mockingbird.getProxyObject(DataSource.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(dataSource.getConnection(), null);
        Dialect jdbcDialectImpl = (Dialect) Mockingbird.getProxyObject(Dialect.class);
        Mockingbird.setReturnValue(DialectManager.createDialect(dataSource, null), jdbcDialectImpl);
        Mockingbird.setReturnValue(jdbcDialectImpl.getDatabaseProduct(), Dialect.DatabaseProduct.UNKNOWN);
        Mockingbird.enterTestMode(MolapConnection.class);
        RolapSchema schema = (RolapSchema) callPrivateMethod("mondrian.rolap.RolapSchema", "<init>", new Class[] {String.class, Util.PropertyList.class, DataSource.class, String.class}, null, new Object[] {"testMolapConnectionKey", propertyList, dataSource, "testMolapConnectionMd5Bytes"});
        MolapConnection inMemoryOlapConnection = new InMemoryOlapConnection(MondrianServer.forId(null), Util.parseConnectString("testMolapConnections"), schema, (DataSource) Mockingbird.getProxyObject(DataSource.class));
        try {
            inMemoryOlapConnection.execute(execution);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MolapConnection.class, ex);
        }
    }
}

