package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class ListelemeGenelMudur {
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = { "TC", "Ýsim", "Parola", "Kýdem", "Adres", "Telefon", "Mail " };
	Object[] satirlar = new Object[7];

	Baglanti bag = new Baglanti();

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListelemeGenelMudur window = new ListelemeGenelMudur();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListelemeGenelMudur() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Genel Müdür");
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(50, 100, 1250, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 45, 1205, 404);
		frame.getContentPane().add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBackground(Color.BLUE);

		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setModel(modelim);
		modelim.setColumnIdentifiers(kolonlar);

		String sorgu = "select * from genel_mudur ";
		ResultSet rs = bag.yap(sorgu);
		try {
			while (rs.next()) {
				satirlar[0] = rs.getString("tc");
				satirlar[1] = rs.getString("isim");
				satirlar[2] = rs.getString("parola");
				satirlar[3] = rs.getString("kýdem");
				satirlar[4] = rs.getString("adres");
				satirlar[5] = rs.getString("telefon");
				satirlar[6] = rs.getString("mail");
				modelim.addRow(satirlar);

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		table.setModel(modelim);

		lblNewLabel = new JLabel("GENEL MÜDÜR");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(510, 11, 204, 24);
		frame.getContentPane().add(lblNewLabel);

	}

}
