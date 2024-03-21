package Adapters;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import DataTypes.DataRecordType;
import Interfaces.InterfaceDataReader;
import Interfaces.InterfaceDataWriter;
/***
 * @apiNote Класс механики работы с данными через файлы
 */
public class AdapterDataFileReaderWriter implements InterfaceDataReader,InterfaceDataWriter{
    private DataRecordType record = new DataRecordType();
    private String fileName = "";
    public AdapterDataFileReaderWriter(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public int DataWrite(DataRecordType data) {
        this.record=data;
        //Пишем в файл с кодировкой UTF-8
        try (FileWriter file = new FileWriter(fileName+".txt",StandardCharsets.UTF_8,true)) {
            StringBuilder sb = new StringBuilder();
            
            sb.append("<"+this.record.getFirstName()+">");
            sb.append(" ");
            sb.append("<"+this.record.getSecondName()+">");
            sb.append(" ");
            sb.append("<"+this.record.getLastName()+">");
            sb.append(" ");
            sb.append("<"+this.record.getDateBirth()+">");
            sb.append(" ");
            sb.append("<"+this.record.getPhoneNumber()+">");
            sb.append(" ");
            sb.append("<"+this.record.getSex()+">\r\n");
            file.write(sb.toString());
            file.flush();
        } catch (IOException e) {
            System.out.println("Не могу открыть файл '" + fileName + "'для записи!");
            e.printStackTrace();
            return -1;
        }
        return 1;
    }
    @Override
    public DataRecordType DataRead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DataRead'");
    }
    public DataRecordType getRecord() {
        return record;
    }
    public void setRecord(DataRecordType record) {
        this.record = record;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
