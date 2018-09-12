import java.io.File;

/**
 * Created by Chen Lei on 2018/9/11.
 *
 */
public class AudioTest {

    public final static void main(String[] args){

        String filePath="C:\\Users\\29420\\Desktop\\11.wav";
        File file=new File(filePath);

        ReadWavFileMessage rfm=ReadWavFileMessage.getInstace(file);

//        rfm.readWavFileAudioMessage(new ReadWavFileMessage.readFileCallback() {
//            @Override
//            public void readFile(String str) {
//                System.out.println(str);
//            }
//        });

        rfm.readWavFileHeaderMessage();

    }
}
