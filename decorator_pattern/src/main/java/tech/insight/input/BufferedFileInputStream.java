package tech.insight.input;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class BufferedFileInputStream extends InputStream {


    private final byte[] buffer = new byte[8192];

    private int position = -1;

    private int capacity = -1;

    private final FileInputStream fileInputStream;

    public BufferedFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    @Override
    public int read() throws IOException {
        if (buffCanRead()) {
            return readFromBuffer();
        }
        refreshBuffer();
        if (!buffCanRead()) {
            return -1;
        }
        return readFromBuffer();
    }

    private int readFromBuffer() {
        return buffer[position++] & 0xFF;
    }


    private void refreshBuffer() throws IOException {
        capacity = this.fileInputStream.read(buffer);
        position = 0;
    }


    private boolean buffCanRead() {
        if (capacity == -1) {
            return false;
        }
        if (position == capacity) {
            return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        this.fileInputStream.close();
    }
}
