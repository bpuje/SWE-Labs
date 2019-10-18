package Lab09.arrayutilstests.q5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Lab09.arrayutils.q5.ArrayReversor;
import Lab09.arrayutils.q5.service.ArrayFlattenerService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorNullTest {
    private ArrayReversor arrayReversor;

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
    public void testReverseArrayNull() {
        Integer[][] a_in = null;
        when(arrayFlattenerService.flattenArray(a_in)).thenReturn(null);
        Integer[] actual = arrayReversor.reverseArray(a_in);
        Integer[] expected = null;
        assertArrayEquals(expected, actual);
        verify(arrayFlattenerService).flattenArray(a_in);
    }
}