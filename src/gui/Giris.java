package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Giris {

	private JFrame frame;
	private JTextField textTC;
	private JPasswordField pswKasiyer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris window = new Giris();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Giris() {
		SatisEkrani sat ;
		initialize();
	}


	private void initialize() {
		frame = new JFrame("ORAKLAR MARKET");
		frame.getContentPane().setBackground(Color.RED);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(-8, 0, 1650,750);
		frame.getContentPane().setLayout(null);
		//frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		
		JLabel lblOraklarMarket = new JLabel("ORAKLAR MARKET");
		lblOraklarMarket.setHorizontalAlignment(SwingConstants.CENTER);
		lblOraklarMarket.setForeground(Color.WHITE);
		lblOraklarMarket.setFont(new Font("Arial Black", Font.BOLD, 50));
		lblOraklarMarket.setBounds(400, 122, 640, 70);
		frame.getContentPane().add(lblOraklarMarket);
		
		JLabel lblNewLabel = new JLabel("KAS�YER TC      : ");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewLabel.setBounds(410, 297, 268, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblKasiyerSifre = new JLabel("KAS�YER ��FRE : ");
		lblKasiyerSifre.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblKasiyerSifre.setBounds(410, 380, 268, 38);
		frame.getContentPane().add(lblKasiyerSifre);
		
		textTC = new JTextField();
		textTC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textTC.setFont(new Font("Arial Black", Font.PLAIN, 25));
		textTC.setBounds(716, 297, 268, 38);
		frame.getContentPane().add(textTC);
		textTC.setColumns(10);
		
		pswKasiyer = new JPasswordField();
		pswKasiyer.setFont(new Font("Arial Black", Font.PLAIN, 25));
		pswKasiyer.setBounds(716, 380, 268, 38);
		frame.getContentPane().add(pswKasiyer);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Murat Can ORAK\\Desktop\\JavaProjelerim\\MarketOtomasyonu\\src\\image\\loading.gif"));
		label.setBounds(410, 203, 640, 640);
		//label.setVisible(false);
		frame.getContentPane().add(label);
	
		
		JButton btnGiriYap = new JButton("G�R�� YAP");
		btnGiriYap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	label.setVisible(true);
				String kullaniciTc = textTC.getText();
				String kullaniciSifre = pswKasiyer.getText();
				
				if (kullaniciTc.equals("1234") && kullaniciSifre.equals("1234")) {
					
			//	frame.setVisible(false);
					new SatisEkrani();
	
				}
				
			}
		});
		btnGiriYap.setBackground(new Color(30, 144, 255));
		btnGiriYap.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnGiriYap.setBounds(848, 494, 192, 38);
		frame.getContentPane().add(btnGiriYap);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
