import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class InscriptionWindow {
    // #region : fields
    JFrame frame_03 = new JFrame("Inscription");

    JTextArea nom = new JTextArea(1, 30);
    JTextArea prenom = new JTextArea(1, 30);
    JTextArea email = new JTextArea(1, 30);
    final public JPasswordField password = new JPasswordField(20);
    final public JPasswordField confirmPassword = new JPasswordField(20);
    JTextArea telephone = new JTextArea(1, 30);

    JLabel nomLabel = new JLabel("Nom* : ");
    JLabel prenomLabel = new JLabel("Prénom* : ");
    JLabel emailLabel = new JLabel("Email* : ");
    JLabel passwordLabel = new JLabel("Mot de passe* : ");
    JLabel confirmPasswordLabel = new JLabel("Confirmer mot de passe* : ");
    JLabel telephoneLabel = new JLabel("Téléphone : ");
    JLabel signup_image = new JLabel(new ImageIcon("src/pics/Inscription_model_00.png"));
    JLabel logoFitPal = new JLabel(new ImageIcon("src/pics/FitnessPal06.png"));

    JButton btnInscription = new JButton("S'inscrire");
    JButton btnPageAccueil = new JButton("Page d'accueil");

    Timer timer = new Timer();
    // #endregion

    public InscriptionWindow() {

        // #region : frame_03
        frame_03.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_03.setLayout(null);
        frame_03.setVisible(true);
        frame_03.setResizable(true);
        frame_03.getContentPane().setBackground(Color.white);
        frame_03.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // #endregion

        // #region : image de signup
        signup_image.setBounds(547, -140, 1000, 1000);
        // #endregion

        //#region : Image logo
        logoFitPal.setBounds(220, 20, 300, 100);
        // #endregion

        // #region : région nom
        nomLabel.setBounds(140, 160, 100, 25);
        nomLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));

        nom.setBounds(220, 190, 300, 25);
        nom.setLineWrap(true);
        nom.setWrapStyleWord(false);
        nom.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        nom.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        // #endregion

        // #region : région prénom
        prenomLabel.setBounds(140, 220, 100, 25);
        prenomLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));

        prenom.setBounds(220, 250, 300, 25);
        prenom.setLineWrap(true);
        prenom.setWrapStyleWord(false);
        prenom.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        prenom.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        // #endregion

        // #region : Email
        emailLabel.setBounds(140, 280, 100, 25);
        emailLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));

        email.setBounds(220, 310, 300, 25);
        email.setLineWrap(true);
        email.setWrapStyleWord(false);
        email.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        email.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        // #endregion

        // #region : mot de passe
        passwordLabel.setBounds(140, 340, 300, 25);
        passwordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));

        password.setBounds(220, 370, 300, 25);
        // password.setLineWrap(true);
        // password.setWrapStyleWord(false);
        password.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        password.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        // #endregion

        // #region : Confirmation d'Email
        confirmPasswordLabel.setBounds(140, 400, 250, 25);
        confirmPasswordLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));

        confirmPassword.setBounds(220, 430, 300, 25);
        // confirmPassword.setLineWrap(true);
        // confirmPassword.setWrapStyleWord(false);
        confirmPassword.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        confirmPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        // #endregion

        // #region : téléphone
        telephoneLabel.setBounds(140, 460, 100, 25);
        telephoneLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));

        telephone.setBounds(220, 490, 300, 25);
        telephone.setLineWrap(true);
        telephone.setWrapStyleWord(false);
        telephone.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        telephone.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        // #endregion

        // #region : boutton inscription
        btnInscription.setEnabled(false);
        btnInscription.setBounds(470, 580, 110, 25);
        btnInscription.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        btnInscription.setBackground(Color.blue);
        btnInscription.setForeground(Color.white);
        btnInscription.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        btnInscription.setFocusable(false);
        btnInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        TimerTask etteindreBoutton = new TimerTask() {
            @Override
            public void run() {
                String mdp = new String(password.getPassword());
                String confirmerMdp = new String(confirmPassword.getPassword());
                if (nom.getText().equals("") || prenom.getText().equals("") || email.getText().equals("")
                        || mdp.equals("") || confirmerMdp.equals("")) {
                    btnInscription.setEnabled(false);
                } else {
                    btnInscription.setEnabled(true);
                }
            }
        };
        timer.schedule(etteindreBoutton, 0, 10);

        btnInscription.addActionListener(e -> {
            String mdp = new String(password.getPassword());
            String confirmerMdp = new String(confirmPassword.getPassword());
            if (email.getText().indexOf("@") == -1 || email.getText().indexOf(".com") == -1) {
                JOptionPane.showMessageDialog(null,
                        "Veuillez entrer une adresse email de la forme :\nExemple@gmail.com", "Email invalide",
                        JOptionPane.ERROR_MESSAGE);
            } else if (mdp.length() < 8) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un mot de passe d'au moins 8 caractères",
                        "Mot de passe invalide", JOptionPane.ERROR_MESSAGE);
            } else if (mdp.equals(confirmerMdp) == false) {
                JOptionPane.showMessageDialog(null, "La mot de passe de confirmation est différent du mot de passe saisi.",
                        "Mot de passe invalide", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // #region: db connection info
                    String dbUrl = new String("jdbc:mysql://localhost:3306/projet_integre_s1");
                    String user = "root";
                    String dbpassword = "bok@alEMISTE2733";
                    Class.forName("com.mysql.cj.jdbc.Driver"); // charger le driver
                    Connection con = DriverManager.getConnection(dbUrl, user, dbpassword);
                    // #endregion

                    // #region : Insertion des données dans la table utilisateurs
                    String sql = "INSERT INTO `utilisateurs`(`id`, `nom`, `prenom`, `phoneNumber`, `email`, `mot_de_passe`) VALUES (?,?,?,?,?,?)";
                    PreparedStatement statement = con.prepareStatement(sql);
                    // inertion des données
                    statement.setLong(1, genereId());
                    statement.setString(2, nom.getText());
                    statement.setString(3, prenom.getText());
                    statement.setString(4, telephone.getText());
                    statement.setString(5, email.getText());
                    statement.setString(6, mdp);
                    int rowsInserted = statement.executeUpdate();
                    // #endregion

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Inscription réussie", "Inscription",
                                JOptionPane.INFORMATION_MESSAGE);
                        frame_03.dispose();
                        new PageAccueil_01();
                    } else {
                        JOptionPane.showMessageDialog(null, "Une erreur est survenue", "Erreur d'inscription",
                                JOptionPane.ERROR_MESSAGE);
                        
                    }
                } catch (Exception throwables) {
                    JOptionPane.showMessageDialog(null, throwables, "Erreur d'inscription",
                            JOptionPane.ERROR_MESSAGE);
                    throwables.printStackTrace();
                }
            }
        });
        // #endregion

        // #region : boutton retour à la page de connexion
        btnPageAccueil.setBounds(135, 580, 170, 25);
        btnPageAccueil.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        btnPageAccueil.setBackground(Color.blue);
        btnPageAccueil.setForeground(Color.white);
        btnPageAccueil.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        btnPageAccueil.setFocusable(false);
        btnPageAccueil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPageAccueil.addActionListener(e -> {
            frame_03.dispose();
            new PageAccueil_01();
        });
        // #endregion

        // #region : ajout des éléments dans le frame
        frame_03.add(logoFitPal);
        frame_03.add(signup_image);
        frame_03.add(nomLabel);
        frame_03.add(nom);
        frame_03.add(prenomLabel);
        frame_03.add(prenom);
        frame_03.add(emailLabel);
        frame_03.add(email);
        frame_03.add(passwordLabel);
        frame_03.add(password);
        frame_03.add(confirmPasswordLabel);
        frame_03.add(confirmPassword);
        frame_03.add(telephoneLabel);
        frame_03.add(telephone);
        frame_03.add(btnInscription);
        frame_03.add(btnPageAccueil);
        // #endregion
    }
    
    public static int genereId() {
        int min = 1_000;
        int max = 9_999;
        int userId = 0;
        int[] Ids = new int[9_000];
        try {
            // #region: db connection info
            String dbUrl = new String("jdbc:mysql://localhost:3306/projet_integre_s1");
            String user = "root";
            String dbpassword = "bok@alEMISTE2733";
            Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.jdbc.Driver
            Connection con = DriverManager.getConnection(dbUrl, user, dbpassword);
            Statement stmt = con.createStatement();
            // #endregion
            int indexIds = 0;
            ResultSet rs = stmt.executeQuery("select id from utilisateurs");
            // we fetch all of the ids
            while (rs.next()) {
                Ids[indexIds] = rs.getInt(1);
                indexIds++;
            }
            do {
                // Génération de l'id entre 1000 et 9999
                userId = (int) Math.floor(Math.random() * (max - min + 1) + min);
            } while (contains(userId, Ids) == 1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Id généré avec succès");
        }
        return userId;
    }

    private static int contains(int userId, int[] T) {
        int exists = 0;
        for (int i = 0; i < T.length; i++) {
            if (userId == T[i]) {
                exists = 1;
                break;
            }
        }
        return exists;
    }
}