package study_08_02;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1. new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        
        // 2. new_id에서 알파벳 소문자, 숫자, (-), (_), (.)를 제외한 모든 문자를 제거합니다.
        String[] str = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")","=", "+", "[", "{", "]", "}", ":", "?", ",", "<", ">", "/"};
        
        for(int i=0; i<str.length; i++){
            new_id = new_id.replaceAll("\\"+str[i], "");
        }
        
        // 3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        
        // 4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(new_id.length() >0){
            if(new_id.charAt(0) == '.'){
                new_id = new_id.substring(1);
            }
        }
        if(new_id.length() >0){
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        
        // 5. new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.equals("")) {
            new_id = "a";
        }
        
        // 6. new_id의 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            if(new_id.charAt(new_id.length()-1) == '.'){
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        
        
        /* 7. new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 
        반복해서 끝에 붙입니다. */
        if(new_id.length() <=2){
            char last = new_id.charAt(new_id.length() - 1);
            while(new_id.length() <3){
                new_id += last;
            }
        }
        
        return new_id;
    }
}