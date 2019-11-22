package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        function = func;

    }
    
    private Object[] modifyArray(Object[] array){
        Object[] arr = Arrays.copyOf(array, array.length);
        for(int i = 0; i < arr.length; i++){
            arr[i] = function.apply(arr[i]);
        }
        return arr;
    }

    @Override
    public Object[] toArray() {

        return modifyArray(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "MapDecorator";
    }

    @Override
    public int size() {
        return smartArray.size();

    }


}
