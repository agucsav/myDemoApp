package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
    public void testArray1Greater() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(4, 12, 7, 9, 5));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 6, 2, 3));
        assertEqual(1, new App().compute(array, array2, 4, 3));
      }

    public void testArray2Greater() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(4, 5, 7, 9, 5));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 6, 2, 3));
        assertEqual(-1, new App().compute(array, array2, 6, 3));
      }

    public void testArraysAreEqual() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(4, 5, 7, 9, 5));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 6, 0, 3));
        assertEqual(0, new App().compute(array, array2, 6, 3));
      }


      public void testEmptyArray1() {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 6, 0, 3));
        assertEqual(-1, new App().compute(array, array2, 6, 3));
      }

      public void testEmptyArray2() {
          ArrayList<Integer> array2 = new ArrayList<>();
          ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 6, 0, 3));
          assertEqual(1, new App().compute(array, array2, 6, 3));
        }

      public void testNullArray1() {
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 6, 0, 3));
    	 assertEqual(-2, new App().compute(null, array, 6, 3));
      }

      public void testNullArray2() {
    	ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 6, 0, 3));
    	 assertEqual(-2, new App().compute(array, null, 6, 3));
      }

}
