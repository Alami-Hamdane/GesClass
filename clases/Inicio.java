import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;


public class Inicio extends JFrame {

	private JPanel contentPane;

	private JTextField cajaTextoCurso;
	private JTextField cajaTextoNivel;

	private JLabel labelCurso;
	private JLabel labelNivel;
	private JLabel labelLogo;

	private JButton botonBuscar;
	private JButton botonAnadirEstudiante;
	private JButton botonListaEstudiantes;
	private JButton botonAnadirCurso;
	private JButton botonAnadirNivel;
	private JButton botonSalir;

	
	GestorBaseDatos gbd= new GestorBaseDatos();
	int i=0;
	
	public Inicio() {

		contentPane = new JPanel();
		
		labelCurso = new JLabel("Los de estudiantes del curso");
		labelNivel = new JLabel("Los estudiantes del nivel");
		labelLogo = new JLabel("");
		cajaTextoCurso = new JTextField();
		cajaTextoNivel = new JTextField();
		
		
		botonAnadirEstudiante = new JButton("Crear Estudiante");
		botonListaEstudiantes = new JButton("Lista Estudiantes");
		botonAnadirCurso = new JButton("Crear Curso");
		botonAnadirNivel = new JButton("Crear Nivel");
		botonBuscar = new JButton("Buscar");
		botonSalir = new JButton("Salir");
		

		botonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();

		
				
				
			
				
				String contenidoNombreCurso = cajaTextoCurso.getText().toString();
				String contenidoNombreNivel = cajaTextoNivel.getText().toString();
				
			
				ListEstudiantes listEtudiantes = new ListEstudiantes(contenidoNombreCurso,contenidoNombreNivel);
				
				
		
				
				
			}
		});
		
		botonAnadirEstudiante.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();
				CrearEstudiante formularioEstudiante = new CrearEstudiante();
				formularioEstudiante.setVisible(true);
			}
		});
		

		
		botonAnadirCurso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
				dispose();
				new CrearCurso();
			}
		});

		
		
		botonAnadirNivel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				
				dispose();
				new CrearNivel();
			}
		});

		
		botonListaEstudiantes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				dispose();

				new ListaTodoEstudiantes("SELECT * FROM estudiante");
		
				
			}
		});
		
		
		
		
		
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp=JOptionPane.showConfirmDialog(null,"Vas a salir del programa?","CONFIRMACIÓN", JOptionPane.WARNING_MESSAGE);
			      if (JOptionPane.OK_OPTION == resp){
			   
			   System.exit(0);
			 }
			      else{
			    
			    	  new Inicio();	
			   }
			}
		});
		
		
		
		
		
		// Configuración Grafica

		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 140, 1000, 590);
		setResizable(false);

		labelCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelCurso.setBounds(395, 326, 271, 53);
		contentPane.add(labelCurso);

		labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelNivel.setBounds(395, 390, 239, 53);
		contentPane.add(labelNivel);

		cajaTextoCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cajaTextoCurso.setBounds(706, 326, 230, 53);
		contentPane.add(cajaTextoCurso);
		cajaTextoCurso.setColumns(10);

		cajaTextoNivel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cajaTextoNivel.setBounds(706, 392, 230, 53);
		contentPane.add(cajaTextoNivel);


		botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonBuscar.setBounds(777, 466, 159, 55);
		contentPane.add(botonBuscar);

		botonAnadirEstudiante.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAnadirEstudiante.setBounds(46, 48, 298, 74);
		contentPane.add(botonAnadirEstudiante);


		botonListaEstudiantes.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonListaEstudiantes.setBounds(46, 369, 298, 74);
		contentPane.add(botonListaEstudiantes);


		botonAnadirCurso.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAnadirCurso.setBounds(46, 147, 298, 74);
		contentPane.add(botonAnadirCurso);
		
		botonAnadirNivel.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAnadirNivel.setBounds(46, 255, 298, 74);
		contentPane.add(botonAnadirNivel);
		
		
		botonSalir.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonSalir.setBounds(46, 466, 159, 55);
		contentPane.add(botonSalir);
		setVisible(true);

		labelLogo.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo.setBounds(583, 11, 353, 244);
		contentPane.add(labelLogo);
		
		
		
		
		
	}

}
