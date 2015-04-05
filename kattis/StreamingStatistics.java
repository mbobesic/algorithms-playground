// link: https://spotify.kattis.com/problems/streamstats
// name: Streaming Statistics
package kattis;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StreamingStatistics {

	private static final double MS_IN_S = 1000.0;

	public static void main(String[] args) throws IOException {

		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();

		TimePoint[] bitrateChanges = new TimePoint[2 * n];

		for (int i = 0; i < n; ++i) {

			long end = io.getLong();
			long duration = io.getLong();
			long bitrate = io.getLong();

			bitrateChanges[2 * i] = new TimePoint(end - duration, bitrate);
			bitrateChanges[2 * i + 1] = new TimePoint(end, -bitrate);
		}

		Arrays.sort(bitrateChanges);

		TimePoint[] bitrateValues = reduceValues(bitrateChanges);
		TimePoint[] bitrateSums = reduceSums(bitrateValues);

		int m = io.getInt();

		for (int i = 0; i < m; i++) {

			long a = io.getLong();
			long b = io.getLong();

			int aPosition = Arrays.binarySearch(bitrateSums, new TimePoint(a, 0));
			int bPosition = Arrays.binarySearch(bitrateSums, new TimePoint(b, 0));

			int aInsertionPoint = aPosition >= 0 ? aPosition : -aPosition - 1;
			int bInsertionPoint = bPosition >= 0 ? bPosition : -bPosition - 1;

			long result = bitrateSums[bInsertionPoint - 1].value - bitrateSums[aInsertionPoint].value;

			if (bInsertionPoint != 0 && bInsertionPoint != bitrateSums.length) {

				result += (b - bitrateValues[bInsertionPoint - 1].time) * bitrateValues[bInsertionPoint - 1].value;
			}

			if (aInsertionPoint != 0 && aInsertionPoint != bitrateSums.length) {

				result += (bitrateValues[aInsertionPoint].time - a) * bitrateValues[aInsertionPoint - 1].value;
			}

			System.out.println(String.format("%.3f", result / MS_IN_S));
		}

		io.close();
	}

	private static TimePoint[] reduceSums(TimePoint[] bitrateValues) {
		TimePoint[] sums = new TimePoint[bitrateValues.length];

		sums[0] = new TimePoint(bitrateValues[0].time, 0);
		int position = 1;
		TimePoint last = null;
		for (TimePoint current : bitrateValues) {

			if (last != null) {

				long time = current.time;
				long currentSum = sums[position - 1].value + last.value * (current.time - last.time);
				sums[position] = new TimePoint(time, currentSum);
				position++;
			}

			last = current;
		}
		return sums;
	}

	private static TimePoint[] reduceValues(TimePoint[] bitrateChanges) {
		int distinctValues = 1;
		for (int i = 1; i < bitrateChanges.length; i++) {

			if (bitrateChanges[i].time != bitrateChanges[i - 1].time) {
				distinctValues++;
			}
		}

		TimePoint[] bitrateValue = new TimePoint[distinctValues];

		int position = 0;
		long totalValue = 0;
		TimePoint last = null;
		for (TimePoint current : bitrateChanges) {

			totalValue += current.value;

			if (current.sameTime(last)) {

				last.value = totalValue;
				continue;
			}

			bitrateValue[position] = new TimePoint(current.time, totalValue);
			last = bitrateValue[position];
			position++;

		}
		return bitrateValue;
	}

	static class TimePoint implements Comparable<TimePoint> {

		long time;
		long value;

		public TimePoint(long time, long value) {

			this.time = time;
			this.value = value;
		}

		@Override
		public int compareTo(TimePoint o) {

			if (this.time < o.time) {
				return -1;
			}
			if (this.time > o.time) {
				return 1;
			}
			return 0;
		}

		public boolean sameTime(TimePoint o) {
			if (o == null) {
				return false;
			}

			return this.time == o.time;
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
