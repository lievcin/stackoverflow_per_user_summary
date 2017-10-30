import org.apache.hadoop.io.Text;
// import java.util.Arrays;


public class TweetsParser {

	private int epoch;
	private int tweetId;
	private String tweetBody;
	private String device;
	private boolean valid_structure;
	private String[] tweet_parts;

	public void parse(String tweet) {

		tweet_parts = tweet.toString().split("\\;");

		if (tweet_parts.length == 4) {
			epoch = Integer.parseInt(tweet_parts[0]);
			tweetId = Integer.parseInt(tweet_parts[1]);
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