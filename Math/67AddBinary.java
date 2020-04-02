class Solution {
		//My first solution using strings, faster than 58.96% (average) o(maxlength(A,B))
		//Memory usage better than 56% (average)
		//Average solution, very straightforward
    public String addBinary(String a, String b) {
        int contA=a.length()-1,contB=b.length()-1;
        String res="";
        char carry='0';
        while(contA>-1 || contB>-1 || carry=='1'){
            char c1=contA>-1?a.charAt(contA):'0';
            char c2=contB>-1?b.charAt(contB):'0';
            if(c1 == '1' && c2 == '1'){
                if(carry=='1'){
                    res='1'+res;
                }else{
                    res='0'+res;
                    carry='1';
                }
            }else{
                if(c1 == '1' || c2=='1'){
                    if(carry=='1'){
                        res='0'+res;
                    }else{
                        res='1'+res;
                    }
                }else{
                    if(carry=='1'){
                        res='1'+res;
                        carry='0';
                    }else{
                        res='0'+res;
                    }
                }
            }
            contA--;
            contB--;
        }
        return res;
    }
}

class Solution {
		//My solution with string builder, BIG improvement in time beating 99.94
		//Average memory better than 56%
		//Preferable to first
    public String addBinary(String a, String b) {
        int contA=a.length()-1,contB=b.length()-1;
        StringBuilder res=new StringBuilder("");
        char carry='0';
        while(contA>-1 || contB>-1 || carry=='1'){
            char c1=contA>-1?a.charAt(contA):'0';
            char c2=contB>-1?b.charAt(contB):'0';
            if(c1 == '1' && c2 == '1'){
                if(carry=='1'){
                    res.insert(0,'1');
                }else{
                    res.insert(0,'0');
                    carry='1';
                }
            }else{
                if(c1 == '1' || c2=='1'){
                    if(carry=='1'){
                        res.insert(0,'0');
                    }else{
                        res.insert(0,'1');
                    }
                }else{
                    if(carry=='1'){
                        res.insert(0,'1');
                        carry='0';
                    }else{
                        res.insert(0,'0');
                    }
                }
            }
            contA--;
            contB--;
        }
        return res.toString();
    }
}

class Solution {
		//Great solution using math instead of ifs for addition
		//Found it as a great memory solution, but when i ran it it was not so good
		//Still interesting approach
    public String addBinary(String a, String b) {
         int i = a.length()-1;
        int j = b.length()-1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = 0;
            if(i>=0 && a.charAt(i) == '1')
                sum++;
            if(j>=0 && b.charAt(j) == '1')
                sum++;
            sum = sum+carry;
            if(sum >=2){
                carry = 1;
            }else{
                carry = 0;
            }
            sb.insert(0,  (char) ((sum%2) + '0'));
            i--;
            j--;
        }
        if(carry==1)
            sb.insert(0, '1');
        return  sb.toString();
    }
}


        //My not elegant solution
        //the part of the sum is bad
        //Good runtime of 2ms better than 78.76% O(N)
        //Bad memory better than 5% O(1)
        //BIG MISTAKE: Coding before understanding, like going forward backward instead of reverse
        //Also, horrible sum with switch instead of the super elegant sum>=2 and sum%2
class Solution {
    public String addBinary(String a, String b) {
        if(a.length()==0 && b.length()==0) return "0";
        //ensure a is longer or equal than b
        if(a.length()<b.length()) return addBinary(b,a);
        
        final int len1=a.length(),len2=b.length(),diff=len1-len2;
        int carry=0;
        StringBuilder result=new StringBuilder("");
        for(int i=len1-1;i>=0;i--){
            int ca=a.charAt(i)-'0',cb;
            if(i-diff<0){
                cb=0;
            }else{
                cb=b.charAt(i-diff)-'0';
            }
            int res=ca+cb+carry;
            switch(res){
                case 0: result.append('0');
                        break;
                case 1: result.append('1');
                        carry=0;
                        break;
                case 2: result.append('0');
                        carry=1;
                        break;
                case 3: result.append('1');
                        carry=1;
            }
        }
        if(carry==1) result.append('1');
        return result.reverse().toString();
    }
}