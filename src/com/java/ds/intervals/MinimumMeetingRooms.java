package com.java.ds.intervals;

import java.util.*;

public class MinimumMeetingRooms {
    /*
    Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.


    Meetings: [[1,4], [2,5], [7,9]]
    Output: 2
    Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.


    So our algorithm will look like this:

    1. Sort all the meetings on their start time.
    2. Create a min-heap to store all the active meetings. This min-heap will also be used to find the active meeting with the smallest end time.
    3. Iterate through all the meetings one by one to add them in the min-heap. Let’s say we are trying to schedule the meeting m1.

    4. Since the min-heap contains all the active meetings, so before scheduling m1 we can remove all meetings from the heap that have ended before m1,
    i.e., remove all meetings from the heap that have an end time smaller than or equal to the start time of m1.

    5. Now add m1 to the heap.
    6. The heap will always have all the overlapping meetings, so we will need rooms for all of them.
    Keep a counter to remember the maximum size of the heap at any time which will be the minimum number of rooms needed.
     */


    class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    };

    public static int findMinimumMeetingRooms(List<Meeting> meetings) {
        if (meetings == null || meetings.size() == 0)
            return 0;

        Collections.sort(meetings, Comparator.comparingInt(Meeting::getStart));


        PriorityQueue<Meeting> minHeap =
                new PriorityQueue<>(meetings.size(), Comparator.comparingInt(Meeting::getEnd));

        int minRooms = 0;
        for (Meeting meeting : meetings) {
            // remove all meetings that have ended when this meeting came as the new meeting can come in the same room
            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll(); //remove the meetings whose start is greater than end of meetings in heap
            }
            // add the current meeting into the minHeap
            minHeap.offer(meeting);

            // all active meeting are in the minHeap, so we need rooms for all of them.
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
