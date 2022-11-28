package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

class huffmanNode
{
    int data;
    char c;

    huffmanNode left;
    huffmanNode right;

}

class MyComparator implements Comparator<huffmanNode>
{

    @Override
    public int compare(huffmanNode x, huffmanNode y) {
        return x.data - y.data;
    }
}

public class huffman
{
    public static void main(String[] args) {

        int n = 7;

        int [] charFreq = {4,7,12,14,17,43,52};

        char [] charArr = {'a','b','c','d','e','f','g'};

        huffmanTree(charFreq,charArr,n);
    }

    private static void huffmanTree(int[] charFreq, char[] charArr, int size) {

        PriorityQueue<huffmanNode> queue = new PriorityQueue<>(size,new MyComparator());

        for(int i = 0; i < charArr.length; i++)
        {
            huffmanNode newn = new huffmanNode();

            newn.data = charFreq[i];
            newn.c =charArr[i];

            newn.left = null;
            newn.right = null;

            queue.add(newn);
        }

        huffmanNode root = null;


        while(queue.size() > 1)
        {
            huffmanNode left = queue.poll();
            huffmanNode right = queue.poll();

            huffmanNode f = new huffmanNode();

            f.data = left.data + right.data;
            f.c = '-';

            f.left = left;
            f.right = right;

            root = f;

            queue.add(f);
        }

        printTree(root,"");
    }

    private static void printTree(huffmanNode root, String code) {

        if(root.left == null && root.right == null && Character.isLetter(root.c))
        {
            System.out.println(root.c + " : "+ code);
            return;
        }

        printTree(root.left,code+0);
        printTree(root.right,code+1);
    }
}