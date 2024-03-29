package com.demo.algorithm.leetcode.easy;

/**
 * create on 2023/12/18
 * @author chenglong
 * description : 找出井字棋的获胜者
 *
 * A和B在一个3 x 3的网格上玩井字棋。
 * 井字棋游戏的规则如下：
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家A总是用"X"作为棋子，而第二个玩家B总是用"O"作为棋子。
 * "X"和"O"只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有3个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组moves，其中每个元素是大小为2的另一个数组（元素分别对应网格的行和列），它按照A和B的行动顺序（先A后B）记录了两人各自的棋子位置。
 * 如果游戏存在获胜者（A或B），就返回该游戏的获胜者；如果游戏以平局结束，则返回"Draw"；如果仍会有行动（游戏未结束），则返回"Pending"。
 * 你可以假设moves都有效（遵循井字棋规则），网格最初是空的，A将先行动。
 *
 * 示例 1：
 * 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * 输出："A"
 * 解释："A" 获胜，他总是先走。
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 *
 * 示例 2：
 * 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * 输出："B"
 * 解释："B" 获胜。
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 *
 * 示例 3：
 * 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * 输出："Draw"
 * 输出：由于没有办法再行动，游戏以平局结束。
 * "XXO"
 * "OOX"
 * "XOX"
 *
 * 示例 4：
 * 输入：moves = [[0,0],[1,1]]
 * 输出："Pending"
 * 解释：游戏还没有结束。
 * "X  "
 * " O "
 * "   "
 *
 * 提示：
 * 1 <= moves.length <= 9
 * moves[i].length == 2
 * 0 <= moves[i][j] <= 2
 * moves 里没有重复的元素。
 * moves 遵循井字棋的规则。
 */
public class Tictactoe {

    public String tictactoe(int[][] moves) {
        int n = moves.length;
        if (n < 5) {
            return "Pending";
        }
        int[][] marks = new int[3][3];
        //先依次记录前四次的move
        for (int i = 0; i < 4; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                //此时A执行
                marks[x][y] = 1;
            } else {
                marks[x][y] = -1;
            }
        }
        for (int i = 4; i < n; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                //此时A执行
                marks[x][y] = 1;
                if (checkTic(x, y, marks, 1)) {
                    return "A";
                }
            } else {
                marks[x][y] = -1;
                if (checkTic(x, y, marks, -1)) {
                    return "B";
                }
            }
        }
        if (n == 9) {
            return "Draw";
        }
        return "Pending";
    }

    private boolean checkTic(int x, int y, int[][] marks, int target) {
        //1，检查行方向
        boolean isSame = true;
        for (int i = 0; i < 3; i++) {
            if (marks[x][i] != target) {
                isSame = false;
                break;
            }
        }
        if (isSame) {
            return true;
        }
        //2，检查列方向
        isSame = true;
        for (int i = 0; i < 3; i++) {
            if (marks[i][y] != target) {
                isSame = false;
                break;
            }
        }
        if (isSame) {
            return true;
        }
        //3，检查对角
        if (x == y) {
            isSame = true;
            for (int i = 0; i < 3; i++) {
                if (marks[i][i] != target) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return true;
            }
        }
        if (x + y == 2) {
            isSame = true;
            for (int i = 0; i < 3; i++) {
                if (marks[i][2 - i] != target) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return true;
            }
        }
        return false;
    }
}
