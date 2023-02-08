import javax.swing.*;
import java.awt.*;

public class LeftPanelRW {
    //#region : variables
    final JPanel leftPanel = new JPanel();

    JLabel logoLPan = new JLabel(new ImageIcon("src/overpowerTakeCome.jpg"));
    JLabel lblLPan = new JLabel("Booking made simple !");
    //#endregion
    
    public LeftPanelRW(JFrame frame_02, int id) {
        //#region : panel gauche
        leftPanel.setBounds(0, 0, 260, frame_02.getHeight());
        leftPanel.setBackground(new Color(100, 120, 250)); // blue : 50, 50, 200 
        leftPanel.setLayout(null);
        leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        //#endregion
    
        //#region : Image et label(Booking made simple !)
        logoLPan.setBounds(0, 0, 260, 260);
        logoLPan.setBorder(BorderFactory.createRaisedBevelBorder());

        lblLPan.setBounds(0, 290, 260, 24);
        lblLPan.setFont(new Font("Bahnschrift", Font.BOLD, 23));
        lblLPan.setForeground(Color.white);
        lblLPan.setHorizontalAlignment(JLabel.CENTER);
        //#endregion

        //#region : Modification de mes informations personnelles
        JButton btnModifInfo = new JButton("Modifier mes infos");
        btnModifInfo.setBounds(10, 365, 220, 20);
        btnModifInfo.setBackground(new Color(100, 120, 250));
        btnModifInfo.setHorizontalAlignment(JButton.LEFT);
        btnModifInfo.setForeground(Color.black);
        btnModifInfo.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnModifInfo.setBorder(BorderFactory.createLineBorder(Color.black, 0, false));
        btnModifInfo.setFocusable(false);
        btnModifInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnModifInfo.addActionListener(e -> {
            new ModifInfoWindow(id);
        });
        leftPanel.add(btnModifInfo);
        //#endregion

        //#region : bouton de déconnexion
        JButton btnDeconnexion = new JButton("Déconnexion");
        btnDeconnexion.setBounds(10, 400, 220, 20);
        btnDeconnexion.setBackground(new Color(100, 120, 250));
        btnDeconnexion.setForeground(Color.black);
        btnDeconnexion.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnDeconnexion.setBorder(BorderFactory.createLineBorder(Color.black, 0, false));
        btnDeconnexion.setFocusable(false);
        btnDeconnexion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDeconnexion.setHorizontalAlignment(JButton.LEFT);
        btnDeconnexion.addActionListener(e -> {
            frame_02.dispose();
            new PageAccueil_01();
        });
        leftPanel.add(btnDeconnexion);
        //#endregion

        //#region : bouton de reservation piscine
        JButton btnReservPiscine = new JButton("Réservation piscine");
        btnReservPiscine.setBounds(10, 435, 220, 20);
        btnReservPiscine.setBackground(new Color(100, 120, 250));
        btnReservPiscine.setForeground(Color.black);
        btnReservPiscine.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        btnReservPiscine.setBorder(BorderFactory.createLineBorder(Color.black, 0, false));
        btnReservPiscine.setFocusable(false);
        btnReservPiscine.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReservPiscine.setHorizontalAlignment(JButton.LEFT);
        btnReservPiscine.addActionListener(e -> {
            new ReservationPiscine(id);
        });
        leftPanel.add(btnReservPiscine);
        //#endregion

        //#region : ajout des éléments au Panel gauche
        leftPanel.add(logoLPan);
        leftPanel.add(lblLPan);
        //#endregion 

        frame_02.add(leftPanel);
    }
}
