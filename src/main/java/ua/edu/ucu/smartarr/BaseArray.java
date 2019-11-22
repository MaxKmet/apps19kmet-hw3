package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] array;

    public BaseArray(Object[] arr){
        array = new Object[arr.length];
        System.arraycopy(arr, 0, array, 0, size());
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size()];
        System.arraycopy(array, 0, newArray, 0, size());
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return array.length;
    }

    public void setValue(int index){array[index] = 0;}
}
