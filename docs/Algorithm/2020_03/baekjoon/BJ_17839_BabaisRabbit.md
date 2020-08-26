```java
package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class BJ_17839_BabaisRabbit {
	static Map<String, ArrayList<String>> hmap= new HashMap<>();
	static Set<String> answer= new TreeSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int Order = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < Order; i++) {
			String[] splited = bf.readLine().split(" is ");
			String s1 = splited[0];
			String s2 = splited[1];

			if(!hmap.containsKey(s1)) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s2);
				hmap.put(s1, list);
			}else {
				ArrayList<String> list = hmap.get(s1);
				list.add(s2);
			}
		}

		if(hmap.containsKey("Baba")) {
			for (String s : hmap.get("Baba")) {
				if(!answer.contains(s)) {
					dfs(s);
				}
			}
		}

		for (String s : answer) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(String str) {
		if(!answer.contains(str)) {
			answer.add(str);

			if(hmap.containsKey(str)) {
				for (String s : hmap.get(str)){
					dfs(s);
				}
			}
		}
	}

}
```
