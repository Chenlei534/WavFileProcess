/**
 * Created by Chen Lei on 2018/9/11.
 * 各种进制之间的转换
 */
public class Util {
    /**
     * 十六进制转换为十进制
     * @param hex 十六进制数
     * @return 十进制数
     */
    public static int hexToDecimal(String hex){
        return Integer.parseInt(hex,16);
    }

    /**
     * 十进制转换为十六进制
     * @param decimal 十进制
     * @return 十六进制
     */
    public static String decimalToHex(int decimal){
        return Integer.toHexString(decimal);
    }

    /**
     * 十进制转换为字符
     * @param decimal 十进制数
     * @return 字符
     */
    public static char decimalToChar(int decimal){
        return (char)decimal;
    }

    /**
     * 字符转换为十进制数
     * @param ch 字符
     * @return 十进制数
     */
    public static int charToDecimal(char ch){
        return ch;
    }

    /**
     * 字符串转换为十六进制数
     * @param string 字符串
     * @return 十六进制数
     */
    public static String stringToHex(String string){
        char[] ch=string.toCharArray();
        StringBuffer sb=new StringBuffer();

        for (int i=0;i<ch.length;i++) {
            sb.append(decimalToHex(charToDecimal(ch[i])));
        }

        return sb.toString();
    }

    /**
     * 十六进制数转换为字符串
     * @param hex 十六进制数
     * @return 字符串
     */
    public static String hexToString(String hex){
        StringBuffer sb=new StringBuffer();
        char[] ch=hex.toCharArray();

        for(int i=1;i<ch.length;i+=2){
            sb.append(decimalToChar(hexToDecimal(ch[i-1]+""+ch[i])));
        }

        return sb.toString();
    }

    /**
     * 比特转换为十六进制
     * @param b 比特
     * @return 十六进制
     */
    public static String byteToHex(byte b) {
        return Integer.toHexString(b & 0xFF);
    }

    /**
     * byte数组转换为长整数
     * @param bytes
     * @return 长整数
     */
    public static long bytesToLong(byte[] bytes){
        StringBuffer sb=new StringBuffer();
        for (int i=bytes.length-1;i>=0;i--){
            sb.append(Util.byteToHex(bytes[i]));
        }

        return Util.hexToDecimal(sb.toString());
    }
}
