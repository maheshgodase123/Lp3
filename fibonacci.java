package practice;

// 0 1 1 2 3 5 8 13
public class fibonacci
{

    public static void main(String[] args) {

        int n = 5;

        System.out.println(recursiveFibo(n));
        nonRecursiveFibo(n-1);
    }

    private static void nonRecursiveFibo(int n) {

        int a = 0;
        int b = 1;
        int c = 0;

        System.out.print(a + " " + b + " ");
        while(n > 0)
        {
            c = a + b;

            a = b;
            b = c;

            System.out.print(c + " ");
            n--;
        }
    }

    private static int recursiveFibo(int n) {

        if(n == 0 || n == 1)
        {
            return n;
        }

        return recursiveFibo(n-2) + recursiveFibo(n-1);
    }

}
