package spl;

import java.io.*;

public class FileFinally {

    public static void k(){
        throw new IllegalArgumentException("");
    }

    public static void main(String[] args){
        String name = args[0];
        BufferedReader file = null;
        try{
            file = new BufferedReader(new FileReader(name));
            String line = file.readLine();
            System.out.println(line);

            //handle FileNotFoundException
            //Note that FileNotFoundException is a type of (subclass of) IOException
        }catch (FileNotFoundException e) {
            System.out.println("File not found: "+ name);
            //handle IOException
        }catch (IOException e) {
            System.out.println("Problem: " + e);
            /*
            Reading a network file and got disconnected.
            Reading a local file that was no longer available.
            Using some stream to read data and some other process closed the stream.
            Trying to read/write a file, but don't have permission.
            Trying to write to a file, but disk space was no longer available.
             */
        }finally{
            if (file != null) {
                System.out.println("Closing the file:" + name);
                try {
                    file.close(); // May throw an exception by itself
                } catch (IOException ignore) {}
            } else {
                System.out.println("Unable to open file:" + name);
            }
        }
    }
}