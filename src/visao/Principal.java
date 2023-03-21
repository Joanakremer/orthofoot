package visao;

import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel clocklbl;

	public void clock() {
		Thread clock = new Thread() {
			public void run() {

				try {
					for (;;) {
						LocalDateTime dataHora = LocalDateTime.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd/MM/yyyy         HH:mm");
						String horaFormatada = dataHora.format(formatter);
						clocklbl.setText(horaFormatada);
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(95, 158, 160));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0,0,0)));
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[100.00px:n:250px,grow][100.00px:n:250px,grow][100.00px:n:250px,grow][100.00px:n:250px,grow][100.00px:n:250px,grow][100.00px:n:250px,grow][100.00px:n:250px,grow][100.00px:n:250px,grow][100.00px:n:250px,grow]", "[100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:50px,grow][100.00px:n:70px,grow][70.00px:n:45px,grow]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1, "cell 0 0 9 2,grow");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "cell 0 17 2 1,grow");
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/calendario.png")));
		lblNewLabel.setBounds(10, 11, 24, 23);
		panel_2.add(lblNewLabel);
		
		JLabel clocklbl = new JLabel("clock");
		clocklbl.setBounds(44, 11, 365, 23);
		panel_2.add(clocklbl);
		clock();
	}
}
