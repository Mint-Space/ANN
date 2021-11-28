# ANN
使用Java类构建ANN


    X = MnistRead.getImagesBinarization(MnistRead.TRAIN_IMAGES_FILE);
    Y = MnistRead.getLabels(MnistRead.TRAIN_LABELS_FILE);

    NeuralLayer neuralLayer = new NeuralLayer()
        .createNeuralLayer(784,ActivationType.Sigmoid)
        .createNeuralLayer(800,ActivationType.Sigmoid)
        .createNeuralLayer(650,ActivationType.Sigmoid)
        .createNeuralLayer(10,ActivationType.Sigmoid);

    NeuralNetwork neuralNetwork = new NeuralNetwork(neuralLayer.getLayerList());
    neuralNetwork.setDataSet(X,Y)
        .setLearningRate(0.145)
        .setLossType(LossType.LeastSquaresMethod)
        .run();
        
创建网络层和网络
设置数据集和学习率以及误差函数
RUN就运行了

可惜学不出来效果。无法查证。求帮忙 ^_^