package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Iade implements ActionListener {

	Baglanti bag = new Baglanti();

	private JFrame frame;
	private JTextField textId, txtAdet;
	int adet2;
	String sorgu3 ;
	DefaultTableModel modelim = new DefaultTableModel();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:m");
	public Iade() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame("ÝADE");
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ADET");
		lblNewLabel.setBounds(44, 69, 33, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ÜRÜN BARKODU");
		lblNewLabel_1.setBounds(183, 69, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textId = new JTextField();
		textId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textId.setFont(new Font("Tahoma", Font.BOLD, 20));
		textId.setBounds(140, 94, 182, 39);
		frame.getContentPane().add(textId);
		textId.setColumns(10);

		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(97, 94, 33, 37);
		frame.getContentPane().add(lblX);

		txtAdet = new JTextField();
		txtAdet.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)|| (c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		txtAdet.setText("1");
		txtAdet.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtAdet.setColumns(10);
		txtAdet.setBounds(34, 94, 53, 39);
		frame.getContentPane().add(txtAdet);

		JButton btn9 = new JButton("9");
		btn9.setBounds(489, 52, 65, 30);
		btn9.addActionListener(this);
		frame.getContentPane().add(btn9);

		JButton btn8 = new JButton("8");
		btn8.setBounds(419, 52, 65, 30);
		btn8.addActionListener(this);
		frame.getContentPane().add(btn8);

		JButton btn7 = new JButton("7");
		btn7.setBounds(349, 52, 65, 30);
		btn7.addActionListener(this);
		frame.getContentPane().add(btn7);

		JButton btn6 = new JButton("6");
		btn6.setBounds(489, 86, 65, 30);
		btn6.addActionListener(this);
		frame.getContentPane().add(btn6);

		JButton btn5 = new JButton("5");
		btn5.setBounds(419, 86, 65, 30);
		btn5.addActionListener(this);
		frame.getContentPane().add(btn5);

		JButton btn4 = new JButton("4");
		btn4.setBounds(349, 86, 65, 30);
		btn4.addActionListener(this);
		frame.getContentPane().add(btn4);

		JButton btn3 = new JButton("3");
		btn3.setBounds(489, 120, 65, 30);
		btn3.addActionListener(this);
		frame.getContentPane().add(btn3);

		JButton btn2 = new JButton("2");
		btn2.setBounds(419, 120, 65, 30);
		btn2.addActionListener(this);
		frame.getContentPane().add(btn2);

		JButton btn1 = new JButton("1");
		btn1.setBounds(349, 120, 65, 30);
		btn1.addActionListener(this);
		frame.getContentPane().add(btn1);

		JButton btn0 = new JButton("0");
		btn0.setBounds(419, 155, 65, 30);
		btn0.addActionListener(this);
		frame.getContentPane().add(btn0);

		JButton btnSil = new JButton("SÝL");
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSil.setBounds(489, 155, 65, 30);
		btnSil.addActionListener(this);
		frame.getContentPane().add(btnSil);

		JButton btnIade = new JButton("ÝADE");
		btnIade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu1 = "select * from urunlistesi where idurunlistesi=" + textId.getText();
				ResultSet res = bag.yap(sorgu1);
				try {
					while (res.next()) {
					
						adet2 = res.getInt("adet");
						Date simdikiZaman = new Date();
						
								int ceviri = Integer.parseInt(txtAdet.getText());
							double topFiyat= res.getDouble("satisFiyati")*ceviri;
				
							sorgu3 = "INSERT INTO iadeurun(idiadeUrun,urunAdi,iadeAdet,alisFiyati,satisFiyati,toplamFiyati,date) VALUES ('"
							+res.getString("idurunListesi")+ "','" +res.getString("urunAdi")+"',"+txtAdet.getText()+ ",'" + res.getDouble("alisFiyati")+ "','" +
							res.getDouble("satisFiyati")+"',"+topFiyat+",'"+df.format(simdikiZaman)+ "')";
						
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				int yeniAdet = adet2 + Integer.parseInt(txtAdet.getText());
				String sorgu = "UPDATE urunlistesi set adet=" + yeniAdet + " where idurunListesi=" + textId.getText();
				bag.update(sorgu);
			
				bag.ekle(sorgu3);
			}
		});
		btnIade.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIade.setBounds(349, 155, 65, 30);
		frame.getContentPane().add(btnIade);

		frame.setVisible(true);

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
		else if (s == "SÝL")
			txtAdet.setText("");

	}
}