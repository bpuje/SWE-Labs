package edu.mum.cs.cs425.lab9solutions.arrayutilstests.q6;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.mum.cs.cs425.lab9solutions.arrayutils.q6.ArrayFlattener;

public class ArrayFlattenerTestNull {
	
	private ArrayFlattener arrayFlattener;

	@Before
	public void setUp() throws Exception {
		this.arrayFlattener = new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		this.arrayFlattener = null;
	}

	@Test
	public final void testFlattenArray() {
		int[][] a_in = null;
		Integer[] a_out = arrayFlattener.flattenArray(a_in);
		Integer[] expected_a_out = null;
		boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
		assertTrue(areArraysEqual);
	}
	
	@Test
	public final void testFlattenArray2() {
		int[][] a_in = null;
		int[] a_out = arrayFlattener.flattenArray2(a_in);
		int[] expected_a_out = null;
		boolean areArraysEqual = Arrays.equals(a_out, expected_a_out);
		assertTrue(areArraysEqual);
	}
}
