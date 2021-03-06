import edu.duke.*;
import java.util.*;

public class gladlibMap {
	private ArrayList<String> wordlist = new ArrayList<String>();
	private HashMap<String, ArrayList<String>> map;
	private Random myRandom;
	private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
	private static String dataSourceDirectory = "data";

	public gladlibMap() {
		map = new HashMap<String, ArrayList<String>>();
		initializeFromSource(dataSourceDirectory);
		myRandom = new Random();
	}

	public gladlibMap(String source) {
		map = new HashMap<String, ArrayList<String>>();
		initializeFromSource(source);
		myRandom = new Random();
	}

	private void initializeFromSource(String source) {
		String[] labels = { "country", "noun", "animal", "adjective", "name", "color", "timeframe", "verb", "fruit" };
		for (String s : labels) {
			ArrayList<String> list = readIt(source + "/" + s + ".txt");
			map.put(s, list);
		}
	}

	private String randomFrom(ArrayList<String> source) {
		int index = myRandom.nextInt(source.size());
		return source.get(index);
	}

	private String getSubstitute(String label) {

		if (label.equals("number")) {
			return "" + myRandom.nextInt(50) + 5;
		}

		return randomFrom(map.get(label));
	}

	private String processWord(String w) {
		int first = w.indexOf("<");
		int last = w.indexOf(">", first);
		if (first == -1 || last == -1) {
			return w;
		}
		String prefix = w.substring(0, first);
		String suffix = w.substring(last + 1);
		String replace = w.substring(first + 1, last);
		String sub = getSubstitute(replace);

		if (wordlist == null) {
			wordlist.add(sub);
		} else {
			while (wordlist.contains(sub)) {
				sub = getSubstitute(replace);
			}
			wordlist.add(sub);
		}
		return prefix + sub + suffix;
	}

	private void printOut(String s, int lineWidth) {
		int charsWritten = 0;
		for (String w : s.split("\\s+")) {
			if (charsWritten + w.length() > lineWidth) {
				System.out.println();
				charsWritten = 0;
			}
			System.out.print(w + " ");
			charsWritten += w.length() + 1;
		}
	}

	private String fromTemplate(String source) {
		String story = "";
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String word : resource.words()) {
				story = story + processWord(word) + " ";
			}
		}
		return story;
	}

	private ArrayList<String> readIt(String source) {
		ArrayList<String> list = new ArrayList<String>();
		if (source.startsWith("http")) {
			URLResource resource = new URLResource(source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		} else {
			FileResource resource = new FileResource(source);
			for (String line : resource.lines()) {
				list.add(line);
			}
		}
		return list;
	}

	public int totalWordsInMap() {
		int total = 0;
		for (String s : map.keySet()) {
			ArrayList<String> list = map.get(s);
			total += list.size();
		}
		return total;
	}

	public int totalWordsConsidered() {
		int words = 0;
		for (String s : map.keySet()) {
			ArrayList<String> list = map.get(s);
			for (int i = 0; i < list.size(); i++) {
				String consider = list.get(i);
				if (wordlist.contains(consider)) {
					words += list.size();
					break;
				}
			}
		}

		return words;
	}

	public void main(String arg[]) {
		System.out.println("\n");
		String story = fromTemplate("data/madtemplate2.txt");
		printOut(story, 60);
		System.out.println(wordlist.size());
		System.out.println("totalWordsInMap: " + totalWordsInMap());
		System.out.println("toatlwordsconsiderd: " + totalWordsConsidered());

	}

}
