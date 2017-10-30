import org.apache.hadoop.io.Text;

public class TweetsParser {

	private long epoch;
	private String tweetId;
	private String tweetBody;
	private String device;
	private boolean valid_structure;
	private String[] tweet_parts;

	public void parse(String tweet) {

		tweet_parts = tweet.toString().split("\\;");

		if (tweet_parts.length == 4 && tweet_parts[0].charAt(0) != '#') {
			//the condition above is due to a series of tweets that have no id somehow or are corrupted
			//but they have 4 elements as ; is being used inside the text of the tweet itself.
			epoch = Long.parseLong(tweet_parts[0]);
			tweetId = tweet_parts[1];
			tweetBody = tweet_parts[2];
			device = tweet_parts[3];
			valid_structure = true;
		}
		else {
			valid_structure  = false;
		}

	}

	public void parse(Text tweet) {
		parse(tweet.toString());
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public int getTweetLength() {
		return tweetBody.length();
	}

	public int getTweetBinSize() {
		return (int) Math.floor(getTweetLength()/5);
	}

	public boolean isValidTweet() {

		if (valid_structure == false || getTweetLength() > 140) {
			return false;
		}
		else {
			return true;
		}

	}
}