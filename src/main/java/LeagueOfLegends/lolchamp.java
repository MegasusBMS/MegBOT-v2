package LeagueOfLegends;

import Json.LolChampion;
import MegasusBOT.commands;
import net.dv8tion.jda.api.EmbedBuilder;

public class lolchamp {
	lolchamp(String[] args){
		String name=commands.e.getMessage().getContentRaw().substring((args[0]+args[1]).length()+2);
		name=LolChampion.ObjectByName("name", name);
		String t = name;
		if(name.contains(" ")){
			String[]x = name.split(" ");
			name = x[0]+x[1];
		}else
		if(name.contains("\'")){
			String[]x=name.split("\'");
			name = x[0]+x[1];
		}
		EmbedBuilder c = new EmbedBuilder();
		if(LolChampion.ObjectByName("emote", name)!=null)
			c.setTitle("<:"+LolChampion.ObjectByName("id", t)+":"+LolChampion.ObjectByName("emote", t)+">"+LolChampion.ObjectByName("name", t)+", "+LolChampion.ObjectByName("title", t)+" (patch 9.18.1)");
		else
		c.setTitle(name+", "+LolChampion.ObjectByNamePatch("title", name)+" (patch 10.7.1)");
		try{
		c.setThumbnail(LolChampion.ObjectByName("icon", t));
		}catch(IllegalArgumentException e){
			EmbedBuilder x = new EmbedBuilder();
			x.setTitle("This champ not exist");
			commands.e.getChannel().sendMessage(x.build()).queue();
			return;
		}
		c.appendDescription("Champ: "+ LolChampion.ObjectByName("name", t) +"\n");
		c.setFooter(LolChampion.ObjectByName("description", t));
		c.appendDescription("Tags : "+LolChampion.TagsbyName(name)+"\n");
		c.addField("StartStatus", "HP:\n"
				+ "DMG:\n"
				+ "Mana\n"
				+ "Armor:\n"
				+ "MagicR.:\n"
				+ "Range:\n"
				+ "HPRegen:\n"
				+ "ManaRegen:\n", true);
		float s[] = {0,0,0,0,0,0,0,0};
		float ls[] = {0,0,0,0,0,0,0,0};
		
		s[0]= Float.valueOf(LolChampion.StatusByName("hp", name).toString());
		s[1]= Float.valueOf(LolChampion.StatusByName("attackdamage", name).toString());
		s[2]= Float.valueOf(LolChampion.StatusByName("mp", name).toString());
		s[3]= Float.valueOf(LolChampion.StatusByName("armor", name).toString());
		s[4]= Float.valueOf(LolChampion.StatusByName("spellblock", name).toString());
		s[5]= Float.valueOf(LolChampion.StatusByName("attackrange", name).toString());
		s[6]= Float.valueOf(LolChampion.StatusByName("hpregen", name).toString());
		s[7]= Float.valueOf(LolChampion.StatusByName("mpregen", name).toString());
		ls[0]= Float.valueOf(LolChampion.LastStatusByName("hp", name).toString());
		ls[1]= Float.valueOf(LolChampion.LastStatusByName("attackdamage", name).toString());
		ls[2]= Float.valueOf(LolChampion.LastStatusByName("mp", name).toString());
		ls[3]= Float.valueOf(LolChampion.LastStatusByName("armor", name).toString());
		ls[4]= Float.valueOf(LolChampion.LastStatusByName("spellblock", name).toString());
		ls[5]= Float.valueOf(LolChampion.LastStatusByName("attackrange", name).toString());
		ls[6]= Float.valueOf(LolChampion.LastStatusByName("hpregen", name).toString());
		ls[7]= Float.valueOf(LolChampion.LastStatusByName("mpregen", name).toString());
		String lsl[]={"","","","","","","",""};
		for(int i=0;i<8;i++){
			if(s[0]>ls[0])
				lsl[i]=">";
			else
				if(s[i]==ls[i])
					lsl[i]="=";
				else
					lsl[i]="<";
		}
		c.addField("Patch 10.7.1", "**"+s[0]+"\n"
				+ s[1]+"\n"
				+ s[2]+"\n"
				+ s[3]+"\n"
				+ s[4]+"\n"
				+ s[5]+"\n"
				+ s[6]+"\n"
				+ s[7]+"\n**", true);
		c.addField("Patch 10.6.1", "**"+lsl[0]+" "+ls[0]+"\n"
				+ lsl[1]+" "+ls[1]+"\n"
				+ lsl[2]+" "+ls[2]+"\n"
				+ lsl[3]+" "+ls[3]+"\n"
				+ lsl[4]+" "+ls[4]+"\n"
				+ lsl[5]+" "+ls[5]+"\n"
				+ lsl[6]+" "+ls[6]+"\n"
				+ lsl[7]+" "+ls[7]+"\n**", true);
		commands.e.getChannel().sendMessage(c.build()).queue();
	}
}
