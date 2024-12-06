/**
 * @author Joao Neves (61899) jfr.neves@campus.fct.unl.pt
 * @author Felipe Magno  (67994) f.magno@campus.fct.unl.pt
 */
package dataStructures;

public class EntryClass<K,V> implements Entry<K,V> {
    /**
      * Serial Version UID of the Class
     */
    static final long serialVersionUID = 0L;

    private final K key;
    private final V value;

    public EntryClass(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}

