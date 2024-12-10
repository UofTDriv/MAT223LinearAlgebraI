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
    
    public AugmentedMatrix(Vector[] vectors, Vector constants) {
        super();
        if (vectors.length == 0 || constants.size() != vectors[0].size()) {
            throw new IllegalArgumentException("Dimensions mismatch");
        }
        this.entries = new double[vectors[0].size()][vectors.length + 1];
        this.rows = vectors[0].size();
        this.columns = vectors.length + 1;

        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < rows; j++) {
                entries[j][i] = vectors[i].get(j);
            }
        }

        for (int j = 0; j < rows; j++) {
            entries[j][columns - 1] = constants.get(j);
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
