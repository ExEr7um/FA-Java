package com.exer7um;

public class Length implements Execute {
    StringBuilder STB = new StringBuilder();

    public void execute() {
        STB.append(UndoableStringBuilder.versions.peek());
        System.out.println(STB.length());
    }
}
