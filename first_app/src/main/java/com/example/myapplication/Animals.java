package com.example.myapplication;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by admin on 2017/1/10.
 */

public class Animals extends BmobObject {
private  String objectid;
    private String tiger;
    private String dog;
    private String cat;
    private String fish;
    private String pig;

    private Boolean isPay;
    private BmobFile pic;

public void setobjectId(String objectid){
    this.objectid=objectid;
}
    public String getobjectid(String id){
        return objectid;
    }
    public String getTiger() {
        return tiger;
    }

    public void setTiger(String tiger) {
        this.tiger = tiger;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCat() {
        return cat;
    }

    public void setFish(String fish) {
        this.fish = fish;
    }

    public String getFish() {
        return fish;
    }

    public void setPig(String pig) {
        this.pig = pig;
    }

    public String getPig() {
        return pig;
    }



    public Boolean getIsPay() {
        return isPay;
    }

    public void setIsPay(Boolean isPay) {
        this.isPay = isPay;
    }

    public BmobFile getPic() {
        return pic;
    }

    public void setPic(BmobFile pic) {
        this.pic = pic;
    }

}
