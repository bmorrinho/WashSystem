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

public class JServico extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textDescricao;
	private final Action novo = new Novo();
	private final Action salvar = new Salvar();
	private final Action anterior = new Anterior();
	private final Action posterior = new Posterior();
	private final Action apagar = new Apagar();
	private final Action alterar = new Alterar();
	private final WindowListener fechar = new Fechar();
	private JTextField textPreco;

	/**
	 * Create the frame.
	 */
	public JServico() {
		setResizable(false);
		setTitle("Cadastro de Tipos de Serviço");
		addWindowListener(fechar);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		
		textDescricao = new JTextField();
		textDescricao.setEditable(false);
		textDescricao.setColumns(10);
		
		JLabel lblNome = new JLabel("Descri\u00E7\u00E3o:");
		
		JLabel label = new JLabel("Pre\u00E7o:");
		
		textPreco = new JTextField();
		textPreco.setEditable(false);
		textPreco.setColumns(10);
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
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(185, Short.MAX_VALUE))
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
								.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addContainerGap(11, Short.MAX_VALUE))
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
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
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
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		BancoDeDados.carregaServicos();
		
		setTitle("Cadastro de Tipos de Serviço - [" + BancoDeDados.servicos.size() + "]");
		
		if(!BancoDeDados.servicos.isEmpty()){
			
			Servico servico = BancoDeDados.servicos.getFirst();
			
			textCodigo.setText(String.valueOf(servico.getCodigo()));
			textDescricao.setText(servico.getDescricao());
			textPreco.setText(String.valueOf(servico.getPreco()));
		}

		
	}
	private class Novo extends AbstractAction {
		public Novo() {
			putValue(NAME, "Novo");
			putValue(SHORT_DESCRIPTION, "Novo Registro");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.servicos.size() == 0)
				textCodigo.setText("1");
			else
				textCodigo.setText(String.valueOf(BancoDeDados.servicos.getLast().getCodigo() + 1));
			
			textDescricao.setEditable(true);
			textPreco.setEditable(true);
			
			textDescricao.setText("");
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
			
			Servico servico;
			
			ListIterator<Servico> listIt = (ListIterator<Servico>)BancoDeDados.servicos.listIterator();
			
			while(listIt.hasNext()){
				servico = listIt.next();
				if(servico.getCodigo() == codigo){
					
					try{
						servico.setCodigo(Integer.parseInt(textCodigo.getText()));
						servico.setDescricao(textDescricao.getText());
						servico.setPreco(Double.parseDouble(textPreco.getText()));
	
					}
					catch(NumberFormatException numFormatE){
						JOptionPane.showMessageDialog(null, "Formato de dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
					setTitle("Cadastro de Tipos de Serviço - [" + BancoDeDados.servicos.size() + "]");
					
					textDescricao.setEditable(false);
					textPreco.setEditable(false);
					
					return;
				}
			}
			
			try{
				servico = new Servico(Integer.parseInt(textCodigo.getText()),
									  textDescricao.getText(),
									  Double.parseDouble(textPreco.getText()));

			BancoDeDados.servicos.add(servico);
			
			}
			catch(NumberFormatException numFormatE){
				numFormatE.printStackTrace();
			}
			
			setTitle("Cadastro de Tipos de Serviço - [" + BancoDeDados.servicos.size() + "]");
			
			textDescricao.setEditable(false);
			
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
			
			Servico servico;
			Servico previous;
			
			ListIterator<Servico> listIt = (ListIterator<Servico>)BancoDeDados.servicos.listIterator();
			
			while(listIt.hasNext()){
				servico = listIt.next();
				if(servico.getCodigo() == codigo){
					listIt.previous();
					
					if(listIt.hasPrevious()){
						previous = listIt.previous();
					
						textCodigo.setText(String.valueOf(previous.getCodigo()));
						textDescricao.setText(previous.getDescricao());						
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
			
			Servico servico;
			Servico next;
			
			ListIterator<Servico> listIt = (ListIterator<Servico>)BancoDeDados.servicos.listIterator();
			
			while(listIt.hasNext()){
				servico = listIt.next();
				if(servico.getCodigo() == codigo && listIt.hasNext()){					
					
					next = listIt.next();
					
					textCodigo.setText(String.valueOf(next.getCodigo()));
					textDescricao.setText(next.getDescricao());
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
			
			if(BancoDeDados.precos.isEmpty())
				BancoDeDados.carregaPrecos();
			
			if(BancoDeDados.servicos.size() >= 1 ){
			
				int codigo = Integer.parseInt(textCodigo.getText());
				int index = 0;
				
				for(Preco preco:BancoDeDados.precos)
					if(preco.getRoupa().getCodigo() == codigo){
						JOptionPane.showMessageDialog(null, "Tipo de serviço relacionado a tabela de preço");
						return;
					}
			
				for(Servico servico:BancoDeDados.servicos)
					if(servico.getCodigo() == codigo){
					
						index = BancoDeDados.servicos.indexOf(servico);
					
						if(BancoDeDados.servicos.listIterator(index).hasPrevious())
							anterior.actionPerformed(e);
						else if(BancoDeDados.servicos.listIterator(index).hasPrevious())
							posterior.actionPerformed(e);
						else{
						
							textCodigo.setText("");
							textDescricao.setText("");
							textPreco.setText("");
						
						}
					
						BancoDeDados.servicos.remove(servico);
						break;
					}
				setTitle("Cadastro de Tipos de Serviço - [" + BancoDeDados.servicos.size() + "]");
			}
		}
	}
	private class Alterar extends AbstractAction {
		public Alterar() {
			putValue(NAME, "Alterar");
			putValue(SHORT_DESCRIPTION, "Alterar Registro Atual");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.servicos.size() >= 1 ){
			
				textDescricao.setEditable(true);
				textPreco.setEditable(true);
			
			}
			
		}
	}
	private class Fechar extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			
			BancoDeDados.gravaServicos();
			
		}
		
	}

}
