import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.ResultSet;
import java.awt.*;

public class PageAccueil_01 {
    //#region : variables
    public final static JFrame frame01 = new JFrame("Réservation complexe sportif");
    Image icon = Toolkit.getDefaultToolkit().getImage("src/pics/arenaStadium.jpg"); 

    JLabel imageJLabel = new JLabel(new ImageIcon("src/pics/arenaStadium01.png"));
    JLabel loginImage = new JLabel(new ImageIcon("src/pics/loginImage.png"));
    JLabel hasAcc = new JLabel("Vous n'avez pas un compte ? Inscrivez-vous : ");
    JLabel loginLabel = new JLabel("Email : ");
    JLabel passwordLabel = new JLabel("Mot de passe : ");

    final public JTextArea login = new JTextArea(1, 30);

    final JButton btnLogin = new JButton("Se connecter");
    final JButton btnCreateAcc = new JButton("Créer un compte");

    final public JPasswordField password = new JPasswordField(20);

    Timer timer = new Timer();
    //#endregion

    public PageAccueil_01() {
        // #region : frame de login
        frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame01.setLayout(null);
        frame01.setVisible(true);
        frame01.setResizable(true);
        frame01.getContentPane().setBackground(Color.white);
        frame01.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame01.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame01.setIconImage(icon);
        // #endregion
        
        //#region : Les 2 images
        // image de la landing page
        imageJLabel.setBounds(0, 0, 1000, 720);
        
        // image de login
        loginImage.setBounds(1090, 80, 200, 200);
        //#endregion

        //#region : Login
        // label login
        loginLabel.setBounds(1090, 300, 100, 25);
        loginLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));

        // zone de login
        login.setBounds(1090, 320, 200, 25);
        login.setLineWrap(true);
        login.setWrapStyleWord(false);
        login.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        login.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        //#endregion

        //#region : Mot de passe
        // label mot de passe
        passwordLabel.setBounds(1090, 360, 100, 25);
        passwordLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));

        // zone de mot de passe
        password.setBounds(1090, 380, 200, 25);
        password.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        password.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
        //#endregion

        // #region : Boutton de login
        btnLogin.setEnabled(false);
        btnLogin.setBounds(1115, 430, 150, 30);
        btnLogin.setFocusable(false);
        btnLogin.setBackground(Color.blue);
        btnLogin.setForeground(Color.white);
        btnLogin.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btnLogin.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));      

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (login.getText().equals("") || password.getPassword().length == 0) {
                    btnLogin.setEnabled(false);
                } else {
                    btnLogin.setEnabled(true);
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1); // delay is in miliseconds
        
        btnLogin.addActionListener(e -> {
            try {
                login(login.getText(), password.getPassword());
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                login.setText("");
                password.setText("");
            };
        });
        // #endregion

        //#region : Boutton de création de compte
        hasAcc.setBounds(1040, 500, 500, 30);
        hasAcc.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btnCreateAcc.setBounds(1115, 530, 150, 30);
        btnCreateAcc.setFocusable(false);
        btnCreateAcc.setBackground(Color.blue);
        btnCreateAcc.setForeground(Color.white);
        btnCreateAcc.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        btnCreateAcc.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        btnCreateAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCreateAcc.addActionListener(e -> {
            sign_up();
        });
        //#endregion

        //#region : Ajout des éléments à la frame
        frame01.add(loginImage);
        frame01.add(loginLabel);
        frame01.add(passwordLabel);
        frame01.add(imageJLabel);
        frame01.add(login);
        frame01.add(password);
        frame01.add(btnLogin);
        frame01.add(hasAcc);
        frame01.add(btnCreateAcc);
        //#endregion
    }

    //#region : Méthodes
    // ouvrir la page d'incription
    public static int login(String login, char[] password) throws Exception{
        //#region: Connection à la base de données
        String mdp = new String(password);
        String dbUrl = new String("jdbc:mysql://localhost:3306/projet_integre_s1");
        String user = "root";
        String dbpassword = "bok@alEMISTE2733";
        Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver
        Connection con = DriverManager.getConnection(dbUrl, user, dbpassword);
        Statement stmt = con.createStatement();
        //#endregion
        try {
            // on sélectionne l'id de l'utilisateur qui a le même email et mot de passe que ceux entrés
            String sql = "SELECT id FROM utilisateurs WHERE email = '" + login + "' AND mot_de_passe = '" + mdp + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                // si l'utilisateur existe, et l'id est récupéré, on ferme la page de login et on ouvre la page de réservation
                System.out.println(rs.getInt("id"));
                frame01.dispose();
                new ReservationWindow(rs.getInt("id"));
                return 1;
            } else {
                // si l'utilisateur n'existe pas, on affiche un message d'erreur
                if (!(login.equals("") && mdp.equals(""))) {
                    JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrect");
                }
                
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // on ferme la connexion à la base de données, pour prévenir toute erreur qui pourra prendre lieu
            con.close();
        }
        return 0;
    }

    // ouvrir la page de réservation
    public void sign_up() {
        // on ferme la page de login et on ouvre la page d'inscription
        frame01.dispose();
        new InscriptionWindow();
    }
    //#endregion
}


//Timer : a facility for threads to schedule tasksfor future execution in a a background thread
//TimerTak : a task that can be scheduled for one-time or repeated execution by a Timer