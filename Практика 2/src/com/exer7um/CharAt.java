package com.exer7um;

public class CharAt implements Execute {
    StringBuilder STB = new StringBuilder();

    private final int position;

    public CharAt(int position) {
        this.position = position;
    }

    public void execute() {
        STB.append(UndoableStringBuilder.versions.peek());
        System.out.println(STB.charAt(position));
    }
}
