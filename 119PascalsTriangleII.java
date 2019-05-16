		//Solution using k length array	
		//Didn't like this problem, same as Pascals Triangle 1
		//Great runtime better than 100%
		//Middle memory better than 51.86%
		//Clever approach, starting from back to front in the generation of each row
		//Penultimate fills with 1 last position, then goes to front until number 1
class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        
        int row[] = new int[rowIndex+1];
        
        row[0] = 1;
        for(int r = 1; r <= rowIndex; r++) {
            for(int c = r; c >= 1; c--) {
                row[c] += row[c-1];
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
            result.add(row[i]);
        }
        return result;
    }
    
}

		//Using array list
		//Worse runtime than with array 1ms worse better than 85%
		//same memory as array
		//Front to back, add 1 to end of every iteration and then fill j with previous
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
                res.add(1);
                for(int j=i-1;j>0;j--) {
                    res.set(j, res.get(j-1)+res.get(j));
                }
        }
        return res;
    }
}
