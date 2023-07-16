package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test42 {
}

class Solution42 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int waterCapacity = 0;
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            leftMaxHeight = Math.max(leftMaxHeight, height[left]);
            rightMaxHeight = Math.max(rightMaxHeight, height[right]);
            if (height[left] > height[right]) {
                waterCapacity += rightMaxHeight - height[right];
                right--;
            } else {
                waterCapacity += leftMaxHeight - height[left];
                left++;
            }
        }

        return waterCapacity;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int waterCapacity = 0;
        Deque<Integer> heightStack = new ArrayDeque<>();
        int heightLen = height.length;

        for (int i = 0; i < heightLen; i++) {
            while (!heightStack.isEmpty() && height[i] > height[heightStack.peek()]) {
                Integer top = heightStack.pop();
                if (heightStack.isEmpty()) {
                    break;
                }
                int left = heightStack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[top];
                waterCapacity += curWidth * curHeight;
            }

            heightStack.push(i);
        }

        return waterCapacity;
    }

}
