package ink.sake.neural;

import ink.sake.activation.ActivationFunction;
import ink.sake.activation.ActivationType;
import ink.sake.lossfunction.LossFunction;
import ink.sake.lossfunction.LossType;
import ink.sake.matrix.Matrix;
import ink.sake.parameter.Parameter;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetwork {

    NeuralLayer neuralLayer;
    Parameter parameter;
    ActivationFunction layerActivationFunction;
    ActivationType layerActivationType;
    List<NeuralLayer> layerList;
    List<Parameter> layerParameterList;

    double[] X;
    double[] layerX;
    double[] lossValue;
    double[] derivationLossValue;
    double[][] error;
    LossFunction lossFunction;
    LossType lossType;

    double[] Y;
    double[] derivationActivate;
    double[][] derivationWeight;
    double[] derivationBias;
    double[][] deltaWeight;
    double[] deltaBias;
    double learningRate;

    double correctRate = 0.0;
    double correct = 0.0;
    double mistake = 0.0;

    Matrix matrix;

    public NeuralNetwork(List<NeuralLayer> layerList){
        this.layerList = layerList;
        layerParameterList = new ArrayList<Parameter>();
        matrix = new Matrix();
        layerActivationFunction = new ActivationFunction();
    }

    public void init(){
        for(int i = 0;i < layerList.size();i++){
            neuralLayer = layerList.get(i);
            if(i == 0) {
                neuralLayer.setX(X);
            }else if(i > 0){
                layerX = layerList.get(i - 1).getActivate();
                neuralLayer.setX(layerX);
            }
                neuralLayer.init();
                neuralLayer.forwardPropagation();
                addParameterList(i);
        }
    }

    /**
    public void forwardPropagation(){
        for(int i = 0;i < layerList.size();i++){
            neuralLayer = layerList.get(i);
            if(i == 0) {
                neuralLayer.setX(X);
            }else if(i > 0){
                layerX = layerList.get(i - 1).getActivate();
                neuralLayer.setX(layerX);
            }
            neuralLayer.forwardPropagation();
            addParameterList(i);
        }
    }
     */

    private void setParameter(int index){
        parameter = layerParameterList.get(index);
        parameter.getParameter();
        parameter.setLayerWeight();
        parameter.setLayerBias();
    }

    public void addParameterList(int index){
        if(layerParameterList.size() < layerList.size()){
            parameter = new Parameter(layerList.get(index));
            parameter.getParameter();
            layerParameterList.add(parameter);
        }else {
            parameter = layerParameterList.get(index);
        }
    }

    public void addLayer(NeuralLayer neuralLayer){
        layerList.add(neuralLayer);
    }

    public double[] lossValue(double[] Y,LossType lossType){
        this.Y = Y;
        this.lossType = lossType;
        Parameter output = layerParameterList.get(layerParameterList.size()-1);
        output.getParameter();
        lossFunction = new LossFunction(lossType);
        return lossValue = lossFunction.lossValue(Y,output.getActivate());
    }

    public double lossTotal(double[] loss){
        double result = 0.0;
        for (int i = 0 ;i<loss.length;i++){
//            System.out.print(loss[i]+"  ");
            result = loss[i] + result;
        }
//        System.out.println();
        return result;
    }

    public double[] derivationLossValue(){
        Parameter output = layerParameterList.get(layerParameterList.size()-1);
        output.getParameter();
        lossFunction = new LossFunction(lossType);
        return derivationLossValue = lossFunction.derivationLossValue(Y,output.getActivate());
    }

    private double[] derivationActivationValue(int layerIndex){
        Parameter derivationActivation = layerParameterList.get(layerIndex);
        layerActivationFunction.setActivationType(layerActivationType);
        return derivationActivate = layerActivationFunction.derivationActivationValue(derivationActivation.getZ(),derivationActivation.getActivationType());
    }

    /**
    public double[][] derivationWeightValue(int layerIndex){
        double[][] result;
        double[][] weight;
        double[] derivationLossValue;
        double[] outError;
        double[][] outErrorMatrix;
        double[] z;
        double[] activate;
        double[] upZ;
        double[][] activateMatrix;
        double[] derivationSigmoid;
        double[] upDerivationSigmoid;
        double[][] derivationSigmoidMatrix;
        double[][] upDerivationSigmoidMatrix;
        double[][] tempMatrix;
        Parameter derivationWeight = layerParameterList.get(layerIndex);
        Parameter nextWeight;
        Parameter upWeight;
        layerActivationType = derivationWeight.getActivationType();
        activationFunction.setActivationType(layerActivationType);
        if(layerParameterList.size() - 1 == layerIndex){
            upWeight = layerParameterList.get(layerIndex - 1);
            weight = derivationWeight.getWeight();
            derivationLossValue = derivationLossValue();
            z = derivationWeight.getZ();
            activate = derivationWeight.getActivate();
            upZ = upWeight.getZ();
            activateMatrix = matrix.vectorToColumnMatrix(activate);
            derivationSigmoid = activationFunction.derivationActivationValue(z);
            upDerivationSigmoid = activationFunction.derivationActivationValue(upZ);
            upDerivationSigmoidMatrix = matrix.vectorToRowMatrix(upDerivationSigmoid);
            outError = matrix.elementProduct(derivationLossValue,derivationSigmoid);
            outErrorMatrix = matrix.vectorToColumnMatrix(outError);
            this.deltaWeight = outErrorMatrix;
            tempMatrix = matrix.multi(matrix.transpose(weight),deltaWeight);
            this.deltaWeight = matrix.elementProduct(tempMatrix,matrix.transpose(upDerivationSigmoidMatrix));
            result = matrix.multi(deltaWeight,matrix.transpose(activateMatrix));
            return matrix.transpose(result);
        }else if(layerIndex > 0) {
            upWeight = layerParameterList.get(layerIndex - 1);
            weight = derivationWeight.getWeight();
            activate = derivationWeight.getActivate();
            activateMatrix = matrix.vectorToColumnMatrix(activate);
            upZ = upWeight.getZ();
            upDerivationSigmoid = activationFunction.derivationActivationValue(upZ);
            upDerivationSigmoidMatrix = matrix.vectorToRowMatrix(upDerivationSigmoid);
            tempMatrix = matrix.multi(matrix.transpose(weight),deltaWeight);
            this.deltaWeight = matrix.elementProduct(tempMatrix,matrix.transpose(upDerivationSigmoidMatrix));
            result = matrix.multi(deltaWeight,matrix.transpose(activateMatrix));
            return matrix.transpose(result);
        }else {
            weight = derivationWeight.getWeight();
            activate = derivationWeight.getActivate();
            activateMatrix = matrix.vectorToColumnMatrix(activate);
            z = derivationWeight.getZ();
            derivationSigmoid = activationFunction.derivationActivationValue(z);
            derivationSigmoidMatrix = matrix.vectorToRowMatrix(derivationSigmoid);
            tempMatrix = matrix.multi(matrix.transpose(weight),deltaWeight);
            this.deltaWeight = matrix.elementProduct(tempMatrix,matrix.transpose(derivationSigmoidMatrix));
            result = matrix.multi(deltaWeight,matrix.transpose(activateMatrix));
            return matrix.transpose(result);
        }
    }
     */

    public double[][] derivationWeightValue(int layerIndex){
        double[][] nextWeight;
        double[] prevActivate;
        double[] x;
        double[][] inputMatrix;
        double[][] prevActivateMatrix;
        double[] derivationSigmoid;
        double[] prevDerivationSigmoid;
        Parameter parameter = layerParameterList.get(layerIndex);
        Parameter nextParameter;
        if(layerIndex == layerParameterList.size() - 1){
            derivationLossValue = derivationLossValue();
            prevActivate = parameter.getX();
            prevActivateMatrix = matrix.vectorToColumnMatrix(prevActivate);
            prevDerivationSigmoid = derivationActivationValue(layerParameterList.size() - 1);
            this.deltaWeight = delta(derivationLossValue,prevDerivationSigmoid);
            return matrix.multi(deltaWeight,matrix.transpose(prevActivateMatrix));
        }else if(layerIndex > 0 & layerIndex < layerParameterList.size() - 1) {
            nextParameter = layerParameterList.get(layerIndex + 1);
            nextWeight = nextParameter.getWeight();
            prevActivate = parameter.getX();
            prevActivateMatrix = matrix.vectorToColumnMatrix(prevActivate);
            derivationSigmoid = derivationActivationValue(layerIndex);
            this.deltaWeight = delta(nextWeight,deltaWeight,derivationSigmoid);
            return matrix.multi(deltaWeight,matrix.transpose(prevActivateMatrix));
        }else {
            nextParameter = layerParameterList.get(layerIndex + 1);
            nextWeight = nextParameter.getWeight();
            x = parameter.getX();
            inputMatrix = matrix.vectorToColumnMatrix(x);
            derivationSigmoid = derivationActivationValue(layerIndex);
            this.deltaWeight = delta(nextWeight,deltaWeight,derivationSigmoid);
            return matrix.multi(deltaWeight,matrix.transpose(inputMatrix));
        }
    }

    private double[][] delta(double[] delta,double[] derivationSigmoid){
        return matrix.vectorToColumnMatrix(matrix.elementProduct(derivationSigmoid,delta));
    }

    private double[][] delta(double[][] weight,double[][] delta,double[] derivationSigmoid){
        double[][] result = matrix.multi(matrix.transpose(weight),delta);
        return matrix.elementProduct(result,matrix.vectorToColumnMatrix(derivationSigmoid));
    }

    /**
    public double[] derivationBiasValue(int layerIndex){
        double[] result;
        double[][] weight;
        double[] z;
        double[] derivationSigmoid;
        double[][] tempMatrix;
        double[] tempVector;
        Parameter derivationBias = layerParameterList.get(layerIndex);
        Parameter nextBias;
        layerActivationType = derivationBias.getActivationType();
        activationFunction.setActivationType(layerActivationType);
        if(layerParameterList.size() - 1 == layerIndex){
            result = derivationLossValue();
            return this.deltaBias = result;
        }else if(layerIndex > 0){
            nextBias = layerParameterList.get(layerIndex + 1);
            weight = nextBias.getWeight();
            z = derivationBias.getZ();
            derivationSigmoid = activationFunction.derivationActivationValue(z);
            tempMatrix = matrix.multi(matrix.transpose(weight),matrix.vectorToColumnMatrix(deltaBias));
            tempVector = matrix.matrixToVector(tempMatrix);
            result = matrix.elementProduct(tempVector,derivationSigmoid);
            return this.deltaBias = result;
        }else {
            nextBias = layerParameterList.get(layerIndex + 1);
            weight = nextBias.getWeight();
            z = derivationBias.getZ();
            derivationSigmoid = activationFunction.derivationActivationValue(z);
            tempMatrix = matrix.multi(matrix.transpose(weight),matrix.vectorToColumnMatrix(deltaBias));
            tempVector = matrix.matrixToVector(tempMatrix);
            result = matrix.elementProduct(tempVector,derivationSigmoid);
            return this.deltaBias = result;
        }
    }
     */

    public double[] derivationBiasValue(int layerIndex){
        double[] result;
        double[][] weight;
        double[] derivationSigmoid;
        Parameter nextBias;
        if(layerParameterList.size() - 1 == layerIndex){
            return this.deltaBias = derivationLossValue;
        }else{
            nextBias = layerParameterList.get(layerIndex + 1);
            weight = nextBias.getWeight();
            derivationSigmoid = derivationActivationValue(layerIndex);
            result = delta(weight,deltaBias,derivationSigmoid);
            return this.deltaBias = result;
        }
    }

    private double[] delta(double[][] weight,double[] deltaBias,double[] derivationSigmoid){
        double[][] result = matrix.multi(matrix.transpose(weight),matrix.vectorToColumnMatrix(deltaBias));
        double[] resultVector = matrix.matrixToVector(result);
        return matrix.elementProduct(resultVector,derivationSigmoid);
    }

    public void backpropagation(){
        for(int i = layerParameterList.size() - 1 ;i >= 0;i--){
            parameter = layerParameterList.get(i);
            this.derivationWeight = derivationWeightValue(i);
            this.derivationBias = derivationBiasValue(i);
            parameter.setDimensionWeight(derivationWeight);
            parameter.setDimensionBias(derivationBias);
        }
    }

    public void setLearningRate(double learningRate){
        this.learningRate = learningRate;
    }

    public void update(){
        double[][] weight;
        double[][] newWeight;
        double[] bias;
        double[] newBias;
        double[][] tempWeight;
        double[] tempbias;
        for(int i = layerParameterList.size()-1; i >= 0;i--){
            parameter = layerParameterList.get(i);
            neuralLayer = layerList.get(i);
            weight = neuralLayer.getWeight();
            bias = neuralLayer.getBias();
            deltaWeight = parameter.getDimensionWeight();
            deltaBias = parameter.getDimensionBias();
            tempWeight = matrix.multi(deltaWeight,learningRate);
            newWeight = matrix.sub(weight,tempWeight);
            tempbias = matrix.multi(deltaBias,learningRate);
            newBias = matrix.sub(bias,tempbias);
            parameter.setNewWeight(newWeight);
            parameter.setNewBias(newBias);
            parameter.setLayerWeight();
            parameter.setLayerBias();

//            System.out.println("update ew weight: "+newWeight[0][0]);

        }
    }

    public void input(double[] X){
        this.X = X;
    }

    public void output(int i,double Y){
        double[] result;
        int maxIndex;
        neuralLayer = layerList.get(layerList.size()-1);
        result = neuralLayer.getActivate();
        maxIndex = matrix.maxVectorIndex(result);

        if(maxIndex == Y){
            correct++;
            correctRate = correct / (i + 1);
        }else {
            mistake = i - correct;
        }
        System.out.println("第 "+i+" 个 "+"OUTPUT:  "+ maxIndex+"  "+" 期望："+Y +" | 正确数： "+correct+" | 错误数： "+mistake+" | losstotal: "+lossTotal(lossValue)+" | 正确率： "+ correctRate);
    }
}
