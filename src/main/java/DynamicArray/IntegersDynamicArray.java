package DynamicArray;

import Array.*;

public class IntegersDynamicArray extends AbstractDynamicArray<Integer> {


    public IntegersDynamicArray(Array<Integer> arr) {
        super(arr);
    }

    @Override
    protected void reSizeArray(int size, boolean shrink) {
        IntegersArray newArr = new IntegersArray(new Integer[size]);
        size = shrink? size:size/2;
        System.arraycopy(this.arr.getArr(), 0, newArr.getArr(), 0, size);
        this.arr = newArr;
    }

    @Override
    public Array<Integer> getArr() {
        return this.arr;
    }
}
