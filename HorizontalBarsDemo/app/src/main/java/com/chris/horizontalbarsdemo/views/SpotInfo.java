package com.chris.horizontalbarsdemo.views;

/**景区bean
 * Created by Chris on 2017/8/14.
 */

public class SpotInfo {

    //名称
    private String spotName;

    //关注度 周
    private String weekAttentionAlgorithm;

    //关注度 月
    private String monthAttentionAlgorithm;

    //满意度 very good
    private String satisfactionBest;

    //good
    private String satisfactionGood;

    //normal
    private String satisfactionNormal;

    //bad
    private String satisfactionBad;

    //very bad
    private String satisfactionWorst;



    private String satisfactionScore;

    public String getWeekAttentionAlgorithm() {
        return weekAttentionAlgorithm;
    }

    public void setWeekAttentionAlgorithm(String weekAttentionAlgorithm) {
        this.weekAttentionAlgorithm = weekAttentionAlgorithm;
    }

    public String getSatisfactionBest() {
        return satisfactionBest;
    }

    public void setSatisfactionBest(String satisfactionBest) {
        this.satisfactionBest = satisfactionBest;
    }

    public String getSatisfactionGood() {
        return satisfactionGood;
    }

    public void setSatisfactionGood(String satisfactionGood) {
        this.satisfactionGood = satisfactionGood;
    }

    public String getSatisfactionNormal() {
        return satisfactionNormal;
    }

    public void setSatisfactionNormal(String satisfactionNormal) {
        this.satisfactionNormal = satisfactionNormal;
    }

    public String getSatisfactionBad() {
        return satisfactionBad;
    }

    public void setSatisfactionBad(String satisfactionBad) {
        this.satisfactionBad = satisfactionBad;
    }

    public String getSatisfactionWorst() {
        return satisfactionWorst;
    }

    public void setSatisfactionWorst(String satisfactionWorst) {
        this.satisfactionWorst = satisfactionWorst;
    }

    public String getMonthAttentionAlgorithm() {
        return monthAttentionAlgorithm;
    }

    public void setMonthAttentionAlgorithm(String monthAttentionAlgorithm) {
        this.monthAttentionAlgorithm = monthAttentionAlgorithm;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSatisfactionScore() {
        return satisfactionScore;
    }

    public void setSatisfactionScore(String satisfactionScore) {
        this.satisfactionScore = satisfactionScore;
    }
}
