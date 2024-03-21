package Exceptions;
/***
 * @apiNote Экземпляр класса генерируемого исключения ошибки указания неверного количества запрашиваемых аргументов
 */
public class ExceptionBadNumberArguments extends Exception{
    
    public ExceptionBadNumberArguments (){
        super("Недопустимое количество аргументов!");
    }

    public ExceptionBadNumberArguments(String message){
        super(message);
        System.out.println(message);
    }
}
