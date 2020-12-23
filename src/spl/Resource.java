package spl;

import java.io.IOException;

public class Resource implements AutoCloseable {


    public Resource(){

    }

    public String read() throws IOException{
        throw new IOException("Can't read");
    }

    @Override
    public void close() throws IOException{
        //throw new IOException("Can't close");
        System.out.println("closing file");
    }
}
