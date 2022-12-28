public class Test {

    public static void main(String[] args){
        //LinkedList<Integer> myList = new LinkedList<>();
        //CircularLinkedList<Integer> myList= new CircularLinkedList<>();
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
        myList.addToFront(10);
        myList.addToFront(11);
        myList.addToFront(12);
        myList.addToFront(13);

        myList.display();







        /*Queue<Integer> q1 = new Queue<>(Integer.class, 5);
        q1.enqueue(5);
        q1.enqueue(15);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.dequeue();
        q1.display();
        GenericStackOps<Integer> sops=new GenericStackOps<>();
        System.out.println(sops.isPalindrome("kapak"));
        q1.clear();
        q1.enqueue(31);
        q1.display();*/



        // GenericStack<Integer> gs = new GenericStack<>(Integer.class, 5);
        //GenericStack<Student> gs2 = new GenericStack<>(Student.class, 5);

        /*gs.push(5);
        gs.push(6);
        gs.push(2);
        gs.display();
        GenericStackOps<Integer> sops=new GenericStackOps<>();
        //System.out.println(sops.search(gs, 6));
        System.out.println(sops.FindMax(gs));*/

   /*     stack s = new stack(5);
        s.push(5);
        s.push(6);
        s.push(2);
        //s.pop();


        s.display();
        //System.out.println(StackOperations.search(s, 67));
        //s.display();
        System.out.println(s.maxnumber());*/


    }
}
