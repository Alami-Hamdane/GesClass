import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListCursos extends JFrame implements ActionListener {

	  private JLabel label1;
	  private JPanel panel1,panel2,panel3;
	  private JTable table;
	  private Vector<String> columnas;
	  private Vector <String> tuple;
	  private Vector <Vector>  lineas;
	  ResultSet rs = null;
	  private JButton botonAtras;

	  
	  public ListCursos(String curso ){
	  
			setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
	  
			
			 ArrayList<Curso> cursos = new ArrayList<>();
	  
			 try {

			        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionestudiantes", "root", "");

			        String query = "SELECT * FROM curso";

			        Statement sta = connection.createStatement();
			        rs = sta.executeQuery(query);

			        
			        
			        while (rs.next()){
			            Curso c = new Curso();
			            c.setNombreCurso(rs.getString("nombreCurso"));
			                  
			          
			       
			                cursos.add(c);
			        

			        }


			    } catch (Exception exception) {
			        exception.printStackTrace();
			    }
			 
			    label1=new JLabel("Lista de cursos disponibles" );
			    panel1=new JPanel();
			    panel2=new JPanel();
			  
			    columnas = new Vector<String>();
			    columnas.add("Nombre del curso");
			 
			    
			    lineas = new Vector <Vector>();
			    
			    for (int i=0;i<cursos.size();i++){
			        
			    	tuple = new Vector<String>();
			    	
			        Curso cur = cursos.get(i);
			        
			        tuple.add(cur.getNombreCurso());
			        lineas.add(tuple);
			    }
			    
			    
			    SpringLayout sl_panel2 = new SpringLayout();
			    
			    
			    table = new JTable(lineas,columnas);
			    table.setRowHeight(40);
			    JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			    panel3=new JPanel();
			   
			    botonAtras = new JButton("Atras");
			    botonAtras.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    		
			    		 dispose();
			             new CrearCurso();
			    	}
			    });
			    setVisible(true);



			  
			    
			    
			    // Configuración Grafica 
			    
			    label1.setFont(new Font("Tahoma", Font.BOLD, 13));
			    
			    panel1.setBackground(new Color(176, 196, 222));
			    panel1.add(label1);
			    
			    panel2.setBackground(new Color(176, 196, 222));
			    panel2.setBorder(new LineBorder(new Color(255, 255, 255), 0));
			    
			    
			    panel2.setLayout(sl_panel2);
			    
			    
			    sl_panel2.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.NORTH, panel2);
			    sl_panel2.putConstraint(SpringLayout.WEST, scrollPane, 33, SpringLayout.WEST, panel2);
			    sl_panel2.putConstraint(SpringLayout.SOUTH, scrollPane, 480, SpringLayout.NORTH, panel2);
			    sl_panel2.putConstraint(SpringLayout.EAST, scrollPane, -27, SpringLayout.EAST,panel2);
			    scrollPane.setBorder(new LineBorder(UIManager.getColor("Tabla.highlight")));
			    panel2.add(scrollPane);
			    
			    
			    panel3.setBackground(new Color(176, 196, 222));
			    
			    
			    getContentPane().add(panel1,BorderLayout.NORTH);
			    getContentPane().add(panel2,BorderLayout.CENTER);
			    getContentPane().add(panel3,BorderLayout.SOUTH);
			    
			    
			    panel3.add(botonAtras);

			    setBounds(150, 140, 1000, 590);
			    setResizable(false);
			    setTitle("Lista De Cursos");
			    
			    
			    
			}

			@Override
			public void actionPerformed(ActionEvent e)
			{

			}
			}
