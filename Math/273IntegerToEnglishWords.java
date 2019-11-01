        //My solution (very similar to the one given by leetcode)
        //they call it divide and conquer
        //Long (110 lines with spacing (vs leetcode's 106)) 
        //but very easy to understand i believe
        //Simple, divide number in batches of 3
        //For billion there are only two choices
        //For millions, thousands and hundreds use hundredCalculator
        //Hundred calculator gets the name of a trio and then we just append the
        //subfix (or however is called)
        //Good runtime of 2ms better than 80.16% O(N)
        //Amazing memory better than 100% O(1)
class Solution {
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        StringBuilder res=new StringBuilder("");
        int billions=num/1000000000;
        if(billions==1){
            res.append("One Billion ");
        }else if(billions==2){
            res.append("Two Billion ");
        }
        
        num=num%1000000000;
        int millions=num/1000000;
        if(millions>0) res.append(hundredCalculator(millions)+"Million ");
        
        num=num%1000000;
        int thousands=num/1000;
        if(thousands>0) res.append(hundredCalculator(thousands)+"Thousand ");
        
        
        num=num%1000;
        int hundreds=num;
        if(hundreds>0) res.append(hundredCalculator(hundreds));
        
        res.setLength(res.length() - 1);
        return res.toString();
    }
    
    public String hundredCalculator(int prefix){
        StringBuilder res=new StringBuilder("");
        
        int hundreds=prefix/100;
        if(hundreds>0) res.append(unitCalculator(hundreds)+"Hundred ");
        
        int tens=prefix%100/10;
        int units=prefix%10;
        if(tens==1){
            res.append(elevensCalculator(units));
        }else{
            if(tens>0) res.append(tensCalculator(tens));
            if(units>0) res.append(unitCalculator(units));
        }
        return res.toString();
    }
    
    public String elevensCalculator(int unit){
        switch(unit){
            case 0:
                return "Ten ";
            case 1:
                return "Eleven ";
            case 2:
                return "Twelve ";
            case 3:
                return "Thirteen ";
            case 4:
                return "Fourteen ";
            case 5:
                return "Fifteen ";
            case 6:
                return "Sixteen ";
            case 7:
                return "Seventeen ";
            case 8:
                return "Eighteen ";
            case 9:
                return "Nineteen ";
        }
        return "";
    }
    
    public String unitCalculator(int unit){
        switch(unit){
            case 1:
                return "One ";
            case 2:
                return "Two ";
            case 3:
                return "Three ";
            case 4:
                return "Four ";
            case 5:
                return "Five ";
            case 6:
                return "Six ";
            case 7:
                return "Seven ";
            case 8:
                return "Eight ";
            case 9:
                return "Nine ";
        }
        return "";
    }
    
    public String tensCalculator(int unit){
        switch(unit){
            case 2:
                return "Twenty ";
            case 3:
                return "Thirty ";
            case 4:
                return "Forty ";
            case 5:
                return "Fifty ";
            case 6:
                return "Sixty ";
            case 7:
                return "Seventy ";
            case 8:
                return "Eighty ";
            case 9:
                return "Ninety ";
        }
        return "";
    }
}

        //Amazingly simple solution from leetcode's hwy_2015
        //I don't think you're expected to come up with this, but it's really
        //clever and elegant
        //Same memory and runtime as my problem
class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) +THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}