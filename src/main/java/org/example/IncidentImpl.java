package org.example;

import java.sql.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class IncidentImpl implements IncidentDao {
    private final static String DB_URL= "jdbc:mysql://localhost:3306/supervisor_system";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";
    @Override
    public void inserer(Incident i) throws SQLException {
        String query = "INSERT INTO incident(Ref,Time,Status,member_id) VALUES(?,?,?,'1jtUQgJPKQ')";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, i.getRef());
            ps.setString(2, i.getStatus());
            ps.setTime(3, i.getTime());
            if (ps.executeUpdate() == 1) {
                System.out.println("Membre inserted successfully");
            }
        }
    }
    @Override
    public void inser(Set<Incident> is) throws SQLException {
        for (Incident x : is) {
            inserer(x);
        }
    }
}

