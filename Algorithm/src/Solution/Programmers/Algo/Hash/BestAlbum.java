package Solution.Programmers.Algo.Hash;
// Lv.3 베스트앨범

import java.util.*;
class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {

        // 장르별로 총 재생횟수 계산
        HashMap<String, Integer> genreTotal = new HashMap<>();
        for (int i=0; i< genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르별 노래 모으기
        HashMap<String, List<Integer>> genreSongs = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(i); // 노래 인덱스 저장
        }

        // 각 장르 안에서 재생횟수 비교 정렬
        for (List<Integer> songs : genreSongs.values()) {
            songs.sort((a, b) -> {
                if (plays[a] != plays[b]) {
                    return plays[b] - plays[a]; // 재생횟수 많은 순
                }
                return a - b; // 재생횟수가 같으면 인덱스가 작은 순
            });
        }

        // 장르를 인기 순으로 정렬
        List<String> sortGenre = new ArrayList<>(genreTotal.keySet());
        sortGenre.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        // 결과 만들기 (각 장르에서 최대 2곡씩)
        List<Integer> res = new ArrayList<>();
        for (String genre : sortGenre) {
            List<Integer> songs = genreSongs.get(genre);
            for (int i=0; i < Math.min(2, songs.size()); i++) {
                res.add(songs.get(i));
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
