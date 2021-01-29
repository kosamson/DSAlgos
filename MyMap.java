/* Custom implementation of the Map interface using a linked-node structure. Performs most operations in O(n) time complexity. */

public class MyMap<T1, T2> {
    private MapNode<T1, T2> head;

    public MyMap() {
        this.head = null;
    }

    public void put(T1 inpKey, T2 inpVal) {
        if (head == null)
            head = new MapNode<T1, T2>(inpKey, inpVal);
        
        else {
            MapNode<T1, T2> iter = head;

            while (iter.next != null) {
                if (iter.key == inpKey) {
                    iter.value = inpVal;
                    return;
                }

                iter = iter.next;
            }

            iter.next = new MapNode<T1, T2>(inpKey, inpVal);
        }
    }

    public void remove(T1 inpKey) {
        if (head == null)
            return;

        if (head.key == inpKey) {
            head = null;
            return;
        }

        MapNode<T1, T2> iter = head;

        while (iter.next != null) {
            if (iter.next.key == inpKey) {
                iter.next = iter.next.next;
                return;
            }
            
            iter = iter.next;
        }
    }

    public T2 get(T1 inpKey) {
        MapNode<T1, T2> iter = head;

        while (iter != null) {
            if (iter.key == inpKey)
                return iter.value;

            iter = iter.next;
        }

        return null;
    }
    
    private class MapNode<T1, T2> {
        public MapNode next;
        public T1 key;
        public T2 value;

        public MapNode() {
            this.next = null;
            this.key = null;
            this.value = null;
        }

        public MapNode(T1 inpKey, T2 inpVal) {
            this.next = null;
            this.key = inpKey;
            this.value = inpVal;
        }
    }
}