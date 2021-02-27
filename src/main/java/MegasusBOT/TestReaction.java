package MegasusBOT;

import java.awt.Event;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;

public class TestReaction {
	public void onGuildMessageReactionAddEvent(GuildMessageReactionAddEvent e){
		if(e.getMember().getUser().equals(e.getJDA().getSelfUser())){
			//e.getChannel().message
		}
	}
}
