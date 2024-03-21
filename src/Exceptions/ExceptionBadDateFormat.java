package Exceptions;
/***
 * @apiNote Экземпляр класса генерируемого исключения ошибки указания некорректного формата даты
 */
public class ExceptionBadDateFormat extends Exception{
    public ExceptionBadDateFormat(){
        super("ИСКЛЮЧЕНИЕ: Дата не соответствует шаблону DD.MM.YYYY!");
    }
    public ExceptionBadDateFormat(String message){
        super(message);
        System.out.printf(message);
    }
}
