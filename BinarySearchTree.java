public class BinarySearchTree <T extends Comparable>{

    private TNode<T> root;

    public void insert(T val){
        TNode<T> newNode=new TNode<>(val);
        if(root==null){
            root=newNode;
        }else{
            TNode<T> iterator=root;
            while (iterator!=null){
                if(val.compareTo(iterator.value)==-1){

                }else{}
            }
        }
    }
}
