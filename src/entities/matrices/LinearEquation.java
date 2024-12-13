package entities.matrices;

public class LinearEquation {
    double[] coefficients;
    double[] variables;
    double constant;

    public LinearEquation(double[] coefficients, double constant) {
        this.coefficients = coefficients;
        this.constant = constant;
        this.variables = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++) {
            this.variables[i] = 1;
        }
    }

    public boolean isSolution(double[] tuple) {
        if (tuple.length != variables.length) {
            return false;
        }
        double sum = 0;
        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * tuple[i];
        }
        return sum == constant;
    }
}
