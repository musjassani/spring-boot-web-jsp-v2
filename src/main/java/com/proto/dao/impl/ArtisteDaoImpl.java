package com.proto.dao.impl;

import com.proto.beans.Artiste;
import com.proto.dao.ArtisteDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("artisteDao")
public class ArtisteDaoImpl extends AbstractDaoImpl<Artiste> implements ArtisteDao {

    private final Logger logger = LoggerFactory.getLogger(ArtisteDaoImpl.class);
}
