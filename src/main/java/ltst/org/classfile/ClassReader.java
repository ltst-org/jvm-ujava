package ltst.org.classfile;

import java.io.IOException;
import java.io.InputStream;

/**
 * class 文件读取器
 */
public class ClassReader {
    private InputStream inputStream;


    public ClassReader(InputStream inputStream){
        this.inputStream  = inputStream;
    }
    public byte[] readU4(){
        return readByLength(4);
    }
    public byte[] readU2(){
        return readByLength(2);
    }
    public byte[] readN(int length){
        return readByLength(length);
    }
    public byte readU1() {return readByLength(1)[0];}

    private byte[] readByLength(int length){
        byte[] read = new byte[length];
        try {
            int readLength = inputStream.read(read);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return read;
    }
}
