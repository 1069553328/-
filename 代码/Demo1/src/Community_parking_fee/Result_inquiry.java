package Community_parking_fee;


import java.sql.*;


public class Result_inquiry extends javax.swing.JFrame {

	String username;
	String car_id;
	String uusername;
	String phone;
	int xxx;
    public Result_inquiry(String username, String car_id,String uusername,String phone) {
	 	this.setLocation(600,300);
    	this.uusername = uusername;
    	this.phone = phone;
    	this.username = username;
    	this.car_id = car_id;
    	setTitle("社区停车收费系统");
        f();
        initComponents();
        text1.setEditable(false);
        text1.setText("查询共计："+xxx+" 条信息");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        return_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        text1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            oobject,
            new String [] {
                "车牌号", "姓名", "手机号", "进入时间", "离开时间", "产生费用"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        return_button.setText("返回");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(text1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(518, 518, 518)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(return_button, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void return_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(username).setVisible(true);
            }
        });
    }                                                
    void f() {
    	try {
    		Connection con = (new Connect_db()).get_con();
            Statement statement = con.createStatement(); //创建执行对象
            String sql=null;
            String res_sql = "select count(*) from access_record where car_id='" + car_id + "'";
            ResultSet res_count = statement.executeQuery(res_sql);
            res_count.next();
            xxx = res_count.getInt(1);
            res_count.close();
            if(xxx == 0) {
            	this.dispose();
				java.awt.EventQueue.invokeLater(new Runnable() {
		            public void run() {
		                new Fail_inquiry(username).setVisible(true);
		            }
		        });
            }
            sql = "select * from access_record where car_id='" + car_id + "'order by ID desc";
            ResultSet rs = statement.executeQuery(sql);
            int i = 0, j = 0;
            oobject = new Object[xxx][6];
            while(rs.next()) {
            	oobject[i][0] = car_id;
            	oobject[i][1] = uusername;
            	oobject[i][2] = phone;
            	oobject[i][3] = rs.getString(3);
            	oobject[i][4] = rs.getString(4);
            	oobject[i][5] = rs.getString(5);
            	i++;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }


    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton return_button;
    private javax.swing.JTextPane text1;
    private Object oobject[][];
    // End of variables declaration                   
}

