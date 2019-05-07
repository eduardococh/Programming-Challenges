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