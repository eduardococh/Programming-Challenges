        //My solution
        //Described as divide and conquer by leetcode
        //Average runtime at 3ms better than 45.89% O(N)
        //Bad memory better than only 9.09% O(N) because of the need to split the string
        //Samples from 0ms use this same approach
class Solution {
    public String validIPAddress(String IP) {
        if(IP==null || IP.length()==0) return "Neither";
        if(IP.contains(":")){//IPV6
            if(IP.charAt(IP.length()-1)==':') return "Neither";
            String ranges[]=IP.split("\\:");
            if(ranges.length!=8) return "Neither";
            for(String number:ranges){
                System.out.println(number+"mm");
                if(number.length()==0) return "Neither";
                if(number.length()>4) return "Neither";
                number=number.toLowerCase();
                for(char car:number.toCharArray()){
                    if((car>='0' && car<='9') || (car>='a' && car<='f')){
                        
                    }else{
                        return "Neither";
                    }
                }
            }
            return "IPv6";
            
        }else{//IPV4
            if(IP.charAt(IP.length()-1)=='.') return "Neither";
            String ranges[]=IP.split("\\.");
            if(ranges.length!=4) return "Neither";
            for(String number:ranges){
                if(number.length()<1 || number.length()>4) return "Neither";
                if(number.charAt(0)=='0' && number.length()>1) return "Neither";
                for(char car:number.toCharArray()){
                    if(car<'0' || car>'9') return "Neither";
                }
                int num=Integer.parseInt(number);
                if(num<0 || num>255) return "Neither";
            }
            return "IPv4";
        } 
    }
}

    ///Other solutions were using built in functionalities (not really a challenge)
    //Using regex for which you need the knowledge
    //Bad runtime 10ms better than only 8.31% O(N)
import java.util.regex.Pattern;
class Solution {
  String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
  Pattern pattenIPv4 =
          Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

  String chunkIPv6 = "([0-9a-fA-F]{1,4})";
  Pattern pattenIPv6 =
          Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");

  public String validIPAddress(String IP) {
    if (pattenIPv4.matcher(IP).matches()) return "IPv4";
    return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
  }
}