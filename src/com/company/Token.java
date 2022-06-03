package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Token {

    /**
     * Карта токенов, содержит информацию, необходимую для успешного токенизирования
     */
    private static final Map<String,String> tokens = new HashMap<>();

    /**
     * Заполняем карту токенов и ключевых слов из файла tokens.list слово и токен разделены @
     */
    static void init(){
        File tokenList = new File("tokens.list");
        if (!tokenList.exists()) {
            System.exit(1);
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(tokenList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String splited[];
        if (scanner == null)
            System.exit(1);
        while (scanner.hasNextLine()){
            splited = scanner.nextLine().split("@");
            tokens.put(splited[0],splited[1]);
        }

        scanner.close();
    }

    /**
     * @param code Код написаный на любом доступном языке (чьи ключевые слова перечислены в файле tokens.list)
     * @return токенизированую строку кода
     */
    public static String codeTokenaize(String code){
        //Получаем сет ключей для токенизирования
        Set<String> keySet = tokens.keySet();

        //Избавляемся от мусорных элементов кода
        code = code.replace(';',' ');
        code = code.replace('\n',' ');
        code = code.replace('{',' ');
        code = code.replace('}',' ');
        code = code.replace('(',' ');
        code = code.replace(')',' ');
        code = code.replace('=',' ');
        code = code.replace("NULL"," ");

        //Избавляемся от различных имён и прочего мусора
        StringBuilder builder = new StringBuilder();
        boolean flag;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) != ' ')
                builder.append(code.charAt(i));
            else {
                flag = false;
                for (String str : keySet) {
                    if (builder.toString().equals(str)) {
                        flag = true;
                    }
                }
                if (!flag && !builder.toString().equals("")){
                    code = code.substring(0, i - builder.length()) + code.substring(i);
                    i -= builder.length()+1;
                }
                builder = new StringBuilder();
            }
        }
        //Убираем лишние пробелы
        code = code.replaceAll("[\\s]{2,}", " ");

        //токенизируем ключевые слова
        for (String str: keySet){
            code = code.replace(str,tokens.get(str));
        }
        return code;
    }
}