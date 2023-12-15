package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.studentDaoImpl;
import model.student;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JScrollPane;

public class studentUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField chi;
	private JTextField eng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentUI frame = new studentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(177, 216, 216));
		panel.setBounds(0, 0, 480, 404);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("學員管理系統");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setBounds(139, 10, 171, 62);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(57, 82, 54, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("國文：");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(192, 82, 54, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("英文：");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(303, 82, 54, 23);
		panel.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setBounds(41, 115, 84, 29);
		panel.add(name);
		name.setColumns(10);
		
		chi = new JTextField();
		chi.setColumns(10);
		chi.setBounds(172, 115, 84, 29);
		panel.add(chi);
		
		eng = new JTextField();
		eng.setColumns(10);
		eng.setBounds(303, 115, 84, 29);
		panel.add(eng);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 270, 378, 128);
		panel.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{	/*
				 * 1.擷取 name,chi,eng getText()
				 * 2.name,chi-->轉整數
				 * 3.new student(name,chi,eng);
				 * 4.add(s);
				 */
				String Name=name.getText();
				int Chi=Integer.parseInt(chi.getText());
				int Eng=Integer.parseInt(eng.getText());
				
				student s=new student(Name,Chi,Eng);
				new studentDaoImpl().add(s);
				

			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.setBounds(165, 154, 102, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢(String)");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{	/*
				 * 1.queryAll2()--->List
				 * 2.String show="";
				 */
				output.setText(new studentDaoImpl().queryAll1());
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setBounds(57, 230, 132, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("查詢(List)");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{	/*
				 * 1.List-->queryAll2();
				 * 2.show:String;
				 */
				
				List<student> l=new studentDaoImpl().queryAll2();
				String show="";
				int sum=0;
				int i=0;
				for(student o:l)
				{
					i++;
					sum=sum+(o.getChi()+o.getEng());
					
					show=show+"id:"+o.getId()+
							"\t姓名:"+o.getName()+
							"\t國文:"+o.getChi()+
							"\t英文:"+o.getEng()+
							"\t總分:"+(o.getChi()+o.getEng())+"\n";
					
				}
				show=show+"\n總分合計="+sum+"\t平均="+(sum/i);
				output.setText(show);
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(255, 230, 132, 30);
		panel.add(btnNewButton_1_1);
	}
}
