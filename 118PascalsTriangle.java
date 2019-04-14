class Solution {
      //My solution, faster and better memory than 100% (weirdly same algorithm took different time in two submissions)
      //https://leetcode.com/submissions/detail/222232644/
      //https://leetcode.com/submissions/detail/221991646/
      //Runtime o(n2)
      //This was a dynamic programming solution, even thou i didnt know it until i saw the article, where it is the only solution
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(numRows==0){
            return result;
        }
        result.add(new ArrayList<Integer>(Arrays.asList(1)));
        if(numRows==1){
            return result;
        }
        result.add(new ArrayList<Integer>(Arrays.asList(1,1)));
        if(numRows==2){
            return result;
        }
        for(int i=3;i<=numRows;i++){
            List<Integer> temp=new ArrayList<Integer>();
            temp.add(1);
            List<Integer> prev=result.get(i-2);
            for(int j=1;j<prev.size();j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}

//Concise solution by leetcode rheaxu
//clever handling of corner cases for 0 and 1 and just more elegant, same runtime and memory
public class Solution {
   public List<List<Integer>> generate(int numRows){
   	List<List<Integer>> allrows = new ArrayList<List<Integer>>();
   	ArrayList<Integer> row = new ArrayList<Integer>();
      
   	for(int i=0;i<numRows;i++)
   	{
   		row.add(0, 1);
   		for(int j=1;j<row.size()-1;j++)
   			row.set(j, row.get(j)+row.get(j+1));
   		allrows.add(new ArrayList<Integer>(row));
   	}
   	return allrows;
   	
   }
}