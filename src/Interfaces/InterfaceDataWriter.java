package Interfaces;

import DataTypes.DataRecordType;

/***
 * @apiNote Интерфейс записи данных
 */
public interface InterfaceDataWriter {

    /**
     * Метод записи данных
     * @param data Класс структуры и обработки входящих данных записи
     * @return 0 - запись данных произведена успешно, -1 - запись данных не произведена по причине произошедшей ошибки
     */
    public int DataWrite(DataRecordType data);
}
