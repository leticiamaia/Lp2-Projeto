package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import projetoLp2.bolao.Jogador;

public class AlterarInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -337804168890997381L;
	private JTextField recebeNovoNomeField;
	private JTextField recebeNovoEmailField;
	private JPasswordField recebeNovaSenhaField;
	private JTextField recebNovaRespostaLabel;
	private JPanel imagemPanel;
	private JPanel formularioAlteraInfoPanel;
	private Jogador user;

	/**
	 * Create the panel.
	 * @param usuario 
	 */
	public AlterarInfoPanel(Jogador usuario) {
		user = usuario;
		setBackground(Color.WHITE);
		setBounds(0, 0, 1284, 640);
		setLayout(null);
		
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
		
		formularioAlteraInfoPanel = new JPanel();
		formularioAlteraInfoPanel.setBackground(Color.WHITE);
		formularioAlteraInfoPanel.setBounds(626, 11, 648, 606);
		formularioAlteraInfoPanel.setVisible(false);
		add(formularioAlteraInfoPanel);
		formularioAlteraInfoPanel.setLayout(null);
		
		criaTituloAlterarInfo();
		
		
		recebeNovoNomeField = new JTextField();
		recebeNovoNomeField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				recebeNovoNomeField.setText(null);
			}
		});
		
		criaAlterarInfoLabels();		
		criaAlterarInfoFields();		
		
		JButton botaoConfirmar = new JButton(" Confirmar");
		botaoConfirmar.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/tick.png")));
		botaoConfirmar.setBounds(189, 369, 121, 34);
		formularioAlteraInfoPanel.add(botaoConfirmar);
		
		JButton botaoCancelar = new JButton(" Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagemPanel.setVisible(true);
				formularioAlteraInfoPanel.setVisible(false);
			}
		});
		botaoCancelar.setIcon(new ImageIcon(AlterarInfoPanel.class.getResource("/projetoLp2/bolao/docs/cancel.png")));
		botaoCancelar.setBounds(367, 369, 121, 34);
		formularioAlteraInfoPanel.add(botaoCancelar);
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
		nomeAtualLabel.setBounds(102, 192, 41, 21);
		add(nomeAtualLabel);
		
		JLabel nomeAtual = new JLabel(user.getNome());
		nomeAtual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nomeAtual.setBounds(153, 195, 388, 14);
		add(nomeAtual);
		
		JLabel emailAtualLabel = new JLabel("Email: ");
		emailAtualLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		emailAtualLabel.setBounds(107, 224, 48, 21);
		add(emailAtualLabel);
		
		JLabel emailAtual = new JLabel(user.getEmail());
		emailAtual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailAtual.setBounds(153, 227, 388, 14);
		add(emailAtual);
		
		JLabel perguntaSecretaLabel = new JLabel("Pergunta Secreta: ");
		perguntaSecretaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		perguntaSecretaLabel.setBounds(41, 256, 114, 21);
		add(perguntaSecretaLabel);
		
		JLabel perguntaSecreta = new JLabel(user.getPerguntaSecreta());
		perguntaSecreta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		perguntaSecreta.setBounds(153, 259, 388, 14);
		add(perguntaSecreta);
		
		JLabel respostaSecretaLabel = new JLabel("Resposta Secreta: ");
		respostaSecretaLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		respostaSecretaLabel.setBounds(41, 288, 124, 21);
		add(respostaSecretaLabel);
		
		JLabel respostaSecreta = new JLabel(user.getResposta());
		respostaSecreta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		respostaSecreta.setBounds(153, 291, 388, 14);
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
		
		JLabel instrucaoAlteraInfo = new JLabel("Os campos das informações que permanecerão iguais não devem ser preenchidos.");
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
		recebeNovoNomeField.setText("Digite seu nome aqui");
		recebeNovoNomeField.setForeground(Color.LIGHT_GRAY);
		recebeNovoNomeField.setColumns(10);
		recebeNovoNomeField.setBounds(131, 176, 437, 20);
		formularioAlteraInfoPanel.add(recebeNovoNomeField);
		
		recebeNovoEmailField = new JTextField();
		recebeNovoEmailField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				recebeNovoEmailField.setText(null);
			}
		});
		recebeNovoEmailField.setText("Digite seu novo email");
		recebeNovoEmailField.setForeground(Color.LIGHT_GRAY);
		recebeNovoEmailField.setColumns(10);
		recebeNovoEmailField.setBounds(131, 207, 437, 20);
		formularioAlteraInfoPanel.add(recebeNovoEmailField);
		
		recebeNovaSenhaField = new JPasswordField();
		recebeNovaSenhaField.setBounds(131, 238, 437, 20);
		formularioAlteraInfoPanel.add(recebeNovaSenhaField);
		
		JComboBox<Object> novaPerguntaSecretaComboBox = new JComboBox<Object>();
		novaPerguntaSecretaComboBox.setBounds(131, 266, 437, 20);
		novaPerguntaSecretaComboBox.addItem("Qual o nome do seu primeiro animal de estima\u00e7\u00e3o?");
		novaPerguntaSecretaComboBox.addItem("Qual o nome do seu professor favarito(a)?");
		novaPerguntaSecretaComboBox.addItem("Qual o nome do seu melhor amigo(a)?");
		novaPerguntaSecretaComboBox.addItem("Qual a primeira praia que voc\u00ea visitou?");
		novaPerguntaSecretaComboBox.addItem("Qual era seu apelido de inf\u00e2ncia?");
		novaPerguntaSecretaComboBox.addItem("Qual \u00e9 o emprego dos seus sonhos?");
		novaPerguntaSecretaComboBox	.addItem("Qual era o modelo do seu primeiro veiculo motorizado?");
		formularioAlteraInfoPanel.add(novaPerguntaSecretaComboBox);
		
		recebNovaRespostaLabel = new JTextField();
		recebNovaRespostaLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				recebNovaRespostaLabel.setText(null);
			}
		});
		recebNovaRespostaLabel.setText("Digite sua nova resposta secreta aqui");
		recebNovaRespostaLabel.setForeground(Color.LIGHT_GRAY);
		recebNovaRespostaLabel.setColumns(10);
		recebNovaRespostaLabel.setBounds(131, 297, 437, 20);
		formularioAlteraInfoPanel.add(recebNovaRespostaLabel);
	}
}
