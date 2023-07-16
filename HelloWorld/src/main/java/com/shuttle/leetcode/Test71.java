package com.shuttle.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test71 {
}

class Solution71 {
    public String simplifyPath(String path) {
        if (path == null || "".equals(path)) {
            return "/";
        }
        String[] paths = path.split("/");
        Deque<String> pathStack = new ArrayDeque<>();

        for (String splitPath : paths) {
            if (splitPath.equals(".") || splitPath.equals("")) {
                continue;
            } else if (splitPath.equals("..")) {
                if (!pathStack.isEmpty()) {
                    pathStack.removeLast();
                }
            } else {
                pathStack.addLast(splitPath);
            }
        }

        if (pathStack.isEmpty()) {
            return "/";
        }

        StringBuilder pathStringBuilder = new StringBuilder();
        while (!pathStack.isEmpty()) {
            pathStringBuilder.append(pathStack.pop()).append("/");
        }
        pathStringBuilder.setLength(pathStringBuilder.length() - 1);
        pathStringBuilder.insert(0, "/");

        return pathStringBuilder.toString();
    }
}
