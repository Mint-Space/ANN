package ink.sake.matrix;

public class ExtensionMatrix extends Matrix{

    //步长
    private int stride;
    private  double[][] Matrix;

    public ExtensionMatrix(){
        super();
    }

    //取出n行m列矩阵
    private double[][] getMinMatrix(double[][] A, int row,int column,int n,int m,int stride){
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = A[row + i + stride][column + j + stride];
            }
        }
        return result;
    }

    private double[][] addPaddingMatrix(double[][] A,int padding){
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[ar+padding*2][ac+padding*2];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i+padding][j+padding] = A[i][j];
            }
        }
        return result;
    }

    private double convolution(double[][] inputA ,double[][] kernel){
        int ar = inputA.length;
        int ac = inputA[0].length;
        double result = 0;
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result += inputA[i][j] * kernel[i][j];
            }
        }
        return result;
    }

    private double[][] CalculateSlider(double[][] A, double[][] B,int stride){
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        double[][] result = new double[ar + stride*2][ac + stride*2];
        if(Math.floorMod(ar,br)==0){
            result = A;
        }else {
            return result = addPaddingMatrix(A,stride);
        }
        if(Math.floorMod(ac,bc)==0){
            result = A;
        }else {
            return result = addPaddingMatrix(A,stride);
        }
        return result;
    }
    public double[][] featureMap(double[][] input, double[][] kernel,int stride) {
        int ar = input.length;
        int ac = input[0].length;
        int br = kernel.length;
        int bc = kernel[0].length;
        double[][] A = CalculateSlider(input,kernel,stride);
        int Ar = A.length;
        int Ac = A[0].length;
        int maxStrideRowCount = (Math.floorMod(Ar-br,stride) == 0 ? Math.floorDiv(Ar-br,stride):(Math.floorDiv(Ar-br,stride)+1))+1;
        int maxStrideColConut = (Math.floorMod(Ac-bc,stride) == 0 ? Math.floorDiv(Ac-bc,stride):(Math.floorDiv(Ac-bc,stride)+1))+1;
        double[][] featureMap = new double[maxStrideRowCount][maxStrideColConut];
        for(int i = 0;i < maxStrideRowCount;i++){
            for (int j = 0; j < maxStrideColConut; j++) {
                featureMap[i][j] = convolution(getMinMatrix(A,i,j,br,bc,stride),kernel);
                System.out.print(featureMap[i][j] +" | ");
            }
            System.out.println();
        }
        return featureMap;
    }


    public void printMatrix(){
        int ar = Matrix.length;
        int ac = Matrix[0].length;
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                System.out.print(Matrix[i][j]);
            }
            System.out.println();
        }
    }
}
