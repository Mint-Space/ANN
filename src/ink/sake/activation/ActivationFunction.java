package ink.sake.activation;

import ink.sake.matrix.Matrix;

public class ActivationFunction {
    private double activationValue;
    private double derivationActivationValue;
    private double[] activationVector;
    private double[] derivationActivationVector;
    private double[][] activationMatrix;
    private double[][] derivationActivationMatrix;
    private ActivationType activationType;

    Matrix matrix = null;


    public ActivationFunction() {
        matrix = new Matrix();
    }

    public ActivationFunction(ActivationType activationType) {
        matrix = new Matrix();
        this.activationType = activationType;
    }

    public double activationValue(double z, ActivationType activationType) {
        if (activationType == ActivationType.Sigmoid) {
            return sigmoid(z);
        } else if (activationType == ActivationType.RELU) {
            return relu(z);
        } else {
            return -1;
        }
    }

    public double[] activationValue(double[] z, ActivationType activationType) {
        if (activationType == ActivationType.Sigmoid) {
            return sigmoid(z);
        } else if (activationType == ActivationType.RELU) {
            return relu(z);
        } else {
            return null;
        }
    }

    public double[][] activationValue(double[][] z, ActivationType activationType) {
        if (activationType == ActivationType.Sigmoid) {
            return sigmoid(z);
        } else if (activationType == ActivationType.RELU) {
            return relu(z);
        } else {
            return null;
        }
    }

    public double derivationActivationValue(double z, ActivationType activationType) {
        if (activationType == ActivationType.Sigmoid) {
            return derivationSigmoid(z);
        } else if (activationType == ActivationType.RELU) {
            return derivationRelu(z);
        } else {
            return -1;
        }
    }

    public double[] derivationActivationValue(double[] z, ActivationType activationType) {
        switch (activationType) {
            case Sigmoid:
                return derivationSigmoid(z);
            case RELU:
                return derivationRelu(z);
            default:
                return null;
        }
    }

    public double[][] derivationActivationValue(double[][] z, ActivationType activationType) {
        switch (activationType) {
            case Sigmoid:
                return derivationSigmoid(z);
            case RELU:
                return derivationRelu(z);
            default:
                return null;
        }
    }

    public double sigmoid(double z) {
        return activationValue = 1 / (1 + Math.exp(-1 * z));
    }

    public double[] sigmoid(double[] z) {
        int zr = z.length;
        double[] result = new double[zr];
        for (int i = 0; i < zr; i++) {
            result[i] = 1 / (1 + Math.exp(-1 * z[i]));
        }
        return activationVector = result;
    }

    public double[][] sigmoid(double[][] z) {
        int zr = z.length;
        int zc = z[0].length;
        double[][] result = new double[zr][zc];
        for (int i = 0; i < zr; i++) {
            for (int j = 0; j < zc; j++) {
                result[i][j] = 1 / (1 + Math.exp(-1 * z[i][j]));
            }
        }
        return activationMatrix = result;
    }

    public double derivationSigmoid(double z) {
        double a = sigmoid(z);
        return derivationActivationValue = a * (1 - a);
    }

    public double[] derivationSigmoid(double[] z) {
        int zr = z.length;
        double[] a = sigmoid(z);
        double[] result = new double[zr];
        for (int i = 0; i < zr; i++) {
            result[i] = a[i] * (1 - a[i]);
        }
        return derivationActivationVector = result;
    }

    public double[][] derivationSigmoid(double[][] z) {
        int zr = z.length;
        int zc = z[0].length;
        double[][] a = sigmoid(z);
        double[][] result = new double[zr][zc];
        for (int i = 0; i < zr; i++) {
            for (int j = 0; j < zc; j++) {
                result[i][j] = a[i][j] * (1 - a[i][j]);
            }
        }
        return derivationActivationMatrix = result;
    }

    public double relu(double z) {
        return activationValue = Math.max(0, z);
    }

    public double[] relu(double[] z) {
        int zr = z.length;
        double[] result = new double[zr];
        for (int i = 0; i < zr; i++) {
            result[i] = Math.max(0, z[i]);
        }
        return activationVector = result;
    }

    public double[][] relu(double[][] z) {
        int zr = z.length;
        int zc = z[0].length;
        activationMatrix = new double[zr][zc];
        for (int i = 0; i < zr; i++) {
            for (int j = 0; j < zc; j++) {
                activationMatrix[i][j] = Math.max(0, z[i][j]);
            }
        }
        return activationMatrix;
    }

    public double derivationRelu(double z) {
        if (z <= 0) {
            return derivationActivationValue = 0;
        } else {
            return derivationActivationValue = 1;
        }
    }

    public double[] derivationRelu(double[] z) {
        int zr = z.length;
        double[] result = new double[zr];
        for (int i = 0; i < zr; i++) {
            if (z[i] <= 0) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }
        return derivationActivationVector = result;
    }

    public double[][] derivationRelu(double[][] z) {
        int zr = z.length;
        int zc = z[0].length;
        derivationActivationMatrix = new double[zr][zc];
        for (int i = 0; i < zr; i++) {
            for (int j = 0; j < zc; j++) {
                if (z[i][j] <= 0) {
                    derivationActivationMatrix[i][j] = 0;
                } else {
                    derivationActivationMatrix[i][j] = 1;
                }
            }
        }
        return derivationActivationMatrix;
    }

    public double getActivationValue() {
        return activationValue;
    }

    public void setActivationValue(double activationValue) {
        this.activationValue = activationValue;
    }

    public double getDerivationActivationValue() {
        return derivationActivationValue;
    }

    public void setDerivationActivationValue(double derivationActivationValue) {
        this.derivationActivationValue = derivationActivationValue;
    }

    public double[] getActivationVector() {
        return activationVector;
    }

    public void setActivationVector(double[] activationVector) {
        this.activationVector = activationVector;
    }

    public double[] getDerivationActivationVector() {
        return derivationActivationVector;
    }

    public void setDerivationActivationVector(double[] derivationActivationVector) {
        this.derivationActivationVector = derivationActivationVector;
    }

    public ActivationType getActivationType() {
        return activationType;
    }

    public void setActivationType(ActivationType activationType) {
        this.activationType = activationType;
    }
}
