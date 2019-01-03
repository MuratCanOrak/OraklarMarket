package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SatisEkrani implements ActionListener {

	Baglanti bag = new Baglanti();
	Fis git;
	Iade iade;
	private JFrame frame;
	private JTable table;
	private JTextField txtAdet;
	private JLabel lblToplam;

	public static JTextField textId;
	public int adet2;
	public double toplam = 0, toplam2 = 0;
	DefaultTableModel modelim = new DefaultTableModel();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:m");

	Object[] kolonlar = { "ÜRÜN", "ADET", "FİYAT", "TOPLAM" };
	Object[] satirlar = new Object[4];

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SatisEkrani window = new SatisEkrani();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SatisEkrani() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame("MARKET OTOMASYONU");
		frame.getContentPane().setBackground(Color.RED);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 5));
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 191, 564, 215); //
		scrollPane.setBackground(Color.BLUE);
		frame.getContentPane().add(scrollPane);

		JLabel lblArka = new JLabel("");
		lblArka.setBackground(Color.WHITE);
		lblArka.setBounds(10, 53, 211, 76);
		frame.getContentPane().add(lblArka);
		lblArka.setOpaque(true);

		lblToplam = new JLabel();
		lblToplam.setHorizontalAlignment(SwingConstants.RIGHT);
		lblToplam.setForeground(Color.BLACK);
		lblToplam.setFont(new Font("Palatino Linotype", Font.BOLD, 73));
		lblToplam.setBackground(Color.WHITE);
		lblToplam.setBounds(10, 65, 204, 64);
		lblToplam.setOpaque(true);
		frame.getContentPane().add(lblToplam);

		txtAdet = new JTextField();
		txtAdet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		txtAdet.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtAdet.setText("1");
		txtAdet.setBounds(10, 140, 53, 40);
		frame.getContentPane().add(txtAdet);
		txtAdet.setColumns(10);

		textId = new JTextField();
		textId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!(Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textId.setFont(new Font("Tahoma", Font.BOLD, 20));
		textId.setBounds(101, 140, 182, 39);
		frame.getContentPane().add(textId);
		textId.setColumns(10);

		table = new JTable();
		table.setBackground(Color.WHITE);
		modelim.setColumnIdentifiers(kolonlar);
		scrollPane.setViewportView(table);

		JButton btn0 = new JButton("0");
		btn0.setBounds(363, 148, 60, 30);
		btn0.addActionListener(this);
		frame.getContentPane().add(btn0);

		JButton btn1 = new JButton("1");
		btn1.setBounds(293, 113, 60, 30);
		btn1.addActionListener(this);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setBounds(363, 113, 60, 30);
		btn2.addActionListener(this);
		frame.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBounds(433, 113, 60, 30);
		btn3.addActionListener(this);
		frame.getContentPane().add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setBounds(293, 79, 60, 30);
		btn4.addActionListener(this);
		frame.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setBounds(363, 79, 60, 30);
		btn5.addActionListener(this);
		frame.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setBounds(433, 79, 60, 30);
		btn6.addActionListener(this);
		frame.getContentPane().add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setBounds(293, 45, 60, 30);
		btn7.addActionListener(this);
		frame.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setBounds(363, 45, 60, 30);
		btn8.addActionListener(this);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBounds(433, 45, 60, 30);
		btn9.addActionListener(this);
		frame.getContentPane().add(btn9);

		JButton btnSil = new JButton("SİL");
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSil.addActionListener(this);
		btnSil.setBounds(433, 148, 60, 30);
		frame.getContentPane().add(btnSil);

		JLabel lblBaslik = new JLabel("ORAKLAR MARKET");
		lblBaslik.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblBaslik.setForeground(Color.WHITE);
		lblBaslik.setBounds(10, 4, 241, 30);
		frame.getContentPane().add(lblBaslik);

		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(66, 140, 33, 40);
		frame.getContentPane().add(lblX);

		JLabel lblToplamTutar = new JLabel("Toplam Tutar :");
		lblToplamTutar.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblToplamTutar.setForeground(Color.WHITE);
		lblToplamTutar.setBounds(10, 40, 100, 14);
		frame.getContentPane().add(lblToplamTutar);

		JLabel lblDate = new JLabel();
		lblDate.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBackground(new Color(255, 0, 0));
		lblDate.setBounds(363, 14, 130, 20);
		frame.getContentPane().add(lblDate);

		JLabel lblTL = new JLabel("");
		lblTL.setBackground(Color.WHITE);
		lblTL.setIcon(new ImageIcon(SatisEkrani.class.getResource("/image/tl.png")));
		lblTL.setBounds(213, 53, 70, 76);
		lblTL.setOpaque(true);
		frame.getContentPane().add(lblTL);

		table.setModel(modelim);
		JButton btnEkle = new JButton("EKLE");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu = "select * from urunlistesi where idurunlistesi=" + textId.getText();
				ResultSet rs = bag.yap(sorgu);
				String sorgu3 = null;
				try {
					while (rs.next()) {
						satirlar[0] = rs.getString("urunAdi");
						satirlar[1] = txtAdet.getText();
						satirlar[2] = rs.getString("satisFiyati");
						toplam2 = Double.parseDouble(rs.getString("satisFiyati")) * Integer.parseInt(txtAdet.getText());
						satirlar[3] = toplam2;
						modelim.addRow(satirlar);
						adet2 = rs.getInt("adet"); // adet tablodaki sütunun adı / adet2 değişken adı

						Date simdikiZaman = new Date();////////////////////////////////////////////////////////////////////////////////////////////////////////////
						// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////df global oluşturdum// yukarıda
						lblDate.setText(df.format(simdikiZaman));//////////////////////////////////////////////////////////////////////////////////////////////////
						sorgu3 = "INSERT INTO satilanUrun(idsatilanUrun,urunAdi,satilanAdet,alisFiyati,satisFiyati,toplamFiyati,date) VALUES ('"
										+rs.getString("idurunLİstesi") + "','" + rs.getString("urunAdi") + "','" + txtAdet.getText()+ "','" + /////////////////////////////////////// birini seç 1
										rs.getString("alisFiyati") + "','" + rs.getString("satisFiyati") + "'," + toplam2 + ",'"+ df.format(simdikiZaman) + "')";//////////////////

					}
				} catch (SQLException e1) {

					e1.printStackTrace();
					System.out.println("hata");
					JOptionPane.showMessageDialog(null, "hata");

				}

				table.setModel(modelim);

				toplam += toplam2; // toplam2 ara bir toplama işlemi
				lblToplam.setText(Double.toString(toplam));

				int yeniAdet = adet2 - Integer.parseInt(txtAdet.getText());
				String sorgu5 = "UPDATE urunlistesi set adet=" + yeniAdet + " where idurunListesi=" + textId.getText();
				bag.update(sorgu5);
				bag.ekle(sorgu3);///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// birini
									///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// seç
									///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 1_2
			}
		});
		btnEkle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEkle.setBounds(293, 148, 60, 30);
		frame.getContentPane().add(btnEkle);

		JButton btnYeniSatis = new JButton("YENİ SATIŞ");
		btnYeniSatis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date simdikiZaman = new Date();
				lblDate.setText(df.format(simdikiZaman));
				
//				String sorgu4 = "INSERT INTO satisraporu(satisToplami,date) VALUES ('" + lblToplam.getText() + "','"
//										+ df.format(simdikiZaman) + "')";
//					bag.ekle(sorgu4);		

				textId.setText("");
				lblToplam.setText("");
				txtAdet.setText("1");
				modelim.setRowCount(0);
				toplam = 0;

			}
		});
		btnYeniSatis.setBounds(10, 417, 110, 23);
		frame.getContentPane().add(btnYeniSatis);

		JButton btnFis = new JButton("FİŞ");
		btnFis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				git = new Fis(toplam, modelim);

			}
		});
		btnFis.setBounds(250, 417, 110, 23);
		frame.getContentPane().add(btnFis);

		JButton btnMenu = new JButton("MENÜ");

		btnMenu.setBounds(464, 417, 110, 23);
		frame.getContentPane().add(btnMenu);

		JButton btnIade = new JButton("İADE");
		btnIade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iade = new Iade();

			}
		});
		btnIade.setBounds(130, 417, 110, 23);
		frame.getContentPane().add(btnIade);

	}

	public void actionPerformed(ActionEvent ae) {
		JButton jb = (JButton) ae.getSource();
		String s = jb.getText();

		if (s == "0")
			txtAdet.setText(txtAdet.getText() + "0");
		else if (s == "1")
			txtAdet.setText(txtAdet.getText() + "1");
		else if (s == "2")
			txtAdet.setText(txtAdet.getText() + "2");
		else if (s == "3")
			txtAdet.setText(txtAdet.getText() + "3");
		else if (s == "4")
			txtAdet.setText(txtAdet.getText() + "4");
		else if (s == "5")
			txtAdet.setText(txtAdet.getText() + "5");
		else if (s == "6")
			txtAdet.setText(txtAdet.getText() + "6");
		else if (s == "7")
			txtAdet.setText(txtAdet.getText() + "7");
		else if (s == "8")
			txtAdet.setText(txtAdet.getText() + "8");
		else if (s == "8")
			txtAdet.setText(txtAdet.getText() + "8");
		else if (s == "9")
			txtAdet.setText(txtAdet.getText() + "9");
		else if (s == "SİL")
			txtAdet.setText("");

	}

	public static JTextField getTextId() {
		return textId;
	}
}
