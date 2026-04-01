class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hmap = {}
        noOfPartions = 0
        noMaxFreqTask = 0
        maxFreq = 0
        for task in tasks:
            hmap[task] = hmap.get(task, 0) + 1
            maxFreq = max(maxFreq,hmap[task])
        
        for k in hmap.keys():
            if hmap[k] == maxFreq:
                noMaxFreqTask += 1

        noOfPartitions = maxFreq -1
        availableslot = noOfPartitions * (n-(noMaxFreqTask -1))
        noOfPendingTasks = len(tasks) - (maxFreq * noMaxFreqTask)
        idle = max(0,availableslot - noOfPendingTasks)
        return len(tasks) + idle