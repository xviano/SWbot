import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.android.dx.command.findusages.Main;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class Corner extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldRuns;
	private JTextField textFieldApp;
	private JButton btnStart, btnStop;
	private Panda p;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Corner frame = new Corner();
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
	public Corner() {
		setResizable(false);

		JTextArea textAreaLog = new JTextArea();
		setTitle("AutoOneCorner");
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

		btnStop = new JButton("?");
		btnStop.addActionListener(this);

		btnStop.setBounds(457, 73, 43, 20);
		panelTop.add(btnStop);

		btnStart = new JButton("Start");
		btnStart.addActionListener(this);

		btnStart.setBounds(383, 73, 77, 20);
		panelTop.add(btnStart);

		JLabel lblOptions = new JLabel("Options");
		lblOptions.setBounds(336, 98, 86, 20);
		panelTop.add(lblOptions);

		JCheckBox chckbxAutoRefill = new JCheckBox("Auto Refill");
		chckbxAutoRefill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "NOPE, just gonna auto refill anyways");
				chckbxAutoRefill.setSelected(true);
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

		textFieldRuns = new JTextField("3");
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
		lblPic.setIcon(new ImageIcon(Corner.class.getResource("/img/panda.png")));
		lblPic.setBounds(54, 14, 128, 125);
		panelTop.add(lblPic);

		JLabel labelAppName = new JLabel("App Name:");
		labelAppName.setBounds(311, 14, 62, 14);
		panelTop.add(labelAppName);

		textFieldApp = new JTextField("Nox");
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

		PrintStream con=new PrintStream(new TextAreaOutputStream(textAreaLogs));
		System.setOut(con);
		System.setErr(con);

		textAreaLogs.setEditable(false);
		//panelLogs.add(textAreaLogs);
		JScrollPane scrollPane = new JScrollPane(textAreaLogs);
		panelLogs.add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnStart) {
			System.out.println("Bloop");
			p = new Panda(textFieldApp.getText(), Integer.parseInt(textFieldRuns.getText()));
			p.start();
		}
		else {
			//JOptionPane.showMessageDialog(null, "Close this app to stop everything.");
			// p.getScriptDetails();
			//System.out.println(p.isInterrupted());

		}

	}


}
