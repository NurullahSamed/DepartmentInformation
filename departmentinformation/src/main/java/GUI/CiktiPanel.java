package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CiktiPanel extends JPanel {

	public CiktiPanel(){
		
    	this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("ÇIKTI"));
    	this.setBackground(Color.white);
    	this.setPreferredSize(new Dimension(585, 400));
    	
	}
}
