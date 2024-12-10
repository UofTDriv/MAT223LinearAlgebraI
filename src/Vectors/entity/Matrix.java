package Vectors.entity;

public class Matrix {
    public double[][] entries;
    public int rows;
    public int columns;

    public Matrix(double[][] entries) {
        this.entries = entries;
        this.rows = entries.length;
        this.columns = entries[0].length;
    }

    public Matrix(Vector[] columns) {
        this.columns = columns.length;
        this.rows = columns[0].dimension;
        this.entries = new double[rows][columns.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns.length; j++) {
                this.entries[i][j] = columns[i].data[j];
            }
        }
    }

    public Matrix() {
    }

    public Matrix interchangeRows(int i, int j) {
        double[] temp = entries[i];
        entries[i] = entries[j];
        entries[j] = temp;
        return this;
    }
    
    public Matrix replaceRowWithScalarMultiple(int i, double scalar) {
        if (scalar != 0) {
            for (int j = 0; j < columns; j++) {
                entries[i][j] *= scalar;
            }
        }
        return this;
    }

    public Matrix rowAddition(int i, int j, double scalar) {
        if (i != j && scalar != 0) {
            for (int k = 0; k < columns; k++) {
                entries[i][k] += scalar * entries[j][k];
            }
        }
        return this;
    }

    public Matrix toReducedRowEchelonForm() {
        int lead = 0;
        for (int r = 0; r < rows; r++) {
            if (columns <= lead) {
                return this;
            }
            int i = r;
            while (entries[i][lead] == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (columns == lead) {
                        return this;
                    }
                }
            }
            interchangeRows(i, r);
            double lv = entries[r][lead];
            replaceRowWithScalarMultiple(r, 1 / lv);
            for (int k = 0; k < rows; k++) {
                if (k != r) {
                    rowAddition(k, r, -entries[k][lead]);
                }
            }
            lead++;
        }
        return this;
    }
    
    

    public Matrix toRowEchelonForm() {
        int lead = 0;
        for (int r = 0; r < rows; r++) {
            if (columns <= lead) {
                return this;
            }
            int i = r;
            while (entries[i][lead] == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (columns == lead) {
                        return this;
                    }
                }
            }
            interchangeRows(i, r);
            double lv = entries[r][lead];
            for (int j = 0; j < columns; j++) {
                entries[r][j] /= lv;
            }
            for (int k = 0; k < rows; k++) {
                if (k != r) {
                    lv = entries[k][lead];
                    for (int j = 0; j < columns; j++) {
                        entries[k][j] -= lv * entries[r][j];
                    }
                }
            }
            lead++;
        }
        return this;
    }

    public int countPivotColumns() {
        int pivotCount = 0;
        for (int j = 0; j < columns; j++) {
            boolean isPivot = false;
            boolean onlyOneNonZero = true;
            for (int i = 0; i < rows; i++) {
                if (entries[i][j] != 0) {
                    if (!isPivot && entries[i][j] == 1) {
                        isPivot = true;
                        for (int k = 0; k < j; k++) {
                            if (entries[i][k] != 0) {
                                onlyOneNonZero = false;
                                break;
                            }
                        }
                    } else {
                        onlyOneNonZero = false;
                        break;
                    }
                }
            }
            if (isPivot && onlyOneNonZero) {
                pivotCount++;
            }
        }
        return pivotCount;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Matrix) {
            Matrix other = (Matrix) obj;
            if (this.rows != other.rows || this.columns != other.columns) {
                return false;
            }
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (this.entries[i][j] != other.entries[i][j]) {
                        return false;
                    }
                }
            }
        }
        else if (obj instanceof Vector) {
            Vector other = (Vector) obj;
            if (this.rows != other.dimension) {
                return false;
            }
            for (int i = 0; i < this.rows; i++) {
                if (this.entries[i][0] != other.data[i]) {
                    return false;
                }
            }
        }
        if (obj instanceof double[][]) {
            double[][] other = (double[][]) obj;
            if (this.rows != other.length || this.columns != other[0].length) {
                return false;
            } else {
                for (int i = 0; i < this.rows; i++) {
                    for (int j = 0; j < this.columns; j++) {
                        if (this.entries[i][j] != other[i][j]) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
