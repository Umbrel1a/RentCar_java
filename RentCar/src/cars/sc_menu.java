package cars;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class sc_menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public sc_menu() {
		setTitle("\u6625\u7530\u7BA1\u5BB6");
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\umbrella\\Pictures\\M1903.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 862, 609);
		setLocation(550,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2\u73B0\u6709\u8F66\u8F86");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				show_garage frame = new show_garage();
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(276, 36, 281, 102);
		btnNewButton.setForeground(new Color(30, 144, 255));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8F66\u8F86\u7EC4\u51FA\u60C5\u51B5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				rent_list frame = new rent_list();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(30, 144, 255));
		btnNewButton_1.setBounds(276, 165, 281, 102);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\u8F66\u8F86\u5F52\u8FD8\u60C5\u51B5");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				return_list frame=new return_list();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_1_1.setForeground(new Color(30, 144, 255));
		btnNewButton_1_1.setBounds(276, 293, 281, 102);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("\u8F66\u8F86\u7EF4\u4FEE\u60C5\u51B5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				repair_list frame = new repair_list();
				
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(30, 144, 255));
		btnNewButton_2.setBounds(276, 417, 281, 102);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u6CE8\u9500");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				log_menu frame=new log_menu();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(new Color(30, 144, 255));
		btnNewButton_3.setBounds(691, 183, 155, 67);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"感谢使用，期待下次使用");
				System.exit(0);
			}
		});
		btnNewButton_3_1.setForeground(new Color(30, 144, 255));
		btnNewButton_3_1.setBounds(691, 54, 155, 67);
		contentPane.add(btnNewButton_3_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("E:\\umbrella\\Pictures\\QQ\u56FE\u724720200522214335.jpg"));
		lblNewLabel.setBounds(0, 0, 856, 580);
		contentPane.add(lblNewLabel);
	}
}
