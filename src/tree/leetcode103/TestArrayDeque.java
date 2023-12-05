package leetcode103;

import java.util.ArrayDeque;

public class TestArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 20; i++) {
            arrayDeque.addFirst(i);
        }
        for (int i = 0; i < 10; i++) {
            arrayDeque.pollFirst();
        }
    }
}
