package entities.matrices;

public class IdentityMatrix extends Matrix {
    public IdentityMatrix(int size) {
        super();
        this.entries = new double[size][size];
        for (int i = 0; i < size; i++) {
            entries[i][i] = 1;
        }
        this.rows = size;
        this.columns = size;
    }
}
