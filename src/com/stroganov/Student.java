package com.stroganov;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

    // id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.

    private  int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthday;
    private String adress;
    private String numberFhone;
    private Facultet facultet;
    private Integer course;
    private String group;
    private DateTimeFormatter dataTimeFormat = DateTimeFormatter.ofPattern("dd.M.yyyy");


    public Student(int id, String lastName, String firstName, String patronymic, String birthday, String adress, String numberPhone, String facultet, int course, String group) throws IllegalArgumentException {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.adress = adress;
        this.numberFhone = numberPhone;
        this.course = course;
        this.group = group;
        this.birthday = LocalDate.parse(birthday, dataTimeFormat);

        switch (facultet) {                                      // как оптимизировать, объеденить эти два блока.
            case "Лингвистика":
                this.facultet = Facultet.LINGUISTICS;
                break;
            case "Философия":
                this.facultet = Facultet.PHILOLOGY;
                break;
            case "математика":
                this.facultet = Facultet.MATHEMATICS;
                break;
            case "Логистика":
                this.facultet = Facultet.LOGISTICS;
                break;

            default:
                throw new IllegalArgumentException();
        }


    }

    public Student(int id, String lastName, String firstName, String patronymic, String birthday, String adress, String facultet, int course, String group) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.adress = adress;
        this.numberFhone = "-";
        this.course = course;
        this.group = group;
        this.id=id;
        this.birthday = LocalDate.parse(birthday, dataTimeFormat);

        switch (facultet) {
            case "Лингвистика":
                this.facultet = Facultet.LINGUISTICS;
                break;
            case "Философия":
                this.facultet = Facultet.PHILOLOGY;
                break;
            case "Математика":
                this.facultet = Facultet.MATHEMATICS;
                break;
            case "Логистика":
                this.facultet = Facultet.LOGISTICS;
                break;

            default:
                throw new IllegalArgumentException();
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getBirthdayString() {
        return dataTimeFormat.format(birthday);
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday, dataTimeFormat);
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumberFhone() {
        return numberFhone;
    }

    public void setNumberFhone(String numberFhone) {
        this.numberFhone = numberFhone;
    }

    public String getFacultet() {
        return facultet.getTitle();
    }

    public void setFacultet(Facultet facultet) {
        this.facultet = facultet;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Студент №" + id + ": " + lastName + " " + firstName +  " " + patronymic +
                ", Год рождения: " + this.getBirthdayString() + ", Адрес: " + adress  + ", Номер телефона: "  + numberFhone +  ", " + facultet +
                " Курс: " + course + " Группа: " + group ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (!patronymic.equals(student.patronymic)) return false;
        if (!birthday.equals(student.birthday)) return false;
        if (adress != null ? !adress.equals(student.adress) : student.adress != null) return false;
        if (numberFhone != null ? !numberFhone.equals(student.numberFhone) : student.numberFhone != null) return false;
        if (facultet != student.facultet) return false;
        if (course != null ? !course.equals(student.course) : student.course != null) return false;
        return group != null ? group.equals(student.group) : student.group == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + patronymic.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (numberFhone != null ? numberFhone.hashCode() : 0);
        result = 31 * result + (facultet != null ? facultet.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
