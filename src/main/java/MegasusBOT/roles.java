package MegasusBOT;


import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class roles {
	public roles(GuildMessageReceivedEvent event) {
		Message m = event.getMessage();
		Member me = null;
		List<Role> r = new ArrayList<Role>();
		boolean ok =true;
		if(m.getContentRaw().split(" ").length>1){
			for(int i=0;i<event.getGuild().getMembers().size();i++)
			if(m.getContentRaw().split(" ")[1].equalsIgnoreCase(event.getGuild().getMembers().get(i).getUser().getName())){
				r = event.getGuild().getMembers().get(i).getRoles();
				me =  event.getGuild().getMembers().get(i);
				ok=false;
				break;
			}
			if(ok){
				if(m.getMentionedMembers().size()>0){
					r = m.getMentionedMembers().get(0).getRoles();
					me = m.getMentionedMembers().get(0);
				}else{
					EmbedBuilder e = new EmbedBuilder();
					e.setTitle(":no_entry:** I can't find :**"+m.getContentRaw().split(" ")[1]);
					event.getChannel().sendMessage(e.build()).queue();
					return;
				}
			}
		}else{
			r = event.getMember().getRoles();
			me = event.getMember();
		}
		EmbedBuilder e = new EmbedBuilder();
		e.setTitle("**Roles of "+me.getEffectiveName()+"**");
		if(r.size()==0)
			e.setDescription("**No roles**");
		else{
			for(int i=0;i<r.size();i++){
				e.appendDescription(r.get(i).getAsMention()+"\n");
			}
		}
		event.getChannel().sendMessage(e.build()).queue();
	}
}
