package leetcode225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackWithOneQueue {
    Queue<Integer> queue;

    public MyStackWithOneQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue.isEmpty()) {
            queue.add(x);
            return;
        }
        int size = queue.size();
        queue.add(x);
        for (int i = 0; i < size; i++) {
            int value = queue.poll();
            queue.add(value);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
