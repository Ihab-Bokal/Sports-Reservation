import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
// import java.util.TimerTask;
import java.sql.SQLException;
import java.awt.*;

public class ReservationPiscine {
    // #region : les variables
    JFrame frame_AddRes = new JFrame("Effectuer une réservation");

    JLabel BGImg = new JLabel();

    JPanel panelAddRes = new JPanel();

    JLabel RESERVATION = new JLabel("Réservation");
    JLabel RESERVATION_ICON = new JLabel(new ImageIcon("src/RESERVATION_ICON0.png"));

    String[] years = { "2022", "2023" };
    JComboBox<String> annee = new JComboBox<String>(years);
    JLabel lblan = new JLabel("Année");

    String[] months = { "Jan.", "Fév.", "Mars", "Avril", "Mai", "Juin", "Juil.", "Août", "Sept.", "Oct.", "Nov.",
            "Déc." };
    JComboBox<String> mois = new JComboBox<String>(months);
    JLabel lblmois = new JLabel("Mois");

    String[] days = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    JComboBox<String> jour = new JComboBox<String>(days);
    JLabel lbljr = new JLabel("Jour");

    String[] hours = { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19" };
    JComboBox<String> heure = new JComboBox<String>(hours);
    JLabel lblheure = new JLabel("Heure");

    String[] entetes = { "Date", "Heure", "Nombre de réservations effectuées"};
    JTable tableReservations;
    String[][] reservations = new String[12][3];
    int ligne = 0;

    JLabel explications = new JLabel();

    JButton btnAfficher = new JButton("Afficher");

    JButton btnReserver = new JButton("Réserver");

    Timer timer = new Timer();
    
    int nbrPassage=0; 
    // #endregion

    public ReservationPiscine(int id) {
        // #region : JLayedPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 30, frame_AddRes.getWidth(), frame_AddRes.getHeight());
        // #endregion

        // #region : frame_AddRes
        frame_AddRes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame_AddRes.setResizable(true);
        frame_AddRes.getContentPane().setBackground(Color.white);
        frame_AddRes.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame_AddRes.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame_AddRes.setLocationRelativeTo(null);
        frame_AddRes.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame_AddRes.setVisible(true);
        // #endregion

        // #region : l'arriere plan
        BGImg.setIcon(new ImageIcon("src/AddReservationImg.jpg"));
        BGImg.setBounds(0, 0, 1366, 764);
        BGImg.setOpaque(true);
        BGImg.setBackground(Color.white);
        BGImg.setVisible(true);
        layeredPane.add(BGImg, Integer.valueOf(0));
        // #endregion

        // #region : panel Ajouter une reservation
        panelAddRes.setBounds(150, 55, 1066, 600);
        panelAddRes.setBackground(Color.white);
        panelAddRes.setLayout(null);
        panelAddRes.setVisible(true);
        panelAddRes.setOpaque(true);
        panelAddRes.setFocusable(false);
        panelAddRes.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        panelAddRes.setBorder(BorderFactory.createRaisedBevelBorder());
        layeredPane.add(panelAddRes, Integer.valueOf(1));
        // #endregion

        // #region : éléments du panelAddRes

        // #region : AddRes et AddResIcon
        RESERVATION.setBounds(210, 55, 400, 50);
        RESERVATION.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        panelAddRes.add(RESERVATION, Integer.valueOf(1));
        RESERVATION_ICON.setBounds(140, 55, 60, 50);
        panelAddRes.add(RESERVATION_ICON, Integer.valueOf(1));
        // #endregion

        // #region : année
        lblan.setBounds(50, 150, 100, 30);
        lblan.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelAddRes.add(lblan, Integer.valueOf(1));
        annee.setBounds(50, 180, 100, 30);
        annee.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        annee.setBackground(Color.white);
        annee.setForeground(Color.black);
        annee.setBorder(BorderFactory.createLineBorder(Color.black, 0, true));
        annee.setCursor(new Cursor(Cursor.HAND_CURSOR));
        annee.setFocusable(false);
        panelAddRes.add(annee, Integer.valueOf(1));
        // #endregion

        // #region : mois
        lblmois.setBounds(160, 150, 100, 30);
        lblmois.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelAddRes.add(lblmois, Integer.valueOf(1));
        mois.setBounds(160, 180, 100, 30);
        mois.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        mois.setBackground(Color.white);
        mois.setForeground(Color.black);
        mois.setBorder(BorderFactory.createLineBorder(Color.black, 0, true));
        mois.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mois.setFocusable(false);
        panelAddRes.add(mois, Integer.valueOf(1));
        // #endregion

        // #region : jour
        lbljr.setBounds(270, 150, 100, 30);
        lbljr.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelAddRes.add(lbljr, Integer.valueOf(1));
        jour.setBounds(270, 180, 100, 30);
        jour.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        jour.setBackground(Color.white);
        jour.setForeground(Color.black);
        jour.setBorder(BorderFactory.createLineBorder(Color.black, 0, true));
        jour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jour.setFocusable(false);
        panelAddRes.add(jour, Integer.valueOf(1));
        // #endregion

        // #region : heure
        lblheure.setBounds(50, 220, 100, 30);
        lblheure.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelAddRes.add(lblheure, Integer.valueOf(1));
        heure.setBounds(50, 250, 100, 30);
        heure.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        heure.setBackground(Color.white);
        heure.setForeground(Color.black);
        heure.setBorder(BorderFactory.createLineBorder(Color.black, 0, true));
        heure.setCursor(new Cursor(Cursor.HAND_CURSOR));
        heure.setFocusable(false);
        heure.setEnabled(false);
        panelAddRes.add(heure, Integer.valueOf(1));
        // #endregion

        // #region : Affichage des horaires disponibles
        btnAfficher.setBounds(100, 530, 100, 30);
        btnAfficher.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        btnAfficher.setBackground(Color.blue);
        btnAfficher.setForeground(Color.white);
        btnAfficher.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        btnAfficher.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAfficher.setFocusable(false);
        btnAfficher.addActionListener(e -> {
            heure.setEnabled(true);
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_integre_s1", "root", "bok@alEMISTE2733");
                Statement stmt = con.createStatement();
                String MOIS_EN_CHIFFRES;
                ResultSet rs2;// le nombre de passage dans la boucle
                switch (mois.getSelectedItem().toString()) {
                    case "Jan.":
                        MOIS_EN_CHIFFRES = "01";
                        break;
                    case "Fév.":
                        MOIS_EN_CHIFFRES = "02";
                        break;
                    case "Mars":
                        MOIS_EN_CHIFFRES = "03";
                        break;
                    case "Avril":
                        MOIS_EN_CHIFFRES = "04";
                        break;
                    case "Mai":
                        MOIS_EN_CHIFFRES = "05";
                        break;
                    case "Juin":
                        MOIS_EN_CHIFFRES = "06";
                        break;
                    case "Juil.":
                        MOIS_EN_CHIFFRES = "07";
                        break;
                    case "Août":
                        MOIS_EN_CHIFFRES = "08";
                        break;
                    case "Sept.":
                        MOIS_EN_CHIFFRES = "09";
                        break;
                    case "Oct.":
                        MOIS_EN_CHIFFRES = "10";
                        break;
                    case "Nov.":
                        MOIS_EN_CHIFFRES = "11";
                        break;
                    case "Déc.":
                        MOIS_EN_CHIFFRES = "12";
                        break;
                    default:
                        MOIS_EN_CHIFFRES = "00";
                        break;
                }
                String dateReservation = annee.getSelectedItem().toString() + "-" + MOIS_EN_CHIFFRES + "-"+ jour.getSelectedItem().toString();
                String sql = "SELECT DATE_RESERVATION, HORAIRE FROM piscine WHERE DATE_RESERVATION = '" + dateReservation + "' ORDER BY HORAIRE ASC";
                ResultSet rs1 = stmt.executeQuery(sql);
                while (rs1.next()) {
                    String date = rs1.getString("DATE_RESERVATION");
                    String heure = rs1.getString("HORAIRE");
                    // count number of reservations called NOMBRE_DE_RESERVATIONS that have been made at the same time
                    String sql2 = "SELECT COUNT(*) AS NOMBRE_DE_RESERVATIONS FROM piscine WHERE DATE_RESERVATION = '" + date + "' GROUP BY DATE_RESERVATION ORDER BY DATE_RESERVATION ASC"; // + "' AND HORAIRE = '" + heure 
                    rs2 = stmt.executeQuery(sql2);
                    int NOMBRE_DE_RESERVATIONS=0;
                    while (rs2.next()) {
                        NOMBRE_DE_RESERVATIONS = rs2.getInt("NOMBRE_DE_RESERVATIONS");
                        if (NOMBRE_DE_RESERVATIONS < 10) {
                            String[] row = { date, heure, Integer.toString(NOMBRE_DE_RESERVATIONS)};
                            for (int i = 0; i < 3; i++) {
                                reservations[ligne][i] = row[i];
                                System.out.println(reservations[ligne][i]);
                            };
                        } else {
                            JOptionPane.showMessageDialog(null, "Il n'y a plus de places disponibles à cet horaire", "Vous ne pouvez pas réserver", JOptionPane.ERROR_MESSAGE);
                        }
                        ligne++;
                    }
                    // String[] row = { date, heure, Integer.toString(NOMBRE_DE_RESERVATIONS)};
                    // if (NOMBRE_DE_RESERVATIONS < 10) {
                    //     for (int i = 0; i < 3; i++) {
                    //         reservations[ligne][i] = row[i];
                    //     };
                    //     ligne++;
                    // } else {
                    //     JOptionPane.showMessageDialog(null, "Il n'y a plus de places disponibles à cet horaire", "Vous ne pouvez pas réserver", JOptionPane.ERROR_MESSAGE);
                    // }
                    rs1.close();
                    rs1 = stmt.executeQuery(sql);
                    for (int k=0;k<=nbrPassage+3;k++) {
                        rs1.next();
                    }
                    nbrPassage++;
                }
                // #region : Tableau des horaires disponibles
                tableReservations = new JTable(reservations, entetes);
                tableReservations.setBounds(640, 130, 530, 390);
                tableReservations.setAutoscrolls(true);
                tableReservations.setRowHeight(22);
                tableReservations.getTableHeader().setBounds(640, 108, 530, 22);
                tableReservations.getTableHeader().setBackground(Color.blue);
                tableReservations.getTableHeader().setForeground(Color.white);
                tableReservations.getTableHeader().setFont(new Font("Bahnschrift", Font.BOLD, 14));
                tableReservations.getTableHeader().setBorder(BorderFactory.createRaisedBevelBorder());
                tableReservations.getTableHeader().setReorderingAllowed(false);
                tableReservations.setBackground(Color.white);
                tableReservations.setForeground(Color.black);
                tableReservations.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
                tableReservations.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
                tableReservations.setFocusable(false);
                tableReservations.setRowSelectionAllowed(true);
                tableReservations.setSelectionBackground(new Color(150, 0, 250));
                tableReservations.setSelectionForeground(Color.white);
                tableReservations.setShowVerticalLines(true);
                tableReservations.setShowHorizontalLines(true);
                tableReservations.setGridColor(Color.black);
                tableReservations.setRowHeight(22);
                tableReservations.setRowMargin(2);
                panelAddRes.add(tableReservations, Integer.valueOf(1));

                JScrollPane scrollPane = new JScrollPane(tableReservations);
                scrollPane.setBounds(500, 108, 530, 390);
                scrollPane.setBackground(Color.white);
                scrollPane.setForeground(Color.black);
                scrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
                scrollPane.setFocusable(false);
                panelAddRes.add(scrollPane, Integer.valueOf(1));
                // #endregion
                reservations = new String[12][3];
                ligne = 0;
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
                throwables.printStackTrace();
            }
        });
        panelAddRes.add(btnAfficher, Integer.valueOf(1));
        // #endregion

        //#region : explications
        JLabel lblExplications = new JLabel("Explications :");
        lblExplications.setBounds(50, 290, 600, 22);
        lblExplications.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        lblExplications.setForeground(Color.blue);
        panelAddRes.add(lblExplications, Integer.valueOf(1));
        explications.setText("<html><br/>Vous pouvez réserver votre ticket de piscine dès qu'il y a<br/>moins de 10 réservations dans cet horaire.le prix d'une<br/>réservation dans la piscine est de 70Dhs<br/>Veuillez noter que la durée d'une réservation est d'une seule<br/>heure.Il faut que vous présentiez votre réservation au<br/>bureau dès votre arrivée à la piscine,vous aurez à payer<br/> les 70Dhs par la méthode que vous souhaitiez dans la limite <br/>des méthodesde paiement disponibles</html>");
        explications.setBounds(50, 260, 600, 260);
        explications.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        explications.setForeground(Color.black);
        panelAddRes.add(explications, Integer.valueOf(1));
        //#endregion

        // #region : Bouton de réservation
        btnReserver.setBounds(250, 530, 150, 30);
        btnReserver.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        btnReserver.setForeground(Color.white);
        btnReserver.setBackground(Color.blue);
        btnReserver.setFocusable(false);
        btnReserver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReserver.setBorder(BorderFactory.createRaisedBevelBorder());
        btnReserver.addActionListener(e -> {
            try {
                nbrPassage++;
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_integre_s1", "root", "bok@alEMISTE2733");
                Statement stmt = con.createStatement();
                String sql;
                String MOIS_EN_CHIFFRES;
                String hour = heure.getSelectedItem().toString() + ":00:00";
                switch (mois.getSelectedItem().toString()) {
                    case "Jan.":
                        MOIS_EN_CHIFFRES = "01";
                        break;
                    case "Fév.":
                        MOIS_EN_CHIFFRES = "02";
                        break;
                    case "Mars":
                        MOIS_EN_CHIFFRES = "03";
                        break;
                    case "Avril":
                        MOIS_EN_CHIFFRES = "04";
                        break;
                    case "Mai":
                        MOIS_EN_CHIFFRES = "05";
                        break;
                    case "Juin":
                        MOIS_EN_CHIFFRES = "06";
                        break;
                    case "Juil.":
                        MOIS_EN_CHIFFRES = "07";
                        break;
                    case "Août":
                        MOIS_EN_CHIFFRES = "08";
                        break;
                    case "Sept.":
                        MOIS_EN_CHIFFRES = "09";
                        break;
                    case "Oct.":
                        MOIS_EN_CHIFFRES = "10";
                        break;
                    case "Nov.":
                        MOIS_EN_CHIFFRES = "11";
                        break;
                    case "Déc.":
                        MOIS_EN_CHIFFRES = "12";
                        break;
                    default:
                        MOIS_EN_CHIFFRES = "01";
                        break;
                }
                String date = annee.getSelectedItem().toString() + "-" + MOIS_EN_CHIFFRES + "-" + jour.getSelectedItem().toString();
                sql = "INSERT INTO piscine VALUES (" + id + ", '" + date + "', '" + hour + "')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Réservation effectuée avec succès");
                
            } catch (Exception e1) {
                System.out.println(e1);
                JOptionPane.showMessageDialog(null, "cet horaire est déjà réservé.", "Erreur de réservation", JOptionPane.ERROR_MESSAGE);
            }
    });
        panelAddRes.add(btnReserver, Integer.valueOf(1));
        // #endregion

        //#endregion

        // #region : Ajout des composants à la frame
        frame_AddRes.add(layeredPane);
        // #endregion
    }

    public int contains(String[] sport, String s) {
        for (int i = 0; i < sport.length; i++) {
            if (sport[i].equals(s)) {
                return 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new ReservationPiscine(1);
    }
}