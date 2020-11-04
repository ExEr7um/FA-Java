package com.exer7um;

public class Append implements Execute {
    StringBuilder STB = new StringBuilder();

    private final String string;

    public Append(String string) {
        this.string = string;
    }

    public void execute() {
        STB.append(string);
        UndoableStringBuilder.versions.push(STB);
    }
}
