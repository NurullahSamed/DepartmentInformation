package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import departmentinformation.CalisanEkle;
import departmentinformation.DeptBilgisi;
import departmentinformation.Kapat;

public class SorguPanel extends JPanel {
	
	private JTextField entry;
	
	public SorguPanel(Connection connection,CiktiPanel cPanel){
		
		//Layout tipi,Çerçeve,Renk ve boyut deðiþkenleri belirlendi.
		this.setLayout(new FlowLayout());
	  	this.setBorder(BorderFactory.createTitledBorder("SORGU"));
    	this.setBackground(Color.white);
    	this.setPreferredSize(new Dimension(585, 60));
    	
    	//Arayüzde görüntülenecek text oluþturuldu.
    	JLabel textView = new JLabel("Bir departmant numarasý giriniz :");
    	this.add(textView);
    	
    	//Departman numarasýnýn girileceði textField oluþturuldu.
    	entry = new JTextField();
    	entry.setPreferredSize(new Dimension(20, 20));
    	//entry.getText();
    	this.add(entry);
    	
    	//No'su girilen departmanýn bilgisini gösterecek buton eklendi.
    	JButton btnDeptBilgisi = new JButton("Dept.Bilgisini Göster");
    	btnDeptBilgisi.setToolTipText("No'su girilen departmanýn bilgisini göster.");
    	this.add(btnDeptBilgisi);
    	//Butona listener eklendi.
    	btnDeptBilgisi.addActionListener(new DeptBilgisi(this,connection,cPanel));
    	
    	//Çalýþan ekleyecek buton eklendi.
    	JButton btnCalisanEkle = new JButton("Calisan Ekle");
    	btnCalisanEkle.setToolTipText("Calisan Ekle");
    	this.add(btnCalisanEkle);
    	//Butona listener eklendi.
    	btnCalisanEkle.addActionListener(new CalisanEkle());
    	
    	//Programý ve veri tabaný baðlantýsýný kapatýcak buton eklendi.
     	JButton btnKapat = new JButton("Kapat");
     	btnKapat.setToolTipText("Kapat");
    	this.add(btnKapat);
    	//Butona listener eklendi.
    	btnKapat.addActionListener(new Kapat(this,connection));
    	
	}
	
	public JTextField getEntry(){
		return entry;
	}
	
}
