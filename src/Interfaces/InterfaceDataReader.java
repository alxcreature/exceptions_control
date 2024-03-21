package Interfaces;

import DataTypes.DataRecordType;

/***
 * @apiNote Интерфейс чтения данных записей
 */
public interface InterfaceDataReader {

    /**
     * Метод чтения данных записей
     * @return Класс структуры содержащий данные считанной записи/записей
     */
    public DataRecordType DataRead();
}
