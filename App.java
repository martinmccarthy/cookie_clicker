import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JButton cookieButton = new JButton();
    private int count = 0;
    private JLabel cookieInfo = new JLabel("Num of cookies: " + count, SwingConstants.CENTER);
    private Image cookie;
    private JButton shopButton = new JButton();
    private int multiplier = 1;
    private int multiplierPrice = 10;

    public App() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        setCookieIcon();
        cookieButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        count += multiplier;
                        cookieInfo.setText("Num of cookies: " + count);
                    }
                }
        );

        shopButton.setText("DOUBLE CLICKS\nPRICE: " + multiplierPrice);
        shopButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Shop shop = new Shop();
                        boolean canBuy = shop.validityCheck(count, multiplierPrice);
                        if(canBuy) {
                            multiplier = multiplier * 2;
                            count = shop.subtractCookies(count, multiplierPrice);
                            multiplierPrice = shop.newPrice(multiplierPrice);
                            shopButton.setText("DOUBLE CLICKS\nPRICE: " + multiplierPrice);
                            cookieInfo.setText("Num of cookies: " + count);
                        }
                    }
                });



        panel.add(shopButton, BorderLayout.CENTER);

        // cookieButton.setSize(250, 500); this mf will not cooperate
        panel.add(cookieButton, BorderLayout.CENTER);

        panel.add(cookieInfo, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(400, 800));
        frame.setResizable(false);
        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cookie Clicker");
        frame.pack();
        frame.setVisible(true);


    }

    public void setCookieIcon() {
        try {
            cookie = ImageIO.read(getClass().getResource("resources/cookie.png"));

            cookieButton.setIcon(new ImageIcon(cookie));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
