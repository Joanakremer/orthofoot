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
		panel.add(panel_2, "cell 0 2 9 21,grow");
		panel_2.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(95, 158, 160));
		panel_2.add(panel_6, "cell 0 0 22 2,grow");
		panel_6.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("Preencha com a suas informações pessoais");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_6.add(lblNewLabel_1, "cell 0 0 9 1,grow");
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, "cell 0 2 22 25,grow");
		panel_7.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("Nome *");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_3, "cell 0 1 9 1,grow");
		
		textField_1 = new JTextField();
		panel_7.add(textField_1, "cell 0 2 9 1,grow");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CPF *");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_4, "cell 0 4,grow");
		
		textField_2 = new JTextField();
		panel_7.add(textField_2, "cell 0 5 9 1,grow");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo");
		panel_7.add(lblNewLabel_5, "cell 0 7 3 1,grow");
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.RED);
		panel_5.setBorder(null);
		panel_5.setBackground(Color.WHITE);
		panel.add(panel_5, "cell 9 2 9 9,grow");
		panel_5.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(95, 158, 160));
		panel_5.add(panel_8, "cell 0 0 10 2,grow");
		panel_8.setLayout(new MigLayout("", "[30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow][30px:n:100px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("Convênio");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_8.add(lblNewLabel_2, "cell 0 0 9 1,grow");
		
		JPanel panel_9 = new JPanel();
		panel_5.add(panel_9, "cell 0 2 10 10,grow");
		
	}
}