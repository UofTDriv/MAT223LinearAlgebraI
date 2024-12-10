package Vectors.entity;

public class AugmentedMatrix extends Matrix {
    public AugmentedMatrix(SystemLinearEquations system) {
        super();
        this.entries = new double[system.equations.length][system.equations[0].coefficients.length + 1];
        this.rows = system.equations.length;
        this.columns = system.equations[0].coefficients.length + 1;
        for (int i = 0; i < system.equations.length; i++) {
            System.arraycopy(system.equations[i].coefficients, 0, entries[i], 0,
                    system.equations[i].coefficients.length);
            entries[i][system.equations[i].coefficients.length] = system.equations[i].constant;
        }
    }

    public Vector getConstants() {
        double[] constants = new double[rows];
        for (int i = 0; i < rows; i++) {
            constants[i] = entries[i][columns - 1];
        }
        return new Vector(constants);
    }

}
