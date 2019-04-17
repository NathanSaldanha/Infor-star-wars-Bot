package repetidorIFCEBot;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class RepetidorIFCEBot extends TelegramLongPollingBot {
	

	
	public void onUpdateReceived(Update update) {
		
		if(update.hasMessage()) {
			
			JSONObject json;
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
			

			String dado = update.getMessage().getText();
			System.out.println(dado);
			dado = dado.toLowerCase(); //Para a string ficar sempre minuscula;
			String[] dados = dado.split("-"); 
			
			
			if(update.getMessage().getText().equals("/start")){
				
				try {
					message.setText("Esta aqui todas a informaçoes de Star Wars\n\n"+"Comandos do bot!\n\n"+"/pessoas-[numero correspondente]\n"+"/planetas-[numero correspondente]\n"+"/naves-[numero correspondente]\n");
					execute(message);
				} catch (TelegramApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(dados[0].equals("pessoa")) {
				try {
					json = JsonReader.readJsonFromUrl("https://swapi.co/api/people/"+dados[1]+"/?format=json");
					
					String nome = json.getString("name");					
					String altura = json.getString("height");
					String cabelo = json.getString("hair_color");					
					String cor_pele = json.getString("skin_color");				
					String massa = json.getString("mass");
					String olhos = json.getString("eye_color");
					String genero = json.getString("gender");
					
					message.setText("Nome: " +nome+"\naltura: " +altura+"\nPeso Corporal: "+massa+"\ncabelo: " +cabelo+"\nCor da pele: " +cor_pele+"\nCor dos olhos: " +olhos+"\nGenero: "+genero);
					
					execute(message);
					
				} catch (JSONException | IOException | TelegramApiException e) {
					e.printStackTrace();
				}
			}else if (dados[0].equals("planeta")) {
				try {
					json = JsonReader.readJsonFromUrl("https://swapi.co/api/planets/"+dados[1]+"/?format=json");
					
					String nome = json.getString("name");
					String periodo_rota = json.getString("rotation_period");
					String orbita = json.getString("orbital_period");
					String diametro = json.getString("diameter");
					String clima = json.getString("climate");
					String gravidade = json.getString("gravity");
					String solo = json.getString("terrain");
					String agua = json.getString("surface_water");
					String populacao = json.getString("population");
				
					
					message.setText("nome: "+nome+"\nperiodo rotaçao: "+periodo_rota+" Horas"+"\nOrbita do planeta: "+orbita+" Dias"+"\ndiametro: "+diametro+" km"+"\nclima: "+clima+"\ngravidade: "+gravidade+"\nsolo: "+solo+"\nComposição de agua na superficie: "+agua+"%"+"\npopulacao: "+populacao);
					execute(message);
					
					
				} catch (JSONException | IOException  | TelegramApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if (dados[0].equals("nave")) {
				try {
					json = JsonReader.readJsonFromUrl("https://swapi.co/api/starships/"+dados[1]+"/?format=json");
					
					String nome = json.getString("name");
					String modelo = json.getString("model");
					String fabricante = json.getString("manufacturer");
					String custo = json.getString("cost_in_credits");
					String comprimento = json.getString("length");
					String velocidadeMaxima = json.getString("max_atmosphering_speed");
					String equipeTecnica = json.getString("crew");
					String qtdPassageiros = json.getString("passengers");
					String cargaMaxima = json.getString("cargo_capacity");
					String tempoUso = json.getString("consumables");
					String motorHyperdriver = json.getString("hyperdrive_rating");
					String velocidadeMGLT = json.getString("MGLT");
					String classe_nave = json.getString("starship_class");
					
					message.setText("nome: "+nome+"\nModel: "+modelo+"\nFabricante: "+fabricante+"\nValor: "+custo+"\nTamanho"+comprimento+"m"+"\nVelocidade Maxima: "+velocidadeMaxima+"km/h"+"\nEquipe Tecnica: "+equipeTecnica+"\nQuantidade de passageiros: "+qtdPassageiros+"\nCarga Maxima: "+cargaMaxima+"\nTempo estimado de uso: "+tempoUso+"\nMotores hyperdrive :"+motorHyperdriver+"\nvelocidade MGLT:"+velocidadeMGLT+"Classe da nave: "+classe_nave);
					execute(message);
					
					
				} catch (JSONException | IOException | TelegramApiException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			


		}	
	}

	// Esse metodo deve sermpre retornar o username do seu Bot
	public String getBotUsername() {

		return "ifce_star_wars_bot";
	}

	// Esse metodo deve sempre retornar o token do seu bot
	@Override
	public String getBotToken() {

		return "826704287:AAGdemwhUhylJn0nz7hV6ANidQGRclFh19M";
	}
}
