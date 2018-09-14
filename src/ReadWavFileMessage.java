import java.io.*;

/**
 * Created by Chen Lei on 2018/9/11.
 * 读取.wav格式的音频文件的信息
 */
public class ReadWavFileMessage {
    private static ReadWavFileMessage instace;
    private BufferedInputStream bis;
    private File file;
    private int wavFileHeaderLength=0;

    private ReadWavFileMessage(File file){
        this.file=file;

    }

    /**
     * 单例模式创建文件读取对象
     * @param file 文件名
     * @return 对象实例
     */
    public static ReadWavFileMessage getInstace(File file){
        if(instace==null){
            instace=new ReadWavFileMessage(file);
        }
        return instace;
    }

    /**
     * 读取文件头信息
     */
    public void readWavFileHeaderMessage(){
        try {
            bis=new BufferedInputStream(new FileInputStream(file));
            //解析文件头信息
            Config.RIFF=new String(readBytes(Config.RIFF_LENGTH));
            Config.NEXT_ADDRESS_SIZE=Util.bytesToLong(readBytes(Config.NEXT_ADDRESS_SIZE_LENGTH));
            Config.WAVE=new String(readBytes(Config.WAVE_LENGTH));
            Config.FMT=new String(readBytes(Config.FMT_LENGTH));
            Config.FILTER_BYTES=(int)Util.bytesToLong(readBytes(Config.FILTER_BYTES_LENGTH));
            Config.TYPE_FORMAT=(int)Util.bytesToLong(readBytes(Config.TYPE_FORMAT_LENGTH));
            Config.CHANNEL_NUMBER=(int)Util.bytesToLong(readBytes(Config.CHANNEL_NUMBER_LENGTH));
            Config.SAMPLING_FREQUENCY=Util.bytesToLong(readBytes(Config.SAMPLING_FREQUENCY_LENGTH));
            Config.TRANSMISSION_RATE=Util.bytesToLong(readBytes(Config.TRANSMISSION_RATE_LENGTH));
            Config.DATA_SIZE=(int)Util.bytesToLong(readBytes(Config.DATA_SIZE_LENGTH));
            Config.PCM_BIT_WIDTH=(int)Util.bytesToLong(readBytes(Config.PCM_BIT_WIDTH_LENGTH));
            Config.ADDITIONAL_INFORMATION=(int)Util.bytesToLong(readBytes(Config.ADDITIONAL_INFORMATION_LENGTH));
            Config.DATA_FLAG=new String(readBytes(Config.DATA_FLAG_LENGTH));
            Config.AUDIO_DATA_SIZE=Util.bytesToLong(readBytes(Config.AUDIO_DATA_SIZE_LENGTH));

            //显示文件头信息
            Config.showWavFileMessage();
            System.out.println(wavFileHeaderLength);

            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取文件体中的音频信息
     */
    public void readWavFileAudioMessage(readFileCallback readFileCallback){
        wavFileHeaderLength=0;
        readWavFileHeaderMessage();
        int len=0;

        try {
            bis=new BufferedInputStream(new FileInputStream(file));
            //过滤头文件信息
            for (int i=0;i<wavFileHeaderLength;i++){
                bis.read();
            }
            //读取文件体信息
            while((len=bis.read())!=-1){
                readFileCallback.readFile(len);
            }
            bis.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从文件中读取length个长度的字节
     * @param length
     * @return
     */
    private byte[] readBytes(int length){
        wavFileHeaderLength+=length;
        byte[] bytes=new byte[length];

        try {
            if(bis.read(bytes)!=length)
                throw new IOException("数据异常0.0");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    /**
     * 文件读取回调接口
     */
    public interface readFileCallback{
        void readFile(int i);
    }
}
