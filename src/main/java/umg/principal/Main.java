package umg.principal;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import umg.principal.TAREA.tareabot;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            TelegramBotsApi botApi = new TelegramBotsApi(DefaultBotSession.class);
            tareabot mibot = new tareabot();
            botApi.registerBot(mibot);
            System.out.println("se esta ejecutando");

        }catch (Exception a) {
            System.out.println("error");
        }

    }
}