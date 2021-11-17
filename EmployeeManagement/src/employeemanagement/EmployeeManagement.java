/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author TrungLT
 */
public class EmployeeManagement {

    final static Validate Validate = new Validate();

    public static void addEmployee(ArrayList<Employee> ls) {
        System.out.println("\n-------- Add Employees -------");
        int id = Validate.checkId("Enter ID: ", ls);
        String firstName = Validate.checkInputString("Enter first name: ");
        String lastName = Validate.checkInputString("Enter last name: ");
        String phone = Validate.checkPhone("Enter phone number: ");
        String email = Validate.checkEmail("Enter email: ");
        String address = Validate.checkInputString("Enter address: ");
        String DOB = Validate.checkInputDate("Enter date of birth: ");
        String sex = Validate.checkSex("Enter sex (1.Male / 2.Female): ");
        int salary = Validate.checkInputInt("Enter salary: ");
        String agency = Validate.checkInputString("Enter agency: ");

        ls.add(new Employee(id, firstName, lastName, phone, email, address, DOB, sex, salary, agency));

        System.out.println("Add Employee Success!");
    }

    public static void updateEmployee(ArrayList<Employee> ls) {
        System.out.println("\n------- Update Employees --------");
        if (ls.isEmpty()) {
            System.out.println("List empty!");
            return;
        }

        int id = Validate.findEmployeeExist("Enter ID: ", ls);

        for (Employee l : ls) {
            if (id == l.getId()) {
                //Id, First Name, Last Name, Phone, Email, Address, DOB, Sex, Salary, Egency
                System.out.println("1. ID");
                System.out.println("2. First Name");
                System.out.println("3. Last Name");
                System.out.println("4. Phone");
                System.out.println("5. Email");
                System.out.println("6. Address");
                System.out.println("7. DOB");
                System.out.println("8. Sex");
                System.out.println("9. Salary");
                System.out.println("10. Agency");
                int choice = Validate.checkIntLimit("Enter attribute you want to change (1-10): ", 1, 10);
                switch (choice) {
                    case 1:
                        l.setId(Validate.checkId("Enter new ID: ", ls));
                        break;
                    case 2:
                        l.setFirstName(Validate.checkInputString("Enter new first name: "));
                        break;
                    case 3:
                        l.setLastName(Validate.checkInputString("Enter new last name: "));
                        break;
                    case 4:
                        l.setPhone(Validate.checkPhone("Enter new phone number: "));
                        break;
                    case 5:
                        l.setEmail(Validate.checkEmail("Enter new email: "));
                        break;
                    case 6:
                        l.setAddress(Validate.checkInputString("Enter new address: "));
                        break;
                    case 7:
                        l.setDOB(Validate.checkInputDate("Enter new date of birth: "));
                        break;
                    case 8:
                        l.setSex(Validate.checkSex("Enter new sex (1.Male / 2.Female): "));
                        break;
                    case 9:
                        l.setSalary(Validate.checkInputInt("Enter new salary: "));
                        break;
                    case 10:
                        l.setAgency(Validate.checkInputString("Enter new agency: "));
                }
            }
        }
    }

    public static void deleteEmployee(ArrayList<Employee> ls) {
        System.out.println("\n------- Remove Employees --------");
        if (ls.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        int id = Validate.findEmployeeExist("Enter ID: ", ls);

        for (Employee l : ls) {
            if (id == l.getId()) {
                ls.remove(l);
                System.out.println("Remove Employee Success!");
                return;
            }
        }
    }

    public static void searchEmployee(ArrayList<Employee> ls) {
        System.out.println("\n------- Search Employees --------");
        int id = Validate.findEmployeeExist("Enter ID: ", ls);

        for (Employee l : ls) {
            if (id == l.getId()) {
                System.out.printf("%-5s%-15s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n", "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                System.out.println(l.toString());
                return;
            }
        }
    }

    public static void sortEmployeeBySalary(ArrayList<Employee> ls) {
        System.out.println("\n--------------------------------------------- Employees Sorted By Salary ---------------------------------------------");
        if (ls.isEmpty()) {
            System.out.println("List empty!");
            return;
        }

        Collections.sort(ls);

        System.out.printf("%-5s%-15s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n", "ID", "FirstName", "LastName", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
        for (Employee l : ls) {
            System.out.println(l.toString());
        }
    }

    public static void display() {
        ArrayList<Employee> ls = new ArrayList<>();
        int choice;
        while (true) {
            System.out.println("\n======== Employee Management Program ========");
            System.out.println("1. Add employees");
            System.out.println("2. Update employees");
            System.out.println("3. Remove employees");
            System.out.println("4. Search employees");
            System.out.println("5. Sort employees by salary");
            System.out.println("6. Exit");
            choice = Validate.checkIntLimit("Your choice: ", 1, 6);
            switch (choice) {
                case 1:
                    addEmployee(ls);
                    break;
                case 2:
                    updateEmployee(ls);
                    break;
                case 3:
                    deleteEmployee(ls);
                    break;
                case 4:
                    searchEmployee(ls);
                    break;
                case 5:
                    sortEmployeeBySalary(ls);
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        display();
    }
}
