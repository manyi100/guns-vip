package cn.stylefeng.guns.modular.sms.wapper;

import cn.stylefeng.guns.sys.core.constant.factory.ConstantFactory;
import cn.stylefeng.guns.sys.core.util.DecimalUtil;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

public class TGwSpConfigWrapper extends BaseControllerWrapper {
    @Autowired
    RedisTemplate<String ,String > redisTemplate;
    public TGwSpConfigWrapper(Map<String, Object> single) {
        super(single);
    }

    public TGwSpConfigWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public TGwSpConfigWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public TGwSpConfigWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        String  spnumbody =map.get("spnumbody").toString();
        int online =Integer.parseInt(redisTemplate.opsForHash().get(spnumbody,"online").toString());
        map.put("online", online);
    }
}
