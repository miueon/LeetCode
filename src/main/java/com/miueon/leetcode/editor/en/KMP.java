package com.miueon.leetcode.editor.en;

public class KMP {
    public static void main(String[] args) {
        String s = "abcdefg";
        String m = "cde";
        System.out.println(getIndexOfKmp(s, m));
    }
    
    public static int[] getNextArray(char[] ms) {
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos=2;
        int cn = 0;
        while (pos < ms.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            } 
        }
        
        return next;
    }

    public static int getIndexOfKmp(String s, String m) {
        if (s == null || m == null || m.length() > s.length() || m.length() < 1) {
            return -1;
        }
        char[] ss= s.toCharArray();
        char[] ms = m.toCharArray();
        int[] next = getNextArray(ms);
        int si=0;
        int mi=0;
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            } 
        }
        return mi == ms.length? si-mi: -1;
    }
}
