package dataStructures;

import java.util.HashMap;
import java.util.Map;

public class BiMap<K, V> {
    private final Map<K, V> keyToValue = new HashMap<>();
    private final Map<V, K> valueToKey = new HashMap<>();

    // Add a key-value pair
    public void put(K key, V value) {
        if (keyToValue.containsKey(key)) {
            V oldValue = keyToValue.get(key);
            valueToKey.remove(oldValue); // Remove the old value-to-key mapping
        }
        if (valueToKey.containsKey(value)) {
            K oldKey = valueToKey.get(value);
            keyToValue.remove(oldKey); // Remove the old key-to-value mapping
        }
        keyToValue.put(key, value);
        valueToKey.put(value, key);
    }

    // Static method to create a BiMap from entries
    @SafeVarargs
    public static <K, V> BiMap<K, V> ofEntries(Map.Entry<K, V>... entries) {
        BiMap<K, V> biMap = new BiMap<>();
        for (Map.Entry<K, V> entry : entries) {
            biMap.put(entry.getKey(), entry.getValue());
        }
        return biMap;
    }

    // Get the value for a given key
    public V getValue(K key) {
        return keyToValue.get(key);
    }

    // Get the key for a given value
    public K getKey(V value) {
        return valueToKey.get(value);
    }

    // Utility method to create an entry (helper for ofEntries)
    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new HashMap.SimpleEntry<>(key, value);
    }
}
