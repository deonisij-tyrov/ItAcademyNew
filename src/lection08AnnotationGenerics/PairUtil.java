package lection08AnnotationGenerics;

public final class PairUtil {
    static <V, K> Pair<V, K> swap(Pair<K, V> pair) {
        Pair<V, K> newPair = new Pair<>(pair.getV(), pair.getK());
        return newPair;
    }
}
