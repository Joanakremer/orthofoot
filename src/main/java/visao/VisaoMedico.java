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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controle.CDao;
import controle.CDaoMedico;
import modelo.MMedico;
import modelo.MPaciente;
import net.miginfocom.swing.MigLayout;

public class VisaoMedico extends JFrame {
	
	private JTextField txtBuscaNome;
	private JPanel contentPane;
	private JLabel lblNewLabel_3;
	private JTable tableMedico;
	private CDaoMedico daoMedico;
	private JComboBox<String> cbDia,cbMes,cbAno;
	private ArrayList<MMedico> listarMedico;
	private MMedico medicoSelecionado;
	private JTable table;
	private JComboBox cbSexo;
	private String crm;
	private JTextField txtCrm;
	private JTextField txtNome;
	
	public VisaoMedico() {
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
				panel_7.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				panel_7.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		panel_7.setBackground(Color.WHITE);
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
		panel_11.setLayout(new MigLayout("", "[20px:n:1200px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_12 = new JLabel("MÉDICO");
		lblNewLabel_12.setForeground(Color.WHITE);
		panel_11.add(lblNewLabel_12, "cell 0 0,growx,aligny top");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtBuscaNome = new JTextField();
		panel_10.add(txtBuscaNome, "cell 0 3 4 1,grow");
		txtBuscaNome.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(220, 220, 220));
		panel_2.add(panel_9, "cell 25 0 12 21,grow");
		panel_9.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:20px,grow][20px:n:70px,grow]"));
		
		JPanel panel_11_1 = new JPanel();
		panel_11_1.setBackground(new Color(95, 158, 160));
		panel_9.add(panel_11_1, "cell 0 0 12 2,grow");
		panel_11_1.setLayout(new MigLayout("", "[20px:n:800px,grow]", "[20px:n:100px,grow]"));
		
		JLabel lblNewLabel_12_1 = new JLabel("Cadastrar Médico");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12_1.setForeground(Color.WHITE);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 38));
		panel_11_1.add(lblNewLabel_12_1, "cell 0 0,grow");
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(null);
		panel_12.setBackground(Color.WHITE);
		panel_9.add(panel_12, "cell 0 2 12 7,grow");
		panel_12.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow][20px:n:30px,grow]"));
		
		JLabel lblNewLabel_14 = new JLabel("CRM *");
		lblNewLabel_14.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14, "cell 0 0 7 1,grow");
		
		txtCrm = new JTextField();
		txtCrm.setForeground(Color.BLACK);
		txtCrm.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCrm.setBackground(new Color(255, 245, 238));
		txtCrm.setColumns(10);
		panel_12.add(txtCrm, "cell 0 1 6 1,grow");
		
		JLabel lblNewLabel_14_1 = new JLabel("Nome Completo *");
		lblNewLabel_14_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_12.add(lblNewLabel_14_1, "cell 0 2 7 1");
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
		
		JComboBox cbSexo = new JComboBox();
		cbSexo.setBackground(new Color(255, 245, 238));
		panel_12.add(cbSexo, "cell 0 5 5 1,grow");
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		cbSexo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		cbSexo.setBounds(10, 179, 181, 29);
		
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
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.LIGHT_GRAY);
		panel_9.add(panel_15, "cell 0 24 12 1,grow");
		panel_15.setLayout(new MigLayout("", "[20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]", "[20px:n:50px,grow]"));
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MMedico newMedico = new MMedico();
				String crm = txtCrm.getText();
				if (crm == null || crm.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CRM está vazio");
				} else {
					newMedico.setCrm(Long.valueOf(crm));
				}
				String nomeCompleto = txtNome.getText();
				if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME COMPLETO está vazio");
				} else {
					newMedico.setnomeCompleto(nomeCompleto);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();
				
				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				newMedico.setdataNasc(data);
	
				String sexo =String.valueOf(cbSexo.getSelectedItem().toString());
				newMedico.setSexo(sexo);
				
				CDaoMedico tableMedico = CDaoMedico.getInstancia();
				boolean insert = tableMedico.inserir(newMedico);
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");
					atualizar();
					txtNome.setText(null);
					txtCrm.setText(null);
					cbSexo.setSelectedItem("Masculino");
					cbDia.setSelectedIndex(0);
					cbMes.setSelectedIndex(0);
					cbAno.setSelectedItem("2023");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
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
		
		JButton atualizar = new JButton("Atualizar");
		atualizar.setEnabled(false);
		atualizar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		atualizar.setFocusPainted(false);
		atualizar.setBorder(new LineBorder(new Color(95, 158, 160)));
		atualizar.setBackground(Color.WHITE);
		panel_15.add(atualizar, "cell 5 0 5 1,grow");
		atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crm = txtCrm.getText().replace("", "");
				if (crm == null || crm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					medicoSelecionado.setCrm(Long.valueOf(crm));
				}
				String nomeCompleto = txtNome.getText();
				if (nomeCompleto == null || nomeCompleto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					medicoSelecionado.setnomeCompleto(nomeCompleto);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();

				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				medicoSelecionado.setdataNasc(data);
				
				String sexo =String.valueOf(cbSexo.getSelectedItem().toString());
					medicoSelecionado.setSexo(sexo);
				
				
				CDaoMedico tableMedico = CDaoMedico.getInstancia();
				atualizar();
				boolean update = tableMedico.update(medicoSelecionado);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");

					txtNome.setText(null);
					txtCrm.setText(null);
					cbSexo.setSelectedItem("Masculino");
					cbDia.setSelectedIndex(0);
					cbMes.setSelectedIndex(0);
					cbAno.setSelectedItem("2023");
					atualizar();
					atualizar.setEnabled(false);
					cadastrar.setEnabled(true);
					txtCrm.enable();
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
				atualizar();
			}
		});
		
		JButton deletar = new JButton("  Deletar");
		deletar.setIcon(new ImageIcon(VisaoMedico.class.getResource("/imagens/perigo24.png")));
		deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDaoMedico c = new CDaoMedico();
				if(medicoSelecionado != null) {
					c.delete(medicoSelecionado);
					listarMedico.remove(medicoSelecionado);
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
					atualizar();
					txtNome.setText(null);
					txtCrm.setText(null);
					cbSexo.setSelectedItem("Masculino");
					cbDia.setSelectedIndex(0);
					cbMes.setSelectedIndex(0);
					cbAno.setSelectedItem("2023");
					txtCrm.enable();
					atualizar.setEnabled(false);
					cadastrar.setEnabled(true);
				}else {
					JOptionPane.showInternalMessageDialog(null, "erro na remoção do dado");
				}
				atualizar();
			}
		});
		deletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				deletar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		JButton pesquisar = new JButton("");
		pesquisar.setIcon(new ImageIcon(VisaoMedico.class.getResource("/imagens/procurar24.png")));
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
			@Override
				public void mouseClicked(MouseEvent e) {
					ArrayList<MMedico> medico = daoMedico.listarMedico();

					String nomeDigitado = txtBuscaNome.getText();

					if (!nomeDigitado.isEmpty()) {

						nomeDigitado = nomeDigitado.toLowerCase();

						ArrayList<MMedico> medicoFiltrados = new ArrayList<>();

						for (MMedico mMedico : medico) {

							if (mMedico.getnomeCompleto().toLowerCase().contains(nomeDigitado)) {
								medicoFiltrados.add(mMedico);
							}
						}

						// monta a tabela filtrada
						
						
						DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
								new String[] {"CRM", "Nome Completo", "Data de Nascimento", "Sexo"});
						listarMedico = daoMedico.listarMedico();

						if (medicoFiltrados.size() > 0 && medicoFiltrados != null) {
							for (MMedico medico1 : medicoFiltrados) {
								modelo.addRow(new Object[] { medico1.getCrm(), medico1.getnomeCompleto(), medico1.getDataFormatada(),
										medico1.getSexo()});
							}
						}
						tableMedico.setModel(modelo);

						TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableMedico.getModel());
						tableMedico.setRowSorter(sorter);

						List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
						sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
						sorter.setSortKeys(sortKeys);

						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
						centerRenderer.setHorizontalAlignment(JLabel.CENTER);

						for (int i = 0; i < tableMedico.getColumnCount(); i++) {
							tableMedico.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
						}

					}
				}
			});
		
		deletar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		deletar.setBorder(new LineBorder(new Color(95, 158, 160)));
		deletar.setFocusPainted(false);
		deletar.setForeground(Color.BLACK);
		deletar.setBackground(Color.WHITE);
		panel_10.add(deletar, "cell 11 3 2 1,grow");
		
		JButton limpar = new JButton("");
		limpar.setIcon(new ImageIcon(VisaoMedico.class.getResource("/imagens/lixeira24.png")));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
				txtCrm.setText(null);
				cbSexo.setSelectedItem("Masculino");
				cbDia.setSelectedIndex(0);
				cbMes.setSelectedIndex(0);
				cbAno.setSelectedItem("2023");
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
		
		daoMedico = CDaoMedico.getInstancia();
		tableMedico = new JTable();
		scrollPane.setViewportView(tableMedico);
		
		tableMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tableMedico.getSelectedRow();
				medicoSelecionado = listarMedico.get(posicaoPessoa);
				txtNome.setText(medicoSelecionado.getnomeCompleto());
				txtCrm.setText(String.valueOf(medicoSelecionado.getCrm()));
				cbDia.setSelectedIndex(medicoSelecionado.getdataNasc().getDayOfMonth());
				cbMes.setSelectedIndex(medicoSelecionado.getdataNasc().getMonthValue());
				cbAno.setSelectedItem(medicoSelecionado.getdataNasc().getYear()+"");
				cbSexo.setSelectedItem(medicoSelecionado.getSexo());
				if(medicoSelecionado != null) {
					txtCrm.disable();
					atualizar.setEnabled(true);
					cadastrar.setEnabled(false);				
					}
			}
		});	
		
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
		atualizar();

		}
	
		public void atualizar() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] {"CRM", "Nome Completo", "Data de Nascimento", "Sexo"});
		listarMedico = daoMedico.listarMedico();

		if (listarMedico.size() > 0 && listarMedico != null) {
			for (MMedico medico : listarMedico) {
				modelo.addRow(new Object[] { medico.getCrm(), medico.getnomeCompleto(), medico.getDataFormatada(),
						medico.getSexo()});
			}
		}

		tableMedico.setModel(modelo);
		
		tableMedico.setModel(modelo);

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableMedico.getModel());
		tableMedico.setRowSorter(sorter);

		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < tableMedico.getColumnCount(); i++) {
			tableMedico.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
	}
}



