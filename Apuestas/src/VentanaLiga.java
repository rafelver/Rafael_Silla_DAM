import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaLiga extends JFrame {
    //variables privadas
	private JPanel contentPane;
	private Liga liga;
	private Equipo equipo;
	private JTextField textonombre;
	private JTextField textonumeroe;
	private JTextField textoamodificar;
    //creamos VentanaLiga
	public VentanaLiga(Liga ligaAModificar) {
		//asignamos liga a ligaAModificar
		liga = ligaAModificar;
		setTitle("Ventana Liga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelliga = new JLabel("Nombre De La Liga");
		labelliga.setBounds(25, 23, 107, 14);
		contentPane.add(labelliga);
		
		textonombre = new JTextField();
		textonombre.setBounds(25, 48, 107, 20);
		liga.setnombreLiga(textonombre.getText());
		contentPane.add(textonombre);
		textonombre.setColumns(10);
		
		JLabel labelnumero = new JLabel("Numero De Equipos");
		labelnumero.setBounds(246, 23, 112, 14);
		contentPane.add(labelnumero);
		
		textonumeroe = new JTextField();
		textonumeroe.setEnabled(false);
		textonumeroe.setBounds(235, 48, 123, 20);
		textonumeroe.setText(String.valueOf(liga.getNumEquipos()));
		contentPane.add(textonumeroe);
		textonumeroe.setColumns(10);
		
		JLabel labelequipo = new JLabel("Equipo A Modificar");
		labelequipo.setBounds(25, 111, 107, 14);
		contentPane.add(labelequipo);
		
		textoamodificar = new JTextField();
		textoamodificar.setBounds(25, 133, 107, 20);
		contentPane.add(textoamodificar);
		textoamodificar.setColumns(10);
		//Boton Modificar
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			VentanaEquipo frameEquipo = new VentanaEquipo(liga.getEquipo(Integer.valueOf(textoamodificar.getText())));
			frameEquipo.setVisible(true);
			frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(25, 206, 89, 23);
		contentPane.add(btnNewButton);
	}
}
