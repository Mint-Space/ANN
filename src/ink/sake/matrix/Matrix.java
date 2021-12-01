package ink.sake.matrix;

import java.math.BigDecimal;

public class Matrix {
    private int row;
    private int column;
    private double[] vector;
    private double[][] matrix;

    private BigDecimal bigDecimal;

    public Matrix() {

    }

    //构造函数 参数为向量行数
    public Matrix(int row) {
        this.row = row;
    }

    //构造函数
    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public double[] random(int row) {
        double[] result = new double[row];
        for (int i = 0; i < row; i++) {
            result[i] = Math.random()-0.5;
        }
        return vector = result;
    }

    public double[][] random(int row, int column) {
        double[][] result = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = Math.random() - 0.5;
            }
        }
        return matrix = result;
    }

    public double[] zero(int row) {
        double[] result = new double[row];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                result[i][j] = 0.0;
//            }
//        }
        return vector = result;
    }

    public double[][] zero(int row, int column) {
        double[][] result = new double[row][column];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                result[i][j] = 0.0;
//            }
//        }
        return matrix = result;
    }

    public double[][] transpose(double[][] A) {
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[ac][ar];
        for (int i = 0; i < ac; i++) {
            for (int j = 0; j < ar; j++) {
                result[i][j] = A[j][i];
            }
        }
        return matrix = result;
    }

    // {{1,2,3...}}
    public double[][] vectorToRowMatrix(double[] A) {
        int ar = A.length;
        double[][] result = new double[1][ar];
        for (int i = 0; i < ar; i++) {
            result[0][i] = A[i];
        }
        return matrix = result;
    }

    // {{1},{2},{3}...}
    public double[][] vectorToColumnMatrix(double[] A) {
        int ar = A.length;
        double[][] result = new double[ar][1];
        for (int i = 0; i < ar; i++) {
            result[i][0] = A[i];
        }
        return matrix = result;
    }

    public double[] matrixToVector(double[][] A) {
        int ar = A.length;
        int ac = A[0].length;
        double[] result;
        if (ar == 1) {
            result = new double[ac];
            for (int i = 0; i < ar; i++) {
                for (int j = 0; j < ac; j++) {
                    result[j] = A[i][j];
                }
            }
        } else if (ac == 1) {
            result = new double[ar];
            for (int i = 0; i < ar; i++) {
                for (int j = 0; j < ac; j++) {
                    result[i] = A[i][j];
                }
            }
        } else {
            System.out.println("矩阵A 没有一维的行或列，不适合将矩阵转换为向量。");
            return null;
        }
        return vector = result;
    }

    public int maxVectorIndex(double[] A){
        int ar = A.length;
        int maxIndex = -1;
        double max = 0;
        for (int i = 0; i < ar; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            } else if (A[i] < max) {
                max = max;
                maxIndex = maxIndex;
            }
        }
        return maxIndex;
    }

    public double[] not(double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            bigDecimal = new BigDecimal(Double.toString(A[i]));
            result[i] = bigDecimal.negate().doubleValue();
        }
        return result;
    }

    public double[] abs(double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = Math.abs(A[i]);
        }
        return result;
    }

    public double vectorSum(double[] A) {
        double result = 0.0;
        int ar = A.length;
        for (int i = 0; i < ar; i++) {
            result += A[i];
        }
        return result;
    }

    public double[] ln(double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = Math.log(A[i]);
        }
        return result;
    }

    public double[] sub(double number,double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for(int i = 0;i < ar;i++) {
            result[i] = number - A[i];
        }
        return result;
    }

    public double[] sub(double[] A,double number) {
        int ar = A.length;
        double[] result = new double[ar];
        for(int i = 0;i < ar;i++) {
            result[i] = A[i] - number;
        }
        return result;
    }

    public double[] division(double[] A,double[] B) {
        int ar = A.length;
        int br = B.length;
        if(ar != br) {
            System.out.println("除法向量A "+ar+" 维 与 向量B "+br+" 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for(int i = 0;i < ar;i++) {
            result[i] = A[i] / B[i];
        }
        return result;
    }

    public double[] add(double[] A, double[] B) {
        int ar = A.length;
        int br = B.length;
        if (ar != br) {
            System.out.println("加法向量A "+ar+" 维 与 向量B "+br+" 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] + B[i];
        }
        return vector = result;
    }

    public double[][] add(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ar != br || ac != bc) {
            System.out.println("加法矩阵A "+ar+" 行 "+ac+" 列 与 矩阵B "+br+" 行 "+bc+" 列 因维度不同。");
            return null;
        }
        double[][] result = new double[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return matrix = result;
    }

    public double[] sub(double[] A, double[] B) {
        int ar = A.length;
        int br = B.length;
        if (ar != br) {
            System.out.println("减法向量A "+ar+" 维 与 向量B "+br+" 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] - B[i];
        }
        return vector = result;
    }

    public double[][] sub(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ar != br || ac != bc) {
            System.out.println("减法矩阵A "+ar+" 行 "+ac+" 列 与 矩阵B "+br+" 行 "+bc+" 列 因维度不同。");
            return null;
        }
        double[][] result = new double[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return matrix = result;
    }

    public double[] elementProduct(double[] A, double[] B) {
        int ar = A.length;
        int br = B.length;
        if (ar != br) {
            System.out.println("元素乘法向量A "+ar+" 维 与 向量B "+br+" 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] * B[i];
        }
        return vector = result;
    }

    public double[][] elementProduct(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ar != br || ac != bc) {
            System.out.println("元素乘法矩阵A "+ar+" 行 "+ac+" 列 与 矩阵B "+br+" 行 "+bc+" 列 因维度不同。");
            return null;
        }
        double[][] result = new double[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i][j] = A[i][j] * B[i][j];
            }
        }
        return matrix = result;
    }

    public double[] pow(double[] A, double number) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = Math.pow(A[i], number);
        }
        return vector = result;
    }

    public double[] multi(double[] A, double number) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] * number;
        }
        return vector = result;
    }

    public double[][] pow(double[][] A, double number) {
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i][j] = Math.pow(A[i][j], number);
            }
        }
        return matrix = result;
    }

    public double[][] multi(double[][] A, double number) {
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i][j] = A[i][j] * number;
            }
        }
        return matrix = result;
    }

    public double[][] multi(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ac != br) {
            System.out.println("乘法矩阵A "+ar+" 行 "+ac+" 列 与 矩阵B "+br+" 行 "+bc+" 列 因维度不同。");
            return null;
        }
        double[][] result = new double[ar][bc];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < bc; j++) {
                result[i][j] = result(A, B, i, j, ac);
            }
        }
        return matrix = result;
    }

    private double result(double[][] A, double[][] B, int row, int column, int key) {
        double result = 0;
        for (int i = 0; i < key; i++) {
            result += A[row][i] * B[i][column];
        }
        return result;
    }

    public double[] binarization(double[] A,double binarizationInterval) {
        int ar = A.length;
        double[] result = new double[ar];
        for(int i = 0;i < ar;i++) {
            result[i] = A[i] / (binarizationInterval-1);
        }
        return result;
    }

    public double[][] binarization(double[][] A,double binarizationInterval) {
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[ar][ac];
        for(int i = 0;i < ar;i++) {
            for(int j = 0;j< ac;j++) {
                result[i][j] = A[i][j] / (binarizationInterval-1);
            }
        }
        return result;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public int getMatrixRow(double[][] A){
        return A.length;
    }

    public int getMatrixColumn(double[][] A){
        return A[0].length;
    }

    public void printVector() {
        int vr = vector.length;
        for (int i = 0; i < vr; i++) {
            System.out.print(vector[i] + "  ");
        }
    }

    public void printVector(double[] vector) {
        int vr = vector.length;
        for (int i = 0; i < vr; i++) {
            System.out.print(vector[i] + "  ");
        }
        System.out.println();
    }

    public void printMatrix() {
        int mr = matrix.length;
        int mc = matrix[0].length;
        for (int i = 0; i < mr; i++) {
            for (int j = 0; j < mc; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void printMatrix(double[][] matrix) {
        int mr = matrix.length;
        int mc = matrix[0].length;
        for (int i = 0; i < mr; i++) {
            for (int j = 0; j < mc; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
