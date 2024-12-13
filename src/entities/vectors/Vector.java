package entities.vectors;

public class Vector {
    public double[] components;
    public int dimension;

    public Vector(double[] components) {
        this.components = components;
        this.dimension = components.length;
    }

    public Vector(int dimension) {
        this.components = new double[dimension];
        this.dimension = dimension;
    }

    public Vector() {
    }

    public Vector add(Vector other) {
        if (this.dimension != other.dimension) {
            throw new IllegalArgumentException("Vectors must have the same dimensions");
        }
        double[] resultData = new double[this.dimension];
        for (int i = 0; i < this.dimension; i++) {
            resultData[i] = this.components[i] + other.components[i];
        }
        this.components = resultData;
        return this;
    }

    public double dotProduct(Vector other) {
        if (this.size() != other.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimension for dot product.");
        }
        double result = 0;
        for (int i = 0; i < this.size(); i++) {
            result += this.components[i] * other.components[i];
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < components.length-1; i++) {
            double d = components[i];
            result += d + " \\\\ ";
        }
        result += components[components.length-1];
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
                if (this.components[i] != other.components[i]) {
                    return false;
                }
            }
            return true;
        }
        else if (obj instanceof double[]) {
            return obj.equals(this.components);
        }
        return false;
    }

    public int size() {
        return dimension;
    }

    public double get(int j) {
        return components[j];
    }
}
