class Solution {
    
    class State{
        int index;
        int start;
        int timeOff;
    }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[]=new int[n];
        Stack<State> processorWait=new Stack<State>();
        HashSet<Integer> startedProcesses=new HashSet<Integer>();
        HashSet<Integer> endedProcesses=new HashSet<Integer>();
        final int len=logs.size();
        for(int i=0;i<len;i++){
            String currentLog=logs.get(i);
            if(getAction(currentLog).equals("start")){
                if(startedProcesses.contains(getId(currentLog))) continue;
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
                    endedProcesses.add(getId(currentLog));
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


    
  /*  private int processLogs(int id,int index,int[] res,List<String> logs){
        int globalTime=0;
        String currentLog=logs.get(id);
        String[] data=currentLog.split(":");
        int startTime=Integer.parseInt(data[2]);
        int logIterator=index+1;
        while(getIndex(logs.get(logIterator))!=index){
            int nextId=getId(logs.get(logIterator));
            processLogs(nextId,logIterator,res,logs);
        }
    }
    */