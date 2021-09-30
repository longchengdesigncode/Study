package com.demo.algorithm.leetcode.medium;

/**
 * create on 9/30/21
 * @author chenglong
 * description : 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 * 提示：
 * 1 <= num <= 3999
 */
public class IntToRoman {

    public static String intToRoman(int num) {
        if (num < 1 || num >= 4000) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        //处理千位
        int tem = num / 1000;
        if (tem == 1) {
            builder.append("M");
        } else if (tem == 2) {
            builder.append("M");
            builder.append("M");
        } else if (tem == 3) {
            builder.append("M");
            builder.append("M");
            builder.append("M");
        }
        num %= 1000;
        //处理百位
        if (num >= 900) {
            builder.append("CM");
            num -= 900;
        }
        if (num >= 500) {
            builder.append("D");
            num -= 500;
        }
        if (num >= 400) {
            builder.append("CD");
            num -= 400;
        }
        tem = num / 100;
        if (tem == 1) {
            builder.append("C");
        } else if (tem == 2) {
            builder.append("C");
            builder.append("C");
        } else if (tem == 3) {
            builder.append("C");
            builder.append("C");
            builder.append("C");
        }
        num %= 100;
        //处理十位
        if (num >= 90) {
            builder.append("XC");
            num -= 90;
        }
        if (num >= 50) {
            builder.append("L");
            num -= 50;
        }
        if (num >= 40) {
            builder.append("XL");
            num -= 40;
        }
        tem = num / 10;
        if (tem == 1) {
            builder.append("X");
        } else if (tem == 2) {
            builder.append("X");
            builder.append("X");
        } else if (tem == 3) {
            builder.append("X");
            builder.append("X");
            builder.append("X");
        }
        num %= 10;
        //处理个位
        if (num == 9) {
            builder.append("IX");
            return builder.toString();
        }
        if (num >= 5) {
            builder.append("V");
            num -= 5;
        }
        if (num >= 4) {
            builder.append("IV");
            num -= 4;
        }
        if (num == 1) {
            builder.append("I");
        } else if (num == 2) {
            builder.append("I");
            builder.append("I");
        } else if (num == 3) {
            builder.append("I");
            builder.append("I");
            builder.append("I");
        }
        return builder.toString();
    }
}
