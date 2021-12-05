# ANN
使用Java类构建ANN


    X = MnistRead.getImagesBinarization(MnistRead.TRAIN_IMAGES_FILE);
            Y = MnistRead.getLabels(MnistRead.TRAIN_LABELS_FILE);
    
            NeuralLayer neuralLayer = new NeuralLayer()
                    .createNeuralLayer(784, ActivationType.Sigmoid)
                    .createNeuralLayer(800, ActivationType.Sigmoid)
                    .createNeuralLayer(10, ActivationType.Sigmoid);
    
            NeuralNetwork neuralNetwork = new NeuralNetwork(neuralLayer.getLayerList());
            neuralNetwork.setDataSet(X, Y)
                    .setLearningRate(0.045)
                    .setLossType(LossType.LeastSquaresMethod)
                    .setDesireTheCorrectRate(0.7)
                    .train();
                    
创建网络层和网络
设置数据集和学习率以及误差函数
RUN就运行了

训练准确率为72.8%。 ^_^