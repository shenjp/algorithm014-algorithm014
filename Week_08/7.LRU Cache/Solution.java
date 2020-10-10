class LRUCache {
    class Entry{
        int key;
        int value;
        Entry prev;
        Entry next;
        public Entry(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Entry> cache=new HashMap<>();
    Entry head;
    Entry tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Entry(-1,-1);
        tail=new Entry(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Entry cur=cache.get(key);
            moveToHead(cur);
            return cur.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Entry cur=cache.get(key);
            cur.value=value;
            moveToHead(cur);
        }else{
            if(cache.size()>=capacity){
                cache.remove(tail.prev.key);
                removeLast();
            }
            Entry cur=new Entry(key,value);
            addToHead(cur);
            cache.put(key,cur);
        }
    }

    private void addToHead(Entry cur){
        cur.prev=head;
        cur.next=head.next;
        head.next=cur;
        cur.next.prev=cur;
    }

    private void removeLast(){
        tail.prev.prev.next=tail;
        tail.prev=tail.prev.prev;
    }

    private void moveToHead(Entry cur){
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
        cur.prev=head;
        cur.next=head.next;
        head.next=cur;
        cur.next.prev=cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */