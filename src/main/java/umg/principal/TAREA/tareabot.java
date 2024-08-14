package umg.principal.TAREA;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class tareabot extends TelegramLongPollingBot {


    LocalDateTime fechaYHoraActual = LocalDateTime.now();



    @Override
    public String getBotUsername() {
        return "Roseni98_bot";
    }

    @Override
    public String getBotToken() {
        return "7487483882:AAHq2sNkcExdxXwMLs7JFNvICgKX_NAl4bQ";
    }



//El método onUpdateReceived(Update update) de la clase Bot se usa para manejar todas las actualizaciones que el
// bot recibe.
// Dependiendo del tipo de actualización, se toman diferentes acciones.

    @Override
    public void onUpdateReceived(Update update) {


        //Se verifica si la actualización contiene un mensaje y si ese mensaje tiene texto.
        //Luego se procesa el contenido del mensaje y se responde según el caso.

        String nombre = update.getMessage().getFrom().getFirstName();
        String apellido = update.getMessage().getFrom().getLastName();
        String nickname = update.getMessage().getFrom().getUserName();

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            //codigo en telefono
            if (message_text.toLowerCase().equals("/info")) {
                sendText(chat_id, "0905-17-1079  Roseni Barillas  Cuarto Semestre");
            }

            if (message_text.toLowerCase().equals("/progra")) {
                sendText(chat_id, "programar es muy dificil  ");
            }
            if (message_text.toLowerCase().equals("/hola")) {
                sendText(chat_id, "Hola" + nombre + " La fecha de hoy es:" + fechaYHoraActual);
            }

            if (message_text.toLowerCase().startsWith("/cambio")) {

                String[] parts = message_text.split(" ");
                if (parts.length == 2) {
                    String numero = parts[1].toLowerCase();
                    double euro = 8.45;
                    double resultado = Integer.parseInt(numero) * euro;
                    sendText(chat_id, "la cantidad de: " + numero + " tiene un valor de: " + resultado);
                } else {
                    sendText(chat_id, "No colocaste numero para cambio");
                }
            }
            if (message_text.toLowerCase().startsWith("/grupo")){

            List<Long> Ids = new ArrayList<>(List.of( 5481012733L, 1510734672L, 6308317056L, 642182669L));

            //6308317056L
                //642182669L
            String[] parts = message_text.split(" ", 2);
            if (parts.length == 2) {
                String mensaje = parts[1];

                for (Long Id : Ids) {

                    sendText(Id, mensaje);
                }
            }

            } else {
                sendText(chat_id, "Use: /grupal + (mensaje)");
            }

        }

    }
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }




}
