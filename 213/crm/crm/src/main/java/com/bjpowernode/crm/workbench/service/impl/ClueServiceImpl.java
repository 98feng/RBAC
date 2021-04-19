package com.bjpowernode.crm.workbench.service.impl;

import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.workbench.domain.*;
import com.bjpowernode.crm.workbench.mapper.*;
import com.bjpowernode.crm.workbench.service.ClueService;
import org.apache.ibatis.cache.decorators.SerializedCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 动力节点
 * 2021/3/31
 */
@Service
public class ClueServiceImpl implements ClueService {

    @Autowired
    private ClueMapper clueMapper;

    //客户Mapper
    @Autowired
    private CustomerMapper customerMapper;

    //联系人Mapper
    @Autowired
    private ContactsMapper contactsMapper;

    //线索备注
    @Autowired
    private ClueRemarkMapper clueRemarkMapper;

    //客户备注
    @Autowired
    private CustomerRemarkMapper customerRemarkMapper;

    //联系人备注
    @Autowired
    private ContactsRemarkMapper contactsRemarkMapper;

    //线索和市场活动
    @Autowired
    private ClueActivityRelationMapper clueActivityRelationMapper;

    //联系人和市场活动
    @Autowired
    private ContactsActivityRelationMapper contactsActivityRelationMapper;

    //交易
    @Autowired
    private TranMapper tranMapper;

    //交易备注
    @Autowired
    private TranRemarkMapper tranRemarkMapper;


    @Override
    public int saveCreateClue(Clue clue) {
        return clueMapper.insertClue(clue);
    }

    @Override
    public Clue queryClueFOrDetailById(String id) {
        return clueMapper.selectClueForDetailById(id);
    }

    @Override
    public void saveConvert(Map<String, Object> map) {
        /*（1）获取到线索id，通过线索id获取线索对象（线索对象当中封装了线索的信息）
（2）通过线索对象提取客户信息，当该客户不存在的时候，新建客户（根据公司的名称精确匹配，判断该客户是否存在！）
（3）通过线索对象提取联系人信息，保存联系人
（4）线索备注转换到客户备注以及联系人备注
（5）“线索和市场活动”的关系转换到“联系人和市场活动”的关系
（6）如果有创建交易需求，创建一条交易
（7）如果创建了交易，则创建一条该交易下的交易历史
（8）删除线索备注
（9）删除线索和市场活动的关系
（10）删除线索*/

        String clueId=(String)map.get("clueId");
        User user=(User)map.get("sessionUser");
        String isCreateTran=(String)map.get("isCreateTran");

        //（1）获取到线索id，通过线索id获取线索对象（线索对象当中封装了线索的信息）
        Clue clue=clueMapper.selectClueById(clueId);
        //(2)根据该线索将与公司相关的信息转到客户表
        Customer customer=new Customer();
        customer.setId(UUIDUtils.getUUID());
        customer.setOwner(user.getId());
        customer.setName(clue.getCompany());
        customer.setPhone(clue.getPhone());
        customer.setWebsite(clue.getWebsite());
        customer.setCreateBy(user.getId());
        customer.setCreateTime(DateUtils.formatDateTime(new Date()));
        customer.setDescription(clue.getDescription());
        customer.setNextContactTime(clue.getNextContactTime());
        customer.setContactSummary(clue.getContactSummary());
        customer.setAddress(clue.getAddress());
        //添加记录到客户表
        customerMapper.insertCustomer(customer);

        //(3)通过线索对象提取联系人信息，保存联系人
        Contacts contacts=new Contacts();
        contacts.setId(UUIDUtils.getUUID());
        contacts.setOwner(user.getId());
        contacts.setSource(clue.getSource());
        contacts.setCustomerId(customer.getId());
        contacts.setFullName(clue.getFullName());
        contacts.setAppellation(clue.getAppellation());
        contacts.setEmail(clue.getEmail());
        contacts.setMphone(clue.getMphone());
        contacts.setJob(clue.getJob());
        contacts.setCreateBy(user.getId());
        contacts.setCreateTime(DateUtils.formatDateTime(new Date()));
        contacts.setDescription(clue.getDescription());
        contacts.setNextContactTime(clue.getNextContactTime());
        contacts.setContactSummary(clue.getContactSummary());
        contacts.setAddress(clue.getAddress());

        contactsMapper.insertContacts(contacts);

        //（4）线索备注转换到客户备注以及联系人备注
        List<ClueRemark> clueRemarkList=clueRemarkMapper.selectClueRemarkByClueId(clueId);//遍历clureRemarkList集合，将集合中的每一条记录取出给客户备注对象和联系人备注对象。每次集合去接收客户备注对象和联系人备注对象
        if(clueRemarkList!=null&&clueRemarkList.size()>0){
            //定义两个对象：客户备注对象和联系人备注对象
            CustomerRemark cur=null;
            ContactsRemark cor=null;

            //定义两个集合：客户备注对象集合和联系人备注对象集合
            List<CustomerRemark> curList=new ArrayList<>();
            List<ContactsRemark> corList=new ArrayList<>();

            for(ClueRemark cr:clueRemarkList){
                //构造客户备注
                cur=new CustomerRemark();
                cur.setId(UUIDUtils.getUUID());
                cur.setNoteContent(cr.getNoteContent());
                cur.setCreateBy(cr.getCreateBy());
                cur.setCreateTime(cr.getCreateTime());
                cur.setEditBy(cr.getEditBy());
                cur.setEditTime(cr.getEditTime());
                cur.setEditFlag(cr.getEditFlag());
                cur.setCustomerId(customer.getId());

                curList.add(cur);

                //构造联系人备注
                cor=new ContactsRemark();
                cor.setId(UUIDUtils.getUUID());
                cor.setNoteContent(cr.getNoteContent());
                cor.setCreateBy(cr.getCreateBy());
                cor.setCreateTime(cr.getCreateTime());
                cor.setEditBy(cr.getEditBy());
                cor.setEditTime(cr.getEditTime());
                cor.setEditFlag(cr.getEditFlag());
                cor.setContactsId(contacts.getId());

                corList.add(cor);

            }
            customerRemarkMapper.insertCustomerRemarkByList(curList);

            contactsRemarkMapper.insertContactsRemarkByList(corList);
        }

        //5.线索和市场活动”的关系转换到“联系人和市场活动”的关系
        //当前线索所对应的市场活动
        List<ClueActivityRelation> carList=clueActivityRelationMapper.selectClueActivityRelationByClueId(clueId);
        //遍历carList,封装ContactsActivityRelation对象，把该线索和市场活动的关系转到联系人与市场活动关系表中
        if(carList!=null&&carList.size()>0){
            ContactsActivityRelation coar=null;
            //定义一个集合来放ContactsActivityRelation
            List<ContactsActivityRelation> coarList=new ArrayList<>();
            //循环获取每一个线索与市场活动的对象
            for(ClueActivityRelation car:carList){
                coar=new ContactsActivityRelation();
                coar.setId(UUIDUtils.getUUID());
                coar.setContactsId(contacts.getId());
                coar.setActivityId(car.getActivityId());

                coarList.add(coar);
            }
            //插入联系人和市场活动表
            contactsActivityRelationMapper.insertContactsActivityRelationByList(coarList);
        }

        //6.如果创建了交易，还需要把该线索下所有的备注转到交易备注表
        if("true".equals(isCreateTran)){
            Tran tran=new Tran();
            tran.setId(UUIDUtils.getUUID());
            tran.setOwner(user.getId());
            tran.setMoney((String)map.get("amountOfMoney"));
            tran.setName((String)map.get("tradeName"));
            tran.setExpectedDate((String)map.get("expectedClosingDate"));
            tran.setCustomerId(customer.getId());
            tran.setStage((String)map.get("stage"));
            //交易和来源现在不需要，在交易模块的创建交易时会有。
            tran.setActivityId((String)map.get("activityId"));
            tran.setContactsId(contacts.getId());
            tran.setCreateBy(user.getId());
            tran.setCreateTime(DateUtils.formatDateTime(new Date()));
            tranMapper.insert(tran);

            //还需要把该线索下所有的备注转到交易备注表
            if(clueRemarkList!=null&&clueRemarkList.size()>0){
                TranRemark tr=null;
                List<TranRemark> trList=new ArrayList<>();

                for(ClueRemark cr:clueRemarkList){
                    tr=new TranRemark();
                    tr.setId(UUIDUtils.getUUID());
                    tr.setNoteContent(cr.getNoteContent());
                    tr.setCreateBy(cr.getCreateBy());
                    tr.setCreateTime(cr.getCreateTime());
                    tr.setEditby(cr.getEditBy());
                    tr.setEditTime(cr.getEditTime());
                    tr.setEditFlag(cr.getEditFlag());
                    tr.setTranId(tran.getId());
                    trList.add(tr);
                }
                tranRemarkMapper.insertTranRemarkByList(trList);
            }
        }

        //8.删除线索备注
        clueRemarkMapper.deleteClueRemarkByClueId(clueId);
        //（9）删除线索和市场活动的关系
        clueActivityRelationMapper.deleteClueActivityRelationByClueId(clueId);
        //（10）删除线索
        clueMapper.deleteClueById(clueId);












    }
}
