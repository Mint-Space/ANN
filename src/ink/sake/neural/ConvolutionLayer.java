package ink.sake.neural;

import ink.sake.activation.ActivationFunction;
import ink.sake.activation.ActivationType;
import ink.sake.matrix.ExtensionMatrix;

public class ConvolutionLayer {
    private ExtensionMatrix convolution;
    private double[][] matrix;
    private double[][] kernel;
    private int stride;
    private double[][] convolutionLayer;
    private double[][] convolutionLayerActivate;

    private ActivationFunction activationFunction;

    public ConvolutionLayer(double[][] input,int kernelSize,int stride){
        convolution = new ExtensionMatrix();
        activationFunction = new ActivationFunction();
        if(kernelSize != -1){
            kernel = convolution.createRandomKernel(kernelSize);
        }
        this.matrix = input;
        this.stride = stride;
    }

    public ConvolutionLayer createConvolutionLayer(){
        convolutionLayer = convolution.featureMap(matrix,kernel,stride);
        return this;
    }

    public ConvolutionLayer activate(ActivationType activationType){
        if(activationType == ActivationType.RELU){
            convolutionLayerActivate = activationFunction.relu(convolutionLayer);
        }else if(activationType == ActivationType.Sigmoid){
            convolutionLayerActivate = activationFunction.sigmoid(convolutionLayer);
        }else {
            convolutionLayerActivate = null;
        }
        return this;
    }

    public ExtensionMatrix getConvolution() {
        return convolution;
    }

    public void setConvolution(ExtensionMatrix convolution) {
        this.convolution = convolution;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getKernel() {
        return kernel;
    }

    public void setKernel(double[][] kernel) {
        this.kernel = kernel;
    }

    public int getStride() {
        return stride;
    }

    public void setStride(int stride) {
        this.stride = stride;
    }

    public double[][] getConvolutionLayer() {
        return convolutionLayer;
    }

    public void setConvolutionLayer(double[][] convolutionLayer) {
        this.convolutionLayer = convolutionLayer;
    }

    public double[][] getConvolutionLayerActivate() {
        return convolutionLayerActivate;
    }

    public void setConvolutionLayerActivate(double[][] convolutionLayerActivate) {
        this.convolutionLayerActivate = convolutionLayerActivate;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }
}
