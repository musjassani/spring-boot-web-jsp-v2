package com.proto.dao.impl;

import com.proto.beans.Pays;
import com.proto.dao.PaysDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("paysDao")
public class PaysDaoImpl extends AbstractDaoImpl<Pays> implements PaysDao {

    private final Logger logger = LoggerFactory.getLogger(PaysDaoImpl.class);
}
