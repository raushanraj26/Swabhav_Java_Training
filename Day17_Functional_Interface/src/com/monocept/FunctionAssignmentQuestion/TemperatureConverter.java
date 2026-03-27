package com.monocept.FunctionAssignmentQuestion;
import java.util.*;
import java.util.function.Function;

public class TemperatureConverter {

    public static void main(String[] args) {
        Function<Double, Double> convert = c -> (c * 9/5) + 32;
        List<Double> temps = Arrays.asList(0.0, 20.0, 37.0);
        for(Double t : temps) {
            System.out.println(t + "°C -> " + convert.apply(t) + "°F");
        }
    }
}