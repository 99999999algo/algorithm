package hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2022.03.22.
 * 프로그래머스 고득점 kit - 해시 - 베스트앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
 */
public class Solution4 {

    public static List<Integer> list;
    private final static int MAX_SONGS_BY_GENRE = 2;

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> album = new ArrayList<>();
        
        // 장르별 재생횟수
        Map<String, Integer> countByGenre = new HashMap<>();
        Map<Integer, String> genreByCount = new HashMap<>();
        // 장르별 선택된 곡의 고유 번호 리스트
        Map<String, List<Integer>> selectedSongsByGenre = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int count = plays[i];

            // 장르별 재생횟수 추가
            int sum = countByGenre.getOrDefault(genre, 0) + count;
            countByGenre.put(genre, sum);

            // 재생 횟수에 따라서 장르 리스트에 곡 추가하기
            list = selectedSongsByGenre.getOrDefault(genre, new ArrayList<>());
            list = add(list, i, count, plays);
            selectedSongsByGenre.put(genre, list);
        }

        for (String g: countByGenre.keySet())
            genreByCount.put(countByGenre.get(g), g);

        // 장르별 재생횟수 내림차순 정렬
        List<Integer> sortedPlaysSumList = genreByCount.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for (Integer c: sortedPlaysSumList) {
            String genre = genreByCount.get(c);
            album.addAll(selectedSongsByGenre.get(genre));
        }

        int[] answer = new int[album.size()];
        for (int i=0; i<album.size(); i++)
            answer[i] = album.get(i);
        return answer;
    }

    // 고유번호 추가하고 정렬하기
    public static List<Integer> add(List<Integer> list, int songId, int count, int[] plays) {
        boolean isAdded = false;

        for (int i=0; i<list.size(); i++) {
            if (plays[list.get(i)] < count) {
                list.add(i, songId);
                isAdded = true;
                break;
            }
        }

        if (!isAdded)
            list.add(songId);

        if (list.size() > MAX_SONGS_BY_GENRE)
            list.remove(MAX_SONGS_BY_GENRE);

        return list;
    }

    // 실행 확인
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Arrays.stream(solution(genres, plays)).forEach(System.out::println);
    }
}
