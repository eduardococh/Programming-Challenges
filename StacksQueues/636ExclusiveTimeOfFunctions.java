class Solution {
    
    class State{
        int index;
        int start;
        int timeOff;
    }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[]=new int[n];
        Stack<State> processorWait=new Stack<State>();
        HashMap<Integer,Integer> startedProcesses=new HashMap<>();
        final int len=logs.size();
        for(int i=0;i<len;i++){
            String currentLog=logs.get(i);
            if(getAction(currentLog).equals("start")){
                if(startedProcesses.containsKey(getId(currentLog)){
                    
                }else{
                    startedProcesses.put(getId(currentLog),1);
                }
            }else{
                if(endedProcesses.contains(getId(currentLog))) continue;
            }
            if(!processorWait.isEmpty()){
                if(processorWait.peek().index==getId(currentLog)){//we have a coincidence
                    State processingStart=processorWait.pop();
                    int totalTime=getTimestamp(currentLog)-processingStart.start+1;
                    res[processingStart.index]=totalTime-processingStart.timeOff;
                    if(!processorWait.isEmpty()){//i will pass my total time as timeoff to father
                        processorWait.peek().timeOff+=totalTime;
                    }
                }else{
                    startedProcesses.add(getId(currentLog));
                    State procStart=new State();
                    procStart.index=getId(currentLog);
                    procStart.start=getTimestamp(currentLog);
                    procStart.timeOff=0;
                    processorWait.push(procStart);
                }
            }else{
                startedProcesses.add(getId(currentLog));
                State procStart=new State();
                procStart.index=getId(currentLog);
                procStart.start=getTimestamp(currentLog);
                procStart.timeOff=0;
                processorWait.push(procStart);
            }
        }
        return res;
    }

    
    private int getTimestamp(String log){
        String[] data=log.split(":");
        return Integer.parseInt(data[2]);
    }
    
    private int getId(String log){
        String[] data=log.split(":");
        return Integer.parseInt(data[0]);
    }
    
    private String getAction(String log){
        String[] data=log.split(":");
        return data[1];
    }
}

        //Simplified approach
class Solution {
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[]=new int[n];
        int currentId=-1,currentStart=-1;
        Stack<Integer> idStack=new Stack<>(),timeStack=new Stack<>();
        //we are supposing data is valid (any end has a start)
        for(String log:logs){
            if(idStack.isEmpty()){
                idStack.push(getId(log));
                timeStack.push(getTimestamp(log));
            }else{
                if(currentId>=0){//
                
                }   
            }
        }
        return res;
    }
    
    private int getId(String log){
        String[] data=log.split(":");
        return Integer.parseInt(data[0]);
    }
    
    private String getAction(String log){
        String[] data=log.split(":");
        return data[1];
    }
    
    private int getTimestamp(String log){
        String[] data=log.split(":");
        return Integer.parseInt(data[2]);
    }

}



public class Solution {
    public int[] exclusiveTime(int n, List < String > logs) {
        Stack < Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.par seInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
}