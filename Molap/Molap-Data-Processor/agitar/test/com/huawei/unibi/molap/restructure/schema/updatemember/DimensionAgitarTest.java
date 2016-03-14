/**
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on Aug 13, 2013 6:11:54 PM
 * Time to generate: 00:23.167 seconds
 *
 */

package com.huawei.unibi.molap.restructure.schema.updatemember;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.huawei.unibi.molap.restructure.schema.model.HierarchyBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DimensionAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return Dimension.class;
    }
    
    public void testConstructor() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        assertEquals("dimension.getName()", "testDimensionName", dimension.getName());
    }
    
    public void testCanMove() throws Throwable {
        List moveTo = new ArrayList(100);
        moveTo.add(new Level("testDimensionValue"));
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setMoveTo(moveTo);
        dimension.setMoveFrom(new LinkedList());
        boolean result = dimension.canMove();
        assertFalse("result", result);
    }
    
    public void testGetLevelToUpdate() throws Throwable {
        List levels = new ArrayList(100);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setLevels(levels);
        Level result = dimension.getLevelToUpdate();
        assertNull("result", result);
        assertSame("dimension.getLevels()", levels, dimension.getLevels());
    }
    
    public void testGetLevelToUpdate1() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List levels = new ArrayList(100);
        levels.add(new Level("testDimensionValue"));
        dimension.setLevels(levels);
        Level result = dimension.getLevelToUpdate();
        assertNull("result", result);
        assertSame("dimension.getLevels()", levels, dimension.getLevels());
    }
    
    public void testGetLevelToUpdateWithAggressiveMocks() throws Throwable {
        Dimension dimension = (Dimension) Mockingbird.getProxyObject(Dimension.class, true);
        List list = (List) Mockingbird.getProxyObject(List.class);
        Iterator iterator = (Iterator) Mockingbird.getProxyObject(Iterator.class);
        Level level = (Level) Mockingbird.getProxyObject(Level.class);
        Level level2 = (Level) Mockingbird.getProxyObject(Level.class);
        Level level3 = (Level) Mockingbird.getProxyObject(Level.class);
        Level level4 = (Level) Mockingbird.getProxyObject(Level.class);
        Level level5 = (Level) Mockingbird.getProxyObject(Level.class);
        dimension.setLevels(list);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.iterator(), iterator);
        Mockingbird.enterNormalMode();
        level.setRenameTo("");
        level2.setRenameTo("");
        level3.setRenameTo(null);
        level4.setRenameTo(null);
        level5.setRenameTo("");
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(iterator.hasNext(), true);
        Mockingbird.setReturnValue(iterator.next(), level);
        Boolean boolean2 = Boolean.TRUE;
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "isEmpty", "()boolean", boolean2, 1);
        Mockingbird.setReturnValue(iterator.hasNext(), true);
        Mockingbird.setReturnValue(iterator.next(), level2);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "isEmpty", "()boolean", boolean2, 1);
        Mockingbird.setReturnValue(iterator.hasNext(), true);
        Mockingbird.setReturnValue(iterator.next(), level3);
        Mockingbird.setReturnValue(iterator.hasNext(), true);
        Mockingbird.setReturnValue(iterator.next(), level4);
        Mockingbird.setReturnValue(iterator.hasNext(), true);
        Mockingbird.setReturnValue(iterator.next(), level5);
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(String.class), "isEmpty", "()boolean", Boolean.FALSE, 1);
        Mockingbird.enterTestMode(Dimension.class);
        Level result = dimension.getLevelToUpdate();
        assertNull("result.getValue()", result.getValue());
        assertNotNull("dimension.getLevels()", dimension.getLevels());
    }
    
    public void testGetParentOfFromWithAggressiveMocks() throws Throwable {
        Dimension dimension = (Dimension) Mockingbird.getProxyObject(Dimension.class, true);
        List list = (List) Mockingbird.getProxyObject(List.class);
        Level level = (Level) Mockingbird.getProxyObject(Level.class);
        dimension.setMoveFrom(list);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.size(), 1);
        Mockingbird.enterNormalMode();
        level.setIndex(1);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.get(0), level);
        Mockingbird.setReturnValue(list.size(), -2);
        Mockingbird.enterTestMode(Dimension.class);
        Level result = dimension.getParentOfFrom();
        assertNull("result", result);
        assertNotNull("dimension.getMoveFrom()", dimension.getMoveFrom());
    }
    
    public void testGetParentOfFromWithAggressiveMocks1() throws Throwable {
        Dimension dimension = (Dimension) Mockingbird.getProxyObject(Dimension.class, true);
        List list = (List) Mockingbird.getProxyObject(List.class);
        Level level = (Level) Mockingbird.getProxyObject(Level.class);
        dimension.setMoveFrom(list);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.size(), 1);
        Mockingbird.enterNormalMode();
        level.setIndex(-1);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.get(0), level);
        Mockingbird.enterTestMode(Dimension.class);
        Level result = dimension.getParentOfFrom();
        assertNull("result", result);
        assertNotNull("dimension.getMoveFrom()", dimension.getMoveFrom());
    }
    
    public void testGetParentOfFromWithAggressiveMocks2() throws Throwable {
        Dimension dimension = (Dimension) Mockingbird.getProxyObject(Dimension.class, true);
        List list = (List) Mockingbird.getProxyObject(List.class);
        Level level = (Level) Mockingbird.getProxyObject(Level.class);
        dimension.setMoveFrom(list);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.size(), 1);
        Mockingbird.enterNormalMode();
        level.setIndex(1);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.get(0), level);
        Mockingbird.setReturnValue(list.size(), 0);
        Mockingbird.setReturnValue(list.get(0), null);
        Mockingbird.enterTestMode(Dimension.class);
        Level result = dimension.getParentOfFrom();
        assertNull("result", result);
        assertNotNull("dimension.getMoveFrom()", dimension.getMoveFrom());
    }
    
    public void testGetParentOfTo() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        Mockingbird.enterRecordingMode();
        Level level = (Level) Mockingbird.getProxyObject(Level.class);
        Mockingbird.setReturnValue(dimension.getLevelToMove(), level);
        Mockingbird.setReturnValue(level.getIndex(), -1);
        Mockingbird.enterTestMode(Dimension.class);
        Level result = dimension.getParentOfTo();
        assertNull("result", result);
    }
    
    public void testGetParentOfToWithAggressiveMocks() throws Throwable {
        Dimension dimension = (Dimension) Mockingbird.getProxyObject(Dimension.class, true);
        List list = (List) Mockingbird.getProxyObject(List.class);
        List list2 = (List) Mockingbird.getProxyObject(List.class);
        Level level = (Level) Mockingbird.getProxyObject(Level.class);
        dimension.setMoveFrom(list);
        dimension.setMoveTo(list2);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.size(), 1);
        Mockingbird.enterNormalMode();
        level.setIndex(1);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.get(0), level);
        Mockingbird.setReturnValue(list2.size(), -2);
        Mockingbird.enterTestMode(Dimension.class);
        Level result = dimension.getParentOfTo();
        assertNull("result", result);
        assertNotNull("dimension.getMoveTo()", dimension.getMoveTo());
        assertNotNull("dimension.getMoveFrom()", dimension.getMoveFrom());
    }
    
    public void testGetParentOfToWithAggressiveMocks1() throws Throwable {
        Dimension dimension = (Dimension) Mockingbird.getProxyObject(Dimension.class, true);
        List list = (List) Mockingbird.getProxyObject(List.class);
        List list2 = (List) Mockingbird.getProxyObject(List.class);
        Level level = (Level) Mockingbird.getProxyObject(Level.class);
        dimension.setMoveFrom(list);
        dimension.setMoveTo(list2);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.size(), 1);
        Mockingbird.enterNormalMode();
        level.setIndex(1);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.get(0), level);
        Mockingbird.setReturnValue(list2.size(), 0);
        Mockingbird.setReturnValue(list2.get(0), null);
        Mockingbird.enterTestMode(Dimension.class);
        Level result = dimension.getParentOfTo();
        assertNull("result", result);
        assertNotNull("dimension.getMoveTo()", dimension.getMoveTo());
        assertNotNull("dimension.getMoveFrom()", dimension.getMoveFrom());
    }
    
    public void testSetHierarchyBean() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        HierarchyBean hierarchyBean = (HierarchyBean) Mockingbird.getProxyObject(HierarchyBean.class);
        Mockingbird.enterTestMode(Dimension.class);
        dimension.setHierarchyBean(hierarchyBean);
        assertSame("dimension.getHierarchyBean()", hierarchyBean, dimension.getHierarchyBean());
    }
    
    public void testSetLevels() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List levels = new ArrayList(100);
        dimension.setLevels(levels);
        assertSame("dimension.getLevels()", levels, dimension.getLevels());
    }
    
    public void testSetMoveFrom() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        dimension.setMoveFrom(moveFrom);
        assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
    }
    
    public void testSetMoveTo() throws Throwable {
        List moveTo = new ArrayList(100);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setMoveTo(moveTo);
        assertSame("dimension.getMoveTo()", moveTo, dimension.getMoveTo());
    }
    
    public void testSetName() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setName("testDimensionName");
        assertEquals("dimension.getName()", "testDimensionName", dimension.getName());
    }
    
    public void testCanMoveThrowsArrayIndexOutOfBoundsException() throws Throwable {
        List moveTo = new ArrayList(100);
        List moveFrom = new ArrayList(1000);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setMoveTo(moveTo);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.canMove();
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(ArrayList.class, ex);
            assertSame("dimension.getMoveTo()", moveTo, dimension.getMoveTo());
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testCanMoveThrowsIndexOutOfBoundsException() throws Throwable {
        List moveFrom = new LinkedList();
        List moveTo = new ArrayList(100);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setMoveTo(moveTo);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.canMove();
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "Index: -1, Size: 0", ex.getMessage());
            assertThrownBy(LinkedList.class, ex);
            assertSame("dimension.getMoveTo()", moveTo, dimension.getMoveTo());
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testCanMoveThrowsNullPointerException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        try {
            dimension.canMove();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertNull("dimension.getMoveTo()", dimension.getMoveTo());
            assertNull("dimension.getMoveFrom()", dimension.getMoveFrom());
        }
    }
    
    public void testCanMoveThrowsNullPointerException1() throws Throwable {
        List moveFrom = new ArrayList(100);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.canMove();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertNull("dimension.getMoveTo()", dimension.getMoveTo());
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testCopyLevelBeansThrowsNoClassDefFoundError() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setHierarchyBean((HierarchyBean) Mockingbird.getProxyObject(HierarchyBean.class));
        Mockingbird.enterTestMode(Dimension.class);
        try {
            dimension.copyLevelBeans();
            fail("Expected NoClassDefFoundError to be thrown");
        } catch (NoClassDefFoundError ex) {
            assertEquals("ex.getMessage()", "com/huawei/unibi/molap/keygenerator/KeyGenerator", ex.getMessage());
            assertThrownBy(Class.class, ex);
            assertNull("dimension.getMoveTo()", dimension.getMoveTo());
            assertNull("dimension.getMoveFrom()", dimension.getMoveFrom());
            assertNull("dimension.getLevels()", dimension.getLevels());
        }
    }
    
    public void testCopyLevelBeansThrowsNullPointerException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        try {
            dimension.copyLevelBeans();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertNull("dimension.getMoveTo()", dimension.getMoveTo());
            assertNull("dimension.getMoveFrom()", dimension.getMoveFrom());
            assertNull("dimension.getLevels()", dimension.getLevels());
        }
    }
    
    public void testGetDimsThrowsNoClassDefFoundError() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setHierarchyBean((HierarchyBean) Mockingbird.getProxyObject(HierarchyBean.class));
        Mockingbird.enterTestMode(Dimension.class);
        try {
            dimension.getDims();
            fail("Expected NoClassDefFoundError to be thrown");
        } catch (NoClassDefFoundError ex) {
            assertEquals("ex.getMessage()", "com/huawei/unibi/molap/keygenerator/KeyGenerator", ex.getMessage());
            assertThrownBy(Class.class, ex);
        }
    }
    
    public void testGetDimsThrowsNullPointerException() throws Throwable {
        try {
            new Dimension("testDimensionName").getDims();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
        }
    }
    
    public void testGetLevelToMoveThrowsArrayIndexOutOfBoundsException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getLevelToMove();
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(ArrayList.class, ex);
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testGetLevelToMoveThrowsIndexOutOfBoundsException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getLevelToMove();
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(ArrayList.class, ex);
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testGetLevelToMoveThrowsNullPointerException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setMoveFrom(null);
        try {
            dimension.getLevelToMove();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertNull("dimension.getMoveFrom()", dimension.getMoveFrom());
        }
    }
    
    public void testGetLevelToUpdateThrowsNullPointerException() throws Throwable {
        List levels = new ArrayList(100);
        levels.add(new Level("testDimensionValue"));
        levels.add((Object) null);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setLevels(levels);
        try {
            dimension.getLevelToUpdate();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertSame("dimension.getLevels()", levels, dimension.getLevels());
        }
    }
    
    public void testGetLevelToUpdateThrowsNullPointerException1() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        try {
            dimension.getLevelToUpdate();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertNull("dimension.getLevels()", dimension.getLevels());
        }
    }
    
    public void testGetLevelToUpdateThrowsNullPointerException2() throws Throwable {
        List levels = new ArrayList(100);
        levels.add((Object) null);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setLevels(levels);
        try {
            dimension.getLevelToUpdate();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertSame("dimension.getLevels()", levels, dimension.getLevels());
        }
    }
    
    public void testGetParentOfFromThrowsArrayIndexOutOfBoundsException() throws Throwable {
        List moveFrom = new ArrayList(100);
        Dimension dimension = new Dimension("testDimensionName");
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getParentOfFrom();
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(ArrayList.class, ex);
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testGetParentOfFromThrowsIndexOutOfBoundsException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getParentOfFrom();
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(ArrayList.class, ex);
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testGetParentOfFromThrowsNullPointerException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        moveFrom.add((Object) null);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getParentOfFrom();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testGetParentOfToThrowsArrayIndexOutOfBoundsException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getParentOfTo();
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(ArrayList.class, ex);
            assertNull("dimension.getMoveTo()", dimension.getMoveTo());
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testGetParentOfToThrowsIndexOutOfBoundsException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getParentOfTo();
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(ArrayList.class, ex);
            assertNull("dimension.getMoveTo()", dimension.getMoveTo());
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
    
    public void testGetParentOfToThrowsNullPointerException() throws Throwable {
        Dimension dimension = new Dimension("testDimensionName");
        List moveFrom = new ArrayList(100);
        moveFrom.add((Object) null);
        dimension.setMoveFrom(moveFrom);
        try {
            dimension.getParentOfTo();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(Dimension.class, ex);
            assertNull("dimension.getMoveTo()", dimension.getMoveTo());
            assertSame("dimension.getMoveFrom()", moveFrom, dimension.getMoveFrom());
        }
    }
}

