package visao;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import modelo.MUsuario;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblclock;

	public void clock() {
		Thread clock = new Thread() {
			public void run() {

				try {
					for (;;) {
						LocalDateTime dataHora = LocalDateTime.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
						String horaFormatada = dataHora.format(formatter);
						lblclock.setText(horaFormatada);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal(MUsuario usuario) {
		setUndecorated(true);
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 90, 1306, 698);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(95, 158, 160));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel
		// -------------------------------------------------------------------------------------------------------------------------------

		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1306, 84);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(47, 79, 79)));
		panel_1.setBounds(0, 650, 1306, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel agendamenu = new JLabel("Agenda");
		agendamenu.setHorizontalTextPosition(SwingConstants.CENTER);
		agendamenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				agendamenu.setForeground(new Color(95, 158, 160));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				agendamenu.setForeground(Color.BLACK);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TelaAgenda telaAgenda = new TelaAgenda();
				telaAgenda.setLocationRelativeTo(null);
				telaAgenda.setVisible(true);

			}
		});
		agendamenu.setForeground(Color.BLACK);
		agendamenu.setBorder(null);
		agendamenu.setFont(new Font("Carlito", Font.PLAIN, 22));
		agendamenu.setHorizontalAlignment(SwingConstants.CENTER);
		agendamenu.setBounds(706, 29, 218, 33);
		panel.add(agendamenu);

		JLabel pacientemenu = new JLabel("Paciente");
		pacientemenu.setHorizontalTextPosition(SwingConstants.CENTER);
		pacientemenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				pacientemenu.setForeground(new Color(95, 158, 160));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				pacientemenu.setForeground(Color.BLACK);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TelaPaciente telaPaciente = new TelaPaciente();
				telaPaciente.setLocationRelativeTo(null);
				telaPaciente.setVisible(true);
			}
		});
		pacientemenu.setForeground(Color.BLACK);
		pacientemenu.setHorizontalAlignment(SwingConstants.CENTER);
		pacientemenu.setFont(new Font("Carlito", Font.PLAIN, 22));
		pacientemenu.setBorder(null);
		pacientemenu.setBounds(895, 30, 218, 33);
		panel.add(pacientemenu);

		JLabel usuariomenu = new JLabel("Usuário");
		usuariomenu.setHorizontalTextPosition(SwingConstants.CENTER);
		usuariomenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				usuariomenu.setForeground(new Color(95, 158, 160));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				usuariomenu.setForeground(Color.BLACK);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				TelaUsuario telaUsuario = new TelaUsuario();
				telaUsuario.setLocationRelativeTo(null);
				telaUsuario.setVisible(true);
			}
		});
		usuariomenu.setForeground(Color.BLACK);
		usuariomenu.setHorizontalAlignment(SwingConstants.CENTER);
		usuariomenu.setFont(new Font("Carlito", Font.PLAIN, 22));
		usuariomenu.setBorder(null);
		usuariomenu.setBounds(1088, 30, 218, 33);
		panel.add(usuariomenu);

		JLabel lblNewLabel = new JLabel("logo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 10, 242, 63);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/Logo 2.png")));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(423, 259, 478, 255);
		contentPane.add(lblNewLabel_1);

		lblclock = new JLabel("clock");
		lblclock.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lblclock.setFont(new Font("Arial", Font.BOLD, 18));
		lblclock.setBounds(10, 11, 316, 26);
		panel_1.add(lblclock);
		setLocationRelativeTo(null);
		clock();
	}
}
