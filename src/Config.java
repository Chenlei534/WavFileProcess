/**
 * Created by Chen Lei on 2018/9/11.
 * 参数配置
 */
public class Config {
    //wav音频文件头部各信息所占字节数
    public final static int RIFF_LENGTH=4;
    public final static int NEXT_ADDRESS_SIZE_LENGTH=4;
    public final static int WAVE_LENGTH=4;
    public final static int FMT_LENGTH=4;
    public final static int FILTER_BYTES_LENGTH=4;
    public final static int TYPE_FORMAT_LENGTH=2;
    public final static int CHANNEL_NUMBER_LENGTH=2;
    public final static int SAMPLING_FREQUENCY_LENGTH=4;
    public final static int TRANSMISSION_RATE_LENGTH=4;
    public final static int DATA_SIZE_LENGTH=2;
    public final static int PCM_BIT_WIDTH_LENGTH=2;
    public final static int ADDITIONAL_INFORMATION_LENGTH=2;
    public final static int DATA_FLAG_LENGTH=4;
    public final static int AUDIO_DATA_SIZE_LENGTH=4;
    //wav音频文件头部各信息
    public static String RIFF="";
    public static long NEXT_ADDRESS_SIZE=0l;
    public static String WAVE="";
    public static String FMT="";
    public static int FILTER_BYTES=0;
    public static int TYPE_FORMAT=0;
    public static int CHANNEL_NUMBER=0;
    public static long SAMPLING_FREQUENCY=0l;
    public static long TRANSMISSION_RATE=0l;
    public static int DATA_SIZE=0;
    public static int PCM_BIT_WIDTH=0;
    public static int ADDITIONAL_INFORMATION=0;
    public static String DATA_FLAG="";
    public static long AUDIO_DATA_SIZE=0l;

    /**
     * 控制台打印wav文件头相关信息
     */
    public static void showWavFileMessage(){
        StringBuilder sb=new StringBuilder();
        sb.append("资源交换文件标志（RIFF）："+RIFF+"\n")
                .append("下个地址到文件尾的总字节数（NEXT_ADDRESS_SIZE）："+NEXT_ADDRESS_SIZE+"\n")
                .append("WAV文件标志（WAVE）："+WAVE+"\n")
                .append("波形格式标志（FMT）："+FMT+"\n")
                .append("过滤字节（FILTER_BYTES）："+FILTER_BYTES+"\n")
                .append("格式种类（TYPE_FORMAT）"+TYPE_FORMAT+"\n")
                .append("通道数（CHANNEL_NUMBER）："+CHANNEL_NUMBER+"\n")
                .append("采样频率（SAMPLING_FREQUENCY）："+SAMPLING_FREQUENCY+"\n")
                .append("波形数据传输速率（TRANSMISSION_RATE）："+TRANSMISSION_RATE+"\n")
                .append("数据块的调整数（DATA_SIZE）："+DATA_SIZE+"\n")
                .append("PCM位宽（PCM_BIT_WIDTH）："+PCM_BIT_WIDTH+"\n")
                .append("附加信息（ADDITIONAL_INFORMATION）："+ADDITIONAL_INFORMATION+"\n")
                .append("数据标志符（DATA_FLAG）："+DATA_FLAG+"\n")
                .append("语音数据大小（AUDIO_DATA_SIZE）："+AUDIO_DATA_SIZE+"\n");
        System.out.println(sb.toString());
    }
}
