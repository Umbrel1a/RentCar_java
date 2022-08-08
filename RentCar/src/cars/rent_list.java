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

public class rent_list extends JFrame {
	Vector rowData;
	Vector<String> columnNames;
	JTable jt = null;
	JScrollPane jsp = null;
	private JScrollPane jsp_1;

	// 定义数据库需要的全局变量
	PreparedStatement ps = null;
	String sql_d = "delete from car WHERE id=?";
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
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public rent_list() {

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
		columnNames.add("用户姓名");
		columnNames.add("租借车辆编号");
		columnNames.add("借出日期");
		columnNames.add("支付金额");

		rowData = new Vector();
		// rowData可以存放多行,开始从数据库里取

		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage?characterEncoding=UTF-8", "root", "");
			// 得到连接
			ps = ct.prepareStatement("select * from rent");

			rs = ps.executeQuery();

			while (rs.next()) {
				// rowData可以存放多行
				Vector hang = new Vector();
				hang.add(rs.getInt("UID"));
				hang.add(rs.getString("user"));
				hang.add(rs.getInt("cid"));

				hang.add(rs.getString("date"));
				hang.add(rs.getFloat("pay"));

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

		JButton btnNewButton = new JButton("\u589E\u52A0\u79DF\u501F\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 增加操作
				String sql_is = "insert into rent values (?,?,?,?,?)";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage?characterEncoding=UTF-8",
							"root", "");

					ps = ct.prepareStatement(sql_is);
					int id = Integer.valueOf(textField_2.getText().trim());
					int cid=Integer.valueOf(textField.getText().trim());
					int money=Integer.valueOf(textField_4.getText().trim());
					ps.setString(2, textField_1.getText());//姓名
					ps.setInt(3, cid);//车辆ID
					ps.setInt(1, id);//用户ID
					ps.setString(4, textField_3.getText());//日期
					ps.setFloat(5, money);//费用
					ps.executeUpdate();

				}catch(com.mysql.jdbc.MysqlDataTruncation e1) {
					JOptionPane.showMessageDialog(null, "请输入正常日期", "警告", JOptionPane.WARNING_MESSAGE);
				}
				catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e1) {
					JOptionPane.showMessageDialog(null, "该记录已存在", "警告", JOptionPane.WARNING_MESSAGE);
				} catch (java.lang.NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "请正确输入数据", "警告", JOptionPane.WARNING_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				rent_list frame = new rent_list();
				frame.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(153, 50, 204));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton.setBounds(733, 432, 113, 39);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u79DF\u501F\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {// 更新数据
			public void actionPerformed(ActionEvent e) {
				String sql_u = "update rent set user=?,cid=?,date=?,pay=? where UID=?";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/garage?characterEncoding=UTF-8",
							"root", "");

					ps = ct.prepareStatement(sql_u);
					int id = Integer.valueOf(textField_2.getText().trim());
					int cid=Integer.valueOf(textField.getText().trim());
					int money=Integer.valueOf(textField_4.getText().trim());
					ps.setString(1, textField_1.getText());//姓名
					ps.setInt(2, cid);//车辆ID
					ps.setInt(5, id);//用户ID
					ps.setString(3, textField_3.getText());//日期
					ps.setFloat(4, money);//费用
					
					ps.executeUpdate();

				}catch(com.mysql.jdbc.MysqlDataTruncation e1) {
					JOptionPane.showMessageDialog(null, "日期输入不合理，请检查后重试", "警告", JOptionPane.WARNING_MESSAGE);
				}
				catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e1) {
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
				rent_list frame = new rent_list();
				frame.setVisible(true);

			}
		});
		btnNewButton_2.setForeground(new Color(153, 50, 204));
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 12));
		btnNewButton_2.setBounds(735, 490, 111, 42);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setForeground(new Color(153, 50, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				sc_menu frame = new sc_menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(616, 432, 93, 39);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(652, 185, 194, 39);
		contentPane.add(textField);
		
		textField_4 = new JTextField();
		textField_4.setBounds(652, 323, 194, 39);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(652, 114, 194, 39);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(652, 47, 194, 39);
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
		lblNewLabel_2.setBounds(601, 114, 54, 39);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("\u501F\u51FA\u8F66\u8F86");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(255, 105, 180));
		lblNewLabel_3.setBounds(591, 185, 64, 39);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("\u65E5\u671F");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(new Color(255, 105, 180));
		lblNewLabel_4.setBounds(601, 258, 54, 39);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u8D39\u7528");
		lblNewLabel_4_1.setForeground(new Color(255, 105, 180));
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(601, 322, 54, 39);
		contentPane.add(lblNewLabel_4_1);

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