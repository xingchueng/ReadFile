package com.meizu.example.readfile;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by zhangxing on 07/02.
 */
public class ReadFile {
    private File file;
    public ReadFile(File file){
        this.file = file;
    }

    public static byte readFirstByte(File file) throws IOException{
        byte[] buffer = new byte[128];
        DataInputStream data;
        try {
            data = new DataInputStream(new FileInputStream(file));
            data.read(buffer);
            if(buffer.length == 0){
                return -1;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return buffer[0];
    }
}
