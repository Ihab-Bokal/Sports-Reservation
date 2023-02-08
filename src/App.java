import java.sql.*;

public class App {
    private static Connection con = null;
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = new String("jdbc:mysql://localhost:3306/projet_integre_s1");
        String user = "root";
        String password = "bok@alEMISTE2733";

        con = DriverManager.getConnection(dbUrl, user, password);
        
        try {
            String sql = "INSERT INTO utilisateurs (id, nom, prenom, phoneNumber, email, mot_de_passe) VALUES (2, 'boukhobza', 'ElMehdi', '0766733207', 'boukhobza@gmail.com', 'LoveFFries');";
            insertRecord(sql);

        } catch(Exception e) {
            System.out.println(e);
        } finally {
            con.close();
            System.out.println("Closing connection");
        }
    }

    private static void insertRecord(String sql) throws SQLException {
        System.out.println("Inside insert record.");

        PreparedStatement prepstmt = con.prepareStatement(sql);
        int rows = prepstmt.executeUpdate();
        if (rows>0) {
            System.out.println("Values inserted successfully");
        }
    }
}

// DATABASES :
/* 
create database projet_integreS1;


create table utilisateurs (
id integer primary key,
nom varchar(20),
prenom varchar(20),
phoneNumber varchar(10),
email varchar(20),
mot_de_passe varchar(30));

create table reservations (
dateRes datetime, ==> TIME() extracts the time from datetime
duree varchar(10),
facility_type varchar(30),
facility_id integer,
nom_coach varchar(35),
reservator_id integer,
prix integer,
foreign key (reservator_id) references utilisateurs(id)
);

create table administrateurs (
id integer primary key,
nom varchar(20),
prenom varchar(20),
phoneNumber varchar(10),
email varchar(20),
mot_de_passe varchar(30)
);


*/


