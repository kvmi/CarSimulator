import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SymulatorAuta extends JFrame implements KeyListener {
	
	Samochod samochod = new Samochod(false, 0, 0, 0);
	private JLabel labelObroty;
	private JLabel labelPredkosc;
	private JLabel labelWiadomosc;
	private JLabel labelBieg;
	private JLabel labelAlert;
	
	public SymulatorAuta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Symulator Auta");
		getContentPane().setLayout(null);
		
		addKeyListener(this);
        setFocusable(true);
		
		JLabel lblSymulatorSamochodu = new JLabel("Symulator samochodu");
		lblSymulatorSamochodu.setEnabled(false);
		lblSymulatorSamochodu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSymulatorSamochodu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSymulatorSamochodu.setBounds(10, 32, 714, 65);
		getContentPane().add(lblSymulatorSamochodu);
		
		labelObroty = new JLabel("0");
		labelObroty.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelObroty.setHorizontalAlignment(SwingConstants.CENTER);
		labelObroty.setBounds(537, 246, 82, 66);
		getContentPane().add(labelObroty);
		
	
		labelPredkosc = new JLabel("0");
		labelPredkosc.setHorizontalAlignment(SwingConstants.CENTER);
		labelPredkosc.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelPredkosc.setBounds(537, 130, 82, 66);
		getContentPane().add(labelPredkosc);
		
		JButton buttonWlaczSilnik = new JButton("W\u0142\u0105cz silnik");
		buttonWlaczSilnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				samochod.setSilnik(true);
        		samochod.setObroty(800);
        		samochod.setBieg(1);
        		labelBieg.setText(String.valueOf(samochod.getBieg()));
        		labelObroty.setText(String.valueOf(samochod.getObroty()));
        		labelWiadomosc.setText("");
        		labelAlert.setText("");
        		samochod.setPredkosc(0);
        		labelPredkosc.setText("0");
			}
			
		});
		buttonWlaczSilnik.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonWlaczSilnik.setBounds(57, 119, 143, 78);
		getContentPane().add(buttonWlaczSilnik);
		buttonWlaczSilnik.setFocusable(false);
		
		JButton buttonWylaczSilnik = new JButton("Wy\u0142\u0105cz silnik");
		buttonWylaczSilnik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				samochod.setSilnik(false);
				samochod.setObroty(0);
				labelObroty.setText(String.valueOf(samochod.getObroty()));
				labelWiadomosc.setText("Wy³¹czy³eœ silnik");
				
			}
		});
		buttonWylaczSilnik.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonWylaczSilnik.setBounds(57, 241, 143, 78);
		getContentPane().add(buttonWylaczSilnik);
		buttonWylaczSilnik.setFocusable(false);
		
		JButton buttonWyzszyBieg = new JButton("Wy\u017Cszy bieg");
		buttonWyzszyBieg.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonWyzszyBieg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(samochod.getBieg() < 5)
				{
				samochod.setBieg(samochod.getBieg() + 1);
				samochod.setObroty((int)(samochod.getObroty() * 0.5));
				labelBieg.setText(String.valueOf(samochod.getBieg()));
				labelObroty.setText(String.valueOf(samochod.getObroty()));
				labelWiadomosc.setText("");
				}
			}
		});
		buttonWyzszyBieg.setBounds(275, 119, 143, 78);
		getContentPane().add(buttonWyzszyBieg);
		buttonWyzszyBieg.setFocusable(false);
		
		JButton buttonNizszyBieg = new JButton("Ni\u017Cszy bieg");
		buttonNizszyBieg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(samochod.getBieg() > 0 && samochod.getBieg() <= 5)
				{
				samochod.setBieg(samochod.getBieg() - 1);
				samochod.setObroty((samochod.getObroty() * 2));
				labelBieg.setText(String.valueOf(samochod.getBieg()));
				labelObroty.setText(String.valueOf(samochod.getObroty()));
				labelWiadomosc.setText("");
				}
				if(samochod.getObroty() > 5000)
            	{
            	labelAlert.setText("Przegrza³eœ silnik!");
            	samochod.setSilnik(false);
            	samochod.setPredkosc(0);
            	samochod.setObroty(0);
            	labelPredkosc.setText(String.valueOf(samochod.getPredkosc()));
            	labelObroty.setText(String.valueOf(samochod.getObroty()));
            	}

			}
		});
		buttonNizszyBieg.setFont(new Font("Tahoma", Font.BOLD, 17));
		buttonNizszyBieg.setBounds(275, 241, 143, 78);
		getContentPane().add(buttonNizszyBieg);
		buttonNizszyBieg.setFocusable(false);
		
		JLabel labelPredkosciomierz = new JLabel("Pr\u0119dko\u015Bciomierz");
		labelPredkosciomierz.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		labelPredkosciomierz.setBounds(542, 119, 130, 14);
		getContentPane().add(labelPredkosciomierz);
		
		JLabel labelObrotomierz = new JLabel("Obrotomierz");
		labelObrotomierz.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		labelObrotomierz.setBounds(542, 241, 103, 14);
		getContentPane().add(labelObrotomierz);
		
		labelWiadomosc = new JLabel("");
		labelWiadomosc.setForeground(new Color(204, 0, 0));
		labelWiadomosc.setFont(new Font("Tahoma", Font.ITALIC, 17));
		labelWiadomosc.setBounds(57, 365, 615, 66);
		getContentPane().add(labelWiadomosc);
		
		JLabel lblObecnyBieg = new JLabel("Obecny bieg:");
		lblObecnyBieg.setBounds(275, 216, 74, 14);
		getContentPane().add(lblObecnyBieg);
		
		labelBieg = new JLabel("N");
		labelBieg.setBounds(372, 216, 46, 14);
		getContentPane().add(labelBieg);
		
		labelAlert = new JLabel("");
		labelAlert.setForeground(new Color(204, 0, 0));
		labelAlert.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelAlert.setBounds(10, 11, 303, 65);
		getContentPane().add(labelAlert);
		
		JLabel lblKmh = new JLabel("km/h");
		lblKmh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKmh.setBounds(626, 147, 46, 36);
		getContentPane().add(lblKmh);
		
		JLabel lblRpm = new JLabel("RPM");
		lblRpm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRpm.setBounds(629, 263, 46, 36);
		getContentPane().add(lblRpm);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SymulatorAuta symulator = new SymulatorAuta();
		symulator.setSize(new Dimension(765,460));
		symulator.setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		String wlaczSilnik = "W³¹cz silnik";
		if (e.getKeyCode() == KeyEvent.VK_W)
        {
			if(samochod.getSilnik() == true)
			{
				if(samochod.getBieg() == 0) samochod.setBieg(1);
			labelBieg.setText(String.valueOf(samochod.getBieg()));
            if(samochod.getBieg() == 1) samochod.setPredkosc(samochod.getPredkosc() + 1);
            if(samochod.getBieg() == 2) samochod.setPredkosc(samochod.getPredkosc() + 2);
            if(samochod.getBieg() == 3) samochod.setPredkosc(samochod.getPredkosc() + 2);
            if(samochod.getBieg() == 4) samochod.setPredkosc(samochod.getPredkosc() + 2);
            if(samochod.getBieg() == 5) samochod.setPredkosc(samochod.getPredkosc() + 3);
            samochod.setObroty(samochod.getObroty() + 90);
            labelObroty.setText(String.valueOf(samochod.getObroty()));
            labelPredkosc.setText(String.valueOf(samochod.getPredkosc()));
            if(samochod.getObroty() > 2000) labelWiadomosc.setText("Zmieñ bieg na wy¿szy");
            if(samochod.getObroty() > 2000 && samochod.getBieg() == 5) labelWiadomosc.setText("");
            else if(samochod.getObroty() < 800) labelWiadomosc.setText("Zmieñ bieg na ni¿szy");
            if(samochod.getObroty() > 5000)
            	{
            	labelAlert.setText("Przegrza³eœ silnik!");
            	samochod.setSilnik(false);
            	samochod.setPredkosc(0);
            	samochod.setObroty(0);
            	labelPredkosc.setText(String.valueOf(samochod.getPredkosc()));
            	labelObroty.setText(String.valueOf(samochod.getObroty()));
            	}
            if (samochod.getObroty() < 750)
			{
			samochod.setSilnik(false);
			labelWiadomosc.setText("Silnik zgas³");
			}
			}
			
			else labelWiadomosc.setText(wlaczSilnik);
        }
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			if(samochod.getSilnik() == true && samochod.getPredkosc() >= 1)
			{
				
			labelBieg.setText(String.valueOf(samochod.getBieg()));
            if(samochod.getBieg() == 1) samochod.setPredkosc(samochod.getPredkosc() - 1);
            if(samochod.getBieg() == 2) samochod.setPredkosc(samochod.getPredkosc() - 2);
            if(samochod.getBieg() == 3) samochod.setPredkosc(samochod.getPredkosc() - 2);
            if(samochod.getBieg() == 4) samochod.setPredkosc(samochod.getPredkosc() - 2);
            if(samochod.getBieg() == 5) samochod.setPredkosc(samochod.getPredkosc() - 3);
            samochod.setObroty(samochod.getObroty() - 90);
            labelObroty.setText(String.valueOf(samochod.getObroty()));
            labelPredkosc.setText(String.valueOf(samochod.getPredkosc()));
            if(samochod.getObroty() > 2000) labelWiadomosc.setText("Zmieñ bieg na wy¿szy");
            if(samochod.getObroty() > 2000 && samochod.getBieg() == 5) labelWiadomosc.setText("");
            else if(samochod.getObroty() < 800) labelWiadomosc.setText("Zmieñ bieg na ni¿szy");
            if(samochod.getObroty() > 5000)
            	{
            	labelAlert.setText("Przegrza³eœ silnik!");
            	samochod.setSilnik(false);
            	samochod.setPredkosc(0);
            	samochod.setObroty(0);
            	labelPredkosc.setText(String.valueOf(samochod.getPredkosc()));
            	labelObroty.setText(String.valueOf(samochod.getObroty()));
            	}
			}
			if (samochod.getObroty() < 750)
				{
				samochod.setSilnik(false);
				labelWiadomosc.setText("Silnik zgas³");
				}
			else labelWiadomosc.setText(wlaczSilnik);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
