package com.shuttle.leetcode;

import java.util.*;

public class Test692 {
}

class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> resultList = new ArrayList<>();
        if (words == null || words.length == 0 || k <= 0) {
            return resultList;
        }
        // {word : frequent}
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String word : words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }
        // 优先级队列，首按frequent进行【小 -> 大】排序，其次按字典【大 -> 小】排序
        Queue<String> wordPriorityQueue = new PriorityQueue<>(
                (element1, element2) -> wordFreqMap.get(element1).equals(wordFreqMap.get(element2))
                        ? element2.compareTo(element1)
                        : wordFreqMap.get(element1) - wordFreqMap.get(element2));

        for (String word : wordFreqMap.keySet()) {
            wordPriorityQueue.offer(word);
            if (wordPriorityQueue.size() > k) {
                wordPriorityQueue.poll();
            }
        }

        while (!wordPriorityQueue.isEmpty()) {
            resultList.add(wordPriorityQueue.poll());
        }
        Collections.reverse(resultList);

        return resultList;
    }
}
