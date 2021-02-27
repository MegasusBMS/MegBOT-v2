package MegasusBOT;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class test {

	/*
	msg - Usage: !msg<tag> <message>
	help - Usage: !help [command]
	set - Usage: 
	!set channel <YourChannelName>
	!set botname <YourBotName>
	!set lang <it,en,de,pt,ro,cz,fr,tr,vn,ru> (One of this options)
	unlink - Usage: !unlink <minecraftUsername>
	alert - Usage: !alert <message>
	link - Usage: !link <minecraftUsername>
	funlink - Usage: !funlink <minecraftUsername>
	user - Usage: !user <minecraftUsername>
	uptime - Usage: !uptime*/
	
	
	
	public test(GuildMessageReceivedEvent event) {
		EmbedBuilder h = new EmbedBuilder();
		h.setTitle(":page_with_curl: Command list:");
		h.appendDescription("**command**\n ->Despription\n\n");
		h.appendDescription("**command**\n ->Despription\n\n");
		h.appendDescription("**command**\n ->Despription\n\n");
		h.appendDescription("**command**\n ->Despription\n\n");
		h.appendDescription("**command**\n ->Despription\n\n");
		event.getChannel().sendMessage(h.build()).queue();
		
	}

}
