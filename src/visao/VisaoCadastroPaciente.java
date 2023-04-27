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
import javax.swing.DefaultComboBoxModel;

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
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	
	public VisaoCadastroPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:150px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:40px,grow][20px:n:30px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow]"));
		
		JPanel panel_1 = new JPanel();
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
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Sexo *");
		lblNewLabel_4_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_4_2_1, "cell 5 4,grow");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(textField_2, "cell 0 5 4 1,grow");
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Maculino");
		rdbtnNewRadioButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		panel_7.add(rdbtnNewRadioButton, "cell 5 5,grow");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Feminino");
		rdbtnNewRadioButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(rdbtnNewRadioButton_1, "cell 6 5 2 1,grow");
		
		JLabel lblNewLabel_4_2 = new JLabel("Data de Nascimento *");
		lblNewLabel_4_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_7.add(lblNewLabel_4_2, "cell 0 7 4 1,grow");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dia", "1", "2", "3", "4", "5", "6", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(comboBox, "cell 0 8,grow");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(comboBox_1, "cell 1 8 2 1,grow");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Ano", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboBox_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		panel_7.add(comboBox_2, "cell 3 8,grow");
		
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
		panel_12.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Estado *");
		lblNewLabel_3_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_12.add(lblNewLabel_3_1_1, "cell 1 0");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Estado", "Acre (AC)", "Alagoas (AL)", "Amapá (AP)", "Amazonas (AM)", "Bahia (BA)", "Ceará (CE)", "Distrito Federal (DF)", "Espírito Santo (ES)", "Goiás (GO)", "Maranhão (MA)", "Mato Grosso (MT)", "Mato Grosso do Sul (MS)", "Minas Gerais (MG)", "Pará (PA)", "Paraíba (PB)", "Paraná (PR)", "Pernambuco (PE)", "Estados", "Piauí (PI)", "Rio de Janeiro (RJ)", "Rio Grande do Norte (RN)", "Rio Grande do Sul (RS)", "Rondônia (RO)", "Roraima (RR)", "Santa Catarina (SC)", "São Paulo (SP)", "Sergipe (SE)", "Tocantins (TO)"}));
		panel_12.add(comboBox_3, "cell 1 1,growx");
		
		JLabel lblNewLabel_3_1 = new JLabel("Cidade *");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_12.add(lblNewLabel_3_1, "cell 1 3");
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_6.setColumns(10);
		panel_12.add(textField_6, "cell 1 4,growx");
		
		JLabel lblNewLabel_3_1_2 = new JLabel("CEP *");
		lblNewLabel_3_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_12.add(lblNewLabel_3_1_2, "cell 1 6");
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_7.setColumns(10);
		panel_12.add(textField_7, "cell 1 7,growx");
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Rua *");
		lblNewLabel_3_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_12.add(lblNewLabel_3_1_2_1, "cell 1 9");
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_8.setColumns(10);
		panel_12.add(textField_8, "cell 1 10,growx");
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("Número *");
		lblNewLabel_3_1_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_12.add(lblNewLabel_3_1_2_1_1, "cell 1 12");
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_9.setColumns(10);
		panel_12.add(textField_9, "cell 1 13,growx");
		
		JLabel lblNewLabel_3_1_2_1_1_1 = new JLabel("Complemento");
		lblNewLabel_3_1_2_1_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		panel_12.add(lblNewLabel_3_1_2_1_1_1, "cell 1 15");
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		textField_10.setColumns(10);
		panel_12.add(textField_10, "cell 1 16,growx");
		
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