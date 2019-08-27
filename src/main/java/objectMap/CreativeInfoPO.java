package objectMap;

import java.util.List;

public class CreativeInfoPO {
    //key
    private int creativeId;
    private String dt;
    private String hour;
    private Integer impNum;

    public List<Long> getPoiIdList() {
        return poiIdList;
    }

    public void setPoiIdList(List<Long> poiIdList) {
        this.poiIdList = poiIdList;
    }

    private List<Long> poiIdList;

    @Override
    public String toString() {
        String result = "";
        result += "creativeId:";
        result += creativeId;
        result += " dt:";
        result += dt;
        result += " hour:";
        result += hour;
        result += " impNum:";
        result += impNum;

        return result;
    }

    public int getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(int creativeId) {
        this.creativeId = creativeId;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Integer getImpNum() {
        return impNum;
    }

    public void setImpNum(Integer impNum) {
        this.impNum = impNum;
    }
}
