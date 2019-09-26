        //My solution, checking every string with the same starting character of B
        //Good runtime 0ms O(N^2) better than 100% (even leetcode's brute force runs in 0ms)
        //Good memory better than 100%
        //Average solution, but with this same runtime we better use the (A+A).contains(B) approach
class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length()==0 && B.length()==0) return true;
        if(A.length()!=B.length()) return false;
        int startA=-1;
        final int lengths=A.length();
        for(int i=0;i<lengths;i++){
            if(A.charAt(i)==B.charAt(0)){
                if(tryStart(i,A,B,lengths)) return true;
            }
        }
        return false;
    }
    
    public boolean tryStart(int startA,String A, String B, int lengths){
        int startB=0;
        while(startA<lengths){
            if(A.charAt(startA++)!=B.charAt(startB++)){
                return false;
            }
        }
        startA=0;
        while(startB<lengths){
            if(A.charAt(startA++)!=B.charAt(startB++)){
                return false;
            }
        }
        return true;
    }
}

    //Super simple approach by leetcode
    //If B is a rotation then the string A+A must contain it
    //So we check it
    //Same time and memory as my approach, better than 100%
    //Time complecity of O(N^2) according to leetcode, but I doubt it since
    //java string contains has a time complexity at worse of O(MN) but could be O(N)
    //Memory of O(N) because we have to create a new string to search in
    //Important to check length of both strings
class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}

    //Rolling hash solution by leetcode
    //Terrible time of 3ms better than 5.90% O(N)
    //Good memory better than 100%
    //The approach with the best time complexity has the worse runtime 
    //Must be because test cases are at most 100 characters long
    //Rolling hash is an approach seen in elements of programming interview as the
    //Rabin-Karp algorithm, buut to a different problem (finding first ocurrence of subtring)
    //Here a complex hash was used, something as simple as mod 31 could work (with more hash colissions)
import java.math.BigInteger;
class Solution {
    public boolean rotateString(String A, String B) {
        //a check of lenght of both strings could be added
        if (A.equals(B)) return true;

        int MOD = 1_000_000_007;
        int P = 113;
        int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

        long hb = 0, power = 1;
        for (char x: B.toCharArray()) {
            hb = (hb + power * x) % MOD;
            power = power * P % MOD;
        }

        long ha = 0; power = 1;
        char[] ca = A.toCharArray();
        for (char x: ca) {
            ha = (ha + power * x) % MOD;
            power = power * P % MOD;
        }

        for (int i = 0; i < ca.length; ++i) {
            char x = ca[i];
            ha += power * x - x;
            ha %= MOD;
            ha *= Pinv;
            ha %= MOD;
            if (ha == hb && (A.substring(i+1) + A.substring(0, i+1)).equals(B))
                return true;

        }
        return false;
    }
}