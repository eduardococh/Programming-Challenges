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

        //3ms solution by leetcode samples
        //Solutions using an array are the fastest ones
        //Same approach as mine but elegant
class Solution {
   public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int S = s.length(), P = p.length();
       if (P == 0 || S == 0 || S < P) return res;
        int[] pa = new int[26];
        int[] wa = new int[26];
        for (int i = 0; i < P; i++) {
            pa[p.charAt(i) - 'a']++;
            wa[s.charAt(i) - 'a']++;
        }
        // System.out.println(Arrays.toString(pa));
        // System.out.println(Arrays.toString(wa));
        for (int i = 0; i <= S - P; i++) {
            int j;
            for (j = 0; j < 26; j++)
                if (wa[j] != pa[j]) break;
            if (j == 26) res.add(i);
            if (i == S - P) break;
            wa[s.charAt(i) - 'a']--;
            wa[s.charAt(i + P) - 'a']++;
        }
        return res;
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


        //HashMap solution by leetcode
        //Terrible runtime of 69ms better than only 18.93% O(N)
        //Bad memory
        //Exact same as array approach, but WAY SLOWER
        //Didn't know that you can directly compare hashMaps with equal
        //Interesting
class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length(), np = p.length();
    if (ns < np) return new ArrayList();

    Map<Character, Integer> pCount = new HashMap();
    Map<Character, Integer> sCount = new HashMap();
    // build reference hashmap using string p
    for (char ch : p.toCharArray()) {
      if (pCount.containsKey(ch)) {
        pCount.put(ch, pCount.get(ch) + 1);
      }
      else {
        pCount.put(ch, 1);
      }
    }

    List<Integer> output = new ArrayList();
    // sliding window on the string s
    for (int i = 0; i < ns; ++i) {
      // add one more letter 
      // on the right side of the window
      char ch = s.charAt(i);
      if (sCount.containsKey(ch)) {
        sCount.put(ch, sCount.get(ch) + 1);
      }
      else {
        sCount.put(ch, 1);
      }
      // remove one letter 
      // from the left side of the window
      if (i >= np) {
        ch = s.charAt(i - np);
        if (sCount.get(ch) == 1) {
          sCount.remove(ch);
        }
        else {
          sCount.put(ch, sCount.get(ch) - 1);
        }
      }
      // compare hashmap in the sliding window
      // with the reference hashmap
      if (pCount.equals(sCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }
}
        