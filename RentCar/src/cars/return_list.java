package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Font;
import java.sql.*;
import javax.swing.JRadioButton;

public class return_list extends JFrame {
	
	Vector rowData;
	Vector<String> columnNames;
	JTable jt = null;
	JScrollPane jsp = null;
	private JScrollPane jsp_1;

	// 定义数据库需要的全局变量
	PreparedStatement ps = null;
	Connection ct = null;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public return_list() {

		setTitle("\u6625\u7530\u7BA1\u5BB6");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\umbrella\\Pictures\\M1903.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 862, 609);
		setLocation(550, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		columnNames = new Vector<>();
		// 设置列名
		columnNames.add("用户编号");
		columnNames.add("姓名");
		columnNames.add("车辆编号");
		columnNames.add("归还日期");
		columnNames.add("归还状态");

		rowData = new Vector();
		// rowData可以存放多行,开始从数据库里取

		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage?characterEncoding=UTF-8", "root", "");
			// 得到连接
			ps = ct.prepareStatement("select * from return_list");
			rs = ps.executeQuery();


			rs = ps.executeQuery();

			while (rs.next()) {
				// rowData可以存放多行
				Vector hang = new Vector();
				hang.add(rs.getString("UID"));
				hang.add(rs.getString("user"));
				hang.add(rs.getString("cid"));
				hang.add(rs.getString("back_date"));
				hang.add(rs.getString("state"));
				

				// 加入到rowData
				rowData.add(hang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (ct != null) {
					ct.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 初始化 jsp
		jsp = new JScrollPane();
		table_1 = new JTable(rowData, columnNames);
		table_1.setBackground(new Color(224, 255, 255));
		jsp_1 = new JScrollPane(table_1);
		jsp_1.setBounds(0, 0, 591, 471);
		getContentPane().add(jsp_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5DF2\u5F52\u8FD8");
		rdbtnNewRadioButton.setBounds(652, 313, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u8BB0\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 增加操作
				String sql_is = "insert into return_list values (?,?,?,?,?)";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage?characterEncoding=UTF-8",
							"root", "");

					ps = ct.prepareStatement(sql_is);
					int uid = Integer.valueOf(textField.getText().trim());
					int cid= Integer.valueOf(textField_2.getText().trim());
					ps.setInt(1, uid);
					ps.setString(2, textField_1.getText());
					ps.setInt(3, cid);
					ps.setString(4,textField_3.getText());
					if(rdbtnNewRadioButton.isSelected())
						ps.setString(5, "已归还");
					else ps.setString(5, "未归还");
					ps.executeUpdate();

				}
				catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(null, "该编号已存在", "警告", JOptionPane.WARNING_MESSAGE);
				}
				catch(com.mysql.jdbc.MysqlDataTruncation e1) {
					JOptionPane.showMessageDialog(null, "请输入正常日期", "警告", JOptionPane.WARNING_MESSAGE);
				}
				catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "请正确输入数据", "警告", JOptionPane.WARNING_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				return_list frame = new return_list();
				frame.setVisible(true);

			}
		});
		btnNewButton.setForeground(new Color(153, 50, 204));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(719, 433, 127, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("\u8FD4\u56DE");
		btnNewButton_3.setForeground(new Color(153, 50, 204));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				sc_menu frame = new sc_menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(616, 432, 93, 39);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_1 = new JButton("\u8FD8\u8F66");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_u = "update return_list  set state=? where UID=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage?characterEncoding=UTF-8",
							"root", "");

					ps = ct.prepareStatement(sql_u);
				
					int uid=Integer.valueOf(textField.getText().trim());
					ps.setInt(2, uid);//费用
					if(rdbtnNewRadioButton.isSelected())
						ps.setString(1, "已归还");
					else ps.setString(1, "未归还");
					
					ps.executeUpdate();

				}catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(null, "数据不合理，请重新输入", "警告", JOptionPane.WARNING_MESSAGE);
				} 
				catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "请正确输入数据", "警告", JOptionPane.WARNING_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				return_list frame = new return_list();
				frame.setVisible(true);

			}
		});
		btnNewButton_1.setForeground(new Color(153, 50, 204));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_1.setBounds(719, 496, 127, 42);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(652, 48, 194, 39);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(652, 114, 194, 39);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(652, 186, 194, 39);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(652, 258, 194, 39);
		contentPane.add(textField_3);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u7F16\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 105, 180));
		lblNewLabel_1.setBounds(591, 47, 64, 39);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("\u59D3\u540D");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(255, 105, 180));
		lblNewLabel_2.setBounds(591, 114, 64, 39);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("\u8F66\u8F86\u7F16\u53F7");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 105, 180));
		lblNewLabel_3.setBounds(591, 185, 64, 39);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("\u5F52\u8FD8\u65E5\u671F");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(new Color(255, 105, 180));
		lblNewLabel_4.setBounds(591, 258, 64, 39);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("\u8BF7\u8F93\u5165\u60F3\u4FEE\u6539\u7684\u5185\u5BB9");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_5.setForeground(new Color(255, 105, 180));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(601, 1, 245, 36);
		contentPane.add(lblNewLabel_5);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\umbrella\\Pictures\\QQ\u56FE\u724720200522214335.jpg"));
		lblNewLabel.setBounds(0, 0, 856, 580);
		contentPane.add(lblNewLabel);

	}
}