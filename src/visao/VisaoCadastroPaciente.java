package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.CDao;
import modelo.MPaciente;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VisaoCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtSexo;
	private JTextField txtDMA;
	private JTextField txtContato;
	private JTextField txtConvenio;
	private JTextField txtCarteira;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisaoCadastroPaciente frame = new VisaoCadastroPaciente();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	public VisaoCadastroPaciente() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:150px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:40px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(null);
		panel.add(panel_1, "cell 0 0 18 2,grow");
		panel_1.setLayout(new MigLayout("", "[20px:n:160px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:40px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:40px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:160px,grow]", "[10px:n:10px,grow][20px:n:40px,grow][10px:n:10px,grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_1.add(panel_3, "cell 0 1 7 1,grow");
		
		JLabel lblNewLabel = new JLabel("Cadastro Paciente");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, "cell 7 0 5 3,grow");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(95, 158, 160));
		panel_1.add(panel_4, "cell 12 1 7 1,grow");
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(95, 158, 160));
		panel_2.setBorder(null);
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, "cell 0 2 9 12,grow");
		panel_2.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(95, 158, 160));
		panel_2.add(panel_6, "cell 0 0 22 2,grow");
		panel_6.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Preencha com a suas informações pessoais");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_6.add(lblNewLabel_1, "cell 0 0 9 1,grow");
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, "cell 0 2 22 14,grow");
		panel_7.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:20px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:20px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:20px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:20px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("Nome *");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_3, "cell 0 1 9 1,grow");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(textField_1, "cell 0 2 9 1,grow");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("CPF *");
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_4_1, "flowx,cell 0 4");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(textField_2, "cell 0 5 4 1,grow");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Data de Nascimento *");
		lblNewLabel_4_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_4_2, "cell 0 7 4 1,grow");
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Sexo *");
		lblNewLabel_4_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_4_2_1, "cell 5 7,grow");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(comboBox, "cell 0 8,grow");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(comboBox_1, "cell 1 8 2 1,grow");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(comboBox_2, "cell 3 8,grow");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Maculino");
		rdbtnNewRadioButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		panel_7.add(rdbtnNewRadioButton, "cell 5 8,grow");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Feminino");
		rdbtnNewRadioButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(rdbtnNewRadioButton_1, "cell 6 8 2 1,grow");
		
		JLabel lblNewLabel_4_3 = new JLabel("Contato *");
		lblNewLabel_4_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_4_3, "cell 0 10");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_3.setColumns(10);
		panel_7.add(textField_3, "cell 0 11 4 1,grow");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel.add(panel_10, "cell 9 2 9 16,grow");
		panel_10.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(95, 158, 160));
		panel_10.add(panel_11, "cell 0 0 22 2,grow");
		panel_11.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_11.add(lblNewLabel_4, "cell 0 0 9 1,grow");
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, "cell 0 2 22 22,grow");
		panel_12.setLayout(new MigLayout("", "[]", "[]"));
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(new Color(95, 158, 160));
		panel_5.setBorder(null);
		panel_5.setBackground(Color.WHITE);
		panel.add(panel_5, "cell 0 14 9 9,grow");
		panel_5.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(95, 158, 160));
		panel_5.add(panel_8, "cell 0 0 9 2,grow");
		panel_8.setLayout(new MigLayout("", "[30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("Convênio");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_8.add(lblNewLabel_2, "cell 0 0 9 1,grow");
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9, "cell 0 2 9 11,grow");
		panel_9.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:20px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:20px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:20px,grow]"));
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Convênio ");
		lblNewLabel_4_3_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_9.add(lblNewLabel_4_3_1, "cell 0 1 9 1");
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_4.setColumns(10);
		panel_9.add(textField_4, "cell 0 2 9 1,grow");
		
		JLabel lblNewLabel_4_3_1_1 = new JLabel("Nº Carteirinha");
		lblNewLabel_4_3_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_9.add(lblNewLabel_4_3_1_1, "cell 0 4 9 1");
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_5.setColumns(10);
		panel_9.add(textField_5, "cell 0 5 9 1,grow");
		
	}
}