public class Node <S extends Comparable>{
    public S value;
    public Node<S> next;
    public Node<S> previous;



    public Node(S val){
        this.value=val;
        this.next=null;
        this.previous=null;
    }

    public String toString(){
        return this.value.toString();
    }
}
