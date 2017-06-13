package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CiktiPanel extends JPanel {
	  
	private JTable table;
	private DefaultTableModel tableModel;
	
	public CiktiPanel(){
		
		//Layout tipi,Çerçeve,Renk ve boyut deðiþkenleri belirlendi.
    	this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("ÇIKTI"));
    	this.setBackground(Color.white);
    	this.setPreferredSize(new Dimension(585, 400));
    	
    	//Tablo belirlenen modele göre oluþturuldu ve boyutu belirlendi.
    	table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        tableModel = new DefaultTableModel(new Object[]{"Ad","Soyad","SSN","DTarihi","Cinsiyet","Maas"},0);
        table.setModel(tableModel);
        //tableModel.addRow(new Object[]{"2","2","2","2","2","2","2"});
        
        
        // Kaydýrma çubuðu oluþturuldu ve tablo panele eklendi.
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);      
         
	}
	
	public DefaultTableModel getTableModel(){
		return tableModel;
	}
}
