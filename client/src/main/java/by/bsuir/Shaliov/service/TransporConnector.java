package by.bsuir.Shaliov.service;

import by.bsuir.Shaliov.ConfigReader;
import by.bsuir.Shaliov.common.service.BookService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.json.simple.parser.ParseException;

/**
 * @author ShaliovArtiom.
 */
public class TransporConnector {
    private static final String URL = "localhost";
    private static final int PORT = 4545;

    private static TransporConnector instance = null;

    private TTransport transport = null;
    private BookService.Client client;

    public TransporConnector() throws ParseException {
        transport = new TSocket(ConfigReader.getURL(), Integer.parseInt(ConfigReader.getPORT()));
    }

    public TransporConnector(String host, int port) {
        transport = new TSocket(host, port);
    }

    public void openConnection() {
        try {
            transport.open();
            setTransportProtocol();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        transport.close();
    }

    private void setTransportProtocol() {
        TProtocol protocol = new TBinaryProtocol(transport);
        client = new BookService.Client(protocol);
    }

    public static TransporConnector getInstance() throws ParseException {
        if (instance == null) {
            instance = new TransporConnector();
        }
        return instance;
    }

    public BookService.Client getClient() {
        return client;
    }


}