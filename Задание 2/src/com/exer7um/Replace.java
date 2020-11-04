package com.exer7um;

public class Replace implements Execute {
    StringBuilder STB = new StringBuilder();

    private final int start;
    private final int end;
    private final String string;

    public Replace(int start, int end, String string) {
        this.start = start;
        this.end = end;
        this.string = string;
    }

    public void execute() {
        STB.append(UndoableStringBuilder.versions.peek());
        STB.replace(start, end, string);
        UndoableStringBuilder.versions.push(STB);
    }
}
