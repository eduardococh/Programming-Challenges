class Solution {
	//My solution, simple, beats 70% time, 100% best memory usage 
    public int countPrimes(int n) {
        boolean array[]=new boolean[n];
        int cont=0;
        for(int i=1;i<array.length-1;i++){
            if(array[i]==false){
                cont++;
                for(int j=i;j<array.length;j=j+(i+1)){
                    array[j]=true;
                }
            }
        }
        return cont;
    }

	//Optimized solution from leetcode, 99.12% time

    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int ans = 1;// don't forget to record 2. :-)
        boolean[] isCompositeArr = new boolean[n];
        int upper = (int) Math.sqrt(n);
        for(int i = 3;i < n;i=i+2){//1.scan only odd number
            if(isCompositeArr[i]) continue;
            ans++;
            if(i > upper) continue;//2. avoid i^2 overflow.
            for(int j = i*i; j < n;j = j + 2*i){//3. initialize j to i^2
                                                //4. increase 2i to keep j as an odd number
                
                isCompositeArr[j] = true;
            }
        }
        return ans;
    }
}