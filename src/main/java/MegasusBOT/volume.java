package MegasusBOT;

import Music.PlayerManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class volume {

	public volume(String[] args, GuildMessageReceivedEvent event) {
		PlayerManager mm = PlayerManager.getInstance();
		try{
			if(args.length==1){
				EmbedBuilder v = new EmbedBuilder();
				v.setTitle(":no_entry: Please provide volume level");
				event.getChannel().sendMessage(v.build()).queue();
				return;
			}
		int volum = Integer.parseInt(args[1]);

		EmbedBuilder v = new EmbedBuilder();
		if(volum>50&&!event.getMember().hasPermission(Permission.MANAGE_CHANNEL)){
			v.setTitle(":cry: Maxim volume for you is 50");
			event.getChannel().sendMessage(v.build()).queue();
			return;
		}else{
			if(volum>100){
				event.getChannel().sendMessage("Maxim volume is 100").queue();
				v.setTitle(":ear: :boom: Maxim volume 100");
				v.setDescription("Trust me you don't want more then 100");
				event.getChannel().sendMessage(v.build()).queue();
				return;
			}
		}
		if(volum<1){
			v.setTitle(":x: Minimum volume is 1");
			event.getChannel().sendMessage(v.build()).queue();
			return;
		}
		mm.getGuildMusicManager(event.getGuild()).player.setVolume(volum*2);
		v.setTitle(":white_check_mark: Volume set to: "+ volum);
		event.getChannel().sendMessage(v.build()).queue();
		}catch(NumberFormatException e){
			EmbedBuilder v = new EmbedBuilder();
			v.setTitle(":cry: Something went rong!");
			v.setDescription(args[1]+ " is not a number");
			event.getChannel().sendMessage(v.build()).queue();
			return;
		}
	}
}
