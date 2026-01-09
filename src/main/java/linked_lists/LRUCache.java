public class LRUCache {


	 public static void main(String[] str) {
        LRUCache lru = new LRUCache(3);
        lru.insertKeyValuePair("b", 2);
        lru.insertKeyValuePair("a", 1);
        lru.insertKeyValuePair("c", 3);
        String key = lru.getMostRecentKey();
        LRUResult result = lru.getValueFromKey("a");
        key = lru.getMostRecentKey();
        lru.insertKeyValuePair("d", 4);
        result = lru.getValueFromKey("b");
        lru.insertKeyValuePair("a", 5);
        result = lru.getValueFromKey("a");

    }//main


  static class LRUCache {
    int maxSize;
    Map<String, Node> map;
    Node head = new Node();
    Node tail = new Node();

    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
      map = new HashMap<>(maxSize);
      head.next = tail;
      tail.prev = head;
    }

    public void insertKeyValuePair(String key, int value) {
      //check map to see if it exists
      //if in map then then it must be in list, update list (remove add)
      Node node = map.get(key);
      if(node!=null){
        node.value = value;
        remove(node);        
        add(node);
      }else{
        //not in map, not in list then 
        //first check to see if we have reached our cap, if yes then increase it
        if(map.size()==maxSize){
          map.remove(tail.prev.key);
          remove(tail.prev);
        }
        //create a new node and add in map list
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        add(newNode);
      }
    }

    public LRUResult getValueFromKey(String key) {
      Node node = map.get(key);
      if(node!=null){
        LRUResult result = new LRUResult(true, node.value);
        remove(node);
        add(node);
        return result;
      }
      return null;
    }

    public String getMostRecentKey() {
      return head.next.key;
    }

    private void remove(Node node){
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private void add(Node node){
      node.next = head.next;
      head.next.prev = node;

      head.next = node;
      node.prev = head;
    }
  }

  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }

  static class Node{
    String key;
    int value;
    Node next;
    Node prev;

    public Node(){}

    public Node(String key, int value){
      this.key = key;
      this.value = value;
    }
    
  }
}
