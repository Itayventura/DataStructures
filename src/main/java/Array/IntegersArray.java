package Array;

import java.util.Arrays;

public class IntegersArray extends SortableArray<Integer>{
    public IntegersArray(Integer[] arr) {
        super(arr);
    }

    public IntegersArray(int size){
        super(new Integer[size]);
    }
}
