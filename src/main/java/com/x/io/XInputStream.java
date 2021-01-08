package com.x.io;

import java.io.*;
import java.net.URL;

public class XInputStream {
    private String path = null;

    public XInputStream(String path) {
        URL url = this.getClass().getClassLoader().getResource(path);
        this.path = url.getPath();
        System.out.println(this.path);
    }

    public void readWithFileInputStreamReadAllBytes() {
        byte[] bytes = null;
        try (InputStream is = new FileInputStream(path)) {
            bytes = is.readAllBytes(); // JDK9以上
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWithFileInputStreamRead() {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        int len = 0;
        try (InputStream is = new FileInputStream(path)) {
            while ((len = is.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWithBufferInputStreamRead() {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024];
        int len = 0;
        try (InputStream is = new FileInputStream(path);
             BufferedInputStream bis = new BufferedInputStream(is)) {
            while ((len = bis.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len));
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
