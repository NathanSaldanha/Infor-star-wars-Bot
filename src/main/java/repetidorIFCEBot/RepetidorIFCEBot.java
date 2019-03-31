package repetidorIFCEBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RepetidorIFCEBot extends TelegramLongPollingBot {
	public void onUpdateReceived(Update update) {

		// Chegando se a atualizacao (update) tem uma mensagem e se a mensagem tem texto
		if (update.hasMessage() && update.getMessage().hasText()) {

			// Instancia um objeto SendMessage com os campos que são OBRIGATORIOS
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
					.setText(update.getMessage().getText());
			try {

				// Chama o metodo para enviar mensagem
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	// Esse metodo deve sermpre retornar o username do seu Bot
	public String getBotUsername() {

		return "repetidor_ifce_bot";
	}

	// Esse metodo deve sempre retornar o token do seu bot
	@Override
	public String getBotToken() {

		return "850229532:AAHr5ox4Oo4_AzAYdMzTTJ07Hr-Bi7NC2Mc";
	}
}
