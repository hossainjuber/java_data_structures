package linked_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public static class Key_Value{
        Key_Value(String k, Integer v){
            this.key = k;
            this.value = v;
        }
        String key;
        Integer value;
	}

    int maxSize;
	Map<String, Integer> cache = new HashMap<>();
	List<Key_Value> list = new ArrayList<>();

    public LRUCache(int maxSize) {
      this.maxSize = maxSize > 1 ? maxSize : 1;
    }

    public void insertKeyValuePair(String key, int value) {
      /* 1. check to see if max capacity has been reached
         2. if max capacity is reached then, delete the bottom elemen int the list
            and delete that same element from the map
         3. else add the element int the map and add the element at the top of the
            list.
       */
    if(list.size()==maxSize){
        list.remove(0);
    }

    list.add(new Key_Value(key, value));
    cache.put(key, list.size()-1);
    }

    public LRUResult getValueFromKey(String key) {
      /* 1. get value from the map using the key
		 2. update the list
	  */
      Key_Value k_v = list.get(cache.get(key));
      list.remove(Integer.valueOf(k_v.value));
      list.add(k_v);
      LRUResult  result = new LRUResult(true, k_v.value);

      return result;
    }

    public String getMostRecentKey() {
      /* 1. get the head of the list

      */
      Key_Value k_v = list.get(list.size()-1);
      return k_v.key;
    }




  static class LRUResult {
    boolean found;
    int value;

    public LRUResult(boolean found, int value) {
      this.found = found;
      this.value = value;
    }
  }//LRUResult


  }

