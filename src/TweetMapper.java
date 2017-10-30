	import java.io.IOException;
	import java.util.Calendar;
	import org.apache.hadoop.io.IntWritable;
	import org.apache.hadoop.io.Text;
	// import org.apache.hadoop.io.LongWritable;
	// import org.apache.hadoop.io.DoubleWritable;
	import org.apache.hadoop.mapreduce.Mapper;
	// import tweets_parser.java;

	public class TweetMapper extends Mapper<Object, Text, IntWritable, IntWritable> {

		private final IntWritable one = new IntWritable(1);
		private TweetsParser parser = new TweetsParser();

    private IntWritable data = new IntWritable();

    public void map(Object key, Text tweet, Context context) throws IOException, InterruptedException {
    		//1469453965000;757570957502394369;Over 30 million women footballers in the world. Most of us would https://t.co/Mu5miVJAWx;<a href="http://twitter.com/download/iphone" rel="nofollow">Twitter for iPhone</a>
	    	//epoch_time;tweetId;tweet(including #hashtags);device
    		parser.parse(tweet);

    		if (parser.isValidTweet()) {
    			data.set(5*parser.getTweetBinSize());
    			context.write(data, one);
    		}

    }

	}
