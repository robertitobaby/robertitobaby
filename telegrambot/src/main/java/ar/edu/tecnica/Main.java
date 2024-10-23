package ar.edu.tecnica;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main extends TelegramLongPollingBot {

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Main());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String command = update.getMessage().getText();
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

            switch (command) {
                case "/ayuda":
                	//TODO Completar el mensaje de ayuda
                    message.setText("Los comandos válidos son: /ayuda, ...");
                    System.out.println("/ayuda");
                    break;

                case "/autor":
                	//TODO Completar con nombre y apellido
                    message.setText("Este bot fue creado por ... (nombre y apellido del alumno)");
                    System.out.println("/autor");
                    break;

                //TODO agregar 10 comandos

                default:
                    message.setText("No entiendo ese comando.");
                    System.out.println("Comando no válido");
                    break;
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return System.getenv("TELEGRAM_BOTNAME");
    }

    @Override
    public String getBotToken() {
        return System.getenv("TELEGRAM_APITOKEN");
    }

}
