package ink.sake;

import ink.sake.activation.ActivationType;
import ink.sake.dataset.MnistRead;
import ink.sake.lossfunction.LossType;
import ink.sake.neural.NeuralLayer;
import ink.sake.neural.NeuralNetwork;

public class Main {
    static double[][] X;
    static double[] Y;

    public static void main(String[] args) {
        X = MnistRead.getImagesBinarization(MnistRead.TRAIN_IMAGES_FILE);
        Y = MnistRead.getLabels(MnistRead.TRAIN_LABELS_FILE);

        NeuralLayer neuralLayer = new NeuralLayer()
                .createNeuralLayer(784, ActivationType.Sigmoid)
                .createNeuralLayer(800, ActivationType.Sigmoid)
                .createNeuralLayer(10, ActivationType.Sigmoid);

        NeuralNetwork neuralNetwork = new NeuralNetwork(neuralLayer.getLayerList());
        neuralNetwork.setDataSet(X, Y)
                .setLearningRate(0.085)
                .setLossType(LossType.LeastSquaresMethod)
                .setDesireTheCorrectRate(0.72)
                .train();
    }
}
