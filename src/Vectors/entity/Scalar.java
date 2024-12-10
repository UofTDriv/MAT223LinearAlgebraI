package Vectors.entity;

public class Scalar {
    public double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar() {
        this.value = 1;
    }

    public Scalar multiply(Scalar other) {
        return new Scalar(this.value * other.value);
    }

    public Vector multiply(Vector vector) {
        double[] resultData = new double[vector.dimension];
        for (int i = 0; i < vector.dimension; i++) {
            resultData[i] = this.value * vector.data[i];
        }
        return new Vector(resultData);
    }

}
