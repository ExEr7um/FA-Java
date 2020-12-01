package com.exer7um;

public class Delete implements Execute {
    StringBuilder STB = new StringBuilder();

    private final int start;
    private final int end;

    public Delete(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void execute() {
        STB.append(UndoableStringBuilder.versions.peek());
        STB.delete(start, end);
        UndoableStringBuilder.versions.push(STB);
    }
}
