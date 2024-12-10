package Vectors.entity;

public class LinearCombination extends Vector {
    Vector[] vectors;
    Scalar[] coefficients;

    public LinearCombination(Vector[] vector, Scalar[] coefficients) {
        assert vector.length == coefficients.length;
        this.vectors = vector;
        this.coefficients = coefficients;
        double[] resultData = new double[vector[0].dimension];
        for (int i = 0; i < this.vectors.length; i++) {
            for (int j = 0; j < this.vectors[i].dimension; j++) {
                resultData[j] += this.vectors[i].data[j] * this.coefficients[i].value;
            }
        }
        this.data = resultData;
        this.dimension = resultData.length;
    }


}
