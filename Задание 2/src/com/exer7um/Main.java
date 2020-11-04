package com.exer7um;

public class Main {

    public static void main(String[] args) {
        UndoableStringBuilder USTB = new UndoableStringBuilder();
        USTB.append("Привет!");
        System.out.println(USTB.get());
        USTB.delete(2, 3);
        System.out.println(USTB.get());
        USTB.charAt(1);
        USTB.insert(2, "abc");
        System.out.println(USTB.get());
        USTB.length();
        USTB.replace(2, 5, "cba");
        System.out.println(USTB.get());
        USTB.reverse();
        System.out.println(USTB.get());
        USTB.undo();
        System.out.println(USTB.get());
        USTB.undo();
        System.out.println(USTB.get());
        USTB.undo();
        System.out.println(USTB.get());
        USTB.undo();
        System.out.println(USTB.get());
    }
}
