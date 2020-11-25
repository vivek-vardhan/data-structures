package com.java.ds.miscellaneous;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of characters where each character represents a fruit tree,
 *
            You start at any tree of your choice, then repeatedly perform the following steps:

        1.  Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
        2.  Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 *
 *
 */
public class FruitIntoBasket {

    /*
    Algo is:

    1. keep 2 tracker: lastFruit, secondLastFruit
    2. keep 2 counts: lastFruitCount, curMax (this will be lastFruit + secondLastFruitCount), whenever fruit changes, curCount will be lastFruitCOunt


     */

    public static int totalFruit(int [] tree) {
        int lastFruit = -1;
        int secondLastFruit = -1;

        int lastFruitCount = 0, curMax = 0, max = 0;

        for (Integer fruit : tree) {
            if (fruit == lastFruit || fruit == secondLastFruit) { //same 2 is continuing, so curMax will increase
                curMax++;
                if (fruit == lastFruit) {
                    lastFruitCount++;//to maintain the count of last fruit that came
                }
            } else {
                curMax = lastFruitCount +1; //new fruit type, so last fruit + 1 will be new count for 2 different types of fruit
            }
            if (fruit != lastFruit) { //if the last fruit is not continuing, means
                lastFruitCount = 1;//some new last fruit, so last fruit count will be 1
                secondLastFruit = lastFruit;//now prev last fruit will be come the new second last fruit
                lastFruit = fruit;

            }
            max = Math.max(curMax, max);

        }

        return max;

    }

    /**
     *
     * This will be in general, and will work in scenario when instead of 2 fruits, there are n fruits
     *
     *  - BASED on sliding window
     *
     */
    public static int totalFruitV2(int[] tree) {
        int start =0, max = 0;

        Map<Integer, Integer> countOfFruitTypes = new HashMap<>();

        for (int i =0; i < tree.length; i++) {
            countOfFruitTypes.put(tree[i], countOfFruitTypes.getOrDefault(tree[i], 0) + 1);

            //now if size becomes 2, start removing the fruit
            while (countOfFruitTypes.size() > 2) {
                //reduce count of fruit at start
                countOfFruitTypes.put(tree[start], countOfFruitTypes.get(tree[start]) - 1);

                //and if count becomes 0, remove this fruit
                if (countOfFruitTypes.get(tree[start]) == 0) {
                    countOfFruitTypes.remove(tree[start]);
                }
                start++;

            }
            max = Math.max(max, i - start + 1);

        }

        return max;

    }


}
