package GUI;

import java.awt.FlowLayout;
import java.sql.Connection;
import javax.swing.JFrame;


public class Frame extends JFrame {
	public Frame(Connection connection){
    	
		//Frame kapat�ld���nda ne olaca�� belirlendi.
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//Frame'in layout tipi belirtildi.
    	this.setLayout(new FlowLayout());
    	
    	//Frame'in i�erisinde yer alacak iki ana panel olu�turuldu.
    	SorguPanel sorguPanel = new SorguPanel();
    	CiktiPanel ciktiPanel = new CiktiPanel();
    	

    	//Bile�enler olu�turulup �er�eveye yerle�tirildi
    	this.getContentPane().add(sorguPanel);
    	this.getContentPane().add(ciktiPanel);
    	
    	//�er�eve boyutland�r�ld�.
    	this.pack();
    	
    	//Frame boyutu belirlendi ve boyutu de�i�tirilemez yap�ld�.
    	this.setSize(600, 500);
    	this.setResizable(false);
    	
    	//G�r�n�r yap�ld�.
    	this.setVisible(true);
	}
}
