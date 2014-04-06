package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projetoLp2.bolao.Jogador;
import projetoLp2.bolao.MeuBolao;

public class AlterarInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -337804168890997381L;
	private JTextField recebeNovoNomeField;
	private JTextField recebeNovoEmailField;
	private JPasswordField recebeNovaSenhaField;
	private JTextField recebNovaRespostaLabel;
	private JComboBox<String> novaPerguntaSecretaComboBox;
	private JLabel nomeAtual, emailAtual, perguntaSecreta, respostaSecreta;
	private JPanel imagemPanel;
	private JPanel formularioAlteraInfoPanel;
	private Jogador user;
	private String novoNome, novoEmail, novaPergunta, novaResposta;
	private JPanel telaBoaVindas;

	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public AlterarInfoPanel(Jogador usuario) {
		user = usuario;
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		setVisible(false);
		
		formularioAlteraInfoPanel = new JPanel();
		formularioAlteraInfoPanel.setBackground(Color.WHITE);
		formularioAlteraInfoPanel.setBounds(626, 11, 648, 606);
		formularioAlteraInfoPanel.setVisible(false);
		add(formularioAlteraInfoPanel);
		formularioAlteraInfoPanel.setLayout(null);
			
		criaImagemPanel();		
		criaTituloDadosAtuais();
		mostraDadosAtuais();
		
		JButton botaoEditarDados = new JButton("Editar Dados");
		botaoEditarDados.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/register_icon.gif")));
		botaoEditarDados.setBounds(240, 382, 132, 36);
		botaoEditarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				imagemPanel.setVisible(false);
				formularioAlteraInfoPanel.setVisible(true);
			}
		});
		add(botaoEditarDados);
		
		JLabel verticalDivisorLabel = new JLabel("");
		verticalDivisorLabel.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/verticalDivider.png")));
		verticalDivisorLabel.setBounds(579, -32, 48, 715);
		add(verticalDivisorLabel);
				
		criaTituloAlterarInfo();			
		criaAlterarInfoLabels();		
		criaAlterarInfoFields();		
		
		telaBoaVindas = new TelaUserBoasVindas();
		JButton botaoConfirmar = new JButton(" Confirmar");
		botaoConfirmar.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				novoNome = recebeNovoNomeField.getText();
				novoEmail =  recebeNovoEmailField.getText();
				novaPergunta = (String) novaPerguntaSecretaComboBox.getSelectedItem();
				novaResposta = recebNovaRespostaLabel.getText();
				try {
					if(MeuBolao.alterarInfo(novoNome,novoEmail, recebeNovaSenhaField.getText(),
					novaPergunta, novaResposta)) {
						JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
						ehVazio();
		}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		botaoConfirmar.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/tick.png")));
		botaoConfirmar.setBounds(411, 377, 121, 34);
		formularioAlteraInfoPanel.add(botaoConfirmar);
		
		JButton botaoCancelar = new JButton(" Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		botaoCancelar.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/cancel.png")));
		botaoCancelar.setBounds(115, 377, 121, 34);
		formularioAlteraInfoPanel.add(botaoCancelar);
		
		JButton limparFormulario = new JButton(" Limpar");
		limparFormulario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recebeNovoNomeField.setText(null);
				recebeNovoEmailField.setText(null);
				recebeNovaSenhaField.setText(null);
				recebNovaRespostaLabel.setText(null);				
			}
		});
		limparFormulario.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/broom arrow.png")));
		limparFormulario.setBounds(265, 377, 121, 34);
		formularioAlteraInfoPanel.add(limparFormulario);
	}

	private void criaImagemPanel() {
		imagemPanel = new JPanel();
		
		imagemPanel.setBackground(Color.WHITE);
		imagemPanel.setBounds(627, 11, 647, 606);
		imagemPanel.setVisible(true);
		add(imagemPanel);
		imagemPanel.setLayout(null);
		
		JLabel imagemGanhadorLabel = new JLabel("");
		imagemGanhadorLabel.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/segura-trofeu.jpg")));
		imagemGanhadorLabel.setBounds(55, 0, 554, 598);
		imagemPanel.add(imagemGanhadorLabel);
	}
	
	private void criaTituloDadosAtuais() {
		JLabel seusDadosAtuaisLabel = new JLabel("Seus dados atuais");
		seusDadosAtuaisLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		seusDadosAtuaisLabel.setBounds(120, 40, 304, 66);
		add(seusDadosAtuaisLabel); 
		
		JLabel horizontalDivisorLabel = new JLabel("");
		horizontalDivisorLabel.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		horizontalDivisorLabel.setBounds(-73, 85, 658, 21);
		add(horizontalDivisorLabel);
	}
	
	private void mostraDadosAtuais() {
		JLabel nomeAtualLabel = new JLabel("Nome: ");
		nomeAtualLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		nomeAtualLabel.setBounds(111, 194, 41, 21);
		add(nomeAtualLabel);
		
		nomeAtual = new JLabel(user.getNome());
		nomeAtual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nomeAtual.setBounds(162, 194, 388, 18);
		add(nomeAtual);
		
		JLabel emailAtualLabel = new JLabel("Email: ");
		emailAtualLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		emailAtualLabel.setBounds(116, 226, 48, 21);
		add(emailAtualLabel);
		
		emailAtual = new JLabel(user.getEmail());
		emailAtual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailAtual.setBounds(162, 225, 388, 20);
		add(emailAtual);
		
		JLabel perguntaSecretaLabel = new JLabel("Pergunta Secreta: ");
		perguntaSecretaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		perguntaSecretaLabel.setBounds(50, 258, 114, 21);
		add(perguntaSecretaLabel);
		
		perguntaSecreta = new JLabel(user.getPerguntaSecreta());
		perguntaSecreta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		perguntaSecreta.setBounds(162, 259, 388, 17);
		add(perguntaSecreta);
		
		JLabel respostaSecretaLabel = new JLabel("Resposta Secreta: ");
		respostaSecretaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		respostaSecretaLabel.setBounds(50, 290, 124, 21);
		add(respostaSecretaLabel);
		
		respostaSecreta = new JLabel(user.getResposta());
		respostaSecreta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		respostaSecreta.setBounds(162, 289, 388, 21);
		add(respostaSecreta);
	}
	
	private void criaTituloAlterarInfo() {
		JLabel alterarInfoLabel = new JLabel("Alterar Informa\u00E7\u00F5es do Usu\u00E1rio");
		alterarInfoLabel.setFont(new Font("Calibri Light", Font.PLAIN, 43));
		alterarInfoLabel.setBounds(36, 24, 658, 66);
		formularioAlteraInfoPanel.add(alterarInfoLabel);
		
		JLabel horizontaDivisorAlteraInfoLabel = new JLabel("");
		horizontaDivisorAlteraInfoLabel.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/divider.jpg")));
		horizontaDivisorAlteraInfoLabel.setBounds(-20, 75, 658, 21);
		formularioAlteraInfoPanel.add(horizontaDivisorAlteraInfoLabel);
		
		JLabel instrucaoAlteraInfo = new JLabel("Os campos das informações que permanecerão iguais não devem ser alterados.");
		instrucaoAlteraInfo.setBounds(92, 89, 476, 86);
		formularioAlteraInfoPanel.add(instrucaoAlteraInfo);
		instrucaoAlteraInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
	}

	private void criaAlterarInfoLabels() {
		JLabel novoNomeLabel = new JLabel("Nome: ");
		novoNomeLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		novoNomeLabel.setBounds(82, 176, 41, 21);
		formularioAlteraInfoPanel.add(novoNomeLabel);
		
		JLabel novoEmailLabel = new JLabel("Email: ");
		novoEmailLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		novoEmailLabel.setBounds(82, 207, 48, 21);
		formularioAlteraInfoPanel.add(novoEmailLabel);
		
		JLabel novaSenha = new JLabel("Senha: ");
		novaSenha.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		novaSenha.setBounds(82, 238, 41, 21);
		formularioAlteraInfoPanel.add(novaSenha);
		
		JLabel novaPerguntaSecretaLabel = new JLabel("Pergunta Secreta: ");
		novaPerguntaSecretaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		novaPerguntaSecretaLabel.setBounds(21, 269, 114, 21);
		formularioAlteraInfoPanel.add(novaPerguntaSecretaLabel);
		
		JLabel novaRespostaLabel = new JLabel("Resposta Secreta: ");
		novaRespostaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		novaRespostaLabel.setBounds(21, 297, 124, 21);
		formularioAlteraInfoPanel.add(novaRespostaLabel);	
	}
	
	private void criaAlterarInfoFields() {
		recebeNovoNomeField = new JTextField();
		recebeNovoNomeField.setForeground(Color.BLACK);
		recebeNovoNomeField.setColumns(10);
		recebeNovoNomeField.setBounds(131, 176, 437, 20);
		formularioAlteraInfoPanel.add(recebeNovoNomeField);
		
		recebeNovoEmailField = new JTextField();
		recebeNovoEmailField.setForeground(Color.BLACK);
		recebeNovoEmailField.setColumns(10);
		recebeNovoEmailField.setBounds(131, 207, 437, 20);
		formularioAlteraInfoPanel.add(recebeNovoEmailField);
		
		recebeNovaSenhaField = new JPasswordField();
		recebeNovaSenhaField.setBounds(131, 238, 437, 20);
		formularioAlteraInfoPanel.add(recebeNovaSenhaField);
		
		novaPerguntaSecretaComboBox = new JComboBox<String>();
		novaPerguntaSecretaComboBox.setBounds(131, 266, 437, 20);
		novaPerguntaSecretaComboBox.addItem("Qual o nome do seu primeiro animal de estima\u00e7\u00e3o?");
		novaPerguntaSecretaComboBox.addItem("Qual o nome do seu professor favarito(a)?");
		novaPerguntaSecretaComboBox.addItem("Qual o nome do seu melhor amigo(a)?");
		novaPerguntaSecretaComboBox.addItem("Qual a primeira praia que voc\u00ea visitou?");
		novaPerguntaSecretaComboBox.addItem("Qual era seu apelido de inf\u00e2ncia?");
		novaPerguntaSecretaComboBox.addItem("Qual \u00e9 o emprego dos seus sonhos?");
		novaPerguntaSecretaComboBox.addItem("Qual era o modelo do seu primeiro veiculo motorizado?");
		novaPerguntaSecretaComboBox.setSelectedItem(user.getPerguntaSecreta());
		formularioAlteraInfoPanel.add(novaPerguntaSecretaComboBox);
		
		recebNovaRespostaLabel = new JTextField();
		recebNovaRespostaLabel.setForeground(Color.BLACK);
		recebNovaRespostaLabel.setColumns(10);
		recebNovaRespostaLabel.setBounds(131, 297, 437, 20);
		formularioAlteraInfoPanel.add(recebNovaRespostaLabel);
	}
	
	public void refresh() {
		imagemPanel.setVisible(true);
		formularioAlteraInfoPanel.setVisible(false);
		recebeNovoNomeField.setText("");
		recebeNovoEmailField.setText("");
		recebeNovaSenhaField.setText("");
		recebNovaRespostaLabel.setText("");
	}
	
	private void ehVazio() {
		if (!novoNome.equals("")) nomeAtual.setText(novoNome);
		if (!novoEmail.equals("")) emailAtual.setText(novoEmail);
		if (!novaPergunta.equals("")) perguntaSecreta.setText(novaPergunta);
		if (!novaResposta.equals("")) respostaSecreta.setText(novaResposta);
		refresh();
	}
}
