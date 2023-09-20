package io.renren.utils;


import java.util.List;

public class CamelCaseUtils {
    private CamelCaseUtils() {
        // 私有构造函数，防止实例化
    }

    public static String convertToCamelCase(String input) {
        List<String> tokens = TokenizerUtils.tokenize(input);
        String result = TokenizerUtils.capitalizeWords(tokens);
        return result;
    }

    public static void main(String[] args) {

    }
}