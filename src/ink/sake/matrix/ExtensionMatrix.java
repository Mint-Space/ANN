package ink.sake.matrix;

public class ExtensionMatrix extends Matrix{

    //步长
    private int stride;
    private  double[][] Matrix;

    public ExtensionMatrix(){
        super();
    }

    /**
     * 私有函数从大矩阵第row行col列中取出n行m列矩阵
     * @param A         输入矩阵
     * @param row       第row行
     * @param column    第column列
     * @param n         取出矩阵为n行
     * @param m         取出矩阵为m列
     * @param stride    步长
     * @return          取出的矩阵
     */
    private double[][] getMinMatrix(double[][] A, int row,int column,int n,int m,int stride){
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[n][m];
        int astrider = 0;
        int astridec = 0;
        for (int i = 0; i < n; i++) {
            astrider = row* stride + i;
            for (int j = 0; j < m; j++) {
                astridec = column*stride+j;
                result[i][j] = A[astrider][astridec];
            }
        }
        return result;
    }

    /**
     * 私有函数给矩阵加0边
     * @param A             输入矩阵
     * @param paddingRow    行加padding
     * @param paddingCol    列加padding
     * @return              返回修正padding的矩阵
     */
    private double[][] addPaddingMatrix(double[][] A,int paddingRow,int paddingCol){
        int ar = A.length;
        int ac = A[0].length;
        double[][] result = new double[ar+paddingRow][ac+paddingCol];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < ac; j++) {
                result[i][j] = A[i][j];
            }
        }
        return result;
    }

    /**
     * 私有函数卷积操作
     * @param inputA    输入矩阵A
     * @param kernel    卷积核
     * @return          卷积结果
     */
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

    /**
     * 私有函数计算滑块
     * @param A     输入矩阵A
     * @param B     输入矩阵B
     * @param row   增加的行
     * @param col   增加的列
     * @return      加padding后的矩阵
     */
    private double[][] CalculateSlider(double[][] A, double[][] B,int row,int col){
        int ar = A.length;
        int ac = A[0].length;
        int br = B.length;
        int bc = B[0].length;
        double[][] result = new double[ar + row*2][ac + col*2];
        return result = addPaddingMatrix(A,row,col);
    }

    /**
     * 公有函数计算特征图
     * @param input     输入矩阵
     * @param kernel    卷积核
     * @param stride    步长
     * @return          计算出的特征图
     */
    public double[][] featureMap(double[][] input, double[][] kernel,int stride) {
        int ar = input.length;
        int ac = input[0].length;
        int br = kernel.length;
        int bc = kernel[0].length;
        int aPaddingRow = (Math.floorMod(ar-br,stride) == 0 ? Math.floorMod(ar-br,stride):stride - (Math.floorMod(ar-br,stride)));
        int aPaddingCol = (Math.floorMod(ac-bc,stride) == 0 ? Math.floorMod(ac-bc,stride):stride - (Math.floorMod(ac-bc,stride)));
        double[][] A = CalculateSlider(input,kernel,aPaddingRow,aPaddingCol);
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
