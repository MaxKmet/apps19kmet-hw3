package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate pred) {
        super(smartArray);
        predicate = pred;
    }
    
    private Object[] modifyArray(Object[] array){
        Object[] arr = Arrays.copyOf(array, array.length);
        return Arrays.stream(arr).filter(s-> predicate.test(s)).toArray();
    }

    @Override
    public Object[] toArray() {
        return modifyArray(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "FilterDecorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
