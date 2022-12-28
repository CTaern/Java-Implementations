public class DoublyLinkedList<T extends Comparable> {
    private DNode<T> head;

    public DNode<T> createNode(T val){
        return new DNode<>(val);
    }
    public void addToFront(T val){

        DNode<T> temp=createNode(val);
        temp.next=head;
        if(head!=null) head.prev=temp;
        head=temp;
    }

    public void selectionSort(){

        DNode<T> headStart=head;
        while(headStart!=null) {
            DNode<T> minNode = findMinNode(headStart);
            T temp = minNode.value;
            minNode.value = headStart.value;
            headStart.value = temp;
            headStart=headStart.next;
        }
    }


    public DNode<T> findMinNode(DNode<T> headStart){
        if(headStart!=null) {
            DNode<T> iterator = headStart;
            DNode<T> minNode=headStart;
            while (iterator!=null){
                if(iterator.value.compareTo(minNode.value)==-1){
                    minNode=iterator;
                }
                iterator=iterator.next;
            }
            return minNode;
        }
        return null;

    }

    public void display(){
        DNode<T> iterator=head;
        if(iterator!=null)
            while(head!=null && iterator.next!=head){
                System.out.println(iterator.value);
                iterator=iterator.next;
        }
        if(head!=null)
            System.out.println(iterator.value);
    }

    public void addToEnd(T val){
        DNode<T> iterator=head;
        if(head==null){
            head=createNode(val);
        }else{
            while (iterator.next != null){
                iterator = iterator.next;
            }
            iterator.next=createNode(val);
           iterator.next.prev=iterator;
        }
    }
    public void deleteFromFront(){
        if(head!=null){
            if(head.next==null)
                head=null;
            else{
                head=head.next;
                head.prev=null;
            }
        }
    }
    public void addAfterHead(T val){
        DNode<T> temp = createNode(val);
        if(head==null)
            head=temp;
        else{
            temp.next=head.next;
            if(head.next!=null) temp.next.prev=temp;
            temp.prev=head;
            head.next=temp;
        }
    }

}
