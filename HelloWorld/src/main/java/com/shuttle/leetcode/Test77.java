package com.shuttle.leetcode;

import java.util.*;

public class Test77 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 2, 3, 1, 1};
        int[] nums2 = new int[]{7, 5, 10, 9, 6};
        Test77 test77 = new Test77();
        System.out.println(test77.maxScore(nums1, nums2, 1));
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length = nums1.length;
        List<List<Integer>> nums1AllList = combine(nums1, length, k);
        List<List<Integer>> nums2AllList = combine(nums2, length, k);
        long max = 0;
        for (int i = 0; i < nums1AllList.size(); i++) {
            int cj = 0;
            List<Integer> nums1List = nums1AllList.get(i);
            List<Integer> nums2List = nums2AllList.get(i);
            int sum = 0;
            for (Integer integer : nums1List) {
                sum += integer;
            }
            nums2List.sort(Comparator.comparingInt(o -> o));
            Integer integer = nums2List.get(0);
            cj = sum * integer;
            max = max < cj ? cj : max;
        }

        return max;
    }

    public List<List<Integer>> combine(int[] nums, int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        backtrack(res, new ArrayList<>(), 0, n, k, nums);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int begin, int n, int k, int[] nums) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < n; i++) {
            path.add(nums[i]);
            backtrack(res, path, i + 1, n, k, nums);
            path.remove(path.size() - 1);
        }
    }
}
