//双向链表
class MyCircularDeque {

    private int size;
    private int capacity;
    private Entry head;
    private Entry tail;

    class Entry{
        public Entry(int val){
            this.val=val;
        }
        int val;
        Entry prev;
        Entry next;
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size=0;
        capacity=k;
        head=new Entry(-1);
        tail=new Entry(-1);
        head.next=tail;
        tail.prev=head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size==capacity) return false;
        Entry entry=new Entry(value);
        Entry first=head.next;
        head.next=entry;
        first.prev=entry;
        entry.prev=head;
        entry.next=first;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size==capacity) return false;
        Entry entry=new Entry(value);
        Entry last=tail.prev;
        last.next=entry;
        tail.prev=entry;
        entry.next=tail;
        entry.prev=last;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size==0) return false;
        Entry first=head.next;
        Entry second=first.next;
        head.next=second;
        second.prev=head;
        first=null;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size==0) return false;
        Entry last=tail.prev;
        Entry second=last.prev;
        tail.prev=second;
        second.next=tail;
        last=null;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size==0) return -1;
        return head.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size==0) return -1;
        return tail.prev.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==capacity;
    }
}