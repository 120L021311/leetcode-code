package leetcode20;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private int topOfStack;
    private List<T> stack;

    public MyStack() {
        topOfStack = -1;
        stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public void clear() {
        topOfStack = -1;
        stack = null;
    }

    public T top() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        }
        return stack.get(topOfStack);
    }

    public void push(T t) {
        stack.add(t);
        topOfStack++;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("栈为空，不能弹栈");
            return null;
        }
        T t = stack.get(topOfStack);
        stack.remove(topOfStack);
        topOfStack--;
        return t;
    }
}
