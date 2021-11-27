package ink.sake.parameter;

import ink.sake.activation.ActivationFunction;
import ink.sake.activation.ActivationType;
import ink.sake.neural.NeuralLayer;

public class Parameter {

    private NeuralLayer neuralLayer;
    private ActivationType activationType;
    private ActivationFunction activationFunction;

    private double[][] weight;
    private double[] bias;
    private double[] z;
    private double[] activate;
    private double[] x;

    private double[][] dimensionWeight;
    private double[] dimensionBias;
    private double[] dimensionZ;
    private double[] dimensionActivate;
    private double[] dimensionX;

    private double[][] newWeight;
    private double[] newBias;

    public Parameter(NeuralLayer neuralLayer){
        this.neuralLayer = neuralLayer;
    }

    public void getParameter(){
        getLayerWeight();
        getLayerBias();
        getLayerZ();
        getLayerActivate();
        getLayerX();
        getLayerActivationFunction();
        getLayerActivateType();
    }

    public ActivationFunction getLayerActivationFunction(){
        return activationFunction = neuralLayer.getActivationFunction();
    }

    public void setLayerActivationFunction(){
        neuralLayer.setActivationFunction(activationFunction);
    }

    public ActivationType getLayerActivateType(){
        return activationType = neuralLayer.getActivationType();
    }

    public void setLayerActivateType(ActivationType activateType){
        neuralLayer.setActivationType(activationType);
    }

    public double[][] getLayerWeight(){
        return weight = neuralLayer.getWeight();
    }

    public void setLayerWeight(){
        neuralLayer.setNewWeight(newWeight);
    }

    public double[] getLayerBias(){
        return bias = neuralLayer.getBias();
    }

    public void setLayerBias(){
        neuralLayer.setNewBias(newBias);
    }

    public double[] getLayerZ(){
        return z = neuralLayer.getZ();
    }

    public void setLayerZ(double[] z){
        neuralLayer.setZ(dimensionZ);
    }

    public double[] getLayerActivate(){
        return activate = neuralLayer.getActivate();
    }

    public void setLayerActivate(double[] activate){
        neuralLayer.setActivate(dimensionActivate);
    }

    public double[] getLayerX(){
        return x = neuralLayer.getX();
    }

    public void setLayerX(double[] x){
        neuralLayer.setX(dimensionX);
    }

    public NeuralLayer getNeuralLayer() {
        return neuralLayer;
    }

    public void setNeuralLayer(NeuralLayer neuralLayer) {
        this.neuralLayer = neuralLayer;
    }

    public double[][] getWeight() {
        return weight;
    }

    public void setWeight(double[][] weight) {
        this.weight = weight;
    }

    public double[] getBias() {
        return bias;
    }

    public void setBias(double[] bias) {
        this.bias = bias;
    }

    public double[] getZ() {
        return z;
    }

    public void setZ(double[] z) {
        this.z = z;
    }

    public double[] getActivate() {
        return activate;
    }

    public void setActivate(double[] activate) {
        this.activate = activate;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }

    public double[][] getDimensionWeight() {
        return dimensionWeight;
    }

    public void setDimensionWeight(double[][] dimensionWeight) {
        this.dimensionWeight = dimensionWeight;
    }

    public double[] getDimensionBias() {
        return dimensionBias;
    }

    public void setDimensionBias(double[] dimensionBias) {
        this.dimensionBias = dimensionBias;
    }

    public double[] getDimensionZ() {
        return dimensionZ;
    }

    public void setDimensionZ(double[] dimensionZ) {
        this.dimensionZ = dimensionZ;
    }

    public double[] getDimensionActivate() {
        return dimensionActivate;
    }

    public void setDimensionActivate(double[] dimensionActivate) {
        this.dimensionActivate = dimensionActivate;
    }

    public double[] getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(double[] dimensionX) {
        this.dimensionX = dimensionX;
    }

    public ActivationType getActivationType() {
        return activationType;
    }

    public void setActivationType(ActivationType activationType) {
        this.activationType = activationType;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public double[][] getNewWeight() {
        return newWeight;
    }

    public void setNewWeight(double[][] newWeight) {
        this.newWeight = newWeight;
    }

    public double[] getNewBias() {
        return newBias;
    }

    public void setNewBias(double[] newBias) {
        this.newBias = newBias;
    }

    public void printWeight(){
        for (int i = 0;i < weight.length;i++){
            for (int j = 0;j < weight[0].length;j++){
                System.out.println(weight[i][j]);
            }
        }
    }
}
