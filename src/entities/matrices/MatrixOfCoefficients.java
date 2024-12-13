package entities.matrices;

public class MatrixOfCoefficients extends Matrix {
    public MatrixOfCoefficients(SystemLinearEquations system) {
        super();
        this.entries = new double[system.equations.length][system.equations[0].coefficients.length];
        this.rows = system.equations.length;
        this.columns = system.equations[0].coefficients.length;
        for (int i = 0; i < system.equations.length; i++) {
            entries[i] = system.equations[i].coefficients;
        }
    }
}
