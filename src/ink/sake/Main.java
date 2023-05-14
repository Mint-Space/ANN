package ink.sake;

import ink.sake.activation.ActivationType;
import ink.sake.dataset.MnistRead;
import ink.sake.lossfunction.LossType;
import ink.sake.matrix.ExtensionMatrix;
import ink.sake.matrix.Matrix;
import ink.sake.neural.NeuralLayer;
import ink.sake.neural.NeuralNetwork;
import ink.sake.parameter.JsonUtils;
import ink.sake.parameter.Parameter;

public class Main {
    static double[][] X;
    static double[] Y;

    public static void main(String[] args) throws Exception{
//        X = MnistRead.getImagesBinarization(MnistRead.TRAIN_IMAGES_FILE);
//        Y = MnistRead.getLabels(MnistRead.TRAIN_LABELS_FILE);
//
//        NeuralLayer neuralLayer = new NeuralLayer()
//                .createNeuralLayer(784, ActivationType.Sigmoid)
//                .createNeuralLayer(800, ActivationType.Sigmoid)
//                .createNeuralLayer(10, ActivationType.Sigmoid);
//
//        NeuralNetwork neuralNetwork = new NeuralNetwork(neuralLayer.getLayerList());
//        neuralNetwork.setDataSet(X, Y)
//                .setLearningRate(0.082)
//                .setLossType(LossType.LeastSquaresMethod)
//                .setDesireTheCorrectRate(0.72)
//                .train();

        double[][] A = {
                {4,3,4},
                {1,2,8},
                {9,2,4}
        };

        double[] B = {2,5,6,5,6,32,7};
        Matrix matrix = new Matrix();
        double[] b = matrix.not(B);
        matrix.printVector(b);
//        ExtensionMatrix e = new ExtensionMatrix();
//        double[][] a = e.averagePooling(A,2);
//        e.printMatrix(a);
//        System.out.print(a);

    }
}
