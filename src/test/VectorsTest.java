package test;

import Vectors.entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VectorsTest {
    @Test
    public void testVectorAddition() {
        Vector v1 = new Vector(new double[]{1, 2, 3});
        Vector v2 = new Vector(new double[]{4, 5, 6});
        Vector v3 = new Vector(new double[]{5, 7, 9});
        assertTrue(v3.equals(v1.add(v2)), "The vector addition result is incorrect");
    }

    @Test
    public void testLinearCombination() {
        Vector[] vectors = new Vector[2];
        Vector e1 = new Vector(new double[]{1, 0, 0});
        Vector e2 = new Vector(new double[]{0, 1, 0});
        Scalar a1 = new Scalar(1);
        Scalar a2 = new Scalar(1);
        vectors[0] = e1;
        vectors[1] = e2;
        Vector result = new LinearCombination(vectors, new Scalar[]{a1, a2});
        Vector e3 = new Vector(new double[]{1, 1, 0});
        assertTrue(result.equals(e3), "The linear combination result is incorrect");
    }

    @Test
    public void testMatrixOfCoefficients() {
        LinearEquation r1 = new LinearEquation(new double[]{1, -1, -1}, 1);
        LinearEquation r2 = new LinearEquation(new double[]{2, -3, -1}, 3);
        LinearEquation r3 = new LinearEquation(new double[]{-1, 1, -1}, -3);
        SystemLinearEquations system = new SystemLinearEquations(new LinearEquation[]{r1, r2, r3});
        MatrixOfCoefficients matrix = new MatrixOfCoefficients(system);
        double[][] expected = new double[][]{{1, -1, -1}, {2, -3, -1}, {-1, 1, -1}};
        assertTrue(matrix.equals(expected), "The matrix of coefficients is incorrect");
    }

    @Test
    public void testAugmentedMatrix() {
        LinearEquation r1 = new LinearEquation(new double[]{1, -1, -1}, 1);
        LinearEquation r2 = new LinearEquation(new double[]{2, -3, -1}, 3);
        LinearEquation r3 = new LinearEquation(new double[]{-1, 1, -1}, -3);
        SystemLinearEquations system = new SystemLinearEquations(new LinearEquation[]{r1, r2, r3});
        AugmentedMatrix matrix = new AugmentedMatrix(system);
        double[][] expected = new double[][]{{1, -1, -1, 1}, {2, -3, -1, 3}, {-1, 1, -1, -3}};
        assertTrue(matrix.equals(expected), "The augmented matrix is incorrect");
    }

    @Test
    public void testRREF() {
        Matrix nonReduced = new Matrix(new double[][]{{1, 1, 2, 1}, {1, 3, 6, 1}, {1, 2, 4, 1}});
        Matrix rref = nonReduced.toReducedRowEchelonForm();
        double[][] expected = new double[][]{{1, 0, 0, 1}, {0, 1, 2, 0}, {0, 0, 0, 0}};
        assertTrue(rref.equals(expected), "The reduced row echelon form is incorrect");
    }

    @Test
    public void testSolvingVectorEquations() {
        LinearEquation e1 = new LinearEquation(new double[]{3, 1}, 107);
        LinearEquation e2 = new LinearEquation(new double[]{1, 2}, 64);
        SystemLinearEquations system = new SystemLinearEquations(new LinearEquation[]{e1, e2});
        AugmentedMatrix matrix = new AugmentedMatrix(system);
        AugmentedMatrix rref = (AugmentedMatrix) matrix.toReducedRowEchelonForm();
        assertTrue(e1.isSolution(rref.getConstants().data), "The solution is incorrect");
    }

    @Test
    public void testNumberOfPivots() {
        IdentityMatrix identity = new IdentityMatrix(3);
        assertTrue(identity.countPivotColumns() == 3, "The number of pivots is incorrect");
        Matrix actual = new Matrix(new double[][]{{1, 0, 0, 1}, {0, 1, 2, 0}, {0, 0, 0, 0}});
        int actualPivots = actual.countPivotColumns();
        assertTrue(actualPivots == 2, "The number of pivots is incorrect");
    }
}
