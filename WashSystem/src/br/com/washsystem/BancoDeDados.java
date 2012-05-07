package br.com.washsystem;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class BancoDeDados {
	
	public static RandomAccessFile arquivo;
	public static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	public static LinkedList<Roupa> roupas = new LinkedList<Roupa>();
	public static LinkedList<Servico> servicos = new LinkedList<Servico>();
	public static LinkedList<Preco> precos = new LinkedList<Preco>();
	public static LinkedList<OrdemServico> ordemservico = new LinkedList<OrdemServico>();
	
	public static void carregaClientes(){
			
		File arquivo = new File("/washsystem/clientes.ser");
		
		if(arquivo.exists()){
			
			if(arquivo.length() > 0){
				
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					clientes = (LinkedList<Cliente>)input.readObject();
					input.close();
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
			}
			
		}
		else{
			
			new File("/washsystem").mkdir();
				
				arquivo = new File("/washsystem/clientes.ser");
			
				try {
					
					arquivo.createNewFile();
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					clientes = (LinkedList<Cliente>)input.readObject();		
					input.close();
					
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				} catch (ClassNotFoundException e) {
						e.printStackTrace();
				}			
				
			
			
		}		
		
	}
	
	public static void gravaClientes(){
		
		File arquivo = new File("/washsystem/clientes.ser");
		
		ObjectOutputStream output;
		
		if(arquivo.exists() && arquivo.canWrite()){
			
			try {
				output = new ObjectOutputStream(new FileOutputStream(arquivo));
				output.writeObject(clientes);
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}				
	}
	
	public static void carregaRoupas(){
		
		File arquivo = new File("/washsystem/roupas.ser");
		
		if(arquivo.exists()){
			
			if(arquivo.length() > 0){
				
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					roupas = (LinkedList<Roupa>)input.readObject();
					input.close();
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
			}
			
		}
		else{
			
			new File("/washsystem").mkdir();
				
				arquivo = new File("/washsystem/roupas.ser");
			
				try {
					
					arquivo.createNewFile();
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					roupas = (LinkedList<Roupa>)input.readObject();	
					input.close();
					
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				} catch (EOFException e){
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				} catch (ClassNotFoundException e) {
						e.printStackTrace();
				} 			
			
		}		
		
	}
	
	public static void gravaRoupas(){
		
		File arquivo = new File("/washsystem/roupas.ser");
		
		ObjectOutputStream output;
		
		if(arquivo.exists() && arquivo.canWrite()){
			
			try {
				output = new ObjectOutputStream(new FileOutputStream(arquivo));
				output.writeObject(roupas);
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}				
	}
	
	public static void carregaServicos(){
		
		File arquivo = new File("/washsystem/servicos.ser");
		
		if(arquivo.exists()){
			
			if(arquivo.length() > 0){
				
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					servicos = (LinkedList<Servico>)input.readObject();
					input.close();
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
			}
			
		}
		else{
			
			new File("/washsystem").mkdir();
				
				arquivo = new File("/washsystem/servicos.ser");
			
				try {
					
					arquivo.createNewFile();
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					servicos = (LinkedList<Servico>)input.readObject();		
					input.close();
					
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				} catch (ClassNotFoundException e) {
						e.printStackTrace();
				}			
				
			
			
		}		
		
	}
	
	public static void gravaServicos(){
		
		File arquivo = new File("/washsystem/servicos.ser");
		
		ObjectOutputStream output;
		
		if(arquivo.exists() && arquivo.canWrite()){
			
			try {
				output = new ObjectOutputStream(new FileOutputStream(arquivo));
				output.writeObject(servicos);
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}				
	}
	
	public static void carregaPrecos(){
		
		File arquivo = new File("/washsystem/precos.ser");
		
		if(arquivo.exists()){
			
			if(arquivo.length() > 0){
				
				try {
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					precos = (LinkedList<Preco>)input.readObject();
					input.close();
				
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
			}
			
		}
		else{
			
			new File("/washsystem").mkdir();
				
				arquivo = new File("/washsystem/precos.ser");
			
				try {
					
					arquivo.createNewFile();
					ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
					precos = (LinkedList<Preco>)input.readObject();		
					input.close();
					
				} catch (FileNotFoundException e) {
						e.printStackTrace();
				} catch (IOException e) {
						e.printStackTrace();
				} catch (ClassNotFoundException e) {
						e.printStackTrace();
				}			
				
			
			
		}		
		
	}
	
	public static void gravaPrecos(){
		
		File arquivo = new File("/washsystem/precos.ser");
		
		ObjectOutputStream output;
		
		if(arquivo.exists() && arquivo.canWrite()){
			
			try {
				output = new ObjectOutputStream(new FileOutputStream(arquivo));
				output.writeObject(precos);
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}				
	}
	
	public static void carregaOrdemServico(){
		
	File arquivo = new File("/washsystem/ordemservico.ser");
	
	if(arquivo.exists()){
		
		if(arquivo.length() > 0){
			
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
				ordemservico = (LinkedList<OrdemServico>)input.readObject();
				input.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	else{
		
		new File("/washsystem").mkdir();
			
			arquivo = new File("/washsystem/ordemservico.ser");
		
			try {
				
				arquivo.createNewFile();
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(arquivo));
				ordemservico = (LinkedList<OrdemServico>)input.readObject();		
				input.close();
				
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			}			
		}		
	}

	public static void gravaOrdemServico(){
	
		File arquivo = new File("/washsystem/ordemservico.ser");
		
		ObjectOutputStream output;
		
		if(arquivo.exists() && arquivo.canWrite()){
			
			try {
				output = new ObjectOutputStream(new FileOutputStream(arquivo));
				output.writeObject(ordemservico);
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}				
	}
}
