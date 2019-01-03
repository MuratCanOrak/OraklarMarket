package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fis {
	private JFrame frame;
	private JTable table;

	public Fis(double toplam, DefaultTableModel modelim) {
		initialize(toplam, modelim);

	}

	private void initialize(double toplam, DefaultTableModel modelim) {

		frame = new JFrame("FÝÞ");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 350, 500);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JLabel lblBaslik = new JLabel("ORAKLAR MARKET");
		lblBaslik.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaslik.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		lblBaslik.setBounds(10, 26, 314, 42);
		frame.getContentPane().add(lblBaslik);

		JLabel lblDate = new JLabel();
		lblDate.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblDate.setForeground(Color.BLACK);
		lblDate.setBackground(Color.WHITE);
		lblDate.setBounds(217, 79, 107, 20);
		frame.getContentPane().add(lblDate);
		Date simdikiZaman = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:m");
		lblDate.setText(df.format(simdikiZaman));

		JScrollPane scrollPaneFis = new JScrollPane();
		scrollPaneFis.setBounds(10, 110, 314, 269);
		frame.getContentPane().add(scrollPaneFis);

		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPaneFis.setViewportView(table);
		table.setModel(modelim);

		JLabel lblToplam = new JLabel("Toplam: ");
		lblToplam.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblToplam.setBounds(158, 393, 62, 14);
		frame.getContentPane().add(lblToplam);

		JLabel lblSon = new JLabel("YÝNE BEKLERÝZ");
		lblSon.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblSon.setBounds(106, 423, 128, 27);
		frame.getContentPane().add(lblSon);

		JLabel lblSonuc = new JLabel("");
		lblSonuc.setBounds(230, 390, 94, 20);
		lblSonuc.setText(Double.toString(toplam) + " TL");
		frame.getContentPane().add(lblSonuc);
		
		
		frame.setVisible(true);

	}
}
