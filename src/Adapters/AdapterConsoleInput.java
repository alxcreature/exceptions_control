package Adapters;

import java.util.Scanner;

import Exceptions.ExceptionConsoleClose;
import Interfaces.InterfaceConsoleInput;
/***
 * @apiNote Класс интерфйса консоли терминалов входящего потока
 */
public class AdapterConsoleInput implements InterfaceConsoleInput,AutoCloseable {
    private Scanner console;
    //Для корректной работы с кодировкой кириллицы устанавливаем кодовую страницу 866
    public AdapterConsoleInput() {
        System.setProperty("console.encoding", "cp866");
        console = new Scanner(System.in, "cp866");
    }

    @Override
    public String ReadConsoleLine(String message) {
        System.out.println(message);
        return this.console.nextLine();
    }

    @Override
    public void close() throws ExceptionConsoleClose {
        try {
            console.close();
        } catch (Exception e) {
            throw new ExceptionConsoleClose("Не могу закрыть входящий поток консоли");
        }
        
    }
    
    
}
