package leetcode225;

import java.util.LinkedList;
import java.util.Queue;

/**
还有一种交换引用的思路，看题解
 */

public class MyStackWithTwoQueues {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStackWithTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.add(x);
        } else {
            while (!queue1.isEmpty()) {
                int value = queue1.poll();
                queue2.add(value);
            }
            queue1.add(x);
            while (!queue2.isEmpty()) {
                int value = queue2.poll();
                queue1.add(value);
            }
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
