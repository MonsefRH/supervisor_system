package org.example;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Interface add member
        AdduserView adduserView = new AdduserView();
        adduserView.start();

        MembreDaoImpl membreDao = new MembreDaoImpl();

        // Path to the CSV file
        String csvFilePath = "C:/Users/LENOVO/OneDrive/Bureau/Exam2022/src/main/resources/membres.csv"; // Ensure the file exists in the same directory or provide a full path

        try {
            // Load members from the CSV file
            Set<Member> membres = membreDao.chargeListMembers(csvFilePath);

            // Print out loaded members
            System.out.println("Loaded members from CSV:");
            for (Member membre : membres) {
                System.out.println("ID: " + membre.getId() +
                        ", Name: " + membre.getNom() +
                        ", First Name: " + membre.getPrenom() +
                        ", Email: " + membre.getEmail() +
                        ", Phone: " + membre.getPhone());
            }

            // Optionally, add them to the database
            System.out.println("\nSaving members to the database...");
            for (Member member : membres) {
                try{
                membreDao.insrer(member);}
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            System.out.println("All members saved to the database successfully!");

        } catch (IOException e) {
            System.err.println("Failed to load members from CSV: " + e.getMessage());
        }
        }
    }
