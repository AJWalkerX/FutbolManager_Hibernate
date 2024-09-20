package com.ajwalker.utility.Data;

import com.ajwalker.entity.League;
import com.ajwalker.entity.Match;
import com.ajwalker.entity.Season;
import com.ajwalker.repository.LeagueRepository;
import com.ajwalker.repository.SeasonRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FixtureGenerator {

    //maçlar için 3 ayrı metod
    public static void generateMatchesAndFixture(DatabaseModel databaseModel,League league){
        int teamNums = league.getTeamIdList().size();
        int matchesPerWeek = teamNums/2;

        List<Integer[]> fixtureListWithID = generateFixtureList(teamNums);

        List<Match> matches = setIDToMatches(databaseModel, fixtureListWithID, league);//Mac nesnesi yarattigimiz yer.

        setDatestoMatches(league, matches);


    }

    public static List<Integer[]> generateFixtureList(int teamCount) {


        List<Integer[]> fixture = new ArrayList<>();

        // Her takımın birbirleriyle iki kez karşılaşacağı fikstürü oluşturuyoruz
        for (int i = 0; i < teamCount - 1; i++) {
            for (int j = 0; j < teamCount / 2; j++) {
                int home = (i + j) % (teamCount - 1);
                int away = (teamCount - 1 - j + i) % (teamCount - 1);
                if (j == 0) {
                    away = teamCount - 1;
                }
                fixture.add(new Integer[]{home, away});
            }
        }

        // İkinci yarı için ters maçları ekliyoruz
        List<Integer[]> reversedFixture = new ArrayList<>();
        for (Integer[] match : fixture) {
            reversedFixture.add(new Integer[]{match[1], match[0]});
        }
        fixture.addAll(reversedFixture);


        //Aynı takım üst üste sürekli ev sahibi olmasın diye
        List<Integer[]> temp = List.copyOf(fixture);

        for(int i =0;i<teamCount-1;i++){
            for(int j=0;j<teamCount/2;j++ ){
                if(i%2==0){
                    fixture.set(j+(i*10),temp.get(190+j+(i*10)));
                    fixture.set(190+j+(i*10), temp.get(j+(i*10)));
                }
            }
        }
        return fixture;
    }
    public static List<Match> setIDToMatches(List<Integer[]> fixtureList, League league) {
        //maçlara id atar.
        List<Long> teamIDlist = LeagueRepository.getInstance().getTeamIds(league.getId());
        List<Match> matchesList = new ArrayList<>();

        for (Integer[] matches : fixtureList) {
            Match match = Match.builder().build();
            if (matches[0] < teamIDlist.size() && matches[1] < teamIDlist.size()) {
                match.setHomeTeamId(teamIDlist.get(matches[0]));
                match.setAwayTeamId(teamIDlist.get(matches[1]));
                matchesList.add(match);
            }
        }
        return matchesList;
    }

    public static Map<Integer, List<Match>> setDatestoMatches(League league, List<Match> matches) {

        Season season = league.getSeason();
        LocalDate matchDate = season.getBEGINNING_OF_SEASON();
        int totalTeamsInLeague = LeagueRepository.getInstance().getTeamIds(league.getId()).size();


        int totalWeek = (totalTeamsInLeague - 1) * 2;
        int matchesPerWeek = totalTeamsInLeague / 2;
        int matchIndex = 0;
        //TODO: Burdan devam edilecek!!!

        for (int i = 0; i < totalWeek; i++) {
            for (int j = 0; j < matchesPerWeek; j++) {
                switch (j) {
                    case 0, 1:
                        matches.get(matchIndex++).setMatchDate(matchDate);
                        break;
                    case 2, 3, 4:
                        matches.get(matchIndex++).setMatchDate(matchDate.plusDays(1));
                        break;
                    case 5, 6, 7:
                        matches.get(matchIndex++).setMatchDate(matchDate.plusDays(2));
                        break;
                    case 8, 9:
                        matches.get(matchIndex++).setMatchDate(matchDate.plusDays(3));
                        break;
                }
            }
            matchDate = matchDate.plusDays(7);
        }
        return null;
    }

}
