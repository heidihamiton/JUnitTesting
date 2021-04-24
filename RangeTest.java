package org.jfree.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest extends TestCase {
	
	double upperRange;
	double lowerRange;
	Range rangeObjectUnderTest;
	Range range1;
	Range range2; 
	Range newRange;
	int desired_element;
	int[] input_array;
	//double valueContained;
	

	//@BeforeClass
	//public static void setUpBeforeClass() throws Exception {
	//}

	//@AfterClass
	//public static void tearDownAfterClass() throws Exception {
	//}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		upperRange = 5;
		lowerRange = -5;
		rangeObjectUnderTest = new Range(lowerRange, upperRange);
		
	}
  
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	@Test 
	public void testCentralValueShouldBeZero() { 
		double expected = (upperRange+lowerRange) /2.0;
			 assertEquals("The central value of "+lowerRange +" and "+upperRange +" should be "+expected, 
			 expected, rangeObjectUnderTest.getCentralValue(), 0.000000001d); 
			 
			 //System.out.println("Cental value is " + rangeObjectUnderTest.getCentralValue());
	} 
	
	public void testGetLowerBoundShouldBeMinusFive() {
		double expected = lowerRange;
				assertEquals("The lower bound value of -5 and 5 should be"+expected,
				expected, rangeObjectUnderTest.getLowerBound());
	}
			
	public void testGetUpperBoundShouldBeFive() {
		double expected = upperRange;
			assertEquals("The upper bound value should be " +expected,
			expected, rangeObjectUnderTest.getUpperBound());
	}
	
	public void testGetLengthShouldBeTen() {
			assertEquals("The length value of -5 and 5 should be 10",
			10, rangeObjectUnderTest.getLength(), 0.000000001d);
	}
	
	 public void testRange() {
		 Range r1 = new Range(-50, 100);
	 }
	 public void testRange1() {
		 Range r1 = new Range(5.88, 5.89); 
	 }

	
	//   			----TESTS FOR CONTAINS----
	//Basic test to ensure this works - comes back True as it should
	public void testContainsShouldBeTrue() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(0));
	}
	public void testContainsShouldBeTrueMinusFive() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(-5));
	}
	public void testContainsShouldBeTrueMinusFour() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(-4));
	}
	public void testContainsShouldBeTrueMinusThree() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(-3));
	}
	public void testContainsShouldBeTrueMinusTwo() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(-2));
	}
	public void testContainsShouldBeTrueMinusOne() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(-1));
	}
	public void testContainsShouldBeTrueFive() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(5));
	}
	public void testContainsShouldBeTrueFour() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(4));
	}
	public void testContainsShouldBeTrueThree() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(3));
	}
	public void testContainsShouldBeTrueTwo() {
		assertTrue("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(2));
	}
	
	public void testContainsShouldBeFalse2() {
        assertFalse("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(-15));
    }
	
	public void testContainsShouldBeFalse3() {
        assertFalse("The contains value of -5 and 5 should be TRUE", rangeObjectUnderTest.contains(367));
    }
	
//	----TESTS FOR INTERSECTS----
	public void testIntersects() {
		assertTrue("The intersects value of -5 and 5 is True", rangeObjectUnderTest.intersects(-5, 5));
	}
	public void testIntersects1() {
		assertTrue("The intersects value of -5 and 5 is True", rangeObjectUnderTest.intersects(-1, 1));
	}
	public void testIntersects2() {
		assertTrue("The intersects value of -5 and 5 is True", rangeObjectUnderTest.intersects(0, 0));
	}
	public void testIntersects3() {
		assertFalse("The intersects value of -5 and 5 is True", rangeObjectUnderTest.intersects(50, 55));
	}
	public void testIntersects4() {
		assertFalse("The intersects value of -5 and 5 is True", rangeObjectUnderTest.intersects(50, 45));
	}
	
//	----TESTS FOR CONSTRAINS----
	public void testConstrain() {
		//assertEquals("The intersects value of -5 and 5 is True", rangeObjectUnderTest.constrain(2.998));
		rangeObjectUnderTest.constrain(2.998);
	}
	public void testConstrain1() {
		//assertEquals("The intersects value of -5 and 5 is True", rangeObjectUnderTest.constrain(-3.75243));
		rangeObjectUnderTest.constrain(-3.75243);
	}
	public void testConstrain2() {
		rangeObjectUnderTest.constrain(11);
	} 
	public void testConstrain3() {
		rangeObjectUnderTest.constrain(-11);
	} 
	public static Boolean testConstain4(int[] input_array, int desired_element){
		double number_of_items = input_array.length;
		Boolean found = false;
		int counter = 0;
		if(number_of_items != 0) {
			counter = 0;
			while((!found) && (counter <= number_of_items)){
				if (input_array[counter] == desired_element)
					found = true;
				counter = counter +1;
			}
		}
		return found; 
	}
	
	
	
//	----TESTS FOR COMBINE----
	public void testCombine() {
		range1 = new Range(1, 10);
		range2 = new Range(50, 100);
		Range.combine(range1, range2);
	}
	public void testCombine1() {
		range1 = new Range(1, 5.8);
		range2 = new Range(7, 10);
		Range.combine(range1, range2);
	} 
	public void testCombine2() {
		range1 = new Range(-10, -5);
		range2 = new Range(5, 10);
		Range.combine(range1, range2);
	}
	public void testCombine3() {
		range1 = new Range(5, 10);
		range2 = new Range(5, 10);
		Range.combine(range1, range2);
	} 
//	----TESTS FOR EXPAND TO INCLUDE----
	public void testExpandToInclude() {
		range1 = new Range(1, 10);
		Range.expandToInclude(range1, 15);
	}
	public void testExpandToInclude1() {
		range1 = new Range(1, 10);
		Range.expandToInclude(range1, -10);
	}
	
//	----TESTS FOR EXPAND----
	public void testExpand() {
		range1 = new Range(1, 10);
		Range.expand(range1, 0.25, 0.5);
	}

//	----TESTS FOR SHIFT----
	public void testShift() {
		range1 = new Range(1, 10); 
		Range.shift(range1, 5d);
	}
	 
	public void testShiftTRUE() {
		range1 = new Range(1, 10);
		boolean T = true;
		Range.shift(range1, 0.000000001d, T);
	}
	public void testShiftFALSE() {
		range1 = new Range(1, 10);
		boolean F = false;
		Range.shift(range1, 0.000000001d, F);
	} 
	public void testShiftTRUEZero() {
		range1 = new Range(-5, 10);
		boolean T = true;
		Range.shift(range1, 0.000000001d, T);
		
	}  
	
	
//	----TESTS FOR EQUALS----
	public void testRangeEquals() {
		range1 = new Range(-5, 5);
		//boolean T = true;
		rangeObjectUnderTest.equals(range1);
	}
	public void testRangeEqualsTrue() {
		range1 = new Range(-5, 5);
		//boolean T = true;
		if(rangeObjectUnderTest.equals(range1)) {
			System.out.println("Range is equal");
		}else {
			System.out.println("Range is not equal");
		}
	}
	
	public void testRangeEquals1() {
		range1 = new Range(1, 10);
		//boolean T = true;
		if(rangeObjectUnderTest.equals(range1)) {
			System.out.println("Range is equal");
		}else {
			System.out.println("Range is not equal");
		}
	}
	public void testRangeEquals2() {
		boolean range3 = true;
		//boolean T = true;
		if(rangeObjectUnderTest.equals(range3)) {
			System.out.println("Range is equal");
		}else {
			System.out.println("Range is not equal");
		}
	} 
	public void testRangeEquals3() {
		String range4 = "hello";
		//boolean T = true;
		if(rangeObjectUnderTest.equals(range4)) {
			System.out.println("Range is equal");
		}else {
			System.out.println("Range is not equal");
		}
	}  
	
	
	
//	----TESTS FOR HASH CODE----
	public void testHashCode() {
		rangeObjectUnderTest.hashCode();
	}
	 
//	----TESTS FOR TO STRING ----
	public void testToString() {
		rangeObjectUnderTest.toString();
	}
	public void testToString1() {
		range1 = new Range(1, 10);
		range1.toString();
	}
	
	
	
	
	
	
	
	
	
}  





