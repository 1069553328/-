package Community_parking_fee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Show_user extends javax.swing.JFrame {

    /**
     * Creates new form Show_user
     */
	String username;
	String car_id;
    public Show_user(String username,String car_id) {
	 	this.setLocation(600,300);
    	this.username = username;
    	this.car_id = car_id;
    	setTitle(username);
        f();
        initComponents();
        show_num_text.setText("共有："+xxx+"信息");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        return_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        car_id_text = new javax.swing.JTextField();
        post_button = new javax.swing.JButton();
        show_num_text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            oobject,
            new String [] {
                "用户编号", "车牌号码", "用户姓名", "联系电话", "家庭地址", "临时用户", "停车位"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        return_button.setText("返回");
        return_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_buttonActionPerformed(evt);
            }
        });

        jLabel1.setText("车牌号:");

        post_button.setText("查询");
        post_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(show_num_text, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(car_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(post_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(return_button))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addComponent(show_num_text, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(return_button)
                            .addComponent(post_button)
                            .addComponent(car_id_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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
    private void post_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:                            
    	car_id = car_id_text.getText();
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show_user(username,car_id).setVisible(true);
            }
        });
    	
    }    
    int xxx;
    void f() {
    	try {
    		Connection con = (new Connect_db()).get_con();
            Statement statement = con.createStatement(); //创建执行对象
            String sql=null;
            String res_sql=null;
            if(car_id.equals("")) {
            	res_sql = "select count(*) from users ";
                sql = "select *from users";
            }
            else {
            	res_sql = "select count(*) from users where car_id='"+car_id+"'";
            	sql = "select *from users where car_id='"+car_id+"'";
            }
            ResultSet res_count = statement.executeQuery(res_sql);
            res_count.next();
            xxx = res_count.getInt(1);
            res_count.close();
            ResultSet rs = statement.executeQuery(sql);
            int i = 0;
            oobject = new Object[xxx][7];
            String user_flag = "是";
            String park_flag = "无";
            while(rs.next()) {
            	if(rs.getInt(6)==1) {
            		user_flag="否";
            	}else {
            		user_flag="是";
            	}
            	if(rs.getInt(7)==1) {
            		park_flag = "有";
            	}else {
            		park_flag = "无";
            	}
            	oobject[i][0] = rs.getInt(1);
            	oobject[i][1] = rs.getString(2);
            	oobject[i][2] = rs.getString(3);
            	oobject[i][3] = rs.getString(4);
            	oobject[i][4] = rs.getString(5);
            	oobject[i][5] = user_flag;
            	oobject[i][6] = park_flag;
            	i++;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField car_id_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton post_button;
    private javax.swing.JButton return_button;
    private javax.swing.JLabel show_num_text;
    private Object oobject[][];
    // End of variables declaration                   
}
