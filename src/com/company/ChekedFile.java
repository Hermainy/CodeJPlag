package com.company;

public class ChekedFile{
    static int check(String s1, String s2) {
        int programmDif = Checker.checkCode(Token.codeTokenaize(s1), Token.codeTokenaize(s2));
        return programmDif;
    }
}
