package study_08_02;

class Solution {
    public int solution(String s) {
        int ans = 0;
        
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<=9; i++){
            s = s.replaceAll(str[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}