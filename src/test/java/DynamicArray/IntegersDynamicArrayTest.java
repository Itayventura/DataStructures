package DynamicArray;

import Array.IntegersArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegersDynamicArrayTest {


    private static IntegersDynamicArray dynamicArray;

    @BeforeEach
    void setUp() {
        dynamicArray = new IntegersDynamicArray(new IntegersArray(new Integer[]{1,2,3,4,5,6,7}));

    }
    @Test
    public void pushTest(){
        assertEquals(7, dynamicArray.size());
        dynamicArray.push(8);
        assertEquals(8, dynamicArray.size());
    }

    @Test
    public void popTest(){
        assertEquals(7, dynamicArray.size());
        assertEquals(7, dynamicArray.pop());

        assertEquals(6, dynamicArray.size());
        assertEquals(6, dynamicArray.pop());
        assertEquals(5, dynamicArray.size());
        assertEquals(5, dynamicArray.pop());
        assertEquals(4, dynamicArray.size());
        assertEquals(4, dynamicArray.pop());
        assertEquals(3, dynamicArray.size());
        assertEquals(3, dynamicArray.pop());

        assertEquals(2, dynamicArray.size());
        assertEquals(2, dynamicArray.pop());
        assertEquals(1, dynamicArray.size());
        assertEquals(1, dynamicArray.pop());
        assertEquals(0, dynamicArray.size());
        assertNull(dynamicArray.pop());
        assertEquals(0, dynamicArray.size());
    }

    @Test
    void reSizeExpandArray() {
        int size = dynamicArray.size();
        assertEquals(size, dynamicArray.getArr().length());
        dynamicArray.push(8);
        assertEquals(size*2, dynamicArray.getArr().length());
    }

    @Test
    void reSizeShrinkArray(){
        int size = dynamicArray.size();
        while(dynamicArray.size() > 0){
            dynamicArray.pop();
            if (size/4 > dynamicArray.size()){
                size = size/2;
                assertEquals(size, dynamicArray.getArr().length());
            }
        }
    }

}