package lyrics_extractor;

import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class webtest {

	public static void main(String args[]) {

		///SONG TO FIND
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("The name of the song: ");
		String song = scan.nextLine().replace(' ', '-').toLowerCase();
		System.out.print("The name of the artist: ");
		String artist = scan.nextLine().replace(' ', '-').toLowerCase();
		
		String url = "http://www.metrolyrics.com/" + song + "-lyrics-" + artist + ".html";
		
		System.out.println("\nFetching file from :" + url);
		
		System.out.println();
		
		
		///EXTRACTION PROCESS
		
		
		try {
			
			//First, get the url
			Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();

			//<br> tags wont be recognized, so we need to do this to have newlines. The 'nlnlnl' can be anything
			doc.select("br").append("nlnlnl");
			
			//Extract words that has a 'verse' tag on on it
			Elements temp = doc.getElementsByClass("verse");
			
			//This is scenario two if we were directed to other pages and no lyrics are available
			if(temp.isEmpty()) {System.out.println("Could not find song :(");}
			
			//Else, proceed to the extraction
			else {
			
			System.out.println("---------------------------------------------------");
			
			//Displays the title of the url
			System.out.println(doc.title());
			
			/* For each element, get the text format, split it into an array to where whenever the 'nlnlnl' word
			 * appears, the program will split it.
			 */
			for(Element lyrics: temp) {
				
				System.out.println();
				for(String i: lyrics.text().split("nlnlnl ")) {
					System.out.println(i);
				}
				
			}
			
			System.out.println("---------------------------------------------------");
			}
	
		}
		//If the lyrics fetching didn't work, this will appear
		catch(Exception e) {
			System.out.println("Could not find song. Sorry :(");
		}
		
	}
	
}
