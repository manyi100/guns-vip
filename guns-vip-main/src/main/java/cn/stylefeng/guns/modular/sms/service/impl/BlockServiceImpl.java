package cn.stylefeng.guns.modular.sms.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.sms.entity.Block;
import cn.stylefeng.guns.modular.sms.mapper.BlockMapper;
import cn.stylefeng.guns.modular.sms.model.params.BlockParam;
import cn.stylefeng.guns.modular.sms.model.result.BlockResult;
import  cn.stylefeng.guns.modular.sms.service.BlockService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 黑名单表 服务实现类
 * </p>
 *
 * @author yqy
 * @since 2019-10-31
 */
@Service
public class BlockServiceImpl extends ServiceImpl<BlockMapper, Block> implements BlockService {

    /**
     * 修改用户状态
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:45
     */
    public int setStatus(Long userId, int status) {
        return this.baseMapper.setStatus(userId, status);
    }
    @Override
    public void add(BlockParam param){
        Block entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(BlockParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(BlockParam param){
        Block oldEntity = getOldEntity(param);
        Block newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public BlockResult findBySpec(BlockParam param){
        return null;
    }

    @Override
    public List<BlockResult> findListBySpec(BlockParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(BlockParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(BlockParam param){
        return param.getBlockid();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Block getOldEntity(BlockParam param) {
        return this.getById(getKey(param));
    }

    private Block getEntity(BlockParam param) {
        Block entity = new Block();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
