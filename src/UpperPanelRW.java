import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.lang.Exception;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;


public class UpperPanelRW extends JPanel {
    //#region : variables
    public static JLabel lblUser = new JLabel("User : ");
    JLabel iconUser = new JLabel(new ImageIcon("src/pics/MINI_loginImage.png"));
    JLabel appLogo = new JLabel(new ImageIcon("src/pics/FitnessPal03_resWindow.png"));

    final JPanel upperPanel = new JPanel(); 
    //#endregion

    public UpperPanelRW(JFrame frame_02, int id) {

        //#region : panel haut
        upperPanel.setBounds(260, 0, frame_02.getWidth() - 260, 60);
        upperPanel.setBackground(Color.white);
        upperPanel.setLayout(null);
        upperPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        //#endregion

        //#region : icone d'utilisateur
        iconUser.setBounds(1040, 10, 40, 40);
        //#endregion
        
        //#region : informations de l'utilisateur
        lblUser.setBounds(750, 10, 300, 40);
        lblUser.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lblUser.setForeground(Color.black);
        lblUser.setHorizontalAlignment(JLabel.CENTER);
        lblUser.setVerticalAlignment(JLabel.CENTER);
        // on sélectionne le nom et le prénom de l'utilisateur dont l'identfiant est id
        try {
            //#region: Connexion à la base de données
            String dbUrl = new String("jdbc:mysql://localhost:3306/projet_integre_s1");
            String user = "root";
            String dbpassword = "bok@alEMISTE2733";
            Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver
            Connection con = DriverManager.getConnection(dbUrl, user, dbpassword);
            Statement stmt = con.createStatement();
            //#endregion
            // on sélectionne l'id de l'utilisateur qui a le même email et mot de passe que ceux entrés
            String sql = "SELECT nom, prenom FROM utilisateurs WHERE id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                lblUser.setText("User : " + rs.getString("nom") + " " + rs.getString("prenom"));
            };
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la connexion à la base de données");
        } 
        //#endregion
        
        //#region : logo de l'application
        appLogo.setBounds(10, 10, 100, 40);
        //#endregion

        //#region : date actuelle
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        JLabel lblDate = new JLabel("Date et heure : " + dtf.format(date));
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime date = LocalDateTime.now();
                lblDate.setText("Date : " + dtf.format(date));
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 99); // delay is in miliseconds
        lblDate.setBounds(370, 10, 300, 40);
        lblDate.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        lblDate.setForeground(Color.black);
        lblDate.setHorizontalAlignment(JLabel.CENTER);
        lblDate.setVerticalAlignment(JLabel.CENTER);
        //#endregion

        //#region : ajout des éléments dans le panel haut
        upperPanel.add(lblUser);
        upperPanel.add(iconUser);
        //#endregion
        
        //#region : ajout des elements dans le panel
        upperPanel.add(appLogo);
        upperPanel.add(lblDate);
        //#endregion
    
        frame_02.add(upperPanel);
    }
}
