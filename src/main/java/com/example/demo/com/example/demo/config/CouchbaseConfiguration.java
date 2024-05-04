package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

	@Override
	public String getConnectionString() {
		return "127.0.0.1";
	}

	@Override
	public String getUserName() {
		return "vyomadmin";
	}

	@Override
	public String getPassword() {
		return "vyomadmin";
	}

	@Override
	public String getBucketName() {
		return "employeewise";
	}

}
