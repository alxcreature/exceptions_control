package DataTypes;

import Exceptions.ExceptionBadDateFormat;
import Exceptions.ExceptionBadFullName;
import Exceptions.ExceptionBadNumberArguments;
import Exceptions.ExceptionBadPhoneNumberFormat;
import Exceptions.ExceptionIllegalSexArgument;
/***
 * @apiNote Класс структуры и обработки данных записи/записей
 */
public class DataRecordType {
    private String firstName;
    private String secondName;
    private String lastName;
    private String dateBirth;
    private long phoneNumber;
    private char sex;

    public String getDateBirth() {
        return dateBirth;
    }
    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    /**
     * Метод парсит введённую строку с консоли, разбивает на аргументы, в качестве разделителя 'пробел' и генерирует исключения если аргументы не соответствуют шаблону
     * @param dataRecord Строка аргументов разделёнными пробелом
     * @throws ExceptionBadNumberArguments Если количество аргументов не равно '6'
     * @throws ExceptionIllegalSexArgument Если неверно указан символ пола 'm' или 'f'
     * @throws ExceptionBadPhoneNumberFormat Если некорректно указан международный номер телефона
     * @throws ExceptionBadDateFormat Если формат даты некорректный или не соответствует шаблону 'DD.MM.YYYY'
     * @throws ExceptionBadFullName Если ФИО содержит символы отличные от кириллицы
     */
    public void parseStringToDataRecord(String dataRecord) throws ExceptionBadNumberArguments,ExceptionIllegalSexArgument, ExceptionBadPhoneNumberFormat, ExceptionBadDateFormat, ExceptionBadFullName{
        String[] tempStrings = (dataRecord).split(" ");
        if (tempStrings.length>6){
            throw new ExceptionBadNumberArguments("Количество аргументов ["+ tempStrings.length +"] больше допустимого количества аргументов [6]!");
        }
        if (tempStrings.length<6) {
            throw new ExceptionBadNumberArguments("Количество аргументов [" + tempStrings.length + "] меньше допустимого количества аргументов [6]!");
        }
        if (tempStrings[0].matches("[а-яёА-ЯЁ]+") && tempStrings[1].matches("[а-яёА-ЯЁ]+") && tempStrings[2].matches("[а-яА-Я]+")){
            this.firstName=tempStrings[0];
            this.secondName=tempStrings[1];
            this.lastName=tempStrings[2];
        } else {
            throw new ExceptionBadFullName("ИСКЛЮЧЕНИЕ: ФИО '" +tempStrings[0]+ " "+tempStrings[1]+" "+ tempStrings[2]+ "' содержит недопустимые символы!");
        }
        if (isDate(tempStrings[3])) this.dateBirth=tempStrings[3];
        else {
            throw new ExceptionBadDateFormat("ИСКЛЮЧЕНИЕ: Дата '" + tempStrings[3] + "' не соответствует шаблону DD.MM.YYYY!");
        }

        if (isNumber(tempStrings[4]) && tempStrings[4].length()<13 && tempStrings[4].length()>10) this.phoneNumber=Long.parseLong(tempStrings[4]);
        else {
            throw new ExceptionBadPhoneNumberFormat("ИСКЛЮЧЕНИЕ: Номер телефона '"+ tempStrings[4] +"' не соответствует шаблону от 11 до 13 цифр 0..991234567890");
        }

        if (tempStrings[5].length()==1 && (tempStrings[5].charAt(0)=='m' || tempStrings[5].charAt(0)=='f')) {
            this.sex=tempStrings[5].charAt(0);
        } else {
            throw new ExceptionIllegalSexArgument("ИСКЛЮЧЕНИЕ: Недопустимый аргумент указания пола (m или f): '"+ tempStrings[5]+"'");
        }
    }

    /**
     * Метод проверяет корректность и соответствие шаблону даты
     * @param date строка даты формата 'DD.MM.YYYY'
     * @return Истина в случае корректности
     */
    private boolean isDate(String date){
        int[] daysPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] parseDate = date.split("\\.");
        if (!isNumber(parseDate[0]) || !isNumber(parseDate[1]) || !isNumber(parseDate[2])) return false;
        int year = Integer.parseInt(parseDate[2]);
        int month = Integer.parseInt(parseDate[1])-1;
        int day = Integer.parseInt(parseDate[0]);
        if (year > 1584 && ((year % 400 == 0) || year % 4 == 0 && year % 100 != 0)) daysPerMonth[1]++;
        if ((month>11) || (day>daysPerMonth[month]) || (year<1974) || (year>2099)) return false;
        return true;
    }
    /**
     * Метод проверки является ли строка числом
     * @param number строка содержащая символы чисел
     * @return Истина в случае если без ошибок
     */
    private boolean isNumber(String number){
        // try {
        //     @SuppressWarnings("unused")
        //     long longNumber = Long.parseLong(number);
        // } catch (NumberFormatException e) {
        //     return false;
        // }
        // return true;
        if (number.matches("[0-9]+")) return true;
        return false;
    }
}
