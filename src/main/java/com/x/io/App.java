package com.x.io;

public class App {
    public static void main(String[] args) {
        XInputStream xis = new XInputStream("file_1.txt");
        xis.readWithFileInputStreamRead();
        xis.readWithFileInputStreamReadAllBytes();
        xis.readWithBufferInputStreamRead();
    }
}
