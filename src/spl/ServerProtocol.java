package spl;

interface ServerProtocol {

    String processMessage(String msg);

    boolean isEnd(String msg);

}