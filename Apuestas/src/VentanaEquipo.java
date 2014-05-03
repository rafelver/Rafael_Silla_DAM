
//importacion de las librerias necesarias
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


//ventana equipo que es el JFrame
public class VentanaEquipo extends JFrame {
    //variables privadas
	private JPanel contentPane;
	private Equipo equipo;
	private JTextField textonombre;
	private JTextField textogolesafavor;
	private JTextField textogolesenc;
	private JTextField textopartidosga;
	private JTextField textopartidosper;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	
	//constructor Ventana equipo
	public VentanaEquipo(Equipo equipoAModificar) {
		equipo = equipoAModificar;
		setTitle("Ventana Equipo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelnombre = new JLabel("Nombre del Equipo");
		labelnombre.setBounds(31, 11, 121, 14);
		contentPane.add(labelnombre);
		
		textonombre = new JTextField();
		textonombre.setBounds(180, 8, 191, 20);
		contentPane.add(textonombre);
		textonombre.setColumns(10);
		
		JLabel labelgoles = new JLabel("Goles");
		labelgoles.setBounds(180, 45, 46, 14);
		contentPane.add(labelgoles);
		
		JLabel labelgolesaf = new JLabel("Goles A Favor");
		labelgolesaf.setBounds(66, 58, 95, 14);
		contentPane.add(labelgolesaf);
		
		textogolesafavor = new JTextField();
		textogolesafavor.setBounds(66, 83, 86, 20);
		contentPane.add(textogolesafavor);
		textogolesafavor.setColumns(10);
		
		JLabel labelgolesec = new JLabel("Goles En Contra");
		labelgolesec.setBounds(243, 60, 102, 14);
		contentPane.add(labelgolesec);
		
		textogolesenc = new JTextField();
		textogolesenc.setBounds(243, 83, 86, 20);
		contentPane.add(textogolesenc);
		textogolesenc.setColumns(10);
		
		JLabel labelpartidos = new JLabel("Partidos");
		labelpartidos.setBounds(180, 116, 63, 14);
		contentPane.add(labelpartidos);
		
		JLabel labelpartidosga = new JLabel("Partidos Ganados");
		labelpartidosga.setBounds(66, 149, 109, 14);
		contentPane.add(labelpartidosga);
		
		textopartidosga = new JTextField();
		textopartidosga.setBounds(66, 174, 86, 20);
		contentPane.add(textopartidosga);
		textopartidosga.setColumns(10);
		
		JLabel labelpartidosper = new JLabel("Partidos Perdidos");
		labelpartidosper.setBounds(243, 149, 109, 14);
		contentPane.add(labelpartidosper);
		
		textopartidosper = new JTextField();
		textopartidosper.setBounds(243, 174, 86, 20);
		contentPane.add(textopartidosper);
		textopartidosper.setColumns(10);
		//creamos el boton Guardar
		JButton btnNewButton = new JButton("Guardar A Disco");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				equipo.setNombre(textonombre.getText());
				equipo.setGolesFavor(Integer.valueOf(textogolesafavor.getText()));
				equipo.setGolesContra(Integer.valueOf(textogolesenc.getText()));
				equipo.setPartidosGanados(Integer.valueOf(textopartidosga.getText()));
				equipo.setPartidosPerdidos(Integer.valueOf(textopartidosper.getText()));
				//llamamos al metodo guardar en Fichero
				guardarEnFichero();
			
			}
		});
		
		btnNewButton.setBounds(32, 217, 129, 23);
		contentPane.add(btnNewButton);
		//creamos el boton leer
		JButton btnNewButton_1 = new JButton("Leer A Disco");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//llamamos al metodo recuperar fichero
				recuperarFichero();
				textonombre.setText(equipo.getNombre());
				textogolesafavor.setText(String.valueOf(equipo.getGolesFavor()));
				textogolesenc.setText(String.valueOf(equipo.getGolesContra()));
				textopartidosga.setText(String.valueOf(equipo.getPartidosGanados()));
				textopartidosper.setText(String.valueOf(equipo.getPartidosPerdidos()));
			}
		});
		btnNewButton_1.setBounds(208, 217, 121, 23);
		contentPane.add(btnNewButton_1);
		//creamos el boton guardar
		JButton btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarEquipo();
			}
		});
		btnNewButton_2.setBounds(365, 217, 89, 23);
		contentPane.add(btnNewButton_2);
		
	}
	
	    private void guardarEquipo(){
	    	equipo.setNombre(textonombre.getText());
			equipo.setGolesFavor(Integer.valueOf(textogolesafavor.getText()));
			equipo.setGolesContra(Integer.valueOf(textogolesenc.getText()));
			equipo.setPartidosGanados(Integer.valueOf(textopartidosga.getText()));
			equipo.setPartidosPerdidos(Integer.valueOf(textopartidosper.getText()));
	    }
	    //metodo Guardar En Fichero
		private void guardarEnFichero(){
			try
			{
				salida = new ObjectOutputStream ( new FileOutputStream("equipo.ser"));
				salida.writeObject( equipo );
				if (salida !=null)
					salida.close();
			}
			catch(IOException ioException)
			{
				System.err.println("Error al abrir el archivo");
			}
		}
		
		//metodo Recuperar Fichero
		private void recuperarFichero(){
			try
			{
				entrada = new ObjectInputStream (new FileInputStream("equipo.ser"));
				equipo=(Equipo)entrada.readObject();
					if (entrada !=null)
						entrada.close();
			}
			catch(IOException ioException)
			{
				System.err.println("Error al abrir el archivo");
			}
			catch(ClassNotFoundException clException){
				System.err.println("Error al crear la Clase");
			}
		}
}
