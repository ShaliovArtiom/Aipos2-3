package by.bsuir.Shaliov.service;

import by.bsuir.Shaliov.ConfigReader;
import by.bsuir.Shaliov.common.model.BookService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.json.simple.parser.ParseException;

/**
 * Класс, реализующий соединение клиента с сервером
 * @author ShaliovArtiom, TruntsVitalij
 */
public class TransporConnector {
    /**
     * поле, предназначенное для создания единственного экземпляра класса
     */
    private static TransporConnector instance = null;
    /**
     * сокет клиента
     */
    private TTransport transport = null;
    /**
     * клиент из BookService
     */
    private BookService.Client client;

    /**
     * Конструктор, создающий сокету по необходимому порту и пути
     * @throws ParseException ошибка чтения config.json
     */
    public TransporConnector() throws ParseException {
        transport = new TSocket(ConfigReader.getURL(), Integer.parseInt(ConfigReader.getPORT()));
    }

    /**
     * Функция, реализующая открытие соединения клиента с сервером
     */
    public void openConnection() {
        try {
            transport.open();
            setTransportProtocol();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    /**
     * Функция закрытия соединения клиента с сервером
     */
    public void closeConnection() {
        transport.close();
    }

    /**
     * Функиця установления транспортного протокола
     */
    private void setTransportProtocol() {
        TProtocol protocol = new TBinaryProtocol(transport);
        client = new BookService.Client(protocol);
    }

    /**
     * Функция проверки единственности базы данных
     * @return возвращение значения instance
     */
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