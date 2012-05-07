package br.com.washsystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
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
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JTextPane;

public class Principal {

	private JFrame frmWashsystemServios;
	private final Action actionJClientes = new actionJClientes();
	private final Action actionJRoupas = new actionJRoupas();
	private final Action actionJServicos = new actionJServicos();
	//private final Action actionJPrecos = new actionJPrecos();
	private JTextField textCodigo;
	private JTextField textCodServico;
	private JTextField textDescServico;
	private JTextField textCodRoupa;
	private JTextField textDescRoupa;
	private JTextField textDescTecido;
	private JTextField textCodCliente;
	private JTextField textDescCliente;
	private final Action novo = new Novo();
	private final Action incluir = new Incluir();
	private final Action limpa = new Limpa();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmWashsystemServios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWashsystemServios = new JFrame();
		frmWashsystemServios.setResizable(false);
		frmWashsystemServios.setTitle("WashSystem - Servi\u00E7os de Lavagem");
		frmWashsystemServios.setBounds(100, 100, 728, 529);
		frmWashsystemServios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmWashsystemServios.setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.setAction(actionJClientes);

		mnCadastros.add(mntmNewMenuItem_1);
		
		JMenuItem mntmRoupas = new JMenuItem("Tipos de Roupa");
		mntmRoupas.setAction(actionJRoupas);
		mnCadastros.add(mntmRoupas);
		
		JMenuItem mntmServios = new JMenuItem("Servi\u00E7os");
		mntmServios.setAction(actionJServicos);
		mnCadastros.add(mntmServios);
		
		//JMenuItem mntmTabelaDePreos = new JMenuItem("Tabela de Pre\u00E7os");
		//mntmTabelaDePreos.setAction(actionJPrecos);
		//mnCadastros.add(mntmTabelaDePreos);
		
		JPanel panelCadServico = new JPanel();
		panelCadServico.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout groupLayout = new GroupLayout(frmWashsystemServios.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCadServico, GroupLayout.PREFERRED_SIZE, 704, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCadServico, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblOrdemDeServio = new JLabel("Ordem de Servi\u00E7o:");
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		
		textCodServico = new JTextField();
		textCodServico.setEditable(false);
		textCodServico.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				Servico servico = null;
				for(Servico obj:BancoDeDados.servicos)
					if(obj.getCodigo() == Integer.parseInt(textCodServico.getText())){
						servico = obj;
						break;
					}
				if(servico != null)
					textDescServico.setText(servico.getDescricao());
				else
					textDescServico.setText("");
			}
		});
		textCodServico.setColumns(10);
		
		textDescServico = new JTextField();
		textDescServico.setEditable(false);
		textDescServico.setColumns(10);
		
		JLabel lblTipoDeServio = new JLabel("Tipo de Servi\u00E7o:");
		
		JLabel lblTipoDeRoupa = new JLabel("Tipo de Roupa:");
		
		textCodRoupa = new JTextField();
		textCodRoupa.setEditable(false);
		textCodRoupa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Roupa roupa = null;
				for(Roupa obj:BancoDeDados.roupas)
					if(obj.getCodigo() == Integer.parseInt(textCodRoupa.getText())){
						roupa = obj;
						break;
					}
				if(roupa != null){
					textDescRoupa.setText(roupa.getTipo());
					textDescTecido.setText(roupa.getTecido());
				}
				else{
					textDescRoupa.setText("");
					textDescTecido.setText("");
				}
			}
		});
		textCodRoupa.setColumns(10);
		
		textDescRoupa = new JTextField();
		textDescRoupa.setEditable(false);
		textDescRoupa.setColumns(10);
		
		textDescTecido = new JTextField();
		textDescTecido.setEditable(false);
		textDescTecido.setColumns(10);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		
		textCodCliente = new JTextField();
		textCodCliente.setEditable(false);
		textCodCliente.setColumns(10);
		
		textDescCliente = new JTextField();
		textDescCliente.setEditable(false);
		textDescCliente.setColumns(10);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setAction(novo);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setAction(incluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setAction(limpa);
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panelCadServico = new GroupLayout(panelCadServico);
		gl_panelCadServico.setHorizontalGroup(
			gl_panelCadServico.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadServico.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadServico.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeDoCliente, Alignment.TRAILING)
								.addComponent(lblOrdemDeServio, Alignment.TRAILING)
								.addComponent(lblTipoDeServio, Alignment.TRAILING)
								.addComponent(lblTipoDeRoupa, Alignment.TRAILING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCadServico.createSequentialGroup()
									.addComponent(btnIncluir)
									.addGap(18)
									.addComponent(btnLimpar))
								.addGroup(gl_panelCadServico.createSequentialGroup()
									.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
										.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCodCliente, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCodServico, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCodRoupa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
										.addComponent(textDescCliente, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDescServico, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDescRoupa, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textDescTecido, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelCadServico.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNovo)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelCadServico.setVerticalGroup(
			gl_panelCadServico.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadServico.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOrdemDeServio)
						.addGroup(gl_panelCadServico.createSequentialGroup()
							.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
								.addComponent(textDescCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCodCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeDoCliente))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
									.addComponent(textCodServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTipoDeServio))
								.addComponent(textDescServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCodRoupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDescRoupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDescTecido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipoDeRoupa))))
					.addGap(29)
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpar)
						.addComponent(btnNovo)
						.addComponent(btnIncluir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(243))
		);
		//panelCadServico.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textCodRoupa, textCodServico}));
		panelCadServico.setLayout(gl_panelCadServico);
		frmWashsystemServios.getContentPane().setLayout(groupLayout);
	}

	private class actionJClientes extends AbstractAction {
		public actionJClientes() {
			putValue(NAME, "Clientes");
			putValue(SHORT_DESCRIPTION, "Cadastro de Clientes");
		}
		public void actionPerformed(ActionEvent e) {
			JCliente jcliente = new JCliente();
			jcliente.setVisible(true);
		}
	}
	private class actionJRoupas extends AbstractAction {
		public actionJRoupas() {
			putValue(NAME, "Tipos de Roupa");
			putValue(SHORT_DESCRIPTION, "Cadastro de Tipos de Roupa");
		}
		public void actionPerformed(ActionEvent e) {
			
			JRoupa jroupa = new JRoupa();
			jroupa.setVisible(true);
			
		}
	}
	private class actionJServicos extends AbstractAction {
		public actionJServicos() {
			putValue(NAME, "Serviços");
			putValue(SHORT_DESCRIPTION, "Cadastro de Tipos de Serviço");
		}
		public void actionPerformed(ActionEvent e) {
			
			JServico jservico = new JServico();
			jservico.setVisible(true);
			
		}
	}
	private class actionJPrecos extends AbstractAction {
		public actionJPrecos() {
			putValue(NAME, "Tabela de Preços");
			putValue(SHORT_DESCRIPTION, "Cadastro da Tabela de Preços");
		}
		public void actionPerformed(ActionEvent e) {
			
			JPreco jpreco = new JPreco();
			jpreco.setVisible(true);
			
		}
	}
	
	private class Novo extends AbstractAction {
		public Novo() {
			putValue(NAME, "Novo");
			putValue(SHORT_DESCRIPTION, "Novo Registro");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.ordemservico.size() == 0)
				textCodigo.setText("1");
			else
				textCodigo.setText(String.valueOf(BancoDeDados.ordemservico.getLast().getCodigo() + 1));
				
			textCodServico.setEditable(true);
			textCodRoupa.setEditable(true);
			textCodCliente.setEditable(true);
						
			textCodServico.setText("");
			textDescServico.setText("");
			textCodRoupa.setText("");
			textDescRoupa.setText("");
			textDescTecido.setText("");
			textCodCliente.setText("");
						
		}
	}
	
	private class Limpa extends AbstractAction{
		public Limpa(){
			putValue(NAME, "Limpa");
			putValue(SHORT_DESCRIPTION, "Limpa os campos");
		}
		public void actionPerformed(ActionEvent e){
			
			textCodServico.setText("");
			textDescServico.setText("");
			textCodRoupa.setText("");
			textDescRoupa.setText("");
			textDescTecido.setText("");
			textCodCliente.setText("");
			textDescCliente.setText("");
			
		}
	}

	private class Incluir extends AbstractAction {
		public Incluir() {
			putValue(NAME, "Incluir");
			putValue(SHORT_DESCRIPTION, "Incluir Ordem de Servico");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(!textCodigo.getText().equals("")){
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Cliente cliente = null;
			Servico servico = null;
			Roupa roupa = null;
			OrdemServico ordemservico = null;
						
			ListIterator<OrdemServico> listIt = (ListIterator<OrdemServico>)BancoDeDados.ordemservico.listIterator();
			
			while(listIt.hasNext()){
				ordemservico = listIt.next();
				if(ordemservico.getCodigo() == codigo){					
					
					for (Cliente obj:BancoDeDados.clientes)
						if(obj.getCodigo() == Integer.parseInt(textCodCliente.getText())){
							cliente = obj;
							break;
						}
					
					for(Servico obj:BancoDeDados.servicos)
						if(obj.getCodigo() == Integer.parseInt(textCodServico.getText())){
							servico = obj;
							break;
						}					
					
					for(Roupa obj:BancoDeDados.roupas)
						if(obj.getCodigo() == Integer.parseInt(textCodRoupa.getText())){
							roupa = obj;
							break;
						}
					
					try{
						ordemservico.setCliente(cliente);
						ordemservico.setServico(servico);
						ordemservico.setRoupa(roupa);
					}
					catch(NumberFormatException numFormatE){
						JOptionPane.showMessageDialog(null, "Formato de dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
						
					}
					
					textCodServico.setEditable(false);
					textCodRoupa.setEditable(false);
					textCodCliente.setEditable(false);
					
					return;
				}
			}			
			
			for (Cliente obj:BancoDeDados.clientes)
				if(obj.getCodigo() == Integer.parseInt(textCodCliente.getText())){
					cliente = obj;
				}
			
			for(Servico obj:BancoDeDados.servicos)
				if(obj.getCodigo() == Integer.parseInt(textCodigo.getText())){
					servico = obj;
				}			
			
			for(Roupa obj:BancoDeDados.roupas)
				if(obj.getCodigo() == Integer.parseInt(textCodRoupa.getText())){
					roupa = obj;
				}
			
			try{
				ordemservico = new OrdemServico(Integer.parseInt(textCodigo.getText()),
								  cliente,
								  servico,
								  roupa);
								  

			BancoDeDados.ordemservico.add(ordemservico);
			
			}
			catch(NumberFormatException numFormatE){
				numFormatE.printStackTrace();
			}
			
			textCodCliente.setEditable(false);
			textCodServico.setEditable(false);
			textCodRoupa.setEditable(false);
						
		}
		}
	}
}
