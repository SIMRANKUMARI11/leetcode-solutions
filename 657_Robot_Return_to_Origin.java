// Problem: Robot Return to Origin
// Platform: LeetCode
// Link: https://leetcode.com/problems/robot-return-to-origin/
/*
Approach:
We track x and y.
U -> y++
D -> y--
R -> x++
L -> x--

If x == 0 and y == 0 → return true
*/

class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for(char ch : moves.toCharArray()) {
            if(ch == 'U') y++;
            else if(ch == 'D') y--;
            else if(ch == 'R') x++;
            else if(ch == 'L') x--;
        }

        return x == 0 && y == 0;
    }
}
