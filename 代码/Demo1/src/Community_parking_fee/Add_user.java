package Community_parking_fee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Add_user extends javax.swing.JFrame {

	String username ;
	int parking_flag=0;
    public Add_user(String username) {
	 	this.setLocation(600,300);
    	this.username = username;
    	setTitle("社区停车收费系统");
        initComponents();
    	havnt_button.setSelected(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id_text = new javax.swing.JTextField();
        name_text = new javax.swing.JTextField();
        phone_text = new javax.swing.JTextField();
        address_text = new javax.swing.JTextField();
        return_button = new javax.swing.JButton();
        post_button = new javax.swing.JButton();
        hava_button = new javax.swing.JRadioButton();
        havnt_button = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel1.setText("注册新用户");

        jLabel2.setFont(new java.awt.Font("幼圆", 1, 15)); // NOI18N
        jLabel2.setText("车牌号：");

        jLabel3.setFont(new java.awt.Font("幼圆", 1, 15)); // NOI18N
        jLabel3.setText("姓名：");

        jLabel4.setFont(new java.awt.Font("幼圆", 1, 15)); // NOI18N
        jLabel4.setText("手机号：");

        jLabel5.setFont(new java.awt.Font("幼圆", 1, 15)); // NOI18N
        jLabel5.setText("家庭住址：");

        id_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_textActionPerformed(evt);
            }
        });

        name_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_textActionPerformed(evt);
            }
        });

        phone_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_textActionPerformed(evt);
            }
        });

        address_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_textActionPerformed(evt);
            }
        });

        return_button.setText("返回");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        post_button.setText("提交");
        post_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post_buttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(hava_button);
        hava_button.setText("已购买车位");
        hava_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hava_buttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(havnt_button);
        havnt_button.setText("未购买车位");
        havnt_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                havnt_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(post_button, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(hava_button)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(havnt_button))
                                .addComponent(id_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(phone_text, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(name_text)
                                .addComponent(address_text, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone_text, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address_text, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hava_button)
                    .addComponent(havnt_button))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(return_button)
                    .addComponent(post_button))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void id_textActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void name_textActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void phone_textActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void address_textActionPerformed(java.awt.event.ActionEvent evt) {                                             
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
    String name = "";
    String phone = "";
    String address = "";
    int flag = 1;
    void get_text() {
    	this.car_id = id_text.getText();
    	this.name = name_text.getText();
    	this.phone = phone_text.getText();
    	this.address = address_text.getText();
    	add_user();
    }
    void add_user() {
    	if(!car_id.equals("")&& !name.equals("")&&!phone.equals("")&&!address.equals("")){
    		Connection con = (new Connect_db()).get_con();
        	Statement sql = null;
        	ResultSet res;
        	try {
        		sql = con.createStatement();
        		String table_carid = "'"+car_id+"'";
        		res = sql.executeQuery("select * from users where car_id="+table_carid);
        		if(!res.next()) {//如果找到
        			res.close();
        			String insertsql = "insert into users values(?,?,?,?,?,?);";
        			PreparedStatement psta = con.prepareStatement(insertsql);
        			psta.setString(1, this.car_id);
        			psta.setString(2, this.name);
        			psta.setString(3, this.phone);
        			psta.setString(4, this.address);
        			psta.setInt(5, this.flag);
        			psta.setInt(6, this.parking_flag);
        			psta.addBatch();
        			psta.executeBatch();
        			psta.close();
        			con.close();
        			this.dispose();
        			java.awt.EventQueue.invokeLater(new Runnable() {
        				public void run() {
        					new Main(username).setVisible(true);
        				}
        			});
        		}
        		else {
        			res.close();
        			this.dispose();
        			java.awt.EventQueue.invokeLater(new Runnable() {
        				public void run() {
        					new Add_admin_fail(username).setVisible(true);
        				}
        			});
        		}
        	}catch(Exception e)
        	{
        		System.out.println(e);
        	}
    	}
    	else {
    		this.dispose();
    		java.awt.EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				new Add_admin_fail(username).setVisible(true);
    			}
    		});
    	}
    }
    private void post_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	get_text();
    	System.out.println(parking_flag);
    }                                             

    private void hava_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	parking_flag = 1;
    }                                           

    private void havnt_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            



    // Variables declaration - do not modify                     
    private javax.swing.JTextField address_text;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton hava_button;
    private javax.swing.JRadioButton havnt_button;
    private javax.swing.JTextField id_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name_text;
    private javax.swing.JTextField phone_text;
    private javax.swing.JButton post_button;
    private javax.swing.JButton return_button;
    // End of variables declaration                   
}

