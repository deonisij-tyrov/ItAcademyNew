package lection08AnnotationGenerics;

import lection06.Zombie;
import lection08AnnotationGenerics.annotation.TransactionAnalyzer;
import lection08AnnotationGenerics.calculator.Calculator;

public class Main {
    public static void main(String[] args) {
//        Pair<Integer, String> pair = new Pair<>(5, "value");
//        System.out.println(pair.getK() + " " + pair.getV());
//        System.out.println(PairUtil.swap(pair).getK() + " " + PairUtil.swap(pair).getV());
//
//        Calculator<Double> calculator = new Calculator<>();
//        System.out.println(calculator.amount(1.2, 25.0));
//
//        Calculator<Integer> calculator1 = new Calculator<>();
//        System.out.println(calculator1.amount(1, 25));
//
//        TransactionAnalyzer.analyzerTransaction(new Calculator<Integer>());

        ClassAnalyzer.analyze(new Calculator<>());
    }
}
