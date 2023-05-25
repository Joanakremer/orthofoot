package visao;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import controle.CDao;
import modelo.MPaciente;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;


public class VisaoPaciente extends JFrame {

	private JTable tablePacientes;
	private JPanel contentPane;
	private MPaciente pacienteSelecionado;
	private ArrayList<MPaciente> listaPaciente;
	private CDao dao;
	private JTextField textField;
	private JTextField textField_1;
	private JFormattedTextField txtProntuario;
	private JFormattedTextField txtCpf;
	private JTextField txtNome;
	private JFormattedTextField txtContato;
	private JTextField txtConvenio;
	private JTextField txtCarteira;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	
	
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
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_8.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_8.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panel_3.add(panel_8, "cell 0 16 2 1,grow");
		panel_8.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:190px,grow][20px:n:40px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/porta28.png")));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblNewLabel_11, "cell 1 0,growx");
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_10, "cell 1 0 22 21,grow");
		panel_10.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:45px,grow]"));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(95, 158, 160));
		panel_10.add(panel_11, "cell 0 0 12 2,grow");
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
		panel_10.add(lblNewLabel_13, "cell 4 3,growy");
		
		JButton btnNewButton = new JButton("Deletar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			CDao c = new CDao();
		});
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton.setBorder(new LineBorder(new Color(95, 158, 160)));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		panel_10.add(btnNewButton, "cell 10 3 2 1,grow");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_9, "cell 23 0 14 21,grow");
		panel_9.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:20px,grow][20px:n:70px,grow]"));
		
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setBackground(new Color(95, 158, 160));
		panel_9.add(panel_11_1, "cell 0 0 12 2,grow");
		panel_11_1.setLayout(new MigLayout("", "[20px:n:800px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_12_1 = new JLabel("Cadastrar Paciente");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setForeground(Color.WHITE);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		panel_11_1.add(lblNewLabel_12_1, "cell 0 0,grow");
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(null);
		panel_12.setBackground(Color.WHITE);
		panel_9.add(panel_12, "cell 0 2 12 9,grow");
		panel_12.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_14 = new JLabel("Prontuário *");
		lblNewLabel_14.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14, "cell 0 0 8 1,grow");
		
		JLabel lblNewLabel_14_1 = new JLabel("CPF *");
		lblNewLabel_14_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_1, "cell 8 0 4 1");
		
		try {
			txtProntuario = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		txtProntuario.setBackground(new Color(255, 245, 238));
		txtProntuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		panel_12.add(txtProntuario, "cell 0 1 7 1,grow");
		txtProntuario.setColumns(10);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf.setBackground(new Color(255, 245, 238));
		txtCpf.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCpf.setColumns(10);
		panel_12.add(txtCpf, "cell 8 1 4 1,grow");
		
		JLabel lblNewLabel_14_2 = new JLabel("Nome Completo *");
		lblNewLabel_14_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2, "cell 0 2 12 1");
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 245, 238));
		txtNome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtNome.setColumns(10);
		panel_12.add(txtNome, "cell 0 3 12 1,grow");
		
		JLabel lblNewLabel_14_2_1 = new JLabel("Sexo *");
		lblNewLabel_14_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1, "cell 0 4 5 1,grow");
		
		JLabel lblNewLabel_14_2_1_1 = new JLabel("Data de Nascimento *");
		lblNewLabel_14_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1_1, "cell 6 4 6 1,grow");
		
		JComboBox sexoBox = new JComboBox();
		sexoBox.setBackground(new Color(255, 245, 238));
		panel_12.add(sexoBox, "cell 0 5 5 1,grow");
		sexoBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		sexoBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		sexoBox.setBounds(10, 179, 181, 29);
		
		JComboBox<String> cbDia = new JComboBox<String>();
		cbDia.setBackground(new Color(255, 245, 238));
		panel_12.add(cbDia, "cell 6 5 2 1,grow");
		cbDia.setBounds(262, 179, 68, 29);
		
		JComboBox<String> cbMes = new JComboBox<String>();
		cbMes.setBackground(new Color(255, 245, 238));
		panel_12.add(cbMes, "cell 8 5 2 1,grow");
		cbMes.setBounds(340, 179, 68, 28);
		
		JComboBox<String> cbAno = new JComboBox<String>();
		cbAno.setBackground(new Color(255, 245, 238));
		panel_12.add(cbAno, "cell 10 5 2 1,grow");
		cbAno.setBounds(418, 179, 79, 29);
		
		JLabel lblNewLabel_14_2_1_2 = new JLabel("Contato *");
		lblNewLabel_14_2_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1_2, "flowx,cell 0 6 12 1");
		
		try {
			txtContato = new JFormattedTextField(new MaskFormatter("(+##)## #####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtContato.setBackground(new Color(255, 245, 238));
		txtContato.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtContato.setColumns(10);
		panel_12.add(txtContato, "cell 0 7 12 1,grow");
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_9.add(panel_13, "cell 0 11 12 5,grow");
		panel_13.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_14_3 = new JLabel("Convênio");
		lblNewLabel_14_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_13.add(lblNewLabel_14_3, "cell 0 0 12 1");
		
		txtConvenio = new JTextField();
		txtConvenio.setBackground(new Color(255, 245, 238));
		txtConvenio.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtConvenio.setColumns(10);
		panel_13.add(txtConvenio, "cell 0 1 12 1,grow");
		
		JLabel lblNewLabel_14_3_1 = new JLabel("Nº Carteira");
		lblNewLabel_14_3_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_13.add(lblNewLabel_14_3_1, "cell 0 2 12 1,grow");
		
		txtCarteira = new JTextField();
		txtCarteira.setBackground(new Color(255, 245, 238));
		txtCarteira.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCarteira.setColumns(10);
		panel_13.add(txtCarteira, "cell 0 3 12 1,grow");
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_9.add(panel_14, "cell 0 16 12 7,grow");
		panel_14.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_14_4 = new JLabel("CEP *");
		lblNewLabel_14_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_4, "cell 0 0 5 1,growx");
		
		JLabel lblNewLabel_14_4_1 = new JLabel("Estado *");
		lblNewLabel_14_4_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_4_1, "cell 6 0 6 1");
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 245, 238));
		textField_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_8.setColumns(10);
		panel_14.add(textField_8, "cell 0 1 5 1,grow");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255, 245, 238));
		panel_14.add(comboBox_2, "cell 6 1 6 1,grow");
		
		JLabel lblNewLabel_14_2_1_2_1 = new JLabel("Cidade *");
		lblNewLabel_14_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_2_1_2_1, "cell 0 2 12 1");
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(255, 245, 238));
		textField_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_9.setColumns(10);
		panel_14.add(textField_9, "cell 0 3 12 1,grow");
		
		JLabel lblNewLabel_14_2_1_2_1_1 = new JLabel("Rua *");
		lblNewLabel_14_2_1_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_14.add(lblNewLabel_14_2_1_2_1_1, "cell 0 4 12 1");
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(255, 245, 238));
		textField_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		textField_10.setColumns(10);
		panel_14.add(textField_10, "cell 0 5 12 1,grow");
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel_15, "cell 0 24 12 1,grow");
		panel_15.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:50px,grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane, "cell 0 5 12 20,grow");
		
		dao = CDao.getInstancia();
		listaPaciente = dao.listarPaciente();
		tablePacientes = new JTable();
		scrollPane.setViewportView(tablePacientes);
		
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Prontuario", "Nome",
				"Data Nascimento", "CPF", "N° Carteira", "Contato", "Convenio", "Sexo" });

		tablePacientes.setModel(modelo);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton_1.setBorder(new LineBorder(new Color(95, 158, 160)));
		btnNewButton_1.setBackground(Color.WHITE);
		panel_15.add(btnNewButton_1, "cell 0 0 5 1,grow");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JButton btnNewButton_1_2 = new JButton("Atualizar");
		btnNewButton_1_2.setEnabled(false);
		btnNewButton_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton_1_2.setFocusPainted(false);
		btnNewButton_1_2.setBorder(new LineBorder(new Color(95, 158, 160)));
		btnNewButton_1_2.setBackground(Color.WHITE);
		panel_15.add(btnNewButton_1_2, "cell 5 0 5 1,grow");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prontuario = txtProntuario.getText().replace("", "");
				if (prontuario == null || prontuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					pacienteSelecionado.setProntuario(Integer.valueOf(prontuario));
				}
				String nome = txtNome.getText();
				if (nome == null || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					pacienteSelecionado.setnomeCompleto(nome);
				}
				String cpf = txtCpf.getText().replace(".", "").replace("-", "");
				if (cpf == null || cpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CPF está vazio");
				} else {
					pacienteSelecionado.setCpf(Long.valueOf(cpf));
				}
				String carteira = txtCarteira.getText();
				if (carteira == null || carteira.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NUMERO CARTEIRA está vazio");
				} else {
					pacienteSelecionado.setnCarteira(Integer.valueOf(carteira));
				}
				String contato = txtContato.getText().replace("(", "").replace(")", "").replace("+", "").replace("-", "");
				if (contato == null || contato.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONTATO está vazio");
				} else {
					pacienteSelecionado.setContato(contato);
				}
				String convenio = txtConvenio.getText();
				if (convenio == null || convenio.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONVENIO está vazio");
				} else {
					pacienteSelecionado.setConvenio(convenio);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();
				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				String sexo = sexoBox.getSelectedItem().toString();
					pacienteSelecionado.setSexo(sexo);

				CDao tablePacientes = CDao.getInstancia();
				boolean update = tablePacientes.update(pacienteSelecionado);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");

					txtProntuario.setText(null);
					txtNome.setText(null);
					txtCpf.setText(null);
					cbDia.setSelectedItem(null);
					cbMes.setSelectedItem(null);
					cbAno.setSelectedItem(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					sexoBox.setSelectedItem("Masculino");
					
					dispose();
					TelaPaciente frame = new TelaPaciente();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
			}
		});
		
		tablePacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tablePacientes.getSelectedRow();
				pacienteSelecionado = listaPaciente.get(posicaoPessoa);
				txtProntuario.setText(String.valueOf(pacienteSelecionado.getProntuario()));
				txtCpf.setText(String.valueOf(pacienteSelecionado.getCpf()));
				txtNome.setText(pacienteSelecionado.getnomeCompleto());
				txtContato.setText(String.valueOf(pacienteSelecionado.getContato()));
				txtConvenio.setText(pacienteSelecionado.getConvenio());
				txtCarteira.setText(String.valueOf(pacienteSelecionado.getnCarteira()));
				cbDia.setSelectedIndex(pacienteSelecionado.getdataNasc().getDayOfMonth());
				cbMes.setSelectedIndex(pacienteSelecionado.getdataNasc().getMonthValue());
				cbAno.setSelectedItem(pacienteSelecionado.getdataNasc().getYear()+"");
				sexoBox.setSelectedItem(pacienteSelecionado.getSexo());
				if(pacienteSelecionado != null) {
					txtProntuario.disable();
				}
				btnNewButton_1_2.setEnabled(true);
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Limpar");
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton_1_1.setBorder(new LineBorder(new Color(95, 158, 160)));
		btnNewButton_1_1.setBackground(Color.WHITE);
		panel_15.add(btnNewButton_1_1, "cell 12 0 2 1,grow");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1_1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		dao = CDao.getInstancia();
		listaPaciente = dao.listarPaciente();
		int ano = LocalDate.now().getYear();
		for (int i = 0; i < 110; i++) {
			cbAno.addItem(String.valueOf(ano));
			ano--;
		}
		int mes = 1;
		for (int i = 0; i < 12; i++) {
			cbMes.addItem(String.valueOf(mes));
			mes++;
		}
		int dia = 1;
		for (int i = 0; i < 31; i++) {
			cbDia.addItem(String.valueOf(dia));
			dia++;
		}
	}
	public void atualizar() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Prontuario", "Nome",
				"Data Nascimento", "CPF", "N° Carteira", "Contato", "Convenio", "Sexo" });

		tablePacientes.setModel(modelo);
		
		if (listaPaciente.size() > 0 && listaPaciente != null) {
			for (MPaciente paciente : listaPaciente) {
				if(paciente == null) {
					System.out.println("paciente está vazio");
				}else {
					modelo.addRow(new Object[] { paciente.getProntuario(), paciente.getnomeCompleto(),
							paciente.getdataNasc(), paciente.getCpf(), paciente.getnCarteira(), paciente.getContato(),
							paciente.getConvenio(), paciente.getSexo() });
				}
			}
		}
	}
	}

