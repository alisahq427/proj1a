public class ArrayDeque<alisa> {
    private alisa[] items;
    private int size;
    // [1,2,3,4,0,0,0] size = 4; add first: add first to index zero and move others back one
    public ArrayDeque(){
        items = (alisa[]) new Object[8];
        size = 0;
    }
    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        alisa[] a = (alisa[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    public void addFirst(alisa item){
            items[0] = item;
            size = size + 1;
        if (size == items.length) {
            resize(size + 1);
        }
    }
    public void addLast(alisa item){
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = item;
        size = size + 1;
    }
    public boolean isEmpty(){
        if (size == 0) {
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
        int i = 0;
        while (i < size - 1){
            System.out.print(items[i] + " ");
        }
    }
    public alisa removeFirst(){
        items[0] = null;
        size = size - 1;
        return items[1];
    }
    public alisa removeLast(){
        items[size-1] = null;
        size = size - 1;
        return items[size - 1];
    }
    public alisa get(int index){
        return items[index];
    }
}
