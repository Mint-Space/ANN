package ink.sake.lossfunction;

import ink.sake.matrix.Matrix;

public class LossFunction {

    LossType lossType;
    Matrix matrix;
    private double lossValue;

    public LossFunction(LossType lossType) {
        this.lossType = lossType;
        matrix = new Matrix();
    }

    public double lossValue(double[] A, double[] B) {
        double result = 0.0;
        if (lossType == LossType.LeastSquaresMethod) {
            result = leastSquaresMethodValue(A, B);
        }
        return result;
    }

    public double[] lossValueVector(double[] A, double[] B) {
        double[] result = new double[A.length];
        if (lossType == LossType.LeastSquaresMethod) {
            result = leastSquaresMethodVector(A, B);
        }
        return result;
    }

    public double[] derivationLossValue(double[] A, double[] B) {
        double[] result = new double[A.length];
        if (lossType == LossType.LeastSquaresMethod) {
            result = derivationLeastSquaresMethodVector(A, B);
        }
        return result;
    }

    public double leastSquaresMethod(double A, double B) {
        return Math.abs((A - B)) / 2.0;
    }

    public double[] leastSquaresMethodVector(double[] A, double[] B) {
        double[] result = matrix.sub(A, B);
        return matrix.multi(matrix.pow(result, 2.0), 0.5);
    }

    public double leastSquaresMethodValue(double[] A, double[] B) {
        double[] distance = matrix.pow(matrix.sub(A, B), 2.0);
        double distanceSum = matrix.vectorSum(distance);
        return this.lossValue = distanceSum / (distance.length * 2.0);
    }

    public double derivationLeastSquaresMethod(double A, double B) {
        return A - B;
    }

    public double[] derivationLeastSquaresMethodVector(double[] A, double[] B) {
        double[] result = matrix.abs(matrix.sub(A, B));
        System.out.print("LOSS:");
        matrix.printVector(result);
        return result;
    }
}
