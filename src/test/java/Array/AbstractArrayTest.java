package Array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AbstractArrayTest {

    private static final int RANGE = 100;
    private static final int LENGTH_BOUND = 10;

    private static int[] ints;
    private static int[] emptyInts = new int[]{};
    private static int[] singleInt = new int[]{0};

    private static IntegersArray arr;
    private static IntegersArray emptyArr;
    private static IntegersArray singleIntArr;

    @BeforeEach
    void setUp() {
        generateRandomArray();
        arr = new IntegersArray(ints);
        emptyArr = new IntegersArray(emptyInts);
        singleIntArr = new IntegersArray(singleInt);
    }

    @AfterEach
    void tearDown() {
    }

    private static void generateRandomArray(){
        int length = new Random().nextInt(5 + LENGTH_BOUND);
        ints = new int[length];
        for (int i = 0; i < length; i++){
            ints[i] = new Random().nextInt(RANGE);
        }
    }
    @Test
    public void insertionSortTest(){
        arr.insertionSort();
        assertTrue(arr.isSorted(), "arr is not sorted");

        emptyArr.insertionSort();
        assertTrue(emptyArr.isSorted(), "emptyArr is not sorted");

        emptyArr.insertionSort();
        assertTrue(emptyArr.isEmpty(), "emptyArr is not empty");

        singleIntArr.insertionSort();
        assertTrue(singleIntArr.isSorted(), "singleIntArr is not sorted");
    }

    @Test
    public void quickSortTest(){
        arr.quickSort();
        assertTrue(arr.isSorted(), "arr is not sorted");

        emptyArr.quickSort();
        assertTrue(emptyArr.isEmpty(), "emptyArr is not empty");

        singleIntArr.quickSort();
        assertTrue(singleIntArr.isSorted(), "singleIntArr is not sorted");
    }

    @Test
    public void mergeSortTest(){
        arr.mergeSort();
        assertTrue(arr.isSorted(), "arr is not sorted");

        emptyArr.mergeSort();
        assertTrue(emptyArr.isEmpty(), "emptyArr is not empty");

        singleIntArr.mergeSort();
        assertTrue(singleIntArr.isSorted(), "singleIntArr is not sorted");
    }
    @Test
    public void heapSortTest(){
        arr.heapSort();
        assertTrue(arr.isSorted(), "arr is not sorted");

        emptyArr.heapSort();
        assertTrue(emptyArr.isEmpty(), "emptyArr is not empty");

        singleIntArr.heapSort();
        assertTrue(singleIntArr.isSorted(), "singleIntArr is not sorted");
    }
}