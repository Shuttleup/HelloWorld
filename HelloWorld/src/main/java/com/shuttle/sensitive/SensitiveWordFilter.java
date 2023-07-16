package com.shuttle.sensitive;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SensitiveWordFilter {

    /**
     * 敏感词将替换成 "*"
     */
    private static final String SENSITIVE_REPLACEMENT = "*";

    private static class PrefixTree {

        /**
         * 子节点
         */
        Map<Character, PrefixTree> children;
        /**
         * 关键词结束标识 false：未结束 true：已结束
         */
        private boolean isKeywordEnd;

        /**
         * 无参构造器
         */
        public PrefixTree() {
            children = new HashMap<>();
        }

        /**
         * 添加子节点
         */
        public void addChildrenNode(Character ch, PrefixTree node) {
            children.put(ch, node);
        }

        /**
         * 获取子节点
         */
        public PrefixTree getChildren(Character ch) {
            return this.children.get(ch);
        }

    }

    /**
     * 根节点
     */
    private PrefixTree root;

    public SensitiveWordFilter() {
        init();
    }

    private void init() {
        // 初始化根节点，构造前缀树
        root = new PrefixTree();
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("sensitive_word.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String sensitiveWord;
            while ((sensitiveWord = br.readLine()) != null) {
                this.addSensitiveWord(sensitiveWord);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加敏感词，构造前缀树
     *
     * @param word 待添加的敏感词
     */
    private void addSensitiveWord(String word) {
        PrefixTree temp = root;
        char[] wordChars = word.toCharArray();
        for (char wordChar : wordChars) {
            // 判断当前字符是否已经存在，不存在需要初始化
            PrefixTree children = temp.getChildren(wordChar);
            if (children == null) {
                children = new PrefixTree();
                temp.addChildrenNode(wordChar, children);
            }
            // 指向子节点，进入下一轮循环
            temp = children;
        }
        // 已到达当前敏感词结尾处
        temp.isKeywordEnd = true;
    }

    /**
     * 过滤
     *
     * @param text 待过滤的文本
     * @return 返回过滤后的文本
     */
    public String filter(String text) {
        // 判空
        if (StringUtils.isEmpty(text)) {
            return "";
        }
        // temp指向根节点
        PrefixTree temp = root;
        // begin指向敏感词开始的位置，position指向text当前位置
        int begin = 0;
        int position = 0;
        StringBuilder resultStr = new StringBuilder();
        int textLen = text.length();

        while (position < textLen) {
            char ch = text.charAt(position);
            // 是符号的话直接跳过
            if (isSymbol(ch)) {
                // 移动指针
                if (temp == root) {
                    resultStr.append(ch);
                    begin++;
                }
                position++;
                continue;
            }
            temp = temp.getChildren(ch);
            if (temp == null) {
                // 以begin开头的字符串不是敏感词
                resultStr.append(text.charAt(begin));
                position = ++begin;
                temp = root;
            } else if (temp.isKeywordEnd) {
                // 发现敏感词，将begin - position 替换为 "*"
                for (int i = 0; i < position - begin + 1; i++) {
                    resultStr.append(SENSITIVE_REPLACEMENT);
                }
                // 移动指针
                begin = ++position;
                temp = root;
            } else {
                // 继续检查下一个字符
                position++;
            }
        }
        // 将最后的字符串拼接上
        resultStr.append(text.substring(begin));

        return resultStr.toString();
    }

    /**
     * 判断当前字符是否为符号
     *
     * @param ch 当前字符
     * @return 返回是否为符号 false：否，true：是
     */
    private boolean isSymbol(Character ch) {
        return !CharUtils.isAsciiAlphanumeric(ch) && (ch < 0x2E80 || ch > 0x9FFF);
    }

}
