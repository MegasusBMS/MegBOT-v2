package MegasusBOT;

import javax.security.auth.login.LoginException;

import com.jagrosh.jdautilities.command.CommandClientBuilder;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class MegasusBOT{public MegasusBOT() {
	// TODO Auto-generated constructor stub
}
	public static JDA jda;
	public static String prefix = "$";
	static int x = 0;
	
	public static void main(String[] args) throws LoginException {
		jda = new JDABuilder(AccountType.BOT).setToken("NjAzNDc2MzI0MTk1MjM3OTA4.Xp2yew.4CQ7EEvJYGivzad8HUXURkpu4eo").build();
		CommandClientBuilder b = new CommandClientBuilder();
		b.setPrefix("$");
		b.setOwnerId("305359668061011968");
		b.setStatus(OnlineStatus.ONLINE);
		b.build();
		jda.addEventListener(new commands());
	}
}