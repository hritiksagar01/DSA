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

