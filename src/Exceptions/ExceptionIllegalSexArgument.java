package Exceptions;
/***
 * @apiNote Экземпляр класса генерируемого исключения ошибки указания символа пола человека
 */
public class ExceptionIllegalSexArgument extends Exception{
    public ExceptionIllegalSexArgument(){
        super("Ошибка в указании знака определяющего пол человека в качестве аргумента!\nДопускается указание пола 'm' или 'f'");
    }
    public ExceptionIllegalSexArgument(String message){
        super(message);
        System.out.println(message);
    }
}
