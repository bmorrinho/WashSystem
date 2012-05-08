package br.com.washsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTable;

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
	private JTextField textSeq;
	private final WindowListener fechar = new Fechar();
	private JTable tOrdens;
	private DefaultTableModel aModel = new DefaultTableModel();
	private Object[] tableColumnNames = new Object[5];
	private final Action novo = new Novo();
	private final Action incluir = new Incluir();
	private final Action limpa = new Limpa();
	private final Action salvar = new Salvar();
	private final Action anterior = new Anterior();
	private final Action posterior = new Posterior();
	private final Action apagar = new Apagar();
	
	
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
		frmWashsystemServios.addWindowListener(fechar);
		
		JScrollPane scroll = new JScrollPane(tOrdens);  
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		frmWashsystemServios.getContentPane().add(scroll);

		
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
		textCodCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				Cliente cliente = null;
				for(Cliente obj:BancoDeDados.clientes)
					if(obj.getCodigo() == Integer.parseInt(textCodCliente.getText())){
						cliente = obj;
						break;
					}
				if(cliente != null){
					textDescCliente.setText(cliente.getNome());
				}
				else{
					textDescCliente.setText("");
				}
				
			}
		});
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
		
		JLabel lblNewLabel = new JLabel("Sequ\u00EAncia:");
		
		textSeq = new JTextField();
		textSeq.setEditable(false);
		textSeq.setColumns(10);
		
		tOrdens = new JTable();
		tOrdens.setEnabled(false);
		tOrdens.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnPrximo = new JButton("Pr\u00F3ximo");
		btnPrximo.setAction(posterior);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setAction(anterior);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setAction(salvar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setAction(apagar);
		
		JLabel lblSeqNo = new JLabel("Seq. No.");
		
		JLabel lblServio = new JLabel("Servi\u00E7o");
		
		JLabel lblTipoRoupa = new JLabel("Tipo Roupa");
		
		JLabel lblTipoTecido = new JLabel("Tipo Tecido");
		
		JLabel lblValorR = new JLabel("Valor R$");
		
		GroupLayout gl_panelCadServico = new GroupLayout(panelCadServico);
		gl_panelCadServico.setHorizontalGroup(
			gl_panelCadServico.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCadServico.createSequentialGroup()
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCadServico.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.TRAILING)
								.addComponent(tOrdens, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
								.addGroup(gl_panelCadServico.createSequentialGroup()
									.addGap(29)
									.addComponent(lblSeqNo)
									.addGap(47)
									.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNovo)
										.addGroup(Alignment.TRAILING, gl_panelCadServico.createSequentialGroup()
											.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelCadServico.createSequentialGroup()
													.addGap(76)
													.addComponent(btnIncluir))
												.addGroup(gl_panelCadServico.createSequentialGroup()
													.addGap(41)
													.addComponent(lblServio)))
											.addGap(18)
											.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelCadServico.createSequentialGroup()
													.addComponent(btnLimpar)
													.addGap(18)
													.addComponent(btnAnterior)
													.addGap(18))
												.addGroup(gl_panelCadServico.createSequentialGroup()
													.addGap(26)
													.addComponent(lblTipoRoupa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)))))
									.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelCadServico.createSequentialGroup()
											.addComponent(btnPrximo)
											.addGap(18))
										.addGroup(gl_panelCadServico.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblTipoTecido, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_panelCadServico.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panelCadServico.createSequentialGroup()
											.addComponent(btnSalvar)
											.addGap(18)
											.addComponent(btnApagar))
										.addGroup(gl_panelCadServico.createSequentialGroup()
											.addComponent(lblValorR)
											.addGap(44))))))
						.addGroup(gl_panelCadServico.createSequentialGroup()
							.addGap(62)
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNomeDoCliente)
								.addComponent(lblTipoDeServio)
								.addComponent(lblTipoDeRoupa)
								.addComponent(lblOrdemDeServio))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
								.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(textSeq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCadServico.createSequentialGroup()
									.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
										.addComponent(textCodCliente, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCodServico, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addComponent(textCodRoupa, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addGap(3)
									.addGroup(gl_panelCadServico.createParallelGroup(Alignment.LEADING)
										.addComponent(textDescCliente, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDescServico, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
										.addComponent(textDescRoupa, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textDescTecido, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addGap(215)))
					.addContainerGap())
		);
		gl_panelCadServico.setVerticalGroup(
			gl_panelCadServico.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadServico.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrdemDeServio))
					.addGap(24)
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
						.addComponent(textSeq, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
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
						.addComponent(lblTipoDeRoupa))
					.addGap(29)
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpar)
						.addComponent(btnNovo)
						.addComponent(btnIncluir)
						.addComponent(btnSalvar)
						.addComponent(btnApagar)
						.addComponent(btnAnterior)
						.addComponent(btnPrximo))
					.addGap(10)
					.addGroup(gl_panelCadServico.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorR)
						.addComponent(lblTipoTecido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTipoRoupa)
						.addComponent(lblServio)
						.addComponent(lblSeqNo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tOrdens, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
					.addContainerGap())
		);
		//panelCadServico.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textCodRoupa, textCodServico}));
		panelCadServico.setLayout(gl_panelCadServico);
		frmWashsystemServios.getContentPane().setLayout(groupLayout);
		
		 //setting the column name
		
			tableColumnNames[0] = "Sequência";
			tableColumnNames[1] = "Serviço";
			tableColumnNames[2] = "Tipo Roupa";
			tableColumnNames[3] = "Tecido";
			tableColumnNames[4] = "Preço";
			
			//binding the jtable to the model
			this.tOrdens.setModel(aModel);
		
		BancoDeDados.carregaServicos();
		BancoDeDados.carregaRoupas();
		BancoDeDados.carregaClientes();
		BancoDeDados.carregaOrdemServico();
		
		if(!BancoDeDados.ordemservico.isEmpty()){
			
			OrdemServico ordemservico = BancoDeDados.ordemservico.getFirst();
			
			textCodigo.setText(String.valueOf(ordemservico.getCodigo()));
			textSeq.setText(String.valueOf(ordemservico.getSequencia()));
			textCodCliente.setText(String.valueOf(ordemservico.getCliente().getCodigo()));
			textDescCliente.setText(String.valueOf(ordemservico.getCliente().getNome()));
			textCodServico.setText(String.valueOf(ordemservico.getServico().getCodigo()));
			textDescServico.setText(ordemservico.getServico().getDescricao());
			textCodRoupa.setText(String.valueOf(ordemservico.getRoupa().getCodigo()));
			textDescRoupa.setText(ordemservico.getRoupa().getTipo());
			textDescTecido.setText(ordemservico.getRoupa().getTecido());
			
		}	
		
		atualizaTable();
		
	}
	
	private void atualizaTable(){
		

		aModel.setColumnIdentifiers(tableColumnNames);
		if (BancoDeDados.servicos == null) {
			this.tOrdens.setModel(aModel);
			return;
		}
		
		tOrdens.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		
		aModel.setRowCount(0);
		Object[] objects = new Object[5];
		ListIterator<OrdemServico> ordemservico = BancoDeDados.ordemservico.listIterator();
		//populating the tablemodel
		while (ordemservico.hasNext()) {
			OrdemServico ordem = ordemservico.next();
			
			if(ordem.getCodigo() == Integer.parseInt(textCodigo.getText())){
			
			objects[0] = ordem.getSequencia();
			objects[1] = ordem.getServico().getDescricao();
			objects[2] = ordem.getRoupa().getTipo();
			objects[3] = ordem.getRoupa().getTecido();
			objects[4] = ordem.getServico().getPreco();
			
	
			}
			aModel.addRow(objects);
		}	
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
			
			textSeq.setText("10");			
				
			textCodServico.setEditable(true);
			textCodRoupa.setEditable(true);
			textCodCliente.setEditable(true);			
						
			textDescCliente.setText("");
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
			
			if(BancoDeDados.ordemservico.size() == 0)
				//textCodigo.setText("1");
				return;
			else{
				textSeq.setText(String.valueOf(Integer.valueOf(textSeq.getText())+10));
			}
//			textSeq.setText("10");			
				
//			textCodCliente.setEditable(true);
			textCodServico.setEditable(true);
			textCodRoupa.setEditable(true);
												
//			textCodCliente.setText("");
//			textDescCliente.setText("");
			textCodServico.setText("");
			textDescServico.setText("");
			textCodRoupa.setText("");
			textDescRoupa.setText("");
			textDescTecido.setText("");
						
		}
	}
	
	private class Fechar extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			
			BancoDeDados.gravaOrdemServico();
			
		}
		
	}
	
	private class Salvar extends AbstractAction {
		public Salvar() {
			putValue(NAME, "Salvar");
			putValue(SHORT_DESCRIPTION, "Salvar");
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
							ordemservico.setCodigo(Integer.parseInt(textCodigo.getText()));
							ordemservico.setSequencia(Integer.parseInt(textSeq.getText()));
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
							          Integer.parseInt(textSeq.getText()),
									  cliente,
									  servico,
									  roupa);
									  

				BancoDeDados.ordemservico.add(ordemservico);
				
				atualizaTable();
				
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
	private class Anterior extends AbstractAction {
	public Anterior() {
			putValue(NAME, "Anterior");
			putValue(SHORT_DESCRIPTION, "Ordem de Servico Anterior");
		}
		public void actionPerformed(ActionEvent e) {	
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			OrdemServico cliente;
			OrdemServico previous;
			
			ListIterator<OrdemServico> listIt = (ListIterator<OrdemServico>)BancoDeDados.ordemservico.listIterator();
			
			while(listIt.hasNext()){
				cliente = listIt.next();
				if(cliente.getCodigo() == codigo){
					listIt.previous();
					
					if(listIt.hasPrevious()){
						previous = listIt.previous();

						textCodigo.setText(String.valueOf(previous.getCodigo()));
						textSeq.setText(String.valueOf(previous.getSequencia()));
						textCodCliente.setText(String.valueOf(previous.getCliente().getCodigo()));
						textDescCliente.setText(previous.getCliente().getNome());
						textCodServico.setText(String.valueOf(previous.getServico().getCodigo()));
						textDescServico.setText(previous.getServico().getDescricao());
						textCodRoupa.setText(String.valueOf(previous.getRoupa().getCodigo()));
						textDescRoupa.setText(previous.getRoupa().getTipo());
						textDescTecido.setText(previous.getRoupa().getTecido());
											
					}
					break;
				}				
			}	
			atualizaTable();				
		}
					
	}
	
	private class Posterior extends AbstractAction {
		public Posterior() {
				putValue(NAME, "Posterior");
				putValue(SHORT_DESCRIPTION, "Ordem de Servico Posterior");
			}
			public void actionPerformed(ActionEvent e) {	
				
				Integer codigo = Integer.parseInt(textCodigo.getText());
				
				OrdemServico cliente;
				OrdemServico next;
				
				ListIterator<OrdemServico> listIt = (ListIterator<OrdemServico>)BancoDeDados.ordemservico.listIterator();
				
				while(listIt.hasNext()){
					cliente = listIt.next();
					if(cliente.getCodigo() == codigo){
						listIt.next();
												
						if(listIt.hasPrevious()){
							next = listIt.previous();

							textCodigo.setText(String.valueOf(next.getCodigo()));
							textSeq.setText(String.valueOf(next.getSequencia()));
							textCodCliente.setText(String.valueOf(next.getCliente().getCodigo()));
							textDescCliente.setText(next.getCliente().getNome());
							textCodServico.setText(String.valueOf(next.getServico().getCodigo()));
							textDescServico.setText(next.getServico().getDescricao());
							textCodRoupa.setText(String.valueOf(next.getRoupa().getCodigo()));
							textDescRoupa.setText(next.getRoupa().getTipo());
							textDescTecido.setText(next.getRoupa().getTecido());
												
						}
						break;
					}				
				}	
				atualizaTable();				
			}
							
		}
	
	private class Apagar extends AbstractAction {
		public Apagar() {
			putValue(NAME, "Apagar");
			putValue(SHORT_DESCRIPTION, "Apagar Ordem de Serviço Atual");
		}
		public void actionPerformed(ActionEvent e) {		
			
			if(BancoDeDados.ordemservico.size() >= 1 ){
			
				int codigo = Integer.parseInt(textCodigo.getText());
				int index = 0;
			
				for(OrdemServico ordem:BancoDeDados.ordemservico)
					if(ordem.getCodigo() == codigo){
					
						index = BancoDeDados.ordemservico.indexOf(ordem);
					
						if(BancoDeDados.ordemservico.listIterator(index).hasPrevious())
							anterior.actionPerformed(e);
						else if(BancoDeDados.ordemservico.listIterator(index).hasPrevious())
							posterior.actionPerformed(e);
						else{
						
							textCodigo.setText("");
							textSeq.setText("10");
							textCodCliente.setText("");
							textDescCliente.setText("");
							textCodServico.setText("");
							textDescServico.setText("");
							textCodRoupa.setText("");
							textDescRoupa.setText("");
							textDescTecido.setText("");
							aModel.setRowCount(0);
						
						}
					
						BancoDeDados.ordemservico.remove(ordem);
						atualizaTable();
						break;
					}
				}
		}//apagar
		
		
	}// fim
}


