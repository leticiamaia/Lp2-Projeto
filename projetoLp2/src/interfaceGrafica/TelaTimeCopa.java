package interfaceGrafica;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Collection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projetoLp2.bolao.docs.ControladorTimes;
import projetoLp2.bolao.TimeCopa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaTimeCopa extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel mainPanel;
	//private static TimeCopa[] times = (TimeCopa[]) ControladorTimes.ler().values().toArray();
	//private static Map<String, TimeCopa> mapTimes = (Map<String, TimeCopa>) ControladorTimes.ler();
	//private static Collection<TimeCopa> listaDeTimes = (Collection<TimeCopa>) mapTimes.values();
	private Collection<TimeCopa> listaDeTimes = (Collection<TimeCopa>) ControladorTimes.ler().values();
	private final String[] comboItens = arrayComboItens();
	private final JComboBox comboBox = new JComboBox(comboItens);
	private TimeCopa itemSelecionadoAtual = null;
	private JLabel labelNomeDoTime = new JLabel();
	/**
	 * Create the panel.
	 */
	public TelaTimeCopa() {
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
		mainPanel = new JPanel(new CardLayout());
		mainPanel.setBackground(new Color(240, 240, 240));
		mainPanel.setBounds(234, 165, 822, 452);
		mainPanel.setVisible(true);
		add(mainPanel);
		
		JLabel fazerApostaLabel = new JLabel("Times da Copa 2014");
		fazerApostaLabel.setBackground(Color.WHITE);
		fazerApostaLabel.setBounds(10, 11, 492, 61);
		fazerApostaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		add(fazerApostaLabel);
		
		JLabel divisorHorizontalLabel = new JLabel("");
		add(divisorHorizontalLabel);
		divisorHorizontalLabel.setIcon(new ImageIcon(TelaDoUsuario.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		divisorHorizontalLabel.setBounds(-88, 59, 700, 21);
		
		final JPanel panelTeste = new JPanel();
		panelTeste.setBounds(0, 0, 822, 452);
		mainPanel.add( panelTeste, comboItens[0]);
		panelTeste.setLayout(null);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTime.setBounds(10, 11, 58, 30);
		panelTeste.add(lblTime);
				
		labelNomeDoTime = new JLabel("");
		labelNomeDoTime.setBounds(130, 11, 309, 30);
		labelNomeDoTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTeste.add(labelNomeDoTime);
		
		JLabel lblBandeira = new JLabel("Bandeira:");
		lblBandeira.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBandeira.setBounds(10, 51, 90, 30);
		panelTeste.add(lblBandeira);
		
		final JLabel lblIconeBandeira = new JLabel("");
		lblIconeBandeira.setBounds(130, 46, 90, 45);
		panelTeste.add(lblIconeBandeira);
		
		JLabel lblNumeroDeVitorias = new JLabel("N\u00B0 Vit\u00F3rias:");
		lblNumeroDeVitorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroDeVitorias.setBounds(10, 92, 90, 30);
		panelTeste.add(lblNumeroDeVitorias);
		
		final JLabel labelNumeroDeVitorias = new JLabel("");
		labelNumeroDeVitorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumeroDeVitorias.setBounds(130, 92, 110, 33);
		panelTeste.add(labelNumeroDeVitorias);
		
		JLabel lblNmeroDeDerrotas = new JLabel("N\u00BA de Derrotas:");
		lblNmeroDeDerrotas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmeroDeDerrotas.setBounds(10, 133, 150, 30);
		panelTeste.add(lblNmeroDeDerrotas);
		
		final JLabel labelNumeroDeDerrotas = new JLabel("");
		labelNumeroDeDerrotas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumeroDeDerrotas.setBounds(130, 136, 115, 27);
		panelTeste.add(labelNumeroDeDerrotas);
		
		JLabel lblNDeEmpates = new JLabel("N\u00BA de Empates:");
		lblNDeEmpates.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNDeEmpates.setBounds(10, 181, 155, 30);
		panelTeste.add(lblNDeEmpates);
		
		final JLabel labelNumeroDeEmpates = new JLabel("");
		labelNumeroDeEmpates.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNumeroDeEmpates.setBounds(130, 184, 115, 27);
		panelTeste.add(labelNumeroDeEmpates);
		
		JLabel selecioneFase = new JLabel("Selecione o time que deseja visualizar:");
		selecioneFase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selecioneFase.setBackground(Color.WHITE);
		selecioneFase.setBounds(314, 93, 232, 61);
		add(selecioneFase);
		
		
		comboBox.setBounds(552, 111, 366, 26);
		add(comboBox);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				itemSelecionadoAtual = (TimeCopa) opcaoComboBox();
				labelNomeDoTime.setText(nomeDoTime() + " (" + abrDoTime() + ")");
				lblIconeBandeira.setIcon(iconeDoTime());
				labelNumeroDeVitorias.setText(numeroDeVitorias());
				labelNumeroDeDerrotas.setText(numeroDeDerrotas());
				labelNumeroDeEmpates.setText(numeroDeEmpates());
			}



		});
		
		adicionaItensAoComboBox();

	}
	
	private TimeCopa opcaoComboBox(){
		String opcao = (String) comboBox.getSelectedItem();
		System.out.println(opcao);
		
		for (TimeCopa time : listaDeTimes) {
			if (opcao.equals(time.toString()))
				System.out.println(time.getNomeDoTime());
				return time;
		}
		return null;
		
	}
	
	private String nomeDoTime(){
		if (itemSelecionadoAtual == null)
			return "";
		return itemSelecionadoAtual.getNomeDoTime();
	}

	private String abrDoTime() {
		if (itemSelecionadoAtual == null)
			return "";
		return itemSelecionadoAtual.getAbreviacaoNomeTime();
	}
	
	private String numeroDeVitorias() {
		if (itemSelecionadoAtual == null)
			return "";
		return itemSelecionadoAtual.getNumVitorias() + " ("+(itemSelecionadoAtual.getPorcentagemVitorias())+"%)";
	}
	
	private String numeroDeDerrotas() {
		if (itemSelecionadoAtual == null)
			return "";
		return itemSelecionadoAtual.getNumDerrotas() + " ("+(itemSelecionadoAtual.getPorcentagemDerrotas())+"%)";
	}
	
	private String numeroDeEmpates() {
		if (itemSelecionadoAtual == null)
			return "";
		return itemSelecionadoAtual.getNumEmpates() + " ("+(itemSelecionadoAtual.getPorcentagemEmpates())+"%)";
	}
	
	private String[] arrayComboItens(){
		String[] arrayComboItens = new String[33];
		
		arrayComboItens[0] = "Selecione um time";
		
		int i = 1;
		//ordenaTimes();
		for (TimeCopa time : listaDeTimes) {
			arrayComboItens[i] = time.toString();
			i++;
		}
		return arrayComboItens;
	}
	
	private void adicionaItensAoComboBox(){
		JPanel panelDoTime;
		
		for (int i = 1; i < comboItens.length; i++) {
			panelDoTime = new JPanel(null);
			panelDoTime.setBounds(0, 0, 822, 452);
			mainPanel.add(panelDoTime, comboItens[i]);
		}
	}
	
	private Icon iconeDoTime() {
		if (itemSelecionadoAtual == null)
			return null;
		return itemSelecionadoAtual.getBandeiraDoTime();
	}
	
	/*private static void ordenaTimes(){
		Arrays.sort(arrayTimes);
	}*/
	
	
	public static void main(String[] args) {
		/*for (int i = 0; i < comboItens.length; i++) {
			System.out.println(comboItens[i]);
		}
		
		for (TimeCopa time : listaDeTimes) {
			System.out.println(time);
		}*/
		JFrame janela = new JFrame();
		janela.setBounds(0, 0, 1300, 700);
		janela.setVisible(true);
		TelaTimeCopa panel = new TelaTimeCopa();
		janela.getContentPane().add(panel);
	}
}
