		//My backtracking solution
		//A "simple" backtracking problem, complicated due to the long answers (2 is very long, 3 even longer)
		//Bad runtime at 198ms better than only 5.15% O(N*N)
		//Bad memory at 47.7mb better than only 5.08% O(
		//Not the most eleg
class Solution {
    
    List<Integer> hours=new ArrayList<>(Arrays.asList(1,2,4,8));
    List<Integer> minutes=new ArrayList<>(Arrays.asList(1,2,4,8,16,32));

    public List<String> readBinaryWatch(int num) {
        List<String> result=new ArrayList<>();
        generateHours(result,num,0,0);
        return result;
    }
    
    public void generateHours(List<String> result, int num, int hour, int minute){
        if(num==0){
            String minuteS=minute<10?0+""+minute:minute+"";
            if(result.contains(hour+":"+minuteS)){
                return;
            }
            result.add(hour+":"+minuteS);
            return;
        }
        for(int i=0;i<minutes.size();i++){
            int aux=minutes.get(i);
            minutes.remove(i);
            minute+=aux;
            if(minute<=59){
                generateHours(result,num-1,hour,minute);
            }
            minute-=aux;
            minutes.add(i,aux);
        }
        for(int i=0;i<hours.size();i++){
            int aux=hours.get(i);
            hours.remove(i);
            hour+=aux;
            if(hour<=11){
                generateHours(result,num-1,hour,minute);
            }
            hour-=aux;
            hours.add(i,aux);
        }
    }
}



		//Backtracking approach optimized
		//Good runtime of 2ms better than 52.44%
		//Amazing memory of 36.9mb better than 100%
		//Same approach as me (two arrays and backtracking) but with BIG improvements
		//The most notorious is usage of visited arrays, which removes the need for modification of arraylist like me
		//this same visited then helps in getting time, the only thing that could be better is maybe removing 
		//so many global variables, but great approach
		

class Solution {
    
    int count = 0;
    boolean[] visitedM = new boolean[6];
    boolean[] visitedH = new boolean[4];
    int[] m = {1, 2, 4, 8, 16, 32};
    int[] h = {1, 2, 4, 8};
    int num;
    Set<String> result = new HashSet<>();
    
    public List<String> readBinaryWatch(int num) {
        this.num = num; 
        backtrack(0, 0, 0);
        List<String> r = new ArrayList<>();
        for (String res: result) {
            r.add(res);
        }
        return r;
    }
    
    private void backtrack(int used, int mIndex, int hIndex) {
        if (used == num) {
            String time = getTime();
            if (time != null) {
                result.add(time);
            }
            return;
        }
        
        for (int mi = mIndex; mi < m.length; ++mi) {
            if (!visitedM[mi]) {
                visitedM[mi] = true;
                backtrack(used + 1, mi + 1, hIndex);
                visitedM[mi] = false;
            }
        }
        for (int hi = hIndex; hi < h.length; ++hi) {
            if (!visitedH[hi]) {
                visitedH[hi] = true;
                backtrack(used + 1, mIndex, hi + 1);
                visitedH[hi] = false;
            }
        }
    }
    
    String getTime() {
        int min = 0;
        for (int i = 0; i < m.length; ++i) {
            if (visitedM[i]) {
                min += m[i];
            }
        }
        if (min > 59) return null;
        
        int hour = 0;
        for (int i = 0; i < h.length; ++i) {
            if (visitedH[i]) {
                hour += h[i];
            }
        }
        if (hour > 11) return null;
        return "" + hour + ":" + (min < 10 ? "0" : "") + min;
    }
}