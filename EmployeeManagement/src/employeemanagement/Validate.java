/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author TrungLT
 */
public class Validate {

    private static final Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^[0-9]{10}$";
    private static final String EMAIL_VALID = "^(.+)@(.+)\\.(.+)$";    
    
    public static int checkIntLimit(String mess, int min, int max) {
        System.out.print(mess);
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.out.println("Please input again!");
            }
        }
    }

    public static String checkInputString(String mess) {
        System.out.print(mess);
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.out.println("Not empty!");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt(String mess) {
        System.out.print(mess);
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Please input again!");
            }
        }
    }

    public static int checkId(String mess, ArrayList<Employee> ls) {
        loop:
        while (true) {
            int result = checkInputInt(mess);

            for (Employee l : ls) {
                if (result == l.getId()) {
                    System.out.println("ID must be not duplicated!");
                    continue loop;
                }
            }
            return result;
        }
    }

    public static String checkInputDate(String mess) {
        System.out.print(mess);
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(true);
                Date date = format.parse(result);
                return format.format(date);
            } catch (NumberFormatException | ParseException ex) {
                System.out.println("Please input again!");
            }
        }
    }

    public static String checkPhone(String mess) {
        while (true) {
            String result = checkInputString(mess);

            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.out.println("Invalid Phone Number!");
            }
        }
    }

    public static String checkSex(String mess) { 
        int n = checkIntLimit(mess, 1, 2);
        String result = null;
        switch (n) {
            case 1:
                result = "Male";
                break;
            case 2:
                result = "Female";
        }
        return result;
    }
    
    public static String checkEmail(String mess){
        while (true) {
            String result = checkInputString(mess);

            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.out.println("Invalid Email!");
            }
        }
    }

    public static int findEmployeeExist(String mess, ArrayList<Employee> ls) {
        int id = checkInputInt(mess);
        for (Employee l : ls) {
            if(id == l.getId()){
                return id;
            }
        }
        System.out.println("Not found!");
        return -1;
    }
}
