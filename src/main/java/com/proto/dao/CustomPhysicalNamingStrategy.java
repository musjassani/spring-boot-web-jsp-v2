package com.proto.dao;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy, Serializable {
	/**
	 * Singleton access
	 */
	public static final CustomPhysicalNamingStrategy INSTANCE = new CustomPhysicalNamingStrategy();

	@Override
	public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment context) {
		return capitalize(name);
	}

	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
		return capitalize(name);
	}

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return capitalize(name);
	}

	@Override
	public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment context) {
		return capitalize(name);
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		return capitalize(name);
	}
	
	private Identifier capitalize(Identifier name) {
		if (name == null)
			return null;
		if (name.isQuoted())
			return name;
		String text = StringUtils.capitalize(name.getText());
		return Identifier.toIdentifier(text);
	}
}
