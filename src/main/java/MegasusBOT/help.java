package MegasusBOT;

import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class help extends ListenerAdapter {
	public help(GuildMessageReceivedEvent event) {
		EmbedBuilder help = new EmbedBuilder();
		String m = event.getMessage().getContentRaw();
		boolean b;
		if(m.equalsIgnoreCase("$help")){
			event.getChannel().sendMessage(":white_check_mark:").queue();
			b=true;
		}
		else{
			event.getChannel().sendMessage(":x:").queue();
			MegasusBOT.x++;
			b=false;
			if(MegasusBOT.x%5==0){
				b=true;
				MegasusBOT.x=0;
			}
		}
		List<Message> Messages = event.getChannel().getHistory().retrievePast(2).complete();
		event.getChannel().deleteMessages(Messages).queue();
		help.setTitle(":sos: Help!");
		help.setDescription(
				  "**Channel:** clear .\n"
				+ "**Administrative:** status, role, roles .\n"
				+ "**Music:** join, leave, play, stop, volume, skip, repeat, next, nowplay, queue .\n"
				+ "**Meme:** meme .\n"
				+ "**LeagueOfLegends:** lol, lol profile,lol add, lol remove, lol live.\n"
				+ "**Other:** profile, avatar .\n"
				+ "**Support: Megasus#4837** .\n\n");
		help.setFooter("We are in "+event.getJDA().getGuilds().size()+" Discord Servers");
		if(b)
		event.getChannel().sendMessage(help.build()).queue();
	}
}
