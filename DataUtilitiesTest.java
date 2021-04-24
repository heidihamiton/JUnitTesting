package org.jfree.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.*;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;


public class DataUtilitiesTest extends TestCase {
	
	
	DefaultKeyedValues2D myMatrix;
	private DefaultKeyedValues2D dataObjectUnderTest;
	private DataUtilities dataObjectUnderTesting;
	//private DataUtilities exampleData;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		//this is me making the matrix
		myMatrix = new DefaultKeyedValues2D();
		//currently the matrix has only 2 values in 0 column which are 1 and 4. 
		myMatrix.addValue(1, 0, 0);
		myMatrix.addValue(4, 1,  2);
		//values.addValue(value, rowKey, columnKey);
		
		dataObjectUnderTest = new DefaultKeyedValues2D();
		
		//myArray = new Double[];
		//double[] myArray = new double[2];
		 
		 
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	} 

	
	// ---------------------------- Column Total ---------------------------------------
	@Test
	public void testNullDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown");
		} catch (Exception e) {
			assertTrue(e.getClass().equals(java.lang.NullPointerException.class));
		}
	}  
	 
	public void testCalculateColumnTotal() { 
		try {
			//DataUtilities.calculateColumnTotal(myMatrix, 0);
			assertEquals(5, DataUtilities.calculateColumnTotal(myMatrix, 0), 0.000000001d);
		} catch (InvalidParameterException exception) {
			assert true;
		}
		  
	}

	
	// ---------------------------- Row Total ---------------------------------------
	
	@Test
	public void testNullDataRowTotal() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown");
		} catch (Exception e) {
			assertTrue(e.getClass().equals(java.lang.NullPointerException.class));
		}
	}
	
	public void testCalculateRowTotal() { 
		try {
			assertEquals(1, DataUtilities.calculateRowTotal(myMatrix, 0), 0.000000001d);
		} catch (InvalidParameterException exception) {
			assert true;
		}
		
	}
	
	// ---------------------------- Number Array ---------------------------------------
	
	public void testCreateNumberArray() { 
		double[] myArray = {0,1,2};
		//myArray[0] = 2;
		//myArray[1] = 5;
		//myArray[2] = 3;
		//System.out.println (myArray);
		//DataUtilities.createNumberArray(myArray);
		
		try {
			assertEquals(myArray, DataUtilities.createNumberArray(myArray));
		} catch (InvalidParameterException exception) {
			assert true;
		}
		
		//assertArrayEquals("", myArray, DataUtilities.createNumberArray(myArray));
		
		System.out.println (myArray);
		
		//assertEquals(5, DataUtilities.createNumberArray(mySingleMatrix));
		
		
	}
	
	
	
	// ---------------------------- Number Array 2D ---------------------------------------
	
	public void testCreateNumberArray2D() { 
		double[][] myArray2d = new double[3][3];
		//myArray2d[0] = ;
		//myArray[1] = 5;
		//myArray[2] = 3;
		//System.out.println (myArray);
		//DataUtilities.createNumberArray(myArray);
		
		try {
			assertEquals(myArray2d, DataUtilities.createNumberArray2D(myArray2d));
		} catch (InvalidParameterException exception) {
			assert true;
		}
		
		 
	}
	
	// -------------------------Cumulative Percentage ---------------------------------
	@Test //getCumaltivePercentagesFunction
	public void testGetCumulativePercentages() {
		DefaultKeyedValues keyValues = new DefaultKeyedValues();
		keyValues.addValue((Comparable) 0.0, 6.0);
		keyValues.addValue((Comparable) 1.0, 11.0);
		keyValues.addValue((Comparable) 2.0, 3.0);
		KeyedValues k = DataUtilities.getCumulativePercentages((KeyedValues) keyValues);
		
		assertEquals((double) k.getValue(2), 1.0, .000000001d);
	}
	
	
	@Test (expected = InvalidParameterException.class)
	public void testGetCumulativePercentagesThrowsExceptionWhenInputIsNull() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("Didn't throw the expected exception");
		} catch (IllegalArgumentException exception) {
			assert true;
		}
	}
	
	
	
}
