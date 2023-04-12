package org.lrdz.FunctionalInterface;

@FunctionalInterface
public interface IMath {

    Double excecute(Double a, Double b);

    default Double sum(Double a, Double b) { return  a + b; }
}
