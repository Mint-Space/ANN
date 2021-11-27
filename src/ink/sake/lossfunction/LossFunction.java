package ink.sake.lossfunction;

import ink.sake.matrix.Matrix;

public class LossFunction {

    LossType lossType;
    Matrix matrix;

    public LossFunction(LossType lossType){
        this.lossType = lossType;
        matrix = new Matrix();
    }

    public double[] lossValue(double[] A , double[] B){
        double[] result = new double[A.length];
        if (lossType == LossType.LeastSquaresMethod){
            result = leastSquaresMethod(A,B);
        }
        return result;
    }

    public double[] derivationLossValue(double[] A , double[] B){
        double[] result = new double[A.length];
        if (lossType == LossType.LeastSquaresMethod){
            result = derivationLeastSquaresMethod(A,B);
        }
        return result;
    }

    public double leastSquaresMethod(double A,double B){
        return Math.abs((A - B)) / 2;
    }

    public double[] leastSquaresMethod(double[] A,double[] B){
        double[] result = matrix.abs(matrix.sub(A, B));
        return matrix.multi(matrix.multi(result, 2),0.5);
    }

    public double derivationLeastSquaresMethod(double A,double B){
        return  A - B;
    }

    public double[] derivationLeastSquaresMethod(double[] A,double[] B){
        double[] result = matrix.abs(matrix.sub(A, B));
        return result;
    }
}
