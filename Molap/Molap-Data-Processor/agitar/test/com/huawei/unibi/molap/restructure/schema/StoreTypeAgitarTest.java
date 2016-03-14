/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on Jul 31, 2013 6:23:39 PM
 * Time to generate: 00:09.549 seconds
 *
 */

package com.huawei.unibi.molap.restructure.schema;

import com.agitar.lib.junit.AgitarTestCase;

public class StoreTypeAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return StoreType.class;
    }
    
    public void testValueOf() throws Throwable {
        StoreType result = StoreType.valueOf("INMEMORY");
        assertEquals("result", StoreType.INMEMORY, result);
    }
    
    public void testValues() throws Throwable {
        StoreType[] result = StoreType.values();
        assertEquals("result.length", 1, result.length);
        assertEquals("result[0]", StoreType.INMEMORY, result[0]);
    }
    
    public void testValueOfThrowsIllegalArgumentException() throws Throwable {
        try {
            StoreType.valueOf("testStoreTypeParam1");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals("ex.getMessage()", "No enum const class com.huawei.unibi.molap.restructure.schema.StoreType.testStoreTypeParam1", ex.getMessage());
            assertThrownBy(Enum.class, ex);
        }
    }
    
    public void testValueOfThrowsNullPointerException() throws Throwable {
        try {
            StoreType.valueOf(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertEquals("ex.getMessage()", "Name is null", ex.getMessage());
            assertThrownBy(Enum.class, ex);
        }
    }
}

