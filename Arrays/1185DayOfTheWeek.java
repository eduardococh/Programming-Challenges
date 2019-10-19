        //My solution
        //Average runtime of 1 ms, faster than 35.98% O(N)
        //Amazing memory better than 100% O(1)
        //The big problem with my solution was choosing a difficult start date
        //that is in the middle of the series, because if the date is smaller or bigger
        //you will need 2 algorithms, if you use 1/1/1971 or 31/12/2100 you get rid
        //of this problem, i partially did this by choosing 1/1 2019 but the problem was
        //the year
        //This problem can be done with zeller formula, built in classes or
        //with well calculated contants, but it's not intuitive like for an interview 

        //TWO BIG LESSONS
        //careful with modulos, here modulo 6 didnt work since 6%6 is 0, not 6 like i thought
        //this took a lot of time to solve
        //This line of code if(dayIndex<0) dayIndex=7-dayIndex;
        //which also took a lot to find, kinda obvious but if dayIndex is negative
        //and you use 7-dayIndex you'll end up with a bigger number, because -(-) makes positive

        //This solution could make sence if there's no way to know which date was in 1/1/1971
        //or zeller formula or other, but I dont think it would be an "easy" problem, medium maybe
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        //
        int tDay=1;
        int tMonth=1;
        int tYear=2019;
        //from 0 to 6
        String[] daysOfWeek=new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        HashSet<Integer> months30=new HashSet(Arrays.asList(4,6,9,11));
        int dayIndex=1;//tuesday
        
        while(year<tYear){//past
            if(isLeapYear(tYear)){
                dayIndex-=2;
            }else{
                dayIndex--;
            }
            //FUCKING LEARN THIS 
            //if(dayIndex<0) dayIndex=7-dayIndex;
            //THIS IS WRONG SINCE -(-) MAKES POSITIVE, 7-dayIndex RESULTED IN 8 OR 9
            //LEARN THIS
            if(dayIndex<0) dayIndex=7+dayIndex;
            tYear--;
        }
        while(year>tYear){//future
            if(isLeapYear(tYear)){
                dayIndex+=2;
            }else{
                dayIndex++;
            }
            if(dayIndex>6) dayIndex=dayIndex%7;
            tYear++;
        }
        
        //we're on the 1st of january of the target year
        
        while(tMonth<month){
            if(tMonth==2){
                if(isLeapYear(tYear)){
                    tDay++;
                    dayIndex++;
                    dayIndex=dayIndex%7;
                }//else nothing changes
                //28 days leave the calendar in same day
                
            }else if(months30.contains(tMonth)){
                dayIndex=dayIndex+2;
                dayIndex=dayIndex%7;
            }else{
                dayIndex=dayIndex+3;
                dayIndex=dayIndex%7;
            }
            tMonth++;
        }
        while(tDay<day){
            tDay++;
            dayIndex++;
            dayIndex=dayIndex%7;
        }
        if(isLeapYear(year) && month<=2){
            dayIndex--;
            if(dayIndex<0) dayIndex=7+dayIndex;
        }
        return daysOfWeek[dayIndex];
    }
    
    public boolean isLeapYear(int year){
        if(year%4!=0){
            //is not divisible by 4, not leap
            return false;
        }else if(year%100!=0){
            //is divisible by 4, but not 100, is leap
            return true;
        }else if(year%400==0){
            //is divisible by 4,100 and 400, is leap (2000)
            return true;
        }else{
            //is divisible by 4 and by 100 but not by 400, is not leap (2100)
            return false;
        }
    }
}


        //Solution by leetcode's davidluoyes
        //Really simple and elegant
        //Amazing runtime 0ms better than 100%
        //Amazing memory better than 100%
        //Trick is starting from first year (or last) and only adding days
        //depending on year or month, really clever
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int num = 0;
        for(int i = 1971;i<year;i++){
            //This works since range is 1971-2100, otherwise use my method above
            if(i % 4 == 0) num += 366;
            else num += 365;
        }
        if(year % 4 == 0) daysOfMonth[1] = 29;
        for(int i = 0;i<month-1;i++){
            num += daysOfMonth[i];
        }
        num += day - 1;
        //we add five since 1/1/1971 is friday
        return week[(num + 5)%7];
    }
}