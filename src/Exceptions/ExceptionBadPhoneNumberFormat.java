package Exceptions;
/***
 * @apiNote Экземпляр класса генерируемого исключения ошибки указания неправильного номера телефона
 */
public class ExceptionBadPhoneNumberFormat extends Exception{
    public ExceptionBadPhoneNumberFormat(){
        super("ИСКЛЮЧЕНИЕ: Номер телефона не соответствует шаблону от 11 до 13 цифр 0..991234567890");
    }
    public ExceptionBadPhoneNumberFormat(String message){
        super(message);
        System.out.println(message);
    }
    
}
