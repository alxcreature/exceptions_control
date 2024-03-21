package Exceptions;
/***
 * @apiNote Экземпляр класса генерируемого исключения ошибки автоматического закрытия входящего потока консоли терминала
 */
public class ExceptionConsoleClose extends Exception{
    public ExceptionConsoleClose (){
        super("Не могу закрыть входящий поток консоли!");
    }
    public ExceptionConsoleClose(String message){
        super(message);
    }
}
