import Adapters.AdapterInterface;

/***
 * Основная программа начиается тут
 */
public class App {
    public static void main(String[] args) throws Exception {
        //Экземпляр интерфейса 
        AdapterInterface ai = new AdapterInterface();
        //Запуск механики работы программы
        ai.run();

    }
}
