package model.data;

import java.util.Objects;

public class Contact {
    private String name;
    private String lastName;
    private String patronymic;
    private String birthDay;
    private String phoneNumber;
    private String gender;

    public Contact() {}

    public Contact(String name,String lastName, String patronymic, String birthDay, String phoneNumber, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFSc(String ... fSc) {
        this.setName(fSc[0]);
        this.setLastName(fSc[1]);
        this.setPatronymic(fSc[2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name)
                && lastName.equals(lastName)
                && patronymic.equals(patronymic)
                && birthDay.equals(contact.birthDay)
                && phoneNumber.equals(contact.phoneNumber)
                && gender.equals(contact.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic, birthDay, phoneNumber, gender);
    }

    @Override
    public String toString() {
        return name +
                " " + lastName +
                " " + patronymic +
                " " + birthDay +
                " " +  phoneNumber +
                " " + gender;
    }
}
