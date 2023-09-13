/* lesson here is that stack operation is preferred time complexity of O(1)
but I did it in time complexity of O(n)
what i should do is to push () and pop() and the beginning of the list ie head or the top
 */


public class StackLL {
    Node top;
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
   void push(int x){
        Node newNode = new Node(x);
            System.out.println("pushing "+x);
            newNode.next = top;
            top = newNode;
            System.out.println("current top "+top.data);
        }

   void pop(){
       System.out.println("popping "+top.data);
        top = top.next;

   }
   void peek(){
       System.out.println("peeking "+top.data);
       System.out.println(top.data);
   }
   void display(){
        Node temp = top;
       while (temp != null) {
           System.out.print(temp.data);
           temp = temp.next;
       }
   }

    public static void main(String[] args) {
        StackLL s = new StackLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        s.pop();
        s.peek();
        s.push(5);
        s.display();
    }

}
class StackArray{
    static final int MAX = 1000;
    int[] arr = new int[MAX];
    int top;
    StackArray(){
        top =-1;
    }
    void push(int x){
        if(top > MAX ){
            System.out.println("Stack Overflow");
        }
        arr[++top] = x;
        System.out.println("pushed "+x);
    }
    void pop(){
        if(top < 0){
            System.out.println("Stack Underflow");
        }
        System.out.println("poped :"+arr[top]);
        top--;
    }
    void peek(){
        System.out.println("peek:"+arr[top]);
    }
    void display(){
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        StackArray sa = new StackArray();
        sa.push(1);
        sa.push(2);
        sa.push(3);
        sa.push(4);
        sa.pop();
        sa.pop();
        sa.push(5);
        sa.display();
    }
}
