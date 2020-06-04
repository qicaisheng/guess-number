package com.twschool.practice;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameRecordMapper {

    @Insert("INSERT INTO `game_record` (id, round, user_guess, position_correct_number, value_correct_number) " +
            "VALUES (#{id}, #{round}, #{userGuess}, #{positionCorrectNumber}, #{valueCorrectNumber})")
    void save(GameRecord gameRecord);

    @Select("SELECT * FROM `game_record` WHERE `round` = #{round}")
    List<GameRecord> findGameRecordsByRound(String round);
}
