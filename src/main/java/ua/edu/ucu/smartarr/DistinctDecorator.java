package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends
        SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }
        
    private Object[] modifyArray(Object[] array){
            Object[] arr = Arrays.copyOf(array, array.length);
            return Arrays.stream(arr).distinct().toArray();
    }

    @Override
    public Object[] toArray() {
        return modifyArray(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
