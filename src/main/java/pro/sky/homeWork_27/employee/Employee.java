package pro.sky.homeWork_27.employee;


import java.util.Objects;

public class Employee {
    String firstName;
    String lastName;

    public Employee(String name, String surname) {
        this.firstName = name;
        this.lastName = surname;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return String.format("Ф.И.: %s %s", lastName, firstName);
    }
}
