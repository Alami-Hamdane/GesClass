import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.testng.annotations.Test;

public class CrearEstudianteTest {
private JPanel contentPane;
	
	private JTextField CajaTexotNumeroDni;
	private JTextField CajaTextApellidos;
	private JTextField cajaTexotNombre;
	private JTextField cajaTextoCurso;
	private JTextField cajaTextoNivelEstudios;
	private JTextField cajaTextoBorrar;
	
	private JButton botonAnadir;
	private JButton botonAtras;
	private JButton botonBorrar;
	private JButton botonListaEstudianes;

	
	private JLabel labelNuevoEstudiante;
	private JLabel labelNumeroDni;
	private JLabel labelApellidos;
	private JLabel labelNombre;
	private JLabel labelCurso;
	private JLabel labelNivelEstudios;
	
	private GestorBaseDatos gbd= new GestorBaseDatos();
	private String contenidoCajaDni="";
	private String contenidoCajaApellido="";
	private String contenidoCajaNombre="";
	private String contenidoCajaCurso="";
	private String contenidoCajaNivel="";
	
	private boolean result=false;
	private JLabel labelLogo_1;

  @Test
  public void CrearEstudianteTest() {

		
		
		contentPane = new JPanel();
		

		labelNuevoEstudiante = new JLabel("Nuevo Estudiante");
		labelNumeroDni = new JLabel("N° Dni");	
		labelApellidos = new JLabel("Apellidos");
		labelNombre = new JLabel("Nombre");
		
		CajaTexotNumeroDni = new JTextField();
		CajaTextApellidos = new JTextField();
		cajaTexotNombre = new JTextField();
		cajaTextoCurso = new JTextField();
		cajaTextoNivelEstudios = new JTextField();
		cajaTextoBorrar = new JTextField();
		
		
		labelCurso = new JLabel("Curso");
		labelNivelEstudios = new JLabel("Nivel de estudios");
		
	    botonAnadir = new JButton("Añadir");
		botonAtras = new JButton("Atras");
		botonBorrar = new JButton("Borrar DNI");
		botonListaEstudianes = new JButton("Lista Estudiantes");
		
		
		botonAnadir.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			  
			        	
			    	
			    	contenidoCajaDni=CajaTexotNumeroDni.getText().toString();
			    	contenidoCajaApellido=CajaTextApellidos.getText().toString();
			    	contenidoCajaNombre=cajaTexotNombre.getText().toString();
			    	contenidoCajaCurso=cajaTextoCurso.getText().toString();
			    	contenidoCajaNivel=cajaTextoNivelEstudios.getText().toString();
					
					result=gbd.crearEstudiante(contenidoCajaDni,contenidoCajaApellido,contenidoCajaNombre,contenidoCajaCurso,contenidoCajaNivel, "estudiante");
					
									
					if (!result)
					{
						JOptionPane.showMessageDialog(null, "Has añadido correctamente el Estudiante : " + contenidoCajaApellido.toUpperCase()+" "+contenidoCajaNombre.toUpperCase());
					
						CajaTexotNumeroDni.setText("");
						CajaTextApellidos.setText("");
						cajaTexotNombre.setText("");
						cajaTextoCurso.setText("");
						cajaTextoNivelEstudios.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No ha sido posible añadir el nuevo estudiante");
					}
					
				
				
				
				
			}
		});
		
		
		botonBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
		
		        
		        
				String contenidoNombreNivel = cajaTextoBorrar.getText().toString();
				
				result =gbd.borrarDni(contenidoNombreNivel,"estudiante");
				
				
				
				
				if (result==true)

				{
					JOptionPane.showMessageDialog(null, "no ha sido posible borrar el estudiante cuyo DNI es  : " + contenidoNombreNivel.toUpperCase());
					
				} 
				
				else
				{
					JOptionPane.showMessageDialog(null, "Has borrado correctamente el estudiante cuyo DNI es : " + contenidoNombreNivel.toUpperCase());

				}
				
				
				cajaTextoBorrar.setText("");
			
				
				
			}
		});
		
		
		
		
		
		
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
	                new Inicio();
			}
		});
		
		
		

		botonListaEstudianes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				new ListaEstudiantes("SELECT * FROM estudiante");
			}
		});
		
		
		
		
		
		
		
		
		
		// Configuración Grafica
		
	
		
		contentPane.setFocusCycleRoot(true);
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelNuevoEstudiante.setFont(new Font("Times New Roman", Font.BOLD, 32));
		labelNuevoEstudiante.setBounds(299, 32, 325, 50);
		contentPane.add(labelNuevoEstudiante);

		labelNumeroDni.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelNumeroDni.setBounds(44, 176, 124, 43);
		contentPane.add(labelNumeroDni);

		labelApellidos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelApellidos.setBounds(44, 233, 135, 29);
		contentPane.add(labelApellidos);
		
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelNombre.setBounds(44, 290, 124, 36);
		contentPane.add(labelNombre);
		
		CajaTexotNumeroDni.setFont(new Font("Tahoma", Font.PLAIN, 32));
		CajaTexotNumeroDni.setBounds(238, 159, 228, 50);
		contentPane.add(CajaTexotNumeroDni);
		CajaTexotNumeroDni.setColumns(10);
		
		CajaTextApellidos.setFont(new Font("Tahoma", Font.PLAIN, 32));
		CajaTextApellidos.setBounds(238, 220, 228, 50);
		contentPane.add(CajaTextApellidos);
		CajaTextApellidos.setColumns(10);
		
		cajaTexotNombre.setFont(new Font("Tahoma", Font.PLAIN, 32));
		cajaTexotNombre.setBounds(238, 281, 228, 50);
		contentPane.add(cajaTexotNombre);
		cajaTexotNombre.setColumns(10);
		
		cajaTextoCurso.setFont(new Font("Tahoma", Font.PLAIN, 32));
		cajaTextoCurso.setBounds(238, 339, 228, 50);
		contentPane.add(cajaTextoCurso);
		cajaTextoCurso.setColumns(10);
		
		cajaTextoNivelEstudios.setFont(new Font("Tahoma", Font.PLAIN, 32));
		cajaTextoNivelEstudios.setBounds(238, 400, 228, 50);
		contentPane.add(cajaTextoNivelEstudios);
		
		labelCurso.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelCurso.setBounds(44, 352, 150, 29);
		contentPane.add(labelCurso);
		
		labelNivelEstudios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelNivelEstudios.setBounds(44, 415, 189, 24);
		contentPane.add(labelNivelEstudios);
		
		
		botonAnadir.setForeground(new Color(0, 0, 0));
		botonAnadir.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAnadir.setBounds(238, 473, 228, 58);
		contentPane.add(botonAnadir);
		
		botonAtras.setForeground(Color.BLACK);
		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAtras.setBounds(832, 477, 142, 50);
		contentPane.add(botonAtras);
		
		labelLogo_1 = new JLabel("");
		labelLogo_1.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo_1.setBounds(674, 11, 300, 183);
		contentPane.add(labelLogo_1);
		
		cajaTextoBorrar.setFont(new Font("Tahoma", Font.PLAIN, 32));
		cajaTextoBorrar.setColumns(10);
		cajaTextoBorrar.setBounds(746, 400, 228, 50);
		contentPane.add(cajaTextoBorrar);
		
		botonBorrar.setForeground(Color.BLACK);
		botonBorrar.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonBorrar.setBounds(489, 400, 228, 50);
		contentPane.add(botonBorrar);
		
		
		botonListaEstudianes.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonListaEstudianes.setBounds(489, 339, 228, 50);
		contentPane.add(botonListaEstudianes);
		
  }
}
