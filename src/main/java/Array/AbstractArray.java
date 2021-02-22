package Array;

public abstract class AbstractArray<T> implements Array<T> {

    protected T[] arr;
    protected int length;

    public AbstractArray(T[] arr){
        this.arr = arr;
        this.length = arr.length;
    }

    @Override
    public T[] getArr(){
        return this.arr;
    }



    @Override
    public int length(){
        return this.length;
    }
    @Override
    public boolean isEmpty(){
        return this.length == 0;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = 0; i < this.length-1; i++){
            stringBuilder.append(this.arr[i] + ", ");
        }
        if (this.length > 0){
            stringBuilder.append(this.arr[this.length-1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void set(T value, int index){
        if (index < this.length) {
            this.arr[index] = value;
        }
    }

    @Override
    public T get(int i){
        return this.arr[i];
    }

}

