package org.antogautjean;

import java.util.HashMap;

public class Line {

    private String code;

    private String name;

    private HashMap<Product, Integer> input;

    private HashMap<Product, Integer> output;

    private int duration;

    private int qualified;

    private int unqualified;

    private int numberOfExecution;

    Line(String code, String name, HashMap<Product, Integer> input, HashMap<Product, Integer> output, int duration, int qualified, int unqualified){

        this.code = code;
        this.name = name;
        this.input = input;
        this.output = output;
        this.duration = duration;
        this.qualified = qualified;
        this.unqualified = unqualified;
        this.numberOfExecution = 0;
    }

    public void execute(){
        //check input exists
        //check output exists
        //input stock - 1
        //output stock + 1
        this.numberOfExecution++;
    }

}
