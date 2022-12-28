public class StackOperations {
    public static boolean search(stack s, int val){
        stack temp = new stack(s.size());
        boolean found=false;
        while(!s.isEmpty()){
            int topElement=s.pop();
            temp.push(topElement);
            if(topElement==val) {
                found = true;
                break;
            }
        }
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }

        return found;
    }

}
