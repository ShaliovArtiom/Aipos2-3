package by.bsuir.Shaliov;

import by.bsuir.Shaliov.view.Window;

/**
 * @author ShaliovArtiom, TruntsVitalij
 */
public class MainClient {
    /**
     * Функция, генерирующая главное окно
     * @param argc массив строк, переданный на вход программе
     */
    public static void main(String[] argc) {
        Window window = new Window();
        window.bind();
    }
}
