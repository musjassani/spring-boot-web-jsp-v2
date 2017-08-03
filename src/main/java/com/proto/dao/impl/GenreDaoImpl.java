package com.proto.dao.impl;

import com.proto.beans.Genre;
import com.proto.dao.GenreDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("genreDao")
public class GenreDaoImpl extends AbstractDaoImpl<Genre> implements GenreDao {

    private final Logger logger = LoggerFactory.getLogger(GenreDaoImpl.class);
}
