package Community_parking_fee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

public class Car_out extends javax.swing.JFrame {

    /**
     * Creates new form car_out
     */
	String username;
    public Car_out(String username) {
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
        endcost = new javax.swing.JButton();
        return_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel1.setText("车牌号：");

        endcost.setText("结算");
        endcost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endcostActionPerformed(evt);
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
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(endcost, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endcost, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(return_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        
    String car_id="";
    String out_time="";
    String in_time="";
    String res_time="";
    String res_cost="";
    private void endcostActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    	this.car_id = text.getText();
		try {
			Connection con = (new Connect_db()).get_con();
        	Statement sta = null;
        	ResultSet res;
			sta = con.createStatement();
			String table_car_id = "'"+this.car_id+"'";
    		res = sta.executeQuery("select * from cost_timing where car_id="+table_car_id);
    		if(res.next()) {
	    		this.in_time = res.getString("in_time");
	    		res.close();
		    	Date day=new Date();    
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				out_time = df.format(System.currentTimeMillis());
				Calendar c = Calendar.getInstance();
                c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(in_time));
                long in_time1 = c.getTimeInMillis();
                c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(out_time));
                long out_time1 = c.getTimeInMillis();
                float res_hour = (float)(out_time1-in_time1)/(1000*60*60);
                res_cost = String.valueOf(res_hour*15);
        		String delsql = "delete from cost_timing where car_id = '"+car_id+"'";
        		sta.executeUpdate(delsql);	//执行并更新数据库数据
        		String insertsql = "insert into access_record values(?,?,?,?);";
    			PreparedStatement psta = con.prepareStatement(insertsql);
    			psta.setString(1, this.car_id);
    			psta.setString(2, this.in_time);
    			psta.setString(3, this.out_time);
    			psta.setString(4, this.res_cost);
    			psta.addBatch();
    			psta.executeBatch();
    			psta.close();
    			con.close();
    			String ress_hour = String.valueOf(res_hour);
    			this.dispose();
    	    	java.awt.EventQueue.invokeLater(new Runnable() {
    	            public void run() {
    	                new Show_cost(username,car_id,in_time,out_time,ress_hour,res_cost).setVisible(true);
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


    // Variables declaration - do not modify                     
    private javax.swing.JButton endcost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton return_button;
    private javax.swing.JTextField text;
    // End of variables declaration                   
}

class Show_cost extends javax.swing.JFrame {

    
	String username;
	String car_id;
	String in_time;
	String out_time;
	String res_hour;
	String res_cost;
    public Show_cost(String username,String car_id,String in_time,String out_time,String res_hour,String res_cost) {

	 	this.setLocation(600,300);
	 	System.out.println("start");
    	this.username = username;
    	this.car_id = car_id;
    	this.in_time = in_time;
    	this.out_time = out_time;
    	this.res_hour = res_hour;
    	this.res_cost = res_cost;
    	setTitle("社区停车收费系统");
    	initComponents();
    	show_text();
    	car_id_text.setEditable(false);
    	in_time_text.setEditable(false);
    	out_time_text.setEditable(false);
    	time_text.setEditable(false);
    	cost_text.setEditable(false);
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
        car_id_text = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        in_time_text = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        out_time_text = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        time_text = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        cost_text = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        close_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(car_id_text);

        jScrollPane2.setViewportView(in_time_text);

        jScrollPane3.setViewportView(out_time_text);

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel1.setText("车牌号：");

        jLabel2.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel2.setText("进入时间：");

        jLabel3.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel3.setText("离开时间：");

        jScrollPane4.setViewportView(time_text);

        jLabel4.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel4.setText("共计小时数：");

        jScrollPane5.setViewportView(cost_text);

        jLabel5.setFont(new java.awt.Font("幼圆", 1, 18)); // NOI18N
        jLabel5.setText("共计花费：");

        close_button.setText("关闭");
        close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(159, 159, 159)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                .addComponent(jScrollPane4)
                                .addComponent(jScrollPane5)))))
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel4)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void close_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(username).setVisible(true);
            }
        });
    }                                            
    void show_text(){
    	try {
	    	Connection con = (new Connect_db()).get_con();
	    	Statement sta = null;
	    	ResultSet res;
			sta = con.createStatement();
			String table_car_id = "'"+this.car_id+"'";
			res = sta.executeQuery("select * from users where car_id="+table_car_id);
			res.next();
			if(res.getInt("parking")==1) {
				this.res_cost = "已购买车位，此次停车费为：0元";
			}
			else {
				if(Float.parseFloat(this.res_hour)<1.0) {
					this.res_cost = "15";
				}
				this.res_cost = "此次停车费为："+this.res_cost+"元";
			}
			res.close();
			con.close();
			car_id_text.setText(this.car_id);
			in_time_text.setText(this.in_time);
			out_time_text.setText(this.out_time);
			time_text.setText(this.res_hour);
			cost_text.setText(this.res_cost);
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }


    // Variables declaration - do not modify                     
    private javax.swing.JTextPane car_id_text;
    private javax.swing.JButton close_button;
    private javax.swing.JTextPane cost_text;
    private javax.swing.JTextPane in_time_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane out_time_text;
    private javax.swing.JTextPane time_text;
    // End of variables declaration                   
}
