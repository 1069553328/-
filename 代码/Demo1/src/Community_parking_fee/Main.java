/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community_parking_fee;

import java.awt.*;
import javax.swing.*;



public class Main extends javax.swing.JFrame {

	String username;
    public Main(String username) {
	 	this.setLocation(600,300);
    	ImageIcon icon=new ImageIcon("./images/timg.jpg"); 
        JLabel lbBg = new JLabel(icon);
        lbBg.setBounds(0, 0, 700, 433);
        this.getContentPane().add(lbBg);
    	this.username = username;
        initComponents();
        setTitle("社区停车收费系统");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        xiugaimima = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        chepaihaochaxun = new javax.swing.JMenuItem();
        yonghubianhaochaxun = new javax.swing.JMenuItem();
        shoujihaochaxun = new javax.swing.JMenuItem();
        yonghucaozuo = new javax.swing.JMenu();
        guanliyuan = new javax.swing.JMenuItem();
        yezhu = new javax.swing.JMenuItem();
        lishiyonghu = new javax.swing.JMenuItem();
        chaxunyonghu = new javax.swing.JMenuItem();
        shanchuyonghu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jiluliuyan = new javax.swing.JMenuItem();
        liuyanzhanshi = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jinrushequ = new javax.swing.JMenuItem();
        likaishequ = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        tuichu = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("系统操作");

        xiugaimima.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        xiugaimima.setText("修改密码");
        xiugaimima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xiugaimimaActionPerformed(evt);
            }
        });
        jMenu1.add(xiugaimima);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("车辆进出记录查询");

        chepaihaochaxun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        chepaihaochaxun.setText("按车牌号查询");
        chepaihaochaxun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chepaihaochaxunActionPerformed(evt);
            }
        });
        jMenu2.add(chepaihaochaxun);

        yonghubianhaochaxun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        yonghubianhaochaxun.setText("按用户编号查询");
        yonghubianhaochaxun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yonghubianhaochaxunActionPerformed(evt);
            }
        });
        jMenu2.add(yonghubianhaochaxun);

        shoujihaochaxun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        shoujihaochaxun.setText("按手机号查询");
        shoujihaochaxun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoujihaochaxunActionPerformed(evt);
            }
        });
        jMenu2.add(shoujihaochaxun);

        jMenuBar1.add(jMenu2);

        yonghucaozuo.setText("用户操作");

        guanliyuan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        guanliyuan.setText("添加管理员");
        guanliyuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guanliyuanActionPerformed(evt);
            }
        });
        yonghucaozuo.add(guanliyuan);

        yezhu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        yezhu.setText("添加业主");
        yezhu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yezhuActionPerformed(evt);
            }
        });
        yonghucaozuo.add(yezhu);

        lishiyonghu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        lishiyonghu.setText("添加临时用户");
        lishiyonghu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lishiyonghuActionPerformed(evt);
            }
        });
        yonghucaozuo.add(lishiyonghu);

        chaxunyonghu.setText("查询用户");
        chaxunyonghu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chaxunyonghuActionPerformed(evt);
            }
        });
        yonghucaozuo.add(chaxunyonghu);

        shanchuyonghu.setText("删除用户");
        shanchuyonghu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shanchuyonghuActionPerformed(evt);
            }
        });
        yonghucaozuo.add(shanchuyonghu);

        jMenuBar1.add(yonghucaozuo);

        jMenu4.setText("用户留言区");

        jiluliuyan.setText("记录留言");
        jiluliuyan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jiluliuyanActionPerformed(evt);
            }
        });
        jMenu4.add(jiluliuyan);

        liuyanzhanshi.setText("留言展示");
        liuyanzhanshi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liuyanzhanshiActionPerformed(evt);
            }
        });
        jMenu4.add(liuyanzhanshi);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("费用公示");

        jinrushequ.setText("进入社区");
        jinrushequ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jinrushequActionPerformed(evt);
            }
        });
        jMenu5.add(jinrushequ);

        likaishequ.setText("离开社区");
        likaishequ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                likaishequActionPerformed(evt);
            }
        });
        jMenu5.add(likaishequ);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("注销");

        tuichu.setText("退出当前用户");
        tuichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuichuActionPerformed(evt);
            }
        });
        jMenu6.add(tuichu);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void xiugaimimaActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	this.dispose();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Update_admin(username).setVisible(true);
			}
		});
    }                                          

    private void yonghubianhaochaxunActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Id_inquiry(username).setVisible(true);
            }
        });
    }                                                   

    private void guanliyuanActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Add_admin(username).setVisible(true);
			}
		});
    }                                          

    private void chepaihaochaxunActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Car_id_inquiry(username).setVisible(true);
            }
        });
    }                                               

    private void shoujihaochaxunActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    	this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Phone_inquiry(username).setVisible(true);
			}
		});
    }                                                      

    private void yezhuActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_user(username).setVisible(true);
            }
        });
    }                                     

    private void lishiyonghuActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Add_casual_user(username).setVisible(true);
			}
		});
    }                                           

    private void liuyanzhanshiActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show_message(username).setVisible(true);
            }
        });
    }                                             

    private void jinrushequActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Car_in(username).setVisible(true);
            }
        });
    }                                          

    private void tuichuActionPerformed(java.awt.event.ActionEvent evt) {                                  
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }                                      

    private void likaishequActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Car_out(username).setVisible(true);
            }
        });
    }                                          

    private void jiluliuyanActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_message(username).setVisible(true);
            }
        });
    }                                          

    private void chaxunyonghuActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Show_user(username,"").setVisible(true);
            }
        });
    }                                            

    private void shanchuyonghuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    	this.dispose();
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Del_user(username).setVisible(true);
            }
        });
    }                                             



    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem chaxunyonghu;
    private javax.swing.JMenuItem chepaihaochaxun;
    private javax.swing.JMenuItem guanliyuan;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jiluliuyan;
    private javax.swing.JMenuItem jinrushequ;
    private javax.swing.JMenuItem likaishequ;
    private javax.swing.JMenuItem lishiyonghu;
    private javax.swing.JMenuItem liuyanzhanshi;
    private javax.swing.JMenuItem shanchuyonghu;
    private javax.swing.JMenuItem shoujihaochaxun;
    private javax.swing.JMenuItem tuichu;
    private javax.swing.JMenuItem xiugaimima;
    private javax.swing.JMenuItem yezhu;
    private javax.swing.JMenuItem yonghubianhaochaxun;
    private javax.swing.JMenu yonghucaozuo;
    // End of variables declaration                   
}
