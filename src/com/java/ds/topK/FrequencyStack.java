package com.java.ds.topK;

import java.util.*;

public class FrequencyStack {
    /*

    Design a class that simulates a Stack data structure, implementing the following two operations:

        push(int num): Pushes the number ‘num’ on the stack.
        pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.


        After following push operations: push(1), push(2), push(3), push(2), push(1), push(2), push(5)

        1. pop() should return 2, as it is the most frequent number
        2. Next pop() should return 1
        3. Next pop() should return 2
     */
    class Element {
        int number;// value of the number
        int frequency;// current frequency of the number when it was pushed to the heap
        int sequenceNumber;// a sequence number, to know what number came first

        public Element(int number, int frequency, int sequenceNumber) {
            this.number = number;
            this.frequency = frequency;
            this.sequenceNumber = sequenceNumber;
        }
    }

    int globalSequenceNumber = 0;

    PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new Comparator<Element>() {
        @Override
        public int compare(Element o1, Element o2) {
            if (o1.frequency != o2.frequency) {
                return o2.frequency - o1.frequency;
            }
            // if both elements have same frequency, return the one that was pushed later
            return o1.sequenceNumber - o2.sequenceNumber;
        }
    });

    Map<Integer, Integer> frequencyMap = new HashMap<>();


    public void push(int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        maxHeap.add(new Element(num, frequencyMap.get(num), globalSequenceNumber++));
    }

    public int pop() {
        int num = maxHeap.poll().number;

        // decrement the frequency or remove if this is the last number
        if (frequencyMap.get(num) > 1) {
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        } else {
            frequencyMap.remove(num);
        }

        return num;
    }

}
