package lection08AnnotationGenerics;

import lection08AnnotationGenerics.analyzer.ClassAnalyzer;
import lection08AnnotationGenerics.annotation.TransactionAnalyzer;
import lection08AnnotationGenerics.calculator.Calculator;
import lection08AnnotationGenerics.pair.Pair;
import lection08AnnotationGenerics.pair.PairUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Peir");
        Pair<Integer, String> pair = new Pair<>(5, "value");
        System.out.println(pair.getK() + " " + pair.getV());
        System.out.println(PairUtil.swap(pair).getK() + " " + PairUtil.swap(pair).getV());

        System.out.println("calculator");
        Calculator<Double> calculator = new Calculator<>();
        System.out.println(calculator.amount(1.2, 25.0));

        Calculator<Integer> calculator1 = new Calculator<>();
        System.out.println(calculator1.amount(1, 25));

        System.out.println("");
        TransactionAnalyzer.analyzerTransaction(new Calculator<Integer>());
        System.out.println("");
        ClassAnalyzer.analyze(new Calculator<>());
    }
}
