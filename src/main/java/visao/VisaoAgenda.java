package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.CDao;
import controle.CDaoAgenda;
import controle.CDaoMedico;
import modelo.MAgenda;
import modelo.MMedico;
import modelo.MPaciente;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class VisaoAgenda extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private String crm;
	private JTextField txtData;
	private JTextField txtHora;
	CDaoAgenda daoAgenda;
	private JTable tableAgenda;
	private Integer idConsulta;
	private MAgenda agendaSelecionada;
	private ArrayList<MAgenda> listAgendas;
	
	
	public VisaoAgenda() {
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
				panel_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		panel_5.setBackground(Color.WHITE);
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
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(Color.WHITE);
				panel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(95, 158, 160));
				panel_6.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				VisaoPaciente frame = new VisaoPaciente();
				frame.setVisible(true);
				dispose();
			}
		});
		panel_6.setBackground(new Color(95, 158, 160));
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
				VisaoMedico visaoMedico = new VisaoMedico();
				visaoMedico.setVisible(true);
				dispose();
			}
		});
		panel_7.setBackground(new Color(95, 158, 160));
		panel_3.add(panel_7, "cell 0 7 2 1,grow");
		panel_7.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:230px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/usuarios32.png")));
		panel_7.add(lblNewLabel_6, "cell 0 0,growx");
		
		JLabel lblNewLabel_10 = new JLabel("Médico");
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
		panel_2.add(panel_10, "cell 1 0 24 21,grow");
		panel_10.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:45px,grow]"));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(95, 158, 160));
		panel_10.add(panel_11, "cell 0 0 13 2,grow");
		panel_11.setLayout(new MigLayout("", "[20px:n:1100px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("AGENDA");
		lblNewLabel_12.setForeground(Color.WHITE);
		panel_11.add(lblNewLabel_12, "cell 0 0,growx,aligny top");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_1 = new JTextField();
		panel_10.add(textField_1, "cell 0 3 4 1,grow");
		textField_1.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_9, "cell 25 0 12 21,grow");
		panel_9.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:20px,grow][20px:n:70px,grow]"));
		
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setBackground(new Color(95, 158, 160));
		panel_9.add(panel_11_1, "cell 0 0 12 2,grow");
		panel_11_1.setLayout(new MigLayout("", "[20px:n:800px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_12_1 = new JLabel("Agendar Consulta");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setForeground(Color.WHITE);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		panel_11_1.add(lblNewLabel_12_1, "cell 0 0,grow");
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(null);
		panel_12.setBackground(Color.WHITE);
		panel_9.add(panel_12, "cell 0 2 12 7,grow");
		panel_12.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JButton pesquisar = new JButton("");
		pesquisar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Documents\\Repositorio\\orthofoot\\src\\main\\resources\\imagens\\procurar24.png"));
		pesquisar.setFocusPainted(false);
		pesquisar.setBorder(new LineBorder(new Color(95, 158, 160)));
		pesquisar.setBackground(Color.WHITE);
		panel_10.add(pesquisar, "cell 4 3,grow");
		pesquisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pesquisar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel lblNewLabel_14 = new JLabel("Data da Consulta *");
		lblNewLabel_14.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14, "cell 0 0 7 1,grow");
		
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtData.setForeground(Color.BLACK);
		txtData.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtData.setBackground(new Color(255, 245, 238));
		txtData.setColumns(10);
		panel_12.add(txtData, "cell 0 1 12 1,grow");
		
		JLabel lblNewLabel_14_1 = new JLabel("Horário da Consulta");
		lblNewLabel_14_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_1, "cell 0 2 7 1");
		try {
			txtHora = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtHora.setBackground(new Color(255, 245, 238));
		txtHora.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtHora.setColumns(10);
		panel_12.add(txtHora, "cell 0 3 12 1,grow");
		
		JLabel lblNewLabel_14_2_1 = new JLabel("Paciente *");
		lblNewLabel_14_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1, "cell 0 4 5 1,grow");
		
		JLabel lblNewLabel_14_2_1_1 = new JLabel("Médico *");
		lblNewLabel_14_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_2_1_1, "cell 7 4 5 1,grow");
		
		JComboBox cbPaciente = new JComboBox();
		panel_12.add(cbPaciente, "cell 0 5 5 1,grow");
		daoAgenda = CDaoAgenda.getInstancia();
		CDao daoPaciente = new CDao();
		ArrayList<MPaciente> listPaciente = daoPaciente.listarPaciente();
		for (MPaciente mPaciente : listPaciente) {
			cbPaciente.addItem(mPaciente);
		}
		
		JComboBox cbMedico = new JComboBox();
		panel_12.add(cbMedico, "cell 7 5 5 1,grow");
		CDaoMedico daoMedico = new CDaoMedico();
		ArrayList<MMedico> listMedico = daoMedico.listarMedico();
		for (MMedico mMedico : listMedico) {
			cbMedico.addItem(mMedico);
		}
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel_15, "cell 0 24 12 1,grow");
		panel_15.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:50px,grow]"));
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoAgenda = new CDaoAgenda();

				MMedico medico = (MMedico) cbMedico.getSelectedItem();
				MPaciente paciente = (MPaciente) cbPaciente.getSelectedItem();
				MAgenda agenda = new MAgenda();
				String data = txtData.getText(); //.replace("/", "");
				String hora = txtHora.getText();
				agenda.setMedico(medico);
				agenda.setPaciente(paciente);
				agenda.setTitulo(paciente.getConvenio());
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date dataFormatada = formater.parse(data);
					agenda.setData(new java.sql.Date(dataFormatada.getTime()));
					JOptionPane.showMessageDialog(null, "Data Cadastrada com sucesso");
				} catch (ParseException f) {
					JOptionPane.showMessageDialog(null, "formato de data invalida");
					// return;
					f.printStackTrace();
				}

				SimpleDateFormat formaterHora = new SimpleDateFormat("hh:mm");
				try {
					Date horaFormatada = formaterHora.parse(hora);
					agenda.setHora(new java.sql.Time(horaFormatada.getTime()));
				} catch (ParseException e3) {
					JOptionPane.showMessageDialog(null, "formato de hora invalido");
					e3.printStackTrace();
				}
				daoAgenda.inserir(agenda);
				atualizar();
			}
		});
		cadastrar.setFocusPainted(false);
		cadastrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		cadastrar.setBorder(new LineBorder(new Color(95, 158, 160)));
		cadastrar.setBackground(Color.WHITE);
		panel_15.add(cadastrar, "cell 0 0 5 1,grow");
		cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cadastrar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JButton deletar = new JButton("  Deletar");
		deletar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Documents\\Repositorio\\orthofoot\\src\\main\\resources\\imagens\\perigo24.png"));
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDaoAgenda a = new CDaoAgenda();
				if (agendaSelecionada != null) {
					a.delete(agendaSelecionada);
					listAgendas.remove(agendaSelecionada);
					atualizar();
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, "erro na remoção de dados");
				}
			atualizar();
				} 		
		});
		deletar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				deletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				deletar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		deletar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		deletar.setBorder(new LineBorder(new Color(95, 158, 160)));
		deletar.setFocusPainted(false);
		deletar.setForeground(Color.BLACK);
		deletar.setBackground(Color.WHITE);
		panel_10.add(deletar, "cell 11 3 2 1,grow");
		
		JButton limpar = new JButton("");
		limpar.setIcon(new ImageIcon("C:\\Users\\Aluno\\Documents\\Repositorio\\orthofoot\\src\\main\\resources\\imagens\\lixeira24.png"));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtData.setText(null);
			txtHora.setText(null);	
			cbPaciente.setSelectedIndex(0);
			cbMedico.setSelectedIndex(0);
			}
		});
		limpar.setFocusPainted(false);
		limpar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		limpar.setBorder(new LineBorder(new Color(95, 158, 160)));
		limpar.setBackground(Color.WHITE);
		panel_15.add(limpar, "cell 12 0 2 1,grow");
		limpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				limpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				limpar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		panel_10.add(scrollPane, "cell 0 5 13 20,grow");
		
		tableAgenda = new JTable();
		atualizar();
		tableAgenda.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoAgenda = tableAgenda.getSelectedRow();
				agendaSelecionada = listAgendas.get(posicaoAgenda);
			}
		});
		scrollPane.setViewportView(tableAgenda);
		
		
		
	}
	public void atualizar() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID Consulta", "Prontuário","Nome Completo", "Hora", "Data", "CRM", "Título", "Numero do Cartão", });
		daoAgenda = new CDaoAgenda();
		listAgendas = daoAgenda.listarAgenda();
		
		if (listAgendas.size() > 0 && listAgendas != null) {
			for (MAgenda agenda : listAgendas) {
				modelo.addRow(new Object[] { agenda.getIdConsulta(),agenda.getPaciente().getProntuario(),agenda.getPaciente().getNomeCompleto(), agenda.getHora(), agenda.getData(),agenda.getMedico().getCrm(),agenda.getPaciente().getConvenio(), agenda.getPaciente().getnCarteira()});
			}
		}
		tableAgenda.setModel(modelo);
	}
}

