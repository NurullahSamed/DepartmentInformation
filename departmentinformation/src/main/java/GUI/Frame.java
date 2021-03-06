package GUI;

import java.awt.FlowLayout;
import java.sql.Connection;
import javax.swing.JFrame;


public class Frame extends JFrame {
	public Frame(Connection connection){
    	
		//Frame kapatıldığında ne olacağı belirlendi.
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//Frame'in layout tipi belirtildi.
    	this.setLayout(new FlowLayout());
    	
    	//Frame'in içerisinde yer alacak iki ana panel oluşturuldu.
    	CiktiPanel ciktiPanel = new CiktiPanel();
    	SorguPanel sorguPanel = new SorguPanel(connection,ciktiPanel);
    	

    	//Bileşenler oluşturulup çerçeveye yerleştirildi
    	this.getContentPane().add(sorguPanel);
    	this.getContentPane().add(ciktiPanel);
    	
    	//Çerçeve boyutlandırıldı.
    	this.pack();
    	
    	//Frame boyutu belirlendi ve boyutu değiştirilemez yapıldı.
    	this.setSize(600, 500);
    	this.setResizable(false);
    	
    	//Görünür yapıldı.
    	this.setVisible(true);
	}
}
