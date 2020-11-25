package com.java.ds.intervals;

import java.util.*;

public class MaximumCPULoad {

    /*
    We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
    Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

    Jobs: [[1,4,3], [2,5,4], [7,9,6]]
    Output: 7
    Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the  jobs are running at the same time
    i.e., during the time interval (2,4).


    Jobs: [[6,7,10], [2,4,11], [8,12,15]]
    Output: 15
    Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.

     */


    class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCpuLoad() {
            return cpuLoad;
        }
    };

    public static int findMaxCPULoad(List<Job> jobs) {
        // sort the jobs by start time
        Collections.sort(jobs, Comparator.comparingInt(Job::getStart));

        int maxCPULoad = 0;
        int currentCPULoad = 0;

        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(),  Comparator.comparingInt(Job::getEnd));
        for (Job job : jobs) {
            // remove all jobs that have ended
            while (!minHeap.isEmpty() && job.start > minHeap.peek().end)
                currentCPULoad -= minHeap.poll().cpuLoad;

            // add the current job into the minHeap
            minHeap.offer(job);
            currentCPULoad += job.cpuLoad;
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }
        return maxCPULoad;
    }

}
