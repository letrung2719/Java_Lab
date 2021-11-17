/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagement;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author TrungLT
 */
public class TaskManagement {

    /**
     * @param args the command line arguments
     */
    private static final Scanner in = new Scanner(System.in);
    private static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    private static int checkIntLimit(int min, int max) {
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

    private static String checkInputDate() {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                format.setLenient(true);
                Date date = format.parse(result);
                return format.format(date);
            } catch (NumberFormatException | ParseException ex) {
                System.out.println("Please input again!");
            }
        }
    }

    private static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.length() == 0) {
                System.out.println("Not empty!");
            } else {
                return result;
            }
        }
    }

    private static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Please input again!");
            }
        }
    }

    private static String checkInputTaskTypeId() {
        while (true) {
            int n = checkIntLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "Code";
                    break;
                case 2:
                    result = "Test";
                    break;
                case 3:
                    result = "Design";
                    break;
                case 4:
                    result = "Review";
            }
            return result;
        }
    }

    private static String checkInputPlanFrom() {
        while (true) {
            String result = checkInputString();

            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0 && Double.parseDouble(result) <= 17.0) {
                return result;
            } else {
                System.out.println("PlanFrom calculate from 8h -> 17h");
            }
        }
    }

    private static String checkInputPlanTo(Task t) {
        while (true) {
            String result = checkInputString();

            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0 && Double.parseDouble(result) <= 17.5) {
                if (Double.parseDouble(result) <= Double.parseDouble(t.getPlanFrom())) {
                    System.out.println("PlanTo must be later than PlanFrom!");
                    continue;
                }
                return result;
            } else {
                System.out.println("PlanFrom calculate from 8h -> 17h");
            }
        }
    }

    private static int findTaskExist(ArrayList<Task> ls) {
        System.out.print("Enter id: ");
        int id = checkInputInt();
        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).getId() == id) {
                return i;
            }
        }
        System.out.println("Not found!");
        return -1;
    }

    private static void addTask(ArrayList<Task> lt) {
        int id = 1;
        if (!lt.isEmpty()) {
            id = lt.get(lt.size() - 1).getId() + 1;
        }

        System.out.println("");
        Task t = new Task();
        System.out.println("-------- Add Task -------");
        t.setId(id);
        System.out.print("Enter Requirement Name: ");
        t.setRequirementName(checkInputString());
        System.out.print("Enter Task Type: ");
        t.setTaskTypeId(checkInputTaskTypeId());
        System.out.print("Enter Date: ");
        t.setDate(checkInputDate());
        System.out.print("Enter From: ");
        t.setPlanFrom(checkInputPlanFrom());
        System.out.print("Enter To: ");
        t.setPlanTo(checkInputPlanTo(t));
        System.out.print("Enter Assignee: ");
        t.setAssign(checkInputString());
        System.out.print("Enter Reviewer: ");
        t.setReviewer(checkInputString());
        lt.add(t);
        System.out.println("Add Task Success!");
    }

    private static void deleteTask(ArrayList<Task> lt) {
        System.out.println("");
        System.out.println("------- Delete Task --------");
        if (lt.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        int findId = findTaskExist(lt);
        if (findId != -1) {
            lt.remove(findId);
            System.out.println("Delete success!");
        }
    }

    private static void print(ArrayList<Task> lt) {
        System.out.println("");
        System.out.println("--------------------------------------------- Task ---------------------------------------------");
        if (lt.isEmpty()) {
            System.out.println("List empty!");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getAssign(),
                    lt.get(i).getReviewer()
            );
        }
        System.out.println("");
    }

    private static void display() {
        ArrayList<Task> ls = new ArrayList<>();
        int choice;
        while (true) {
            System.out.println("\n======== Task Program ========");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    addTask(ls);
                    break;
                case 2:
                    deleteTask(ls);
                    break;
                case 3:
                    print(ls);
                    break;
                case 4:
                    return;

            }
        }
    }

    public static void main(String[] args) throws IOException {
        display();
    }
}
