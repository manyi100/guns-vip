package cn.stylefeng.guns.modular.sms.wapper;

import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;

import java.util.List;
import java.util.Map;

public class MobileWrapper  extends BaseControllerWrapper {
    public MobileWrapper(Map<String, Object> single) {
        super(single);
    }

    public MobileWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {

    }

}
