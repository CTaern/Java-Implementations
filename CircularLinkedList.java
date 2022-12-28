public class CircularLinkedList<T extends Comparable>{
    private Node<T> head;

    public Node<T> createNode(T val){
        return new Node<T>(val);
    }

    public void addToFront(T val){
        Node<T> temp = new Node(val);
        if(head==null){
            head=temp;
            head.next=head;
        }else{
            temp.next=head;
            //head=temp;
            Node<T> iterator=head;
            while (iterator.next!=head){
                iterator=iterator.next;
            }
            head=temp;
            iterator.next=head;

        }
    }
    public void display(){
        Node<T> iterator=head;
        while(head!=null && iterator.next!=head){
            System.out.println(iterator.value);
            iterator=iterator.next;
        }
        if(head!=null)
            System.out.println(iterator.value);
    }
}
