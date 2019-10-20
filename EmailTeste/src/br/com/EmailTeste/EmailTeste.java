package br.com.EmailTeste;

import br.com.ConexaoBanco.*;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailTeste {

	public static void main(String[] args) {
		ConexaoMySQL conexaoBanco = new ConexaoMySQL();
		conexaoBanco.conectar();
		if (conexaoBanco.estaConectado()) {
			//conexaoBanco.listarBoletosNaoBaixados();
			//conexaoBanco.inserirContato("nome", "telefone");
			//conexaoBanco.editarContato("id", "nome", "telefone");
			//conexaoBanco.excluirContato("id");

			final String username = "email";
			final String password = "senha";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "");
			props.put("mail.smtp.port", "");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("email"));
				message.setSubject("Teste do email sendo enviado por java");
				message.setText("Olá.!! Esta e-mail foi enviado usando javamail");

				Transport.send(message);

				System.out.println("Pronto!");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

			conexaoBanco.desconectar();
		} else {
			System.out.println("Não está conectado com o banco de dados!");
		}

	}

}
