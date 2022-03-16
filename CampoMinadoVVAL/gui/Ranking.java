package br.com.poli.CampoMinadoVVAL.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.poli.CampoMinadoVVAL.Jogador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Ranking {
	private File txtRanking;
	private FileWriter fileW;
	private BufferedWriter buffW;
	private FileReader fileR;
	private BufferedReader buffR;
	private List<Jogador> jogador = new ArrayList<Jogador>();

	public Ranking() {

	}

	public void criaRanking(String filepath) {
		txtRanking = new File(filepath);
		try {
			if (txtRanking.exists()) {
				System.out.println("Ranking carregado");
			} else {

				txtRanking.createNewFile();
				System.out.println("Ranking criado com sucesso");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void escreveTexto(Jogador jogador) throws IOException {
		this.fileW = new FileWriter(this.txtRanking, true);
		this.buffW = new BufferedWriter(this.fileW);
		buffW.write(jogador.getNome());
		buffW.newLine();
		buffW.write(jogador.getTempo());
		buffW.newLine();
		buffW.close();
		System.out.println("Dados gravados no ranking");
	}

	public void scanTexto(String filepath) throws IOException {
		this.fileR = new FileReader(filepath);
		this.buffR = new BufferedReader(fileR);
		String line=buffR.readLine();
		while(line!=null) {
			Jogador jogadorNovo= new Jogador(line);
			line=buffR.readLine();
			jogadorNovo.setTempo(Integer.parseInt(line));
			jogador.add(jogadorNovo);
			line=buffR.readLine();
		}
		while(jogador.size()<5) {
			Jogador preencher = new Jogador("-");
			preencher.setTempo(9999999);
			jogador.add(preencher);
		}
		Collections.sort(jogador);
	}
	public void clearArray() {
		jogador.clear();
	}
	public String retornaTempo() {
		String nova="";
	for (int i = 0; i < 5; i++) {
		nova+=jogador.get(i).getTempo()+"\n";
		
	}
	return nova;
	}

	public String retornaNome() {
		String nova="";
	for (int i = 0; i < 5; i++) {
		nova+=jogador.get(i).getNome()+"\n";
		
	}
	return nova;
	}

	public List<Jogador> getJogador() {
		return jogador;
	}

	public void setJogador(List<Jogador> jogador) {
		this.jogador = jogador;
	}
	
	
}
