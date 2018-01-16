package Community_parking_fee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Car_id_inquiry extends javax.swing.JFrame {

	/**
	 * Creates new form Id_inquiry
	 */
	String username;

	public Car_id_inquiry(String username) {
	 	this.setLocation(600,300);
		this.username = username;
		setTitle("社区停车收费系统");
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		text = new javax.swing.JTextField();
		post_button = new javax.swing.JButton();
		return_button = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("幼圆", 1, 24)); // NOI18N
		jLabel1.setText("  请输入车牌号码：");

		text.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textActionPerformed(evt);
			}
		});

		post_button.setText("提交");
		post_button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				post_buttonActionPerformed(evt);
			}
		});

		return_button.setText("返回");
		return_button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				return_buttonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(221, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										layout.createSequentialGroup()
												.addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(post_button, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(text)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
						.addGap(208, 208, 208)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(81, 81, 81)
				.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(26, 26, 26)
				.addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(38, 38, 38).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(post_button).addComponent(return_button))
				.addContainerGap(160, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void textActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		this.dispose();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Main(username).setVisible(true);
			}
		});
	}

	String car_id = "";
	String uusername = "";
	String phone = "";

	void get_text() {
		this.car_id = text.getText();
		this.inquiry();
	}

	void inquiry() {
		Connection con = (new Connect_db()).get_con();
		Statement sql = null;
		ResultSet res;
		try {
			sql = con.createStatement();
			String table_car_id = "'" + car_id + "'";
			res = sql.executeQuery("select * from users where car_id=" + table_car_id);
			if(res.next()) {
				uusername = res.getString("username");
				phone = res.getString("phone");
				res.close();
				con.close();
				this.dispose();
				java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                new Result_inquiry(username,car_id,uusername,phone).setVisible(true);
		            }
		        });
			}
			else {
				res.close();
				con.close();
				this.dispose();
				java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                new Fail_inquiry(username).setVisible(true);
		            }
		        });
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void post_buttonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		get_text();
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JButton post_button;
	private javax.swing.JButton return_button;
	private javax.swing.JTextField text;
	// End of variables declaration
}
