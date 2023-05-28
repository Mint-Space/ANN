package ink.sake.parameter;

import ink.sake.activation.ActivationType;
import ink.sake.lossfunction.LossType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParameterUtils {

    public static final String SaveParameterPath = "DataSet/Parameter/";
    public static final String ReadParameterPath = "DataSet/Parameter/";

    String networkParameter = "";

    List<Parameter> parameterList;
    double[][] weight;
    double[] bias;
    int layerNeuralNumber;
    LossType lossType;
    ActivationType activationType;
    boolean isWriteSuccess = false;
    boolean isAppend = false;
    private String parameterFileName = "";
    private String fullPathName = "DataSet/Parameter/BestParameter_0.7532458874314572_2023年04月22日17时43分58秒.txt";

    JsonUtils jsonUtils = null;
    public ParameterUtils(){
    }
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



    public boolean read(String fullPathName) {
        boolean isFile = false;
        FileInputStream fileInputStream = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        String parameterString = "";
        try {
            fileInputStream = new FileInputStream(fullPathName);
            reader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(reader);
            String string = "";
            while(( string = bufferedReader.readLine())!=null){
                parameterString += string;
            }
            parsingParameters(parameterString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isFile;
    }

    public Parameter parsingParameters(String data){
        Parameter parameter = new Parameter();
//        JSONFunctions jsonFunctions = new JSONListAdapter(data);
        String[] dataArray = data.split("\\{|\\}",8);
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println(dataArray.length);
        for (int i = 0; i < dataArray.length; i++) {
            String[]  neuralNetworkParameterString= dataArray[i].split("NeuralNetworkParameter");
            for (int j = 0; j < neuralNetworkParameterString.length; j++) {
//                System.out.println(neuralNetworkParameterString[j]);
                
            }

        }
        System.out.println();
        return parameter;
    }

    public String getParameterFileName() {
        return parameterFileName;
    }

    public void setParameterFileName(String parameterFileName) {
        this.parameterFileName = parameterFileName;
    }
}
