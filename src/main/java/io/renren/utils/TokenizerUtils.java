package io.renren.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenizerUtils {
    private TokenizerUtils() {
        // 私有构造函数，防止实例化
    }

    public static String capitalizeWords(List<String> words) {
        StringBuilder sb = new StringBuilder();

        if (words.size() == 1) {
            // 如果列表长度为1，则将该项转换为小写
            sb.append(words.get(0).toLowerCase());
        } else {
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);

                if (i > 0) {
                    // 对除第一个单词外的其他单词进行首字母大写、其他字母小写处理
                    word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                }

                sb.append(word);
            }
        }

        return sb.toString();
    }

    public static List<String> tokenize(String input) {
        List<String> tokenizedWords = new ArrayList<>();

        // 使用正则表达式将驼峰式命名的文本划分为单个单词
        Pattern pattern = Pattern.compile("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])");
        Matcher matcher = pattern.matcher(input);
        int lastIndex = 0;

        while (matcher.find()) {
            String word = input.substring(lastIndex, matcher.start());
            tokenizedWords.add(word);
            lastIndex = matcher.start();
        }

        if (lastIndex < input.length()) {
            String word = input.substring(lastIndex);
            tokenizedWords.add(word);
        }

        return tokenizedWords;
    }

}