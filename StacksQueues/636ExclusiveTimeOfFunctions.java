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