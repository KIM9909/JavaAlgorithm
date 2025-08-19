package Solution.Beakjun.String;
// 9248. Platinum3_Suffix Array

//import java.io.*;
//import java.util.*;
//public class P3_SuffixArray {
//    static String S;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder idxSb = new StringBuilder();
//        StringBuilder lcpSb = new StringBuilder();
//        S = br.readLine();
//
//        // String 배열 제거 - 메모리 절약의 핵심
//        Integer[] idxArr = new Integer[S.length()];
//
//        // 인덱스만 저장
//        for (int i=0; i<S.length(); i++) {
//            idxArr[i] = i+1;
//        }
//
//        Arrays.sort(idxArr, (a, b) -> compareSuffix(a-1, b-1));
//
//        for (int idx : idxArr) {
//            idxSb.append(idx).append(" ");
//        }
//
//        System.out.println(idxSb.toString());
//
//        // LCP Array 구하기
//        lcpSb.append("x").append(" ");
//
//        for (int i=1; i< idxArr.length; i++) {
//            int lcpCnt = getLCP(idxArr[i-1]-1, idxArr[i]-1);
//            lcpSb.append(lcpCnt).append(" ");
//        }
//
//        System.out.println(lcpSb.toString());
//    }
//
//    static int compareSuffix(int idx1, int idx2) {
//        int len1 = S.length() - idx1;
//        int len2 = S.length() - idx2;
//        int minLen = Math.min(len1, len2);
//
//        for (int i = 0; i < minLen; i++) {
//            if (S.charAt(idx1 + i) != S.charAt(idx2 + i)) {
//                return S.charAt(idx1 + i) - S.charAt(idx2 + i);
//            }
//        }
//        return len1 - len2;
//    }
//
//    // 인덱스로 직접 LCP 계산
//    static int getLCP(int idx1, int idx2) {
//        int minLen = Math.min(S.length() - idx1, S.length() - idx2);
//        int cnt = 0;
//
//        for (int i = 0; i < minLen; i++) {
//            if (S.charAt(idx1 + i) == S.charAt(idx2 + i)) {
//                cnt++;
//            } else {
//                break;
//            }
//        }
//        return cnt;
//    }
//}

import java.io.*;
import java.util.*;

public class P3_SuffixArray {
    static int[] sa, lcp, rank, tmp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = s.length();

        // Suffix Array 구축
        sa = buildSuffixArray(s);

        // LCP Array 구축
        lcp = buildLCPArray(s, sa);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(sa[i] + 1).append(" ");
        }
        sb.append("\n");

        sb.append("x ");
        for (int i = 1; i < n; i++) {
            sb.append(lcp[i]).append(" ");
        }

        System.out.println(sb);
    }

    // Manber-Myers Algorithm - O(N log^2 N)
    static int[] buildSuffixArray(String s) {
        int n = s.length();
        Integer[] sa = new Integer[n];
        int[] rank = new int[n];
        int[] tmp = new int[n];

        // 초기화: 첫 글자로 순위 매기기
        for (int i = 0; i < n; i++) {
            sa[i] = i;
            rank[i] = s.charAt(i);
        }

        // 길이를 2배씩 늘려가며 정렬
        for (int k = 1; k < n; k *= 2) {
            final int[] r = rank;
            final int len = k;

            // 현재 길이 k*2의 부분 문자열로 정렬
            Arrays.sort(sa, (i, j) -> {
                // 첫 k 길이 비교
                if (r[i] != r[j]) return r[i] - r[j];
                // 다음 k 길이 비교
                int ri = (i + len < n) ? r[i + len] : -1;
                int rj = (j + len < n) ? r[j + len] : -1;
                return ri - rj;
            });

            // 새로운 rank 배열 생성
            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                // 이전 suffix와 같은지 확인
                int prev = sa[i - 1], curr = sa[i];
                boolean same = (rank[prev] == rank[curr]);
                if (same && prev + k < n && curr + k < n) {
                    same = (rank[prev + k] == rank[curr + k]);
                } else if (same) {
                    same = (prev + k >= n && curr + k >= n);
                }

                tmp[curr] = same ? tmp[prev] : tmp[prev] + 1;
            }

            // rank 배열 업데이트
            System.arraycopy(tmp, 0, rank, 0, n);

            // 모든 suffix가 구분되면 종료
            if (rank[sa[n - 1]] == n - 1) break;
        }

        // Integer[] -> int[] 변환
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = sa[i];
        }
        return result;
    }

    // Kasai's Algorithm - O(N)
    static int[] buildLCPArray(String s, int[] sa) {
        int n = s.length();
        int[] lcp = new int[n];
        int[] rank = new int[n];

        // rank[i] = suffix i가 정렬된 배열에서 몇 번째인지
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        int h = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = sa[rank[i] - 1];

                // 공통 접두사 길이 계산
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) {
                    h++;
                }

                lcp[rank[i]] = h;

                if (h > 0) h--;
            }
        }

        return lcp;
    }
}