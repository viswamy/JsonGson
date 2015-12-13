package temp;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

class JsonGson {

	static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}

	public static void JsonGsonTesting() throws IOException {

		String jsonStr = readFile("data.txt");

		Gson gson = new Gson();
		JsonObject jsonObj = gson.fromJson(jsonStr, JsonObject.class);
		System.out.println(jsonObj.get("xyz"));

		JsonObject currentlyObj = jsonObj.get("currently").getAsJsonObject();
		JsonObject dailyObj = jsonObj.get("daily").getAsJsonObject();
		JsonObject dailyObj0 = dailyObj.getAsJsonArray("data").get(0)
				.getAsJsonObject();

		System.out.println(currentlyObj.get("time").getAsString());
		System.out.println(currentlyObj.toString());
		System.out.println(dailyObj0.toString());

	}

	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException {
		JsonGsonTesting();
	}
}
