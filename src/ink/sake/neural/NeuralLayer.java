package ink.sake.neural;

import ink.sake.activation.ActivationFunction;
import ink.sake.activation.ActivationType;
import ink.sake.matrix.Matrix;

public class NeuralLayer {

    Matrix matrix;
    private ActivationType activationType;
    private ActivationFunction activationFunction;
    private int neuralNumber;
    private double[] x;
    private double[] z;
    private double[] bias;
    private double[] newBias;
    private double[][] weight;
    private double[][] newWeight;
    private double[] activate;

    public NeuralLayer(int neuralNumber,ActivationType activationType){
        this.neuralNumber = neuralNumber;
        this.activationType =activationType;
        activationFunction = new ActivationFunction(activationType);
        matrix = new Matrix();
    }

    public NeuralLayer(int neuralNumber,double[] x,ActivationType activationType){
        this.x = x;
        this.neuralNumber = neuralNumber;
        this.activationType = activationType;
        matrix = new Matrix();
    }

    public void init(){
        this.weight = this.firstRandomWeight(newWeight);
        this.bias = this.firstRandomBias(newBias);
    }

    public boolean input(double[] X){
        if(X == null){
            return false;
        }else {
            this.x = X;
            return true;
        }
    }

    public double[] forwardPropagation(){
        z = z(x,weight,bias);
        return activate =  activationValue(z);
    }

    public double[] firstRandomBias(int biasNumber){
        return new Matrix().random(biasNumber);
    }

    public double[] firstRandomBias(double[] bias){
        if(bias == null){
            return new Matrix().random(this.getNeuralNumber());
        }else {
            return bias;
        }
    }

    public double[][] firstRandomWeight(int row,int column){
        return new Matrix().random(row,column);
    }

    public double[][] firstRandomWeight(double[][] weight){
        if(weight == null){
            return new Matrix().random(this.getNeuralNumber(),getX().length);
        }else {
            return weight;
        }
    }

    public double[] z(double[] x,double[][] weight,double[] bias){
        double[][] product;
        double[][] xMatrix;
        xMatrix = matrix.vectorToColumnMatrix(x);
        product = matrix.multi(weight,xMatrix);
        double[] productVecotr = matrix.matrixToVector(product);
        return matrix.add(productVecotr, bias);
    }

    public double z(double x,double weight,double bias){
        return x * weight + bias;
    }

    public double[] activationValue(double[] z){
        return activationFunction.activationValue(z,activationType);
    }

    public double activationValue(double z){
        return activationFunction.activationValue(z,activationType);
    }

    public int getNeuralNumber() {
        return neuralNumber;
    }

    public void setNeuralNumber(int neuralNumber) {
        this.neuralNumber = neuralNumber;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[] getBias() {
        return bias;
    }

    public void setBias(double[] bias) {
        this.bias = bias;
    }

    public double[][] getWeight() {
        return weight;
    }

    public void setWeight(double[][] weight) {
        this.weight = weight;
    }

    public double[] getActivate() {
        return activate;
    }

    public void setActivate(double[] activate) {
        this.activate = activate;
    }

    public double[] getZ() {
        return z;
    }

    public void setZ(double[] z) {
        this.z = z;
    }

    public ActivationType getActivationType() {
        return activationType;
    }

    public void setActivationType(ActivationType activationType) {
        this.activationType = activationType;
    }

    public void printActiavte() {
        for (int i =0;i<activate.length;i++){
            System.out.println(activate[i]);
        }
    }

    public double[] getNewBias() {
        return newBias;
    }

    public void setNewBias(double[] newBias) {
        this.newBias = newBias;
    }

    public double[][] getNewWeight() {
        return newWeight;
    }

    public void setNewWeight(double[][] newWeight) {
        this.newWeight = newWeight;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }
}
