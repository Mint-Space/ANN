package ink.sake.neural;

import ink.sake.activation.ActivationFunction;
import ink.sake.activation.ActivationType;
import ink.sake.matrix.ExtensionMatrix;

public class Pooling {

    private ExtensionMatrix extensionMatrix;

    private PoolingType poolingType;
    private double[][] matrix;

    private int kernelStride;

    private double[][] poolingLayer;

    private double[][] poolingLayerActivate;

    private ActivationFunction activationFunction;

    public Pooling(double[][] input,int kernelStride){
        extensionMatrix = new ExtensionMatrix();
        activationFunction = new ActivationFunction();
        this.matrix = input;
        this.kernelStride = kernelStride;
    }

    public Pooling createPooling(PoolingType poolingType){
        if(PoolingType.MaxPooling == poolingType){
            poolingLayer =  extensionMatrix.maxPooling(matrix,kernelStride);
        }else if(PoolingType.AveragePooling == poolingType){
            poolingLayer = extensionMatrix.averagePooling(matrix,kernelStride);
        }else {
            return null;
        }
        return this;
    }

    public Pooling activate(ActivationType activationType){
        if(ActivationType.Sigmoid == activationType){
            poolingLayerActivate = activationFunction.sigmoid(poolingLayer);
        }else if(ActivationType.RELU == activationType){
            poolingLayerActivate = activationFunction.relu(poolingLayer);
        }else {
            return null;
        }
        return this;
    }

    public ExtensionMatrix getExtensionMatrix() {
        return extensionMatrix;
    }

    public void setExtensionMatrix(ExtensionMatrix extensionMatrix) {
        this.extensionMatrix = extensionMatrix;
    }

    public PoolingType getPoolingType() {
        return poolingType;
    }

    public void setPoolingType(PoolingType poolingType) {
        this.poolingType = poolingType;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public int getKernelStride() {
        return kernelStride;
    }

    public void setKernelStride(int kernelStride) {
        this.kernelStride = kernelStride;
    }

    public double[][] getPoolingLayer() {
        return poolingLayer;
    }

    public void setPoolingLayer(double[][] poolingLayer) {
        this.poolingLayer = poolingLayer;
    }

    public double[][] getPoolingLayerActivate() {
        return poolingLayerActivate;
    }

    public void setPoolingLayerActivate(double[][] poolingLayerActivate) {
        this.poolingLayerActivate = poolingLayerActivate;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }
}
