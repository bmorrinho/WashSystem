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

public class JRoupa extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textTipo;
	private JTextField textTecido;
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
	public JRoupa() {
		setResizable(false);
		setTitle("Cadastro de Tipos de Roupa");
		addWindowListener(fechar);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		
		textTipo = new JTextField();
		textTipo.setEditable(false);
		textTipo.setColumns(10);
		
		JLabel lblNome = new JLabel("Tipo:");
		
		textTecido = new JTextField();
		textTecido.setEditable(false);
		textTecido.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Tecido:");
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
								.addComponent(lblNome)
								.addComponent(lblSobrenome))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textTecido, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
						.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTipo))
					.addContainerGap(159, Short.MAX_VALUE))
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
								.addComponent(textTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTecido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSobrenome))
					.addContainerGap(167, Short.MAX_VALUE))
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		BancoDeDados.carregaRoupas();
		
		setTitle("Cadastro de Tipos de Roupa - [" + BancoDeDados.roupas.size() + "]");
		
		if(!BancoDeDados.roupas.isEmpty()){
			
			Roupa roupa = BancoDeDados.roupas.getFirst();
			
			textCodigo.setText(String.valueOf(roupa.getCodigo()));
			textTipo.setText(roupa.getTipo());
			textTecido.setText(roupa.getTecido());
			
		}

		
	}
	private class Novo extends AbstractAction {
		public Novo() {
			putValue(NAME, "Novo");
			putValue(SHORT_DESCRIPTION, "Novo Registro");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.roupas.size() == 0)
				textCodigo.setText("1");
			else
				textCodigo.setText(String.valueOf(BancoDeDados.roupas.getLast().getCodigo() + 1));
			
			textTipo.setEditable(true);
			textTecido.setEditable(true);
			
			textTipo.setText("");
			textTecido.setText("");
						
		}
	}
	private class Salvar extends AbstractAction {
		public Salvar() {
			putValue(NAME, "Salvar");
			putValue(SHORT_DESCRIPTION, "Salva Registro Atual");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(!textCodigo.getText().equals("")){
			
			Integer codigo = Integer.parseInt(textCodigo.getText());
			
			Roupa roupa;
			
			ListIterator<Roupa> listIt = (ListIterator<Roupa>)BancoDeDados.roupas.listIterator();
			
			while(listIt.hasNext()){
				roupa = listIt.next();
				if(roupa.getCodigo() == codigo){
					
					try{
						roupa.setCodigo(Integer.parseInt(textCodigo.getText()));
						roupa.setTipo(textTipo.getText());
						roupa.setTecido(textTecido.getText());
	
					}
					catch(NumberFormatException numFormatE){
						JOptionPane.showMessageDialog(null, "Formato de dados incorretos", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
					setTitle("Cadastro de Tipos de Roupa - [" + BancoDeDados.roupas.size() + "]");
					
					textTipo.setEditable(false);
					textTecido.setEditable(false);
					
					return;
				}
			}
			
			try{
				roupa = new Roupa(Integer.parseInt(textCodigo.getText()),
									  textTipo.getText(),
									  textTecido.getText());

			BancoDeDados.roupas.add(roupa);
			
			}
			catch(NumberFormatException numFormatE){
				numFormatE.printStackTrace();
			}
			
			setTitle("Cadastro de Tipos de Roupa - [" + BancoDeDados.roupas.size() + "]");
			
			textTipo.setEditable(false);
			textTecido.setEditable(false);
			
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
			
			Roupa roupa;
			Roupa previous;
			
			ListIterator<Roupa> listIt = (ListIterator<Roupa>)BancoDeDados.roupas.listIterator();
			
			while(listIt.hasNext()){
				roupa = listIt.next();
				if(roupa.getCodigo() == codigo){
					listIt.previous();
					
					if(listIt.hasPrevious()){
						previous = listIt.previous();
					
						textCodigo.setText(String.valueOf(previous.getCodigo()));
						textTipo.setText(previous.getTipo());
						textTecido.setText(previous.getTecido());						
						
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
			
			Roupa roupa;
			Roupa next;
			
			ListIterator<Roupa> listIt = (ListIterator<Roupa>)BancoDeDados.roupas.listIterator();
			
			while(listIt.hasNext()){
				roupa = listIt.next();
				if(roupa.getCodigo() == codigo && listIt.hasNext()){					
					
					next = listIt.next();
					
					textCodigo.setText(String.valueOf(next.getCodigo()));
					textTipo.setText(next.getTipo());
					textTecido.setText(next.getTecido());	
					
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
			
			if(BancoDeDados.roupas.size() >= 1 ){
			
				int codigo = Integer.parseInt(textCodigo.getText());
				int index = 0;
				
				for(Preco preco:BancoDeDados.precos)
					if(preco.getRoupa().getCodigo() == codigo){
						JOptionPane.showMessageDialog(null, "Tipo de roupa relacionado a tabela de preço");
						return;
					}
			
				for(Roupa roupa:BancoDeDados.roupas)
					if(roupa.getCodigo() == codigo){
					
						index = BancoDeDados.roupas.indexOf(roupa);
					
						if(BancoDeDados.roupas.listIterator(index).hasPrevious())
							anterior.actionPerformed(e);
						else if(BancoDeDados.roupas.listIterator(index).hasPrevious())
							posterior.actionPerformed(e);
						else{
						
							textCodigo.setText("");
							textTipo.setText("");
							textTecido.setText("");
						
						}
					
						BancoDeDados.roupas.remove(roupa);
						break;
					}
				setTitle("Cadastro de Tipos de Roupa - [" + BancoDeDados.roupas.size() + "]");
			}
		}
	}
	private class Alterar extends AbstractAction {
		public Alterar() {
			putValue(NAME, "Alterar");
			putValue(SHORT_DESCRIPTION, "Alterar Registro Atual");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(BancoDeDados.roupas.size() >= 1 ){
			
				textTipo.setEditable(true);
				textTecido.setEditable(true);	
			
			}
			
		}
	}
	private class Fechar extends WindowAdapter{
		
		public void windowClosing(WindowEvent e){
			
			BancoDeDados.gravaRoupas();
			
		}
		
	}

}
