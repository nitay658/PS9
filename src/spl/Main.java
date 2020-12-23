package spl;

import java.io.IOException;

public class Main {



    public static void foo() throws IOException{
        Resource r = new Resource();
        r.read();
    }

    public static void tryFinally1() throws IOException{
        Resource r = new Resource();
        try{
            System.out.println(r.read());
        }catch(IOException e){
            throw e;
        }
        finally{
            try{
                r.close();
            }catch(IOException e){
                throw e; //only this one? WOW
            }
        }
    }

    public static void tryFinally2() throws IOException{
        IOException err = null;
        Resource r = new Resource();
        try{
            System.out.println(r.read());
        }catch(IOException e){
            err = e;
        }
        finally{
            try{
                r.close();
            }catch(IOException e){
                if(err!=null){
                    err.addSuppressed(e);
                }else{
                    err = e;
                }
            }finally{
                if(err!=null){
                    throw err;
                }
            }
        }
    }

    public static void tryWithResources() throws IOException{
        try(Resource r = new Resource()){
            System.out.println(r.read());
        }catch(IOException e){
            throw e;
        }

    }

    public static int finallyExample(){
        try{
            return 1;
        }
        finally {
            System.out.println("Should print anyway");
        }
    }

    public static void access(){
        try{
            //tryFinally1();
            //tryFinally2();
            tryWithResources();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        int x = finallyExample();
//        System.out.println(x);
        access();
    }
}
