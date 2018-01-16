package Community_parking_fee;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Car_in extends javax.swing.JFrame {

	String username;
    public Car_in(String username) {
	 	this.setLocation(600,300);
        this.username = username;
        setTitle("社区停车收费系统");
    	initComponents();
    	show_car_num();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        post_button = new javax.swing.JButton();
        text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        return_button = new javax.swing.JButton();
        show_carnum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        post_button.setText("提交");
        post_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post_buttonActionPerformed(evt);
            }
        });

        text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel1.setText("车牌号：");

        return_button.setText("返回");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        show_carnum.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(189, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(show_carnum, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(return_button)
                        .addGap(33, 33, 33)
                        .addComponent(post_button))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(show_carnum, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(return_button)
                    .addComponent(post_button))
                .addGap(143, 143, 143))
        );

        pack();
    }// </editor-fold>                        
    String car_id="";
    private void post_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	this.car_id = text.getText();
    	try {		
    		Connection con = (new Connect_db()).get_con();
        	Statement stat = null;
        	ResultSet res;
			stat = con.createStatement();
			String table_car_id = "'"+this.car_id+"'";
    		res = stat.executeQuery("select * from users where car_id="+table_car_id);
    		
    		if(res.next()) {
    			String sql = "select * from cost_timing where car_id="+table_car_id;
    			res = stat.executeQuery(sql);
    			if(res.next()) {
    				res.close();
    				con.close();
    				this.dispose();
    				java.awt.EventQueue.invokeLater(new Runnable() {
        	            public void run() {
        	                new Car_in_fail2(username).setVisible(true);
        	            }
        	        });
    			}
    			else {
	    			String insertsql = "insert into cost_timing values(?,?);";
	    			PreparedStatement psta = con.prepareStatement(insertsql);
	    			psta.setString(1, this.car_id);
	    			Date day=new Date();    
	    			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    			psta.setString(2,df.format(System.currentTimeMillis()));
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
    		}
    		else {
    			res.close();
    			con.close();
    			this.dispose();
    	    	java.awt.EventQueue.invokeLater(new Runnable() {
    	            public void run() {
    	                new Car_in_fail(username).setVisible(true);
    	            }
    	        });
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	
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

    private void textActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    
    
    void show_car_num() {
    	String car_num;
    	try {
	    	Connection con = (new Connect_db()).get_con();
	    	Statement stat = null;
	    	ResultSet res;
			stat = con.createStatement();
			res = stat.executeQuery("select count('car_id') from cost_timing ");
			res.next();
			car_num = "剩余车位数："+String.valueOf(600-res.getInt(1));
			show_carnum.setText(car_num);
			res.close();
			con.close();
    	}catch(Exception e) {
    		System.out.println(e);
    	}
		
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton post_button;
    private javax.swing.JButton return_button;
    private javax.swing.JLabel show_carnum;
    private javax.swing.JTextField text;
    // End of variables declaration                   
}


class Car_in_fail extends javax.swing.JFrame {

    /**
     * Creates new form Car_in_fail
     */
	String username;
    public Car_in_fail(String username) {
	 	this.setLocation(600,300);
    	this.username = username;
    	setTitle("社区停车收费系统");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        yonghu = new javax.swing.JButton();
        lingshiyonghu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel1.setText("车辆未在系统注册！");

        yonghu.setText("注册用户");
        yonghu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yonghuActionPerformed(evt);
            }
        });

        lingshiyonghu.setText("注册临时用户");
        lingshiyonghu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lingshiyonghuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lingshiyonghu)
                            .addComponent(yonghu, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(262, 262, 262))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(yonghu)
                .addGap(31, 31, 31)
                .addComponent(lingshiyonghu)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void yonghuActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_user(username).setVisible(true);
            }
        });
    }                                    

    private void lingshiyonghuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_casual_user(username).setVisible(true);
            }
        });
    }                                              



    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton lingshiyonghu;
    private javax.swing.JButton yonghu;
    // End of variables declaration                   
}




class Car_in_fail2 extends javax.swing.JFrame {

    /**
     * Creates new form Car_in_fail2
     */
	String username;
    public Car_in_fail2(String username) {
	 	this.setLocation(600,300);
    	this.username = username;
    	setTitle("社区停车收费系统");
    	initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        post_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel1.setText("该号码车辆已进入社区中，请核实车辆信息");

        post_button.setText("确定");
        post_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(148, 148, 148))
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(post_button, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(post_button)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void post_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Car_in(username).setVisible(true);
            }
        });
    }                                           


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton post_button;
    // End of variables declaration                   
}

