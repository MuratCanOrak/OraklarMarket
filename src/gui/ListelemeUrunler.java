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
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListelemeUrunler {
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = { "BARKOD", "ADET","URUN ADI", "ALIÞ FÝYATI", "SATIÞ FÝYATI"};
	Object[] satirlar = new Object[5];

	Baglanti bag = new Baglanti();

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField textid;
	private JTextField textAdet;
	private JTextField textUrunAdi;
	private JTextField textAlisFiyati;
	private JTextField textSatisFiyati;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListelemeUrunler window = new ListelemeUrunler();
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
	public ListelemeUrunler() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("ÜRÜNLER");
		frame.getContentPane().setBackground(Color.RED);
		frame.setBounds(50, 100, 1250, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 45, 1205, 402);
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
		
		textid = new JTextField();
		textid.setBounds(10, 458, 231, 20);
		frame.getContentPane().add(textid);
		textid.setColumns(10);
		
		textAdet = new JTextField();
		textAdet.setColumns(10);
		textAdet.setBounds(251, 458, 231, 20);
		frame.getContentPane().add(textAdet);
		
		textUrunAdi = new JTextField();
		textUrunAdi.setColumns(10);
		textUrunAdi.setBounds(492, 458, 231, 20);
		frame.getContentPane().add(textUrunAdi);
		
		textAlisFiyati = new JTextField();
		textAlisFiyati.setColumns(10);
		textAlisFiyati.setBounds(733, 458, 231, 20);
		frame.getContentPane().add(textAlisFiyati);
		
		textSatisFiyati = new JTextField();
		textSatisFiyati.setColumns(10);
		textSatisFiyati.setBounds(974, 458, 231, 20);
		frame.getContentPane().add(textSatisFiyati);

		JButton btnListele = new JButton("LÝSTELE");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				
				String sorgu2= "UPDATE urunlistesi set adet=" + textAdet.getText() + ",urunAdi='"+textUrunAdi.getText()
				+ "',alisFiyati="+textAlisFiyati.getText() + ",satisFiyati="+textSatisFiyati.getText()+" where idurunListesi=" + textid.getText();
				bag.update(sorgu2);
						
				String sorgu = "SELECT * FROM urunlistesi;";
				ResultSet rs = bag.yap(sorgu);
				
				try {
					while (rs.next()) {
						satirlar[0] = rs.getString("idurunListesi");
						satirlar[1] = rs.getInt("adet");
						satirlar[2] = rs.getString("urunAdi");
						satirlar[3] = rs.getDouble("alisFiyati");
						satirlar[4] = rs.getDouble("satisFiyati");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

				table.setModel(modelim);
				
			
				
				
			}
			
		});

		btnListele.setBounds(996, 489, 164, 23);
		frame.getContentPane().add(btnListele);
		

		JButton btnNewButton_1 = new JButton("YENi KAYIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu3 = "INSERT INTO urunlistesi(idurunListesi,adet,urunAdi,alisFiyati,satisFiyati) VALUES ('"
						+textid.getText() + "','" +textAdet.getText()+ "','" + textUrunAdi.getText()+ "','" +
						textAlisFiyati.getText() + "','" + textSatisFiyati.getText()+ "')";
				
			//	System.out.println("sorgu 3: "+sorgu3);
				bag.ekle(sorgu3);
				
			}
		});
		btnNewButton_1.setBounds(800, 489, 164, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textid.setText(modelim.getValueAt(table.getSelectedRow(), 0).toString());
				textAdet.setText(modelim.getValueAt(table.getSelectedRow(), 1).toString());
				textUrunAdi.setText(modelim.getValueAt(table.getSelectedRow(), 2).toString());
				textAlisFiyati.setText(modelim.getValueAt(table.getSelectedRow(), 3).toString());
				textSatisFiyati.setText( modelim.getValueAt(table.getSelectedRow(), 4).toString());
			}
		});

	}
}
