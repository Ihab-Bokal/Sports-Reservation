import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ShowReservations extends JTable {
    //#region : fields
    String[] entetes = { "Sport", "Date", "heure", "Durée", "identifiant du terrain", "Prix", "Localisation" };
    String[][] data = new String[18][7];
    JTable reservations;
    int nombre_de_reservations=0;
    int champ_reservation; // cette variable 
    //#endregion

    public ShowReservations(int id, JFrame frame_02) {
        //#region : connection et apport des données de projet_integre_s1.reservations
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = new String("jdbc:mysql://localhost:3306/projet_integre_s1");
            String user = "root";
            String password = "bok@alEMISTE2733";
            Connection con = DriverManager.getConnection(dbUrl, user, password);
            String sql = "SELECT ress.TypeRessource sport, rs.DATE_RESERVATION date, rs.HEURE heure, ress.duree_utilisation duree, ress.idRESSOURCE idRessource, ress.prix prix, ress.localisation localisation FROM reservations rs, ressources ress WHERE rs.ID_RESSOURCE = ress.idRessource AND ID_D_UTILISATEUR = " + id;
            PreparedStatement prepstmt = con.prepareStatement(sql);
            ResultSet rs = prepstmt.executeQuery();
            while (rs.next()) {
                String sport = rs.getString("sport");
                String date = rs.getString("date");
                String heure = rs.getString("heure");
                String duree = rs.getString("duree");
                String ID_TERRAIN = rs.getString("idRessource");
                String prix = rs.getString("prix");
                String localisation = rs.getString("localisation");
                String[] row = { sport, date, heure, duree, ID_TERRAIN, prix, localisation };
                // if (row[nombre_de_reservations]==null) {
                //     break;
                // }
                for (champ_reservation=0; champ_reservation<7; champ_reservation++) {
                    data[nombre_de_reservations][champ_reservation] = row[champ_reservation];
                }
                nombre_de_reservations++;
            };
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        //#endregion
        
        //#region : ScrollPane for the table
        // JScrollPane scrollTable = new JScrollPane(reservations);
        // scrollTable.setBounds(640, 130, 720, 550);
        // frame_02.getContentPane().add(scrollTable);
        //#endregion

        //#region : données de la table
        reservations = new JTable(data, entetes);
        //#endregion

        //#region : table
        reservations.setBounds(640, 122, 720, 550);
        reservations.setAutoscrolls(true);
        reservations.setRowHeight(22);
        reservations.getTableHeader().setBounds(640, 100, 720, 22);
        reservations.getTableHeader().setBackground(Color.blue);
        reservations.getTableHeader().setForeground(Color.white);
        reservations.getTableHeader().setFont(new Font("Bahnschrift", Font.BOLD, 14));
        reservations.getTableHeader().setBorder(BorderFactory.createRaisedBevelBorder());
        reservations.getTableHeader().setReorderingAllowed(false);
        reservations.setBackground(Color.white);
        reservations.setForeground(Color.black);
        reservations.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        reservations.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        reservations.setFocusable(false);
        reservations.setRowSelectionAllowed(true);
        reservations.setSelectionBackground(new Color(150, 0, 250));
        reservations.setSelectionForeground(Color.white);
        reservations.setShowVerticalLines(true);
        reservations.setShowHorizontalLines(true);
        reservations.setGridColor(Color.black);
        reservations.setRowHeight(22);
        reservations.setRowMargin(2);
        //#endregion
        
        //#region : ajout d'éléments au frame
        frame_02.getContentPane().add(reservations.getTableHeader());
        frame_02.getContentPane().add(reservations);
        //#endregion
    }
    public static void main(String[] args) {
        new ShowReservations(1, new JFrame());
    }
}
