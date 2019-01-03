package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ListelemeSatis {
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = { "BARKOD", "ADI", "Satýlan Adet", "Alis Fiyati", "Satis Fiyati", "Toplam ", "Tarih" };
	Object[] satirlar = new Object[7];

	Baglanti bag = new Baglanti();

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblSatlanrnler;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListelemeSatis window = new ListelemeSatis();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListelemeSatis() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame("Satýlan Ürünler");
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


				String sorgu = "select * from satilanurun ";
				ResultSet rs = bag.yap(sorgu);
				try {
					while (rs.next()) {
						satirlar[0] = rs.getString("idsatilanUrun");
						satirlar[1] = rs.getString("urunAdi");
						satirlar[2] = rs.getString("satilanAdet");
						satirlar[3] = rs.getString("alisFiyati");
						satirlar[4] = rs.getString("satisFiyati");
						satirlar[5] = rs.getString("toplamFiyati");
						satirlar[6] = rs.getString("date");
						modelim.addRow(satirlar);
						
						
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

		table.setModel(modelim);
		
		lblSatlanrnler = new JLabel("SATILAN ÜRÜNLER");
		lblSatlanrnler.setForeground(Color.WHITE);
		lblSatlanrnler.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSatlanrnler.setBounds(503, 10, 224, 24);
		frame.getContentPane().add(lblSatlanrnler);
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
