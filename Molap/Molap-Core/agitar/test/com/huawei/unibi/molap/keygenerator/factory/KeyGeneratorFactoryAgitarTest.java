/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on 29 Jul, 2013 2:30:34 PM
 * Time to generate: 00:13.631 seconds
 *
 */

package com.huawei.unibi.molap.keygenerator.factory;

import com.agitar.lib.junit.AgitarTestCase;
import com.huawei.unibi.molap.keygenerator.mdkey.MultiDimKeyVarLengthGenerator;
import com.huawei.unibi.molap.util.MolapUtil;

public class KeyGeneratorFactoryAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return KeyGeneratorFactory.class;
    }
    
    public void testConstructor() throws Throwable {
        new KeyGeneratorFactory();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testGetKeyGenerator() throws Throwable {
        int[] dimesion = new int[3];
        MultiDimKeyVarLengthGenerator result = (MultiDimKeyVarLengthGenerator) KeyGeneratorFactory.getKeyGenerator(dimesion);
        assertEquals("result.getDimCount()", 3, result.getDimCount());
    }
    
    public void testGetKeyGeneratorThrowsNullPointerException() throws Throwable {
        try {
            KeyGeneratorFactory.getKeyGenerator((int[]) null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(MolapUtil.class, ex);
        }
    }
}

