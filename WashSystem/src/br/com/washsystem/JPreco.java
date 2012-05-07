package br.com.washsystem;

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

public class JPreco extends JFrame {

	private JPanel contentPane;
	private JTextField textCodServico;
	private JTextField textCodRoupa;
	private final Action novo = new Novo();
	private final Action salvar = new Salvar();
	private final Action anterior = new Anterior();
	private final Action posterior = new Posterior();
	private final Action apagar = new Apagar();
	private final Action alterar = new Alterar();
	private final WindowListener fechar = new Fechar();
	private JTextField textPreco;
	private JTextField textTipoRoupa;
	private JTextField textTecidoRoupa;
	private JTextField textCodigo;
	private JTextField textDescServico;

	/**
	 * Create the frame.
	 */
	public JPreco() {
		setResizable(false);
		setTitle("Tabela de Pre\u00E7os");
		addWindowListener(fechar);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblCdigo = new JLabel("Tipo de Servi\u00E7o:");
		
		textCodServico = new JTextField();
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
		textCodServico.setEditable(false);
		textCodServico.setColumns(10);
		
		textCodRoupa = new JTextField();
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
					textTipoRoupa.setText(roupa.getTipo());
					textTecidoRoupa.setText(roupa.getTecido());
				}
				else{
					textTipoRoupa.setText("");
					textTecidoRoupa.setText("");
				}
			}
		});
		textCodRoupa.setEditable(false);
		textCodRoupa.setColumns(10);
		
		JLabel lblNome = new JLabel("Tipo de Roupa:");
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		
		textPreco = new JTextField();
		textPreco.setEditable(false);
		textPreco.setColumns(10);
		
		textTipoRoupa = new JTextField();
		textTipoRoupa.setEditable(false);
		textTipoRoupa.setColumns(10);
		
		textTecidoRoupa = new JTextField();
		textTecidoRoupa.setEditable(false);
		textTecidoRoupa.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		
		textDescServico = new JTextField();
		textDescServico.setEditable(false);
		textDescServico.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCdigo)
						.addComponent(lblNewLabel)
						.addComponent(lblNome)
						.addComponent(lblPreo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textCodRoupa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(textCodServico, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(textCodigo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textDescServico)
								.addComponent(textTipoRoupa, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textTecidoRoupa, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCodServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCdigo)
						.addComponent(textDescServico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCodRoupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNome)
						.addComponent(textTipoRoupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTecidoRoupa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPreo)
						.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(95))
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
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
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
					.addContainerGap(103, Short.MAX_VALUE))
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textCodRoupa, textCodServico, textPreco}));
		contentPane.setLayout(gl_contentPane);
		
		if(BancoDeDados.servicos.isEmpty())
			BancoDeDados.carregaServicos();
		if(BancoDeDados.roupas.isEmpty())
			BancoDeDados.carregaRoupas();
		
		BancoDeDados.carregaPrecos();
		
		setTitle("Tabela de Preços - [" + BancoDeDados.precos.size() + "]");
		
		
		
		if(!BancoDeDados.precos.isEmpty()){
			
			Preco preco = BancoDeDados.precos.getFirst();
			
			textCodigo.setText(String.valueOf(preco.getCodigo()));
			textCodServico.setText(String.valueOf(preco.getServico().getCodigo()));
			textDescServico.setText(preco.getServico().getDescricao());
			textCodRoupa.setText(String.valueOf(preco.getRoupa().getCodigo()));
			textTipoRoupa.setText(preco.getRoupa().getTipo());
			textTecidoRoupa.setText(preco.getRoupa().getTecido());
			textPreco.setText(String.valueOf(preco.getPreco()));
			
		}
		
	}
	private class Novo extends AbstractAction {
		public Novo() {
			putValue(NAME, "Novo");
			putValue(SHORT_DESCRIPTION, "Novo Registro");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.precos.size() == 0)
				textCodigo.setText("1");
			else
				textCodigo.setText(String.valueOf(BancoDeDados.precos.getLast().getCodigo() + 1));
				
			textCodServico.setEditable(true);
			textCodRoupa.setEditable(true);
			textPreco.setEditable(true);
						
			textCodServico.setText("");
			textDescServico.setText("");
			textCodRoupa.setText("");
			textTipoRoupa.setText("");
			textTecidoRoupa.setText("");
			textPreco.setText("");
						
		}
	}
	private class Salvar extends AbstractAction {
		public Salvar() {
			putValue(NAME, "Salvar");
			putValue(SHORT_DESCRIPTION, "Salva Registro");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(!textCodigo.getText().equals("")){
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Servico servico = null;
			Roupa roupa = null;
			Preco Preco = null;
			
			ListIterator<Preco> listIt = (ListIterator<Preco>)BancoDeDados.precos.listIterator();
			
			while(listIt.hasNext()){
				Preco = listIt.next();
				if(Preco.getCodigo() == codigo){					
					
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
						Preco.setServico(servico);
						Preco.setRoupa(roupa);
						Preco.setPreco(Double.parseDouble(textPreco.getText()));
	
					}
					catch(NumberFormatException numFormatE){
						JOptionPane.showMessageDialog(null, "Formato de dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
						
					}
					
					setTitle("Tabela de Preços - [" + BancoDeDados.precos.size() + "]");
					
					textCodServico.setEditable(false);
					textCodRoupa.setEditable(false);
					textPreco.setEditable(false);
					
					return;
				}
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
				Preco = new Preco(Integer.parseInt(textCodigo.getText()),
								  servico,
								  roupa,
								  Double.parseDouble(textPreco.getText()));

			BancoDeDados.precos.add(Preco);
			
			}
			catch(NumberFormatException numFormatE){
				numFormatE.printStackTrace();
			}
			
			setTitle("Tabela de Preços - [" + BancoDeDados.precos.size() + "]");
			
			textCodServico.setEditable(false);
			textCodRoupa.setEditable(false);
			textPreco.setEditable(false);
			
		}
		}
	}
	private class Anterior extends AbstractAction {
		public Anterior() {
			putValue(NAME, "Anterior");
			putValue(SHORT_DESCRIPTION, "Registro Anterior");
		}
		public void actionPerformed(ActionEvent e) {			
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Preco Preco;
			Preco previous;
			
			ListIterator<Preco> listIt = (ListIterator<Preco>)BancoDeDados.precos.listIterator();
			
			while(listIt.hasNext()){
				Preco = listIt.next();
				if(Preco.getCodigo() == codigo){
					listIt.previous();
					
					if(listIt.hasPrevious()){
						previous = listIt.previous();
					
						textCodigo.setText(String.valueOf(previous.getCodigo()));
						textCodServico.setText(String.valueOf(previous.getServico().getCodigo()));
						textDescServico.setText(previous.getServico().getDescricao());
						textCodRoupa.setText(String.valueOf(previous.getRoupa().getCodigo()));						
						textTipoRoupa.setText(previous.getRoupa().getTipo());
						textTecidoRoupa.setText(previous.getRoupa().getTecido());
						textPreco.setText(String.valueOf(previous.getPreco()));
						
					}
					break;
				}				
			}						
		}
	}
	private class Posterior extends AbstractAction {
		public Posterior() {
			putValue(NAME, "Posterior");
			putValue(SHORT_DESCRIPTION, "Registro Posterior");
		}
		public void actionPerformed(ActionEvent e) {
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Preco preco;
			Preco next;
			
			ListIterator<Preco> listIt = (ListIterator<Preco>)BancoDeDados.precos.listIterator();
			
			while(listIt.hasNext()){
				preco = listIt.next();
				if(preco.getCodigo() == codigo && listIt.hasNext()){					
					
					next = listIt.next();
					
					textCodigo.setText(String.valueOf(next.getCodigo()));
					textCodServico.setText(String.valueOf(next.getServico().getCodigo()));
					textDescServico.setText(next.getServico().getDescricao());	
					textCodRoupa.setText(String.valueOf(next.getRoupa().getCodigo()));						
					textTipoRoupa.setText(next.getRoupa().getTipo());
					textTecidoRoupa.setText(next.getRoupa().getTecido());
					textPreco.setText(String.valueOf(next.getPreco()));
						
					
					break;
				}
				
			}
			
		}
	}
	private class Apagar extends AbstractAction {
		public Apagar() {
			putValue(NAME, "Apagar");
			putValue(SHORT_DESCRIPTION, "Apagar Registro Atual");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.precos.size() >= 1 ){
			
				int codigo = Integer.parseInt(textCodigo.getText());
				int index = 0;
			
				for(Preco preco:BancoDeDados.precos)
					if(preco.getCodigo() == codigo){
					
						index = BancoDeDados.precos.indexOf(preco);
					
						if(BancoDeDados.precos.listIterator(index).hasPrevious())
							anterior.actionPerformed(e);
						else if(BancoDeDados.precos.listIterator(index).hasPrevious())
							posterior.actionPerformed(e);
						else{
						
							textCodigo.setText("");
							textCodServico.setText("");
							textDescServico.setText("");
							textCodRoupa.setText("");						
							textTipoRoupa.setText("");
							textTecidoRoupa.setText("");
							textPreco.setText("");
						
						}
					
						BancoDeDados.precos.remove(preco);
						break;
					}
				setTitle("Tabela de Preços - [" + BancoDeDados.precos.size() + "]");
			}
		}
	}
	private class Alterar extends AbstractAction {
		public Alterar() {
			putValue(NAME, "Alterar");
			putValue(SHORT_DESCRIPTION, "Alterar Registro Atual");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.precos.size() >= 1 ){
			
				textCodServico.setEditable(true);
				textCodRoupa.setEditable(true);
				textPreco.setEditable(true);
			
			}
			
		}
	}
	private class Fechar extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			
			BancoDeDados.gravaPrecos();
			
		}
		
	}
}
