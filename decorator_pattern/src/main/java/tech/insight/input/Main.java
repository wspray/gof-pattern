package tech.insight.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class Main {
    public static void main(String[] args) {
        File file = new File("jvm.pdf");
        long l = Instant.now().toEpochMilli();
        try (InputStream bufferedFileInputStream = new BufferedFileInputStream(new FileInputStream(file))) {
            while (true) {
                int bufferRead = bufferedFileInputStream.read();
                if (bufferRead == -1) {
                    break;
                }
            }
            System.out.println("用时:" + (Instant.now().toEpochMilli() - l) + "毫秒");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
