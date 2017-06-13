package departmentinformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.SorguPanel;

public class CalisanEkle implements ActionListener{

	private SorguPanel sPanel;
	private Connection conn;
	
	public CalisanEkle(SorguPanel sPanel,Connection connection){
		
		this.sPanel = sPanel;
		this.conn = connection;
	}
	public void actionPerformed(ActionEvent e) {
		
		String ad= JOptionPane.showInputDialog("Calisanin adini giriniz: ");

        String soyad= JOptionPane.showInputDialog("Calisanin soyadini giriniz: ");

        String ssn= JOptionPane.showInputDialog("Calisanin no'sunu giriniz: ");

        String dTarihi= JOptionPane.showInputDialog("Calisanin dogum tarihini giriniz: ");
        
        String cinsiyet= JOptionPane.showInputDialog("Calisanin cinsiyetini giriniz: ");
        
        String maas= JOptionPane.showInputDialog("Calisanin maas bilgisini giriniz: ");
        
        String dNo= JOptionPane.showInputDialog("Calisanin departman bilgisini giriniz: ");

        Statement st;
        ResultSet rs;
        String sql = "SELECT dept_no FROM departments WHERE dept_no ='"+dNo+"'";
        
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			//Eðer böyle bir departman numarasý yok ise,
			if(!rs.next()){
				JOptionPane.showMessageDialog(sPanel, "Girilen departman geçersiz !");
			}else{
				String sql2 = "INSERT into employees (first_name,last_name,emp_no,birth_date,gender) VALUES ('"+ad+"','"+soyad+"','"+ssn+"','"+dTarihi+"','"+cinsiyet+"')";
				String sql3 = "INSERT into salaries (emp_no,salary) VALUES ('"+ssn+"','"+maas+"')";
				String sql4 = "INSERT into dept_emp (emp_no,dept_no) VALUES ('"+ssn+"','"+dNo+"')";
				st = conn.createStatement();
				st.executeUpdate(sql2);
				st.executeUpdate(sql3);
				st.executeUpdate(sql4);
			}
			rs.close();
			st.close();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(sPanel, e1);
			e1.printStackTrace();
		}
		
	}

}
