package mx.test.wdt;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
 * Window
 * @author anver
 *
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JButton btnCheck = null;

	private Manejador manejador;
	private JTextField txtChair;
	private JTextField txtResult;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JScrollPane jScrollPane;
	private JTextArea txtList;
	/**
	 * This is the default constructor
	 */
	public Ventana(Manejador manejador) {
		super();

		initialize();

		this.manejador = manejador;

		actualiza();

	}

	private void actualiza() {
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(406, 319);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				manejador.finaliza();
			}
		});
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnCheck(), null);
			txtChair = new JTextField();
			txtChair.setBounds(12, 15, 279, 24);
			jContentPane.add(txtChair);
			txtChair.setColumns(10);

			txtResult = new JTextField();
			txtResult.setEditable(false);
			txtResult.setBounds(12, 54, 374, 27);
			jContentPane.add(txtResult);
			txtResult.setColumns(10);
			
			JLabel lblDe = new JLabel("Desde:");
			lblDe.setBounds(12, 113, 42, 17);
			jContentPane.add(lblDe);
			
			txtStart = new JTextField();
			txtStart.setBounds(59, 111, 54, 24);
			jContentPane.add(txtStart);
			txtStart.setColumns(10);
			
			JLabel lblA = new JLabel("Hasta:");
			lblA.setBounds(125, 111, 42, 17);
			jContentPane.add(lblA);
			
			txtEnd = new JTextField();
			txtEnd.setColumns(10);
			txtEnd.setBounds(171, 109, 54, 26);
			jContentPane.add(txtEnd);
			
			JButton btnGetPrimeNumbers = new JButton("Obtener primos");
			btnGetPrimeNumbers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtStart.getText().equals("") || txtEnd.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Debes de ingresar los parametros", "Campo vacio", JOptionPane.WARNING_MESSAGE);
					else {
						ArrayList<Integer> listPrimeNumbers = manejador.getPrimeNumbers(txtStart.getText(), txtEnd.getText());
						for (Integer integer : listPrimeNumbers) {
							System.out.println(integer + "\n");
						}
						for (Integer integer : listPrimeNumbers) {
							txtList.append(integer + "\n");
						}
					}
					
				}
			});
			
			btnGetPrimeNumbers.setBounds(257, 108, 129, 27);
			jContentPane.add(btnGetPrimeNumbers);
			
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(15, 16, 361, 178));
			jScrollPane.setBounds(12, 142, 374, 133);
			jContentPane.add(jScrollPane);
			
			txtList = new JTextArea();
			jScrollPane.setViewportView(txtList);
			
			
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonAgregar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnCheck() {
		if (btnCheck == null) {
			btnCheck = new JButton();
			btnCheck.setBounds(new Rectangle(303, 12, 83, 27));
			btnCheck.setText("Validar");
			btnCheck.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println(manejador.hasUniqueChair(txtChair.getText()));
					if (manejador.hasUniqueChair(txtChair.getText()))
						txtResult.setText("La cadena es unica");
					else
						txtResult.setText("La cadena no es unica");

				}
			});
		}
		return btnCheck;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
