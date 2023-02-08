import javax.swing.*;
import java.awt.*;
// import java.time.LocalDateTime;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.Statement;
// import java.sql.ResultSet;
// import java.lang.Exception;
// import java.time.format.DateTimeFormatter;
// import java.util.Timer;
// import java.util.TimerTask;

public class ReservationWindow extends JPanel {
    //#region : variables
    final JFrame frame_02 = new JFrame("Réservation complexe sportif");
    
    final JPanel leftPanel = new JPanel();

    final JButton btnShowReservations = new JButton("Afficher mes réservations");
    final JButton btncomp1 = new JButton();
    final JButton btnAddReservation = new JButton("Ajouter une réservation");
    final JButton btncomp2 = new JButton();
    final JButton btnShowInfo = new JButton("Description du complexe");
    final JButton btncomp3 = new JButton();
    final JButton btnReservationPiscine = new JButton("Description du complexe");
    final JButton btncomp4 = new JButton();

    final JLabel fbField = new JLabel(new ImageIcon("src/pics/volleyBallField1.jpg"));

    Font bahnFont18 = new Font("Bahnschrift", Font.BOLD, 18);

    JLabel img = new JLabel(new ImageIcon("src/pics/image1.png"));
    //#endregion

    public ReservationWindow(int id) {
        //#region : frame_02
        frame_02.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_02.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame_02.setLayout(null);
        frame_02.setVisible(true);
        frame_02.setResizable(true);
        frame_02.getContentPane().setBackground(new Color(244, 244, 249));
        frame_02.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame_02.setIconImage(new ImageIcon("src/pics/FitnessPal02.png").getImage());
        //#endregion

        //#region : panel gauche
        new LeftPanelRW(frame_02, id);
        //#endregion
        
        //#region : panel haut
        new UpperPanelRW(frame_02, id);
        //#endregion
        
        //#region : img 
        img.setBounds(650, 100, 670, 570);
        frame_02.add(img);
        //#endregion

        //#region : bouton Informations sur le complexe
        btnShowInfo.setBounds(300,  100, 300, 60);
        btnShowInfo.setBackground(Color.white);
        btnShowInfo.setForeground(Color.black);
        btnShowInfo.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnShowInfo.setBorder(BorderFactory.createRaisedBevelBorder());
        btnShowInfo.setFocusable(false);
        btnShowInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnShowInfo.addActionListener(e -> {
            new InfoWindow(id);
        });
        // ajoutons le boutton qui sert de décoration
        btncomp1.setBounds(290, 100, 10, 60);
        btncomp1.setBackground(new Color(254, 40, 73));
        btncomp1.setBorder(BorderFactory.createRaisedBevelBorder());
        btncomp1.setFocusable(false);
        btncomp1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btncomp1.addActionListener(e -> {
            new InfoWindow(id);
        });
        //#endregion

        //#region : bouton Ajouter une réservation
        btnAddReservation.setBounds(300, 350, 300, 60);
        btnAddReservation.setBackground(Color.white);
        btnAddReservation.setForeground(Color.black);
        btnAddReservation.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnAddReservation.setBorder(BorderFactory.createRaisedBevelBorder());
        btnAddReservation.setFocusable(false);
        btnAddReservation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddReservation.addActionListener(e -> {
            new AddReservation(id);
        });
        // ajoutons le boutton qui sert de décoration
        btncomp2.setBounds(290, 350, 10, 60);
        btncomp2.setBackground(new Color(100, 50, 200));
        btncomp2.setBorder(BorderFactory.createRaisedBevelBorder());
        btncomp2.setFocusable(false);
        btncomp2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btncomp2.addActionListener(e -> {
            new AddReservation(id);
        });
        //#endregion
        
        //#region : bouton Afficher les réservations
        btnShowReservations.setBounds(300, 550, 300, 60);
        btnShowReservations.setBackground(Color.white);
        btnShowReservations.setForeground(Color.black);
        btnShowReservations.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnShowReservations.setBorder(BorderFactory.createRaisedBevelBorder());
        btnShowReservations.setFocusable(false);
        btnShowReservations.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnShowReservations.addActionListener(e -> {
            frame_02.remove(img);
            btncomp3.setEnabled(false);
            btnShowReservations.setEnabled(false);
            new ShowReservations(id, frame_02);
        });
        // ajoutons le boutton qui sert de décoration
        btncomp3.setBounds(290, 550, 10, 60);
        btncomp3.setBackground(new Color(00, 0, 240)); // Cyan : 124, 216, 243 // saumon : 254, 40, 73 // jaune doré : 200, 50, 230
        btncomp3.setBorder(BorderFactory.createRaisedBevelBorder());
        btncomp3.setFocusable(false);
        btncomp3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btncomp3.addActionListener(e -> {
            frame_02.remove(img);
            btncomp3.setEnabled(false);
            btnShowReservations.setEnabled(false);
            new ShowReservations(id, frame_02);
        });
        //#endregion
        //#region : bouton Reservation piscine
        btnReservationPiscine.setBounds(300, 550, 300, 60);
        btnReservationPiscine.setBackground(Color.white);
        btnReservationPiscine.setForeground(Color.black); /* 0852643197 */
        btnReservationPiscine.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnReservationPiscine.setBorder(BorderFactory.createRaisedBevelBorder());
        btnReservationPiscine.setFocusable(false);
        btnReservationPiscine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReservationPiscine.addActionListener(e -> {
            frame_02.remove(img);
            btncomp3.setEnabled(false);
            new ShowReservations(id, frame_02);
        });
        // ajoutons le boutton qui sert de décoration
        btncomp4.setBounds(290, 550, 10, 60);
        btncomp4.setBackground(Color.GREEN); // Cyan : 124, 216, 243 // saumon : 254, 40, 73 // jaune doré : 200, 50, 230
        btncomp4.setBorder(BorderFactory.createRaisedBevelBorder());
        btncomp4.setFocusable(false);
        btncomp4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btncomp4.addActionListener(e -> {
            frame_02.remove(img);
            btnShowReservations.setEnabled(false);
            new ReservationPiscine(id);
        });
        //#endregion



        //#region : images qui défilent
        fbField.setBounds(700, 250, 575, 300);
        //#endregion

        //#region : ajout des éléments au frame
        frame_02.add(btnShowInfo);
        frame_02.add(btncomp1);
        frame_02.add(btnAddReservation);
        frame_02.add(btncomp2);
        frame_02.add(btnShowReservations);
        frame_02.add(btncomp3);
        frame_02.add(leftPanel);
        frame_02.add(fbField);
        //#endregion
    }
}