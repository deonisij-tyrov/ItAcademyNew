package lection08AnnotationGenerics;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("as", 1);
        System.out.println(pair.getK() + " " + pair.getV());
        Pair<Integer, String> newPair = PairUtil.swap(pair);
        System.out.println(newPair.getK() + " " + newPair.getV());
    }
}
