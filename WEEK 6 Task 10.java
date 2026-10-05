import java.io.*;
import java.util.*;

public class Solution {

    
    static int[] manacherOdd(String s) {
        int n = s.length();
        int[] d1 = new int[n];

        int l = 0, r = -1;

        for (int i = 0; i < n; i++) {
            int k;

            if (i > r) {
                k = 1;
            } else {
                k = Math.min(d1[l + r - i], r - i + 1);
            }

            while (i - k >= 0 &&
                   i + k < n &&
                   s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }

            d1[i] = k;

            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }

        return d1;
    }

    
    static int[] manacherEven(String s) {
        int n = s.length();
        int[] d2 = new int[n];

        int l = 0, r = -1;

        for (int i = 0; i < n; i++) {
            int k;

            if (i > r) {
                k = 0;
            } else {
                k = Math.min(d2[l + r - i + 1], r - i + 1);
            }

            while (i - k - 1 >= 0 &&
                   i + k < n &&
                   s.charAt(i - k - 1) == s.charAt(i + k)) {
                k++;
            }

            d2[i] = k;

            if (i + k - 1 > r) {
                l = i - k;
                r = i + k - 1;
            }
        }

        return d2;
    }

    static class RangeMax {
        int n;
        int[] neg;
        int[] zero;
        int[] pos;

        RangeMax(int n) {
            this.n = n;
            neg = new int[4 * n + 5];
            zero = new int[4 * n + 5];
            pos = new int[4 * n + 5];

            Arrays.fill(neg, Integer.MIN_VALUE);
            Arrays.fill(zero, Integer.MIN_VALUE);
            Arrays.fill(pos, Integer.MIN_VALUE);
        }

        void update(int node, int left, int right,
                    int ql, int qr, int value, int type) {

            if (ql > right || qr < left) {
                return;
            }

            if (ql <= left && right <= qr) {
                if (type == -1) {
                    neg[node] = Math.max(neg[node], value);
                } else if (type == 0) {
                    zero[node] = Math.max(zero[node], value);
                } else {
                    pos[node] = Math.max(pos[node], value);
                }
                return;
            }

            int mid = (left + right) / 2;

            update(node * 2, left, mid, ql, qr, value, type);
            update(node * 2 + 1, mid + 1, right, ql, qr, value, type);
        }

        void update(int l, int r, int value, int type) {
            if (l > r || r < 0 || l >= n) {
                return;
            }

            l = Math.max(l, 0);
            r = Math.min(r, n - 1);

            if (l <= r) {
                update(1, 0, n - 1, l, r, value, type);
            }
        }

        int[] query(int node, int left, int right,
                    int index, int bestNeg,
                    int bestZero, int bestPos) {

            bestNeg = Math.max(bestNeg, neg[node]);
            bestZero = Math.max(bestZero, zero[node]);
            bestPos = Math.max(bestPos, pos[node]);

            if (left == right) {
                return new int[]{bestNeg, bestZero, bestPos};
            }

            int mid = (left + right) / 2;

            if (index <= mid) {
                return query(node * 2, left, mid, index,
                        bestNeg, bestZero, bestPos);
            } else {
                return query(node * 2 + 1, mid + 1, right, index,
                        bestNeg, bestZero, bestPos);
            }
        }

        int[] query(int index) {
            return query(1, 0, n - 1, index,
                    Integer.MIN_VALUE,
                    Integer.MIN_VALUE,
                    Integer.MIN_VALUE);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        
        String doubled = s + s;

        int m = doubled.length();

        int[] odd = manacherOdd(doubled);
        int[] even = manacherEven(doubled);

        RangeMax rmq = new RangeMax(n);

       
        int halfOdd = (n - 1) / 2;
        int ceilOdd = (n) / 2;

        for (int c = 0; c < m; c++) {

           
            int d = odd[c] - 1;

            if (d >= 0) {

                
                int left = c - (n - 1) + d;
                int right = c - d;

                rmq.update(
                        left,
                        right,
                        2 * d + 1,
                        0
                );

                
                left = Math.max(c - d, c - halfOdd);
                right = c;

                
                rmq.update(
                        left,
                        right,
                        2 * c + 1,
                        -1
                );

               
                left = c - n + 1;
                right = Math.min(
                        c + d - n + 1,
                        c - ceilOdd
                );

            
                rmq.update(
                        left,
                        right,
                        2 * n - 2 * c - 1,
                        1
                );
            }

        
            d = even[c];

            if (d > 0) {

                int left = c - n + d;
                int right = c - d;

                rmq.update(
                        left,
                        right,
                        2 * d,
                        0
                );

                
                left = Math.max(c - d, c - n / 2);
                right = c;

               
                rmq.update(
                        left,
                        right,
                        2 * c,
                        -1
                );

                
                left = c - n;
                right = Math.min(
                        c + d - n,
                        c - (n + 1) / 2
                );

               
                rmq.update(
                        left,
                        right,
                        2 * n - 2 * c,
                        1
                );
            }
        }

        
        StringBuilder output = new StringBuilder();

        for (int x = 0; x < n; x++) {

            int[] values = rmq.query(x);

            int answer = 1;

           
            if (values[0] != Integer.MIN_VALUE) {
                answer = Math.max(
                        answer,
                        -2 * x + values[0]
                );
            }


            if (values[1] != Integer.MIN_VALUE) {
                answer = Math.max(
                        answer,
                        values[1]
                );
            }

           
            if (values[2] != Integer.MIN_VALUE) {
                answer = Math.max(
                        answer,
                        2 * x + values[2]
                );
            }

            output.append(answer).append('\n');
        }

        System.out.print(output);
    }
}
