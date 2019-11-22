package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator comparator;
    public SortDecorator(SmartArray smartArray, MyComparator cmp){
        super(smartArray);
        comparator = cmp;
    }
    
    private Object[] modifyArray(Object[] array){
        Object[] arr = Arrays.copyOf(array, array.length);
        Arrays.sort(arr, comparator);
        return arr;
    }

    @Override
    public Object[] toArray() {
        return modifyArray(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "SortDecorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }

    
}
