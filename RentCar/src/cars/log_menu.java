package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.DropMode;

public class log_menu extends JFrame {
static int count=0;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	Account ac1=new Account();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public log_menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("../pic/backdrop.jpg"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\u6625\u7530\u7BA1\u5BB6");
		setBounds(100, 100, 862, 609);
		setLocation(550, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setBounds(139, 120, 141, 55);
		lblNewLabel_1.setForeground(new Color(138, 43, 226));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setBounds(139, 219, 141, 55);
		lblNewLabel_2.setForeground(new Color(138, 43, 226));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(301, 129, 306, 40);
		textField.setFont(new Font("宋体", Font.PLAIN, 18));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals(ac1.ID))//账号正确之后进入密码验证
					{if(passwordField.getText().equals(ac1.password)) {
					JOptionPane.showMessageDialog(null,"登录成功，欢迎使用本系统");
					setVisible(false);
					sc_menu frame = new sc_menu();
					frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null,"密码错误，错误超过三次将退出系统","警告",JOptionPane.WARNING_MESSAGE);
						count++;
						if(count==3) {JOptionPane.showMessageDialog(null,"错误次数超过上限，即将退出系统","警告",JOptionPane.WARNING_MESSAGE);
						System.exit(0);
						}
						}
					
				}
				else {
					if (!textField.getText().equals(""))JOptionPane.showMessageDialog(null,"账号不存在");
				}
				}
					
		});
		btnNewButton.setBounds(329, 327, 220, 40);

		contentPane.add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(301, 230, 306, 40);

		contentPane.add(passwordField);
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(0, 0, 856, 580);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("E:umbrella\\Pictures\\QQ\u56FE\u724720200522214335.jpg"));
		contentPane.add(lblNewLabel_3);
	}
}
