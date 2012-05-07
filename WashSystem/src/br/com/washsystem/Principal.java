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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Principal {

	private JFrame frmWashsystemServios;
	private final Action actionJClientes = new actionJClientes();
	private final Action actionJRoupas = new actionJRoupas();
	private final Action actionJServicos = new actionJServicos();
	private final Action actionJPrecos = new actionJPrecos();

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
		
		JMenuItem mntmTabelaDePreos = new JMenuItem("Tabela de Pre\u00E7os");
		mntmTabelaDePreos.setAction(actionJPrecos);
		mnCadastros.add(mntmTabelaDePreos);
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
}
