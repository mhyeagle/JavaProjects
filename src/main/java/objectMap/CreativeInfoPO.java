package objectMap;

public class CreativeInfoPO {
    //key
    private int creativeId;
    private String dt;
    private String hour;
    private int impNum;

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

    public int getImpNum() {
        return impNum;
    }

    public void setImpNum(int impNum) {
        this.impNum = impNum;
    }
}