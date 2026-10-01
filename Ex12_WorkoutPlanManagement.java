import java.sql.*;
import java.util.Scanner;

public class WorkoutPlanManagement {

    static final String URL = "jdbc:mysql://localhost:3306/GymDB";
    static final String USER = "root";
    static final String PASSWORD = "root"; // Change if needed

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    // Database Connection
    static void connect() throws Exception {
        con = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Add Workout Plan
    static void addPlan() throws Exception {
        System.out.println("\n--- Add Workout Plan ---");

        System.out.print("Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Member Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Goal: ");
        String goal = sc.nextLine();

        System.out.print("Workout Type: ");
        String workout = sc.nextLine();

        System.out.print("Duration (weeks): ");
        int duration = sc.nextInt();
        sc.nextLine();

        System.out.print("Trainer: ");
        String trainer = sc.nextLine();

        String sql = "INSERT INTO workout_plan VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.setString(4, goal);
        ps.setString(5, workout);
        ps.setInt(6, duration);
        ps.setString(7, trainer);

        ps.executeUpdate();

        System.out.println("\nWorkout plan added successfully!");
    }

    // Search Workout Plan
    static void searchPlan() throws Exception {
        System.out.print("\nEnter Member ID: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM workout_plan WHERE member_id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("\n--- Workout Plan ---");
            System.out.println("Member ID     : " + rs.getInt("member_id"));
            System.out.println("Name          : " + rs.getString("member_name"));
            System.out.println("Age           : " + rs.getInt("age"));
            System.out.println("Goal          : " + rs.getString("goal"));
            System.out.println("Workout Type  : " + rs.getString("workout_type"));
            System.out.println("Duration      : " + rs.getInt("duration") + " weeks");
            System.out.println("Trainer       : " + rs.getString("trainer"));
        } else {
            System.out.println("Member not found!");
        }
    }

    // Display All Plans
    static void displayAll() throws Exception {
        String sql = "SELECT * FROM workout_plan";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n========== ALL WORKOUT PLANS ==========");

        while (rs.next()) {
            System.out.println("----------------------------------------");
            System.out.println("ID       : " + rs.getInt("member_id"));
            System.out.println("Name     : " + rs.getString("member_name"));
            System.out.println("Goal     : " + rs.getString("goal"));
            System.out.println("Workout  : " + rs.getString("workout_type"));
            System.out.println("Duration : " + rs.getInt("duration") + " weeks");
            System.out.println("Trainer  : " + rs.getString("trainer"));
        }
    }

    // Update Workout Plan
    static void updatePlan() throws Exception {
        System.out.print("\nEnter Member ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New Workout Type: ");
        String workout = sc.nextLine();

        System.out.print("New Duration (weeks): ");
        int duration = sc.nextInt();
        sc.nextLine();

        String sql = "UPDATE workout_plan SET workout_type=?, duration=? WHERE member_id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, workout);
        ps.setInt(2, duration);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Workout plan updated successfully!");
        else
            System.out.println("Member not found!");
    }

    // Delete Workout Plan
    static void deletePlan() throws Exception {
        System.out.print("\nEnter Member ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM workout_plan WHERE member_id=?";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Workout plan deleted successfully!");
        else
            System.out.println("Member not found!");
    }

    // Main Method
    public static void main(String[] args) {

        try {
            connect();

            while (true) {
                System.out.println("\n====================================");
                System.out.println("    WORKOUT PLAN MANAGEMENT SYSTEM");
                System.out.println("====================================");
                System.out.println("1. Add Workout Plan");
                System.out.println("2. Search Workout Plan");
                System.out.println("3. Display All Plans");
                System.out.println("4. Update Workout Plan");
                System.out.println("5. Delete Workout Plan");
                System.out.println("6. Exit");

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addPlan();
                        break;

                    case 2:
                        searchPlan();
                        break;

                    case 3:
                        displayAll();
                        break;

                    case 4:
                        updatePlan();
                        break;

                    case 5:
                        deletePlan();
                        break;

                    case 6:
                        con.close();
                        System.out.println("Thank you!");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
