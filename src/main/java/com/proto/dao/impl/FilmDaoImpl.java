package com.proto.dao.impl;

import com.proto.beans.Film;
import com.proto.dao.FilmDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("filmDao")
public class FilmDaoImpl extends AbstractDaoImpl<Film> implements FilmDao {

    private final Logger logger = LoggerFactory.getLogger(FilmDaoImpl.class);
}
