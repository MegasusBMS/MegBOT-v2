package LeagueOfLegends;

import MegasusBOT.MegasusBOT;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class lolhelp {
	public lolhelp(GuildMessageReceivedEvent event) {
		EmbedBuilder help = new EmbedBuilder();
		help.setTitle(":sos: (!!!BETA!!!) League of Legends commands:");
		help.setDescription("lol add (region) (summoner)           **->** link your summoner on discordID \n"
							+ "lol remove 				           **->** unlink your summoner from discordID\n"
							+ "lol profile / p 			           **->** show your Lol profile\n"
							+ "lol profile / p (region) (summoner) **->** show the Lol profile of that summoner\n"
							+ "lol live                            **->** show your live game\n"
							+ "lol live (regiun) (summoner)        **->** show the live game of that summoner");
		event.getChannel().sendMessage(help.build()).queue();
	}
}
