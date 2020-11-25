package com.java.ds.intervals;

import java.util.*;

public class EmployeeFreeTime {
    /*
    For ‘K’ employees, we are given a list of intervals representing the working hours of each employee.
    Our goal is to find out if there is a free interval that is common to all employees.
    You can assume that each list of employee working hours is sorted on the start time.


    Input: Employee Working Hours=[[[1,3], [9,12]],       [[2,4]], [[6,8]]]
    Output: [4,6], [8,9]
    Explanation: All employees are free between [4,6] and [8,9].

     */

    class Employee {
        Interval interval; // interval representing employee's working hours
        int employeeIndex; // index of the list containing working hours of this employee
        int intervalIndex; // index of the interval in the employee list

        public Employee(Interval interval, int employeeIndex, int intervalIndex) {
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;
        }

        public Interval getInterval() {
            return interval;
        }

        public int getEmployeeIndex() {
            return employeeIndex;
        }

        public int getIntervalIndex() {
            return intervalIndex;
        }
    }

    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Employee> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.interval.getStart(), b.interval.getStart()));

        // insert the first interval of each employee to the queue
        for (int i = 0; i < schedule.size(); i++) {
            minHeap.add(new Employee(schedule.get(i).get(0), i, 0));
        }
        //Take 1st interval
        Interval previousInterval = minHeap.peek().interval;

        List<Interval> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Employee top = minHeap.poll();
            // if previousInterval is not overlapping with the next interval, insert a free interval
            if (previousInterval.getEnd() < top.interval.getStart()) {
                result.add(new Interval(previousInterval.getEnd(), top.interval.getStart()));
                previousInterval = top.interval;
            } else { // overlapping intervals, update the previousInterval if needed
                if (previousInterval.getEnd() < top.interval.getEnd()) {
                    previousInterval = top.interval;
                }

            }
            // if there are more intervals available for the same employee, add their next interval
            List<Interval> employeeSchedule = schedule.get(top.employeeIndex);
            if (employeeSchedule.size() > top.intervalIndex + 1) {
                minHeap.add(new Employee(employeeSchedule.get(top.intervalIndex + 1), top.employeeIndex,
                        top.intervalIndex + 1));
            }
        }
        return result;

    }
}
