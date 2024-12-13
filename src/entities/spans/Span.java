package entities.spans;

import entities.vectors.LinearCombination;
import entities.vectors.Scalar;
import entities.vectors.Vector;

import java.util.List;

public class Span {
    public List<Vector> basisVectors;

    public Span(List<Vector> basisVectors) {
        this.basisVectors = basisVectors;
    }

    public LinearCombination spanSum(Scalar[] coefficients) {
        if (coefficients.length != basisVectors.size()) {
            throw new IllegalArgumentException("Number of coefficients must match the number of basis vectors.");
        }
        return new LinearCombination((Vector[]) basisVectors.toArray(), coefficients);
    }

}
