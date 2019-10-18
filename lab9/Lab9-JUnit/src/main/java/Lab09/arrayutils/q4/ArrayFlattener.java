package Lab09.arrayutils.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Lab09.arrayutils.q5.service.ArrayFlattenerService;

public class ArrayFlattener implements ArrayFlattenerService{
	
	@Override
	public Integer[] flattenArray(Integer[][] a_in) {
		if (a_in == null) 
			return null;
        List<Integer> list = new ArrayList<>();
        for (Integer[] arr : a_in) {
            for (int i : arr) {
                list.add(i);
            }
        }
        return (Integer[]) list.toArray(new Integer[list.size()]);
    }		
	
	public int[] flattenArray2(int[][] a_in) {
		if (a_in == null) 
			return null;
		return Arrays.stream(a_in)
				.flatMapToInt(arr -> Arrays.stream(arr))
				.toArray();
	}
}
