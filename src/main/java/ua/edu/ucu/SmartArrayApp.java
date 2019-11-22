package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.DistinctDecorator;
import java.util.Arrays;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object oFst, Object oSec) {
                return ((Integer) oFst) - ((Integer) oSec);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
            Student[] students) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                int minGPA = 4;
                int year = 2;
                Student stud = (Student) t;
                return (stud.getGPA() >= minGPA && stud.getYear() == year);
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object oFst, Object oSec) {
                Student studFst = (Student) oFst;
                Student studSec = (Student) oSec;
                return (studFst.getSurname().compareTo(studSec.getSurname()));
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student stud = (Student) t;
                return stud.getSurname() + " " + stud.getName();
            }
        };

        SmartArray sa = new BaseArray(students);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);
        sa = new DistinctDecorator(sa);


        Object[] result = sa.toArray();
        return Arrays.stream(result).toArray(String[]::new);

    }
}
