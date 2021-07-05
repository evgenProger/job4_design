package cashe;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCashe<K, V> {
    protected final Map<K, SoftReference<V>> cashe = new HashMap<>();

    public void put(K key, V value) {
        cashe.put(key, new SoftReference<V>(value));
    }

    public V get(K key) throws IOException {
        V value = cashe.get(key).get();
        if (value == null) {
            value = load(key);
        }
        return value;
    }

    protected abstract V load(K key) throws IOException;
}


