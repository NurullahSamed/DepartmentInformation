package departmentinformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import GUI.CiktiPanel;
import GUI.SorguPanel;

public class DeptBilgisi implements ActionListener{
	
	private SorguPanel sPanel;
	private JTextField entry;
	private Connection conn;
	private CiktiPanel cPanel;
	private DefaultTableModel tableModel;
	
	public DeptBilgisi(SorguPanel sPanel,Connection connection,CiktiPanel cPanel){
		this.sPanel = sPanel;
		this.conn = connection;
		this.cPanel = cPanel;
		this.tableModel = cPanel.getTableModel();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//Her sorgu yapýldýðýnda bir önceki tabloyu temizle.
		tabloyuTemizle ();
		
		entry = sPanel.getEntry();
		String deptNo = entry.getText();
		boolean isSonucNull = true;
		
		Statement st;
		ResultSet rs;
		
		String querry = "SELECT first_name,last_name,e.emp_no,birth_date,gender,salary "
				+ "FROM employees e, dept_emp d ,salaries s "
				+ "WHERE e.emp_no = s.emp_no and d.emp_no = e.emp_no "
				+ "and d.dept_no = '"+deptNo+"'";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(querry);
			while (rs.next())
			{
				isSonucNull = false;
				//Tabloya sorgu sonucu yazdýrýldý.
				tableModel.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});

			}
			rs.close();
			st.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//Sorgu sonucu null ise ekrana bilgilendirme mesajý yazdýr.
		if(isSonucNull){
			JOptionPane.showMessageDialog(sPanel, "Bu departmana ait kayýt bulunamadý !");
		}
	}
	
	private void tabloyuTemizle (){
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}

}
