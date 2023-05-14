package ink.sake.matrix;

import java.math.BigDecimal;

public class Matrix {
    /**
     * 行数
     */
    private int row;
    /**
     * 列数
     */
    private int column;
    /**
     * 一维向量
     */
    private double[] vector;
    /**
     * 二维矩阵
     */
    private double[][] matrix;

    /**
     * BigDecimal类型
     */
    private BigDecimal bigDecimal;

    /**
     * 构造函数
     */
    public Matrix() {

    }

    //构造函数 参数为向量行数

    /**
     * 构造函数
     * @param row   向量行数
     */
    public Matrix(int row) {
        this.row = row;
    }

    //构造函数

    /**
     * 构造函数
     * @param row       矩阵行
     * @param column    矩阵列
     */
    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * 生成随机向量
     * @param row   向量行
     * @return      随机向量
     */
    public double[] random(int row) {
        double[] result = new double[row];
        for (int i = 0; i < row; i++) {
            result[i] = Math.random() - 0.5;
        }
        return vector = result;
    }

    /**
     * 生成随机矩阵
     * @param row       矩阵行
     * @param column    矩阵列
     * @return          随机矩阵
     */
    public double[][] random(int row, int column) {
        double[][] result = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[i][j] = Math.random() - 0.5;
            }
        }
        return matrix = result;
    }

    /**
     * 生成随机零向量
     * @param row   零向量行
     * @return      随机零向量
     */
    public double[] zero(int row) {
        double[] result = new double[row];
        return vector = result;
    }

    /**
     * 生成随机零矩阵
     * @param row       零矩阵行
     * @param column    零矩阵列
     * @return          随机零矩阵
     */
    public double[][] zero(int row, int column) {
        double[][] result = new double[row][column];
        return matrix = result;
    }

    /**
     * 矩阵转置
     * @param A 矩阵A
     * @return  转置后的矩阵
     */
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


    /**
     * 一维向量转为1行xN列矩阵   {{1,2,3...}}
     * @param A     向量A
     * @return      1行xN列矩阵   {{1,2,3...}}
     */
    public double[][] vectorToRowMatrix(double[] A) {
        int ar = A.length;
        double[][] result = new double[1][ar];
        for (int i = 0; i < ar; i++) {
            result[0][i] = A[i];
        }
        return matrix = result;
    }

    // {{1},{2},{3}...}

    /**
     * 一维向量转为N行x1列矩阵    {{1},{2},{3}...}
     * @param A     向量A
     * @return      N行x1列矩阵    {{1},{2},{3}...}
     */
    public double[][] vectorToColumnMatrix(double[] A) {
        int ar = A.length;
        double[][] result = new double[ar][1];
        for (int i = 0; i < ar; i++) {
            result[i][0] = A[i];
        }
        return matrix = result;
    }

    /**
     * 矩阵转为向量
     * @param A     矩阵A
     * @return      一维向量
     */
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
            result = new double[ar*ac];
            int rr = result.length;
            double number = 0;
                for (int j = 0; j < ar; j++) {
                    for (int z = 0; z < ac; z++) {
                        result[z] = A[j][z];
                        System.out.print(j+z);
                    }
                    //eeeerrrrrrr
//                result[i] = result[j];
                }


            System.out.println("矩阵A 没有一维的行或列，不适合将矩阵转换为向量。");
            return result;
        }
        return vector = result;
    }

    /**
     * 一维向量最大值的下标
     * @param A     一维向量
     * @return      一维向量最大值的下标
     */
    public int maxVectorIndex(double[] A) {
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

    /**
     * 向量取反
     * @param A     一维向量
     * @return      一维向量取反
     */
    public double[] not(double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            bigDecimal = new BigDecimal(Double.toString(A[i]));
            result[i] = bigDecimal.negate().doubleValue();
        }
        return result;
    }

    /**
     * 一维向量的绝对值
     * @param A     一维向量
     * @return      取绝对值后的一维向量
     */
    public double[] abs(double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = Math.abs(A[i]);
        }
        return result;
    }

    /**
     * 一维向量的所有值的总和
     * @param A     一维向量
     * @return      一维向量的所有值的总和
     */
    public double vectorSum(double[] A) {
        double result = 0.0;
        int ar = A.length;
        for (int i = 0; i < ar; i++) {
            result += A[i];
        }
        return result;
    }

    /**
     * 一维向量log值
     * @param A     一维向量
     * @return      一维向量log值
     */
    public double[] log(double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = Math.log(A[i]);
        }
        return result;
    }

    /**
     * 一个数和一维向量的减法
     * @param number    一个有小数点的数
     * @param A         一维向量
     * @return          一个有小数点的数与一维向量的差
     */
    public double[] sub(double number, double[] A) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = number - A[i];
        }
        return result;
    }

    /**
     * 一维向量和一个数的减法
     * @param A         一维向量
     * @param number    一个有小数点的数
     * @return          一维向量与一个有小数点点的数的差
     */
    public double[] sub(double[] A, double number) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] - number;
        }
        return result;
    }

    /**
     * 两个向量各元素相除
     * @param A     一维向量
     * @param B     一维向量
     * @return      两个向量各元素相除
     */
    public double[] division(double[] A, double[] B) {
        int ar = A.length;
        int br = B.length;
        if (ar != br) {
            System.out.println("除法向量A " + ar + " 维 与 向量B " + br + " 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] / B[i];
        }
        return result;
    }

    /**
     * 两个向量各元素相加
     * @param A     一维向量
     * @param B     一维向量
     * @return      两个向量各元素相加
     */
    public double[] add(double[] A, double[] B) {
        int ar = A.length;
        int br = B.length;
        if (ar != br) {
            System.out.println("加法向量A " + ar + " 维 与 向量B " + br + " 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] + B[i];
        }
        return vector = result;
    }

    /**
     * 两个矩阵各元素相加
     * @param A     二维矩阵
     * @param B     二维矩阵
     * @return      两个矩阵各元素相加
     */
    public double[][] add(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ar != br || ac != bc) {
            System.out.println("加法矩阵A " + ar + " 行 " + ac + " 列 与 矩阵B " + br + " 行 " + bc + " 列 因维度不同。");
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

    /**
     * 两个一维向量各元素相减
     * @param A     一维向量
     * @param B     一维向量
     * @return      两个一维向量各元素相减
     */
    public double[] sub(double[] A, double[] B) {
        int ar = A.length;
        int br = B.length;
        if (ar != br) {
            System.out.println("减法向量A " + ar + " 维 与 向量B " + br + " 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] - B[i];
        }
        return vector = result;
    }

    /**
     * 两个二维矩阵各元素相减
     * @param A     二维矩阵
     * @param B     二维矩阵
     * @return      两个二维矩阵各元素相减
     */
    public double[][] sub(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ar != br || ac != bc) {
            System.out.println("减法矩阵A " + ar + " 行 " + ac + " 列 与 矩阵B " + br + " 行 " + bc + " 列 因维度不同。");
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

    /**
     * 两个一维向量各元素相乘
     * @param A     一维向量
     * @param B     一维向量
     * @return      两个一维向量各元素相乘
     */
    public double[] elementProduct(double[] A, double[] B) {
        int ar = A.length;
        int br = B.length;
        if (ar != br) {
            System.out.println("元素乘法向量A " + ar + " 维 与 向量B " + br + " 维  因维度不同");
            return null;
        }
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] * B[i];
        }
        return vector = result;
    }

    /**
     * 两个二维矩阵各元素相乘
     * @param A     二维矩阵
     * @param B     二维矩阵
     * @return      两个二维矩阵各元素相乘
     */
    public double[][] elementProduct(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ar != br || ac != bc) {
            System.out.println("元素乘法矩阵A " + ar + " 行 " + ac + " 列 与 矩阵B " + br + " 行 " + bc + " 列 因维度不同。");
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

    /**
     * 一维向量的N次方
     * @param A         一维向量
     * @param number    N次
     * @return          一维向量的N次方
     */
    public double[] pow(double[] A, double number) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = Math.pow(A[i], number);
        }
        return vector = result;
    }


    /**
     * 一维向量乘一一个带小数点的数
     * @param A         一维向量
     * @param number    一个带小数点的数
     * @return          一维向量乘一一个带小数点的数
     */
    public double[] multi(double[] A, double number) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] * number;
        }
        return vector = result;
    }

    /**
     * 一个带小数点的数复制到一维向量
     * @param A     一个带小数点的数
     * @param row   一维向量行数（长度）
     * @return      一个带小数点的数复制到一维向量
     */
    public double[] numberCopyToVector(double A,int row){
        double[] result = new double[row];
        for (int i = 0; i < row; i++) {
            result[i] = A;
        }
        return result;
    }
    /**
     * 二维矩阵各元素的N次方
     * @param A         二维矩阵
     * @param number    N次
     * @return          二维矩阵各元素的N次方
     */
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

    /**
     * 二维矩阵和一个带小数点的数相乘
     * @param A         二维矩阵
     * @param number    一个带小数点的数
     * @return          二维矩阵和一个带小数点的数相乘
     *
     */
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

    /**
     * 两个二维矩阵相乘
     * @param A     二维矩阵A
     * @param B     二维矩阵B
     * @return      两个二维矩阵相乘
     */
    public double[][] multi(double[][] A, double[][] B) {
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        if (ac != br) {
            System.out.println("乘法矩阵A " + ar + " 行 " + ac + " 列 与 矩阵B " + br + " 行 " + bc + " 列 因维度不同。");
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

    /**
     * 两个二维矩阵相乘
     * @param A         二维矩阵A
     * @param B         二维矩阵B
     * @param row       二维矩阵A的行
     * @param column    二维矩阵B的列
     * @param key       二维矩阵A的列
     * @return          两个二维矩阵相乘
     */
    private double result(double[][] A, double[][] B, int row, int column, int key) {
        double result = 0;
        for (int i = 0; i < key; i++) {
            result += A[row][i] * B[i][column];
        }
        return result;
    }

    /**
     * 一维向量二值化
     * @param A                     一维向量
     * @param binarizationInterval  二值化的最大数
     * @return                      二值化为0~1的数
     */
    public double[] binarization(double[] A, double binarizationInterval) {
        int ar = A.length;
        double[] result = new double[ar];
        for (int i = 0; i < ar; i++) {
            result[i] = A[i] / (binarizationInterval - 1);
        }
        return result;
    }

    /**
     * 二维矩阵二值化
     * @param A                         二维矩阵
     * @param binarizationInterval      二值化的最大数
     * @return                          二值化为0~1的数
     */
    public double[][] binarization(double[][] A, double binarizationInterval) {
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[ar][ac];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i][j] = A[i][j] / (binarizationInterval - 1);
            }
        }
        return result;
    }

    /**
     * 得到行数
     * @return      得到行数
     */
    public int getRow() {
        return row;
    }

    /**
     * 设置行数
     * @param row       设置行数
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * 得到列数
     * @return      得到列数
     */
    public int getColumn() {
        return column;
    }

    /**
     * 设置列数
     * @param column        设置列数
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * 得到一维向量
     * @return      得到一维向量
     */
    public double[] getVector() {
        return vector;
    }

    /**
     * 设置一维向量
     * @param vector        设置一维向量
     */
    public void setVector(double[] vector) {
        this.vector = vector;
    }

    /**
     * 得到二维矩阵
     * @return      得到二维矩阵
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * 设置二维矩阵
     * @param matrix        设置二维矩阵
     */
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * 得到二维矩阵行数
     * @return 得到二维矩阵行数
     */
    public int getMatrixRow() {
        return matrix.length;
    }

    /**
     * 得到二维矩阵列数
     * @return 得到二维矩阵列数
     */
    public int getMatrixColumn() {
        return matrix[0].length;
    }

    /**
     * 打印一维向量
     */
    public void printVector() {
        int vr = vector.length;
        for (int i = 0; i < vr; i++) {
            System.out.print(vector[i] + "  ");
        }
    }

    /**
     * 打印一维向量
     * @param vector    一维向量
     */
    public void printVector(double[] vector) {
        int vr = vector.length;
        for (int i = 0; i < vr; i++) {
            System.out.print(vector[i] + "  ");
        }
        System.out.println();
    }

    /**
     * 打印二维矩阵
     */
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

    /**
     * 打印二维矩阵
     * @param matrix 二维矩阵
     */
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
