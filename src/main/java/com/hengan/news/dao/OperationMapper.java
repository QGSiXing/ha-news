package com.hengan.news.dao;

import com.hengan.news.core.MyMapper;
import com.hengan.news.model.po.OperationPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationMapper extends MyMapper<OperationPO> {
}