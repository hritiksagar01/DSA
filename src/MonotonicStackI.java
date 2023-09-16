import java.util.Scanner;

class MonotonicStack{
    public static void main(String[] args) {
        int c =0;
        int[] a = new int[100];
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("please enter a number");

            for (int i = 0; i < 100; i++) {
                System.out.println("now enter number ");
                a[i] = sc.nextInt();
                c++;
            }
        }
        catch (Exception e){

        };
        StackArray sa = new StackArray();
        for (int i = 0; i < c; i++) {
            if (sa.top == -1) {
                sa.push(a[i]);
            } else {
                while (sa.top != -1 && sa.peek() > a[i] ) {
                    sa.pop();
                }
                sa.push(a[i]);
            }
        }
        sa.display();
    }
}