package by.bsuir.Shaliov;

import by.bsuir.Shaliov.common.model.BookService;
import by.bsuir.Shaliov.mysql.MysqlOption;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 *
 * @author ShaliovArtiom, TruntsVitalij
 */
public class MainServer {
    /**
     * Запросы MYSQL
     */
    public static MysqlOption service;
    /**
     *
     */
    public static BookService.Processor processor;
    /**
     * сокет сервера
     */
    private static TServerSocket serverTransport;

    /**
     * Функция, инициализирующая MYSQL запросы и функции для книги
     * @param arg массив строк
     */
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

    /**
     * Функция, реализующая общение сервера с клиентом
     * @param processor
     */
    private static void perform(BookService.Processor processor) {
        try {
            serverTransport = new TServerSocket(Integer.parseInt(ConfigReader.getPORT()));
            TServer server = new TSimpleServer(
                    new TServer.Args(serverTransport).processor(processor)
            );

            System.out.println("Starting " + Integer.parseInt(ConfigReader.getPORT()) + "...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
