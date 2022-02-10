package BI;

public enum RateTypeStrategyEnum {
    NORMAL(1),                  // 正常计算
    UNCAL(2),                   // 不计算，在未过完的周期中对用户展示-
    CAL(3);                     // 按照未过完的时间计算

    private Integer strategy;

    RateTypeStrategyEnum(Integer strategy) {
        this.strategy = strategy;
    }

    public Integer getStrategy() {
        return strategy;
    }

    public static RateTypeStrategyEnum of(Integer strategy) {
        for (RateTypeStrategyEnum rateTypeStrategy : RateTypeStrategyEnum.values()) {
            if (strategy.equals(rateTypeStrategy.getStrategy())) {
                return rateTypeStrategy;
            }
        }

        return NORMAL;
    }
}
