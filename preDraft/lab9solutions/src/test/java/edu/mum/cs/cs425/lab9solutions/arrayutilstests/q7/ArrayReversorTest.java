package edu.mum.cs.cs425.lab9solutions.arrayutilstests.q7;

import edu.mum.cs.cs425.lab9solutions.arrayutils.q7.ArrayReversor;
import edu.mum.cs.cs425.lab9solutions.arrayutils.q7.service.ArrayFlattenerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {
    private ArrayReversor arrayReversor;
    // This is stubbing
//    private ArrayFlattenerService arrayFlattenerService = new ArrayFlattenerService() {
//        @Override
//        public int[] flattenArray(int[][] a_in) {
//            return new int[0];
//        }
//    }
    private ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);

    @Before
    public void setUp() throws Exception {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @After
    public void tearDown() throws Exception {
        this.arrayReversor = null;
    }

    @Test
    public void testReverseArray() {
        int[][] a_in = new int[][]{{1,3}, {0}, {4,5,9}};
        when(arrayFlattenerService.flattenArray(a_in)).thenReturn(new int[]{1,3,0,4,5,9});
        int[] actual = arrayReversor.reverseArray(a_in);
        int[] expected = new int[]{9,5,4,0,3,1};
        assertArrayEquals(expected, actual);
        verify(arrayFlattenerService).flattenArray(a_in);
    }
}