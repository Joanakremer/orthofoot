package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.border.MatteBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblclock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clock(){
		Thread clock = new Thread() {
			public void run() {
				
				try {
					for(;;) {
					LocalDate data = LocalDate.now();
					LocalTime hora = LocalTime.now();
					lblclock.setText(""+data.toString()+"    |    "+hora.toString());
					sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setUndecorated(true);
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 90, 1306, 698);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(47, 79, 79)));
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 0, 1306, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBounds(22, 24, 276, 33);
		panel.add(lblNewLabel);
		
		
		JButton sairbt = new JButton("");
		sairbt.setBounds(1236, 24, 47, 33);
		panel.add(sairbt);
		sairbt.setFocusPainted(false);
		sairbt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TelaPrincipal.this.dispose();
			}

			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		sairbt.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/sair-alt.png")));
		sairbt.setBorder(null);
		sairbt.setBackground(Color.WHITE);
		
		JLabel agendamenu = new JLabel("Agenda");
		agendamenu.setForeground(Color.WHITE);
		agendamenu.setBorder(null);
		agendamenu.setFont(new Font("Arial", Font.BOLD, 22));
		agendamenu.setHorizontalAlignment(SwingConstants.CENTER);
		agendamenu.setBounds(300, 24, 218, 33);
		panel.add(agendamenu);
		
		JLabel pacientemenu = new JLabel("Paciente");
		pacientemenu.setForeground(Color.WHITE);
		pacientemenu.setHorizontalAlignment(SwingConstants.CENTER);
		pacientemenu.setFont(new Font("Arial", Font.BOLD, 22));
		pacientemenu.setBorder(null);
		pacientemenu.setBounds(516, 24, 218, 33);
		panel.add(pacientemenu);
		
		JLabel usuariomenu = new JLabel("Usuário");
		usuariomenu.setForeground(Color.WHITE);
		usuariomenu.setHorizontalAlignment(SwingConstants.CENTER);
		usuariomenu.setFont(new Font("Arial", Font.BOLD, 22));
		usuariomenu.setBorder(null);
		usuariomenu.setBounds(732, 24, 218, 33);
		panel.add(usuariomenu);
		
		JLabel separator1 = new JLabel("New label");
		separator1.setBorder(new LineBorder(Color.WHITE, 6));
		separator1.setBounds(516, 26, 2, 33);
		panel.add(separator1);
		
		JLabel separator2 = new JLabel("New label");
		separator2.setBorder(new LineBorder(Color.WHITE, 6));
		separator2.setBounds(732, 26, 2, 33);
		panel.add(separator2);
		
		JLabel separator3 = new JLabel("New label");
		separator3.setBorder(new LineBorder(Color.WHITE, 6));
		separator3.setBounds(948, 26, 2, 33);
		panel.add(separator3);
		
		JLabel lblNewLabel_1 = new JLabel("LOGO\r\n");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(490, 259, 325, 168);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(47, 79, 79)));
		panel_1.setBounds(0, 650, 1306, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblclock = new JLabel("clock");
		lblclock.setFont(new Font("Arial", Font.BOLD, 18));
		lblclock.setBounds(10, 11, 316, 26);
		panel_1.add(lblclock);
		setLocationRelativeTo(null);
		clock();
	}
}
