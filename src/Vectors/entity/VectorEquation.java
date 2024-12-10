package Vectors.entity;

public class VectorEquation extends LinearCombination {

    public VectorEquation(Vector[] vectors, Scalar[] coefficients, Vector constants) {
        super(vectors, coefficients);
        AugmentedMatrix matrix = new AugmentedMatrix(vectors, constants);

        assert matrix.toReducedRowEchelonForm().countPivotColumns() <= matrix.columns - 1;
    }
}
