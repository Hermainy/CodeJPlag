package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Checker {

    private static int hs(String s) {
        long h = 0;
        long md = (int)1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            h = h * 101 % md + (long)s.charAt(i);
            //System.out.println("a"+h);
        }
        //System.out.println("a "+(int)h%md);
        return (int)(h % md);
    }

    private static Set<Integer> mark(String s) {
        List<Integer> h = new ArrayList<>();
        Set<Integer> ans = new HashSet<>();
        String buff = "";
        for (int i = 0; i < s.length(); i++) {
            buff += s.charAt(i);
            //System.out.println("buff="+buff);
            if (buff.length() == 4) {
                buff =  buff.substring(1);
                //System.out.println("true");
                h.add(hs(buff));
            }
        }
        //System.out.println("SSSS//"+h);
        for (int i = 0; i < h.size(); i++) {
            ans.add(h.get(i));
        }

        //System.out.println("ans" + ans);
        return ans;
    }

    /*private static  double sr(Set <Integer> st1, Set <Integer > st2) {
        int k = 0;
        System.out.println("st1/"+st1);
        System.out.println("st2/"+st2);
        for (int i : st1) {
            System.out.println(i+"---------"+k);
            if ( st2.contains(i) )k++;
        }
        return (double)k / st1.size();
    }*/

    private static double a(Set<Integer> s1,Set<Integer> s2)
    {
        int k=0;
        int t=0;
        for(int i :s1)
        {
            if ( s2.contains(i) )k++;
            else t++;
        }
        int y=0;
        for(int i:s2)
        {
            y++;
        }
        return (double)k/(y+t);
    }
    static int checkCode(String code1, String code2){
        return  (int)(100*a(mark(code1),mark(code2)));
    }
}