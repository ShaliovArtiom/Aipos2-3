package by.bsuir.Shaliov;

import by.bsuir.Shaliov.common.service.BookService;
import by.bsuir.Shaliov.mysql.MysqlOption;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.io.IOException;
import java.net.Socket;

/**
 * @author ShaliovArtiom.
 */
public class Main {
    private static final int PORT = 4545;

    public static MysqlOption service;
    public static BookService.Processor processor;
    private static TServerSocket serverTransport;

    public static void main(String[] arg) {
        try {
            service = new MysqlOption();
            processor = new BookService.Processor(service);

            Runnable simple = () -> perform(processor);

            new Thread(simple).start();
        }catch (Exception x) {
            x.printStackTrace();
        }
    }

    private static void perform(BookService.Processor processor) {
        try {
            serverTransport = new TServerSocket(PORT);
            TServer server = new TSimpleServer(
                    new TServer.Args(serverTransport).processor(processor)
            );

            System.out.println("Starting " + PORT + "...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
