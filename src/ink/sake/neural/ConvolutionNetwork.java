package ink.sake.neural;

import ink.sake.activation.ActivationType;

import java.util.*;

public class ConvolutionNetwork {

    List<ConvolutionLayer> convolutionLayerList;
    List<Pooling> poolingList;
    double[][] input ;
    int kernelSize;
    int stride;
    int poolingKernelStride;
    ActivationType activationType;
    PoolingType poolingType;
    ConvolutionLayer convolutionLayer;
    Pooling pooling;
    public ConvolutionNetwork(){
        convolutionLayerList = new ArrayList<ConvolutionLayer>();
        poolingList = new ArrayList<Pooling>();
    }

    public ConvolutionNetwork getLayerActivateParemeter(){
        if(poolingList != null){
           pooling = poolingList.get(poolingList.size()-1);
        }
        return this;
    }
    public double[][] getPoolingActivate(){
        return pooling.getPoolingLayerActivate();
    }
    public ConvolutionNetwork input(double[][] input){
        this.input = input;
        return this;
    }
    public ConvolutionNetwork setConvolutionLayerParemeter(int kernelSize,int stride,int poolingKernelStride,ActivationType activationType,PoolingType poolingType){
        this.kernelSize = kernelSize;
        this.stride = stride;
        this.poolingKernelStride = poolingKernelStride;
        this.activationType = activationType;
        this.poolingType = poolingType;
        return this;
    }
    public ConvolutionNetwork build(){

        return this;
    }

    public ConvolutionNetwork create(){

        ConvolutionLayer convolutionLayer = new ConvolutionLayer(input,kernelSize,stride);
        convolutionLayer.createConvolutionLayer()
                .activate(activationType);
        Pooling pooling = new Pooling(convolutionLayer.getConvolutionLayerActivate(),poolingKernelStride);
        pooling.createPooling(poolingType)
                .activate(activationType);

        convolutionLayerList.add(convolutionLayer);
        poolingList.add(pooling);
        return this;
    }
}
