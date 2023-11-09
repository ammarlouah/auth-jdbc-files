package com.example;
import java.sql.*;

public class Crud {
    public static boolean insertEtud(int appoge,String cne,String nom,String prenom) throws SQLException{
        Connection con = DbConnection.connection();
        String query = "INSERT INTO etudiant VALUES(?,?,?,?);";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, appoge);
            preparedStatement.setString(2, cne);
            preparedStatement.setString(3, nom);
            preparedStatement.setString(4, prenom);
            preparedStatement.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    public static boolean selectEtud(int appoge,String cne) throws SQLException{
        Connection con = DbConnection.connection();
        String query = "SELECT * FROM etudiant WHERE appoge=? AND cne=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, appoge);
            preparedStatement.setString(2, cne);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(rs.getMetaData().getColumnCount());
            if(!rs.next()) return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
