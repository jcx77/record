package com.framework.commons.shiro.mgt;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

public class JwtWebSubjectFactory extends DefaultWebSubjectFactory {
	public Subject createSubject(SubjectContext context) {
		context.setSessionCreationEnabled(false);
		return super.createSubject(context);
	}
}