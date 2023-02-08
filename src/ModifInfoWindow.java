import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

public class ModifInfoWindow extends JFrame {
    // #region : les variables
    JFrame frame_AddRes = new JFrame("Modification des informations");

    JLabel BGImg = new JLabel();

    JPanel panelModif = new JPanel();

    JLabel MajInfos = new JLabel("Màj des informations");
    JLabel ModifInfoIcon = new JLabel(new ImageIcon("src/ModifInfoIcon.jpg"));

    JTextArea nom = new JTextArea();
    JTextArea prenom = new JTextArea();
    JTextArea email = new JTextArea();
    JTextArea mdp = new JTextArea();
    JTextArea telephone = new JTextArea();

    JLabel lblnom = new JLabel("Nom* :");
    JLabel lblPrenom = new JLabel("Prenom* :");
    JLabel lblmail = new JLabel("Email* :");
    JLabel lblmdp = new JLabel("Mot de passe* :");
    JLabel lbltelephone = new JLabel("Telephone :");

    JButton btnValider = new JButton("Valider");

    // Timer timer = new Timer();
    // #endregion

    public ModifInfoWindow(int id) {
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
        BGImg.setIcon(new ImageIcon("src/ModifInfo.jpg"));
        BGImg.setBounds(0, 0, 1366, 764);
        BGImg.setOpaque(true);
        BGImg.setBackground(Color.white);
        BGImg.setVisible(true);
        layeredPane.add(BGImg, Integer.valueOf(0));
        // #endregion

        // #region : panelModif
        panelModif.setBounds(200, 70, 480, 600);
        panelModif.setBackground(Color.white);
        panelModif.setLayout(null);
        panelModif.setVisible(true);
        panelModif.setOpaque(true);
        panelModif.setFocusable(false);
        panelModif.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        panelModif.setBorder(BorderFactory.createRaisedBevelBorder());
        layeredPane.add(panelModif, Integer.valueOf(1));
        // #endregion

        // #region : éléments du panelModif

        // #region : MajInfos et ModifInfoIcon
        MajInfos.setBounds(120, 55, 400, 50);
        MajInfos.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        panelModif.add(MajInfos, Integer.valueOf(1));
        ModifInfoIcon.setBounds(50, 55, 60, 50);
        panelModif.add(ModifInfoIcon, Integer.valueOf(1));
        // #endregion

        // #region : nom
        nom.setBounds(40, 190, 190, 22);
        nom.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        nom.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        lblnom.setBounds(40, 160, 190, 22);
        lblnom.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelModif.add(lblnom, Integer.valueOf(1));
        panelModif.add(nom, Integer.valueOf(1));
        // #endregion

        // #region : prenom
        prenom.setBounds(240, 190, 200, 22);
        prenom.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        prenom.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        lblPrenom.setBounds(240, 160, 190, 22);
        lblPrenom.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelModif.add(lblPrenom, Integer.valueOf(1));
        panelModif.add(prenom, Integer.valueOf(1));
        // #endregion

        // #region : email
        email.setBounds(40, 270, 400, 22);
        email.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        email.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        lblmail.setBounds(40, 240, 190, 22);
        lblmail.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelModif.add(lblmail, Integer.valueOf(1));
        panelModif.add(email, Integer.valueOf(1));
        // #endregion

        // #region : mdp
        mdp.setBounds(40, 350, 400, 22);
        mdp.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        mdp.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        lblmdp.setBounds(40, 320, 190, 22);
        lblmdp.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelModif.add(lblmdp, Integer.valueOf(1));
        panelModif.add(mdp, Integer.valueOf(1));
        // #endregion

        // #region : telephone
        telephone.setBounds(40, 430, 400, 22);
        telephone.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        telephone.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        lbltelephone.setBounds(40, 400, 190, 22);
        lbltelephone.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        panelModif.add(lbltelephone, Integer.valueOf(1));
        panelModif.add(telephone, Integer.valueOf(1));
        // #endregion

        // #endregion

        // #region : btnValider
        btnValider.setBounds(190, 500, 100, 30);
        btnValider.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
        btnValider.setBackground(Color.blue);
        btnValider.setForeground(Color.white);
        btnValider.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        btnValider.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnValider.setFocusable(false);
        btnValider.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_integre_s1", "root",
                        "bok@alEMISTE2733");
                Statement stmt = con.createStatement();
                String sql = "SELECT id FROM utilisateurs WHERE id = " + id;
                if (nom.getText().equals("") && prenom.getText().equals("") && email.getText().equals("")
                        && mdp.getText().equals("") && telephone.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir au moins un champ", "Saisie incomplète",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!nom.getText().equals("")) {
                        sql = "UPDATE utilisateurs SET nom = '" + nom.getText() + "' WHERE id = " + id;
                        stmt.executeUpdate(sql);
                    }
                    if (!prenom.getText().equals("")) {
                        sql = "UPDATE utilisateurs SET prenom = '" + prenom.getText() + "' WHERE id = " + id;
                        stmt.executeUpdate(sql);
                    }
                    if (!email.getText().equals("")) {
                        sql = "UPDATE utilisateurs SET email = '" + email.getText() + "' WHERE id = " + id;
                        stmt.executeUpdate(sql);
                    }
                    if (!mdp.getText().equals("")) {
                        sql = "UPDATE utilisateurs SET mot_de_passe = '" + mdp.getText() + "' WHERE id = " + id;
                        stmt.executeUpdate(sql);
                    }
                    if (!telephone.getText().equals("")) {
                        sql = "UPDATE utilisateurs SET phoneNumber = '" + telephone.getText() + "' WHERE id = " + id;
                        stmt.executeUpdate(sql);
                    }
                }
                stmt.executeUpdate(sql);
                sql = "SELECT nom, prenom FROM utilisateurs WHERE id = " + id;
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                UpperPanelRW.lblUser.setText("User : " + rs.getString("nom") + " " + rs.getString("prenom"));
                JOptionPane.showMessageDialog(null,
                        "<html>Veuillez mémoriser votre mot de passe et votre email<br/> pour que vous puissiez vous connecter ultérieurement</html>",
                        "Modification effectuée avec succès", JOptionPane.WARNING_MESSAGE);
                frame_AddRes.dispose();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        panelModif.add(btnValider, Integer.valueOf(1));
        // #endregion

        // #region : Ajout des composants à la frame
        frame_AddRes.add(layeredPane);
        // #endregion
    }
}