package programmers.베스트앨범;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"classic", "pop", "classic", "classic", "pop"},	new int[]{500, 600, 150, 800, 2500})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"classic", "pop", "classic", "classic", "classic"},	new int[]{500, 1000, 400, 300, 200})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"classic", "pop", "classic"},	new int[]{500, 1001, 500})));
        //[4, 1, 3, 0]})
    }

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayMap = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        Map<String, List<Song>> songListByGenre = new HashMap<>();
        for(int i=0; i<genres.length; i++) {

            String genre = genres[i];
            int genrePlay = genrePlayMap.get(genre);
            int play = plays[i];
            int number = i;

            List<Song> songList = songListByGenre.getOrDefault(genre, new ArrayList<>());

            int rank = 1;
            int delIndex = -1;
            for (int j = 0; j < songList.size(); j++) {
                if(songList.get(j).getPlay() > play) {
                    rank++;
                } else if(songList.get(j).getPlay() == play && songList.get(j).getNumber() < number) {
                    rank++;
                } else {
                    delIndex = j;
                }
            }

            if(rank > 2) {
                continue;
            }

            Song song = new Song();
            song.setGenre(genre);
            song.setGenrePlay(genrePlay);
            song.setNumber(number);
            song.setPlay(play);
            songList.add(song);

            if(songList.size() > 2 && delIndex > -1) {
                songList.remove(delIndex);
            }

            songListByGenre.put(genre, songList);
        }


        List<Song> list = new ArrayList<>();
        for (List<Song> songList : songListByGenre.values()) {
            list.addAll(songList);
        }

        Collections.sort(list, new Comparator<Song>() {
            @Override
            public int compare(Song song1, Song song2) {
                int genrePlay = song1.getGenrePlay() - song2.getGenrePlay();
                int playCount = song1.getPlay() - song2.getPlay();
                int number = song2.getNumber() - song1.getNumber();

                if(song1.getGenrePlay() < song2.getGenrePlay()) {
                    return 1;
                } else if (song1.getGenrePlay() > song2.getGenrePlay()) {
                    return -1;
                } else {
                    if(song1.getPlay() < song2.getPlay()) {
                        return 1;
                    } else if (song1.getPlay() > song2.getPlay()) {
                        return -1;
                    } else {
                        if(song1.getNumber() < song2.getNumber()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            }
        });


        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).getNumber();
        }

        return answer;
    }


    public static class Song {
        String genre;
        int play;
        int number;
        int genrePlay;

        public int getGenrePlay() {
            return genrePlay;
        }

        public void setGenrePlay(int genrePlay) {
            this.genrePlay = genrePlay;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}


