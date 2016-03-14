/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on 29 Jul, 2013 4:49:00 PM
 * Time to generate: 00:18.742 seconds
 *
 */

package com.huawei.unibi.molap.engine.util;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.huawei.unibi.molap.util.ByteUtil;

public class ByteArrayWrapperAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return ByteArrayWrapper.class;
    }
    
    public void testConstructor() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        assertNull("byteArrayWrapper.getData()", byteArrayWrapper.getData());
    }
    
    public void testCompareTo() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        ByteArrayWrapper other = new ByteArrayWrapper();
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, ByteUtil.compare((byte[]) null, (byte[]) null), -5);
        Mockingbird.enterTestMode(ByteArrayWrapper.class);
        int result = byteArrayWrapper.compareTo(other);
        assertEquals("result", -5, result);
    }
    
    public void testCompareTo1() throws Throwable {
        ByteArrayWrapper other = new ByteArrayWrapper();
        int result = other.compareTo(other);
        assertEquals("result", 0, result);
    }
    
    public void testEquals() throws Throwable {
        ByteArrayWrapper other = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[1];
        other.setData(data, 100, 0, maxKey, 1000);
        boolean result = new ByteArrayWrapper().equals(other);
        assertFalse("result", result);
    }
    
    public void testEquals1() throws Throwable {
        ByteArrayWrapper other = new ByteArrayWrapper();
        boolean result = other.equals(other);
        assertTrue("result", result);
    }
    
    public void testEquals2() throws Throwable {
        boolean result = new ByteArrayWrapper().equals(new Integer(1));
        assertFalse("result", result);
    }
    
    public void testGetData() throws Throwable {
        byte[] data = new byte[0];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byteArrayWrapper.setActualData(data);
        byte[] result = byteArrayWrapper.getData();
        assertSame("result", data, result);
    }
    
    public void testGetData1() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[2];
        byteArrayWrapper.setActualData(data);
        byte[] result = byteArrayWrapper.getData();
        assertSame("result", data, result);
        assertEquals("data[0]", (byte)0, data[0]);
    }
    
    public void testGetHashCode() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] maskKey = new byte[2];
        int result = byteArrayWrapper.getHashCode(maskKey);
        assertEquals("result", 961, result);
    }
    
    public void testGetHashCode1() throws Throwable {
        byte[] maskKey = new byte[0];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        int result = byteArrayWrapper.getHashCode(maskKey);
        assertEquals("result", 1, result);
    }
    
    public void testHashCode() throws Throwable {
        byte[] data = new byte[3];
        byte[] maxKey = new byte[2];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byteArrayWrapper.setData(data, 0, 1, maxKey, 100);
        int result = byteArrayWrapper.hashCode();
        assertEquals("result", 31, result);
    }
    
    public void testHashCode1() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[1];
        byteArrayWrapper.setData(data, 100, 0, maxKey, 1000);
        int result = byteArrayWrapper.hashCode();
        assertEquals("result", 1, result);
    }
    
    public void testSetActualData() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[1];
        byteArrayWrapper.setActualData(data);
        assertSame("byteArrayWrapper.getData()", data, byteArrayWrapper.getData());
    }
    
    public void testSetActualData1() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[3];
        byteArrayWrapper.setActualData(data, 0, 1);
        assertEquals("byteArrayWrapper.getData().length", 1, byteArrayWrapper.getData().length);
    }
    
    public void testSetData() throws Throwable {
        byte[] data = new byte[3];
        byte[] maxKey = new byte[2];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byteArrayWrapper.setData(data, 0, 1, maxKey, 100);
        assertEquals("byteArrayWrapper.hashCode()", 31, byteArrayWrapper.hashCode());
    }
    
    public void testSetData1() throws Throwable {
        int[] maskByteRanges = new int[0];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[2];
        byteArrayWrapper.setData(data, 100, maxKey, maskByteRanges, 1000);
        byte[] data2 = new byte[1];
        byte[] maxKey2 = new byte[3];
        byteArrayWrapper.setData(data2, 0, 1, maxKey2, 100);
        assertEquals("byteArrayWrapper.hashCode()", -428854527, byteArrayWrapper.hashCode());
    }
    
    public void testSetData2() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[1];
        byteArrayWrapper.setData(data, 100, 0, maxKey, 1000);
        byte[] data2 = new byte[2];
        byte[] maxKey2 = new byte[3];
        byteArrayWrapper.setData(data2, 100, 0, maxKey2, 1000);
        assertEquals("byteArrayWrapper.hashCode()", 1, byteArrayWrapper.hashCode());
    }
    
    public void testSetData3() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[1];
        byteArrayWrapper.setData(data, 100, 0, maxKey, 1000);
        assertEquals("byteArrayWrapper.hashCode()", 1, byteArrayWrapper.hashCode());
    }
    
    public void testSetData4() throws Throwable {
        int[] maskByteRanges = new int[0];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[2];
        byteArrayWrapper.setData(data, 100, maxKey, maskByteRanges, 1000);
        assertEquals("byteArrayWrapper.hashCode()", -428854527, byteArrayWrapper.hashCode());
    }
    
    public void testSetData5() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[1];
        byteArrayWrapper.setData(data, 100, 0, maxKey, 1000);
        byte[] data2 = new byte[1];
        byte[] maxKey2 = new byte[1];
        int[] maskByteRanges = new int[0];
        byteArrayWrapper.setData(data2, 100, maxKey2, maskByteRanges, 1000);
        assertEquals("byteArrayWrapper.hashCode()", 1, byteArrayWrapper.hashCode());
    }
    
    public void testSetData6() throws Throwable {
        byte[] data = new byte[3];
        byte[] maxKey = new byte[2];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byteArrayWrapper.setData(data, 0, 1, maxKey, 100);
        byte[] data2 = new byte[2];
        byte[] maxKey2 = new byte[1];
        int[] maskByteRanges = new int[1];
        byteArrayWrapper.setData(data2, 0, maxKey2, maskByteRanges, 100);
        assertEquals("byteArrayWrapper.hashCode()", 31, byteArrayWrapper.hashCode());
    }
    
    public void testSetData7() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[3];
        byte[] maxKey = new byte[3];
        int[] maskByteRanges = new int[1];
        maskByteRanges[0] = 2;
        byteArrayWrapper.setData(data, 0, maxKey, maskByteRanges, 100);
        assertEquals("byteArrayWrapper.hashCode()", 1493912449, byteArrayWrapper.hashCode());
    }
    
    public void testCompareToThrowsNullPointerException() throws Throwable {
        int[] maskByteRanges = new int[0];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[2];
        byteArrayWrapper.setData(data, 100, maxKey, maskByteRanges, 1000);
        try {
            byteArrayWrapper.compareTo(new ByteArrayWrapper());
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteUtil.class, ex);
        }
    }
    
    public void testGetHashCodeThrowsNullPointerException() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        try {
            byteArrayWrapper.getHashCode((byte[]) null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
        }
    }
    
    public void testHashCodeThrowsNullPointerException() throws Throwable {
        try {
            new ByteArrayWrapper().hashCode();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
        }
    }
    
    public void testSetActualDataThrowsArrayIndexOutOfBoundsException() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[3];
        try {
            byteArrayWrapper.setActualData(data, 100, 1000);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(System.class, ex);
            assertNull("byteArrayWrapper.getData()", byteArrayWrapper.getData());
        }
    }
    
    public void testSetActualDataThrowsNegativeArraySizeException() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[2];
        try {
            byteArrayWrapper.setActualData(data, 100, -1);
            fail("Expected NegativeArraySizeException to be thrown");
        } catch (NegativeArraySizeException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertNull("byteArrayWrapper.getData()", byteArrayWrapper.getData());
        }
    }
    
    public void testSetActualDataThrowsNullPointerException() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        try {
            byteArrayWrapper.setActualData((byte[]) null, 100, 1000);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(System.class, ex);
            assertNull("byteArrayWrapper.getData()", byteArrayWrapper.getData());
        }
    }
    
    public void testSetDataThrowsArrayIndexOutOfBoundsException() throws Throwable {
        byte[] data = new byte[1];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] maxKey = new byte[0];
        try {
            byteArrayWrapper.setData(data, 100, 1000, maxKey, 0);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("byteArrayWrapper.hashCode()", -428854527, byteArrayWrapper.hashCode());
            assertEquals("ex.getMessage()", "100", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
        }
    }
    
    public void testSetDataThrowsArrayIndexOutOfBoundsException1() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[3];
        byte[] maxKey = new byte[2];
        int[] maskByteRanges = new int[0];
        byteArrayWrapper.setData(data, 100, maxKey, maskByteRanges, 1000);
        byte[] data2 = new byte[2];
        byte[] maxKey2 = new byte[2];
        try {
            byteArrayWrapper.setData(data2, 0, 100, maxKey2, 1000);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "2", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertEquals("byteArrayWrapper.hashCode()", -428854527, byteArrayWrapper.hashCode());
        }
    }
    
    public void testSetDataThrowsArrayIndexOutOfBoundsException2() throws Throwable {
        byte[] maxKey = new byte[1];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[1];
        try {
            byteArrayWrapper.setData(data, 0, 100, maxKey, 1000);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("byteArrayWrapper.hashCode()", 1493912449, byteArrayWrapper.hashCode());
            assertEquals("ex.getMessage()", "1", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
        }
    }
    
    public void testSetDataThrowsArrayIndexOutOfBoundsException3() throws Throwable {
        byte[] data = new byte[1];
        byte[] maxKey = new byte[3];
        int[] maskByteRanges = new int[2];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        try {
            byteArrayWrapper.setData(data, 0, maxKey, maskByteRanges, 1);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("byteArrayWrapper.hashCode()", 31, byteArrayWrapper.hashCode());
            assertEquals("ex.getMessage()", "1", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
        }
    }
    
    public void testSetDataThrowsArrayIndexOutOfBoundsException4() throws Throwable {
        byte[] data = new byte[3];
        byte[] maxKey = new byte[2];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byteArrayWrapper.setData(data, 0, 1, maxKey, 100);
        byte[] data2 = new byte[3];
        byte[] maxKey2 = new byte[1];
        int[] maskByteRanges = new int[3];
        try {
            byteArrayWrapper.setData(data2, 0, maxKey2, maskByteRanges, 100);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "1", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertEquals("byteArrayWrapper.hashCode()", 31, byteArrayWrapper.hashCode());
        }
    }
    
    public void testSetDataThrowsArrayIndexOutOfBoundsException5() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[1];
        byteArrayWrapper.setData(data, 100, 0, maxKey, 1000);
        byte[] data2 = new byte[0];
        byte[] maxKey2 = new byte[2];
        int[] maskByteRanges = new int[1];
        try {
            byteArrayWrapper.setData(data2, 100, maxKey2, maskByteRanges, 1000);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "100", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertEquals("byteArrayWrapper.hashCode()", 1, byteArrayWrapper.hashCode());
        }
    }
    
    public void testSetDataThrowsNegativeArraySizeException() throws Throwable {
        byte[] data = new byte[2];
        byte[] maxKey = new byte[1];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        try {
            byteArrayWrapper.setData(data, 100, -1, maxKey, 1000);
            fail("Expected NegativeArraySizeException to be thrown");
        } catch (NegativeArraySizeException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertNull("byteArrayWrapper.maskedKey", getPrivateField(byteArrayWrapper, "maskedKey"));
        }
    }
    
    public void testSetDataThrowsNegativeArraySizeException1() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[1];
        byte[] maxKey = new byte[0];
        int[] maskByteRanges = new int[3];
        try {
            byteArrayWrapper.setData(data, 100, maxKey, maskByteRanges, -1);
            fail("Expected NegativeArraySizeException to be thrown");
        } catch (NegativeArraySizeException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertNull("byteArrayWrapper.maskedKey", getPrivateField(byteArrayWrapper, "maskedKey"));
        }
    }
    
    public void testSetDataThrowsNullPointerException() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[1];
        byteArrayWrapper.setData(data, 100, 0, maxKey, 1000);
        byte[] maxKey2 = new byte[1];
        try {
            byteArrayWrapper.setData((byte[]) null, 100, 1000, maxKey2, 0);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertEquals("byteArrayWrapper.hashCode()", 1, byteArrayWrapper.hashCode());
        }
    }
    
    public void testSetDataThrowsNullPointerException1() throws Throwable {
        int[] maskByteRanges = new int[0];
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[2];
        byteArrayWrapper.setData(data, 100, maxKey, maskByteRanges, 1000);
        byte[] data2 = new byte[0];
        byte[] maxKey2 = new byte[2];
        try {
            byteArrayWrapper.setData(data2, 100, maxKey2, (int[]) null, 1000);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
            assertEquals("byteArrayWrapper.hashCode()", -428854527, byteArrayWrapper.hashCode());
        }
    }
    
    public void testSetDataThrowsNullPointerException2() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        int[] maskByteRanges = new int[3];
        byte[] data = new byte[2];
        try {
            byteArrayWrapper.setData(data, 0, (byte[]) null, maskByteRanges, 100);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertEquals("byteArrayWrapper.hashCode()", 1493912449, byteArrayWrapper.hashCode());
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
        }
    }
    
    public void testSetDataThrowsNullPointerException3() throws Throwable {
        ByteArrayWrapper byteArrayWrapper = new ByteArrayWrapper();
        byte[] data = new byte[0];
        byte[] maxKey = new byte[2];
        try {
            byteArrayWrapper.setData(data, 100, maxKey, (int[]) null, 1000);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertEquals("byteArrayWrapper.hashCode()", -428854527, byteArrayWrapper.hashCode());
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteArrayWrapper.class, ex);
        }
    }
}

