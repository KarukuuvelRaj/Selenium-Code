package week3.day2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class MostDuplicateCharacter {
	public static void main(String[] args) {
		String inp = "abbabaaccvccb";
		char[] input = inp.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : input) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		//System.out.println(map);
		int maxOcc=0;
		char maxChar=0;
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		List<String> maxCh = new ArrayList<String>();
		String str="";
		for (Entry<Character, Integer> entry : entrySet) {
			if(entry.getValue()>=maxOcc) {
				maxChar=entry.getKey();
				maxOcc=entry.getValue();
				str=maxChar+"--->"+maxOcc;
				maxCh.add(str);
			}
		}
		System.out.println("The most number of duplicate character is :"+maxCh);
	}
}