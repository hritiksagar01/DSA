import java.util.Scanner;

class Linkedlist {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    void addend(int data){
        Node newNode;
        if(head == null){
            head = new Node(data);}
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }
    void addfirst(int data){
        Node newNode;
        if(head == null)
            newNode = new Node(data);

        newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    void addmiddle (int find,int data){
        Node newNode = new Node(data);
        Node temp = head;
        while(temp.data != find){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void search(int find){
        Node temp = head;
        while(temp != null){
            if(temp.data == find){
                System.out.println("FOUND");
                break;
            }
            temp = temp.next;
        }
        if(temp == null)
            System.out.println("Not found");
    }

    void lengthOfLinkedlist(){
        int c =0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        System.out.println(c);
    }

    void reverse(){
        Node current = head,prev =null,next;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    Node reverse(Node head)              // using recursion
    {
        if (head == null || head.next == null)
            return head;

        /* reverse the rest list and put
        the first element at the end */
        Node rest = reverse(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

    void delete_from_beginning(){
        if(head.next!= null){
            head = head.next;
        }
        else
            head = null;

    }
    void delete_from_end(){
        Node temp = head;
        while(temp.next.next !=null){
            temp = temp.next;
        }
        temp.next = null;
    }
    void delete_from_middle(int find){
        Node temp =head;
        while(temp.next.data!= find){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    int numberofelement(){
        int c=0;
        Node temp = head;
        while(temp !=null ){
            temp = temp.next;
            c++;
        }
        return c;
    }

    void nthNodefromLast(int find){                            // naive method
        int element = (numberofelement() - find +1);
        Node temp = head;
        int c =1;
        while (c!= element){
            temp = temp.next;
            c++;
        }
        System.out.println(temp.data);
    }

    void nth_element_using_recursion(Node head,int n1){
        int c= 0;
        if(head == null)
            return;
        nth_element_using_recursion(head.next,n1);
        if(++c == n1)
            System.out.println(head.data);
    }
    void printmiddleelement(){
        Node temp = head, slow = head , fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }

    void occurance(int n){
        Node temp = head;
        int c=0;
        while( temp != null){
            if(temp.data == n)
                c++;
            temp = temp.next;
        }
        System.out.println(c);
    }
    void moveElementTofirst(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next.next = head;
        head = temp.next;
        temp.next = null;

    }
    void temp(){
        Node temp = head;
        while(temp != null){
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    void temp_next(){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    void temp_next_next(){
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    void middle_as_head_savedata(){                        // did not understand about prev pointer but later it clicked
        Node slow = head, fast = head,prev = null;
        while((fast != null) && (fast.next != null) ){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;

        }
        int c = slow.data;
        Node newNode = new Node(c);
        newNode.next = head;
        head = newNode;
        prev.next =slow.next;

    }
    void delete_alternative_elements(){            // cant do recursively HELP !!!!!!!!!!!!!!!!!!!
        Node temp = head;
        while(temp.next!= null){
            temp.next = temp.next.next;
            temp =temp.next;
        }
    }

    void add1tothelist(){
        Node temp = head;
        int s=0;
        while(temp != null){
            s= s*10 + temp.data;
            temp = temp.next;
        }
        int newnum=s+1;
        reverse();
        temp = head;
        while(temp != null && newnum != 0){
            int rem = newnum%10;
            temp.data = rem;
            temp =temp.next;
            newnum /=10;
        }
        reverse();
    }

    void pairwiseswap(){
        Node temp =head;
        while (temp != null && temp.next != null){
            int v = temp.data;
            temp.data = temp.next.data;
            temp.next.data =v;
            temp = temp.next.next;
        }
    }
    void pairwiseswapbychanginglink() {
        Node prev = null, curr = head;
        while (curr != null) {

        }
    }
    boolean detect_loop_in_linkedlist(){
        Node slow = head,fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
    void palindrome(){
        boolean flag = true;
        Node slow = head, fast = head , prev = null,next, curr;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        curr = prev;
        while( curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        while(head != prev ) {
            if (head.data != prev.data) {
                flag = false;
            }
            head = head.next;
            prev = prev.next;
        }
        System.out.println(flag);
    }

    void segregateEvenOdd()
    {
        Node end = head;
        Node prev = null;
        Node curr = head;

        /* Get pointer to last Node */
        while (end.next != null)
            end = end.next;

        Node new_end = end;

        // Consider all odd nodes before getting first even
        // node
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        // do following steps only if there is an even node
        if (curr.data % 2 == 0) {
            head = curr;

            // now curr points to first even node
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                }
                else {
                    /* Break the link between prev and
                     * curr*/
                    prev.next = curr.next;

                    /* Make next of curr as null */
                    curr.next = null;

                    /*Move curr to end */
                    new_end.next = curr;

                    /*Make curr as new end of list */
                    new_end = curr;

                    /*Update curr pointer */
                    curr = prev.next;
                }
            }
        }

        /* We have to set prev before executing rest of this
         * code */
        else
            prev = curr;

        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    _______________________________________________
                    Enter 1 to add elements to the end of the list 
                    Enter 2 to add elements to the first  of the list
                    Enter 3 to add in the middle of the list
                    Enter 4 to search in the list
                    Enter 5 to display.
                    Enter 6 to find the length of the linkedlist
                    Enter 7 to reverse the linkedlist by interation
                    Enter 8 to reverse the linkedlist by recursion
                    Enter 9 to delete an element from the beginning 
                    Enter 10 to delete an element form the end
                    Enter any alphabet to end
                                                   
                    ________________________________________________
                     """);
            switch (sc.nextInt()) {
                case 1 -> {
                    try {
                        while (true) {
                            System.out.println("Enter number");
                            addend(sc.nextInt());
                        }
                    } catch (Exception e) {
                        sc.nextLine();
                        break;
                    }
                }
                case 2 -> {
                    try {
                        while (true) {
                            System.out.println("Enter number");
                            addfirst(sc.nextInt());
                        }
                    } catch (Exception e) {
                        sc.nextLine();
                        break;
                    }
                }
                case 3 -> addmiddle(sc.nextInt(), sc.nextInt());
                case 4 -> search(sc.nextInt());
                case 5 -> display(head);
                case 6 -> lengthOfLinkedlist();
                case 7 -> reverse();
                case 8 -> display(reverse(head));
                case 9 -> delete_from_beginning();
                case 10 -> delete_from_end();
                case 11 -> delete_from_middle(sc.nextInt());
                case 12 -> nthNodefromLast(sc.nextInt());
                case 13 -> nth_element_using_recursion( head,sc.nextInt());
                case 14 -> printmiddleelement();
                case 15 -> occurance(sc.nextInt());
                case 16 -> moveElementTofirst();
                case 17 -> middle_as_head_savedata();
                case 18 -> delete_alternative_elements();
                case 19 -> add1tothelist();
                case 20 -> pairwiseswap();
                case 21 -> detect_loop_in_linkedlist();
                case 22 -> palindrome();
                case 23 ->segregateEvenOdd();
            }
        }
    }
    public static void main(String[] args) {
        Linkedlist l = new Linkedlist();
        Linkedlist l2  = new Linkedlist();
        l.input();
    }
}