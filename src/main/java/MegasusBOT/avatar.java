package MegasusBOT;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class avatar {
	public avatar(GuildMessageReceivedEvent event) {
		String nick="";
		String image="";
		String m = event.getMessage().getContentRaw();
		boolean ok =true;
		if(m.split(" ").length>1){
			for(int i=0;i<event.getGuild().getMembers().size();i++)
			if(m.split(" ")[1].equalsIgnoreCase(event.getGuild().getMembers().get(i).getUser().getName())){
				nick = event.getGuild().getMembers().get(i).getUser().getName();
				image = event.getGuild().getMembers().get(i).getUser().getAvatarUrl();
				ok=false;
				break;
			}
			if(ok){
				if(event.getMessage().getMentionedMembers().size()>0){
			nick = event.getMessage().getMentionedMembers().get(0).getUser().getName();
			image = event.getMessage().getMentionedMembers().get(0).getUser().getAvatarUrl();
				}else{
					EmbedBuilder e = new EmbedBuilder();
					e.setTitle(":no_entry:** I can't find :**"+m.split(" ")[1]);
					event.getChannel().sendMessage(e.build()).queue();
					return;
				}
			}
		}else{
			nick = event.getAuthor().getName();
			image = event.getAuthor().getAvatarUrl();
		}
		EmbedBuilder e = new EmbedBuilder();
		e.setTitle("**"+nick+"**");
		e.setImage(image);
		event.getChannel().sendMessage(e.build()).queue();
	}
}
