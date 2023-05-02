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
import javax.swing.DefaultComboBoxModel;

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
	 * @throws ParseException 
	 */
	public TelaCadastroPaciente() throws ParseException {	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 570);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 507, 45);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRAR PACIENTE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(102, 11, 285, 27);
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 67, 507, 225);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo *");
		lblNewLabel_2.setBounds(10, 11, 351, 29);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 40, 476, 29);
		panel_3.add(txtNome);
		txtNome.setForeground(Color.BLACK);
		txtNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("CPF *");
		lblNewLabel_2_1.setBounds(10, 80, 127, 29);
		panel_3.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(10, 109, 127, 29);
		panel_3.add(txtCpf);
		txtCpf.setText("         .        .     -  ");
		txtCpf.setForeground(Color.BLACK);
		txtCpf.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Data Nascimento *");
		lblNewLabel_2_1_2.setBounds(173, 80, 222, 29);
		panel_3.add(lblNewLabel_2_1_2);
		lblNewLabel_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Sexo *");
		lblNewLabel_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_2_1_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_4.setBounds(10, 149, 127, 29);
		panel_3.add(lblNewLabel_2_1_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox.setBounds(172, 109, 59, 29);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_1.setBounds(232, 109, 152, 29);
		panel_3.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Ano", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboBox_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_1_1.setBounds(386, 109, 100, 29);
		panel_3.add(comboBox_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBox_2.setBounds(10, 178, 127, 29);
		panel_3.add(comboBox_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Contato *");
		lblNewLabel_2_1_3.setBounds(173, 149, 313, 29);
		panel_3.add(lblNewLabel_2_1_3);
		lblNewLabel_2_1_3.setForeground(Color.BLACK);
		lblNewLabel_2_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtContato = new JFormattedTextField(new MaskFormatter("(+##)## #####-####"));
		txtContato.setBounds(173, 178, 313, 29);
		panel_3.add(txtContato);
		txtContato.setForeground(Color.BLACK);
		txtContato.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtContato.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 303, 507, 155);
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
		txtCarteira.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(428, 482, 89, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cadastrar Endereço *");
		btnNewButton.setBounds(10, 482, 189, 31);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		
	}
}
