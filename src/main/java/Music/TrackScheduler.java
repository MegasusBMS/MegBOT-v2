package Music;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason;

import MegasusBOT.MegasusBOT;
import MegasusBOT.Play;
import MegasusBOT.commands;
import net.dv8tion.jda.api.managers.AudioManager;

public class TrackScheduler extends AudioEventAdapter {
	private final AudioPlayer player;
	public AudioManager am;
	public BlockingQueue<AudioTrack> queue;
	public static List<AudioTrack> tracks;
	public static boolean start = false;

	public TrackScheduler(AudioPlayer player,AudioManager am) {
		this.player = player;
		this.queue = new LinkedBlockingQueue<AudioTrack>();
		this.am = am;
	}

	public void queue(AudioTrack track) {
		if (!player.startTrack(track, true)) {
			queue.offer(track);
		}
	}

	public void queueclear() {
		tracks = new ArrayList<AudioTrack>(queue);
		queue.clear();
	}

	public void reloadqueue() {
		queue.clear();
		for (int i = 0; i < tracks.size(); i++) {
			String[] song = (MegasusBOT.prefix + "play " + tracks.get(i).getInfo().title).split(" ");
			new Play(song, commands.e, false);
		}
	}

	public BlockingQueue<AudioTrack> getQueue() {
		return queue;
	}

	/**
	 * Start the next track, stopping the current one if it is playing.
	 */
	public void nextTrack() {
		player.playTrack(queue.poll());
		//player.startTrack(queue.poll(), false);
	}

	@Override
	public void onTrackEnd(AudioPlayer player, AudioTrack track, AudioTrackEndReason endReason) {
		if (endReason.mayStartNext)
			nextTrack();
	}
}