package ink.sake.parameter;

import ink.sake.activation.ActivationType;
import ink.sake.lossfunction.LossType;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class ParameterUtils {

    public static final String SaveParameterPath = "DataSet/Parameter/";
    public static final String ReadParameterPath = "DataSet/Parameter/";

    List<Parameter> parameterList;
    double[][] weight;
    double[] bias;
    int layerNeuralNumber;
    LossType lossType;
    ActivationType activationType;
    boolean isWriteSuccess = false;
    boolean isAppend = false;
    private String parameterFileName = "";
    private String fullPathName = "";

    public ParameterUtils(List<Parameter> parameterList) {
        this.parameterList = parameterList;
    }

    public boolean writeParameter() {
        fullPathName = SaveParameterPath + parameterFileName;
        for (int i = 0; i <= parameterList.size() - 1; i++) {
            layerNeuralNumber = getLayerNeuralNumber(parameterList.get(i));
            weight = getLayerWeight(parameterList.get(i));
            bias = getLayerBias(parameterList.get(i));
            activationType = getLayerActivationType(parameterList.get(i));
            lossType = getLossType(parameterList.get(i));
            isAppend = i != 0;
            write(i, layerNeuralNumber, weight, bias, activationType, lossType, isAppend);
        }
        return isWriteSuccess;
    }

    private double[][] getLayerWeight(Parameter parameter) {
        return parameter.getWeight();
    }

    private double[] getLayerBias(Parameter parameter) {
        return parameter.getBias();
    }

    private int getLayerNeuralNumber(Parameter parameter) {
        return parameter.getNeuralNumber();
    }

    private ActivationType getLayerActivationType(Parameter parameter) {
        return parameter.getActivationType();
    }

    private LossType getLossType(Parameter parameter) {
        return parameter.getLossType();
    }

    private void write(int layerNumberIndex, int layerNeuralNumber, double[][] weight, double[] bias, ActivationType activationType, LossType lossType, boolean isAppend) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fullPathName, isAppend);
            if (lossType != null) {
                fileWriter.write("{\"NeuralNetworkParameter\":[LayerNumberIndex:" + layerNumberIndex + ",LayerNeuralNumber:" + layerNeuralNumber + ",ActivationType:" + activationType + ",LossType:" + lossType + "]}\r\n");
            } else {
                fileWriter.write("{\"NeuralNetworkParameter\":[LayerNumberIndex:" + layerNumberIndex + ",LayerNeuralNumber:" + layerNeuralNumber + ",ActivationType:" + activationType + "]}\r\n");
            }
            fileWriter.write("{\"Weight\":[" + weight.length + "][" + weight[0].length + "]\r\n");
            fileWriter.write("[");
            for (int i = 0; i < weight.length; i++) {
                fileWriter.write("[");
                for (int j = 0; j < weight[0].length; j++) {
                    fileWriter.write(String.valueOf(weight[i][j]));
                    fileWriter.write(",");
                }
                fileWriter.write("],\r\n");
            }
            fileWriter.write("]}\r\n");
            fileWriter.write("{\"Bias\":[" + bias.length + "]\r\n");
            fileWriter.write("[");
            for (int i = 0; i < bias.length; i++) {
                fileWriter.write(String.valueOf(bias[i]));
                fileWriter.write(",");
            }
            fileWriter.write("]}\r\n");
            fileWriter.flush();
            isWriteSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
            isWriteSuccess = false;
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                    isWriteSuccess = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                isWriteSuccess = false;
            }
        }
    }

    private boolean read() {
        boolean isFile = false;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fullPathName);
            if (fileReader.read() != -1) {
                isFile = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isFile;
    }

    public String getParameterFileName() {
        return parameterFileName;
    }

    public void setParameterFileName(String parameterFileName) {
        this.parameterFileName = parameterFileName;
    }
}
