package ink.sake.neural;

import ink.sake.matrix.ExtensionMatrix;
import ink.sake.matrix.Matrix;

public class ConvolutionNeuralNetwork {

    Matrix matrix ;
    ExtensionMatrix extensionMatrix ;

    public ConvolutionNeuralNetwork(){
        extensionMatrix = new ExtensionMatrix();
    }


    public void build(){
        matrix = new Matrix(3,3);
    }
    public double[][] input(double[][] A){
        extensionMatrix.featureMap(A,A,2);
        return null;
    }
}
