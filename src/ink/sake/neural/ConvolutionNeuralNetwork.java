package ink.sake.neural;

import ink.sake.matrix.ExtensionMatrix;
import ink.sake.matrix.Matrix;

public class ConvolutionNeuralNetwork {

    Matrix matrix ;
    ExtensionMatrix extensionMatrix ;

    public ConvolutionNeuralNetwork(){
        extensionMatrix = new ExtensionMatrix();
    }

    public void input(Matrix matrix){
        matrix = this.matrix;
    }

    public void build(){
    }
}
