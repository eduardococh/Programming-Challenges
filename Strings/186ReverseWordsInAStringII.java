class Solution {
    public void reverseWords(char[] s) {
        StringBuilder result=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        for(char ch:s){
            if(ch==' '){
                sb.insert(0,' ');
                result.insert(0,sb);
                sb=new StringBuilder();
                System.out.println("fsdf "+result.toString());
            }else{
                sb.append(ch);
            }
        }
        result.insert(0,sb);
        System.out.println("fsdf "+result.toString());
        int cont=0;
        for(char c:result.toString().toCharArray()){
            s[cont++]=c;
        }
    }
}