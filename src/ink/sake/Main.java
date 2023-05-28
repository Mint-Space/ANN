package ink.sake;

import ink.sake.activation.ActivationType;
import ink.sake.dataset.MnistRead;
import ink.sake.lossfunction.LossType;
import ink.sake.matrix.ExtensionMatrix;
import ink.sake.matrix.Matrix;
import ink.sake.neural.*;
import ink.sake.parameter.JsonUtils;
import ink.sake.parameter.Parameter;
import ink.sake.parameter.ParameterUtils;

public class Main {
    static double[][][] X;
    static double[] Y;

    public static void main(String[] args) throws Exception{
//        X = MnistRead.getImagesBinarization(MnistRead.TRAIN_IMAGES_FILE);
        X = MnistRead.getImagesMatrix(MnistRead.TRAIN_IMAGES_FILE);
        Y = MnistRead.getLabels(MnistRead.TRAIN_LABELS_FILE);
//        Matrix matrix = new Matrix();
//        matrix.printMatrix(X[0]);
//        NeuralLayer neuralLayer = new NeuralLayer()
//                .createNeuralLayer(784, ActivationType.RELU)
//                .createNeuralLayer(800, ActivationType.RELU)
//                .createNeuralLayer(10, ActivationType.RELU);
//
//        NeuralNetwork neuralNetwork = new NeuralNetwork(neuralLayer.getLayerList());
//        neuralNetwork.setDataSet(X, Y)
//                .setLearningRate(0.082)
//                .setLossType(LossType.LeastSquaresMethod)
//                .setDesireTheCorrectRate(0.72)
//                .train();


//        ParameterUtils p = new ParameterUtils();
//        p.read("DataSet/Parameter/BestParameter_0.7532458874314572_2023年04月22日17时43分58秒.txt");
//            p.parsingParameters();

//        double[][] A = {
//                {4,3,4},
//                {1,2,8},
//                {9,2,4}
//        };
//
//        ExtensionMatrix e = new ExtensionMatrix();
//        double[][] a = e.averagePooling(A,2);
//        e.printMatrix(a);
//        System.out.print(a);

//        ConvolutionLayer convolutionLayer = new ConvolutionLayer(X[0],3,1);
//        convolutionLayer.createConvolutionLayer().activate(ActivationType.Sigmoid);
//        Pooling pooling = new Pooling(convolutionLayer.getConvolutionLayerActivate(),2);
//        pooling.createPooling(PoolingType.MaxPooling).activate(ActivationType.Sigmoid);
//
//        ConvolutionLayer convolutionLayer1 = new ConvolutionLayer(pooling.getPoolingLayerActivate(), 5,1);
//        convolutionLayer1.createConvolutionLayer().activate(ActivationType.Sigmoid);
//        Pooling pooling1 = new Pooling(convolutionLayer1.getConvolutionLayerActivate(),2);
//        pooling1.createPooling(PoolingType.MaxPooling).activate(ActivationType.Sigmoid);

//        Matrix matrix  = new Matrix();
//        matrix.printMatrix(X[0]);
//        System.out.println();
//        matrix.printMatrix(convolutionLayer.getConvolutionLayer());
//        System.out.println();
//        matrix.printMatrix(convolutionLayer.getConvolutionLayerActivate());
//        System.out.println();
//        matrix.printMatrix(pooling.getPoolingLayer());
//        System.out.println();
//        matrix.printMatrix(pooling.getPoolingLayerActivate());
//
//        System.out.println();
//        matrix.printMatrix(convolutionLayer1.getConvolutionLayer());
//        System.out.println();
//        matrix.printMatrix(convolutionLayer1.getConvolutionLayerActivate());
//        System.out.println();
//        matrix.printMatrix(pooling1.getPoolingLayer());
//        System.out.println();
//        matrix.printMatrix(pooling1.getPoolingLayerActivate());

        ConvolutionNetwork cn =  new ConvolutionNetwork();
        cn.input(X[0])
                .setConvolutionLayerParemeter(3,1,2,ActivationType.Sigmoid,PoolingType.MaxPooling)
                .create()
                .input(cn.getLayerActivateParemeter().getPoolingActivate())
                .setConvolutionLayerParemeter(3,1,2,ActivationType.Sigmoid,PoolingType.MaxPooling)
                .create()
                .input(cn.getLayerActivateParemeter().getPoolingActivate())
                .setConvolutionLayerParemeter(3,1,2,ActivationType.Sigmoid,PoolingType.MaxPooling)
                .create();

    }
}
