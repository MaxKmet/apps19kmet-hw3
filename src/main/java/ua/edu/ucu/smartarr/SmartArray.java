package ua.edu.ucu.smartarr;

public interface SmartArray {

    public Object[] toArray(); // return array with SmartArray elements

    public String operationDescription(); // return current operation name applied to SmartArray

    public int size(); // return SmartArray size

}
