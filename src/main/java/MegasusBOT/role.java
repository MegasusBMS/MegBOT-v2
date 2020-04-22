package MegasusBOT;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class role {
	public role(GuildMessageReceivedEvent event) {
		Message m = event.getMessage();
		List<Member> me = new ArrayList<Member>();
		Role r = null;
		boolean ok = true;
		int k = 0;
		if (event.getGuild().getRoles().size() > 0) {
			if (m.getContentRaw().split(" ").length > 1) {
				for (int i = 0; i < event.getGuild().getRoles().size(); i++) {
					if (event.getGuild().getRoles().get(i).getName().contains(m.getContentRaw().split(" ")[1])) {
						ok = false;
						r = event.getGuild().getRoles().get(i);
						break;
					}
					if (ok)
						if (m.getMentionedRoles().size() > 0) {
							r = m.getMentionedRoles().get(0);
						}
				}
			} else {
				EmbedBuilder e = new EmbedBuilder();
				e.setTitle(":no_entry: **You must provide a role**");
				event.getChannel().sendMessage(e.build()).queue();
				return;
			}
			for (int j = 0; j < event.getGuild().getMembers().size(); j++) {
				for (int z = 0; z < event.getGuild().getMembers().get(j).getRoles().size(); z++) {
					if (event.getGuild().getMembers().get(j).getRoles().get(z) == r) {
						me.add(event.getGuild().getMembers().get(j));
						k++;
						break;
					}
				}
			}if(r==null){
				EmbedBuilder e = new EmbedBuilder();
			}
			EmbedBuilder e = new EmbedBuilder();
			e.setTitle("**Role: **" + r.getName());
			for (int i = 0; i < me.size(); i++) {
				e.appendDescription(me.get(i).getAsMention());
				if ((i+1) % 3 == 0)
					e.appendDescription("\n");
				else
					e.appendDescription("\t");
			}
			e.setFooter(k + " Members have this roles");
			event.getChannel().sendMessage(e.build()).queue();
		} else {
			EmbedBuilder e = new EmbedBuilder();
			e.setTitle(":no_entry: **Server don't have role**");
			event.getChannel().sendMessage(e.build()).queue();
		}
	}
}
