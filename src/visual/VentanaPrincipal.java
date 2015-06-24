package visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import auxiliar.Auxiliar;
import beans.Proyecto;

import trataJSON.UsuarioJSON;

import visual.VentanaUsuario;


public class VentanaPrincipal extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	public  JButton btnNuevoEjercicio, btnNuevoUsuario, btnBuscaUsuario, btnNuevaRutina;
	public  JButton btnBorraTablas;
	private JTextField txtUsuario;
	private JTable tbUsuarios = new JTable(Auxiliar.modelo);
	private UsuarioJSON uJSON = new UsuarioJSON();

	//private DefaultListModel<String> modelo = new DefaultListModel<String>();
	//private JList<String> txtAreaUsuario = new JList<String>(Auxiliar.modelo);
		
	public VentanaPrincipal() 
	{ 		
		//final VentanaPrincipal v = this;
        setTitle("CLUB FITNESS CARCAIXENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1, 1, 800, 600);   

     // Panel principal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);
     
     // Botón para nuevo usuario
        btnNuevoUsuario = new JButton("Nuevo Usuario");                
        btnNuevoUsuario.setBounds(10, 10, 150, 20);
        btnNuevoUsuario.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	VentanaUsuario nuevoUsuario = new VentanaUsuario();
        		nuevoUsuario.setVisible(true);        		
            }
        });        
        contentPane.add(btnNuevoUsuario);
        
     // Cuadro de busqueda de usuarios
        txtUsuario = new JTextField();                
        txtUsuario.setBounds(200, 10, 250, 20);
        contentPane.add(txtUsuario);
        
        btnBuscaUsuario = new JButton("Buscar Usuario");                
        btnBuscaUsuario.setBounds(460, 10, 175, 20);
        btnBuscaUsuario.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {ListIterator<Proyecto> iter = Auxiliar.lUsuarios.listIterator();
            
            while (iter.hasNext())
            {        	        	
            	Proyecto usuario = (Proyecto) iter.next();
            	String s = usuario.getNombre();
            	if(s.equals(txtUsuario.getText())){
            		
            		txtAreaUsuario.setSelectedIndex(iter.previousIndex());
            	}
            		
            }
                            
                                             
            	//VentanaUsuario nuevoUsuario = new VentanaUsuario();
        		//nuevoUsuario.setVisible(true);        		
            }
        });      
        contentPane.add(btnBuscaUsuario);
        
     // Botón para nuevo ejercicio
        btnNuevoEjercicio = new JButton("Nuevo Ejercicio");                
        btnNuevoEjercicio.setBounds(10, 35, 150, 20);
        btnNuevoEjercicio.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {            	
            	VentanaEjercicio nuevoEjercicio = new VentanaEjercicio();
        		nuevoEjercicio.setVisible(true);        		
            }
        });
        contentPane.add(btnNuevoEjercicio);
        
     // Botón para nueva rutina
        btnNuevaRutina = new JButton("Nueva Rutina");                
        btnNuevaRutina.setBounds(10, 60, 150, 20);
        btnNuevaRutina.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	//VentanaRutina nuevaRutina = new VentanaRutina();
        		//nuevaRutina.setVisible(true);        		
            }
        });
        contentPane.add(btnNuevaRutina);
        
     // Listado de usuarios        
        
        Auxiliar.lUsuarios = uJSON.consultaUsuariosJSON();                       
        
        Collections.sort(Auxiliar.lUsuarios, new Comparator<Proyecto>(){
			public int compare(Proyecto u1, Proyecto u2) {
				// TODO Auto-generated method stub
				
				return u1.getNombre().compareTo(u2.getNombre());
			}
        });
        ListIterator<Proyecto> iter = Auxiliar.lUsuarios.listIterator();
        
        while (iter.hasNext())
        {        	        	
        	Proyecto usuario = (Proyecto) iter.next();
        	//Auxiliar.modelo.addElement(usuario.getNombre() + " " + usuario.getApe1() + " " + usuario.getApe2());
        	Auxiliar.modelo.setValueAt(usuario.getNombre() + " " + usuario.getApe1() + " " + usuario.getApe2(), iter.nextIndex(), 1);
        }
                   
        //Auxiliar.modelo.addElement("+...");
        
        
                	
        //txtAreaUsuario.setModel(modelo);        
        /*
        JScrollPane scroll = new JScrollPane(txtAreaUsuario, 
        		    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        		    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(200, 35, 575, 500);
        contentPane.add(scroll, BorderLayout.CENTER);
        */
        
        tbUsuarios = new JTable(Auxiliar.modelo);
    	JScrollPane scrollpane = new JScrollPane(tbUsuarios);
    	contentPane.add(scrollpane);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
	}
}