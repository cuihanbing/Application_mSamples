package com.example.myapplication;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by admin on 2017/1/10.
 */

public class GameScore extends BmobObject{

    private String playerName;
    private Integer score;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer familyNumber;
    private Boolean isPay;
    private BmobFile pic;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
public  void setAge(Integer age){
    this.age=age;
}

    public Integer getAge() {
        return age;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setFamilyNumber(Integer familyNumber) {
        this.familyNumber = familyNumber;
    }

    public Integer getFamilyNumber() {
        return familyNumber;
    }

    public Boolean getIsPay() {
        return isPay;
    }

    public void setIsPay(Boolean isPay) {
        this. isPay = isPay;
    }

    public BmobFile getPic() {
        return pic;
    }

    public void setPic(BmobFile pic) {
        this.pic = pic;
    }

}
