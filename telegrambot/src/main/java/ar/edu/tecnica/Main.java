package ar.edu.tecnica;
import java.util.Random;

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
                    message.setText("Mis comandos válidos son: /infodelbot, /azar, /autor, /chistes, /Personajes, /San Martín, /Spider-Man, /Jesucristo, /Osama Bin Laden ");
                    System.out.println("/ayuda");
                    break;

                case "/autor":
                	//TODO Completar con nombre y apellido
                    message.setText("Este bo"
                    		+ "t fue creado por:  roberth fernández");
                    System.out.println("/autor");
                    break;
                
                case "/infodelbot":
                	message.setText("Yo soy robflop, contengo información super  útil y un poco de diversión, puedes consultar mis otras funcionalidades en /ayuda");
                	break;
                	
                case "/azar":
                	String[] carasello = {"cara", "cruz"};
                	
                	Random rand = new Random();
                	
                	int indice = rand.nextInt(carasello.length);
                	String aleatorio = carasello[indice];
                	message.setText("la moneda a caído y es: "+ aleatorio);
                	break;
                case "/chistes":
                	 String[] chistes = {
                	            "¿Por qué el libro de matemáticas está triste? Porque tenía muchos problemas.",
                	            "¿Qué hace una abeja en el gimnasio? ¡Zum-ba!",
                	            "¿Cómo se llama un boomerang que no vuelve? Un palo.",
                	            "¿Por qué los pájaros no usan Facebook? Porque ya tienen Twitter.",
                	            "¿Cuál es el colmo de un electricista? No encontrar su corriente de trabajo.",
                	            "¿Por qué el perro se sentó en el reloj? Porque quería ser un perro de tiempo completo.",
                	            "¿Qué le dijo un gusano a otro gusano? ¡Voy a dar una vuelta a la manzana!",
                	            "¿Por qué el café está triste? Porque se siente espresso.",
                	            "¿Cómo se llama un dinosaurio con un vocabulario extenso? Un thesaurus.",
                	            "¿Cuál es el colmo de un carpintero? No poder encontrar su madera."
                	        };
                	 Random chiste = new Random();
                	 
                	 int osi = chiste.nextInt(chistes.length);
                	 String michiste = chistes[osi];
                	message.setText(michiste);
                	
                	break;
                case "/Personajes":
                	message.setText("Tenemos varios personajes: /San_Martín, /SpiderMan, /Jesucristo, /Osama_Bin_laden /Rayo_Mcqueen");
                	
                	break;
                case "/San_Martín":
                	message.setText("José de San Martín fue un líder militar argentino que luchó por la independencia de Argentina, Chile y Perú del dominio español. Es conocido por su estratégica cruza de los Andes y por ser una figura clave en la liberación de Sudamérica. Se retiró a Europa después de alcanzar sus objetivos y murió en 1850.");
                	break;
                case "/SpiderMan":
                	message.setText("Spider-Man, creado por Stan Lee y Steve Ditko, es un superhéroe de Marvel. Su identidad secreta es Peter Parker, un joven que obtiene habilidades arácnidas tras ser mordido por una araña radiactiva. Lucha contra el crimen en Nueva York, enfrentando a villanos como el Duende Verde y Doctor Octopus, mientras lidia con su vida personal y la responsabilidad de sus poderes.");
                	break;
                case "/Jesucristo":
                	message.setText("Jesucristo fue un líder religioso y la figura central del cristianismo. Nació en Judea, en el siglo I, y predicó el amor, el perdón y la salvación. Realizó milagros, fue crucificado y resucitó, según la creencia cristiana. Su vida y enseñanzas influyeron profundamente en la religión y la cultura mundial.");
                	break;
                case "/Osama_Bin_Laden":
                	message.setText("Osama bin Laden fue el fundador y líder de Al Qaeda, la organización terrorista responsable de los atentados del 11 de septiembre de 2001 en Estados Unidos. Nació en Arabia Saudita en 1957 y se convirtió en un prominente enemigo de Occidente. Fue asesinado en 2011 por fuerzas especiales de Estados Unidos en Pakistán.");
                	break;
                case "/Rayo_Mcqueen":
                	message.setText("Rayo McQueen es el protagonista de la película de animación Cars de Disney-Pixar. Es un coche de carreras ambicioso y competitivo que, tras un accidente en una carrera importante, aprende sobre la amistad, la humildad y el trabajo en equipo en el pueblo de Radiador Springs. A lo largo de la saga, McQueen evoluciona de ser un egoísta a convertirse en un mentor para nuevas generaciones de corredores.");
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
