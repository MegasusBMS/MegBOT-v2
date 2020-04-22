package Music;

import java.util.concurrent.CompletableFuture;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;

public class Spotify {
	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
	          .setAccessToken("taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk")
	          .build();
	
	public static String Name(String id){
		GetTrackRequest a = spotifyApi.getTrack(id)
//	          .market(CountryCode.SE)
	          .build();
		final CompletableFuture<Track> t = a.executeAsync();
		final Track track = t.join();
		return track.getName();
	}
}
