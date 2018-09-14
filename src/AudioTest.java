import java.io.*;

/**
 * Created by Chen Lei on 2018/9/11.
 *
 */
public class AudioTest {

    public final static void main(String[] args){
//        String filePath="C:\\Users\\29420\\Desktop\\11.wav";
//        File file=new File(filePath);
//        ReadWavFileMessage rfm=ReadWavFileMessage.getInstace(file);
//        rfm.readWavFileHeaderMessage();
        //===================================================
        String filePath1="C:\\Users\\29420\\Desktop\\55.txt";
        File file1=new File(filePath1);

        try {
            if(!file1.exists()){
                file1.createNewFile();
            }
            FileOutputStream fos=new FileOutputStream(file1);
            PrintWriter  pw=new PrintWriter (fos);




            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
