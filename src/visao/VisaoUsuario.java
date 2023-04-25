package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import componentesVisuais.HintTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class VisaoUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableUsuarios;

	
	public VisaoUsuario() {
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
		panel_2.setLayout(new MigLayout("", "[288.00px:n:240px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]", "[20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_2.add(panel_3, "cell 0 0 1 21,grow");
		panel_3.setLayout(new MigLayout("", "[20px:n:200px,grow][20px:n:40px,grow]", "[20px:n:60px,grow][20px:n:50px,grow][10px:n:10px,grow][20px:n:50px,grow][10px:n:10px,grow][20px:n:50px,grow][10px:n:10px,grow][20px:n:50px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:30px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow][20px:n:50px,grow]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/menu32.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEADING);
		panel_3.add(lblNewLabel_1, "cell 1 0,grow");
		
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
		panel_4.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:200px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/casa32.png")));
		panel_4.add(lblNewLabel_2, "cell 0 0,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Home");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
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
		panel_5.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:200px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/agenda32.png")));
		panel_5.add(lblNewLabel_4, "cell 0 0,growx");
		
		JLabel lblNewLabel_8 = new JLabel("Agenda");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		panel_5.add(lblNewLabel_8, "cell 1 0");
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(Color.WHITE);
				panel_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(95, 158, 160));
				panel_6.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				VisaoPaciente visaoPaciente = new VisaoPaciente();
				visaoPaciente.setVisible(true);
				dispose();
			}
		});
		panel_6.setBackground(new Color(95, 158, 160));
		panel_3.add(panel_6, "cell 0 5 2 1,grow");
		panel_6.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:200px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/paciente32.png")));
		panel_6.add(lblNewLabel_5, "cell 0 0,growx");
		
		JLabel lblNewLabel_9 = new JLabel("Paciente");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		panel_6.add(lblNewLabel_9, "cell 1 0");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_3.add(panel_7, "cell 0 7 2 1,grow");
		panel_7.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:200px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/usuarios32.png")));
		panel_7.add(lblNewLabel_6, "cell 0 0,growx");
		
		JLabel lblNewLabel_10 = new JLabel("Usuário");
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		panel_7.add(lblNewLabel_10, "cell 1 0");
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, "cell 0 16 2 1,grow");
		panel_8.setLayout(new MigLayout("", "[20px:n:40px,grow][20px:n:150px,grow][20px:n:40px,grow]", "[20px:n:50px,grow]"));
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(VisaoPrincipal.class.getResource("/imagens/icone32.png")));
		panel_8.add(lblNewLabel_7, "cell 0 0,growx");
		
		JLabel lblNewLabel_12 = new JLabel("Nome Usuário");
		lblNewLabel_12.setForeground(Color.BLACK);
		lblNewLabel_12.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		panel_8.add(lblNewLabel_12, "cell 1 0,growx,aligny center");
		
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
		panel_8.add(lblNewLabel_11, "cell 2 0,growx");
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(null);
		panel_9.setBackground(Color.WHITE);
		panel_2.add(panel_9, "cell 1 0 38 21,grow");
		panel_9.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow]", "[20px:n:40px,grow][20px:n:50px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]"));
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10, "cell 0 1 20 1,grow");
		panel_10.setLayout(new MigLayout("", "[20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:60px,grow][20px:n:80px,grow][20px:n:80px,grow][20px:n:60px,grow][20px:n:80px,grow]", "[10px:n:50px,grow]"));
		
		
		HintTextField pesquisartxt = new HintTextField("Pesquisar");
		panel_10.add(pesquisartxt, "cell 0 0 4 1,grow");
		pesquisartxt.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		pesquisartxt.setBounds(64, 247, 307, 48);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		panel_10.add(btnNewButton, "cell 4 0,grow");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(VisaoPaciente.class.getResource("/imagens/procurar24.png")));
		btnNewButton.setBackground(new Color(95, 158, 160));
		
		JButton btnNewButton_3 = new JButton(" Cadastrar");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		panel_10.add(btnNewButton_3, "cell 13 0 2 1,growx");
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		btnNewButton_3.setIcon(new ImageIcon(VisaoPaciente.class.getResource("/imagens/adicionar24.png")));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(95, 158, 160));
		
		JButton btnNewButton_2 = new JButton(" Excluir");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		panel_10.add(btnNewButton_2, "cell 16 0 2 1,growx");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 24));
		btnNewButton_2.setIcon(new ImageIcon(VisaoPaciente.class.getResource("/imagens/excluir24.png")));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(95, 158, 160));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		panel_10.add(btnNewButton_1, "cell 19 0,grow");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(VisaoPaciente.class.getResource("/imagens/atualizar24.png")));
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_9.add(scrollPane, "cell 0 3 20 17,grow");
		
		tableUsuarios = new JTable();
		tableUsuarios.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		tableUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Usuário", "Login", "Senha", "Tipo"
			}
		));
		scrollPane.setViewportView(tableUsuarios);
	}

}
