        //My sliding window solution with not optimal checking
        //Create an array with 26 spaces for all letters and add the letters of p
        //process the string in a sliding window
        //Surprisingly good runtime of 5ms better than 94.68% O(N+M) (checking time will
        //always take 26, so this might be counted as constant)
        //Bad memory better than only 6% O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(s.length()==0 || p.length()==0) return result;
        if(s.length()<p.length()) return result;
        int[] arr=new int[26];
        final int lenP=p.length();
        final int lenS=s.length();
        //add all of p characters
        for(char car:p.toCharArray()){
            arr[car-'a']++;
        }
        for(int i=0;i<lenP;i++){
            arr[s.charAt(i)-'a']--;
        }
        if(checkArray(arr)) result.add(0);
        for(int i=lenP;i<lenS;i++){
            //we remove the first character
            arr[s.charAt(i-lenP)-'a']++;
            //we add the last character
            arr[s.charAt(i)-'a']--;
            if(checkArray(arr)) result.add(i-lenP+1);
        }
        return result;
    }
    
    public boolean checkArray(int arr[]){
        for(int a:arr){
            if(a!=0) return false;
        }
        return true;
    }
}

    /*
        My complex solution that might work with more tought into it
    */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new ArrayList<>();
        if(s.length()==0 || p.length()==0) return result;
        int[] arr=new int[26];
        int areEqual=0;
        //add all of p characters
        for(char car:p.toCharArray()){
            arr[car-'a']++;
            if(arr[car-'a']==1) areEqual++;
        }
        printArr(arr);
        System.out.println(areEqual);
        //remove all of s characters in p lenght
        final int lenP=p.length();
        for(int i=0;i<lenP;i++){
            arr[s.charAt(i)-'a']--;
            if(arr[s.charAt(i)-'a']==1) areEqual++;
            if(arr[s.charAt(i)-'a']==-1) areEqual++;
            if(areEqual==0) result.add(i-lenP+1);
        }
        printArr(arr);
        System.out.println(areEqual+"enter loop");
        if(areEqual==0) result.add(0);
        final int lenS=s.length();
        for(int i=lenP;i<lenS;i++){
            //we remove the first character
            arr[s.charAt(i-lenP)-'a']++;
            if(arr[s.charAt(i-lenP)-'a']==0) areEqual--;
            if(arr[s.charAt(i-lenP)-'a']==-1) areEqual++;
            if(arr[s.charAt(i-lenP)-'a']==1) areEqual++;
            printArr(arr);
            System.out.println(areEqual);
            //we add the last character
            arr[s.charAt(i)-'a']--;
            if(arr[s.charAt(i)-'a']==0) areEqual--;
            if(arr[s.charAt(i)-'a']==1) areEqual++;
            if(arr[s.charAt(i)-'a']==-1) areEqual++;
            if(areEqual==0) result.add(i-lenP+1);
            printArr(arr);
            System.out.println(areEqual);
        }
        return result;
    }
    
    public void printArr(int arr[]){
        for(int a:arr){
            System.out.print(a+",");
        }
        System.out.println();
    }
}