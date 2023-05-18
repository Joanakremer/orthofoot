package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import net.miginfocom.swing.MigLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.table.DefaultTableModel;

import componentesVisuais.HintTextField;
import controle.CDao;
import modelo.MPaciente;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;


public class VisaoPaciente extends JFrame {

	private JPanel contentPane;
	private MPaciente pacienteSelecionado;
	private ArrayList<MPaciente> listaPaciente;
	private CDao dao;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	public VisaoPaciente() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:150px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBorder(null);
		panel.add(panel_1, "cell 0 0 18 2,grow");
		panel_1.setLayout(new MigLayout("", "[20px:n:500px,grow][20px:n:300px,grow][20px:n:1200px,grow]", "[20px:n:90px,grow]"));
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/Logo banner.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBorder(null);
		panel_1.add(lblNewLabel, "cell 0 0,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2, "cell 0 2 18 21,grow");
		panel_2.setLayout(new MigLayout("", "[20px:n:300px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]", "[20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_2.add(panel_3, "cell 0 0 1 21,grow");
		panel_3.setLayout(new MigLayout("", "[20px:n:200px,grow][20px:n:90px,grow]", "[20px:n:60px,grow][20px:n:50px,grow][10px:n:10px,grow][20px:n:50px,grow][10px:n:10px,grow][20px:n:50px,grow][10px:n:10px,grow][20px:n:50px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:30px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/menu32.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEADING);
		panel_3.add(lblNewLabel_1, "cell 1 0,alignx right,growy");
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(Color.WHITE);
				panel_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(95, 158, 160));
				panel_4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				VisaoPrincipal visaoPrincipal = new VisaoPrincipal();
				visaoPrincipal.setVisible(true);
				dispose();
			}
		});
		panel_4.setBackground(new Color(95, 158, 160));
		panel_3.add(panel_4, "cell 0 1 2 1,grow");
		panel_4.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:230px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/casa32.png")));
		panel_4.add(lblNewLabel_2, "cell 0 0,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Home");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		panel_4.add(lblNewLabel_3, "cell 1 0");
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(Color.WHITE);
				panel_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(95, 158, 160));
				panel_5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				VisaoAgenda visaoAgenda = new VisaoAgenda();
				visaoAgenda.setVisible(true);
				dispose();
			}
		});
		panel_5.setBackground(new Color(95, 158, 160));
		panel_3.add(panel_5, "cell 0 3 2 1,grow");
		panel_5.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:230px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/agenda32.png")));
		panel_5.add(lblNewLabel_4, "cell 0 0,growx");
		
		JLabel lblNewLabel_8 = new JLabel("Agenda");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		panel_5.add(lblNewLabel_8, "cell 1 0");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_3.add(panel_6, "cell 0 5 2 1,grow");
		panel_6.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:230px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/paciente32.png")));
		panel_6.add(lblNewLabel_5, "cell 0 0,growx");
		
		JLabel lblNewLabel_9 = new JLabel("Paciente");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		panel_6.add(lblNewLabel_9, "cell 1 0");
		
		JPanel panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_7.setBackground(Color.WHITE);
				panel_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(new Color(95, 158, 160));
				panel_7.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {				
				VisaoUsuario visaoUsuario = new VisaoUsuario();
				visaoUsuario.setVisible(true);
				dispose();
			}
		});
		panel_7.setBackground(new Color(95, 158, 160));
		panel_3.add(panel_7, "cell 0 7 2 1,grow");
		panel_7.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:230px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/usuarios32.png")));
		panel_7.add(lblNewLabel_6, "cell 0 0,growx");
		
		JLabel lblNewLabel_10 = new JLabel("Usuário");
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		panel_7.add(lblNewLabel_10, "cell 1 0");
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, "cell 0 16 2 1,grow");
		panel_8.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:190px,grow][20px:n:40px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_11.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_11.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_11.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/porta28.png")));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_11, "cell 1 0,growx");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_10, "cell 1 0 19 21,grow");
		panel_10.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(95, 158, 160));
		panel_10.add(panel_11, "cell 0 0 10 2,grow");
		panel_11.setLayout(new MigLayout("", "[20px:n:820px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("PACIENTE");
		lblNewLabel_12.setForeground(Color.WHITE);
		panel_11.add(lblNewLabel_12, "cell 0 0,growx,aligny top");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_1 = new JTextField();
		panel_10.add(textField_1, "cell 0 3 4 1,grow");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setIcon(new ImageIcon(VisaoPaciente.class.getResource("/imagens/procurar24.png")));
		panel_10.add(lblNewLabel_13, "cell 4 3,alignx left,growy");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setIcon(new ImageIcon(VisaoPaciente.class.getResource("/imagens/excluir24.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.WHITE);
		panel_10.add(btnNewButton, "cell 8 3 2 1,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane, "cell 0 5 10 21,grow");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_9, "cell 20 0 17 21,grow");
		panel_9.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setBackground(new Color(95, 158, 160));
		panel_9.add(panel_11_1, "cell 0 0 16 2,grow");
		panel_11_1.setLayout(new MigLayout("", "[20px:n:800px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_12_1 = new JLabel("Cadastrar Paciente");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setForeground(Color.WHITE);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		panel_11_1.add(lblNewLabel_12_1, "cell 0 0,grow");
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(null);
		panel_12.setBackground(Color.WHITE);
		panel_9.add(panel_12, "cell 0 2 16 10,grow");
		panel_12.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_14 = new JLabel("Prontuário *");
		lblNewLabel_14.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14, "cell 0 1 8 1,grow");
		
		JLabel lblNewLabel_14_1 = new JLabel("CPF *");
		lblNewLabel_14_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_1, "cell 9 1 5 1");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel_12.add(textField_2, "cell 0 2 8 1,grow");
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_3.setColumns(10);
		panel_12.add(textField_3, "cell 9 2 5 1,grow");
		
		JLabel lblNewLabel_14_2 = new JLabel("Nome Completo *");
		lblNewLabel_14_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2, "cell 0 3 14 1");
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_4.setColumns(10);
		panel_12.add(textField_4, "cell 0 4 14 1,grow");
		
		JLabel lblNewLabel_14_2_1 = new JLabel("Sexo *");
		lblNewLabel_14_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1, "cell 0 5 5 1,grow");
		
		JLabel lblNewLabel_14_2_1_1 = new JLabel("Data de Nascimento *");
		lblNewLabel_14_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1_1, "cell 6 5 6 1,grow");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel_12.add(comboBox, "cell 0 6 5 1,grow");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel_12.add(comboBox_1, "cell 6 6 2 1,grow");
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel_12.add(comboBox_1_1, "cell 8 6 2 1,grow");
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel_12.add(comboBox_1_1_1, "cell 10 6 2 1,grow");
		
		JLabel lblNewLabel_14_2_1_2 = new JLabel("Contato *");
		lblNewLabel_14_2_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1_2, "cell 0 7 14 1");
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_5.setColumns(10);
		panel_12.add(textField_5, "cell 0 8 14 1,grow");
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_9.add(panel_13, "cell 0 12 16 5,grow");
		panel_13.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_14_3 = new JLabel("Convênio");
		lblNewLabel_14_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_13.add(lblNewLabel_14_3, "cell 0 0 14 1");
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_6.setColumns(10);
		panel_13.add(textField_6, "cell 0 1 14 1,grow");
		
		JLabel lblNewLabel_14_3_1 = new JLabel("Nº Carteira");
		lblNewLabel_14_3_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_13.add(lblNewLabel_14_3_1, "cell 0 2 14 1,grow");
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_7.setColumns(10);
		panel_13.add(textField_7, "cell 0 3 14 1,grow");
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_9.add(panel_14, "cell 0 17 16 8,grow");
		panel_14.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_14_4 = new JLabel("CEP *");
		lblNewLabel_14_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_4, "cell 0 0 5 1,growx");
		
		JLabel lblNewLabel_14_4_1 = new JLabel("Estado *");
		lblNewLabel_14_4_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_4_1, "cell 6 0 8 1");
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_8.setColumns(10);
		panel_14.add(textField_8, "cell 0 1 5 1,grow");
		
		JComboBox comboBox_2 = new JComboBox();
		panel_14.add(comboBox_2, "cell 6 1 8 1,grow");
		
		JLabel lblNewLabel_14_2_1_2_1 = new JLabel("Cidade *");
		lblNewLabel_14_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_2_1_2_1, "cell 0 2 14 1");
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_9.setColumns(10);
		panel_14.add(textField_9, "cell 0 3 14 1,grow");
		
		JLabel lblNewLabel_14_2_1_2_1_1 = new JLabel("Rua *");
		lblNewLabel_14_2_1_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_2_1_2_1_1, "cell 0 4 14 1");
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_10.setColumns(10);
		panel_14.add(textField_10, "cell 0 5 14 1,grow");
		dao = CDao.getInstancia();
		listaPaciente = dao.listarPaciente();
	}
	}

