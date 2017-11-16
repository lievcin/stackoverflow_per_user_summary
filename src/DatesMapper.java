	import java.io.IOException;
	import java.util.Calendar;
	import org.apache.hadoop.io.IntWritable;

	import org.apache.hadoop.io.Text;
	import org.apache.hadoop.mapreduce.Mapper;
	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import java.io.StringReader;
	import org.xml.sax.InputSource;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import javax.xml.parsers.ParserConfigurationException;
	import org.xml.sax.SAXException;


	public class DatesMapper extends Mapper<Object, Text, Text, IntWritable> {

		private final IntWritable one = new IntWritable(1);
		private Text data = new Text();

    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder;
    // private static final Joiner TAG_JOINER = Joiner.on(",").skipNulls();
    // private static final DateFormat DATE_PARSER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    // private static final SimpleDateFormat DATE_BUILDER = new SimpleDateFormat("yyyy-MM-dd");

		@Override
		  protected void setup(Context context) throws IOException, InterruptedException
		  {
		      try
		      {
		          builder = factory.newDocumentBuilder();
		      }
		      catch (ParserConfigurationException e)
		      {
		          new IOException(e);
		      }
		  }


    @Override
    public void map(Object key, Text post, Context context) throws IOException, InterruptedException {
    	String entry = post.toString();
    	try
        {
		    	Document doc = builder.parse(new InputSource(new StringReader(entry)));
		      Element rootElem = doc.getDocumentElement();

		      // String id = rootElem.getAttribute("Id");
		      // String creationDate = rootElem.getAttribute("CreationDate");
		      String UserId = rootElem.getAttribute("UserId"); //for Badges, Comments
		      // String UserId = rootElem.getAttribute("OwnerUserId"); //for Posts


					data.set(UserId);
		    	context.write(data, one);
		    }
		  catch (SAXException e)
      {
          context.getCounter("Bad Record Counters", "Unparsable records").increment(1);
      }
      finally
      {
          builder.reset();
      }

    }
}