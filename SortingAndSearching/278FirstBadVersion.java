//My very long solution
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int current=n,divided=n;
        boolean isBelowMe=false;
        System.out.println("hwey "+n);
        while(divided>0){
            System.out.println("in"+current);
            if(isBadVersion(current)){//true -> First bad is below me or me
                isBelowMe=true;
                divided=divided/2;
                current=current-divided;
                
            }else{                  //false -> First bad is over me
                isBelowMe=false;
                divided=divided/2;
                current=current+divided;
            }
            
        }
        if(isBelowMe==true){
            while(isBelowMe==true){
                System.out.println("out"+current);
                if(isBadVersion(current)==false){//first bad is first over me
                    isBelowMe=false;
                    current+=2; //Add 1 to get to the one over me and another for the current-- below
                }
                current--;
            }   
        }else{
            while(isBelowMe==false){
                System.out.println("out"+current);
                if(isBadVersion(current)==true){//first bad is me
                    isBelowMe=true;
                    current--; //Add 1 to get to the one over me and another for the current-- below
                }
                current++;
            }   
        }
        return current;
    }
}
//Usual binary search
public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}


//Desired solution as in article
public int firstBadVersion(int n) {
    int left = 1;
    int right = n;
    while (left < right) { 
        int mid = left + (right - left) / 2;  //mid=(L+(R-L))
        if (isBadVersion(mid)) {	      //        ---
            right = mid;		      //	 2
        } else {
            left = mid + 1;
        }
    }
    return left;
}
