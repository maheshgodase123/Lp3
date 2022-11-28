package practice;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class knapsack {

    public static void main(String[] args) {

        final DecimalFormat df = new DecimalFormat("0.0");

        int [] profit = {24,15,25};

        int [] weight = {15,10,18};

        int capacity = 20;


        Float [] ratio = new Float[profit.length];

        for(int i = 0; i < profit.length; i++)
        {
            ratio[i] = Float.parseFloat(df.format((float)profit[i]/weight[i]));
        }

        int [] sortedIndices = sortWithIndices(ratio);

        float finalProfit = fractionalKnapsack(weight,profit,sortedIndices, capacity);

        System.out.println(finalProfit);
    }

    private static float fractionalKnapsack(int[] weight, int[] profit, int[] sortedIndices, int capacity) {

        float p = 0;
        int i = 0;

        for(i = 0; i < sortedIndices.length; i++)
        {
            if(capacity > 0 && weight[sortedIndices[i]] <= capacity)
            {
                p = p + profit[sortedIndices[i]];
                capacity = capacity - weight[sortedIndices[i]];
            }
            else
            {
                break;
            }
        }

        if(capacity > 0 && i < sortedIndices.length)
        {
            p = p + ((float)(capacity)/weight[sortedIndices[i]])*profit[sortedIndices[i]];
        }

        return p;
    }

    private static int[] sortWithIndices(Float[] ratio) {

        HashMap<Float,Integer> map = new HashMap<>();

        for(int i = 0; i < ratio.length; i++)
        {
            map.put(ratio[i],i);
        }

        Arrays.sort(ratio, Collections.reverseOrder());

        int [] sortedIndices = new int[ratio.length];
        for(int i = 0; i < ratio.length; i++)
        {
            sortedIndices[i] = map.get(ratio[i]);
        }

        return sortedIndices;
    }
}
