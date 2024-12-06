/**
 * @author Joao Neves (61899) jfr.neves@campus.fct.unl.pt
 * @author Felipe Magno  (67994) f.magno@campus.fct.unl.pt
 */

package dataStructures;

import java.io.Serializable;

/**
 * Interface representing a key-value pair entry in a map.
 * It defines methods to retrieve the key and the value of the entry.
 *
 * @param <K> The type of the key in the entry.
 * @param <V> The type of the value in the entry.
 */
public interface Entry<K, V> extends Serializable {

    /**
     * Returns the key in the entry.
     *
     * @return The key of type K.
     */
    K getKey();

    /**
     * Returns the value in the entry.
     *
     * @return The value of type V.
     */
    V getValue();
}
