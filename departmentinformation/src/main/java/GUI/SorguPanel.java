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
		
		//Layout tipi,�er�eve,Renk ve boyut de�i�kenleri belirlendi.
		this.setLayout(new FlowLayout());
	  	this.setBorder(BorderFactory.createTitledBorder("SORGU"));
    	this.setBackground(Color.white);
    	this.setPreferredSize(new Dimension(585, 60));
    	
    	//Aray�zde g�r�nt�lenecek text olu�turuldu.
    	JLabel textView = new JLabel("Bir departmant numaras� giriniz :");
    	this.add(textView);
    	
    	//Departman numaras�n�n girilece�i textField olu�turuldu.
    	entry = new JTextField();
    	entry.setPreferredSize(new Dimension(20, 20));
    	//entry.getText();
    	this.add(entry);
    	
    	//No'su girilen departman�n bilgisini g�sterecek buton eklendi.
    	JButton btnDeptBilgisi = new JButton("Dept.Bilgisini G�ster");
    	btnDeptBilgisi.setToolTipText("No'su girilen departman�n bilgisini g�ster.");
    	this.add(btnDeptBilgisi);
    	//Butona listener eklendi.
    	btnDeptBilgisi.addActionListener(new DeptBilgisi(this,connection,cPanel));
    	
    	//�al��an ekleyecek buton eklendi.
    	JButton btnCalisanEkle = new JButton("Calisan Ekle");
    	btnCalisanEkle.setToolTipText("Calisan Ekle");
    	this.add(btnCalisanEkle);
    	//Butona listener eklendi.
    	btnCalisanEkle.addActionListener(new CalisanEkle(this,connection));
    	
    	//Program� ve veri taban� ba�lant�s�n� kapat�cak buton eklendi.
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
