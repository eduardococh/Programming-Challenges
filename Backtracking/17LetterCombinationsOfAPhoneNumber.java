		//My iterative solution
		//Might seem a lot of work to go through the whole list N times, but to my surprise it was
		//quite fast, though not the fastest at 1ms, better than 85%
		//Great memory, surprisingly for me at 35mb, less than 98.10%
		//Not backtracking as the category suggested
class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result=new ArrayList<>();
        if(digits.length()==0) return result;
        
        char[][] letterRelation={{'a','b','c'},{'d','e','f'},{'g','h','i'},
                                {'j','k','l'},{'m','n','o'},{'p','q','r','s'},
                                {'t','u','v'},{'w','x','y','z'}};
	//Get total number of combinations in the final answer
        int finalLength=1;
        for(char number:digits.toCharArray()){
            finalLength*=letterRelation[number-'2'].length;
        }
        //Fill stringb array list
        ArrayList<StringBuilder> aux=new ArrayList<>();
        for(int i=0;i<finalLength;i++){
            aux.add(new StringBuilder(""));
        }
        
        final int length=digits.length();
        char digArr[]=digits.toCharArray();

	//For every digit
        for(int i=0;i<length;i++){
            finalLength/=letterRelation[digArr[i]-'2'].length;
            int lengthOfIteration=finalLength;
            int currentDigit=0;

	    //Pass through whole result list and add next character
            for(int j=0;j<aux.size();j++){
                StringBuilder str=aux.get(j);
                str.append(letterRelation[digArr[i]-'2'][currentDigit]);
                lengthOfIteration--;
		
		//switch digits in filling so we get the alternating pattern
                if(lengthOfIteration==0){
                    lengthOfIteration=finalLength;
                    currentDigit++;
                    if(currentDigit==letterRelation[digArr[i]-'2'].length){
                        currentDigit=0;
                    }
                }
            }   
        }
        
        for(int j=0;j<aux.size();j++){
            result.add(aux.get(j).toString());
        }
        return result;
    }
}

		//Backtracking solution by leetcode's durenking (Since leetcodes solution runtime is 1ms, not greatest)
		//Best runtime at 0ms better than 100%	 
		//
class Solution {
    List rtn;
    StringBuilder sb;

    public List<String> letterCombinations(String digits) {
        rtn = new ArrayList<String>();
        if(digits.isEmpty()) return rtn;

        String[] data = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // 2~9
	
	//creates an array with the "data" values, so for 548664 it will have the respective letters
	//in that order
        String [] textList = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++) {
            int idx = digits.charAt(i) - '0' - 2;
            textList[i] = data[idx];
        }

        sb = new StringBuilder();
        recursion(textList, sb);

        return rtn;
    }

    private void recursion(String[] textList, StringBuilder track) {
        if(track.length() == textList.length) {
            rtn.add(track.toString());
            return;
        }

        int row = track.length();
        for(int i = 0; i < textList[row].length(); i++) {
            track.append(textList[row].charAt(i));
            recursion(textList, track);
            track.deleteCharAt(sb.length() - 1);
        }
    }
}



		//Leetcode's solution, not best runtime 85% good memory 97% but great explanation of backgracking
		//Global output list so the recursive algorithm can add to it
		//Very straightforward
class Solution {
  Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  List<String> output = new ArrayList<String>();


  public List<String> letterCombinations(String digits) {
    if (digits.length() != 0)
      backtrack("", digits);
    return output;
  }

  public void backtrack(String combination, String next_digits) {

    // if there is no more digits to check
    if (next_digits.length() == 0) {
      // the combination is done
      output.add(combination);

    } else {

    // if there are still digits to check
   
      // iterate over all letters which map 
      // the next available digit
      String digit = next_digits.substring(0, 1);
      String letters = phone.get(digit);

      //for every letter of this number backtrack
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, next_digits.substring(1));
      }
    }
  }

}