import javax.swing.*;
import java.awt.*;

public class InfoWindowTEEEEST {
    //#region : fields
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

    public InfoWindowTEEEEST(int id) {
        //#region : la fenêtre 
        infoWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoWindow.setSize(1100, 730);
        infoWindow.setLocationRelativeTo(null);
        infoWindow.setLayout(null);
        infoWindow.setBackground(Color.white);
        infoWindow.setResizable(false);
        infoWindow.setVisible(true);
        infoWindow.setTitle("Informations sur le complexe");
        infoWindow.setIconImage(new ImageIcon("src/pics/FitnessPal02.png").getImage());
        //#endregion

        //#region : descriptif du complexe 
        basketText.setText("<html>On met à votre disposition 2 terrains de basket. <br/>Ces derniers sont soumis à une observation permanente pour assurrer <br/>votre amusement et votre sécurité.</html>");
        basketText.setFont(new Font("Arial", Font.BOLD, 18));
        basketText.setHorizontalAlignment(JLabel.CENTER);
        basket.setBounds(10, 30, 230, 180);
        basketText.setBounds(250, 40, 300, 130);

        footText.setText("<html>Le terrain de foot le meilleur à Rabat est mis à votre diposition.<br/> Réservez pour profiter d'un match que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        footText.setFont(new Font("Arial", Font.BOLD, 16));
        footText.setHorizontalAlignment(JLabel.CENTER);
        football.setBounds(550, 30, 230, 180);
        footText.setBounds(790, 40, 300, 130);

        futsalText.setText("<html>Le terrain de futsal le meilleur à Rabat est mis à votre diposition.<br/> Réservez pour profiter d'un match que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        futsalText.setFont(new Font("Arial", Font.BOLD, 18));
        futsalText.setHorizontalAlignment(JLabel.CENTER);
        futsal.setBounds(10, 420, 230, 180);
        futsalText.setBounds(250, 430, 450, 130);

        piscineText.setText("<html>La piscine la plus grande à Rabat est mise à votre diposition.<br/> Réservez pour profiter d'un moment que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        piscineText.setFont(new Font("Arial", Font.BOLD, 18));
        piscineText.setHorizontalAlignment(JLabel.CENTER);
        piscine.setBounds(500, 610, 230, 180);
        piscineText.setBounds(10, 620, 450, 130);

        volleyText.setText("<html>Le terrain de volley le meilleur à Rabat est mis à votre diposition.<br/> Réservez pour profiter d'un match que vous n'oublierez jamais!<br/> Mais faites vite, les réservations sont nombreuses. </html>");
        volleyText.setFont(new Font("Arial", Font.BOLD, 18));
        volleyText.setHorizontalAlignment(JLabel.CENTER);
        volley.setBounds(10, 810, 230, 180);
        volleyText.setBounds(250, 820, 450, 130);
        //#endregion
    
        //#region : le bouton fermer
        btnClose.setBounds(950, 620, 100, 30);
        btnClose.addActionListener(e -> infoWindow.dispose());
        //#endregion

        //#region : le panel
        infoPanel.setLayout(null);
        infoPanel.setBounds(0, 0, 1100, 730);
        infoPanel.setBackground(Color.white);
        //#endregion

        //#region : ajout des éléments à la fenêtre
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
        infoPanel.add(btnClose);
        infoWindow.add(infoPanel);
        //#endregion
        

        
    }
    public static void main(String[] args) {
        new InfoWindowTEEEEST(6838);
    }
}
