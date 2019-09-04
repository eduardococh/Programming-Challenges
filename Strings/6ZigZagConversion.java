		//My solution
		//Mediocre runtime at 12ms better than 46.06% O(N)
		//Mediocre memory at 40.2mb better than only 41.61% O(N)
		//Clear solution I think, but not the most optimal
class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        StringBuilder result[]=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            result[i]=new StringBuilder("");
        }
        final int length=s.length();
        int i=0;
        while(i<length){
            for(int j=0;j<numRows && i<length;j++){
                result[j].append(s.charAt(i));
                i++;
            }
            for(int j=numRows-2;j>0 && i<length;j--){
                result[j].append(s.charAt(i));
                i++;
            }
        }
        String endRes="";
        for(int j=0;j<numRows;j++){
            endRes+=(result[j]);
        }
        return endRes.toString();
    }
}


		//Leecodes solution, approach like me
		//But with more optimizations
		//Good runtime better than 69%
		//Good memory better than 79.80%
		//Very clever, goes up and down using a boolean

class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
	


		//Solution using known formulas
		//From leetcode's 3ms sample
		//Good runtime at 3ms better than 96% O(N)
		//Amazing memory at 36.8mb less than 99.80%
		//This is the best "trivial" solution as better solutions are complex
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}