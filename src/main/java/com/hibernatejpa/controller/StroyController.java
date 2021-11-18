package com.hibernatejpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hibernatejpa.entity.Story;
import com.hibernatejpa.errorhandling.RecordNotFoundException;

@Controller
@RequestMapping(value = "/story")
public class StroyController {
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public Story getBook(@RequestBody Story story) {

		if (StringUtils.isEmpty(story.getStoryName())) {
			throw new RecordNotFoundException("Story Name not found");
		}
		return story;
	}

}