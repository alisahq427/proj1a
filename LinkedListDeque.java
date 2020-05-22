public class LinkedListDeque<object> {
    private Node sentinel;
    private int size;
        private class Node{
            private Node prev;
            private object item;
            private Node next;
            private Node(object i,Node n,Node p){
                item = i;
                next = n;
                prev = p;
            }
            private Node(){}
            private object getRecursive(int index){
                if (index == 0){
                    return this.item;
                }
                return this.next.getRecursive(index-1);
            }
        }
    public LinkedListDeque(){
            sentinel = new Node();
            sentinel.prev = sentinel;
            sentinel.next = sentinel;
            size = 0;
    }
    public void addFirst(object T){
            sentinel.next =  new Node(T,sentinel.next,sentinel);
            size = size + 1;
    }
    public void addLast(object T){
            sentinel.prev = new Node(T,sentinel,sentinel.prev);
            size = size + 1;
    }
    public boolean isEmpty(){
            if (sentinel.next == sentinel){
                return true;
            }
            else{
                return false;
            }
    }
    public int size(){
            return size;
    }
    public void printDeque(){
        Node L = sentinel.next;
        int i = 0;
        while (i < size) {
            System.out.print(L.item);
            System.out.print(" ");
            L = L.next;
            i = i + 1;
        }
    }
    public object removeLast(){
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            if(isEmpty()){
                return null;
            }
            return sentinel.prev.item;
        }
    public object removeFirst(){
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            if(isEmpty()){
                return null;
            }
            return sentinel.next.item;
    }
    public object get(int index){
            Node L = sentinel.next;
            while (index < size){
            L = L.next;
            index = index + 1;
        }
            return L.item;
    }

    public object getRecursive(int index) {
            object thing = sentinel.next.getRecursive(index);
            return thing;
    }

}
