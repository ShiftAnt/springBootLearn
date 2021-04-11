package org.learn.springbootlearn.restservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Greeting {
	private final Long id;
	private final String content;
}
