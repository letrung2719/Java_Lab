/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.util.Objects;

/**
 *
 * @author TrungLT
 */
public class Employee implements Comparable<Employee> {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String DOB;
    private String sex;
    private int salary;
    private String agency;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, String phone, String email, String address, String DOB, String sex, int salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-15s%-15s%-15s%-25s%-15s%-15s%-15s%-15d%-15s",
                getId(), getFirstName(), getLastName(), getPhone(), getEmail(), getAddress(), getDOB(), getSex(), getSalary(), getAgency());
    }

    @Override
    public int compareTo(Employee t) {
        int n1 = this.getSalary();
        int n2 = t.getSalary();
        if (n1 < n2) {
            return 1;
        } else if (n1 == n2) {
            return 0;
        } else {
            return -1;
        }
    }
}
