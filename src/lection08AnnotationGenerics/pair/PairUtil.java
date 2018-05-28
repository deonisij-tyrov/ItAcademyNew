package lection08AnnotationGenerics.pair;

public final class PairUtil {
    public static <K, V> Pair<V, K> swap(Pair<K, V> pair) {
        Pair<V, K> newPair = new Pair<>(pair.getV(), pair.getK());
        return newPair;
    }
}
