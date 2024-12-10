package Vectors.entity;

public class Vector {
    public double[] data;
    public int dimension;

    public Vector(double[] data) {
        this.data = data;
        this.dimension = data.length;
    }

    public Vector() {
    }

    public Vector add(Vector other) {
        if (this.dimension != other.dimension) {
            throw new IllegalArgumentException("Vectors must have the same dimensions");
        }
        double[] resultData = new double[this.dimension];
        for (int i = 0; i < this.dimension; i++) {
            resultData[i] = this.data[i] + other.data[i];
        }
        return new Vector(resultData);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < data.length-1; i++) {
            double d = data[i];
            result += d + " \\\\ ";
        }
        result += data[data.length-1];
        return "\\begin{pmatrix} " + result + " \\end{pmatrix}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            Vector other = (Vector) obj;
            if (this.dimension != other.dimension) {
                return false;
            }
            for (int i = 0; i < this.dimension; i++) {
                if (this.data[i] != other.data[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
