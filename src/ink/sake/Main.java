package ink.sake;

import ink.sake.activation.ActivationType;
import ink.sake.dataset.MnistRead;
import ink.sake.lossfunction.LossType;
import ink.sake.matrix.ExtensionMatrix;
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
                {1,2,1,2},
                {3,2,1,3},
                {1,3,1,3}
        };
        double[][] B = {
                {1,0},
                {0,1}
        };
        ExtensionMatrix extensionMatrix = new ExtensionMatrix();
        double[][] C = extensionMatrix.featureMap(A,B,2);
//        System.out.println(Math.floorDiv(4,2));

//         int a = 9 ;
//         int b = 2;
//         int i = 0;
//
//         if(Math.floorMod(a,b) == 0){
//             i = a / b;
//            System.out.println(i);
//         }else {
//             i = a /b +1;
//             System.out.println(i);
//         }
//         System.out.println(i);
//        extensionMatrix.printMatrix();
    }
}
