package br.com.washsystem;

//import java.awt.BorderLayout;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
//import javax.swing.JSeparator;
//import javax.swing.border.LineBorder;
//import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ListIterator;

import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class JCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNome;
	private JTextField textSNome;
	private JTextField textEndereco;
	private JTextField textNumero;
	private JTextField textCEP;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textTelefone;
	private JCheckBox cbxPendencia;
	private final Action novo = new Novo();
	private final Action salvar = new Salvar();
	private final Action anterior = new Anterior();
	private final Action posterior = new Posterior();
	private final Action apagar = new Apagar();
	private final Action alterar = new Alterar();
	private final WindowListener fechar = new Fechar();

	/**
	 * Create the frame.
	 */
	public JCliente() {
		setResizable(false);
		setTitle("Cadastro de Clientes");
		addWindowListener(fechar);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		
		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		
		textSNome = new JTextField();
		textSNome.setEditable(false);
		textSNome.setColumns(10);
		
		textEndereco = new JTextField();
		textEndereco.setEditable(false);
		textEndereco.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setEditable(false);
		textNumero.setColumns(10);
		
		textCEP = new JTextField();
		textCEP.setEditable(false);
		textCEP.setColumns(10);
		
		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setColumns(10);
		
		textTelefone = new JTextField();
		textTelefone.setEditable(false);
		textTelefone.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		
		JLabel lblCep = new JLabel("CEP:");
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		JLabel lblEstado = new JLabel("Estado:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		cbxPendencia = new JCheckBox("");
		cbxPendencia.setEnabled(false);
		cbxPendencia.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblPossuiPendnciaFinanceira = new JLabel("Cliente Possui Pend\u00EAncia Financeira?");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCdigo)
							.addGap(5))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblSobrenome)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(9)
										.addComponent(lblEndereo))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(17)
										.addComponent(lblNmero))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(35)
										.addComponent(lblCep))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(21)
										.addComponent(lblCidade))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(21)
										.addComponent(lblEstado))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(12)
										.addComponent(lblTelefone)))
								.addComponent(lblNome))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPossuiPendnciaFinanceira)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbxPendencia))
						.addComponent(textSNome, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textEndereco, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textNumero, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textCEP, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textCidade, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textEstado, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textTelefone, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNome))
					.addContainerGap(148, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCdigo))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textSNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSobrenome)
							.addGap(12)
							.addComponent(lblEndereo)
							.addGap(12)
							.addComponent(lblNmero)
							.addGap(12)
							.addComponent(lblCep)
							.addGap(12)
							.addComponent(lblCidade)
							.addGap(12)
							.addComponent(lblEstado)
							.addGap(12)
							.addComponent(lblTelefone)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPossuiPendnciaFinanceira)
						.addComponent(cbxPendencia))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setAction(novo);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setAction(anterior);
		
		JButton btnPosterior = new JButton("Posterior");
		btnPosterior.setAction(posterior);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setAction(alterar);
		
		JButton btnSalva = new JButton("Salvar");
		btnSalva.setAction(salvar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setAction(apagar);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAnterior)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPosterior)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAlterar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSalva)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnApagar)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo)
						.addComponent(btnAnterior)
						.addComponent(btnPosterior)
						.addComponent(btnAlterar)
						.addComponent(btnSalva)
						.addComponent(btnApagar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		BancoDeDados.carregaClientes();
		
		setTitle("Cadastro de Clientes - [" + BancoDeDados.clientes.size() + "]");
		
		if(!BancoDeDados.clientes.isEmpty()){
			
			Cliente cliente = BancoDeDados.clientes.getFirst();
			
			textCodigo.setText(String.valueOf(cliente.getCodigo()));
			textNome.setText(cliente.getNome());
			textSNome.setText(cliente.getSobrenome());
			textEndereco.setText(cliente.getEndereco());
			textNumero.setText(String.valueOf(cliente.getNum_endereco()));
			textCEP.setText(cliente.getCep());
			textCidade.setText(cliente.getCidade());
			textEstado.setText(cliente.getEstado());
			textTelefone.setText(cliente.getTelefone());
			
			cbxPendencia.setSelected(cliente.hasPendencia());
			
		}

		
	}
	private class Novo extends AbstractAction {
		public Novo() {
			putValue(NAME, "Novo");
			putValue(SHORT_DESCRIPTION, "Novo Cliente");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.clientes.size() == 0)
				textCodigo.setText("1");
			else
				textCodigo.setText(String.valueOf(BancoDeDados.clientes.getLast().getCodigo() + 1));
			
			textNome.setEditable(true);
			textSNome.setEditable(true);
			textEndereco.setEditable(true);
			textNumero.setEditable(true);
			textCEP.setEditable(true);
			textCidade.setEditable(true);
			textEstado.setEditable(true);
			textTelefone.setEditable(true);
			
			textNome.setText("");
			textSNome.setText("");
			textEndereco.setText("");
			textNumero.setText("");
			textCEP.setText("");
			textCidade.setText("");
			textEstado.setText("");
			textTelefone.setText("");
						
		}
	}
	private class Salvar extends AbstractAction {
		public Salvar() {
			putValue(NAME, "Salvar");
			putValue(SHORT_DESCRIPTION, "Salva Cliente Atual");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(!textCodigo.getText().equals("")){
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Cliente cliente;
			
			ListIterator<Cliente> listIt = (ListIterator<Cliente>)BancoDeDados.clientes.listIterator();
			
			while(listIt.hasNext()){
				cliente = listIt.next();
				if(cliente.getCodigo() == codigo){
					
					try{
						cliente.setCodigo(Integer.parseInt(textCodigo.getText()));
						cliente.setNome(textNome.getText());
						cliente.setSobrenome(textSNome.getText());
						cliente.setEndereco(textEndereco.getText());
						cliente.setNum_endereco(Integer.parseInt(textNumero.getText()));
						cliente.setCep(textCEP.getText());
						cliente.setCidade(textCidade.getText());
						cliente.setEstado(textEstado.getText());
						cliente.setTelefone(textTelefone.getText());
						
					}
					catch(NumberFormatException numFormatE){
						JOptionPane.showMessageDialog(null, "Formato de dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
					setTitle("Cadastro de Clientes - [" + BancoDeDados.clientes.size() + "]");
					
					textNome.setEditable(false);
					textSNome.setEditable(false);
					textEndereco.setEditable(false);
					textNumero.setEditable(false);
					textCEP.setEditable(false);
					textCidade.setEditable(false);
					textEstado.setEditable(false);
					textTelefone.setEditable(false);
					
					return;
				}
			}
			
			try{
				cliente = new Cliente(Integer.parseInt(textCodigo.getText()),
									  textNome.getText(),
									  textSNome.getText(),
									  textEndereco.getText(),
									  Integer.parseInt(textNumero.getText()),										  
									  textCidade.getText(),
									  textEstado.getText(),
									  textCEP.getText(),
									  textTelefone.getText());

			BancoDeDados.clientes.add(cliente);
			
			}
			catch(NumberFormatException numFormatE){
				numFormatE.printStackTrace();
			}
			
			setTitle("Cadastro de Clientes - [" + BancoDeDados.clientes.size() + "]");
			
			textNome.setEditable(false);
			textSNome.setEditable(false);
			textEndereco.setEditable(false);
			textNumero.setEditable(false);
			textCEP.setEditable(false);
			textCidade.setEditable(false);
			textEstado.setEditable(false);
			textTelefone.setEditable(false);
			
		}
		}
	}
	private class Anterior extends AbstractAction {
		public Anterior() {
			putValue(NAME, "Anterior");
			putValue(SHORT_DESCRIPTION, "Cliente Anterior");
		}
		public void actionPerformed(ActionEvent e) {			
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Cliente cliente;
			Cliente previous;
			
			ListIterator<Cliente> listIt = (ListIterator<Cliente>)BancoDeDados.clientes.listIterator();
			
			while(listIt.hasNext()){
				cliente = listIt.next();
				if(cliente.getCodigo() == codigo){
					listIt.previous();
					
					if(listIt.hasPrevious()){
						previous = listIt.previous();
					
						textCodigo.setText(String.valueOf(previous.getCodigo()));
						textNome.setText(previous.getNome());
						textSNome.setText(previous.getSobrenome());
						textEndereco.setText(previous.getEndereco());
						textNumero.setText(String.valueOf(previous.getNum_endereco()));
						textCEP.setText(previous.getCep());
						textCidade.setText(previous.getCidade());
						textEstado.setText(previous.getEstado());
						textTelefone.setText(previous.getTelefone());
						
						cbxPendencia.setSelected(previous.hasPendencia());
						
					}
					break;
				}				
			}						
		}
	}
	private class Posterior extends AbstractAction {
		public Posterior() {
			putValue(NAME, "Posterior");
			putValue(SHORT_DESCRIPTION, "Cliente Posterior");
		}
		public void actionPerformed(ActionEvent e) {
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Cliente cliente;
			Cliente next;
			
			ListIterator<Cliente> listIt = (ListIterator<Cliente>)BancoDeDados.clientes.listIterator();
			
			while(listIt.hasNext()){
				cliente = listIt.next();
				if(cliente.getCodigo() == codigo && listIt.hasNext()){					
					
					next = listIt.next();
					
					textCodigo.setText(String.valueOf(next.getCodigo()));
					textNome.setText(next.getNome());
					textSNome.setText(next.getSobrenome());
					textEndereco.setText(next.getEndereco());
					textNumero.setText(String.valueOf(next.getNum_endereco()));
					textCEP.setText(next.getCep());
					textCidade.setText(next.getCidade());
					textEstado.setText(next.getEstado());
					textTelefone.setText(next.getTelefone());	
					
					cbxPendencia.setSelected(next.hasPendencia());
					
					break;
				}
				
			}
			
		}
	}
	private class Apagar extends AbstractAction {
		public Apagar() {
			putValue(NAME, "Apagar");
			putValue(SHORT_DESCRIPTION, "Apagar Cliente Atual");
		}
		public void actionPerformed(ActionEvent e) {		
			
			if(BancoDeDados.clientes.size() >= 1 ){
			
				int codigo = Integer.parseInt(textCodigo.getText());
				int index = 0;
			
				for(Cliente cliente:BancoDeDados.clientes)
					if(cliente.getCodigo() == codigo){
					
						index = BancoDeDados.clientes.indexOf(cliente);
					
						if(BancoDeDados.clientes.listIterator(index).hasPrevious())
							anterior.actionPerformed(e);
						else if(BancoDeDados.clientes.listIterator(index).hasPrevious())
							posterior.actionPerformed(e);
						else{
						
							textCodigo.setText("");
							textNome.setText("");
							textSNome.setText("");
							textEndereco.setText("");
							textNumero.setText("");
							textCEP.setText("");
							textCidade.setText("");
							textEstado.setText("");
							textTelefone.setText("");
							
							cbxPendencia.setSelected(false);
						
						}
					
						BancoDeDados.clientes.remove(cliente);
						break;
					}
				setTitle("Cadastro de Clientes - [" + BancoDeDados.clientes.size() + "]");
			}
		}
	}
	private class Alterar extends AbstractAction {
		public Alterar() {
			putValue(NAME, "Alterar");
			putValue(SHORT_DESCRIPTION, "Alterar Cliente Atual");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.clientes.size() >= 1 ){
			
				textNome.setEditable(true);
				textSNome.setEditable(true);
				textEndereco.setEditable(true);
				textNumero.setEditable(true);
				textCEP.setEditable(true);
				textCidade.setEditable(true);
				textEstado.setEditable(true);
				textTelefone.setEditable(true);	
			
			}
			
		}
	}
	private class Fechar extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			
			BancoDeDados.gravaClientes();
			
		}
		
	}
}
