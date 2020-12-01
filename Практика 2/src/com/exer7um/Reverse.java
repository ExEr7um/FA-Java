package com.exer7um;

public class Reverse implements Execute {
    StringBuilder STB = new StringBuilder();

    public void execute() {
        STB.append(UndoableStringBuilder.versions.peek());
        STB.reverse();
        UndoableStringBuilder.versions.push(STB);
    }
}