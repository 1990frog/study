package theme739;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }

}
