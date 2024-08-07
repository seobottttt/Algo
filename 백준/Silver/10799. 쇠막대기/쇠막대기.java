import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String stick = br.readLine();
		Deque<Character> deque = new ArrayDeque<>();

		int stickNum = 0;

		int answer = 0;

		for (int i = 0; i < stick.length(); i++) {
			char cur = stick.charAt(i);
			if (cur == '(') {
				deque.addLast(cur);
			} else {

				if (stick.charAt(i - 1) == '(') {
					// lazer
					deque.removeLast();
					answer += deque.size();
				} else {
					// stick end point
					deque.removeLast();
					answer++;
				}

			}
			// ()(((()())(())()))(())
			// System.out.println(i + 1 + "번째:" + deque.size());

		}

		System.out.println(answer);

	}

}
