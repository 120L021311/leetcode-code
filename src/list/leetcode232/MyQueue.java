package leetcode232;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            int value = stack1.pop();
            stack2.push(value);
        }
        int ret = stack2.pop();
        while (!stack2.isEmpty()) {
            int value = stack2.pop();
            stack1.push(value);
        }
        return ret;
    }

    public int peek() {
        return stack1.peekLast();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}


//题解
//class MyQueue {
//
//    Deque<Integer> stack1;
//    Deque<Integer> stack2;
//
//    public MyQueue() {
//        stack1 = new LinkedList<>();
//        stack2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        stack1.push(x);
//    }
//
//    public int pop() {
//        if(!stack2.isEmpty()){
//            return stack2.pop();
//        }
//        while(!stack1.isEmpty()){
//            int value=stack1.pop();
//            stack2.push(value);
//        }
//        return stack2.pop();
//    }
//
//    public int peek() {
//        if(!stack2.isEmpty()) {
//            return stack2.peekFirst();
//        } else {
//            return stack1.peekLast();
//        }
//    }
//
//    public boolean empty() {
//        return stack1.isEmpty() && stack2.isEmpty();
//    }
//}

