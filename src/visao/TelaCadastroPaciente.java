package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
import modelo.MPaciente;
import javax.swing.JComboBox;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtProntuario;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtCarteira;
	private JFormattedTextField txtContato;
	private JTextField txtConvenio;
	private JComboBox<String> cbDia, cbMes, cbAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
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
	public TelaCadastroPaciente() {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 627);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		new JTextField();
		try {
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		new JTextField();
		try {
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		new JTextField();
		new JTextField();
		try {
			txtDMA = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txtDMA.setForeground(Color.BLACK);
			txtDMA.setBorder(new LineBorder(Color.WHITE, 4, true));
			txtDMA.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtDMA.setBounds(258, 213, 200, 29);
		txtDMA.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CEP", "Rua", "Cidade", "Estado"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 854, 45);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRAR PACIENTE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(221, 11, 285, 27);
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 67, 503, 255);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo *");
		lblNewLabel_2.setBounds(10, 24, 351, 29);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 53, 476, 29);
		panel_3.add(txtNome);
		txtNome.setForeground(Color.BLACK);
		txtNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("* CPF");
		lblNewLabel_2_1.setBounds(10, 93, 127, 29);
		panel_3.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(10, 122, 127, 29);
		panel_3.add(txtCpf);
		txtCpf.setText("         .        .     -  ");
		txtCpf.setForeground(Color.BLACK);
		txtCpf.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Data Nascimento *");
		lblNewLabel_2_1_2.setBounds(173, 93, 222, 29);
		panel_3.add(lblNewLabel_2_1_2);
		lblNewLabel_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Sexo");
		lblNewLabel_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_2_1_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_4.setBounds(10, 162, 127, 29);
		panel_3.add(lblNewLabel_2_1_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(172, 122, 59, 29);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(232, 122, 152, 29);
		panel_3.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(386, 122, 100, 29);
		panel_3.add(comboBox_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 191, 127, 29);
		panel_3.add(comboBox_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Contato *");
		lblNewLabel_2_1_3.setBounds(173, 162, 313, 29);
		panel_3.add(lblNewLabel_2_1_3);
		lblNewLabel_2_1_3.setForeground(Color.BLACK);
		lblNewLabel_2_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtContato = new JFormattedTextField(new MaskFormatter("(+##)## #####-####"));
		txtContato.setBounds(173, 191, 313, 29);
		panel_3.add(txtContato);
		txtContato.setForeground(Color.BLACK);
		txtContato.setBorder(new LineBorder(Color.WHITE, 4, true));
		txtContato.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtContato.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 333, 503, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1_2_1.setBounds(10, 11, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_1);
		lblNewLabel_2_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(10, 40, 473, 29);
		panel_1.add(txtConvenio);
		txtConvenio.setForeground(Color.BLACK);
		txtConvenio.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtConvenio.setBorder(new LineBorder(Color.WHITE, 4, true));
		txtConvenio.setColumns(10);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Nº Carteira");
		lblNewLabel_2_1_2_2.setBounds(10, 80, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_2);
		lblNewLabel_2_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtCarteira = new JTextField();
		txtCarteira.setBounds(10, 111, 473, 29);
		panel_1.add(txtCarteira);
		txtCarteira.setForeground(Color.BLACK);
		txtCarteira.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtCarteira.setBorder(new LineBorder(Color.WHITE, 4, true));
		txtCarteira.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(523, 67, 341, 255);
		contentPane.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(775, 535, 89, 31);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(8, 9, 137, 29);
		textField.setColumns(10);
	}
}
