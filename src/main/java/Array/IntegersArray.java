package Array;

import java.util.Arrays;

public class IntegersArray extends AbstractArray<Integer>{
    public IntegersArray(int[] arr) {
        super(Arrays.stream( arr ).boxed().toArray( Integer[]::new ));
    }

    public IntegersArray(int size){
        super(new Integer[size]);
    }
}
