package com.banco.base.codeChallenge.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.banco.base.codeChallenge.service.MessageService;

@Component
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getMessage(String id) {
		final Locale locale = LocaleContextHolder.getLocale();		
		return messageSource.getMessage(id, null, locale);
	}
}