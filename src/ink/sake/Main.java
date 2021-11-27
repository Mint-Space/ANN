package ink.sake;

import ink.sake.activation.ActivationType;
import ink.sake.dataset.MnistRead;
import ink.sake.lossfunction.LossType;
import ink.sake.matrix.Matrix;
import ink.sake.neural.NeuralLayer;
import ink.sake.neural.NeuralNetwork;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static double[][] X;
    static double[] Y;

    public static void main(String[] args) {
        X = MnistRead.getImagesBinarization(MnistRead.TRAIN_IMAGES_FILE);
        Y = MnistRead.getLabels(MnistRead.TRAIN_LABELS_FILE);
        double[][] y = getY(Y);
        NeuralLayer inputLayer = new NeuralLayer(784,ActivationType.Sigmoid);
        NeuralLayer hiddenLayerOne = new NeuralLayer(800,ActivationType.Sigmoid );
        NeuralLayer hiddenLayerTwo = new NeuralLayer(650,ActivationType.Sigmoid);
        NeuralLayer outputLayer = new NeuralLayer(10,ActivationType.Sigmoid);
        List<NeuralLayer> layerList = new ArrayList<NeuralLayer>();
        layerList.add(inputLayer);
        layerList.add(hiddenLayerOne);
        layerList.add(hiddenLayerTwo);
        layerList.add(outputLayer);

        NeuralNetwork neuralNetwork = new NeuralNetwork(layerList);
        neuralNetwork.setLearningRate(0.145);
        for(int i = 0;i < 5000;i++){
            neuralNetwork.input(X[i]);
            neuralNetwork.init();
            neuralNetwork.lossValue(setY((int)Y[i]), LossType.LeastSquaresMethod);
            neuralNetwork.output(i,Y[i]);
            neuralNetwork.backpropagation();
            neuralNetwork.update();
        }
    }

    public static double[] setY(int number) {
        double[] result = new double[10];
        result[number] = 1.0;
        return result;
    }

    public static double[][] getY(double[] Y){
        double[][] result = new double[Y.length][10];
        for(int i = 0;i < Y.length;i++){
            for(int j = 0;j < 10;j++){
                if(Y[i] == j){
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }
}
