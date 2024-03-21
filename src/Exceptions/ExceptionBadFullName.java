package Exceptions;
/***
 * @apiNote Экземпляр класса генерируемого исключения ошибки указания ФИО символами отличными от кириллицы
 */
public class ExceptionBadFullName extends Exception{
    public ExceptionBadFullName(){
        super("ИСКЛЮЧЕНИЕ: ФИО содержит недопустимые символы!");
    }
    public ExceptionBadFullName (String message){
        super(message);
        System.out.println(message);
    }
    
}
