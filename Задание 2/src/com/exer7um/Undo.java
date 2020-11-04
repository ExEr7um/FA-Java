package com.exer7um;

public class Undo implements Execute {
    public void execute() {
        UndoableStringBuilder.versions.pop();
    }
}