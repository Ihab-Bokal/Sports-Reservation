import javax.swing.*;
import java.awt.*;

public class InfoWindow {
    //#region : les variables
    JFrame infoWindow = new JFrame();
    JPanel infoPanel = new JPanel();

    JButton btnClose = new JButton("Fermer");

    JLabel basket = new JLabel(new ImageIcon("src/mainPics/BasketField.jpg"));
    JLabel basketText = new JLabel();
    JLabel football = new JLabel(new ImageIcon("src/mainPics/fbField.jpg"));
    JLabel footText = new JLabel();
    JLabel futsal = new JLabel(new ImageIcon("src/mainPics/futsalField.jpg"));
    JLabel futsalText = new JLabel();
    JLabel piscine = new JLabel(new ImageIcon("src/mainPics/swimmingPool1.png"));
    JLabel piscineText = new JLabel();
    JLabel volley = new JLabel(new ImageIcon("src/mainPics/volleyBallField1.jpg"));
    JLabel volleyText = new JLabel();
    //#endregion
    
    public InfoWindow(int id) {
        //#region : la fenêtre
        infoWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoWindow.setSize(1100, 730);
        infoWindow.setLocationRelativeTo(null);
        infoWindow.setAlwaysOnTop(true);
        infoWindow.setLayout(null);
        infoWindow.setBackground(Color.white);
        infoWindow.setResizable(false);
        infoWindow.setVisible(true);
        infoWindow.setTitle("Informations sur le complexe");
        infoWindow.setIconImage(new ImageIcon("src/pics/FitnessPal02.png").getImage());
        //#endregion

        //#region : descriptif du complexe 
        basketText.setText("<html>On met à votre disposition 2 terrains de basket. <br/>Ces derniers sont soumis à une observation permanente pour assurrer <br/>votre amusement et votre sécurité.</html>");
        basketText.setFont(new Font("Arial", Font.BOLD, 16));
        basketText.setHorizontalAlignment(JLabel.CENTER);
        basket.setBounds(10, 30, 230, 180);
        basketText.setBounds(250, 50, 300, 130);

        footText.setText("<html>Le terrain de foot le meilleur à Rabat est mis à votre diposition.<br/> Réservez pour profiter d'un match que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        footText.setFont(new Font("Arial", Font.BOLD, 16));
        footText.setHorizontalAlignment(JLabel.CENTER);
        football.setBounds(550, 20, 230, 180);
        footText.setBounds(790, 40, 290, 130);

        futsalText.setText("<html>Le terrain de futsal le meilleur à Rabat est mis à votre diposition.<br/> Réservez pour profiter d'un match que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        futsalText.setFont(new Font("Arial", Font.BOLD, 16));
        futsalText.setHorizontalAlignment(JLabel.CENTER);
        futsal.setBounds(13, 250, 230, 180);
        futsalText.setBounds(250, 280, 300, 130);

        piscineText.setText("<html>La piscine la plus grande à Rabat est mise à votre diposition.<br/> Réservez pour profiter d'un moment que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        piscineText.setFont(new Font("Arial", Font.BOLD, 16));
        piscineText.setHorizontalAlignment(JLabel.CENTER);
        piscine.setBounds(550, 250, 230, 180);
        piscineText.setBounds(790, 280, 290, 130);

        volleyText.setText("<html>Le terrain de volley le meilleur à Rabat est mis à votre diposition.<br/> Réservez pour profiter d'un match que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        volleyText.setFont(new Font("Arial", Font.BOLD, 16));
        volleyText.setHorizontalAlignment(JLabel.CENTER);
        volley.setBounds(240, 470, 230, 180);
        volleyText.setBounds(490, 490, 300, 130);
        //#endregion

        //#region : panel
        infoPanel.setBounds(0, 0, 1090, 730);
        infoPanel.setBackground(new Color(244, 244, 254));
        infoPanel.setLayout(null);
        //#endregion

        //#region : make the frame scrollable
        JScrollPane scrollPane = new JScrollPane(infoPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 0, 1100, 730);
        //#endregion

        //#region : le bouton de fermeture
        btnClose.setBounds(900, 630, 100, 25);
        btnClose.setBackground(Color.blue);
        btnClose.setForeground(Color.white);
        btnClose.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        btnClose.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        // btnClose.setFocusPainted(false);
        btnClose.setFocusable(false);
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnClose.addActionListener(e -> {
            infoWindow.dispose();
        });
        // #endregion

        //#region : ajout des éléments au panel
        infoWindow.add(scrollPane);
        infoPanel.add(btnClose);
        infoPanel.add(basket);
        infoPanel.add(basketText);
        infoPanel.add(football);
        infoPanel.add(footText);
        infoPanel.add(futsal);
        infoPanel.add(futsalText);
        infoPanel.add(piscine);
        infoPanel.add(piscineText);
        infoPanel.add(volley);
        infoPanel.add(volleyText);
        //#endregion
    }
    public static void main(String[] args) {
        new InfoWindow(6838);
    }
}
