package Interfaces;
/***
 * Интерфейс чтения данных с консоли терминала
 */
public interface InterfaceConsoleInput {
    /**
     * Метод чтения данных с консоли и выводом сообщения
     * @param message выводимое сообщение
     * @return результат чтения ввода с консоли
     */
    public String ReadConsoleLine(String message);

}
