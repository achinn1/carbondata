/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on 29 Jul, 2013 5:00:08 PM
 * Time to generate: 00:12.693 seconds
 *
 */

package com.huawei.unibi.molap.engine.datastorage;

import com.agitar.lib.junit.AgitarTestCase;

public class MemberAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return Member.class;
    }
    
    public void testConstructor() throws Throwable {
        char[] name = new char[2];
        Member member = new Member(name);
        assertNull("member.attributes", member.attributes);
        assertSame("member.name", name, member.name);
    }
    
    public void testEquals() throws Throwable {
        char[] name = new char[1];
        Member obj = new Member(name);
        boolean result = obj.equals(obj);
        assertTrue("result", result);
    }
    
    public void testEquals1() throws Throwable {
        char[] name = new char[1];
        boolean result = new Member(name).equals("");
        assertFalse("result", result);
    }
    
    public void testEquals2() throws Throwable {
        char[] name = new char[1];
        char[] name2 = new char[3];
        boolean result = new Member(name).equals(new Member(name2));
        assertFalse("result", result);
    }
    
    public void testGetAttributes() throws Throwable {
        char[] name = new char[0];
        Member member = new Member(name);
        Object[] properties = new Object[3];
        member.setAttributes(properties);
        Object[] result = member.getAttributes();
        assertSame("result", properties, result);
        assertNull("properties[0]", properties[0]);
    }
    
    public void testGetCharArray() throws Throwable {
        char[] name = new char[3];
        char[] result = new Member(name).getCharArray();
        assertSame("result", name, result);
        assertEquals("name[0]", '\u0000', name[0]);
    }
    
    public void testGetCharArray1() throws Throwable {
        char[] name = new char[0];
        char[] result = new Member(name).getCharArray();
        assertSame("result", name, result);
    }
    
    public void testHashCode() throws Throwable {
        char[] name = new char[1];
        int result = new Member(name).hashCode();
        assertEquals("result", 62, result);
    }
    
    public void testSetAttributes() throws Throwable {
        char[] name = new char[0];
        Member member = new Member(name);
        Object[] properties = new Object[1];
        member.setAttributes(properties);
        assertSame("member.attributes", properties, member.attributes);
    }
    
    public void testToString() throws Throwable {
        char[] name = new char[1];
        String result = new Member(name).toString();
        assertEquals("result", "\u0000", result);
    }
}

