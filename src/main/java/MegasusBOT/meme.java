package MegasusBOT;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class meme {
	@SuppressWarnings("unchecked")
	public meme(GuildMessageReceivedEvent e){
        JSONParser parser = new JSONParser();
        String postLink = "";
        String title = "";
        String url = "";
		try {
            URL memeURL = new URL("https://meme-api.herokuapp.com/gimme");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(memeURL.openConnection().getInputStream()));

            String lines;
            while ((lines = bufferedReader.readLine()) != null){
                JSONArray array = new JSONArray();
                array.add(parser.parse(lines));

                for (Object o : array) {
                    JSONObject jsonObject = (JSONObject) o;

                    postLink = (String) jsonObject.get("postLink");
                    title = (String) jsonObject.get("title");
                    url = (String) jsonObject.get("url");
                }
            }
            bufferedReader.close();
            
            EmbedBuilder builder = new EmbedBuilder().setTitle(title, postLink).setImage(url).setColor(Color.ORANGE);
			e.getChannel().sendMessage(builder.build()).queue();

        } catch (Exception ex) {
        	e.getChannel().sendMessage(":no_entry: **Hey, something went wrong. Please try again later!**").queue();
			ex.printStackTrace();
        }
	}
}