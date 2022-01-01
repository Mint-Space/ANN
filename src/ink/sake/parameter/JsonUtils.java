package ink.sake.parameter;

import javax.swing.text.Style;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class JsonUtils {

    Object data;

    char braceLeft = '{';
    char braceRight = '}';
    char squareBracketsLeft = '[';
    char squareBracketsRight = ']';
    char colon = ':';
    char comma = ',';
    char doubleQuotationMarks = '"';

    public JsonUtils(Object data){
        this.data = data;
    }

    public void createJson(){
        try{

            String result;
            Field name = data.getClass().getDeclaredField("neuralNumber");
            name.setAccessible(true);
            result = doubleQuotationMarks + name.getName() + doubleQuotationMarks + colon + doubleQuotationMarks + name.getInt(data) + doubleQuotationMarks;
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getIntField(String fieldName,Object objectName){
        try{
            String result;
            Field field = objectName.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            result = doubleQuotationMarks + fieldName + doubleQuotationMarks + colon + doubleQuotationMarks + field.getInt(objectName) + doubleQuotationMarks;

            System.out.println(result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getDoubleVectorField(String fieldName,Object objectName){
        String result = "";
        try{
            Field fields = objectName.getClass().getDeclaredField(fieldName);
            fields.setAccessible(true);
            Object doubleVector = fields.get(objectName);
            result = doubleQuotationMarks + fieldName + doubleQuotationMarks + colon + squareBracketsLeft;
            int vectorlength = Array.getLength(doubleVector);
            for (int i = 0; i < vectorlength; i++) {
                Object vector = Array.getDouble(doubleVector,i);
                double vectorTemp = (double)vector;
                result += vectorTemp;
                if(i < vectorlength-1){
                    result += comma;
                }
            }
            result += squareBracketsRight;
//            System.out.println(result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
    }
    public String getDoubleMatrixField(String fieldName,Object objectName){
        String result = "";
        try{
            Field fields = objectName.getClass().getDeclaredField(fieldName);
            fields.setAccessible(true);
            Object doubleMatrix = fields.get(objectName);
            result = doubleQuotationMarks + fieldName + doubleQuotationMarks + colon + squareBracketsLeft;
            int row = Array.getLength(doubleMatrix);
            int column = Array.getLength(Array.get(doubleMatrix,0));
            for (int i = 0; i < row; i++) {
                result += squareBracketsLeft;
                for (int j = 0; j < column; j++) {
                    Object matrix = Array.getDouble(Array.get(doubleMatrix,i),j);
                    double matrixTemp = (double)matrix;
                    result += matrixTemp;
                    if(j < column-1){
                        result += comma;
                    }else {
                        result += squareBracketsRight;
                    }
                }
                if(i < row-1){
                    result += comma;
                }else {
                    result += squareBracketsRight;
                }
            }
//            System.out.println(result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }
    }
}
