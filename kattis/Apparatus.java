// link: https://open.kattis.com/problems/apparatus
// name: Apparatus
package kattis;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Apparatus {

	private static final int MODULO = 1000003;

	public static void main(String[] args) throws IOException {

		Kattio io = new Kattio(System.in, System.out);
	
		int switchesCount = io.getInt();
		int photosCount = io.getInt();

		String[] switchPhotos = new String[photosCount];
		String[] lightPhotos = new String[photosCount];
		for (int i = 0; i < photosCount; i++) {

			switchPhotos[i] = io.getWord();
			lightPhotos[i] = io.getWord();
		}

		LinkedList<Integer> switches = new LinkedList<>();
		LinkedList<Integer> lights = new LinkedList<>();
		for (int i = 0; i < switchesCount; i++) {
			switches.add(i);
			lights.add(i);
		}

		Queue<Partial> q = new ArrayDeque<>();
		q.add(new Partial(switches, lights, 0));
		long result = 1;
		while (!q.isEmpty()) {
			Partial current = q.poll();
			
			if (current.order == photosCount) {

				result = (result * factorial(current.switches.size())) % MODULO;
				continue;
			}

			LinkedList<Integer> switchZeros = new LinkedList<>();
			LinkedList<Integer> lightZeros = new LinkedList<>();

			ListIterator<Integer> switchIterator = current.switches.listIterator();
			while (switchIterator.hasNext()) {
				Integer next = switchIterator.next();
				if (switchPhotos[current.order].charAt(next) == '0') {
					switchZeros.add(next);
					switchIterator.remove();
				}
			}

			ListIterator<Integer> lightIterator = current.lights.listIterator();
			while (lightIterator.hasNext()) {
				Integer next = lightIterator.next();
				if (lightPhotos[current.order].charAt(next) == '0') {
					lightZeros.add(next);
					lightIterator.remove();
				}
			}

			if (switchZeros.size() != lightZeros.size()) {
				result = 0;
				break;
			}

			if (current.lights.size() > 0 && current.switches.size() > 0)
				q.add(new Partial(current.switches, current.lights, current.order + 1));
			if (lightZeros.size() > 0 && switchZeros.size() > 0)
				q.add(new Partial(switchZeros, lightZeros, current.order + 1));
		}

		io.println(result);
		io.close();
	}

	private static long factorial(int input) {
		long result = 1;
		for (long i = 1; i < input + 1; i++) {
			result = (result * i) % MODULO;
		}
		return result;
	}

	static class Partial {
		LinkedList<Integer> switches;
		LinkedList<Integer> lights;
		int order;

		public Partial(LinkedList<Integer> switches, LinkedList<Integer> lights, int order) {
			super();
			this.switches = switches;
			this.lights = lights;
			this.order = order;
		}

	}

	static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}
}
