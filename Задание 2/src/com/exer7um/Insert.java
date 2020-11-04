package com.exer7um;

public class Insert implements Execute {
    StringBuilder STB = new StringBuilder();

    private final int position;
    private final String string;

    public Insert(int position, String string) {
        this.position = position;
        this.string = string;
    }

    @Override
    public void execute() {
        STB.append(UndoableStringBuilder.versions.peek());
        STB.insert(position, string);
        UndoableStringBuilder.versions.push(STB);
    }
}
