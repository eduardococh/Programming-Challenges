class Solution {
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