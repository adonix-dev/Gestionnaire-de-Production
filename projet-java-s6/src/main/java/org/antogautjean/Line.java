package org.antogautjean;

import java.util.HashMap;

public class Line {

    private String code;

    private String name;

    private HashMap<Product, Integer> input;

    private HashMap<Product, Integer> output;

    private int duration;

    private Employee[] qualified;

    private Employee[] unqualified;

    private int numberOfExecution;

    public Line(String code, String name, HashMap<Product, Integer> input, HashMap<Product, Integer> output, int duration, int qualified, int unqualified){

        this.code = code;
        this.name = name;
        this.input = input;
        this.output = output;
        this.duration = duration;
        this.qualified = new Employee[qualified];
        this.unqualified = new Employee[unqualified];
        this.numberOfExecution = 0;
    }

    public boolean execute(){
        //check input exists
        //check output exists
        //input stock - 1
        //output stock + 1
        this.numberOfExecution++;
        return true;
    }

}
