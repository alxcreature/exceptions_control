package Adapters;

import DataTypes.DataRecordType;
import Enumerators.Commands;
import Exceptions.ExceptionBadDateFormat;
import Exceptions.ExceptionBadFullName;
import Exceptions.ExceptionBadNumberArguments;
import Exceptions.ExceptionBadPhoneNumberFormat;
import Exceptions.ExceptionConsoleClose;
import Exceptions.ExceptionIllegalSexArgument;
/***
 * @apiNote Класс связывающий всемеханизмы приложения интерфейса и механики поведения
 */
public class AdapterInterface {
    /**
     * Метод запускает взаимодействие механики и интерфейса (консоли терминала)
     * @throws ExceptionConsoleClose В случае ошибки закрытия входящего потока консоли терминала
     */
    public void run() throws ExceptionConsoleClose{
        //Перечисления команд консоли
        Commands cmd = Commands.NONE;
        //Экземпляр консоли терминала
        AdapterConsoleInput con = new AdapterConsoleInput();
        String tempString;
        while (true){
            try {
                cmd = Commands.valueOf(con.ReadConsoleLine("Введите команду управления:").toUpperCase());
            }
            catch (IllegalArgumentException e){
                System.out.println("ОШИБКА: Такой команды не существует!");
                cmd = Commands.HELP;
            }
            switch (cmd) {
                case EXIT:
                    System.out.println("Выход из программы");
                    con.close();
                    return;
                case ADD:
                    DataRecordType record = new DataRecordType();
                    tempString=con.ReadConsoleLine("Введите запись формата: Фамилия Имя Отчество DD.MM.YYYY(дата рождения) номер_телефона пол(f,m)");
                    try {
                        record.parseStringToDataRecord(tempString);
                        AdapterDataFileReaderWriter adf = new AdapterDataFileReaderWriter(record.getFirstName());
                        if (adf.DataWrite(record)==-1) System.out.println("ОШИБКА: Не удалось произвести запись данных в файл!");
                    } catch (ExceptionBadNumberArguments e) {
                        e.printStackTrace();
                    } catch (ExceptionIllegalSexArgument e){
                        e.printStackTrace();
                    } catch (ExceptionBadPhoneNumberFormat e) {
                        e.printStackTrace();
                    } catch (ExceptionBadDateFormat e) {
                        e.printStackTrace();
                    } catch (ExceptionBadFullName e) {
                        e.printStackTrace();
                    }
                    break;
                case DEL:
                    break;
                case READ:
                    break;
                case WRITE:
                    break;
                case HELP:
                default:
                    System.out.println("Помощь:\nhelp\t- подсказка (это сообщение, по умолчанию).\nadd\t- добавить и произвести запись в файл данных согласно шаблону.\nexit\t- выход из программы.\ndel,read,write - не реализовано на текущий момент.");
                    break;
            }
        }
    }
}
