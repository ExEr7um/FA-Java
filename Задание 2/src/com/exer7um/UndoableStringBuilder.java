package com.exer7um;

import java.util.Stack;

public class UndoableStringBuilder {
    public static Stack<StringBuilder> versions = new Stack<>();

    public void append(String string) {
        Append append = new Append(string);
        append.execute();
    }

    public void delete(int start, int end) {
        Delete delete = new Delete(start, end);
        delete.execute();
    }

    public void charAt(int position) {
        CharAt charAt = new CharAt(position);
        charAt.execute();
    }

    public void insert(int position, String string) {
        Insert Insert = new Insert(position, string);
        Insert.execute();
    }

    public void length() {
        Length length = new Length();
        length.execute();
    }

    public void replace(int start, int end, String string) {
        Replace replace = new Replace(start, end, string);
        replace.execute();
    }

    public void reverse() {
        Reverse reverse = new Reverse();
        reverse.execute();
    }

    public void undo() {
        Undo undo = new Undo();
        undo.execute();
    }

    public String get() {
        if (versions.isEmpty()) {
            return "";
        } else {
            return versions.peek().toString();
        }
    }
}
