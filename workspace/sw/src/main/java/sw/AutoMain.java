package sw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AutoMain extends JFrame implements ActionListener, PatternsPack {

	private JPanel contentPane;
	private JTextField textFieldRuns;
	private JTextField textFieldApp;
	private JButton btnStart, btnStop;
	private String appName;
	private int runs;
	private Thread th;
	private volatile boolean flag = false;

	private PandaWorker pandaWorker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutoMain frame = new AutoMain();
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
	public AutoMain() {
		setResizable(false);
		JTextArea textAreaLog = new JTextArea();
		setTitle("AutoCorner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panelTop = new JPanel();
		contentPane.add(panelTop);
		panelTop.setLayout(null);

		JLabel lblLogs = new JLabel("Logs");
		lblLogs.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogs.setBounds(0, 204, 43, 21);
		panelTop.add(lblLogs);

		btnStop = new JButton("X");
		this.btnStop.addActionListener(this);
		//		btnStop.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent arg0) {
		//				System.out.println("asdwqdwqd");
		//			}
		//		});
		btnStop.setBounds(457, 73, 43, 20);
		panelTop.add(btnStop);

		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		//		
		//		btnStart.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {	
		//				System.out.println("saatarar");
		//			}
		//		});
		btnStart.setBounds(383, 73, 77, 20);
		panelTop.add(btnStart);

		JLabel lblOptions = new JLabel("Options");
		lblOptions.setBounds(336, 98, 86, 20);
		panelTop.add(lblOptions);

		JCheckBox chckbxAutoRefill = new JCheckBox("Auto Refill");
		chckbxAutoRefill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "NOPE, just gonna auto refill anyways");
			}
		});
		chckbxAutoRefill.setSelected(true);
		chckbxAutoRefill.setBounds(336, 118, 85, 21);
		panelTop.add(chckbxAutoRefill);
		chckbxAutoRefill.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JCheckBox chckbxDelayBetweenRuns = new JCheckBox("Delay between runs");
		chckbxDelayBetweenRuns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Still working on this");
			}
		});
		chckbxDelayBetweenRuns.setBounds(336, 138, 115, 21);
		panelTop.add(chckbxDelayBetweenRuns);
		chckbxDelayBetweenRuns.setFont(new Font("Tahoma", Font.PLAIN, 10));

		textFieldRuns = new JTextField();
		textFieldRuns.setBounds(383, 42, 115, 20);
		panelTop.add(textFieldRuns);
		textFieldRuns.setColumns(10);

		JLabel lblRuns = new JLabel("Runs:");
		lblRuns.setBounds(311, 45, 46, 14);
		panelTop.add(lblRuns);

		JLabel lblWhenYouLazy = new JLabel("When you lazy but gotta farm dungeon...");
		lblWhenYouLazy.setBounds(10, 138, 251, 21);
		panelTop.add(lblWhenYouLazy);

		JLabel lblPic = new JLabel("");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setIcon(new ImageIcon(AutoMain.class.getResource("/img/panda.png")));
		lblPic.setBounds(54, 14, 128, 125);
		panelTop.add(lblPic);

		JLabel labelAppName = new JLabel("App Name:");
		labelAppName.setBounds(311, 14, 62, 14);
		panelTop.add(labelAppName);

		textFieldApp = new JTextField("");
		textFieldApp.setColumns(10);
		textFieldApp.setBounds(383, 11, 115, 20);
		panelTop.add(textFieldApp);

		JLabel lblCornerbot = new JLabel("CornerBot v1.1");
		lblCornerbot.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCornerbot.setBounds(447, 166, 77, 14);
		panelTop.add(lblCornerbot);

		JLabel lblIllJustBe = new JLabel("I'll be here auto-ing... in one corner... :'D");
		lblIllJustBe.setBounds(10, 150, 272, 21);
		panelTop.add(lblIllJustBe);

		JPanel panelLogs = new JPanel();
		contentPane.add(panelLogs);
		panelLogs.setLayout(new GridLayout(0, 1, 0, 0));

		JTextArea textAreaLogs = new JTextArea();

		//		PrintStream con=new PrintStream(new TextAreaOutputStream(textAreaLogs));
		//		System.setOut(con);
		//		System.setErr(con);

		textAreaLogs.setEditable(false);
		panelLogs.add(textAreaLogs);
		JScrollPane scrollPane = new JScrollPane(textAreaLogs);
		panelLogs.add(scrollPane);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStart) {
			try {
				pandaWorker = new PandaWorker(textFieldRuns, textFieldApp) ;

				System.out.println("PandaBot Starting");
				pandaWorker.execute();
				System.out.println("PandaBot Started");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else {
			pandaWorker.cancel(true);
			System.out.println("Destroyed PandaBot");
		}

	}
}
