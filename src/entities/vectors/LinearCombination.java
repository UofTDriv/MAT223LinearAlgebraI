package entities.vectors;

public class LinearCombination extends Vector {
    Vector[] vectors;
    Scalar[] coefficients;

    public LinearCombination(Vector[] vector, Scalar[] coefficients) {
        assert vector.length == coefficients.length;
        this.vectors = vector;
        this.coefficients = coefficients;
        Vector temp = new Vector(vector[0].dimension);
        for (int i = 0; i < this.vectors.length; i++) {
            temp.add(coefficients[i].multiply(vectors[i]));
        }
        this.components = temp.components;
        this.dimension = temp.dimension;
    }

    public LinearCombination(Vector[] vectors) {
        this(vectors, new Scalar[vectors.length]);
    }


    public LinearCombination() {
    }
}
