package DynamicArray;

import Array.*;

public class IntegersDynamicArray extends AbstractDynamicArray<Integer> {


    public IntegersDynamicArray(Array<Integer> arr) {
        super(arr);
    }

    public IntegersDynamicArray(Integer value){
        super(value);
        this.arr = new IntegersArray(new Integer[]{value});
    }

    public IntegersDynamicArray(){
        super();
        this.arr = new IntegersArray(new Integer[1]);
    }


    @Override
    protected void reSizeArray(int size, boolean shrink) {
        IntegersArray newArr = new IntegersArray(new Integer[size]);
        if (shrink)
            newArr.copy(this.arr.getArr(), size);
        else
            newArr.copy(this.arr.getArr(), size/2);
        this.arr = newArr;
    }

    @Override
    public Array<Integer> getArr() {
        Array<Integer> arr = new IntegersArray(this.size);
        arr.copy(this.arr.getArr(), this.size);
        return arr;
    }
}
